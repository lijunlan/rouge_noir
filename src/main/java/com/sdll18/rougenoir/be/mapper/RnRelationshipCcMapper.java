package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnRelationshipCcSqlProvider;
import com.sdll18.rougenoir.be.model.RnRelationshipCc;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnRelationshipCcMapper {
    @Delete({
            "delete from rn_relationship_cc",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into rn_relationship_cc (commodity_id, category_id, ",
            "create_time)",
            "values (#{commodityId,jdbcType=INTEGER}, #{categoryId,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(RnRelationshipCc record);

    @InsertProvider(type = RnRelationshipCcSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(RnRelationshipCc record);

    @Select({
            "select",
            "id, commodity_id, category_id, create_time",
            "from rn_relationship_cc",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "commodity_id", property = "commodityId", jdbcType = JdbcType.INTEGER),
            @Result(column = "category_id", property = "categoryId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP)
    })
    RnRelationshipCc selectByPrimaryKey(Integer id);

    @UpdateProvider(type = RnRelationshipCcSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnRelationshipCc record);

    @Update({
            "update rn_relationship_cc",
            "set commodity_id = #{commodityId,jdbcType=INTEGER},",
            "category_id = #{categoryId,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnRelationshipCc record);
}