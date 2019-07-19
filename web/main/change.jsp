
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>

</head>

<body>
<script>

    $(function () {
        $("#fm").submit(function () {
           if ( $("#CfPwd")==""){
               alert("密码不能为空");

               return false;
           }else if($("#NewPwd").val()==""){
              alert("密码不能为空");
              return false;

           }else if($("#NewPwd").val()!=$("#CfPwd").val()){
               alert("两次密码不一致");
               return  false;
           }else {
               return true;
           }

        })
    })



</script>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">表单</a></li>
    </ul>
</div>

<div class="formbody">
<form action="user" method="post" id="fm" >
    <ul class="forminfo">
        <input type="hidden" name="oper" value="change"/>
        <li><label>新密码</label><input name="NewPwd" id="NewPwd" type="text" class="dfinput" /><i></i></li>
        <li><label>更改密码</label><input id="CfPwd" type="text" class="dfinput" /><i></i></li>
        <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存" style="color: #1F3D74;background-color: #dc4e00"/></li>
    </ul>
</form>

</div>


</body>

</html>

