//package com.gsom.Security;
//
//import com.gsom.Entity.User;
//import com.gsom.Repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    private Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);
//
//    private UserRepository userRepository;
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();
//
//        DefaultOAuth2User oAuth2User = (DefaultOAuth2User) delegate.loadUser(userRequest);
//
//        logger.info(userRequest.getClientRegistration().toString());
//        logger.info(oAuth2User.toString());
//
//        String registrationId = userRequest.getClientRegistration().getRegistrationId();
//        String clientId = userRequest.getClientRegistration().getClientId();
//
//        User user = userRepository.findByOauthRegistrationIdAndOauthClientId(registrationId, clientId);
//
//        if (user == null) {
//            user = new User();
//            user.setOauthRegistrationId(registrationId);
//            user.setOauthClientId(clientId);
//            user.setName(oAuth2User.getAttribute("login"));
//            userRepository.save(user);
//
//            logger.info("Created user : " + user.toString());
//        }
//
//        logger.info(String.format("User #%d logged in", user.getId()));
//
//        SecurityUser securityUser = new SecurityUser();
//
//        securityUser.setOAuth2User(oAuth2User);
//        securityUser.setUser(user);
//
//        return securityUser;
//    }
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//}
