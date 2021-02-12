package tn.esprit.securingweb;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse  response = (HttpServletResponse)  servletResponse ;
        HttpServletRequest request = (HttpServletRequest)  servletRequest;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,DELETE,PUT");
        response.setHeader("Access-Control.Max.Age","3600");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with, authorization, x-auth-token, origin, content-type, accept");
          if("OPTIONS".equalsIgnoreCase(request.getMethod())){
              response.setStatus(HttpServletResponse.SC_OK);
          }else {
              filterChain.doFilter(request,response);
          }
    }

    @Override
    public void destroy() {

    }
}
