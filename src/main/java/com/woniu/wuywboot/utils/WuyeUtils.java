package com.woniu.wuywboot.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 老谭（<a href="http://www.woniuxy.com">蜗牛学苑</a>）
 */
public class WuyeUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    private static ThreadLocal<SqlSession> conns = new ThreadLocal<>();

    public static SqlSession getSession() {
        SqlSession sqlSession = conns.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            conns.set(sqlSession);
        }
        return sqlSession;
    }

    public static <T> T getMapper(Class<T> c) {
        return getSession().getMapper(c);
    }

    public static void commit(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }
}
