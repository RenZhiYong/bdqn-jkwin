<%--
  Created by IntelliJ IDEA.
  User: Allen
  Date: 2018/4/15
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <%--自适应--%>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no"/>
    <%--css--%>
    <link rel="stylesheet" href="/css/WeChatPaying.css">
    <link rel="stylesheet" href="/css/publicTop.css">
    <link rel="stylesheet" href="/bootstrap-3.3.7/dist/css/bootstrap.min.css">
    <%--js--%>
    <script src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="../../js/publicTop.js"></script>
    <script type="text/javascript " src="/js/jquery-3.3.1.js"></script>
    <script type="text/javascript " src="/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
    <%----%>
    <title>微信支付页面</title>
</head>
<body>
<%@include file="publicTop1.html"  %>

<div class="container-fluid gradient">
    <div class="row" style="padding: 0 15px 0 15px;">
        <div class="col-md-12">
            <div class="container">
                <div class="row " style="padding: 0 15px 0 15px;">

                    <div class="col-md-6" id="payContent_left">
                        <div class="container-fluid" style="margin-top: 0px">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="pay_text_content">
                                        <span>
                                        请使用微信&nbsp;<span class="glyphicon glyphicon-qrcode"></span>&nbsp;<span style="color:#f90 ">扫一扫</span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12 ">
                                    <div class="pay_text_content">
                                        扫描二维码支付
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12 pay_text_content" style="padding: 0">
                                    <div class="pay_text_content"
                                         style=" width: 300px;height: 300px;">
                                        <%--<img src="${ercodeUrl}">--%>
                                        <img src="${ercodeUrl}" alt="" class="media-object img-thumbnail" id="ercode">
                                </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-md-12 ">
                                    <div class="pay_text_content">
                                        <span style="color:#f90 "> 二维码时长为2小时，尽快完成支付</span>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>


                    <div class="col-md-6 hidden-xs" id="payContent_right">
                        <img src="/image/WeChatTips.jpg" alt="微信付款指示">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>

<script>
    $(document).ready(function () {
        $.ajax()


    })
</script>
