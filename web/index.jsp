
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>title</title>
  <link rel="stylesheet" type="text/css" href="css/index.css"/>
  <script>
    function changeCode() {
      var codeImg=document.getElementById("verifyCode");
      codeImg.src="demo1?t="+Math.random();
    }
  </script>
</head>
<body>
<form action="http://localhost:8080/javaweb2/demo3" method="post">
  <div>
    <div class="bgDiv">
      <div class="login">

        <div class="username">
          <div class="username1">用户名：</div>
          <input class="userInp" type="text" name="username" placeholder="请输入用户名"/>
        </div>
        <div class="pwd">
          <div class="pwd1">密码：</div>
          <input class="pwdInp" type="password" name="pwd" placeholder="请输入密码"/>
        </div>

         <div class="ywd">
          验证码：<input name="Vcode">
           <img src="/demo1" id="verifyCode" onclick="changeCode()"><br>
           <input type="checkbox" name="keep"> 一周免密登录<br>
         </div>
        <button class="btn" type="submit" >登录</button>

      </div>
    </div>
  </div>
</form>>
</body>
</html>
