package com.gsom.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class UserController {


//    @GetMapping("/user")
//    public Principal getUser(Principal principal) {
//        return principal;
//    }

    @GetMapping("/api/token")
    public Map<String,String> token(HttpSession session) {
        return Collections.singletonMap("token", session.getId());
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
