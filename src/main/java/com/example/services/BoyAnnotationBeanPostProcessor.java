package com.example.services;

import com.example.annotation.Log;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class BoyAnnotationBeanPostProcessor  implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        /**
         * 利用Java反射机制注入属性
         */
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        System.out.println(beanName);
        for (Field declaredField : declaredFields) {
            Log annotation = declaredField.getAnnotation(Log.class);
            if (null == annotation) {
                continue;
            }
            declaredField.setAccessible(true);
            try {
                declaredField.set(bean, annotation.name());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
