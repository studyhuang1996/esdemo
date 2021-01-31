package com.studyhuang.esdemo.utils;

/**
 * @author huang1996
 * @date 2021-01-30 22:04
 */

public class IndexInfo {

    private String indexName;

    private String indexType;

    public IndexInfo() {
    }

    public IndexInfo(String indexName, String indexType) {
        this.indexName = indexName;
        this.indexType = indexType;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public String getIndexName() {
        return indexName;
    }

    public String getIndexType() {
        return indexType;
    }
}
