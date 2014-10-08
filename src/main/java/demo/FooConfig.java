package demo;

import demo.conf.AutowireCandidateResolverConfigurer;
import demo.conf.MyAutowireCandidateResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class FooConfig {

    @Autowired
    Environment environment;

    @Bean
    public Foo foo() {
        String message = "Environment was not injected!";
        if (environment != null) {
            message = environment.getProperty("foo.message");
        }
        return new Foo(message);
    }

    @Bean
    public static AutowireCandidateResolver autowireCandidateResolver() {
        return new MyAutowireCandidateResolver();
    }

    // FIXME: After commenting this bean all is working!
    @Bean
    public static AutowireCandidateResolverConfigurer autowireCandidateResolverConfigurer() {
        return new AutowireCandidateResolverConfigurer(autowireCandidateResolver());
    }
}
