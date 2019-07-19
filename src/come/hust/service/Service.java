package come.hust.service;

import come.hust.pojo.User;

import java.util.List;

/**
 * @create 2019-07-18 15:22
 */
public interface Service {

     User checkLoginService(String name,String pwd);
     int ChangePwdService(String name,String NewPwd);
     List <User> ShowUserService();
     int SubmitUserService(User u);
}
