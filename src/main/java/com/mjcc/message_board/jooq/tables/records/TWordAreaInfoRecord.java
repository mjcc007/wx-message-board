/*
 * This file is generated by jOOQ.
 */
package com.mjcc.message_board.jooq.tables.records;


import com.mjcc.message_board.jooq.tables.TWordAreaInfo;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


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
public class TWordAreaInfoRecord extends UpdatableRecordImpl<TWordAreaInfoRecord> implements Record8<Integer, String, String, String, String, String, String, LocalDateTime> {

    private static final long serialVersionUID = -2076636966;

    /**
     * Setter for <code>public.t_word_area_info.article_id</code>. id
     */
    public void setArticleId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.t_word_area_info.article_id</code>. id
     */
    public Integer getArticleId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.t_word_area_info.openid</code>. 用户openid
     */
    public void setOpenid(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.t_word_area_info.openid</code>. 用户openid
     */
    public String getOpenid() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.t_word_area_info.article_title</code>. 文章标题
     */
    public void setArticleTitle(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.t_word_area_info.article_title</code>. 文章标题
     */
    public String getArticleTitle() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.t_word_area_info.article_url</code>. 文章链接
     */
    public void setArticleUrl(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.t_word_area_info.article_url</code>. 文章链接
     */
    public String getArticleUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.t_word_area_info.article_img</code>. 文章图片
     */
    public void setArticleImg(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.t_word_area_info.article_img</code>. 文章图片
     */
    public String getArticleImg() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.t_word_area_info.publicname</code>. 公众号名称
     */
    public void setPublicname(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.t_word_area_info.publicname</code>. 公众号名称
     */
    public String getPublicname() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.t_word_area_info.description</code>. 描述
     */
    public void setDescription(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.t_word_area_info.description</code>. 描述
     */
    public String getDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.t_word_area_info.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.t_word_area_info.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, String, String, String, String, String, String, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, String, String, String, String, String, String, LocalDateTime> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return TWordAreaInfo.T_WORD_AREA_INFO.ARTICLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TWordAreaInfo.T_WORD_AREA_INFO.OPENID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TWordAreaInfo.T_WORD_AREA_INFO.ARTICLE_TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TWordAreaInfo.T_WORD_AREA_INFO.ARTICLE_URL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TWordAreaInfo.T_WORD_AREA_INFO.ARTICLE_IMG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TWordAreaInfo.T_WORD_AREA_INFO.PUBLICNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return TWordAreaInfo.T_WORD_AREA_INFO.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field8() {
        return TWordAreaInfo.T_WORD_AREA_INFO.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getArticleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getOpenid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getArticleTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getArticleUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getArticleImg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getPublicname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component8() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getArticleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getOpenid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getArticleTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getArticleUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getArticleImg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPublicname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value8() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord value1(Integer value) {
        setArticleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord value2(String value) {
        setOpenid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord value3(String value) {
        setArticleTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord value4(String value) {
        setArticleUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord value5(String value) {
        setArticleImg(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord value6(String value) {
        setPublicname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord value7(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord value8(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWordAreaInfoRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7, LocalDateTime value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TWordAreaInfoRecord
     */
    public TWordAreaInfoRecord() {
        super(TWordAreaInfo.T_WORD_AREA_INFO);
    }

    /**
     * Create a detached, initialised TWordAreaInfoRecord
     */
    public TWordAreaInfoRecord(Integer articleId, String openid, String articleTitle, String articleUrl, String articleImg, String publicname, String description, LocalDateTime createTime) {
        super(TWordAreaInfo.T_WORD_AREA_INFO);

        set(0, articleId);
        set(1, openid);
        set(2, articleTitle);
        set(3, articleUrl);
        set(4, articleImg);
        set(5, publicname);
        set(6, description);
        set(7, createTime);
    }
}
