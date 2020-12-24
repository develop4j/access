package com.levy.access.service.impl;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.levy.access.constants.enums.ResultEnum;
import com.levy.access.exception.AccessException;
import com.levy.access.helper.SysUserHelper;
import com.levy.access.model.SysUserDO;
import com.levy.access.service.SysLoginService;
import com.levy.access.utils.TokenUtils;
import com.levy.access.vo.LoginBean;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author levy
 * @date 2020/12/4
 */

@Service
public class SysLoginServiceImpl implements SysLoginService {
    Logger logger = LoggerFactory.getLogger(SysLoginServiceImpl.class);


    @Autowired
    private Producer producer;

    @Autowired
    private SysUserHelper sysUserHelper;

    @Override
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store,no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        logger.info("===============登录验证码：" + text + "========");
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存验证码到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        logger.info("===============SESSION ID：" + request.getSession().getId() + "========");
        //返回验证码
        ServletOutputStream stream = response.getOutputStream();
        ImageIO.write(image, "jpg", stream);
        IOUtils.closeQuietly(stream);
    }

    @Override
    public String login(LoginBean loginBean, HttpServletRequest request, HttpServletResponse response) {
        String kaptcha = loginBean.getCaptcha();
        // 获取验证码
        String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        logger.info("登录获取到的验证码：" + kaptcha);
        logger.info("Session ID：" + request.getSession().getId());
        logger.info("Session中获取到的验证码：" + captcha);
        if (captcha == null) {
            throw new AccessException(ResultEnum.CAPTCHA_INVALID);
        }
        // 验证码不正确
        if (loginBean.getCaptcha() == null || !loginBean.getCaptcha().equals(captcha)) {
            throw new AccessException(ResultEnum.CAPTCHA_ERROR);
        }
        // 用户名是否存在
        SysUserDO user = sysUserHelper.getUserByNameOrPassword(loginBean);
        if (user == null) {
            throw new AccessException(ResultEnum.USERNAME_OR_PASSWORD_INCORRECT);
        }
        // 将当前用户的信息加密
        String des = TokenUtils.encryptDes(user.getSalt(), user.getName() + "-" + user.getPassword());
        // 将用户名存入session中
        request.getSession().setAttribute("token", des);
        // 存入cookies
        Cookie cookie = new Cookie("token", des);
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        request.setAttribute("token", des);
        response.addCookie(cookie);
        return user.getName();
    }
}
