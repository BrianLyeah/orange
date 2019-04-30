import cn.itcast.dao.IAccountDao;
import cn.itcast.dao.IUserDao;
import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class testDemo01 {


    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        //userDao = sqlSession.getMapper(IUserDao.class);//USER一对多时查询
        userDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    //USER一对多时查询
   /* @Test
    public void findAll(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println("------------------user的账户信息---------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }*/

    @Test
    public void findAll(){
        List<Account> all = userDao.findAll();
        for (Account user : all) {
            System.out.println("------------------user的账户信息---------------");
            System.out.println(user);
            System.out.println(user.getUser());
        }

    }

}
