package com.studyhuang.esdemo.annotation;

import java.lang.annotation.*;

/**
 * @author huang1996
 * @date 2021-01-30 21:46
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface EsId {
}
