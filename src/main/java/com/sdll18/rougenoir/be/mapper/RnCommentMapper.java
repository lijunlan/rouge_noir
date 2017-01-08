package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnCommentSqlProvider;
import com.sdll18.rougenoir.be.model.RnComment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnCommentMapper {
    @Delete({
        "delete from rn_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rn_comment (from_user_id, to_order_id, ",
        "content, create_time, ",
        "status)",
        "values (#{fromUserId,jdbcType=INTEGER}, #{toOrderId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RnComment record);

    @InsertProvider(type=RnCommentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(RnComment record);

    @Select({
        "select",
        "id, from_user_id, to_order_id, content, create_time, status",
        "from rn_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="from_user_id", property="fromUserId", jdbcType=JdbcType.INTEGER),
        @Result(column="to_order_id", property="toOrderId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    RnComment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RnCommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnComment record);

    @Update({
        "update rn_comment",
        "set from_user_id = #{fromUserId,jdbcType=INTEGER},",
          "to_order_id = #{toOrderId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnComment record);
}