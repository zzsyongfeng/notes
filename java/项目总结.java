1.单选获取被选中的值
var passFlag = $("input[name='passFlag']:checked").val();

$(this).attr("disabled","disabled");
		   $("#sub").text("提交中");
		   $("#fillship").submit();
		   
ajax异步介绍:
http://mybloggers.blog.163.com/blog/static/1003865092010111631741468/


location.href='<%=basepath %>/transport/listexceptionship.htm'

1、取到选中的值；var result=$("#你的radioId").val();

2、赋值；$("#你的文本框ID").val(result);


3.设置时间进行刷新
setTimeout(function () { location.reload(); }, 1000);


4.多行文本框
<textarea id="outOfReason" name="outOfReason" onmousedown="cursor(event,this);" style="width: 400px; text-align:start;height: 100px;overflow-x: hidden;overflow-y: auto;"></textarea>
判断长度里面不能有回车或者空格
/*定义多行文本框鼠标始终停留在开始处*/
        function cursor(e,a) {
			if (e && e.preventDefault) {
				e.preventDefault();
			} else {
				window.event.returnValue=false;
			}
			a.focus();
		}
		
5.ajax异步请求数据
 /*ajax异步提交弹出窗口表单*/
        function test() {
            var form = new FormData(document.getElementById("appendShipCompany"));
            $.ajax({
				url:"<%=basepath%>/transport/doexceptionship.json",
				type:"post",
				data:form,
				processData:false,
				contentType:false,
				success:function(data){
					window.wxc.xcConfirm("提交成功！", window.wxc.xcConfirm.typeEnum.success);
					setTimeout("window.location.reload();",2000);//延时2秒刷新页面
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    alert(textStatus);
                }
            });        
        }
		
6.选中当前记录行数
$("#tab tr").click(function() {
	$(this).addClass("onclick").siblings("tr").removeClass("onclick");
});

7.BigDecimal格式化0
public BigDecimal getPlanQuantity() {
	return planQuantity == null ? new BigDecimal(0) : planQuantity;
}

8.格式化日期
TO_CHAR( NVL (A.DATE_OF_BUILD, '') ,'yyyy-mm-dd') buildtime    TO_CHAR (UPDATE_TIME, 'YYYY-MM-DD HH24:MI:ss')

9.数据库关联查询
LEFT JOIN T_SHIP_COMPANY_RELATION B ON A .SHIP_ID = B.SHIP_ID
关联查询主数据表中没有的字段可以在sql起别名,在实体类中声明getset方法

