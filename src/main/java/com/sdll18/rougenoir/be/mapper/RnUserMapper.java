package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnUserSqlProvider;
import com.sdll18.rougenoir.be.model.RnUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnUserMapper {
    @Delete({
            "delete from rn_user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into rn_user (email, password, ",
            "name, icon, create_time, ",
            "update_time, status)",
            "values (#{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{name,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(RnUser record);

    @InsertProvider(type = RnUserSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(RnUser record);

    @Select({
            "select",
            "id, email, password, name, icon, create_time, update_time, status",
            "from rn_user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "icon", property = "icon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER)
    })
    RnUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type = RnUserSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnUser record);

    @Update({
            "update rn_user",
            "set email = #{email,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "name = #{name,jdbcType=VARCHAR},",
            "icon = #{icon,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "status = #{status,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnUser record);
}