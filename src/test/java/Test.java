import com.sdll18.rougenoir.be.mapper.RnAddressMapper;
import com.sdll18.rougenoir.be.mapper.RnHomePageMapper;
import com.sdll18.rougenoir.be.model.RnAddress;
import com.sdll18.rougenoir.be.model.RnHomePage;
import com.sdll18.rougenoir.be.starter.Application;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Copyright (C) 2015 - 2017 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2017-01-04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class Test {

    @Autowired
    private RnAddressMapper rnAddressMapper;

    @Autowired
    private RnHomePageMapper rnHomePageMapper;

    @org.junit.Test
    public void pr() {
        System.out.println("ssssssssssssssss");
    }

    @org.junit.Test
    public void test() {
//        RnAddress rnAddress = new RnAddress();
//        rnAddress.setAddress("testetse");
//        rnAddress.setName("ffffffffffff");
//        rnAddress.setPhone("111111111111111");
//        rnAddress.setUserId(1);
//        rnAddress.setStatus(true);
//        int id = rnAddressMapper.insert(rnAddress);
//        rnAddress = rnAddressMapper.selectByPrimaryKey(id);
        List<RnHomePage> list = rnHomePageMapper.selectAll();
        System.out.println(list.size());
    }
}
