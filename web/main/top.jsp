<%@ page import="come.hust.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Li
  Date: 2019/7/7
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="come.hust.pojo.*" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
        String name=((User) session.getAttribute("user")).getName();

%>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function(){
            //顶部导航切换
            $(".nav li a").click(function(){
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })
            $("#out").click(function () {
                var flag=window.confirm("你真的要退出吗")
                    if(flag){

                        window.top.location.href="user?oper=out";
                    }

            })
        })
    </script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
</div>



<div class="topright">
    <ul>

        <li><a href="login.html"  id="out">退出</a></li>
    </ul>

    <div class="user">
        <span><%=name%></span>


    </div>

</div>

</body>
</html>
