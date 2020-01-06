package com.blogger.blogcast.exception;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String message){
        super(message);
    }
}
