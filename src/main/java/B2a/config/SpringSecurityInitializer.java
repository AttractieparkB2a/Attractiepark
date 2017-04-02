package B2a.config;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public SpringSecurityInitializer() {
        super(SecurityConfig.class);
    }
}
