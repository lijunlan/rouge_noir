package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnAddressSqlProvider;
import com.sdll18.rougenoir.be.model.RnAddress;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnAddressMapper {
    @Delete({
            "delete from rn_address",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into rn_address (user_id, address, ",
            "phone, name, status)",
            "values (#{userId,jdbcType=INTEGER}, #{address,jdbcType=VARCHAR}, ",
            "#{phone,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{status,jdbcType=BIT})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(RnAddress record);

    @InsertProvider(type = RnAddressSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(RnAddress record);

    @Select({
            "select",
            "id, user_id, address, phone, name, status",
            "from rn_address",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT)
    })
    RnAddress selectByPrimaryKey(Integer id);

    @UpdateProvider(type = RnAddressSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnAddress record);

    @Update({
            "update rn_address",
            "set user_id = #{userId,jdbcType=INTEGER},",
            "address = #{address,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=VARCHAR},",
            "name = #{name,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=BIT}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnAddress record);
}