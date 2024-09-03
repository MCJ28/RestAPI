package api.Endpoints;

/*		Swagger :- https://petstore.swagger.io/
 
	Pet --> 	POST	    https://petstore.swagger.io/v2/pet
				GET	  		https://petstore.swagger.io/v2/pet/{petId}
 				UPDATE		https://petstore.swagger.io/v2/pet
 				DELETE		https://petstore.swagger.io/v2/pet/{petId}
 			
 	STORE ---> 	POST		https://petstore.swagger.io/v2/store/order
 				GET			https://petstore.swagger.io/v2/store/order/{orderID}
 				UPDATE		https://petstore.swagger.io/v2/store/order
 				DELETE		https://petstore.swagger.io/v2/store/order/{orderID}
 				
 	USER --->   POST 		https://petstore.swagger.io/v2/user
 	 			GET			https://petstore.swagger.io/v2/user/{username}
 	 			UPDATE		https://petstore.swagger.io/v2/user/{username} 
 	 			DELETE		https://petstore.swagger.io/v2/user/{username} 	

 */

public class Routes 
{
	//	URL for PET Module
	
	public static String basePet_URL = "https://petstore.swagger.io/v2";
	
	public static String PostPet_URL	 = basePet_URL+"/pet";
	public static String GetPet_URL		 = basePet_URL+"/pet/{petId}";
	public static String UpdatePet_URL	 = basePet_URL+"/pet";
	public static String DeletePet_URL   = basePet_URL+"/pet/{petId}";
	
	
	
	//	URL for Store Module
	
	public static String baseStore_url = "https://petstore.swagger.io/v2/";
	
	public static String PostStore_url 	    = baseStore_url+"store/order";
	public static String GetStore_url	 	= baseStore_url+"store/order/{orderID}";
	public static String UpdateStore_url    = baseStore_url+"store/order";
	public static String DeleteStore_url    = baseStore_url+"store/order/{orderID}";
	
	
	//	URL for User Module
	
	public static String baseUser_url = "https://petstore.swagger.io/v2/";
	
	public static String PostUser_Url 		= baseUser_url+"user";
	public static String GetUser_Url	    = baseUser_url+"user/{username}";
	public static String UpdateUser_Url 	= baseUser_url+"user/{username}";
	public static String DeleteUser_Url 	= baseUser_url+"user/{username}";	
}
