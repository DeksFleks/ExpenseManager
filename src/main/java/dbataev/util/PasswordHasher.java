package dbataev.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hashPassword(String pwd){
        return encoder.encode(pwd);
    }
    public static boolean checkPassword(String pwd, String hash){
        return encoder.matches(pwd, hash);
    }
}
