package demo.conf;

import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;

public class MyAutowireCandidateResolver extends ContextAnnotationAutowireCandidateResolver {

    @Override
    protected Object buildLazyResolutionProxy(DependencyDescriptor descriptor, String beanName) {
        return super.buildLazyResolutionProxy(descriptor, beanName);
    }


}
