package com.myblog.service.impl.user;


import com.myblog.service.user.UserService;

//@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService {

//    @Resource
//    @Autowired
//    private UserMapper userMapper;
//
//
//    public User selectUser(int userId) {
//        return this.userMapper.selectUser(userId);
////        return null;
//    }
//
//
//
//    @Override
//    public User addUser(User user) throws Exception {
//        user.setCreateTime(new Date());
//        MessageDigest md5 = MessageDigest.getInstance("MD5");
//        String token = System.currentTimeMillis()+new Random().nextInt()+"nono哒哟";
////        user.setToken(new String(md5.digest(token.getBytes("UTF-8")),"UTF-8"));
//        user.setToken(token);
//        int i =this.userMapper.addUser(user);
//        if(i==0){
//            return null;
//        }
//        user = userMapper.selectUserAll(user.getId());
//        return user;
//    }
//
//    public void test(){
//        System.out.println("测试");
//    }
}
