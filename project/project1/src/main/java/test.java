import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
		new test_box().test();
	}
}

class test_box {
	
	public void test() {
		
		String table_nm = "shop";
		
	    StringBuilder placeholders = new StringBuilder();
	    Map<String, String> sdata = new HashMap<>();
	    sdata.put("sid", "khj67515");
	    sdata.put("snm", "홍길동");
	    sdata.put("sno", "12345");

	    for (Map.Entry<String, String> entry : sdata.entrySet()) {
	        if (placeholders.length() > 0) {
	            placeholders.append("&&");
	        }
	        placeholders.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
	    }

	    String sql = "select count(*) as cnt from "+table_nm+" where "+placeholders+"";
	    System.out.println(sql);
	}

}
