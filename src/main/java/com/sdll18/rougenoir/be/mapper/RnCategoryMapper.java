package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnCategorySqlProvider;
import com.sdll18.rougenoir.be.model.RnCategory;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnCategoryMapper {
    @Delete({
            "delete from rn_category",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into rn_category (name, parent_id, ",
            "rn_index)",
            "values (#{name,jdbcType=VARCHAR}, #{parentId,jdbcType=INTEGER}, ",
            "#{rnIndex,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(RnCategory record);

    @InsertProvider(type = RnCategorySqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(RnCategory record);

    @Select({
            "select",
            "id, name, parent_id, rn_index",
            "from rn_category",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "parent_id", property = "parentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "rn_index", property = "rnIndex", jdbcType = JdbcType.INTEGER)
    })
    RnCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type = RnCategorySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnCategory record);

    @Update({
            "update rn_category",
            "set name = #{name,jdbcType=VARCHAR},",
            "parent_id = #{parentId,jdbcType=INTEGER},",
            "rn_index = #{rnIndex,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnCategory record);
}