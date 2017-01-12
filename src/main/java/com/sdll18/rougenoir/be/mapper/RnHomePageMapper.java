package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnHomePageSqlProvider;
import com.sdll18.rougenoir.be.model.RnHomePage;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RnHomePageMapper {
    @Delete({
            "delete from rn_home_page",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into rn_home_page (commodity_id, description, ",
            "title, cover, rn_index)",
            "values (#{commodityId,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, ",
            "#{title,jdbcType=VARCHAR}, #{cover,jdbcType=VARCHAR}, #{rnIndex,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(RnHomePage record);

    @InsertProvider(type = RnHomePageSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(RnHomePage record);

    @Select({
            "SELECT id, commodity_id, description, title, cover, rn_index " +
                    "FROM rn_home_page " +
                    "WHERE id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "rnHomePage_whole",
            value = {
                    @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
                    @Result(column = "commodity_id", property = "commodityId", jdbcType = JdbcType.INTEGER),
                    @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "cover", property = "cover", jdbcType = JdbcType.VARCHAR),
                    @Result(column = "rn_index", property = "rnIndex", jdbcType = JdbcType.INTEGER)
            })
    RnHomePage selectByPrimaryKey(Integer id);

    @Select({
            "SELECT id, commodity_id, description, title, cover, rn_index FROM rn_home_page ORDER BY rn_index ASC"
    })
    @ResultMap(value = "rnHomePage_whole")
    List<RnHomePage> selectAll();

    @UpdateProvider(type = RnHomePageSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnHomePage record);

    @Update({
            "update rn_home_page",
            "set commodity_id = #{commodityId,jdbcType=INTEGER},",
            "description = #{description,jdbcType=VARCHAR},",
            "title = #{title,jdbcType=VARCHAR},",
            "cover = #{cover,jdbcType=VARCHAR},",
            "rn_index = #{rnIndex,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnHomePage record);

}