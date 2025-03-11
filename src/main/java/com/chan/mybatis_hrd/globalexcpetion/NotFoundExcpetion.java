package com.chan.mybatis_hrd.globalexcpetion;

public class NotFoundExcpetion  extends RuntimeException {
    public NotFoundExcpetion(String message) {
        super(message);
    }
}
 