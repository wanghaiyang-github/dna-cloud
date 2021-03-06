<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>北京市公安局DNA信息统计管理系统</title>
    <%@ include file="../linkCss.jsp" %>
    <style>
        .bu {
            background: #fddddb;
            color: #fc5a56;
            padding: 5px;
            border-radius: 50%;
            font-size: 10px;
            font-weight: 600;
        }

        .bigTable.table-bordered, .bigTable.table-bordered > tbody > tr > td {
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
        }
        .export{
            font-size:14px;
            color: #0C81F5;
            font-weight:normal;
            cursor: pointer;
        }
        .case-number tr td:nth-child(3)/*,.case-number tr td:nth-child(5),.case-number tr td:nth-child(7),.case-number tr td:nth-child(9),.case-number tr td:nth-child(11),.case-number tr td:nth-child(13),.case-number tr td:nth-child(15),.case-number tr td:nth-child(17),.case-number tr td:nth-child(19)*/{
            /*color: #0C81F5;*/
        }
        .case-number tr td:nth-child(2)/*,.case-number tr td:nth-child(6),.case-number tr td:nth-child(8),.case-number tr td:nth-child(10),.case-number tr td:nth-child(12),.case-number tr td:nth-child(14),.case-number tr td:nth-child(16),.case-number tr td:nth-child(18),.case-number tr td:nth-child(20)*/{
            /*color: #FF5A56;*/
        }
        .case-number tr:last-of-type td{
            color: #333;
            font-size:14px;
            font-weight:bold;
        }
        .case-number tr:last-of-type td:nth-child(1){
            color: #FF5A56;
        }
        /*案件性质开始*/
        .checkbox-div p {
            margin: 0;
            position: relative;
        }

        .checkbox-div {
            border-bottom: 1px dashed #e2e2e2;
            margin: 10px 0;
            padding-bottom: 10px;
        }

        .checkbox-div p span:first-of-type {
            font-size: 14px;
            font-weight: bold;
            color: #0279E2;
            border-left: 5px solid #0279E2;
            padding-left: 4px;
        }

        .checkbox-div .check-all {
            display: inline-block;
            width: 40px;
            height: 22px;
            line-height: 22px;
            text-align: center;
            background: #E8E8E8;
            color: #333;
            cursor: pointer;
        }

        .checkbox-div .check-all.active {
            color: #0076E6;
            background: #e3effc;
        }

        .checkbox-div .check-list {
            margin: 10px 0;
        }

        .checkbox-div .check-list li {
            display: inline-block;
            padding: 10px 14px;
            background: #E8E8E8;
            color: #333;
            font-size: 12px;
            border-radius: 37px;
            cursor: pointer;
            position: relative;
            margin-right: 14px;
        }

        .check-list li.active {
            background: #DDEEFF;
            border: 1px solid #0073EA;
            color: #0073EA;
            font-weight: bold;
        }

        .check-list li.active:before {
            content: '';
            display: inline-block;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            background: url("../img/check.png") no-repeat center;
            background-size: 100%;
            position: absolute;
            top: -4px;
            right: -8px;
        }

        .check-first {
            display: inline-block;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            background: url("../img/uncheck.png") no-repeat center;
            background-size: 100%;
            position: absolute;
            right: 0;
            cursor: pointer;
        }

        .checkbox-div p b.active {
            background: url("../img/check.png") no-repeat center;
            background-size: 100%;
        }

        .btn-blue-radius {
            width: 106px;
            height: 35px;
            line-height: 35px;
            font-size: 14px;
            border-radius: 35px;
            background: #0076E6;
            padding: 0;
            color: #fff;
            outline: none;
        }
        .table>thead>tr th{
            /*width: 100%;*/
            /*word-break:break-all !important;*/
            white-space:normal;
        }
        /*案件性质结束*/
    </style>
</head>

<body>

