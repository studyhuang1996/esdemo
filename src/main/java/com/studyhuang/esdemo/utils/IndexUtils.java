package com.studyhuang.esdemo.utils;

import com.studyhuang.esdemo.annotation.EsId;
import com.studyhuang.esdemo.annotation.EsIndex;

import java.lang.reflect.Field;

/**
 * @author huang1996
 * @date 2021-01-30 22:03
 */
public class IndexUtils {


    public static IndexInfo getIndexInfo(Class<?> clazz) {
        EsIndex indexAnnotate = clazz.getAnnotation(EsIndex.class);
        if (indexAnnotate != null) {
            String indexName = indexAnnotate.indexName();
            String indexType = indexAnnotate.indexType();
            return new IndexInfo(indexName, indexType);
        }
        return null;

    }

    public static String getEsId(Object obj) throws Exception {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            EsId esId = field.getAnnotation(EsId.class);
            if (esId != null) {
                Object value = field.get(obj);
                return value == null ? null : value.toString();
            }
        }
        return null;
    }
}
