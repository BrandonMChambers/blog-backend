package com.blogger.blogcast.service;

import com.blogger.blogcast.model.BlogUser;
import com.blogger.blogcast.model.CustomUserDetails;
import com.blogger.blogcast.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

//    @Autowired
//    private BlogUserRepository blogUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<BlogUser> optionalBlogUser = blogUserRepository.findByUsername(username);
//
//        optionalBlogUser
//                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//        return optionalBlogUser
//                .map(CustomUserDetails::new).get();
        //Temp
        return new User("foo", "foo", new ArrayList<>());

//        BlogUser blogUser = blogUserRepository.findByUsername(username);
//
//        if (blogUser == null) {
//            throw new UsernameNotFoundException("User not found.");
//        }
//
//        return new PdfUserDetails(blogUser);
//
//        BlogUser blogUser = blogUserRepository.findByUsername(username);
//        if(blogUser == null){
//            throw new UsernameNotFoundException(username);
//        }
//

    }
}
