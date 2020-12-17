package com.iesvi.password;

public interface PasswordService {

    String hash(String input);

    String algorithm();

}