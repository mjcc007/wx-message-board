/*
 * This file is generated by jOOQ.
 */
package com.mjcc.message_board.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TWordAreaInfo implements Serializable {

    private static final long serialVersionUID = 780384955;

    private Integer       articleId;
    private String        openid;
    private String        articleTitle;
    private String        articleUrl;
    private String        articleImg;
    private String        publicname;
    private String        description;
    private LocalDateTime createTime;

    public TWordAreaInfo() {}

    public TWordAreaInfo(TWordAreaInfo value) {
        this.articleId = value.articleId;
        this.openid = value.openid;
        this.articleTitle = value.articleTitle;
        this.articleUrl = value.articleUrl;
        this.articleImg = value.articleImg;
        this.publicname = value.publicname;
        this.description = value.description;
        this.createTime = value.createTime;
    }

    public TWordAreaInfo(
        Integer       articleId,
        String        openid,
        String        articleTitle,
        String        articleUrl,
        String        articleImg,
        String        publicname,
        String        description,
        LocalDateTime createTime
    ) {
        this.articleId = articleId;
        this.openid = openid;
        this.articleTitle = articleTitle;
        this.articleUrl = articleUrl;
        this.articleImg = articleImg;
        this.publicname = publicname;
        this.description = description;
        this.createTime = createTime;
    }

    public Integer getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getOpenid() {
        return this.openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getArticleTitle() {
        return this.articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleUrl() {
        return this.articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getArticleImg() {
        return this.articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }

    public String getPublicname() {
        return this.publicname;
    }

    public void setPublicname(String publicname) {
        this.publicname = publicname;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TWordAreaInfo (");

        sb.append(articleId);
        sb.append(", ").append(openid);
        sb.append(", ").append(articleTitle);
        sb.append(", ").append(articleUrl);
        sb.append(", ").append(articleImg);
        sb.append(", ").append(publicname);
        sb.append(", ").append(description);
        sb.append(", ").append(createTime);

        sb.append(")");
        return sb.toString();
    }
}
