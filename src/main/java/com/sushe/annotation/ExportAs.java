package com.sushe.annotation;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExportAs {
    Class<?> value(); // 目标导出类，例如 AdminExport.class
}

