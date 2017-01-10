package com.sdll18.rougenoir.be.mapper.provider;

import com.sdll18.rougenoir.be.model.RnCategory;
import org.apache.ibatis.jdbc.SQL;

public class RnCategorySqlProvider {

    public String insertSelective(RnCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rn_category");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getRnIndex() != null) {
            sql.VALUES("rn_index", "#{rnIndex,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RnCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("rn_category");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getRnIndex() != null) {
            sql.SET("rn_index = #{rnIndex,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}