<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app711.dao.OrderDao" %>
<%@ page import="app711.dao.po.Order" %>
<%@ page import="app711.dao.po.User" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/my.order.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
</head>
<body>
<%
User user=(User)session.getAttribute("currentUser");
//String order_id ="12345678910";//request.getParameter("order_id");
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
    <!-- 主导航-->

<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li></li>
    </ul>
</div>
    <!--我的订单内容区域 #container-->
    <div id="container" class="clearfix">
        <!-- 左边栏-->
        <div id="leftsidebar_box" class="lf">
            <div class="line"></div>
            <dl class="my_order">
                <dt onClick="changeImage()">我的订单
                    <img src="../img/myOrder/myOrder2.png">
                </dt>

            </dl>

         </div>
        <!-- 右边栏-->
        <div class="rightsidebar_box rt">
            <!-- 商品信息标题-->
            <table id="order_list_title"  cellpadding="0" cellspacing="0" >
                <tr>
                    <th width="345">商品</th>
                    <th width="82">单价（元）</th>
                    <th width="50">数量</th>
                    <th width="82">售后</th>
                    <th width="100">实付款（元）</th>
                    <th width="90">交易状态</th>
                    <th width="92">操作</th>
                </tr>
            </table>
            <!-- 订单列表项 -->
<%
		Order order=new Order();
ArrayList<Order> orders = orderDao.selectByPhone(user.getPhone());
order=null;
		for(int i=0;i<orders.size();i++){
			order=orders.get(i);
			//写一个<div></div>
		
			%> 
            
            <div id="orderItem">
                <p class="orderItem_title">
                 <span id="order_id">
                     &nbsp;&nbsp;订单编号:<a href="#" name="order_id"><%=order.getOrder_id() %> </a>
                 </span>
                    &nbsp;&nbsp;成交时间：<%=order.getHandover() %> :00&nbsp;&nbsp;
                 <span>
                     <a href="#" class="servie">
                         联系客服<img src="../img/myOrder/kefuf.gif"/>
                     </a>
                 </span>
                </p>
            </div>
            <div id="orderItem_detail">
                <ul>
                    <li class="product">
                        <b><a href="#"><img src="../img/goods/<%=order.getProduct() %>/detail1.jpg" /></a></b>
                        <b class="product_name lf" >
                            <a href=""><%=order.getTitle() %></a>
                            <br/>
                        </b>
                        <b class="product_color ">
                            出版社：<%=order.getPress() %>
                        </b>
                    </li>
                    <li class="unit_price">
                        专属价
                        <br/>
                        ￥<%=order.getPrice() %>
                    </li>
                    <li class="count">
                       <%=order.getCount() %>件
                    </li>
                    <li class="sale_support">
                        退款/退货
                        <br/>
                        我要维权
                    </li>
                    <li class=" payments_received">
                        ￥<%=order.getPayment() %>
                    </li>
                    <li class="trading_status">
                        <img src="../img/myOrder/car.png" alt=""/>已发货
                        <br/>
                        <a href="order-info.jsp?order_id=<%=order.getOrder_id() %>">订单详情</a>
                    </li>
                    <li class="operate">
                      <!-- <a href="confirmReceipt.html">确认收货</a> --> 
                        <a href="#" id="confirmReceipt" >确认收货</a>
                    </li>
                </ul>
            </div>
     <% }%>
            
            
			<!--分页器-->
            <div class="tcdPageCode"></div>
        </div>
        <!-- 右边栏(没有订单时) -->
        <!-- 右边栏(没有订单时)开始 -->
        <!--
		<div class="rightsidebar_box rt" >
		      <div class="order_empty">
		          <img src="../img/myOrder/myOrder3.png" alt=""/>
		         <p>你可能还没有订单(⊙o⊙)</p>
		         <span>赶紧去下单吧 <b>去购物</b></span>
		     </div>
	    </div>
    -->
        <!-- 右边栏(没有订单时)结束 -->
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
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script src="../js/order.js"></script>
<script type="text/javascript">
//分页部分
$(".tcdPageCode").createPage({
    pageCount:6,
    current:1,
    backFn:function(p){
    	
    }
});

//点击确认收货 跳转页面
$("#confirmReceipt").click(function (e) {
    //数量取值
    
   // buyAccount = $("#buy-num").val();
    //console.log(buyAccount);
    var params = {
    	order_id: <%=order.getOrder_id() %>,
    	
    };
    $.ajax({
        type: "post",
        url: "/webapp713/servlet/confirmReceipt",
        data: params,
        success: function (data) {
            if (data == 'yes') {
                alert("你好，已经确定收货！");
                var url = "/webapp713/page/confirmReceipt.jsp";
                window.location.href = url;
               
            } else {
                alert("确定收货失败！");
            }
        },
        error: function (data) {
            alert("系统异常！");
        }
    });
    
    
})
/*
$(".tcdPageCode").createPage({
    pageCount: ${requestScope.pageCount },
    current: ${requestScope.current },
    backFn:function(pageIndex){
        var start = (pageIndex-1)*${requestScope.length };
        window.location.href='../servlet/show-order?pageIndex='+pageIndex+'&start='+start+'&length='+${requestScope.length };
    }
});
*/
</script>
</html>
