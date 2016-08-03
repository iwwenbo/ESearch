package com.es.service;

import java.util.List;

/**
 * Created by iwwenbo on 2016/7/27.
 * 搜索服务接口
 */
public interface IRxSearchService {

    /**
     * 根据关键字进行搜索的方法
     * @param keyWords 关键字
     * @return 返回搜索结果
     */
    public List<String> doSearchByKeyWords(String keyWords);
}
