package com.studyhuang.esdemo.annotation;

import java.lang.annotation.*;

/**
 * @author huang1996
 * @date 2021-01-30 21:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface EsIndex {

    String indexName();

    String indexType() default "_doc";

}
