//package com.gsom.Security;
//
//import com.gsom.Entity.User;
//import com.gsom.Repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.stereotype.Service;
//import org.springframework.util.Assert;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.List;
//
//@Service
//public class CustomUserDetailsManager implements UserDetailsManager {
//
//    private Logger logger = LoggerFactory.getLogger(CustomUserDetailsManager.class);
//
//    private UserRepository userRepository;
//
//    public CustomUserDetailsManager(UserRepository userRepository) {
//        this.userRepository = userRepository;
//
//        org.springframework.security.core.userdetails.User.UserBuilder builder =
//                org.springframework.security.core.userdetails.User.builder();
//
//        UserDetails admin = builder.username("admin")
//                .passwordEncoder(x -> passwordEncoder().encode(x))
//                .password("nhjkmuhjv")
//                .roles("USER", "ADMIN")
//                .accountExpired(false)
//                .accountLocked(false)
//                .disabled(false)
//                .build();
//
//        UserDetails testUser = builder.username("test_user")
//                .passwordEncoder(x -> passwordEncoder().encode(x))
//                .password("qwerty1")
//                .roles("USER")
//                .accountExpired(false)
//                .accountLocked(false)
//                .disabled(false)
//                .build();
//
//        createUser(admin);
//        createUser(testUser);
//    }
//
//    @Override
//    public void createUser(UserDetails userDetails) {
//
//        User user = userRepository.findByName(userDetails.getUsername());
//        Assert.isNull(user, "User with such name already exist");
//
//        logger.info("Creating user : " + userDetails.toString());
//
//        user = new User();
//        setDetailsToUser(userDetails, user);
//        userRepository.save(user);
//
//        logger.info("Created user : " + user.toString());
//    }
//
//    @Override
//    public void updateUser(UserDetails userDetails) {
//        User user = userRepository.findByName(userDetails.getUsername());
//        Assert.notNull(user, "User with such name does not exist");
//
//        setDetailsToUser(userDetails, user);
//        userRepository.save(user);
//
//        logger.info("Updated user : " + user.toString());
//    }
//
//    @Override
//    public void deleteUser(String s) {
//        User user = userRepository.findByName(s);
//        Assert.notNull(user, "User with such name does not exist");
//        userRepository.delete(user);
//
//        logger.info("Deleted user : " + user.toString());
//    }
//
//    @Override
//    public void changePassword(String s, String s1) {
//
//    }
//
//    @Override
//    public boolean userExists(String s) {
//        return userRepository.findByName(s) != null;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        logger.info("Trying to find user :" + s);
//
//        User user = userRepository.findByName(s);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User with such name does not exist");
//        }
//
//        return convertUserToDetails(user);
//    }
//
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    private void setDetailsToUser(UserDetails userDetails, User user) {
//        user.setName(userDetails.getUsername());
//        user.setPassword(userDetails.getPassword());
//        user.setLocked(!userDetails.isAccountNonLocked());
//        user.setExpired(!userDetails.isAccountNonExpired());
//        user.setDisabled(!userDetails.isEnabled());
//
//        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//        LinkedList<String> authoritiesList = new LinkedList<>();
//
//        for (GrantedAuthority authority : authorities) {
//            authoritiesList.add(authority.getAuthority());
//        }
//        user.setRoles(String.join(",", authoritiesList));
//    }
//
//    private UserDetails convertUserToDetails(User user) {
//        org.springframework.security.core.userdetails.User.UserBuilder builder =
//                org.springframework.security.core.userdetails.User.builder();
//
//        String[] roles = user.getRoles().split(",");
//
//        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
//
//        for (String role : roles) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
//        }
//
//        return builder.username(user.getName())
//                .password(user.getPassword())
//                .disabled(user.getDisabled())
//                .accountLocked(user.getLocked())
//                .accountExpired(user.getExpired())
//                .authorities(authorities)
//                .build();
//    }
//}
