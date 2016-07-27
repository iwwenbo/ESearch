package com.es.action;

import com.es.service.IRxSearchService;

/**
 * Created by iwwenbo on 2016/7/27.
 */
public class RxSearchAction {

    private IRxSearchService rxSearchService;

    /**
     * 进行搜索的方法
     */
    private void doSearchPage(){
        System.out.println("正在进行搜索。。。");
    }

    public IRxSearchService getRxSearchService() {
        return rxSearchService;
    }

    public void setRxSearchService(IRxSearchService rxSearchService) {
        this.rxSearchService = rxSearchService;
    }
}
