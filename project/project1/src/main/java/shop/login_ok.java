package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.encode_md5;
import model.select_where;

public class login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final String table_nm = "shop_member";

	PrintWriter pw = null;
	
	Map<String, String> sdata = null;
	boolean is_exist = false;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		String spart = request.getParameter("spart");
		String sid = request.getParameter("sid");
		String spw = request.getParameter("spw");
		
		this.sdata = new HashMap<String, String>();
		this.sdata.put("spart", spart);
		this.sdata.put("sid", sid);
		
		spw = new encode_md5().encode(spw);
		if(spart == "C") {
			String sno = request.getParameter("sno");
			this.sdata.put("sno", sno);
		}
		
		this.is_exist = new select_where().is_exist(this.sdata, this.table_nm);
		
		if(this.is_exist) {
			this.pw.write("<script>"
					+ "alert('정상적으로 로그인 되었습니다.');"
					+ "location.href='./main.jsp';"
					+ "</script>");
		}
	}

}
