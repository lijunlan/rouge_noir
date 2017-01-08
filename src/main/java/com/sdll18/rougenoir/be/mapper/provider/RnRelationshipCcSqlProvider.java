package com.sdll18.rougenoir.be.mapper.provider;

import com.sdll18.rougenoir.be.model.RnRelationshipCc;
import org.apache.ibatis.jdbc.SQL;

public class RnRelationshipCcSqlProvider {

    public String insertSelective(RnRelationshipCc record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rn_relationship_cc");
        
        if (record.getCommodityId() != null) {
            sql.VALUES("commodity_id", "#{commodityId,jdbcType=INTEGER}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }
}