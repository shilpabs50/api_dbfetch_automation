package api;


import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import utils.ConfigManager;


public class UserAPI {

	public static Response CreateUser(String payload) {
		
    return	given()
    		.log().all()
					.baseUri(ConfigManager.get("base.url"))
					.header("Content-Type", "application/json")
					.header("x-api-key", ConfigManager.get("x-api-key"))
					.body(payload)
				.when()
				.post("/api/users");
	
		
	}
	
	
	
}
