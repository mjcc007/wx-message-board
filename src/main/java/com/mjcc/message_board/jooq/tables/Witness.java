/*
 * This file is generated by jOOQ.
 */
package com.mjcc.message_board.jooq.tables;


import com.mjcc.message_board.jooq.Indexes;
import com.mjcc.message_board.jooq.Keys;
import com.mjcc.message_board.jooq.Public;
import com.mjcc.message_board.jooq.tables.records.WitnessRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
 * 分享关联表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Witness extends TableImpl<WitnessRecord> {

    private static final long serialVersionUID = 1354556478;

    /**
     * The reference instance of <code>public.witness</code>
     */
    public static final Witness WITNESS = new Witness();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WitnessRecord> getRecordType() {
        return WitnessRecord.class;
    }

    /**
     * The column <code>public.witness.share_openid</code>. 分享者的openid
     */
    public final TableField<WitnessRecord, String> SHARE_OPENID = createField("share_openid", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "分享者的openid");

    /**
     * The column <code>public.witness.witness_openid</code>. 见证者的openid
     */
    public final TableField<WitnessRecord, String> WITNESS_OPENID = createField("witness_openid", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "见证者的openid");

    /**
     * The column <code>public.witness.category_id</code>. 惩罚的id
     */
    public final TableField<WitnessRecord, Integer> CATEGORY_ID = createField("category_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "惩罚的id");

    /**
     * The column <code>public.witness.create_time</code>. 创建时间
     */
    public final TableField<WitnessRecord, LocalDateTime> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * Create a <code>public.witness</code> table reference
     */
    public Witness() {
        this(DSL.name("witness"), null);
    }

    /**
     * Create an aliased <code>public.witness</code> table reference
     */
    public Witness(String alias) {
        this(DSL.name(alias), WITNESS);
    }

    /**
     * Create an aliased <code>public.witness</code> table reference
     */
    public Witness(Name alias) {
        this(alias, WITNESS);
    }

    private Witness(Name alias, Table<WitnessRecord> aliased) {
        this(alias, aliased, null);
    }

    private Witness(Name alias, Table<WitnessRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("分享关联表"));
    }

    public <O extends Record> Witness(Table<O> child, ForeignKey<O, WitnessRecord> key) {
        super(child, key, WITNESS);
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
        return Arrays.<Index>asList(Indexes.WITNESS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<WitnessRecord> getPrimaryKey() {
        return Keys.WITNESS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<WitnessRecord>> getKeys() {
        return Arrays.<UniqueKey<WitnessRecord>>asList(Keys.WITNESS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Witness as(String alias) {
        return new Witness(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Witness as(Name alias) {
        return new Witness(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Witness rename(String name) {
        return new Witness(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Witness rename(Name name) {
        return new Witness(name, null);
    }
}