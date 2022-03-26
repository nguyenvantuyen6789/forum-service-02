package com.tuyennguyen.productservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionCommon {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Map<String, String> conflictData() {
        Map<String, String> map = new HashMap<>();
        return null;
    }

}
