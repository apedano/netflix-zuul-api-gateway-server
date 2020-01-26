/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apedano.microservices.netflixzuulapigatewayserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alessandro
 */
@Component
public class ZuulLogginFilter extends ZuulFilter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ZuulLogginFilter.class);

    /**
     * Defines the lifecycle hook
     * 
     * pre - filter executed before the call
     * post - after the request has executed
     * error - only in case of error
     * @return 
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * If you have multiple filters, here you define the order
     * This is the first filter to execute
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     *
     * Defines wether the filter is executed or not depending on business logic.In this case the filter always executes
     *
     * @return 
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * What actually the filter does
     * @return
     * @throws ZuulException 
     */
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        LOGGER.info("Request received -> {}", request);
        LOGGER.info("Request URI -> {}", request.getRequestURI());
        return null;
    }

}
