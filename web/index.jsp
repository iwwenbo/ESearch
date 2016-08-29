<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css" media="screen">
    <title>ESearch</title>
    <script type="text/javascript" src="resources/js/jquery-1.12.2.min.js"></script>
    <script>
        function show_error(xhr){

            var iWidth=800;
            var iHeight=600;
            var iTop = (window.screen.availHeight-30-iHeight)/2;
            var iLeft = (window.screen.availWidth-10-iWidth)/2;
            window.open('','','top='+iTop+',iLeft='+iLeft+',width='+iWidth+',height='+iHeight
                    +'toolbar=no, scrollbars=yes,menubar=no,location=no, resizable=yes').document.write(xhr.responseText);


        }
        //搜索函数
        function dosearch(){
            var url ="<s:url action='doSearch.action'/>";
            //首先判断文本框的内容是否为空
            if($("#sn").val().replace(new RegExp(" ", 'g'),"")==""){
                //为空
                console.log("内容为空");
            }else {
                //不为空进行搜索
                $.ajax({
                    type: "post",
                    async: false,
                    url: url,
                    data: $("#submitForm").serialize(),
                    success: function (data) {
                        console.log("日志搜索完成。。。。");
                    },
                    error: function (xhr) {
                        if (confirm("保存失败，是否查看错误信息！")) {
                            show_error(xhr);
                        }
                    }
                });
            }
        }

        $(document).ready(function () {
            $("#searchbutton").click(function() {
                dosearch();
             }
            );
        })
    </script>
</head>
  <body>
  <div class="container">
      <div style="height:550px;">
          <div class="text-center hidden-xs">
              <h1 style="padding-top:100px;">Google</h1>
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
  </div>
  </body>
</html>
