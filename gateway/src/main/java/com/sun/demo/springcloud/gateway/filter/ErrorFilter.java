package com.sun.demo.springcloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.sun.demo.springcloud.gateway.enums.FilterTypeEnum;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class ErrorFilter extends ZuulFilter {

    private static final String ERROR_STATUS_CODE = "error.status_code";

    @Value("${cookie.key.token}")
    private String token;

    @Value("${cookie.key.userId}")
    private String userId;

    @Override
    public String filterType() {
        return FilterTypeEnum.ERROR.getValue();
    }

    // 定义filter的顺序，数字越小表示顺序越高，越先执行
    /**
     * zuul中默认实现的filter
         类型	顺序	过滤器	功能
         pre	-3	ServletDetectionFilter	标记处理Servlet的类型
         pre	-2	Servlet30WrapperFilter	包装HttpServletRequest请求
         pre	-1	FormBodyWrapperFilter	包装请求体
         route	1	DebugFilter	标记调试标志
         route	5	PreDecorationFilter	处理请求上下文供后续使用
         route	10	RibbonRoutingFilter	serviceId请求转发
         route	100	SimpleHostRoutingFilter	url请求转发
         route	500	SendForwardFilter	forward请求转发
         post	0	SendErrorFilter	处理有错误的请求响应
         post	1000	SendResponseFilter	处理正常的请求响应
     *
     * */
    @Override
    public int filterOrder() {
        return -4;
    }

    // 表示是否需要执行该filter，true表示执行，false表示不执行
    // filter生效策略
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // filter logic
    @Override
    public Object run() {

        RequestContext ctx = new RequestContext();
        String token = getCook(this.token);
        String userId = getCook(this.userId);
        if (token.isEmpty() || userId.isEmpty()) {
            ctx.setSendZuulResponse(false);
            ctx.put(ERROR_STATUS_CODE, HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        if (!validationTokenIsActive()) {
            ctx.setSendZuulResponse(false);
            ctx.put(ERROR_STATUS_CODE, HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }

        ctx.put(ERROR_STATUS_CODE, HttpServletResponse.SC_OK);
        ctx.setSendZuulResponse(true);
        return null;
    }

    // validation UserId and Token relation and token time from cacheDB
    protected Boolean validationTokenIsActive() {
        return Boolean.FALSE;
    }

    private String getCook(String key) {
        String value = "";
        try {
            value = Arrays.stream(new RequestContext().getRequest().getCookies())
                    .filter(c -> c.getName().equals(key))
                    .findFirst()
                    .map(Cookie::getValue).orElse("");
        } catch (NullPointerException e) {

        }
        return value;
    }
}
