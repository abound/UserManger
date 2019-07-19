package come.hust.Dao;

import come.hust.pojo.User;

import java.util.List;

/**
 * @create 2019-07-18 15:22
 */
public interface Dao {

         User CheckLoginDao(String name,String pwd);
         int ChangePwdDao(String name,String NewPwd);
         List<User> ShowUserDao();
         int  SubmitUserDao(User u);
}
