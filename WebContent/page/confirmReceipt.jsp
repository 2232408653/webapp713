<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app711.dao.OrderDao" %>
<%@ page import="app711.dao.po.Order" %>
<%@ page import="app711.dao.po.User" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内学子商城-订单详情页</title>
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/order.info.css" rel="stylesheet" />
</head>
<body>
<%
User user=(User)session.getAttribute("currentUser");
OrderDao orderDao=new OrderDao();
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
            <li><a href="index.jsp" >首页</a><b>|</b></li>
            <li><a href="collect.jsp" >收藏</a><b>|</b></li>
            <li><a href="order.jsp" >订单</a><b>|</b></li>
            <li><a href="cart.jsp" >购物车</a><b>|</b></li>
            <li><a href="password-change.html">设置</a><b>|</b></li>
            <li><a href="login.html">退出</a><b>|</b></li>
            <li><a href="lookforward.html">帮助</a></li>
        </ul>
    </div>
</header>
<!-- nav主导航-->

<!--详细信息-->
<div id="container">
        <!-- 导航 -->
        <div class="container_nav">
            首页&gt;订单管理&gt;订单<span>12345677777</span>
        </div>
        <div class="orderInfo_icon">
            <p>订单<span class="order-num">12345677777</span>&nbsp;&nbsp;&nbsp;当前状态：<span class="state">买家已收货</span></p>
        </div>
        <!-- 订单状态流程图-->
        <div id="orderStatusChart">
              <dl>
                  <dt><img src="../img/orderinfo/orderinfo_img1_2.png" alt=""/></dt>
                  <dd>
                      <p>提交订单</p>
                      <span>2018.07.09 8:00</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../img/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>

              <dl>
                  <dt><img src="../img/orderinfo/orderinfo_img3_2.png" alt=""/></dt>
                  <dd>
                      <p >已经送达</p>
                      <span >2018.07.10 13:00</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../img/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>

              <dl>
                  <dt><img src="../img/orderinfo/orderinfo_img4_2.png" alt=""/></dt>
                  <dd >
                      <p >确认收货</p>
                      <span >2018.07.11 14:00</span>
                  </dd>
              </dl>
              <dl>
                <dt class="point"><img src="../img/orderinfo/orderinfo_img6_2.png" alt=""/></dt>
              </dl>

            <dl>
                  <dt><img src="../img/orderinfo/orderinfo_img5_1.png" alt=""/></dt>
                  <dd >
                      <p >待评价</p>
                      <span style="display: none">2016.01.01 13:00</span>
                  </dd>
              </dl>

        </div>
        <div class="clear">

        <!-- 详细信息-->
            <h1>详细信息</h1>
            收货人：<span class="consignee">某某某</span>&nbsp;&nbsp;&nbsp;&nbsp;邮编：<span class="postcode">100000</span>&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span class="tel">13913883111</span>
            <br/>
            <p>收货地址：<span>北京市昌平沙河小镇小沙河单身男公寓11楼1单元1号门</span></p>
        </div>

        <!-- 商品信息-->
        <div style="width: 1000px; margin:0px auto">
        
        <%
		Order order=new Order();
		ArrayList<Order> orders = orderDao.selectAll();
		order=null;
		for(int i=0;i<orders.size();i++){
			order=orders.get(i);
		
			%> 
            <h1 class="commodity">商品信息</h1>
            <div class="product_confirm">
                <ul class="item_title">
                    <li class="p_info">商品信息</li>
                    <li class="p_price">单价(元)</li>
                    <li class="p_count">数量</li>
                    <li class="p_tPrice">实付款</li>
                </ul>
                <div>订单编号：<span><%=order.getOrder_id() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;成交时间：2016-11-12 11:11&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系客服：<img src="../img/orderinfo/kefuf.gif" alt=""/></div>
                <ul class="item_detail">
                    <li class="p_info">
                        <b><img src="../img/goods/<%=order.getProduct() %>/detail1.jpg" /></b>
                        <p class="product_name lf" >
                           <%=order.getProduct() %>
                        </p>
                        <br/>
                <span class="product_color ">
                   颜色：深空灰
                </span>
                    </li>
                    <li class="p_price">
                        <i>专属价</i>
                        <br/>
                        <span class="pro_price">￥<%=order.getPrice() %></span>
                    </li>
                    <li class="p_count"><%=order.getCount() %>件</li>
                    <li class="p_tPrice">￥<%=order.getPrice() %></li>
                    <!--<li class="remark">备注</li>-->
                    <li></li>
                </ul>
            </div>
		<% }%>
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
