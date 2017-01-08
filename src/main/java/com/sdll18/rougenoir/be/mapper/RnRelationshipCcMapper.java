package com.sdll18.rougenoir.be.mapper;

import com.sdll18.rougenoir.be.mapper.provider.RnRelationshipCcSqlProvider;
import com.sdll18.rougenoir.be.model.RnRelationshipCc;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;

public interface RnRelationshipCcMapper {
    @Insert({
        "insert into rn_relationship_cc (commodity_id, category_id, ",
        "create_time)",
        "values (#{commodityId,jdbcType=INTEGER}, #{categoryId,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RnRelationshipCc record);

    @InsertProvider(type=RnRelationshipCcSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(RnRelationshipCc record);
}