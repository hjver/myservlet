package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;

public class insert_data {
	
	Connection con = null;
	PreparedStatement ps = null;
	dbconnet db = new dbconnet();
	String sql = "";
	int result = 0;

	public int insert(ArrayList<String> sdata, String table_nm) {
		
		String placeholders = String.join(",", Collections.nCopies(sdata.size(), "?"));
		this.sql = "insert into "+table_nm+" value ('0',"+placeholders+", now())";
		
		try {
			this.con = db.getConnection();
			this.ps = this.con.prepareStatement(this.sql);
			for(int i=0; i<sdata.size(); i++) {
				this.ps.setString(i+1, sdata.get(i));
			}
			this.result = this.ps.executeUpdate();
		}catch (Exception e) {
			//System.out.println(e);
			this.result = 0;
		}finally {
			try {
				this.ps.close();
				this.con.close();
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
		return result;
	}
}
