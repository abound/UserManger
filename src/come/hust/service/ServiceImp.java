package come.hust.service;

import come.hust.Dao.Dao;
import come.hust.Dao.daoImp;
import come.hust.pojo.User;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @create 2019-07-18 15:23
 */
public class ServiceImp implements Service {
   Logger logger=Logger.getLogger(ServiceImp.class);
    Dao daos=new daoImp();
    @Override
    public User checkLoginService(String name, String pwd) {

        logger.debug(name+"发起登陆请求");
        User u= daos.CheckLoginDao(name,pwd);
        if(u!=null){
            logger.debug(name+"登陆成功");
        }else {
            logger.debug(name+"登陆失败");
        }
        return u;
    }

    @Override
    public int ChangePwdService(String name,String NewPwd) {
        int index=daos.ChangePwdDao(name,NewPwd);
        if(index>0){
            logger.debug("修改密码成功");
        }else {
            logger.debug("修改密码失败");
        }
        return index;
    }

    @Override
    public List<User> ShowUserService() {
        List<User> lu=new ArrayList<>();
        lu=daos.ShowUserDao();
        logger.debug("显示所有信息"+lu);
        return lu;
    }

    @Override
    public int SubmitUserService(User u) {

        int index=daos.SubmitUserDao(u);


        return index;
    }
}
