1.�������һ���ı���󣬲�������ڶ������˵�������Ч�����Լ�
		{ view:"form", elements:[
			{ type:"header", template:"Enable on select"},
			{ view:"richselect", label:"Country", options:["Russia", "Germany"],
				relatedView:"sub2", relatedAction:"enable/snow" },
			{ view:"text", id:"sub2", label:"City", disabled:true/hidden:true }
		]}
		
2.ͼ����ַ
http://fontawesome.io/icons/

3.�鿴Զ�̶˿��Ƿ���
start /min telnet 192.168.3.42 2121

4.�����û�����������tomcat
�༭tomcat/bin�ļ����µ�catalina.bat�ļ������ļ���ͷ����jreĿ¼�����·��
set JAVA_HOME="jdk·��"

5.0����ʵ��ʾ�հ�
format:function(value){if(value==0) return ""; else return value;},

6.����ɾ��ͼ��icon
	"trash-o"
	
7.�Զ��߶�
	type:{height:"auto"},
	
8.1.���ַ������Ǵ�����
���磺var s = '234';
������/********** �ַ�������������лᱻ������������������ ***************/��
������s *= 1;  
������/******* string������ת��������ֻ��string��Ч ********/
������ parseInt(s); // 234
������ parseFloat(s); //234
������/************ ǿ������ת�� *********************/
������ Number(s); // 234



����

${if(len(region) == 0,"","and INSTR('"+region+"', user_ch.region ) > 0 and user_ch.region !=''")}

9.����� (ʵ�������/�ƻ������)*100%

10.mysqlȥ���س��ͻ��з� REPLACE(REPLACE(latitude,CHAR(10),''),CHAR(13),'')

11.format(today(), "yyyy")+"-01"

12.���������˻��з�=SUBSTITUTE($$$, CHAR(13),"")

13.�����б����Խ� on:{'onItemClick':function(id){this.focus();}},

14.ǿ��Զ�������˳� mstsc /admin

