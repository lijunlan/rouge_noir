package com.sdll18.rougenoir.be.mapper.provider;

import com.sdll18.rougenoir.be.model.RnCollection;
import org.apache.ibatis.jdbc.SQL;

public class RnCollectionSqlProvider {

    public String insertSelective(RnCollection record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rn_collection");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getCommodityId() != null) {
            sql.VALUES("commodity_id", "#{commodityId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RnCollection record) {
        SQL sql = new SQL();
        sql.UPDATE("rn_collection");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        sql.WHERE("commodity_id = #{commodityId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}