package io.github.bhuwanupadhyay.jdbc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> employeeRoutes(EmployeeWebHandler handler) {
        return route(GET("/employees/{employee_no}").and(accept(APPLICATION_JSON)), handler::getEmployee)
                .andRoute(GET("/employees").and(accept(APPLICATION_JSON)), handler::listEmployee)
                .andRoute(POST("/employees").and(contentType(APPLICATION_JSON)), handler::createEmployee);
    }

    @Bean
    public RouterFunction<ServerResponse> departmentRoutes(EmployeeWebHandler handler) {
        return route(GET("/departments/{dept_no}").and(accept(APPLICATION_JSON)), handler::getEmployee)
                .andRoute(GET("/departments").and(accept(APPLICATION_JSON)), handler::listEmployee)
                .andRoute(POST("/departments").and(contentType(APPLICATION_JSON)), handler::createEmployee);
    }


    /**
     * Make lazy initialization for all spring beans to increase startup time.
     */
    @Configuration
    public static class LazyInitBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            for (String beanName : beanFactory.getBeanDefinitionNames()) {
                beanFactory.getBeanDefinition(beanName).setLazyInit(true);
            }
        }

    }
}
