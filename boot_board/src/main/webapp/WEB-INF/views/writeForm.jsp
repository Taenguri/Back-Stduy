<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style>
</style>
</head>
<body>
	<h2>글쓰기</h2>
	<form action="writeAction" method="post">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="board_name" size="50"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="board_title" size="50"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="60" name="board_content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기">&nbsp;&nbsp;
					<a href="listForm"><input type="button" value="목록"/></a>
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>