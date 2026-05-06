package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import utils.ConfigManager;

public class DBUtils {
	
	
	public static Connection getConnection() throws SQLException {
		
		
		//jdbc:postgresql://<host>:<port>/<database>
		// Connect to this remote PostgreSQL database 
		//jdbc → Java Database Connectivity
		//postgresql → DB type
		//db.tmupeegqodixflvmtvdu.supabase.co → Supabase host
		//5432 → default PostgreSQL port
		//postgres → database name
		
		
	
		String url = ConfigManager.get("db.connectionString");
		
		Properties props = new Properties();
		props.setProperty("user",ConfigManager.get("db.user"));
		props.setProperty("password", ConfigManager.get("db.password"));
		//props.setProperty("ssl", "true");
		props.setProperty("sslmode", ConfigManager.get("db.sslmode")); // FIX
		
		return DriverManager.getConnection(url,props);
		
		
	}
	
	
	// 🔹 2. Generic INSERT/UPDATE/DELETE
    public static int executeUpdate(String query, Object... params) throws Exception {

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(query);

        setParams(ps, params);

        int rows = ps.executeUpdate();
        System.out.println("Rows affected: " + rows);

        return rows;
    }
    
    
 // 🔹 3. Generic SELECT (single value)
    public static String getSingleData(String query, Object... params) throws Exception {

        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(query);

        setParams(ps, params);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString(1); // first column
        }

        return null;
    }
    
    

    // 🔹 5. Business-specific method (optional)
    public static void insertUser(String id, String name, String job) throws Exception {

        String query = "INSERT INTO users (id, name, job) VALUES (?, ?, ?)";
        executeUpdate(query, id, name, job);
    }
    

    public static String getUserName(String id) throws Exception {

        String query = "SELECT name FROM users WHERE id = ?";
        return getSingleData(query, id);
    }
    
    
    
    
    private static void setParams(PreparedStatement ps, Object... params) throws Exception {

        if (params == null) {
            System.out.println("Params are null!");
            return;
        }

        for (int i = 0; i < params.length; i++) {
            System.out.println("Setting param " + (i+1) + " = " + params[i]);
            ps.setObject(i + 1, params[i]);
        }
    }

}
