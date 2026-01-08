package com.sushe.util;

import com.sushe.annotation.ExportAs;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@Order(1)
public class ExportCopyAspect {

    @Around("@annotation(exportAs)")
    public Object around(ProceedingJoinPoint pjp, ExportAs exportAs) throws Throwable {
        //执行原方法
        Object ret = pjp.proceed();
        if (ret == null) return null;

        if (!(ret instanceof List)) {
            return ret; // 只处理 List
        }

        List<?> list = (List<?>) ret;
        //获取目标类
        Class<?> targetClass = exportAs.value();

        //复制后的返回数据
        List<Object> out = new ArrayList<>(list.size());

        for (Object src : list) {
            if (src == null) continue;

            Object target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(src, target);  // 同名属性复制；源里多的属性(如page/limit)会自动忽略
            out.add(target);
        }
        return out;
    }
}

