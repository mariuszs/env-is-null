package demo;

import demo.conf.AutowireCandidateResolverConfigurer;
import demo.conf.MyAutowireCandidateResolver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class FooConfig implements BeanFactoryAware {

    private Environment environment;

    @Bean
    public Foo foo() {
        String message = "Environment was not injected!";
        if (environment != null) {
            message = environment.getProperty("foo.message");
        }
        return new Foo(message);
    }

    @Bean
    public AutowireCandidateResolver autowireCandidateResolver() {
        return new MyAutowireCandidateResolver();
    }

    @Bean
    public AutowireCandidateResolverConfigurer autowireCandidateResolverConfigurer() {
        return new AutowireCandidateResolverConfigurer(autowireCandidateResolver());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        environment = beanFactory.getBean(Environment.class);
    }
}
