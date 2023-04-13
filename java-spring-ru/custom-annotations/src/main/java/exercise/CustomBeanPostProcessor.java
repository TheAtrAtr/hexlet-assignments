package exercise;

import java.lang.reflect.Proxy;

import exercise.calculator.CalculatorImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// BEGIN
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorImpl.class);
    private final Map<String, Class> annotatedBeans = new HashMap<>();
    private final Map<String, String> logLevels = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        boolean b = bean.getClass().isAnnotationPresent(Inspect.class);
        if (b) {
            annotatedBeans.put(beanName, Inspect.class);
            logLevels.put(beanName, bean.getClass().getAnnotation(Inspect.class).level());
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (annotatedBeans.get(beanName) != null) {
            var proxy1 = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), ((proxy, method, args) -> {
                        if ((logLevels.get(beanName)).equalsIgnoreCase("info")) {
                            LOGGER.info((String.format("Was called method: %s() with arguments: [%d, %d]", method.getName(), args[0], args[1])));
                        } else if ((logLevels.get(beanName)).equalsIgnoreCase("debug")) {
                            LOGGER.debug((String.format("Was called method: %s() with arguments: [%d, %d]", method.getName(), args[0], args[1])));
                        } else {
                            throw new RuntimeException("Unsupported level log");
                        }
                        return method.invoke(bean, args);
                    })
            );
            return BeanPostProcessor.super.postProcessAfterInitialization(proxy1, beanName);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
// END



