package kz.greetgo.diploma.register.beans.prod;

import java.io.IOException;
import java.util.EnumSet;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kz.greetgo.depinject.core.Bean;

@Bean
public class ForwardFilter implements Filter {

  public void register(ServletContext ctx) {
    FilterRegistration.Dynamic dynamic = ctx.addFilter(getClass().getName(), this);
    dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
  }
  
  @Override
  public void init(FilterConfig filterConfig) {
  }

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest directRequest,
                       ServletResponse directResponse,
                       FilterChain chain)
    throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) directRequest;
    HttpServletResponse response = (HttpServletResponse) directResponse;

    if (needDirect(request.getRequestURI())) {
      chain.doFilter(directRequest, directResponse);
    } else {
      request.getRequestDispatcher("/index.html").forward(request, response);
    }


  }

  private boolean needDirect(String requestURI) {
    if (requestURI == null) {
      return true;
    }

    if (requestURI.endsWith(".js")) {
      return true;
    }

    if ("/favicon.ico".equals(requestURI)) {
      return true;
    }

    if (requestURI.endsWith(".css")) {
      return true;
    }

//    FONTS
    if (requestURI.endsWith(".woff")
      || requestURI.endsWith(".woff2")
      || requestURI.endsWith(".eot")
      || requestURI.endsWith(".ttf")) {
      return true;
    }

    if (requestURI.startsWith("/assets/")) {
      return true;
    }

    if (requestURI.startsWith("/api/")) {
      return true;
    }

    return false;
  }
} 
