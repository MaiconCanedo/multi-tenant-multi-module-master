package br.com.maicon.pratica.webserviceprincipal;

import br.com.maicon.pratica.webserviceprincipal.resource.security.TenantHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private TenantHandlerInterceptor tenantHandlerInterceptor;

    public WebConfig(TenantHandlerInterceptor tenantHandlerInterceptor) {
        this.tenantHandlerInterceptor = tenantHandlerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantHandlerInterceptor).addPathPatterns("/**");
    }
}

