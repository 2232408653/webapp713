<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="app711.dao.BookDao" %>
<%@ page import="app711.dao.po.Book" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内商城学子详情页</title>
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/pro.details.css" rel="stylesheet" />
    <link href="../css/animate.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
</head>
<body>
<% 
String isbn=request.getParameter("isbn");
BookDao bookdao=new BookDao();
Book book=bookdao.selectByIsbn(isbn);
%>
<!-- 页面顶部-->
<header id="top">
    <div id="logo" class="lf">
        <img class="animated jello" src="../img/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>

        <a href="" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
            <li><a href="../page/index.jsp" >首页</a><b>|</b></li>
            <li><a href="../page/collect.jsp" >收藏</a><b>|</b></li>
            <li><a href="../page/order.jsp" >订单</a><b>|</b></li>
            <li><a href="../page/cart.jsp" >购物车</a><b>|</b></li>
            <li><a href="../page/password-change.html">设置</a><b>|</b></li>
            <li><a href="../page/login.html">退出</a><b>|</b></li>
            <li><a href="../page/lookforward.html">帮助</a></li>
        </ul>
    </div>
</header>

<div>&nbsp;</div>
<div class="rt">
<div class="store_top">
        <img src="../img/banner/icon.png" alt=""/><h2>删除</h2>
    </div>
<img id="mImg" src="../img/goods/<%=book.getIsbn() %>/detail1big.jpg"/>

<h2><a href="#" class="collection lf" id="collect"><span>确认删除</span></a><b><img src='../img/product_detail/product_detail_img62.png' alt=""/></h2>
<h2><a href="detail.jsp?isbn=<%=request.getParameter("isbn")%>">查看详情/取消</a></h2>


</div>
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../img/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../img/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../img/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../img/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
            <p class="footer1"><img src="../img/footer/tedu.png" alt="" class=" footLogo"/></p>
            <p class="footer2"><img src="../img/footer/footerFont.png"alt=""/></p>
            <!-- 页面底部-备案号 #footer -->
            <div class="record">
                2001-2016 版权所有 京ICP证8000853号-56
            </div>
        </div>
        <div class="foot_left lf" >
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../img/footer/wechat.png" alt=""/>
                    <img src="../img/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>达内商城客户端</p>
            <img src="../img/footer/ios.png" class="lf">
            <img src="../img/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../img/footer/erweima.png">
        </div>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script>
    //添加收藏
  $("#collect").click(function (e) {
        var params = {
        	product: <%=book.getIsbn() %>
        };
        $.ajax({
            type: "post",
            url: "/webapp713/servlet/deletecollect",
            data: params,
            success: function (data) {
                if (data == 'yes') {
                    alert("删除成功");
                    window.location.href="collect.jsp";
                } else if(data='have'){
                    alert("已经删除或者收藏夹内没有");
                    window.location.href="collect.jsp";
                } 
            },
            error: function (data) {
                alert("系统异常！");
            }
        });
    })
</script>

</body>
</html>
