package com.swarn.assignment.factory;

/**
 * @author Swarn Singh.
 */
public class Test {
    public static void main(String[] args) {
        Authentication authentication = AuthenticationFactory.getAuthenticationProvider("Google");
        authentication.authenticate();
    }
}
