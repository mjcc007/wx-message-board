/*
 * This file is generated by jOOQ.
 */
package com.mjcc.message_board.jooq.tables;


import com.mjcc.message_board.jooq.Indexes;
import com.mjcc.message_board.jooq.Keys;
import com.mjcc.message_board.jooq.Public;
import com.mjcc.message_board.jooq.tables.records.TWordsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class TWords extends TableImpl<TWordsRecord> {

    private static final long serialVersionUID = 383252616;

    /**
     * The reference instance of <code>public.t_words</code>
     */
    public static final TWords T_WORDS = new TWords();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TWordsRecord> getRecordType() {
        return TWordsRecord.class;
    }

    /**
     * The column <code>public.t_words.lw_id</code>. 评论id编号
     */
    public final TableField<TWordsRecord, Integer> LW_ID = createField("lw_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('t_words_lw_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "评论id编号");

    /**
     * The column <code>public.t_words.lw_openid</code>. 评论人的openid
     */
    public final TableField<TWordsRecord, String> LW_OPENID = createField("lw_openid", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "评论人的openid");

    /**
     * The column <code>public.t_words.lw_name</code>. 评论人的的名字
     */
    public final TableField<TWordsRecord, String> LW_NAME = createField("lw_name", org.jooq.impl.SQLDataType.VARCHAR(128).nullable(false), this, "评论人的的名字");

    /**
     * The column <code>public.t_words.lw_head_imgurl</code>. 评论用户的头像
     */
    public final TableField<TWordsRecord, String> LW_HEAD_IMGURL = createField("lw_head_imgurl", org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "评论用户的头像");

    /**
     * The column <code>public.t_words.lw_content</code>. 评论内容
     */
    public final TableField<TWordsRecord, String> LW_CONTENT = createField("lw_content", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "评论内容");

    /**
     * The column <code>public.t_words.lw_for_topic_id</code>. 那个主题留言
     */
    public final TableField<TWordsRecord, Integer> LW_FOR_TOPIC_ID = createField("lw_for_topic_id", org.jooq.impl.SQLDataType.INTEGER, this, "那个主题留言");

    /**
     * The column <code>public.t_words.lw_select</code>. 是否是精选留言
     */
    public final TableField<TWordsRecord, Short> LW_SELECT = createField("lw_select", org.jooq.impl.SQLDataType.SMALLINT.defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.SMALLINT)), this, "是否是精选留言");

    /**
     * The column <code>public.t_words.lw_zan</code>. 被赞数
     */
    public final TableField<TWordsRecord, Integer> LW_ZAN = createField("lw_zan", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "被赞数");

    /**
     * The column <code>public.t_words.lw_cai</code>. 被踩数
     */
    public final TableField<TWordsRecord, Integer> LW_CAI = createField("lw_cai", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "被踩数");

    /**
     * The column <code>public.t_words.lw_date</code>. 创建时间
     */
    public final TableField<TWordsRecord, LocalDateTime> LW_DATE = createField("lw_date", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * Create a <code>public.t_words</code> table reference
     */
    public TWords() {
        this(DSL.name("t_words"), null);
    }

    /**
     * Create an aliased <code>public.t_words</code> table reference
     */
    public TWords(String alias) {
        this(DSL.name(alias), T_WORDS);
    }

    /**
     * Create an aliased <code>public.t_words</code> table reference
     */
    public TWords(Name alias) {
        this(alias, T_WORDS);
    }

    private TWords(Name alias, Table<TWordsRecord> aliased) {
        this(alias, aliased, null);
    }

    private TWords(Name alias, Table<TWordsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TWords(Table<O> child, ForeignKey<O, TWordsRecord> key) {
        super(child, key, T_WORDS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.T_WORDS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TWordsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_T_WORDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TWordsRecord> getPrimaryKey() {
        return Keys.T_WORDS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TWordsRecord>> getKeys() {
        return Arrays.<UniqueKey<TWordsRecord>>asList(Keys.T_WORDS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWords as(String alias) {
        return new TWords(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TWords as(Name alias) {
        return new TWords(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TWords rename(String name) {
        return new TWords(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TWords rename(Name name) {
        return new TWords(name, null);
    }
}
