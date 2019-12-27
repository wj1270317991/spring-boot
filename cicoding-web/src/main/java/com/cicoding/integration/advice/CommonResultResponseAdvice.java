package com.cicoding.integration.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * com.cicoding.integration.advice
 *
 * @author wangjun
 * @date 2019/12/27 11:23 上午
 */
@ControllerAdvice("com.cicoding.integration.web")
public class CommonResultResponseAdvice implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Method method = returnType.getMethod();
        String name = method.getName();
        logger.info("method: {}",returnType.getMethod());
        return body;
    }
}
