package com.myblog.web;


import com.myblog.pojo.user.User;
import com.myblog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CacheConfig(cacheNames = "user")
public class UserController {

    //    @Resource(name="userService")
    @Autowired
    private UserService userService;

    @ResponseBody
    @Cacheable(/*key = "targetClass + ':' + methodName + '_' + #p0",*/ unless = "#result.size() <= 0")
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Map getUser(@PathVariable("id") Integer userId) throws Exception {
        System.out.println("如果第二次没有走到这里说明缓存被添加了");
        User user = this.userService.selectUser(userId);
        return queryResult(0,user,"成功");

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Map selectUser(@RequestBody User user) throws Exception {
        User user1 = null;
        try {
            user1 = this.userService.addUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return queryResult(0,user1,"成功");

    }


    private Map queryResult(int code, Object data, String msg){
        Map<String,Object> result = new HashMap<>();
        result.put("code",code);
        result.put("data",data);
        result.put("msg",msg);
        return result;
    }

}

