package com.studyhuang.esdemo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;


/**
 * @author huang1996
 * @date 2021-01-30 22:41
 */
public class JsonMapper {

    private static final Logger logger = LogManager.getLogger(JsonMapper.class);

  //  public static final JsonMapper INSTANCE = new JsonMapper();


    private static   ObjectMapper objectMapper = new ObjectMapper();


    static{
        //ObjectMapper忽略多余字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static <T> String obj2String(T obj){
        if (obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static JsonMapper defaultMapper() {
        return new JsonMapper();
    }



    public <T> T fromJson(@Nullable String jsonString, Class<T> clazz) {
        if (StringUtils.isEmpty(jsonString)) {
            return null;
        }

        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            logger.warn("parse json string error:" + jsonString, e);
            //throw ExceptionUtil.unchecked(e);
            return null;
        }
    }

    public String toJson(Object object) {

        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            logger.warn("write to json string error:" + object, e);
        //    throw ExceptionUtil.unchecked(e);
            return null;
        }
    }

}