<div class="row Modular part">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading blue">
                <div>
                    案件查询
                </div>
            </div>
            <div class="panel-body">
                <form id="consignationForm" action="<%=path%>/warehousing/warehousingCntList" class="form-horizontal tasi-form form-inline"
                      method="post">
                    <div class="row">
                        <div class="col-md-3" style="padding: 0;">
                            <div class="form-group">
                                <label>送检单位</label>
                                <select class="form-control" name="delegateOrgCode">
                                    <option value="" >请选择单位</option>
                                    <c:forEach items="${orgInfoList}" var="orgInfo" varStatus="cs">
                                        <option value="${orgInfo.orgCode}" <c:if test="${orgInfo.orgCode eq query.delegateOrgCode}">selected</c:if> >${orgInfo.orgName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-3" style="padding: 0;">
                            <div class="form-group">
                                <label>送检日期</label>
                                <input type="text" class="form-control form_datetime" readonly="readonly"
                                       name="delegateStartDatetime" value=" <fmt:formatDate value='${query.delegateStartDatetime}' pattern='yyyy-MM-dd'/>" placeholder="请选择开始时间">
                            </div>
                        </div>
                        <div class="col-md-3" style="padding: 0;">
                            <div class="form-group">
                                <label>至</label>
                                <input type="text" class="form-control form_datetime" readonly="readonly"
                                       name="delegateEndDatetime" value=" <fmt:formatDate value='${query.delegateEndDatetime}' pattern='yyyy-MM-dd'/>" placeholder="请选择结束时间">
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="form-group">
                                <button class="btn btn-blue" type="submit" id="addInformant">查询</button>
                                <button type="reset" name="reset" class="btn btn-blue-border">重置</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="row Modular notAccepted part">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading blue row" style="padding: 10px 15px;">
                <div class="col-md-9">统计结果列表</div>
                <div class="col-md-10 col-md-offset-10 export" name="comprehensiveQueryexportBtn">
                    <img src="../img/daochu.png" alt="" width="24px">
                    <span>导出excel</span>
                </div>
            </div>
            <div class="panel-body" style="padding: 0 0 15px 0;">
                <table id="table-con" class="table table-hover table-bordered bigTable table-striped" style="table-layout: fixed;margin-top: 0;">
                    <thead>
                    <tr>
                        <th style="width: 100px;">送检单位</th>
                        <th>高空坠物</th>
                        <th>打拐</th>
                        <th>其他</th>
                        <th>治安</th>
                        <th >伤害致死</th>
                        <th>亲缘</th>
                        <th>强奸</th>
                        <th>盗抢工地</th>
                        <th>凶杀</th>
                        <th>盗窃</th>
                        <th>寻衅滋事</th>
                        <th>抢夺</th>
                        <th>伤害</th>
                        <th>诈骗</th>
                        <th>非正常死亡</th>
                        <th>走失人口</th>
                        <th>抢劫</th>
                        <th>交通事故</th>
                        <th>尸源认定</th>
                        <th style="color: #FF5A56;">总计</th>
                    </tr>
                    </thead>
                    <tbody id="" class="case-number">
                    <c:forEach items="${result}" var="result" varStatus="s">
                        <tr> <input type="hidden" value="${result.value}">
                            <td>${result.key}</td>
                            <c:forEach items="${result.value}" var="resultValue" varStatus="c">
                                <td title="${resultValue.value}">${resultValue.value}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td>总计</td>
                        <c:forEach items="${caseProperyCountVoList}" var="total" varStatus="c">
                            <td title="${total.gkzwTotal}">${total.gkzwTotal}</td>
                            <td title="${total.dgTotal}">${total.dgTotal}</td>
                            <td title="${total.qtTotal}">${total.qtTotal}</td>
                            <td title="${total.zaTotal}">${total.zaTotal}</td>
                            <td title="${total.shzsTotal}">${total.shzsTotal}</td>
                            <td title="${total.qyTotal}">${total.qyTotal}</td>
                            <td title="${total.qjaTotal}">${total.qjaTotal}</td>
                            <td title="${total.dqgdTotal}">${total.dqgdTotal}</td>
                            <td title="${total.xcTotal}">${total.xcTotal}</td>
                            <td title="${total.dqTotal}">${total.dqTotal}</td>
                            <td title="${total.xxzsTotal}">${total.xxzsTotal}</td>
                            <td title="${total.qdTotal}">${total.qdTotal}</td>
                            <td title="${total.shTotal}">${total.shTotal}</td>
                            <td title="${total.zpTotal}">${total.zpTotal}</td>
                            <td title="${total.fzcswTotal}">${total.fzcswTotal}</td>
                            <td title="${total.zsrkTotal}">${total.zsrkTotal}</td>
                            <td title="${total.qjTotal}">${total.qjTotal}</td>
                            <td title="${total.jtsgTotal}">${total.jtsgTotal}</td>
                            <td title="${total.syrdTotal}">${total.syrdTotal}</td>
                        </c:forEach>
                    </tr>
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
<div class="modal" id="exportSuccess" tabindex="-1" role="dialog" aria-labelledby="exportSuccess">
    <div class="modal-dialog" role="document" style="width: 456px;">
        <div class="modal-content">
            <div class="modal-body" style="padding: 90px 0;text-align: center">
                <p>
                    <img src="../img/success.png" alt="" width="82px">
                </p>
                <p style="font-size: 22px;font-weight: bold;color: #1BB29B;">
                    导出成功
                </p>
            </div>
        </div>
    </div>
</div>
<div class="height-60"></div>
<div class="row footer">
    Copyright© 2019 北京博安智联科技有限公司       
</div>
<%@ include file="../linkJs.jsp" %>
<script src="<%=path%>/js/entrustCurrency.js"></script>
<script>
    $(function () {

         function RowTotal2() {
                 $('#table-con tbody tr').each(function (tr_Index) {
                     if($(this).attr("title") == "total"){
                     }else{
                         var rowTotal = 0;
                         $(this).find('td').each(function (td_index) {
                             if (td_index != 0) {
                                 rowTotal += parseFloat($(this).text());
                             }
                         });
                         $(this).append("<td class='sum' title='" + rowTotal + "'>"+rowTotal+"</td>")
                     }
                 });
         }
        RowTotal2();

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


        $(".title-tab").click(function () {
            $(this).addClass("active").siblings().removeClass("active")
        });

        //导出excel
        $("div[name='comprehensiveQueryexportBtn']").click(function () {
            var newUrl = "<%=path%>/warehousing/exportExcel";
            $("#consignationForm").attr('action',newUrl);
            $("#consignationForm").submit();

            var oldUrl = "<%=path%>/warehousing/warehousingCntList";
            $("#consignationForm").attr('action',oldUrl);
        });

        //        导出成功模态框居中显示
        $('#exportSuccess').on('shown.bs.modal', function () {
            var $this = $(this);
            var dialog = $this.find('.modal-dialog');
            //此种方式，在使用动画第一次显示时有问题
            //解决方案，去掉动画fade样式
            var top = ($(window).height() - dialog.height()) / 2;
            dialog.css({
                marginTop:top
            });
        });

        /*//案件性质
        $(".check-list").on("click", "li", function () {
            if ($(this).hasClass("active")) {
                $(this).removeClass("active")
                if ($(this).parents("ul").find("li.active").length != $(this).parents("ul").find("li").length) {
                    $(this).parents(".checkbox-div").find(".check-all").removeClass("active")
                }
            } else {
                $(this).addClass("active")
                if ($(this).parents("ul").find("li.active").length == $(this).parents("ul").find("li").length) {
                    $(this).parents(".checkbox-div").find(".check-all").addClass("active")
                }
            }
        })
        $(".check-all").click(function () {
            if ($(this).hasClass("active")) {
                $(this).removeClass("active")
                $(this).parents(".checkbox-div").find("li").removeClass("active")
            } else {
                $(this).addClass("active")
                $(this).parents(".checkbox-div").find("li").addClass("active")
            }
        })
        $(".check-first").click(function () {
            if ($(this).hasClass("active")) {
                $(this).removeClass("active")
            } else {
                $(this).addClass("active")
            }
        })
        $("button[name='okCheck']").click(function () {
            var selectedList = []
            $(".checkbox-div").each(function(){
                if($(this).children(".check-list").length>0){
                    $(this).find("li.active").each(function () {
                        selectedList.push($(this).text())
                    })
                }else if($(this).find("span.active").length>0){
                    selectedList.push($(this).find("span.active").prev().text())
                }
            })
            $("input[name='caseType']").val(selectedList.join(","))
            $("#caseNature").modal("hide")
        })*/
    });
</script>
</body>

</html>