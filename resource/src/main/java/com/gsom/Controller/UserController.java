package com.gsom.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @CrossOrigin(origins = "*")
    @GetMapping("/user")
    public Principal getUser(Principal principal) {
        return principal;
    }

//    @GetMapping("/token")
//    public Map<String, String> token(HttpSession session) {
//        return Collections.singletonMap("token", session.getId());
//    }
//
//    @GetMapping("/user")
//    public SecurityUser user(@AuthenticationPrincipal SecurityUser securityUser) {
//        return securityUser;
//    }
}
