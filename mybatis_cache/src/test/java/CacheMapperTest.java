import com.ztt.mybatis.mapper.CacheMapper;
import com.ztt.mybatis.pojo.Emp;
import com.ztt.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void testGetEmpById() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = session.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp);

        System.out.println(mapper.getEmpById(1));
        SqlSession session1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = session1.getMapper(CacheMapper.class);
        System.out.println(mapper1.getEmpById(1));
    }
    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        sqlSession2.close();
    }


}
