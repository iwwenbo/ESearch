package com.es.service.impl;

import com.es.service.IRxSearchService;
import com.es.util.QueryBuildUtil;
import com.es.util.SearchUtil;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by iwwenbo on 2016/7/27.
 */
@Service
public class RxSearchServiceImpl  implements IRxSearchService{
    private Client searchUtil;
    //默认索引
    private static final String DEFAULT_SEARCH_TYPE="hhtwsyyt-fwqq";
    QueryBuildUtil queryBuildUtil = new QueryBuildUtil();

    /**
     * 根据关键字进行搜索的方法
     * @return
     */
    public List<String> doSearchByKeyWords(String keyWords) {
        System.out.println("正在对关键字："+keyWords+" 进行搜索");
        System.out.println(searchUtil);
        //searchUtil = SearchUtil.getElasticClient("es-cluster","172.21.142.162:9300");
        //根据查询字符串构建QueryStringQueryBuilder，这里只是根据关键字到搜索引擎的content字段进行匹配查询
        QueryStringQueryBuilder stringQueryBuilder = queryBuildUtil.getQueryStringQueryBuilder(keyWords,"content");
        System.out.println(stringQueryBuilder.toString()+"--000");
        //根据stringQueryBuilder进行查询
        SearchRequestBuilder searchRequestBuilder = searchUtil.prepareSearch().setTypes(DEFAULT_SEARCH_TYPE).setQuery(stringQueryBuilder);
        //打印一下构建的查询条件
        System.out.println(searchRequestBuilder.toString());
        //根据搜索的条件获得响应的searchResponse
        SearchResponse searchResponse = searchRequestBuilder.execute().actionGet();
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHits = hits.getHits();
        HashMap<String,Object> sourceMap = null;
        List<String> returnList = new ArrayList<>();
        System.out.println(searchHits.length+"-----------length");
        if(searchHits.length>0){
            for (SearchHit hit:searchHits){
                sourceMap = (HashMap<String,Object>)hit.getSource();
                System.out.println((String)sourceMap.get("content"));
                returnList.add((String)sourceMap.get("content"));
            }
        }
        return returnList;
    }


    public Client getSearchUtil() {
        return searchUtil;
    }

    public void setSearchUtil(Client searchUtil) {
        this.searchUtil = searchUtil;
    }
}
