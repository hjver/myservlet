package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.encode_md5;
import model.insert_data;

public class join_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final String table_nm = "shop_member";
	
	PrintWriter pw = null;
	ArrayList<String> sdata = null;
	int result = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		String spart = request.getParameter("spart");
		String sid = request.getParameter("sid");
		String spw = request.getParameter("spw");
		String snm = request.getParameter("snm");
		String stel = request.getParameter("stel");
		String semail = request.getParameter("semail");
		
		spw = new encode_md5().encode(spw);
		
		this.sdata = new ArrayList<String>();
		this.sdata.add(spart);
		this.sdata.add(sid);
		this.sdata.add(spw);
		this.sdata.add(snm);
		this.sdata.add(stel);
		this.sdata.add(semail);
		
		String sno = null;
		if (spart.equals("C")) {
			sno = request.getParameter("sno");
		}
		this.sdata.add(sno);
		
		this.result = new insert_data().insert(sdata, this.table_nm);
		
		if(this.result > 0) {
			this.pw.write("<script>"
					+ "alert('회원가입이 정상적으로 완료되었습니다.');"
					+ "location.href='./login.jsp';"
					+ "</script>");
		}else {
			this.pw.write("<script>"
					+ "alert('연락처 또는 이메일이 중복되어서 가입이 취소되었습니다.');"
					+ "location.href='./join.html';"
					+ "</script>");			
		}
		this.pw.close();	
	}
}
