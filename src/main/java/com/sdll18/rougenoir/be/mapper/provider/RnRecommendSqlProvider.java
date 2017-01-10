package com.sdll18.rougenoir.be.mapper.provider;

import com.sdll18.rougenoir.be.model.RnRecommend;
import org.apache.ibatis.jdbc.SQL;

public class RnRecommendSqlProvider {

    public String insertSelective(RnRecommend record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rn_recommend");
        
        if (record.getCommodityId() != null) {
            sql.VALUES("commodity_id", "#{commodityId,jdbcType=INTEGER}");
        }
        
        if (record.getRnIndex() != null) {
            sql.VALUES("rn_index", "#{rnIndex,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RnRecommend record) {
        SQL sql = new SQL();
        sql.UPDATE("rn_recommend");
        
        if (record.getCommodityId() != null) {
            sql.SET("commodity_id = #{commodityId,jdbcType=INTEGER}");
        }
        
        if (record.getRnIndex() != null) {
            sql.SET("rn_index = #{rnIndex,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}