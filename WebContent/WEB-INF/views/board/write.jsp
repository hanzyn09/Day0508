<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/common/menu.jsp"/>
	<h1>글쓰기 페이지</h1>
	<a href="list">게시글 목록</a>
	<form action="write" method="post">
		<p><input type="text" name="subject" placeholder="제목을 입력하세요">
		<p><textarea rows="5" cols="40" name="content"></textarea>
		<p><input type="submit" value="등록">
	</form>
</body>
</html>