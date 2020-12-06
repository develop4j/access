package com.levy.access.model;

import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_menu")
public class SysMenuDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.name
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.parent_id
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.url
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.perms
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private String perms;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.type
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.icon
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private String icon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.order_num
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private Integer orderNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.create_by
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.create_time
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.last_update_by
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private String lastUpdateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.last_update_time
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.del_flag
     *
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    @LogicDelete
    private Byte delFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.id
     *
     * @return the value of sys_menu.id
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.id
     *
     * @param id the value for sys_menu.id
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.name
     *
     * @return the value of sys_menu.name
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.name
     *
     * @param name the value for sys_menu.name
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.parent_id
     *
     * @return the value of sys_menu.parent_id
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.parent_id
     *
     * @param parentId the value for sys_menu.parent_id
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.url
     *
     * @return the value of sys_menu.url
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.url
     *
     * @param url the value for sys_menu.url
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.perms
     *
     * @return the value of sys_menu.perms
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public String getPerms() {
        return perms;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.perms
     *
     * @param perms the value for sys_menu.perms
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.type
     *
     * @return the value of sys_menu.type
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.type
     *
     * @param type the value for sys_menu.type
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.icon
     *
     * @return the value of sys_menu.icon
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.icon
     *
     * @param icon the value for sys_menu.icon
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.order_num
     *
     * @return the value of sys_menu.order_num
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.order_num
     *
     * @param orderNum the value for sys_menu.order_num
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.create_by
     *
     * @return the value of sys_menu.create_by
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.create_by
     *
     * @param createBy the value for sys_menu.create_by
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.create_time
     *
     * @return the value of sys_menu.create_time
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.create_time
     *
     * @param createTime the value for sys_menu.create_time
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.last_update_by
     *
     * @return the value of sys_menu.last_update_by
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.last_update_by
     *
     * @param lastUpdateBy the value for sys_menu.last_update_by
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.last_update_time
     *
     * @return the value of sys_menu.last_update_time
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.last_update_time
     *
     * @param lastUpdateTime the value for sys_menu.last_update_time
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.del_flag
     *
     * @return the value of sys_menu.del_flag
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.del_flag
     *
     * @param delFlag the value for sys_menu.del_flag
     * @mbggenerated Thu Jan 16 20:41:11 CST 2020
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}