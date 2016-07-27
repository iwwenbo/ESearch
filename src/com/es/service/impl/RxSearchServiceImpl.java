package com.es.service.impl;

import com.es.service.IRxSearchService;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by iwwenbo on 2016/7/27.
 */
public class RxSearchServiceImpl  implements IRxSearchService{
    @Autowired
    private Client searchUtil;
    //默认索引
    private static final String DEFAULT_SEARCH_INDEX="es-iwwenbo";

}
