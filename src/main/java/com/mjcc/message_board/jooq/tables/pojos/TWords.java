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
public class TWords implements Serializable {

    private static final long serialVersionUID = 26542997;

    private Integer       lwId;
    private String        lwOpenid;
    private String        lwName;
    private String        lwHeadImgurl;
    private String        lwContent;
    private Integer       lwForTopicId;
    private Short         lwSelect;
    private Integer       lwZan;
    private Integer       lwCai;
    private LocalDateTime lwDate;

    public TWords() {}

    public TWords(TWords value) {
        this.lwId = value.lwId;
        this.lwOpenid = value.lwOpenid;
        this.lwName = value.lwName;
        this.lwHeadImgurl = value.lwHeadImgurl;
        this.lwContent = value.lwContent;
        this.lwForTopicId = value.lwForTopicId;
        this.lwSelect = value.lwSelect;
        this.lwZan = value.lwZan;
        this.lwCai = value.lwCai;
        this.lwDate = value.lwDate;
    }

    public TWords(
        Integer       lwId,
        String        lwOpenid,
        String        lwName,
        String        lwHeadImgurl,
        String        lwContent,
        Integer       lwForTopicId,
        Short         lwSelect,
        Integer       lwZan,
        Integer       lwCai,
        LocalDateTime lwDate
    ) {
        this.lwId = lwId;
        this.lwOpenid = lwOpenid;
        this.lwName = lwName;
        this.lwHeadImgurl = lwHeadImgurl;
        this.lwContent = lwContent;
        this.lwForTopicId = lwForTopicId;
        this.lwSelect = lwSelect;
        this.lwZan = lwZan;
        this.lwCai = lwCai;
        this.lwDate = lwDate;
    }

    public Integer getLwId() {
        return this.lwId;
    }

    public void setLwId(Integer lwId) {
        this.lwId = lwId;
    }

    public String getLwOpenid() {
        return this.lwOpenid;
    }

    public void setLwOpenid(String lwOpenid) {
        this.lwOpenid = lwOpenid;
    }

    public String getLwName() {
        return this.lwName;
    }

    public void setLwName(String lwName) {
        this.lwName = lwName;
    }

    public String getLwHeadImgurl() {
        return this.lwHeadImgurl;
    }

    public void setLwHeadImgurl(String lwHeadImgurl) {
        this.lwHeadImgurl = lwHeadImgurl;
    }

    public String getLwContent() {
        return this.lwContent;
    }

    public void setLwContent(String lwContent) {
        this.lwContent = lwContent;
    }

    public Integer getLwForTopicId() {
        return this.lwForTopicId;
    }

    public void setLwForTopicId(Integer lwForTopicId) {
        this.lwForTopicId = lwForTopicId;
    }

    public Short getLwSelect() {
        return this.lwSelect;
    }

    public void setLwSelect(Short lwSelect) {
        this.lwSelect = lwSelect;
    }

    public Integer getLwZan() {
        return this.lwZan;
    }

    public void setLwZan(Integer lwZan) {
        this.lwZan = lwZan;
    }

    public Integer getLwCai() {
        return this.lwCai;
    }

    public void setLwCai(Integer lwCai) {
        this.lwCai = lwCai;
    }

    public LocalDateTime getLwDate() {
        return this.lwDate;
    }

    public void setLwDate(LocalDateTime lwDate) {
        this.lwDate = lwDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TWords (");

        sb.append(lwId);
        sb.append(", ").append(lwOpenid);
        sb.append(", ").append(lwName);
        sb.append(", ").append(lwHeadImgurl);
        sb.append(", ").append(lwContent);
        sb.append(", ").append(lwForTopicId);
        sb.append(", ").append(lwSelect);
        sb.append(", ").append(lwZan);
        sb.append(", ").append(lwCai);
        sb.append(", ").append(lwDate);

        sb.append(")");
        return sb.toString();
    }
}