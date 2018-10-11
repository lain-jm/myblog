import com.myblog.SpringBootStartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootStartApplication.class})//指定启动类
//@SpringBootTest(classes = SpringBootStartApplication.class) 老版本
@Transactional
public class test {

//    @Autowired
//    private UserMapper userMapper;

    @Test
    public void ApplicationTests(){
//        String email = userMapper.checkIsExsitEmail("331037760@qq.com");
//        System.out.println(email);
    }

}
