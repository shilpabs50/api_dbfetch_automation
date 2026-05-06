package tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.UserAPI;
import db.DBUtils;
import io.restassured.response.Response;
import utils.ConfigManager;

public class UserTest {

	@Test
	public void testAPI_DB_Validation() throws Exception {

	
	    	
	    	String name = ConfigManager.get("user.name");
	    	String job = ConfigManager.get("user.job");

	    	String payload = "{ \"name\": \"" + name + "\", \"job\": \"" + job + "\" }";

	        Response response = UserAPI.CreateUser(payload);
	        response.then().statusCode(201);

	        String responseId = response.jsonPath().getString("id");
	        String responseName = response.jsonPath().getString("name");

	        System.out.println("ID: " + responseId);
	        System.out.println("Name: " + responseName);
	        
	        //Insert data
	        DBUtils.insertUser(responseId, responseName, job);	        
	        
	        //fetch data
	        String nameFromDB = DBUtils.getUserName(responseId);
	        
	        System.out.println("Name present in the DB  "+nameFromDB);
	        
	        Assert.assertEquals(name, nameFromDB,"Mismatch between API response and data stored in the DB");
	        
	        
	        

//	        /*// DB Connection
//	        Connection con = DBUtils.getConnection();
//	        System.out.println("Connected to DB");
//
//	        // Insert
//	        PreparedStatement ps = con.prepareStatement(
//	                "INSERT INTO users (id, name, job) VALUES (?, ?, ?)");
//
//	        ps.setString(1, responseId);
//	        ps.setString(2, responseName);
//	        ps.setString(3, "QA");
//
//	        int rows = ps.executeUpdate();
//	        System.out.println("Rows inserted: " + rows);
//
//	        // Fetch
//	        PreparedStatement ps2 = con.prepareStatement(
//	                "SELECT name FROM users WHERE id = ?");
//
//	        ps2.setString(1, responseId);
//	        ResultSet rs = ps2.executeQuery();
//
//	        if (rs.next()) {
//	            String dbName = rs.getString("name");
//	            System.out.println("DB Name: " + dbName);
//
//	            Assert.assertEquals(name, dbName);
//	        } else {
//	            Assert.fail("No data found in DB");
//	        }
//
//	    } catch (Exception e) {
//	        e.printStackTrace();   // 🔥 THIS IS KEY
//	        Assert.fail("Test failed due to exception");
//	    }*/
//	    */
//	    
//	    
	    
	
	
	}

}
