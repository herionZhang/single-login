<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Index.html</title>
     
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
     
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
 
  </head>
   
  <body>
     
  <form action="servlet/LoginServlet">
     
	    用户名：<input type="text" name="userName"/><br/>
	    密	  码： <input type="password" name="password"/><br/>
      <input type="submit" value="登录" name="login"/>
  </form>
         
  </body>
</html>