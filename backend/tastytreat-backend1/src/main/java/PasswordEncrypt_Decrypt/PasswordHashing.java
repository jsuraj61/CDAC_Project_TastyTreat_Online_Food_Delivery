package PasswordEncrypt_Decrypt;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHashing {
	
	public static String hashPassword(String password) {
	    String salt = BCrypt.gensalt(12);
	    String hashedPassword = BCrypt.hashpw(password, salt);
	    return hashedPassword;
	}
	
	
	
	public static boolean checkPassword(String password, String hashedPassword) {
	    return BCrypt.checkpw(password, hashedPassword);
	}


}
