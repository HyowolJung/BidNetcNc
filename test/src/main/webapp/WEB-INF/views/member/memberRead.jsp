<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>회원 상세정보</title>
<style>
table {
        border-collapse: collapse;
        width: 100%;
        margin-bottom: 20px;
        text-align: center;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 8px;
        text-align: center;
    }

    th {
        background-color: #f2f2f2;
    }

    button {
        padding: 10px;
        cursor: pointer;
        margin-bottom: 10px;
    }

    input[type="radio"] {
        margin-left: 5px;
    }

    .center {
        text-align: center;
    }
</style>
</head>
<body>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%@include file="/WEB-INF/views/common/header.jsp"%><br>
<input id="pageNo" name="pageNo" value="${pageNo}" type="hidden">
<div class="center">
멤버 상세정보
<br>
<br>
 <!--  -->
<table border="1">
	<thead>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>성별</th>
			<th>이메일</th>
			<th>직급</th>
			<th>부서</th>
			<th>전화번호</th>
			<th>상태</th>
			<th>팀</th>
			<th>권한</th>
			<th>입사일</th>
			<th>퇴사일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="memberList" items="${memberList}">
			<tr>
				<td id="td_Id">${memberList.memberId }</td>
				<td>${memberList.memberName }</td>
				<td>${memberList.memberGn}</td>
				<td>${memberList.memberEmail}</td>
				<td>${memberList.memberPos}</td>
				<td>${memberList.memberDept}</td>
				<td>${memberList.memberTel }</td>
				<td>${memberList.memberSt }</td>
				<td>${memberList.memberTeam }</td>
				<td>${memberList.memberAuth }</td>
				<td>${memberList.memberStDay }</td>
				<%-- <td>${memberList.memberLaDay == '1900-01-01' ? '(미정)' :  memberList.memberLaDay}</td> --%>
				<td>${memberList.memberLaDay == null ? '(미정)' :  memberList.memberLaDay}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<button type="button" id="modify" onclick="submitPost()">수정</button>
<button type="button" id="back">뒤로 가기</button>
</div>
<br><br>
<div class="center">
참여중인 프로젝트
<br>
<br>
<table border="1">
<thead>
	<tr>
		<!-- <th>ㅁ</th> -->
		<th>번호(프로젝트)</th> <!-- style="display: none" -->
		<th>이름(프로젝트)</th>
		<!-- <th>언어</th>
		<th>데이터베이스</th> -->
		<th>투입일</th>
		<th>철수일</th>
	</tr>
</thead>
<tbody>
<c:choose>
	<c:when test="${empty projectList}">
      <tr>
        <td colspan="4" style="text-align: center;">참여중인 프로젝트가 없습니다</td>
      </tr>
    </c:when>
    <c:otherwise>
		<c:forEach var="project" items="${projectList}">
    		<tr>
        		<!-- <td><input type="radio"></td> -->
        		<td>${project['PROJECT_ID']}</td> <!-- style="display: none" -->
        		<td>${project['PROJECT_NAME']}</td>
        		<td>${project['PUSHDATE'] == null ? '미정' : project['PUSHDATE']}</td>
        		<td>${project['PULLDATE'] == null ? '미정' : project['PULLDATE']}</td>
    			<%-- <td><fmt:formatDate value="${project['PUSHDATE']}" pattern="yyyy-MM-dd" /></td>
    			<td><fmt:formatDate value="${project['PULLDATE']}" pattern="yyyy-MM-dd" /></td> --%>
        		<%-- <td><fmt:formatDate value="${project['PULLDATE']}" pattern="yyyy-MM-dd" /></td> --%>
    		</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>
</tbody>
</table>
</div>		
<script type="text/javascript">
var member_Id = document.getElementById("td_Id").innerText;
var pageNo = $("#pageNo").val();
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
//console.log("member_Id : " + member_Id);

function submitPost() {//member_Id, pageNo
	//alert("pageNo : " + pageNo);
	//alert("member_Id : " + member_Id);
    // 폼 생성
    //location.href ="/member/memberModify";
    var member_Id = document.getElementById("td_Id").innerText;
	var pageNo = $("#pageNo").val();
	
	//alert("member_Id : " + member_Id);
	//alert("pageNo : " + pageNo);
	
    var form = $('<form></form>', {
        method: 'POST',
        action: '/member/memberModify'
    });

    // memberId와 pageNo 값을 input으로 추가
    form.append($('<input>', {
        type: 'hidden',
        name: 'member_Id',
        value: member_Id
    }));
    
    form.append($('<input>', {
        type: 'hidden',
        name: 'pageNo',
        value: pageNo
    }));

    form.append($('<input>', {
        type: 'hidden',
        name: '${_csrf.parameterName}',
        value: '${_csrf.token}'
    }));
    
    // 폼을 body에 추가하고 제출
    $('body').append(form);
    form.submit();
}

$("#back").click(function(){
	//location.href = "/member/memberList?pageNo=" + pageNo;
	location.href = "/member/memberList";
});
</script>
</body>
</html>