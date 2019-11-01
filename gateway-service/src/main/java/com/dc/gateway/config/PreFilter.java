package com.dc.gateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author duanchao
 * @CreateDate: 2019/9/12 0012 16:23
 */
@Component
public class PreFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**执行过滤*/
    @Override
    public boolean shouldFilter() {
        return true;
    }

    private boolean ignoreCheck(String url){
        List<String> list = new ArrayList<>();
        list.add("/api/order/goods/find/id");

        if(list.contains(url)){
            return true;
        }
        return  false;
    }

    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String servletPath = request.getServletPath();


        log.info("方法={} >>>路径= {}，servletPath={}", request.getMethod(), request.getRequestURL().toString(),servletPath);
        boolean ignore = ignoreCheck(servletPath);
        String method = request.getMethod();
        if(ignore){
            return null;
        }

       


//        String access_token = request.getParameter("access_token");
//        if(StringUtils.isBlank(access_token) || !"test".equals(access_token)){
//            // zuul过滤该请求
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(401);
            requestContext.setResponseBody("token is invalid");
//            log.info("the request {} is fail, the token is invalid", request.getRequestURL().toString());
//        } else {
//            log.info("the request {} is ok", request.getRequestURL().toString());
//        }
        return null;
    }
}
