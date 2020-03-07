<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="app711.dao.BookDao" %>
<%@ page import="app711.dao.po.Book" %>
<%@ page import="app711.dao.OrderItemDao" %>
<%@ page import="app711.dao.po.OrderItem" %>
<%@ page import="app711.dao.AddressDao" %>
<%@ page import="app711.dao.po.Address" %>
<%@ page import="app711.dao.OrderDao" %>
<%@ page import="app711.dao.po.Order" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内学子商城-订单详情页</title>
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/order.info.css" rel="stylesheet" />
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
            <li><a href="index.html" >首页</a><b>|</b></li>
            <li><a href="collect.html" >收藏</a><b>|</b></li>
            <li><a href="order.html" >订单</a><b>|</b></li>
            <li><a href="cart.html" >购物车</a><b>|</b></li>
            <li><a href="password-change.html">设置</a><b>|</b></li>
            <li><a href="login.html">退出</a><b>|</b></li>
            <li><a href="lookforward.html">帮助</a></li>
        </ul>
    </div>
</header>
<!-- nav主导航-->

<!--详细信息-->
<%
String order_id=request.getParameter("order_id");
//order_id="123456789";
OrderItemDao collect=new OrderItemDao();
OrderDao a=new OrderDao();
ArrayList<OrderItem> collects = collect.selectAllByOrder_id(order_id);
Order order=a.selectByOrder_id2(order_id);
AddressDao addressDao=new AddressDao();
Address add=addressDao.selectByID(order.getAddress_id());






%>
<div class="store">

<!--商品-->


<div id="container">
        <!-- 导航 -->
        <div class="container_nav">
            首页&gt;订单管理&gt;订单<span><%=order.getOrder_id() %></span>
        </div>
        <div class="orderInfo_icon">
            <p>订单<span class="order-num"><%=order.getOrder_id() %></span>&nbsp;&nbsp;&nbsp;当前状态：<span class="state"><%=order.getSta() %></span></p>
        </div>
        <!-- 订单状态流程图-->

        <div class="clear">

        <!-- 详细信息-->
            <h1>详细信息</h1>
            收货人：<span class="consignee"><%=add.getReceiver() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span class="tel"><%=add.getReceiverPhone() %></span>
            <br/>
            <p>收货地址：<span><%=add.getAddress() %></span></p>
        </div>
        <h1>商品信息</h1>
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
                        购入价格：<span>￥<%=collects.get(i).getPrice() %></span>
                    </span>
                </p>
                <p class="three">
                    <span>
                    购买数量：<span><%=collects.get(i).getCount() %></span>
                    </span>
                </p>
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
<h1>总价<%=order.getPayment() %></h1>

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
<script>
    //搜索下拉
    $('.seek').focus(function(){

        if($(this).hasClass('clickhover')){

            $(this).removeClass('clickhover');
            $(this).find('.seek_content').hide();
            $(this).find('img').attr('src','../img/header/header_normal.png');

        }else{
            $(this).addClass('clickhover');
            $(this).find('.seek_content').show();
            $(this).find('img').attr('src','../img/header/header_true.png');
        }
    })
    $('.seek_content>div').click(function(){
        $('.seek').removeClass('clickhover');
        var text=$(this).html();
        $('.seek span').html(text);
        $(this).parent().hide();
        $('.seek').find('img').attr('src','../img/header/header_normal.png');
        $('.seek').blur();

    })

    $('.seek').blur(function(){

        $('.seek').removeClass('clickhover');
        $('.seek_content').hide();

        $('.seek').find('img').attr('src','../img/header/header_normal.png');
        console.log(1);
    })
    //头部hover
    $(".care").hover(function(){
        $(this).attr('src',"../img/header/care1.png");
    },function(){
        $(this).attr('src',"../img/header/care.png");
    });
    $(".order").hover(function(){
        $(this).attr('src',"../img/header/order1.png");
    },function(){
        $(this).attr('src',"../img/header/order.png");
    });
    $(".shopcar").hover(function(){
        $(this).attr('src',"../img/header/shop_car1.png");
    },function(){
        $(this).attr('src',"../img/header/shop_car.png");
    });
</script>
</html>
