package com.liwei;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liwei.utils.ElasticsearchUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApplicationTests {

    @Test
    public void contextLoads() {
        ElasticsearchUtil.createIndex("ceshi");
    }
    @Test
    public void deleteIndex() {
        ElasticsearchUtil.deleteIndex("population");
    }
    @Test
    public void sava() {
        Map<String,Object> json = new HashMap<String,Object>();
        json.put("user","liwei2");
        json.put("age","20");
        json.put("update",new Date());
        String s = JSON.toJSONString(json);
        JSONObject jsonObject = JSONObject.parseObject(s);
        ElasticsearchUtil.addData(jsonObject,"test","one","5");
    }
    @Test
    public void deleteDataById() {

        ElasticsearchUtil.deleteDataById( "test","one","2");


    }

}
