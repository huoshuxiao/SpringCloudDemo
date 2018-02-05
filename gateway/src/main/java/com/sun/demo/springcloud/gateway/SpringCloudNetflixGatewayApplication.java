package com.sun.demo.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudNetflixGatewayApplication {

	// 定义filter的顺序，数字越小表示顺序越高，越先执行
	/**
	 * zuul中默认实现的filter
	 类型	顺序	过滤器	功能
	 pre	-3	ServletDetectionFilter	标记处理Servlet的类型
	 pre	-2	Servlet30WrapperFilter	包装HttpServletRequest请求
	 pre	-1	FormBodyWrapperFilter	包装请求体
	 pre	1	DebugFilter	标记调试标志
	 pre	5	PreDecorationFilter	处理请求上下文供后续使用       (默认加载)
	 route	10	RibbonRoutingFilter	serviceId请求转发			   (默认加载)
	 route	100	SimpleHostRoutingFilter	url请求转发
	 route	500	SendForwardFilter	forward请求转发
	 post	0	SendErrorFilter	处理有错误的请求响应
	 post	900	LocationRewriteFilter	重定向Header到Zuul url
	 post	1000	SendResponseFilter	处理正常的请求响应
	 *
	 * */

//	@Bean
//	public ZuulFilter tokenFilter() {
//		return new TokenFilter();
//	}

/*
	// 在请求被路由之前调用
	// 实现身份验证、在集群中选择请求的微服务、记录调试信息等
	@Bean
	public ZuulFilter preFilter() {
		return new PreFilter();
	}

	// 将请求路由到微服务时调用
	// 用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务
	@Bean
	public ZuulFilter routingFilter() {
		return new RoutingFilter();
	}

	// 在路由到微服务以后执行
	// 用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等
	@Bean
	public ZuulFilter postFilter() {
		return new PostFilter();
	}

	// 发生错误时执行该过滤器，然后调用PostFilter
	@Bean
	public ZuulFilter errorFilter() {
		return new ErrorFilter();
	}

	// web request forward
	@Bean
	public ZuulFilter locationRewriteFilter() {
		return new LocationRewriteFilter();
	}
*/
	// 开启zuul.route动态化 for bus
	@RefreshScope
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties() {
		return new ZuulProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudNetflixGatewayApplication.class, args);
	}
}
