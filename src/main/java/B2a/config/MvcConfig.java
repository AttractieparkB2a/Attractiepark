package B2a.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class MvcConfig extends WebMvcConfigurationSupport {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/ticketOrder").setViewName("ticketOrder");
    }

}
