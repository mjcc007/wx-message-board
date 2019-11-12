/*
 * This file is generated by jOOQ.
 */
package com.mjcc.message_board.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;


/**
 * 惩罚类目表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PunishCategory implements Serializable {

    private static final long serialVersionUID = -1462895322;

    private Integer       categoryId;
    private String        categoryName;
    private LocalDateTime createTime;

    public PunishCategory() {}

    public PunishCategory(PunishCategory value) {
        this.categoryId = value.categoryId;
        this.categoryName = value.categoryName;
        this.createTime = value.createTime;
    }

    public PunishCategory(
        Integer       categoryId,
        String        categoryName,
        LocalDateTime createTime
    ) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createTime = createTime;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PunishCategory (");

        sb.append(categoryId);
        sb.append(", ").append(categoryName);
        sb.append(", ").append(createTime);

        sb.append(")");
        return sb.toString();
    }
}