//package com.gsom.Security;
//
//import com.gsom.Entity.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//
//import java.util.Collection;
//import java.util.Map;
//
//public class SecurityUser implements OAuth2User {
//
//    private User user;
//    private OAuth2User oAuth2User;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public OAuth2User getOAuth2User() {
//        return oAuth2User;
//    }
//
//    public void setOAuth2User(OAuth2User oAuth2User) {
//        this.oAuth2User = oAuth2User;
//    }
//
//    @Override
//    public Map<String, Object> getAttributes() {
//        return oAuth2User.getAttributes();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return oAuth2User.getAuthorities();
//    }
//
//    @Override
//    public String getName() {
//        return oAuth2User.getName();
//    }
//}
