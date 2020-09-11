//package org.example.security;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class PasswordEncoderImpl implements PasswordEncoder {
//
//    @Override
//    public String encode(CharSequence charSequence) {
//        return charSequence.toString();
//    }
//
//    @Override
//    public boolean matches(CharSequence charSequence, String s) {
//        return charSequence.toString().equals(s);
//    }
//
//    @Override
//    public boolean upgradeEncoding(String encodedPassword) {
//        return false;
//    }
//}
