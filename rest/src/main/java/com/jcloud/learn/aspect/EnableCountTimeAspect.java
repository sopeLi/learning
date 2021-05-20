package com.jcloud.learn.aspect;

import com.jcloud.learn.annotion.EnableCountTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author lixin
 * @description:
 * @date Create in 20:28 2021/5/20
 */
@Component
@Aspect
public class EnableCountTimeAspect {

    @Around("@annotation(countTime)")
    public Object doAround(ProceedingJoinPoint pjp, EnableCountTime countTime) throws Throwable {
        long begin = System.currentTimeMillis();
        Object obj = pjp.proceed();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getSignature().getDeclaringTypeName();
        System.out.println(className + "." + methodName + " 方法消耗时间：" + (System.currentTimeMillis() - begin) + " ms");
        return obj;

    }
}
