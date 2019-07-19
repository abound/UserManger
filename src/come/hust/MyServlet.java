package come.hust;

import come.hust.pojo.User;
import come.hust.service.Service;
import come.hust.service.ServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import  org.apache.log4j.Logger;

/**
 * @create 2019-07-18 15:23
 */
@WebServlet(name = "MyServlet",urlPatterns = "/user")
public class MyServlet extends HttpServlet {
    Logger logger = Logger.getLogger(MyServlet.class);
    Service service = new ServiceImp();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String oper = request.getParameter("oper");
        if ("login".equals(oper)) {
            CheckLogin(request, response);

        } else if ("out".equals(oper)) {

            userOut(request, response);
        } else if ("change".equals(oper)) {

            ChangePwd(request, response);
        } else if ("show".equals(oper)) {
            ShowUserService(request, response);
        } else if ("reg".equals(oper)){

            RegUserService(request,response);
        }else {


            logger.debug("没有找到对应的操作符" + oper);
        }


    }

    public void CheckLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");


        User u = service.checkLoginService(name, pwd);
        System.out.println(u);
        if (u != null) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", u);
            response.sendRedirect("main/main.jsp");
            return;
        } else {

            request.setAttribute("flag", 0);

            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

    }

    public void userOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        response.sendRedirect("login.jsp");


    }

    public void ChangePwd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = ((User) request.getSession().getAttribute("user"));
        String name = u.getName();
        String Pwd = request.getParameter("NewPwd");
        System.out.println(Pwd);
        Service service = new ServiceImp();
        int index = service.ChangePwdService(name, Pwd);
        System.out.println(index);
        if (index > 0) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("pwd", 0);
            response.sendRedirect("/05_manage_war_exploded/login.jsp");
        }


    }

    public void ShowUserService(HttpServletRequest request, HttpServletResponse response)
        throws IOException,ServletException{


        List<User> lu=service.ShowUserService();
        System.out.println(lu);
        if(lu!=null){
            request.setAttribute("lu",lu);
            request.getRequestDispatcher("main/allUserInfo.jsp").forward(request,response);
            return;
        }

    }

    public  void RegUserService(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException{

            String name=request.getParameter("name");
            String pwd=request.getParameter("pwd");
            String sex=request.getParameter("sex");
            Integer age=Integer.parseInt(request.getParameter("age"));
            String birth=request.getParameter("birth");
            System.out.println(name+pwd+sex+age+birth);
            User u=new User(0,name,pwd,sex,age,birth);
            int index=service.SubmitUserService(u);
            System.out.println(index);
            if(index>0){
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("reg", 0);
                response.sendRedirect("/05_manage_war_exploded/login.jsp");
            }else {

            }

    }






}
