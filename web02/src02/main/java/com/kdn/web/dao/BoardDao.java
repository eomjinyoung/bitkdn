package com.kdn.web.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kdn.web.vo.Board;

public class BoardDao {
  static SqlSessionFactory sqlSessionFactory;
  
  static {
    try {
      String resource = "com/kdn/web/dao/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void insert(Board board) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert("com.kdn.web.dao.BoardDao.insert", board);
      sqlSession.commit();
    } catch (Exception e) {
      throw e;
      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public List<Board> list() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("com.kdn.web.dao.BoardDao.list");
    } catch (Exception e) {
      throw e;
      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public Board detail(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne("com.kdn.web.dao.BoardDao.detail", no);
    } catch (Exception e) {
      throw e;
      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public void update(Board board) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert("com.kdn.web.dao.BoardDao.update", board);
      sqlSession.commit();
    } catch (Exception e) {
      throw e;
      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  public void delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert("com.kdn.web.dao.BoardDao.delete", no);
      sqlSession.commit();
    } catch (Exception e) {
      throw e;
      
    } finally {
      try {sqlSession.close();} catch (Exception e) {}
    }
  }
  
  
}
