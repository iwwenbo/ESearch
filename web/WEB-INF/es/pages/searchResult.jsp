<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css" media="screen">
    <title>搜索结果</title>
    <script type="text/javascript" src="resources/js/jquery-1.12.2.min.js"></script>
</head>
  <body>
  <nav class="navbar navbar-inverse" role="navigation">
      <div class="container">
          <!-- logo -->
          <div class="navbar-header">
              Google
          </div>
          <div class="col-md-8 col-md-offset-2">
              <form id="submitForm">
                  <div class="input-group btn-group" style="margin:0 auto;padding-top:50px;">
                      <input type="text" class="form-control dropdown-toggle" id="sn" name="keyWords" value="${keyWords}" style="height:42px;" placeholder="输入关键字" autofocus onkeydown="if(event.keyCode==13){dosearch();}" >
                      <span class="input-group-btn">
                    <button type="button" class="btn btn-danger" id="searchbutton" style="height:42px;">搜索</button>
                </span>
                  </div>
              </form>
          </div>
      </div>
  </nav>
  <div class="container">
      <div style="height:550px;">
          <h2>Title</h2>
          <div>中国驻洛杉矶领事馆遭亚裔男子枪击 嫌犯已自首</div>
      </div>
      </div>
  </body>
</html>
