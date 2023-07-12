package com.example.siliconvalley_prvtd_lmtd.exceptionBox.interceptor;
import com.example.siliconvalley_prvtd_lmtd.exceptionBox.response.Response;
import com.example.siliconvalley_prvtd_lmtd.exceptionBox.response.ResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResponseInterceptor implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        return returnType.getParameterType().equals(Response.class);

    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> converterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {


            return Response.builder().data(body).build();

    }
}
