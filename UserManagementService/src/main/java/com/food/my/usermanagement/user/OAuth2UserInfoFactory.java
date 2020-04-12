package com.food.my.usermanagement.user;

import java.util.Map;

import com.food.my.usermanagement.model.AuthProvider;

public class OAuth2UserInfoFactory {
	
public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) throws Exception {
	
	if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
        return new GoogleOAuth2UserInfo(attributes);
    } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
        return new FacebookOAuth2UserInfo(attributes);
    } else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
        return new GithubOAuth2UserInfo(attributes);
    } else {
        throw new Exception("Sorry! Login with " + registrationId + " is not supported yet.");
    }
}

}
