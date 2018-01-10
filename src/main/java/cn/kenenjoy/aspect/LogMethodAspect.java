package cn.kenenjoy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by hefa on 2018/1/10.
 */
@Aspect
@Component
public class LogMethodAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogMethodAspect.class);

    @Pointcut("execution(public * cn.kenenjoy.controller..*.*(..))")
    public void controllerPoint() {

    }

    @Before("controllerPoint()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();// 获取被拦截的方法
        String methodName = method.getName();// 获取被拦截的方法方法名
        logger.info("方法名：" + methodName + " 参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "controllerPoint()", returning = "result")
    public void doAroundAdvice(JoinPoint joinPoint, String result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();// 获取被拦截的方法
        String methodName = method.getName();// 获取被拦截的方法方法名
        logger.info("方法名：" + methodName + " 请求参数：" + Arrays.toString(joinPoint.getArgs()));
        logger.info("方法名：" + methodName + " 返回参数：" + result);
    }

}
