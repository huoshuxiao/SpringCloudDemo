package com.sun.demo.feign.search;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class SearchClientFallbackFactory implements FallbackFactory<SearchClient> {

    @Override
    public SearchClient create(Throwable cause) {
        return new SearchClientFallback(cause);
    }
}
