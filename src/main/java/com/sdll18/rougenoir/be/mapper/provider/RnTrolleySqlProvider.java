package com.sdll18.rougenoir.be.mapper.provider;

import com.sdll18.rougenoir.be.model.RnTrolley;
import org.apache.ibatis.jdbc.SQL;

public class RnTrolleySqlProvider {

    public String insertSelective(RnTrolley record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rn_trolley");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getCommodityId() != null) {
            sql.VALUES("commodity_id", "#{commodityId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCount() != null) {
            sql.VALUES("count", "#{count,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RnTrolley record) {
        SQL sql = new SQL();
        sql.UPDATE("rn_trolley");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCount() != null) {
            sql.SET("count = #{count,jdbcType=INTEGER}");
        }
        
        sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        sql.WHERE("commodity_id = #{commodityId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}