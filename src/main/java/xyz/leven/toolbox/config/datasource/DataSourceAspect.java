package xyz.leven.toolbox.config.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;



@Order(1)
@Aspect
@Repository
public class DataSourceAspect {

    @Pointcut("execution(* xyz.leven.toolbox.service..*(..))")
    private void anyMethod() {
    }

    @AfterReturning(value = "anyMethod()", returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        DataSourceHolder.clearDataSourceType();
    }

    @Before(value="anyMethod()")
    public void before(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //如果方法体上使用了DataSource注解
        if (method.isAnnotationPresent(Ds.class)) {
            //获取该方法上的注解名
            Ds ds = method.getAnnotation(Ds.class);
            //将方法体上的注解的值赋予给DataSourceHolder数据源持有类
            DataSourceHolder.setDataSourceType(ds.value());
        }
    }

}
