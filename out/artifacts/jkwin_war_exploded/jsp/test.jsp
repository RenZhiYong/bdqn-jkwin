<%--
  Created by IntelliJ IDEA.
  User: RZY
  Date: 2018/4/8
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <script src="../js/jquery-3.0.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
        <p>第一个bootstrap</p>
        <p>使用了 .container-fluid，100% 宽度，占据全部视口（viewport）的容器。</p>
    </div>
    <div class="container-fluid">
        <h1>Hello World!</h1>
        <p>重置浏览器大小查效果。</p>
        <p> 在移动设备上，即屏幕宽度小于 576px 时，四个列将会上下堆叠排版。</p>
        <div class="row">
            <div class="col-sm-3" style="background-color:lavender;">.col-sm-3</div>
            <div class="col-sm-3" style="background-color:lavenderblush;">.col-sm-3</div>
            <div class="col-sm-3" style="background-color:lavender;">.col-sm-3</div>
            <div class="col-sm-3" style="background-color:lavenderblush;">.col-sm-3</div>
        </div>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-primary">Sony</button>
        <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
            <span class="caret"></span>
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Tablet</a>
            <a class="dropdown-item" href="#">Smartphone</a>
        </div>
    </div>
    <nav class="nav navbar-default">
        <div class="container">
            <div class="navbar-header">
                <!--此处写导航栏的Header-->
                <p class="navbar-brand">IT</p>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Java</a></li>
                <li><a href="#">C/C++</a></li>
                <li><a href="#">Shell</a></li>
                <li><a href="#">Python</a></li>
            </ul>
        </div>
    </nav>

    <hr>
    <div class="dropdown">
        <button class="btn btn-primary" data-toggle="dropdown">
            Dropdown
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="#">Java</a></li>
            <li><a href="#">C/C++</a></li>
            <li><a href="#">Python</a></li>
            <li><a href="#">Php</a></li>
        </ul>
    </div>
</body>
</html>
