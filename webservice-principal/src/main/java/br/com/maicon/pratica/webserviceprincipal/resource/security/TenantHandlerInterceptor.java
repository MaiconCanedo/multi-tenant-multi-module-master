package br.com.maicon.pratica.webserviceprincipal.resource.security;

import br.com.maicon.pratica.webserviceprincipal.model.exception.BadRequestExecption;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.config.TenantContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TenantHandlerInterceptor extends HandlerInterceptorAdapter {

    private static final String TENANT_HEADER_NAME = "DataBaseId";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        String tenantId = request.getHeader(TENANT_HEADER_NAME);
        if (tenantId == null || tenantId.trim().length() < 1)
            throw new BadRequestExecption("Header " + TENANT_HEADER_NAME + " não informado");
        TenantContext.setTenantId(tenantId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) {
        TenantContext.clear();
    }
}
