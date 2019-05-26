import com.myblog.SpringBootStartApplication;
import com.myblog.pojo.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootStartApplication.class})//指定启动类
//@SpringBootTest(classes = SpringBootStartApplication.class) 老版本
@Transactional
public class test {

//    @Autowired
//    private UserMapper userMapper;
    @Autowired
    RedisConnectionFactory factory;


    @Autowired
    RedisTemplate<String, Object> template;//bean在configuration标签的类

    @Autowired
    StringRedisTemplate stringTemplate;

    @Test
    public void ApplicationTests(){
//        String email = userMapper.checkIsExsitEmail("331037760@qq.com");
//        System.out.println(email);
    }

    @Test
    public void testRedis(){
            //得到一个连接
        RedisConnection conn = factory.getConnection();
        conn.set("hello".getBytes(),"world".getBytes());
        System.out.println("===========================");
        System.out.println(new String(conn.get("hello".getBytes())));
        System.out.println("===========================");
    }





    @Test
    public void testRedisTemplate(){
        System.out.println("===========================");
        template.opsForValue().set("key1", "value1");
        System.out.println(template.opsForValue().get("key1"));
        System.out.println("===========================");
    }

    @Test
    public void testStringRedisTemplate(){
        System.out.println("===========================");
        stringTemplate.opsForValue().set("key1", "value1");
        System.out.println(stringTemplate.opsForValue().get("key1"));
        System.out.println("===========================");
    }

    @Test
    public void testRedisTemplateList(){
        System.out.println("===========================");
        User user  = new User();
        user.setId(1);
        user.setToken("洗面奶");
        user.setEmail("100ml");
        User user2  = new User();
        user.setId(1);
        user.setToken("洗面奶");
        user.setEmail("200ml");
        //依次从尾部添加元素
        template.opsForList().rightPush("user", user);
        template.opsForList().rightPush("user", user2);
        //查询索引0到商品总数-1索引（也就是查出所有的商品）
        List<Object> userList = template.opsForList().range("user", 0,template.opsForList().size("user")-1);
        for(Object obj:userList){
            System.out.println((User)obj);
        }
        System.out.println("产品数量:"+template.opsForList().size("user"));
        System.out.println(userList);
        System.out.println("===========================");

    }

    @Test
    public void testStringRedisTemplateList(){
        System.out.println("===========================");
        User user  = new User();
        user.setId(1);
        user.setToken("洗面奶");
        user.setEmail("100ml");
        User user2  = new User();
        user.setId(1);
        user.setToken("洗面奶");
        user.setEmail("200ml");
        //依次从尾部添加元素
        stringTemplate.opsForList().rightPush("user", user.toString());
        stringTemplate.opsForList().rightPush("user", user2.toString());
        //查询索引0到商品总数-1索引（也就是查出所有的商品）
        List<String> userList = stringTemplate.opsForList().range("user", 0,stringTemplate.opsForList().size("user")-1);
        for(Object obj:userList){
            System.out.println((String) obj);
        }
        System.out.println("产品数量:"+stringTemplate.opsForList().size("user"));
        System.out.println(userList);
        System.out.println("===========================");

    }



}
