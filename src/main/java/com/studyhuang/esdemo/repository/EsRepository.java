package com.studyhuang.esdemo.repository;

import org.elasticsearch.index.query.QueryBuilder;

import java.util.List;

/**
 * @author huang1996
 * @date 2021-01-30 21:55
 */
public interface EsRepository<T,M> {

    /**
     * 新增索引
     * @param t 索引pojo
     */
    public boolean save(T t) throws Exception;
    /**
     * 非分页查询
     * @param queryBuilder 查询条件
     * @param clazz 索引pojo类类型
     * @return
     * @throws Exception
     */
    public List<T> search(QueryBuilder queryBuilder, Class<T> clazz) throws Exception;

    /**
     * id数据是否存在
     * @param id 索引数据id值
     * @param clazz 索引pojo类类型
     * @return
     */
    public boolean exists(M id,Class<T> clazz) throws Exception;
}
