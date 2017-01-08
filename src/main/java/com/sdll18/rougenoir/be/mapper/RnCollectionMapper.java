package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnCollectionSqlProvider;
import com.sdll18.rougenoir.be.model.RnCollection;
import com.sdll18.rougenoir.be.model.RnCollectionKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnCollectionMapper {
    @Delete({
        "delete from rn_collection",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(RnCollectionKey key);

    @Insert({
        "insert into rn_collection (user_id, commodity_id, ",
        "create_time)",
        "values (#{userId,jdbcType=INTEGER}, #{commodityId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RnCollection record);

    @InsertProvider(type=RnCollectionSqlProvider.class, method="insertSelective")
    int insertSelective(RnCollection record);

    @Select({
        "select",
        "user_id, commodity_id, create_time",
        "from rn_collection",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="commodity_id", property="commodityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RnCollection selectByPrimaryKey(RnCollectionKey key);

    @UpdateProvider(type=RnCollectionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnCollection record);

    @Update({
        "update rn_collection",
        "set create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnCollection record);
}