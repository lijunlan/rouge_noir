package com.sdll18.rougenoir.be.mapper.provider;

import com.sdll18.rougenoir.be.model.RnComment;
import org.apache.ibatis.jdbc.SQL;

public class RnCommentSqlProvider {

    public String insertSelective(RnComment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rn_comment");
        
        if (record.getFromUserId() != null) {
            sql.VALUES("from_user_id", "#{fromUserId,jdbcType=INTEGER}");
        }
        
        if (record.getToOrderId() != null) {
            sql.VALUES("to_order_id", "#{toOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(RnComment record) {
        SQL sql = new SQL();
        sql.UPDATE("rn_comment");
        
        if (record.getFromUserId() != null) {
            sql.SET("from_user_id = #{fromUserId,jdbcType=INTEGER}");
        }
        
        if (record.getToOrderId() != null) {
            sql.SET("to_order_id = #{toOrderId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}