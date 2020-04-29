package com.assignment.factory;

public class AuthenticationFactory {

    public static Authentication getAuthenticationProvider(String provider) {
        switch (provider) {
            case "Google":
                return new GoogleAuthentication();
            case "Facebook":
                return new FacebookAuthentication();
            case "Microsoft":
                return new MicrosoftAuthentication();
            default:
                return null;
        }
    }
}
