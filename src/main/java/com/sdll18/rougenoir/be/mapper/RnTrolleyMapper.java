package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnTrolleySqlProvider;
import com.sdll18.rougenoir.be.model.RnTrolley;
import com.sdll18.rougenoir.be.model.RnTrolleyKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnTrolleyMapper {
    @Delete({
            "delete from rn_trolley",
            "where user_id = #{userId,jdbcType=INTEGER}",
            "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(RnTrolleyKey key);

    @Insert({
            "insert into rn_trolley (user_id, commodity_id, ",
            "create_time, count)",
            "values (#{userId,jdbcType=INTEGER}, #{commodityId,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{count,jdbcType=INTEGER})"
    })
    int insert(RnTrolley record);

    @InsertProvider(type = RnTrolleySqlProvider.class, method = "insertSelective")
    int insertSelective(RnTrolley record);

    @Select({
            "select",
            "user_id, commodity_id, create_time, count",
            "from rn_trolley",
            "where user_id = #{userId,jdbcType=INTEGER}",
            "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "commodity_id", property = "commodityId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "count", property = "count", jdbcType = JdbcType.INTEGER)
    })
    RnTrolley selectByPrimaryKey(RnTrolleyKey key);

    @UpdateProvider(type = RnTrolleySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnTrolley record);

    @Update({
            "update rn_trolley",
            "set create_time = #{createTime,jdbcType=TIMESTAMP},",
            "count = #{count,jdbcType=INTEGER}",
            "where user_id = #{userId,jdbcType=INTEGER}",
            "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnTrolley record);
}