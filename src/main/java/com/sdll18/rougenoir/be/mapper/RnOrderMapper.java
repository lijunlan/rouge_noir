package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnOrderSqlProvider;
import com.sdll18.rougenoir.be.model.RnOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface RnOrderMapper {
    @Delete({
            "delete from rn_order",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into rn_order (code, user_id, ",
            "status, create_time, ",
            "update_time, pay_time, ",
            "commodity_ids, total_money, ",
            "detail, address_id)",
            "values (#{code,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER}, ",
            "#{status,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{payTime,jdbcType=TIMESTAMP}, ",
            "#{commodityIds,jdbcType=VARCHAR}, #{totalMoney,jdbcType=INTEGER}, ",
            "#{detail,jdbcType=VARCHAR}, #{addressId,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(RnOrder record);

    @InsertProvider(type = RnOrderSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(RnOrder record);

    @Select({
            "select",
            "id, code, user_id, status, create_time, update_time, pay_time, commodity_ids, ",
            "total_money, detail, address_id",
            "from rn_order",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "pay_time", property = "payTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "commodity_ids", property = "commodityIds", jdbcType = JdbcType.VARCHAR),
            @Result(column = "total_money", property = "totalMoney", jdbcType = JdbcType.INTEGER),
            @Result(column = "detail", property = "detail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER)
    })
    RnOrder selectByPrimaryKey(Integer id);

    @UpdateProvider(type = RnOrderSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RnOrder record);

    @Update({
            "update rn_order",
            "set code = #{code,jdbcType=VARCHAR},",
            "user_id = #{userId,jdbcType=INTEGER},",
            "status = #{status,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "pay_time = #{payTime,jdbcType=TIMESTAMP},",
            "commodity_ids = #{commodityIds,jdbcType=VARCHAR},",
            "total_money = #{totalMoney,jdbcType=INTEGER},",
            "detail = #{detail,jdbcType=VARCHAR},",
            "address_id = #{addressId,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RnOrder record);
}