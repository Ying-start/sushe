package com.sushe.util;



import com.github.pagehelper.PageHelper;
import com.sushe.po.BasePageRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PageAspect {

    // 定义切点：所有标注了 @PageQuery 的方法
    @Pointcut("@annotation(com.sushe.annotation.PageQuery)")
    public void pagePointCut() {
    }

    /**
     * 前置通知：在目标方法执行前，设置分页参数
     */
    @Before("pagePointCut()")
    public void before(JoinPoint joinPoint) {
        // 获取方法的所有参数
        Object[] args = joinPoint.getArgs();

        // 遍历参数，寻找继承了 BasePageRequest 的参数对象
        for (Object arg : args) {
            if (arg instanceof BasePageRequest) {
                BasePageRequest pageRequest = (BasePageRequest) arg;

                // 核心：启动 PageHelper
                // PageHelper 使用 ThreadLocal，必须在 SQL 执行前调用
                if (pageRequest.getPage() != null && pageRequest.getLimit() != null) {
                    PageHelper.startPage(pageRequest.getPage(), pageRequest.getLimit());
                }
                break; // 找到一个分页参数对象即可停止
            }
        }
    }

    /**
     * 后置通知：无论是否异常，清理 ThreadLocal
     * 虽然 PageHelper 在 execute 后会自动清理，但为了保险起见，建议手动清理
     */
    @After("pagePointCut()")
    public void after() {
        PageHelper.clearPage();
    }
}