10.数据库中时间查询转换
<if test="createTime != null">
	AND A.CREATE_TIME &gt;= TO_DATE(#{createTime}, 'yyyy-mm-dd hh24:mi:ss')
</if>

11.日期转自定义标签在页面显示出来
<td class="td_left">
	<fmt:formatDate value="${p.plandfhgTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
</td>

12.根据按钮传需要的值,隐藏的数据用.val(值:标签里面的),显示的数据用.text(值:标签包着的)

13.定义多行文本框鼠标始终停留在开始处
onmousedown="cursor(event,this);"
function cursor(e,a) {
	//鼠标光标在文本中可以任意点击移动和任意选中
	if (document.content.focus){
		document.content.select();
	}
	if (e && e.preventDefault) {
		e.preventDefault();
	} else {
		window.event.returnValue=false;
	}
	a.focus();
}

14.js根据名字取值
$("input[name='ownerEn']").val($(this).toPinyin().toUpperCase());

15.页面返回 onclick="history.back();"    javascript:history.back();

16.js里面终止代码return false;
	java里面终止代码:return 返回值类型; System.exit(0);(直接停止虚拟机)
	
17.中间移动间隙 style="padding-right:3px ;"

18.页面重定向 location.href="<%=basepath%>/transport/listtransports.htm";

19.关闭浏览器  $(window).on('beforeunload', function(e) {
//...
    });
	
20.输入有最大限制,和数据库保持一致,不然报错 maxlength="300" onkeyup="value=value.replace(/[^\d]/g,'')"

21.SQL语句对单个字段去重，并且显示所有列
SELECT * FROM T_CUSTOMER
WHERE 1 = 1 
 		AND ORG_NO IN(
 		SELECT MAX(ORG_NO) 
 		FROM T_CUSTOMER
 		GROUP BY NAME)
		
22.提交按钮预防重复提交
	在请求成功加开关 $("#submitBtn").attr("disabled", true);  要是选项卡就定为this
					$("#submitBtn").attr("disabled", false);

23.字段为数字型的比较不能用.equals


25.在数据库中读取多个数据
	String sourceStr = "e0359437.gif,63f42f02d.gif ,63jd23d.gif"; //一个字符串
	String[] sourceStrArray = sourceStr.split(","); //分割出来的字符数组

26.参数String在sql中转换DATE
<if test="expirytime != null">
	EXPIRY = to_date(#{expirytime,jdbcType=VARCHAR}, 'yyyy-mm-dd'),
</if>

27.上传文件删除服务器上的文件
	File file = new File("文件的路径");
	file.delete();

28.SELECT * FROM S订单 limit 4 取表前4行

29.代码

30.BigDecimal的加减乘除都被封装了方法 所以不能用基础类型的运算符直接运算,调用其方法进行运算
	比较大小,直接相减,和0比较
	BigDecimal amt= requestList.getApproveQuantity().subtract(requestOrderShip.getFinishQuantity());
	int number = amt.compareTo(BigDecimal.ZERO);
	number == -1 就是小于0
	number == 0 就是等于0
	number == 1 就是正数
	
31.sql中if...else  CASE WHEN (RO.APPROVE_QUANTITY-NVL(tto.QUANTITY , 0 )) < 0 
      			THEN 0 ELSE (RO.APPROVE_QUANTITY-NVL(tto.QUANTITY , 0 )) END surplusQuantity,
				
32.sql计算关联
	select
		ro.REQUEST_NO,
		ro.RECEIVER_COMPANY,
		ro.DELIVERY_TYPE,
		ro.PETROLEUM_NAME,
		NVL(RO.REQUEST_QUANTITY , 0 ) REQUEST_QUANTITY,
		ro.APPROVE_QUANTITY,
		NVL(tto.QUANTITY , 0 ) finishQuantity,
		RO.APPROVE_QUANTITY-NVL(tto.QUANTITY , 0 ) surplusQuantity,
		ro.RECEIVER_NAME,
		ro.RECEIVER_PHONE,
		ro.SALE_NAME,
		ro.DEPOT_NAME,
 		TO_CHAR(REPORTING_TIME, 'yyyy-mm-dd hh24:mi:ss') REPORTING_TIME,
 		TO_CHAR(APPROVAL_TIME, 'yyyy-mm-dd hh24:mi:ss') APPROVAL_TIME,
 		TO_CHAR(DEPOT_REVIEW_TIME, 'yyyy-mm-dd hh24:mi:ss') DEPOT_REVIEW_TIME,
 		STATE,
 		(
 			TO_HARBOUR || ' (' || PROVINCE || ' ' || CITY || ')'
 		) TO_HARBOUR
	from T_REQUEST_ORDER_SHIP ro
	  LEFT JOIN (SELECT	REQUEST_NO,	SUM (QUANTITY) QUANTITY FROM T_TRANSPORT_ORDER
			GROUP BY REQUEST_NO
	  ) tto ON ro.REQUEST_NO = tto.REQUEST_NO
	where 1=1
	
33.js写在前面和后面的区别
	当页面载入时，位于 body 部分的 JavaScripts 将会执行。
	当被调用时，位于 head 部分的 JavaScripts 才会被执行。

34.调用js文件
	<%
		String basepath = request.getContextPath();
	%>
	<script type="text/javascript" src="<%=basepath%>/js/js.js"></script>

35. 在tomcat中配置文件
	<Context path="/trace/image" docBase="D:/zhangyouhui/apache-tomcat-8.0.30/bin/image"></Context>

36. eclipse控制台不自动自动跳转windows -> preferences -> server 把show server view when server stase changes 前面的钩去掉
	tomcat启动保存代码不自动加载项目,双击tomcat点击右上角的部署,把自动关掉就行
	
37. maven配置阿里云镜像
	<mirror> 
		<id>alimaven</id> 
		<name>aliyun maven</name> 
		<url>http://maven.aliyun.com/nexus/content/groups/public/</url> 
		<mirrorOf>central</mirrorOf> 
	 </mirror> 
	 
38.页面保留小数点位数
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<fmt:formatNumber value="${hzt50+hzt70+hzt90}" pattern="#0.0#"/>
	
39.java高级具备
	1.Core Java，就是Java基础、JDK的类库，很多童鞋都会说，JDK我懂，但是懂还不足够，知其然还要知其所以然，JDK的源代码写的非常好，要经常查看，对使用频繁的类，比如String，集合类（List，Map，Set）等数据结构要知道它们的实现，不同的集合类有什么区别，然后才能知道在一个具体的场合下使用哪个集合类更适合、更高效，这些内容直接看源代码就OK了
	2.多线程并发编程，现在并发几乎是写服务端程序必须的技术，那对Java中的多线程就要有足够的熟悉，包括对象锁机制、synchronized关键字，concurrent包都要非常熟悉，这部分推荐你看看《Java并发编程实践》这本书，讲解的很详细
	
	3.I/O，Socket编程，首先要熟悉Java中Socket编程，以及I/O包，再深入下去就是Java NIO,再深入下去是操作系统底层的Socket实现,了解Windows和Linux中是怎么实现socket的
	
	4.JVM的一些知识，不需要熟悉，但是需要了解，这是Java的本质，可以说是Java的母体, 了解之后眼界会更宽阔，比如Java内存模型（会对理解Java锁、多线程有帮助）、字节码、JVM的模型、各种垃圾收集器以及选择、JVM的执行参数（优化JVM）等等,这些知识在《深入Java虚拟机》这本书中都有详尽的解释,或者去oracle网站上查看具体版本的JVM规范.
	
	5.一些常用的设计模式，比如单例、模板方法、代理、适配器等等，以及在Core Java和一些Java框架里的具体场景的实现，这个可能需要慢慢积累，先了解有哪些使用场景，见得多了，自己就自然而然会去用。
	
	6.常用数据库（Oracle、MySQL等）、SQL语句以及一般的优化
	
	7.JavaWeb开发的框架，比如Spring、iBatis等框架，同样他们的原理才是最重要的，至少要知道他们的大致原理。
	
	8.其他一些有名的用的比较多的开源框架和包，Netty网络框架，Apache common的N多包，Google的Guava等等，也可以经常去Github上找一些代码看看。
	
40.java项目权限管理
	１、库的设计：建立五张表，权限表、用户表、角色表、角色权限表、用户角色表

	２、页面的设计：在页面菜单上的权限管理中包括用户管理（用户的增、删、改、查）与角色管理（角色的增、删、改、查）.

	在系统开始使用时,肯定要用一个默认的系统用户在页面进行配置（也就是在库中存在一个用户，用户具有“超级管理员”角色，这个角色包含这个系统中的所有权限）。

	系统在初始化时权限表中包含你的所有的要控制用户显示的项的一个对应值。

	首先，先创建你想要的角色，在页面上可以用JS脚本生成一棵树，这棵树的每一个节点就是通过树节点的复选框可以为当前新增的角色选择你想设定的权限，这样你新建一个角色保存时，就会将这个角色的信息存入角色表中，同时将角色与所选的权限的关系放入角色权限表中。

	其次，在用户管理项中，新建一个用户，为这个用户选择一个之前建立的角色，这样就可以将其保存到用户表中，同时将用户与角色的关系放到用户角色表中。

	３、逻辑设计：当一个用户登陆时，校验用户的身份的时候，若是该用户存在，可以将这个用户所具有的权限查出来（通过用户与角色、角色与权限的对应关系来处理），放入session中（不要怕往session中入东西，不会太多），这样当用户登陆以后，点击每一个可以判断session中有没有这个点击所对应的权限，若是没有就提示“没有权限”，也可以通过直接对用户所具有的权限，在页面的层次上就将功能屏敝，也就是说用户没有的权限，在页面上根本就不显示。

41.js控制页面颜色
document.getElementById('msg').style.color = "#3C763D";
document.getElementById('msg').style.background = "#3C763D";

42.webix点击选择什么隐藏其他的空间
var t1 = {view:"text",id:"t1",value:"1"}
    var t2 = {view:"text",id:"t2",value:"2"}

var c1 = {
    view:"combo", 
  	
   options:[{id:1,value:"one"},{id:2,value:"two"},{id:3,value:"three"}],
   on:{
  	 "onChange":function(){
     	//$$("t1").setValue(this.getValue());
       //$$("t2").setValue(this.getText());
       
     	switch(this.getValue())
            { 
            case  1:$$("t1").hide();
            break;
            case  2:$$("t2").hide();
            break;
            default:
        }
     
     }
  }
}

webix.ui(
  { rows:[ t1, t2, c1, ] }
);

	date_format(ogl.start_time,'%Y-%m-%d %H:%i') startTimeStr,
			date_format(ogl.arrival_time,'%Y-%m-%d %H:%i') arrivalTimeStr,
			date_format(ogl.report_time,'%Y-%m-%d %H:%i') reportTimeStr,
			date_format(ogl.trace_end_time,'%Y-%m-%d %H:%i') traceEndTimeStr,

43.时间戳
yyyy-MM-dd HH:mm:ss

44.快速定位jar包的所在 Ctrl+Shift+T
快速引用包 Ctrl+Shift+O

45.jquery页面跳转
第一种：(跳转到b.html)
<script language="javascript" type="text/javascript">
window.location.href="b.html";
</script>
第二种：（返回上一页面）
<script language="javascript">
window.history.back(-1);
</script>
第三种：
<script language="javascript">
window.navigate("b.html");
</script>
第四种：
<script language="JavaScript">
self.location=’b.html’;
</script>
第五种：
<script language="javascript">
top.location=’b.html’;
</script>

46.eclise中添加本地jar
	1).配置maven环境变量
	2).命令行 mvn -v 判断maven配置是否成功
	3).输入 mvn install:install-file -Dfile=F:/hessianService.jar -DgroupId=com.hessian -DartifactId=hessian-service-20170714 -Dversion=1.0.0 -Dpackaging=jar
	4).更新到本地maven库中
	5).在pom.xml中配置添加库中路径

