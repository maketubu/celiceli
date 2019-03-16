<%--
  Created by IntelliJ IDEA.
  User: xiaotaoran
  Date: 2019/3/15
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>GAME</title>
</head>
<link rel="stylesheet" href="bootstrap.css">
<style>
    .header {
        position: absolute;
        top: 0px;
        left: 0px;
        right: 0px;
        height: 60px;
        background-color: #000;
        color: #fff;
    }

    .content {
        margin-top: 70px;
    }

    .greenbg {
        width: 100%;
        background-color: #0f0;
    }

    .greenbr {
        text-align: center;
        border: solid;
        border-radius: 8px;
        border-color: #0a0;
        color: #0a0;
    }

    .submit {
        height: 45px;
    }

    .fit {
        width: 100%;
    }

    .row {
        margin-top: 12px;
    }

    .panal {
        width: 30%;
        margin: 0 auto;
        margin-bottom: 30px;
    }

    .box {
        margin-bottom: 20x;
    }
</style>
<script>
    function getByClass(parent, cls) {
        if (parent.getElementsByClassName) {
            return parent.getElementsByClassName(cls);
        } else {
            var res = [];
            var reg = new RegExp(' ' + cls + ' ', 'i')
            var ele = parent.getElementsByTagName('*');
            for (var i = 0; i < ele.length; i++) {
                if (reg.test(' ' + ele[i].className + ' ')) {
                    res.push(ele[i]);
                }
            }
            return res;
        }
    }

    function get(index) {
        var choose = getByClass(document, 'greenbr');
        for (let i = 0; i < choose.length; i++) {
            choose[i].style.backgroundColor = "#fff";
            choose[i].style.color = "#0a0";
        }
        choose[index].style.backgroundColor = "#0a0";
        choose[index].style.color = "#fff";

        var count = document.getElementById("count");
        if(index == 1) { money = 30; } else
        if(index == 2) { money = 50; } else
        if(index == 3) { money = 100; } else
        if(index == 4) { money = 300; } else
        if(index == 5) { money = 500; } else
        { money = 10; }
        count.value = money;
    }
</script>

<body>
<div class="header text-center">
    <h3>充值vip</h3>
</div>
<div class="content">
    <div class="panal">
        <div class="row">
            <div class="col-xs-5 greenbr" onclick="get(0)" style="background-color:#0a0;color:#fff">
                <strong>一天</strong>
                <br> 售价：10.00元

            </div>
            <div class="col-xs-offset-2 col-xs-5 greenbr" onclick="get(1)">
                <strong>一星期</strong>
                <br> 售价：30.00元

            </div>
        </div>
        <div class="row">
            <div class="col-xs-5 greenbr" onclick="get(2)">
                <strong>一个月</strong>
                <br> 售价：50.00元

            </div>
            <div class="col-xs-offset-2 col-xs-5 greenbr" onclick="get(3)">
                <strong>一年</strong>
                <br> 售价：100.00元

            </div>
        </div>

    </div>
    <hr>
    <form action="/vip.action" class="form panal" method="get">
        <div class="form-group row box">
            <label for="uid" class="col-xs-3 control-label">游戏ID</label>
            <div class="col-xs-9">
                <input type="text"  id="uid" name="uid" placeholder="输入要充值的游戏ID">
            </div>
        </div>

        <div class="form-group row box">
            <label for="count" class="col-xs-3 control-label">金额</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="count" name="count" readonly value="10">
            </div>
        </div>

        <div class="form-group row box">
            <div class="col-xs-12 fit">
                <button type="submit" class="btn btn-success fit">购买</button>
            </div>
        </div>
    </form>
</div>
</body>

</html>

