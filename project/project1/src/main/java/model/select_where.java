package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class select_where {
	
	Connection con = null;
	PreparedStatement ps = null;
	dbconnet db = new dbconnet();
	String sql = "";
	ResultSet rs = null;
	
	public boolean is_exist(Map<String, String> sdata, String table_nm) {
		
		boolean is_exist = false;
		
		StringBuilder placeholders = new StringBuilder();
		for (Map.Entry<String, String> entry : sdata.entrySet()) {
	        if (placeholders.length() > 0) {
	            placeholders.append("&&");
	        }
	        placeholders.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
	    }
		
		this.sql = "select count(*) as cnt from "+table_nm+" where "+placeholders+"";
		
		try {
			this.con = this.db.getConnection();
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			if(this.rs.next()) {
				if(this.rs.getInt("cnt")==1) {
					is_exist = true;
				}
				else if(this.rs.getInt("cnt")==0) {
					is_exist = false;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return is_exist;
	}
}
