package com.studyplatform.web.service.impl;

import com.studyplatform.web.bean.UserBean;
import com.studyplatform.web.dao.UserDao;
import com.studyplatform.web.dao.impl.UserDaoImpl;
import com.studyplatform.web.exception.UserExistException;
import com.studyplatform.web.service.UserService;

/**
 * 业务逻辑封装接口实现（用户登录） 
 * Title: UserServiceImpl
 * @date 2018年2月22日
 * @author Freedom0013
 */
public class UserServiceImpl implements UserService {
    /** 初始化dao */
    UserDao dao = new UserDaoImpl();
    @Override
    public UserBean login(String username, String password) {
        return dao.findUserByUserNameAndPassword(username, password);
    }

    @Override
    public void register(UserBean user) throws UserExistException {
     // 查找用户
        UserBean u = dao.findUserByUserName(user.getUser_name());
        if (u == null){
            // 说明用户没有注册过,执行添加
            dao.add(user);
        }else{
            throw new UserExistException();
        }
    }
}
