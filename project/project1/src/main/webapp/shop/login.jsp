<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
<form id="frm" method="post" action="./login_ok.do" onsubmit="return loginck()">
<p>[회원 로그인]</p>
<div>
<label><input type="radio" name="spart" value="P" checked="checked" onclick="partcheck(this.value)">일반회원</label>
<label><input type="radio" name="spart" value="C" onclick="partcheck(this.value)">사업자회원</label>
<br>
<input type="text" name="sid" placeholder="아이디를 입력하세요"><br>
<input type="password" name="spw" placeholder="패스워드를 입력하세요"><br>
<span id="snoview" style="display:none">
<input type="text" name="sno" placeholder="사업자 등록번호"><br>
</span>
<br>
<input type="submit" value="로그인">
</div>
</form>
</body>
<script>
function partcheck(part){
	var snoview = document.getElementById("snoview");
	if(part == "P"){
		snoview.style.display = "none";
	}else{
		snoview.style.display = "block";
	}
}

function loginck(){
	if(frm.sid.value==""){
		alert("아이디를 입력하세요");
		return false;
	}else if(frm.spw.value==""){
		alert("패스워드를 입력하세요");
		return false;
	}else{
		if(frm.spart[0].checked){
			return true;
		}else{
			if(frm.sno.value==""){
				alert("사업자번호를 입력하세요");
				return false;
			}else{
				return true;
			}
		}
	}
}
</script>
</html>