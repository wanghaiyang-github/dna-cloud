<%@ include file="../include.jsp" %>
<%
    String path = request.getContextPath();
%>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2018/12/19
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>北京市公安局法医鉴定案件受理系统</title>
    <%@ include file="../linkCss.jsp" %>
    <style>
        .btn-red:hover {
            width: 100%;
        }

        #videoBox a {
            padding-top: 10px;
            padding-bottom: 10px
        }

        #videoBox button {
            padding: 10px 26px;
        }

        .bu {
            background: #fddddb;
            color: #fc5a56;
            padding: 5px;
            border-radius: 50%;
            font-size: 10px;
            font-weight: 600;
        }
    </style>
</head>
<body>
<div class="row Modular">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading blue">
                <div>查询条件</div>
            </div>
            <div class="panel-body">
                <form id="consignationForm" action="<%=path %>/equipmentRepairInfo/equipmentRepairList" class="form-horizontal tasi-form"
                      method="post">
                    <div class="row">
                        <div class="col-md-4 seachInputBox">
                            <div class="form-group">
                                <label>设备编号</label>
                                <input type="text" id="equipmentNo" name="entity.equipmentNo" value="${query.entity.equipmentNo}"
                                       class="form-control"
                                       placeholder="请输入案件名称">
                            </div>
                        </div>
                        <div class="col-md-4 seachInputBox">
                            <div class="form-group">
                                <label>设备名称</label>
                                <input type="text" class="form-control" placeholder="请输入案件编号" id="equipmentName"
                                       name="equipmentName" value="${query.equipmentName}">
                            </div>
                        </div>
                        <div class="col-md-4 seachInputBox">
                            <div class="form-group">
                                <label>设备状态</label>
                                <div class="select">
                                    <select id="equipmentStatus" name="entity.equipmentStatus"
                                            value="${query.entity.equipmentStatus}" class="form-control">
                                        <option value="">全部</option>
                                        <c:forEach items="${equipmentStatusList}" var="list" varStatus="do">
                                            <option value="${list.dictCode}">${list.dictName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 seachInputBox">
                            <div class="form-group seachButtonBox">
                                <input type="hidden" name="page" id="page" value="${pageInfo.page}"/>
                                <button class="btn btn-blue" type="submit" id="addInformant">查询</button>
                                <button class="btn btn-blue-border">重置</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="row Modular ">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading yellow">
                <div>设备报废记录</div>
            </div>
            <div class="panel-body">
                <table class="table table-hover table-bordered bigTable">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>设备编号</th>
                        <th>设备名称</th>
                        <th>入库时间</th>
                        <th>设备状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="equipmentRepairInfoListTbody">
                        <c:forEach items="${equipmentInfoList}" var="list" varStatus="s">
                            <tr>
                                <td>${s.index+1}</td>
                                <td>${list.entity.equipmentNo}<input type="hidden" name="equipmentNo" value="${list.entity.equipmentNo}"></td>
                                <td>${list.equipmentName}<input type="hidden" name="equipmentName" value="${list.equipmentName}"></td>
                                <td><fmt:formatDate value='${list.entity.createDatetime}' pattern='yyyy-MM-dd '/><input type="hidden" name="createDatetime" value="${list.entity.createDatetime}"></td>
                                <td>${list.equipmentStatusName}<input type="hidden" name="equipmentStatus" value="${list.entity.equipmentStatus}"></td>
                                <td>
                                    <input type="hidden" id="id" name="id" value="${list.entity.id}">
                                    <button name="modifyBtn" type="button" class="btn btn-green btn-xs edit">申请报修</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="row" style="padding: 0px">
                    <div class="col-md-12">
                        <div id="kkpager"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../linkJs.jsp" %>
<script src="<%=path%>/js/entrustCurrency.js"></script>
<script>
    $(function () {

        $('.form_datetime').datetimepicker({
            format: 'yyyy-mm-dd',
            language: 'zh',
            weekStart: 1,
            todayBtn: 1,
            minView: "month",
            autoclose: true,
            todayHighlight: true,
            forceParse: 0,
            showMeridian: 1
        }).on('changeDate', function (ev) {
            $(this).datetimepicker('hide');
        });


    })
</script>
</body>

</html>