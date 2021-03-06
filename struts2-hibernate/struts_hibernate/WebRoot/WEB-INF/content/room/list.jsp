<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link type="text/css" rel="styleSheet" href="layer/layer/skin/default/layer.css"/>


<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.STYLE7 {font-size: 12}

-->
</style>

<script src="js/jquery.js"></script>
<script src="layer/layer/layer.js"></script>
<script>
	//jquery写法的核心思路
	//$("#deptSelect").val(${deptId});


	function test(opt){
		//alert(opt);
		//获取选中的公寓的楼层数量
		var floors=opt.getAttribute("floors");
		//获取楼层select
		var sel=document.getElementById("floorsSelect");
		
		//拼接楼层select内部的option
		var opts="";
		for(var i=1;i<=floors;i++){
			opts+="<option id='floor"+i+"' value='"+i+"'>"+i+"楼</option>";
		}
		//把拼接好的楼层option字符串,写入下拉列表
		sel.innerHTML=opts;
	}
	
	function init(){
		//从request中获取上次搜索时使用的参数
		var deptId="${deptId}",floors="${floors}";
	
		//获取指定公寓id代表的公寓的option对象
		var dept=document.getElementById("dept"+deptId);
		//选中指定公寓
		dept.selected="selected"
		//获取指定公寓的楼层信息
		test(dept);
		//选中上次搜索时使用的楼层参数
		document.getElementById("floor"+floors).selected="selected";
	}
	
	function openLayer(id){
		//layer.msg('hello');
		
		layer.open({
			type:2,
			title: "房间信息",//如果不需要标题栏,则设置为false,如果需要,则直接设置标题
			closeBtn: 1, //设置为0不显示关闭按钮
			maxmin :true,//是否显示最大化,最小化按钮
			shade: [0.5,"#999"],//第一个参数为透明度,0为全透明.第二个参数为遮罩层颜色
			area: ['550px', '355px'],//使用2个参数定义宽度和高度,如果只定义一个参数,表示设置宽度,而高度由系统自定义
			//offset: 'rb', //右下角弹出
			//time: 2000, //2秒后自动关闭,通常针对与提示层来进行设置
			anim: 2,//动画效果.0-6.如果设置为-1表示无动画
			content: ['roomInfo.do?id='+id, 'no'], //iframe的url，no代表不显示滚动条
			btn : [ '确认','取消','不知道'],
			yes:function (){
				alert(111111);
			},
			//第二个以后的按钮自带关闭效果,如果不希望执行完毕后自动关闭
			//则应当在方法调用即将结束时返回fasle
			btn2:function(){
				alert(2222222);
				return false;
			},
			btn3:function(){
				alert(33333333);
				return false;
			}
		});
	}
</script>
</head>

<body onload="init()">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">房间列表</span></td>
        <td width="281" background="images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                        <input type="checkbox" name="checkbox62" value="checkbox" />
                    </div></td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
              </table></td>
              <td width="60">
              
              <a href="room/addPage.action">
              <table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/001.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">新增</div></td>
                  </tr>
              </table>
              </a>
              </td>
              
              
              <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/083.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">删除</div></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table>
    </td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
        
        <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
          <tr>
            <td width="6%" height="26" background="images/tab_14.gif" class="STYLE1" colspan="7">
	            <div align="left" class="STYLE2 STYLE1">
	            
	            	<form action="roomList.do" method="get">
	            		&nbsp;&nbsp;&nbsp;&nbsp;请选择公寓&nbsp;&nbsp;${deptId }
	            		<select name="deptId" style="width:120px">
	            			<option  >---请选择公寓---</option>
	            			<c:forEach items="${deptList }" var="dept">
	            			<!-- 使用公寓的id作为value,保证每一个选项的值都不重复,可以精确的定位到选择的公寓上 -->
	            			<!-- 为每个option定义一个自定义属性用于记录当前这个公寓拥有的楼层数量 -->
	            			<option value="${dept.id }" floors="${dept.floors }" id="dept${dept.id }" onclick="test(this)">---${dept.deptNo }---</option>
	            			</c:forEach>
	            		</select>&nbsp;&nbsp;&nbsp;&nbsp;
	            		请选择楼层&nbsp;&nbsp;
	            		<select name="floors" id="floorsSelect">
	            			
	            		</select>
	            		<input type="submit" value="查询"/>
	            	</form>
	            </div>
            </td>
          </tr>
          <tr>
            <td width="6%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">选择</div></td>
            <td width="24%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">所属公寓</div></td>
            <td width="8%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">房间号</div></td>
            <td width="8%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">楼层</div></td>
            <td width="24%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">备注</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">查看</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">编辑</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">删除</div></td>
          </tr>
          
          <!-- 循环
          	被循环的组件为request中获取的list集合
          	每次循环获得的变量名为dept
          	循环状态为vs
           -->
          <c:forEach items="${pb.list}" var="room" varStatus="vs">
          <tr>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <input name="checkbox" type="checkbox" class="STYLE2" value="checkbox" />&nbsp;${vs.count }
            </div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${room.dept.deptNo }</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${room.roomNo }</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${room.floors }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${room.remark }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><a href="javascript:openLayer('${room.id }')">查看</a></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><a href="room/updatePage.do?id=${room.id }">修改</a></div></td>
            																			<!-- 根据指定数据的id进行删除操作 -->
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><a href="room/delete.do?id=${room.id }">删除</a></div></td>
          </tr>
          </c:forEach>
          
        </table></td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        <td background="images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap"><span class="STYLE1">共120条纪录，当前第1/10页，每页10条纪录</span></td>
            <td width="75%" valign="top" class="STYLE1"><div align="right">
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62" height="22" valign="middle"><div align="right"><img src="images/first.gif" width="37" height="15" /></div></td>
                  <td width="50" height="22" valign="middle"><div align="right"><img src="images/back.gif" width="43" height="15" /></div></td>
                  <td width="54" height="22" valign="middle"><div align="right"><img src="images/next.gif" width="43" height="15" /></div></td>
                  <td width="49" height="22" valign="middle"><div align="right"><img src="images/last.gif" width="37" height="15" /></div></td>
                  <td width="59" height="22" valign="middle"><div align="right">转到第</div></td>
                  <td width="25" height="22" valign="middle"><span class="STYLE7">
                    <input name="textfield" type="text" class="STYLE1" style="height:10px; width:25px;" size="5" />
                  </span></td>
                  <td width="23" height="22" valign="middle">页</td>
                  <td width="30" height="22" valign="middle"><img src="images/go.gif" width="37" height="15" /></td>
                </tr>
              </table>
            </div></td>
          </tr>
        </table></td>
        <td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>

