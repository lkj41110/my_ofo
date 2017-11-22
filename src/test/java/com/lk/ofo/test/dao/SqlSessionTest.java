package com.lk.ofo.test.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luokai
 * @date 2017/11/22
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml"})
public class SqlSessionTest {
    @Autowired
    private SqlSession sqlSession;

    @Test
    public void selectTest() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("sql", "select * from _user where id=1000");

        System.out.println(sqlSession.selectOne("com.lk.ofo.dao.UserDao.sql", params));
    }
}
