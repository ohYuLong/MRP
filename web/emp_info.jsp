<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
</head>
<body>
<div align="center">
<p>用户详细信息</p>
<hr>
<div id="app">
    <p> emp_info</p>
    <p hidden id="userid"><%=request.getParameter("id")%></p>
    <table>
        <tr>
            <td>用户号：</td>
            <td>{{userObj.username}}</td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>{{userObj.password}}</td>
        </tr>
        <tr>
            <td>部门：</td>
            <td>{{userObj.department}}</td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>{{userObj.name}}</td>
        </tr>
        <tr>
            <td>更新时间：</td>
            <td>{{userObj.time}}</td>
        </tr>
    </table>
    <button @click="back">返回</button>
    </div>
</div>

<script src="static/js/vue.js"></script>
<script src="static/js/axios.min.js"></script>
<script>
    window.onload = function () {
        if(app1.userid) {
            axios ({
                method: "get",
                url: "findUserBaseInfo.do3?id="+app1.userid,
            }).then(response => {
                app1.userObj = response.data;
                console.log(response.data);
            })
        }
    }

    const app1 = new Vue({
        el: "#app",
        data: {
            userid: document.querySelector("#userid").innerText,
            userObj: {},
        },
        methods: {
            back() {
                history.back();
            },
        }
    })

</script>
</body>
</html>