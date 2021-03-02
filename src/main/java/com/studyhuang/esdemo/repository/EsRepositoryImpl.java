package com.studyhuang.esdemo.repository;

import com.studyhuang.esdemo.utils.IndexInfo;
import com.studyhuang.esdemo.utils.IndexUtils;
import com.studyhuang.esdemo.utils.JsonMapper;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author huang1996
 * @date 2021-01-30 21:58
 */
@Component
public class EsRepositoryImpl<T, M> implements EsRepository<T, M> {
    @Autowired
    private RestHighLevelClient client;


    public boolean save(T t) throws Exception {
        //通过 t的class获取，indexname名字，通过实体获取id，调用原生api保存实体
        IndexInfo indexInfo = IndexUtils.getIndexInfo(t.getClass());
        String indexname = indexInfo.getIndexName();
        String indextype = indexInfo.getIndexType();
        String id = IndexUtils.getEsId(t);
        IndexRequest indexRequest = null;
        if (StringUtils.isEmpty(id)) {
            indexRequest = new IndexRequest(indexname, indextype);
        } else {
            indexRequest = new IndexRequest(indexname, indextype, id);
        }

        String data = JsonMapper.obj2String(t);
        indexRequest.source(data, XContentType.JSON);

        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);

        return response.getResult() == DocWriteResponse.Result.CREATED;
    }

    public List<T> search(QueryBuilder queryBuilder, Class<T> clazz) throws Exception {
        return null;
    }

    public boolean exists(M id, Class<T> clazz) throws Exception {

        return false;
    }


}
