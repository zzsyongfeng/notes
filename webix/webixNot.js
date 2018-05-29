1.当输入第一个文本框后，才能输入第二个，菜单联动的效果可以加
		{ view:"form", elements:[
			{ type:"header", template:"Enable on select"},
			{ view:"richselect", label:"Country", options:["Russia", "Germany"],
				relatedView:"sub2", relatedAction:"enable/snow" },
			{ view:"text", id:"sub2", label:"City", disabled:true/hidden:true }
		]}
		
2.图标网址
http://fontawesome.io/icons/

3.查看远程端口是否开启
start /min telnet 192.168.3.42 2121

4.不配置环境变量启动tomcat
编辑tomcat/bin文件夹下的catalina.bat文件，在文件开头加上jre目录的相对路径
set JAVA_HOME=D:\Program Files\Java\jdk1.7.0_79

5.0不现实显示空白
format:function(value){if(value==0) return ""; else return value;},

6.批量删除图标icon
	"trash-o"
	
7.自动高度
	type:{height:"auto"},
	
8.1.当字符串中是纯数字
例如：var s = '234';
　　　/********** 字符串在运算操作中会被当做数字类型来处理 ***************/　
　　　s *= 1;  
　　　/******* string的两个转换函数，只对string有效 ********/
　　　 parseInt(s); // 234
　　　 parseFloat(s); //234
　　　/************ 强制类型转换 *********************/
　　　 Number(s); // 234



▼▲

${if(len(region) == 0,"","and INSTR('"+region+"', user_ch.region ) > 0 and user_ch.region !=''")}

9.完成率 (实际完成数/计划完成数)*100%

10.mysql去掉回车和换行符 REPLACE(REPLACE(latitude,CHAR(10),''),CHAR(13),'')

11.format(today(), "yyyy")+"-01"

12.帆软导出过滤换行符=SUBSTITUTE($$$, CHAR(13),"")

13.车号列表点击对焦 on:{'onItemClick':function(id){this.focus();}},

14.强制远程桌面退出 mstsc /admin

