<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset==UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/styles/JSONFormatter.css'/>">
    <script type="text/javascript" src="<c:url value='/scripts/common/common.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/scripts/jquery/jquery-1.8.2.min.js'/>"></script>
    <SCRIPT type="text/javascript" src="<c:url value='/scripts/jquery/jquery.json-2.2.js'/>"></SCRIPT>
    <script type="text/javascript" src="<c:url value='/scripts/JSONFormatter.js'/>"></script>
    <title>自定义菜单</title>
</head>
<body>
<br/>
<input type="button" id="setCustomMenu" class="form_button"
       style="padding:8px;font: 13.3333px Arial;margin-left: 15px;border:1px
 solid;height:33px;cursor: pointer; width:150px;background:#269CE9;color:#FFF" value="设置自定义菜单"/>
<input type="button" id="getCustomMenu" class="form_button"
       style="padding:8px;font: 13.3333px Arial;margin-left: 15px;border:1px solid;height:33px;cursor: pointer;
       width:150px;background:#269CE9;color:#FFF" value="获取自定义菜单"/>
<input type="button" id="setMenuStatus" class="form_button"
       style="padding:8px;font: 13.3333px Arial;margin-left: 15px;border:1px solid;height:33px;cursor: pointer;
       width:150px;background:#269CE9;color:#FFF" value="设置菜单状态"/>
<br>

<div id="setMenu-div" style="display:none">
    <form id="form1">
        <dl>
            <h4>菜单一：</h4>
            <dd>
                <label>名称&nbsp;&nbsp;&nbsp;</label><input type="text" name="name">
            </dd>
            <dd>
                <label>类型&nbsp;&nbsp;</label>
                <input type='radio' name='type' value=1>响应消息
                <input type='radio' name='type' value=2>url跳转
                <input type='radio' name='type' value=3>图文消息
            </dd>
            <dd>
                <label>响应消息&nbsp;</label><input type="text" name="actionParam">
            </dd>
        </dl>
    </form>
    <form id="form2">
        <dl>
            <h4>菜单二：</h4>
            <dd>
                <label>名称&nbsp;&nbsp;&nbsp;</label><input type="text" name="name">
            </dd>
            <dd>
                <label>类型&nbsp;&nbsp;</label>
                <input type='radio' name='type' value=1>响应消息
                <input type='radio' name='type' value=2>url跳转
                <input type='radio' name='type' value=3>图文消息
            </dd>
            <dd>
                <label>响应消息&nbsp;</label><input type="text" name="actionParam">
            </dd>
        </dl>
    </form>
    <form id="form3">
        <dl>
            <h4>菜单三：</h4>
            <dd>
                <label>名称&nbsp;&nbsp;&nbsp;</label><input type="text" name="name">
            </dd>
            <dd>
                <label>类型&nbsp;&nbsp;</label>
                <input type='radio' name='type' value=1>响应消息
                <input type='radio' name='type' value=2>url跳转
                <input type='radio' name='type' value=3>图文消息
            </dd>
            <dd>
                <label>响应消息&nbsp;</label><input type="text" name="actionParam">
            </dd>
        </dl>
    </form>
    <input type='button' id='submitMenu' value='点击设置'>
</div>
<br>
<div id="setStatus-div" style="display:none">
    设置菜单状态：<br>
    <input type='radio' name='status' value='NORMAL'>正常</input>
    <input type='radio' name='status' value='CLOSE'>关闭</input>
    <input type='radio' name='status' value='DLETED'>删除</input>
    <input type='button' id='submitSet' value='点击设置'>
</div>
<div id="output" style="display:block;word-break: break-all;word-wrap: break-word;"></div>
<br/>
<script type="text/javascript">
    function format(json) {
        $("#output").html("");
        if (json == null || json == "") {
            json = {"msg": "没有数据"}
        }
        JSONFormatter.format(json, {'appendTo': '#output', 'collapse': true, 'list_id': 'json'});
    }

    function getMenuResultHandler(result) {
        var json;
        if (result.errorCode == 0) {
            json = result.menus;
        } else {
            json = result;
        }

        format(json);
    }
    function setMenuResultHandler(result) {
        format(result);
    }

    $(function () {
        //设置自定义菜单
        $("#setCustomMenu").click(function () {
            $("#setMenu-div").show();
            $("#setStatus-div").hide();
            $("#output").hide();
        });
        //获取自定义菜单
        $("#getCustomMenu").click(function () {
            $("#setMenu-div").hide();
            $("#setStatus-div").hide();
            var url = '${pageContext.request.contextPath}/customMenu/menu';
            ajaxAsyncGet(url, Math.round(new Date().getTime() / 1000), getMenuResultHandler);
            $("#output").show();
        });
        //设置菜单状态按钮
        $("#setMenuStatus").click(function () {
            $("#setStatus-div").show();
            $("#setMenu-div").hide();
            $("#output").hide();
        });
        //提交设置状态请求
        $("#submitSet").click(function () {
            var status = $('input[name="status"]:checked').val();
            if (status == null) alert("请选择状态");
            var url = '${pageContext.request.contextPath}/customMenu/menu/' + status;
            ajaxAsyncPut(url, status, getMenuResultHandler);
            $("#output").show();
        })
        $("#submitMenu").click(function () {
            var arg1 = $("#form1").serializeObject();
            var arg2 = $("#form2").serializeObject();
            var arg3 = $("#form3").serializeObject();
            var params = new Array();
            params.push(arg1);
            params.push(arg2);
            params.push(arg3);
            var url = '${pageContext.request.contextPath}/customMenu/menu/set';
            ajaxListRequest(url, 'post', params, setMenuResultHandler);
            $("#output").show();
        });
    })
</script>
</body>
</html>