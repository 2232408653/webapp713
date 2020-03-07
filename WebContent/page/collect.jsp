<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="app711.dao.collectDao" %>
<%@ page import="app711.dao.po.Collect" %>
<%@ page import="app711.dao.po.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app711.dao.BookDao" %>
<%@ page import="app711.dao.po.Book" %>

<%
User user=(User)session.getAttribute("currentUser");
collectDao collect=new collectDao();
ArrayList<Collect> collects = collect.selectCollectAllByUser_id(user.getPhone());
%>


<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内商城收藏夹</title>
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/my.collect.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
     <link href="../css/item.food.css" rel="stylesheet" />
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/slide.css" rel="stylesheet" />
</head>
<body>
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
            <li><a href="index.jsp" >首页</a><b>|</b></li>
            <li><a href="collect.jsp" >收藏</a><b>|</b></li>
            <li><a href="order.jsp" >订单</a><b>|</b></li>
            <li><a href="cart.jsp" >购物车</a><b>|</b></li>
            <li><a href="password-change.html">设置</a><b>|</b></li>
            <li><a href="login.html">退出</a><b>|</b></li>
            <li><a href="lookforward.html">帮助</a></li>
        </ul>
    </div>
</header><br/>

<div class="store">
	 <div class="store_top">
        <img src="../img/banner/icon.png" alt=""/>
        我的收藏
    </div>
<!--商品-->
    <%
    BookDao bookDao=new BookDao();
    Book book=null;
    for(int i=0;i<collects.size();i++){
    	book=bookDao.selectByIsbn(collects.get(i).getProduct());
    	if(i%4==0){
    		%>
    		<div class="store_content" >
    		<%
    	}
    %>
    	
    	<div >
                <a href="../page/detail.jsp?isbn=<%=book.getIsbn()%>"><img src="../img/goods/<%=book.getIsbn()%>/index.jpg" alt=""/></a>
                <p class="one"><%=book.getTitle() %></p>
                <p class="two">
                    <span>
                        价格：<span>￥<%=book.getPrice() %></span>
                    </span>
                </p>
                <p class="three">
                    <span>
                    出版社：<span><%=book.getPress() %></span>
                    </span>
                </p>
                <span class="addCart"><a href="deleteCollete.jsp?isbn=<%=book.getIsbn()%>">移除收藏</a></span>
            </div>

    	<% 
    		if(i%4==3){
    			%>
    			</div>
    			<%
    		}
    }
    %>
</div>

<!--商品-->

    <div class="none" style="display: none">
        <div class="none_content">
            <img src="../img/model/model_img3.png" alt="" class="lf"/>
            <p class="lf">您的收藏夹竟然还是空哒( ⊙ o ⊙ )</p>
            <span class="lf">赶快去收藏商品吧！</span>
            <a href="#" class="lf">去购物>></a>
        </div>

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
            <p class="footer2"><img src="../img/footer/footerFont.png" alt=""/></p>
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
<script src="../js/collect.js"></script>
</body>
</html>
