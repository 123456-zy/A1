package build;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
public class DBUtill implements SqlDao{
	
	final private String url="jdbc:mysql://localhost:3306/jspdemo?"+
	"serverTimezone=UTC&useSSL=false";
	final private String user="root";
	final private String pwd="123456";
	final private String driver="com.mysql.cj.jdbc.Driver";
	Connection conn;
	public static void main(String[] args) {
		new DBUtill();
	}
	
	public DBUtill(){
		try {
			//加载类
			Class.forName(driver);
			//链接数据库
			conn=DriverManager.getConnection(url,user,pwd);
			//预处理sql语句
			String Sql="insert into logintable values(?,?)";
			int resultint=this.insertexecute(Sql,new String[] {"361","134","362","321"});
			System.out.print(resultint);
//			PreparedStatement stmt=conn.prepareStatement(
//					"select * from logintable");
//			Map<String,String> values=new HashMap<>();
//			values.put("username"," 356");
////			stmt.setString(1,"356");
//			ResultSet rs=stmt.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getString("username"));
//				System.out.println(rs.getString("password"));
//			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ResultSet selectexecute(String Sql, Map<String, String> values) {
		PreparedStatement stmt;
		try {
			//Sql='select * from logintable where username=?'
//			stmt = conn.prepareStatement(Sql);
			StringBuffer stb=new StringBuffer(Sql+" where ");
			
			for(Map.Entry<String,String> entry:values.entrySet()) {
				if(values!=null) {
					stb.append("where");
					boolean flag=true;
					stb.append(entry.getKey()+"='"+entry.getValue()+"' ");
				}
				stb.append("and"+ entry.getKey()+"='"+entry.getValue()+"' ");
			}
			stmt=conn.prepareStatement(Sql);
//			stmt.setString(1, "356");
			return stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}
	
	public int insertexecute(String Sql, String arg[]) {
		// TODO 自动生成的方法存根
		PreparedStatement stmt;
		try {
			stmt=conn.prepareStatement(Sql);
			for(int i=0;i<arg.length;i++)
			stmt.setString(1, arg[1]);
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
	

	@Override
	public int insertexecute(String Sql, Map<String, String> values) {
		// TODO 自动生成的方法存根
		return 0;
	}
}
	