47.mysql查询当天当纪念

48.修改tomcat窗口名称
if "%TITLE%" == "" set TITLE=Tomcat_zibeiche [%DATE% %TIME%]

49.mysql查询月数据
select date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') as ww from DUAL    -- 上月
SELECT DATE_FORMAT(CURDATE(), '%Y-%m') from DUAL;  -- 本月
SELECT DATE_SUB(CURDATE(), INTERVAL 5 DAY) from dual; --天数
			
			
购货单位APP
state:  0 全部   数据库中的 STATE >= 0 AND STATE <= 500
		1 待审核 数据库中的 STATE < 110
		2 执行中 数据库中的 STATE >= 110 AND STATE < 400
		3 已完成 数据库中的 STATE >= 400 AND STATE <=500
		
	申请单
	000 制单中
	100 已提单
	105 已驳回
	107 已挂单
	110 已受理
	120 派船中
	140 全派船
	200 全下单
	220 全接单
	300 全发货
	400 全收货
	500 已评价


Windows 7 Starter（初级版）
Windows 7 Home Basic（家庭普通版）
Windows 7 Home Premium（家庭高级版）
Windows 7 Professional（专业版）
Windows 7 Enterprise（企业版）
Windows 7 Ultimate（旗舰版）

webix.locale.pager = {
    first: "首页",
    last: "尾页",
    next: "下一页",
    prev: "上一页"
};

CONCAT('空',CONVERT((SELECT count(empty_weight) from  carriage_info_log where carriage_group_no=og.carriage_group_no AND empty_weight LIKE '空'), char), '/重',
				CONVERT(cc.carNumber,char) - CONVERT((SELECT count(empty_weight) from  carriage_info_log where carriage_group_no=og.carriage_group_no AND empty_weight LIKE '空'), char) 
			) empty_weight
 
 

http://www.cnblogs.com/DBFocus/archive/2011/09/04/2166584.html  


http://localhost:8080/pl_cloud/railway/app/allot?bigPotNum=2&smallPotNum=3&approveBillNo=I_GF17040059












