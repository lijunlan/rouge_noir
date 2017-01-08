package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnBrowseHistorySqlProvider;
import com.sdll18.rougenoir.be.model.RnBrowseHistory;
import com.sdll18.rougenoir.be.model.RnBrowseHistoryKey;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnBrowseHistoryMapper {
    @Delete({
        "delete from rn_browse_history",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(RnBrowseHistoryKey key);

    @Insert({
        "insert into rn_browse_history (user_id, commodity_id, ",
        "create_time)",
        "values (#{userId,jdbcType=INTEGER}, #{commodityId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(RnBrowseHistory record);

    @InsertProvider(type=RnBrowseHistorySqlProvider.class, method="insertSelective")
    int insertSelective(RnBrowseHistory record);

    @Select({
        "select",
        "user_id, commodity_id, create_time",
        "from rn_browse_history",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="commodity_id", property="commodityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    RnBrowseHistory selectByPrimaryKey(RnBrowseHistoryKey key);

    @UpdateProvider(type=RnBrowseHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnBrowseHistory record);

    @Update({
        "update rn_browse_history",
        "set create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and commodity_id = #{commodityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnBrowseHistory record);
}