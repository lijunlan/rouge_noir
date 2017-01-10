package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnRecommendSqlProvider;
import com.sdll18.rougenoir.be.model.RnRecommend;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnRecommendMapper {
    @Delete({
            "delete from rn_recommend",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into rn_recommend (commodity_id, rn_index, ",
            "create_time, update_time)",
            "values (#{commodityId,jdbcType=INTEGER}, #{rnIndex,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(RnRecommend record);

    @InsertProvider(type = RnRecommendSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(RnRecommend record);

    @Select({
            "select",
            "id, commodity_id, rn_index, create_time, update_time",
            "from rn_recommend",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "commodity_id", property = "commodityId", jdbcType = JdbcType.INTEGER),
            @Result(column = "rn_index", property = "rnIndex", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    RnRecommend selectByPrimaryKey(Integer id);

    @UpdateProvider(type = RnRecommendSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnRecommend record);

    @Update({
            "update rn_recommend",
            "set commodity_id = #{commodityId,jdbcType=INTEGER},",
            "rn_index = #{rnIndex,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnRecommend record);
}