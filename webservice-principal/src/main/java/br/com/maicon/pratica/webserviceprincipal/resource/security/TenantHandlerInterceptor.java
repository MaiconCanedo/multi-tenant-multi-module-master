package br.com.maicon.pratica.webserviceprincipal.resource.security;

import br.com.maicon.pratica.webserviceprincipal.model.exception.BadRequestExecption;
import br.com.maicon.pratica.webserviceprincipal.model.persistence.config.TenantContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TenantHandlerInterceptor implements HandlerInterceptor {

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
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        TenantContext.clear();
        if (response.getStatus() == 200 || response.getStatus() == 201) {
            System.out.println("Sucesso!!");
        }
    }
}
