package com.rizvankarimov.springboot.junit5mavenstarter.assertjTest;

public class MailServerUnavailableException extends Exception {
    public MailServerUnavailableException(String test) {
        super(test);
    }
}
