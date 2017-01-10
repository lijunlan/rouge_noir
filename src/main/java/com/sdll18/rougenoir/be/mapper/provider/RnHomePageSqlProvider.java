package com.sdll18.rougenoir.be.mapper.provider;

import com.sdll18.rougenoir.be.model.RnHomePage;
import org.apache.ibatis.jdbc.SQL;

public class RnHomePageSqlProvider {

    public String insertSelective(RnHomePage record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rn_home_page");
        
        if (record.getCommodityId() != null) {
            sql.VALUES("commodity_id", "#{commodityId,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCover() != null) {
            sql.VALUES("cover", "#{cover,jdbcType=VARCHAR}");
        }
        
        if (record.getRnIndex() != null) {
            sql.VALUES("rn_index", "#{rnIndex,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RnHomePage record) {
        SQL sql = new SQL();
        sql.UPDATE("rn_home_page");
        
        if (record.getCommodityId() != null) {
            sql.SET("commodity_id = #{commodityId,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getCover() != null) {
            sql.SET("cover = #{cover,jdbcType=VARCHAR}");
        }
        
        if (record.getRnIndex() != null) {
            sql.SET("rn_index = #{rnIndex,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}