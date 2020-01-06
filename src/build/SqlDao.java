package build;

import java.sql.ResultSet;
import java.util.Map;
public interface SqlDao {
	
	
	/**
	 * 
	 * @param Sql
	 * @param values
	 * @return
	 */
	public ResultSet selectexecute(String Sql,Map<String,String>values);
	
	public int insertexecute(String Sql,Map<String,String>values);
}