package com.es.util;

import org.elasticsearch.index.query.QueryStringQueryBuilder;

/**
 * Created by iwwenbo on 2016/8/3.
 * 功能:Elasticsearch进行query操作的构建工具类
 */
public class QueryBuildUtil {


    /**
     * 根据条件构建QueryStringQueryBuilder：
     *
     * @param queryString 要查询的字符串
     * @param queryField  对应的搜索引擎字段
     * @return QueryStringQueryBuilder
     */
    public QueryStringQueryBuilder getQueryStringQueryBuilder(String queryString, String queryField) {
        return new QueryStringQueryBuilder(queryString).defaultField(queryField);
    }
}
