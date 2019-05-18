package com.myblog.service.impl.user;


import com.myblog.mapper.user.UserMapper;
import com.myblog.pojo.user.User;
import com.myblog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    @Autowired
    private UserMapper userMapper;


    public User selectUser(int userId) {
        return this.userMapper.selectUser(userId);
//        return null;
    }



    @Override
    public User addUser(User user) throws Exception {
        user.setCreateTime(new Date());
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String token = System.currentTimeMillis()+new Random().nextInt()+"nono哒哟";
//        user.setToken(new String(md5.digest(token.getBytes("UTF-8")),"UTF-8"));
        user.setToken(token);
        int i =this.userMapper.addUser(user);
        if(i==0){
            return null;
        }
        user = userMapper.selectUserAll(user.getId());
        return user;
    }

    public void test(){
        System.out.println("测试");
    }
}
