package com.levy.access.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author levy
 * @date 2020/12/3
 */
@RestController
@RequestMapping("/login")
public class SysLoginController {

    @Autowired
    private Producer producer;

    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store,no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存验证码到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        //返回验证码
        ServletOutputStream stream = response.getOutputStream();
        ImageIO.write(image, "jpg", stream);
        IOUtils.closeQuietly(stream);

    }

}
