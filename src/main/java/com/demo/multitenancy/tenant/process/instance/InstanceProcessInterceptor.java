package com.demo.multitenancy.tenant.process.instance;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Service("instanceInterceptor")
public class InstanceProcessInterceptor extends HandlerInterceptorAdapter {

  private static final String INSTANCE_HEADER = "X-InstanceID";

  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
      throws Exception {

    String instanceProcess = req.getHeader(INSTANCE_HEADER);
    boolean instanceSet = false;

    if(StringUtils.isEmpty(instanceProcess)) {
      res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      res.setContentType(MediaType.APPLICATION_JSON_VALUE);
      res.getWriter().write("{\"error\": \"No instance process supplied\"}");
      res.getWriter().flush();
    } else {
      InstanceProcessContext.setCurrentInstance(instanceProcess);
      instanceSet = true;
    }

    return instanceSet;
  }

  @Override
  public void postHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
          throws Exception {
	  InstanceProcessContext.clear();
  }
}