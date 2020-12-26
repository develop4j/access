package com.levy.access.model;

import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_config")
public class SysConfigDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    private String label;

    private String type;

    private String description;

    private Long sort;

    private Long creatorId;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private String remarks;

    @LogicDelete
    private Byte delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "SysConfigDO{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", sort=" + sort +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", remarks='" + remarks + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}