package com.es.action;

import com.es.service.IRxSearchService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by iwwenbo on 2016/7/27.
 */

@Controller
@Scope("prototype")
public class RxSearchAction extends ActionSupport {
    //搜索关键字
    private String keyWords;

    @Autowired
    private IRxSearchService rxSearchService;

    /**
     * 跳转到搜索页面
     */
    public  String doSearchPage(){
        return "success";
    }

    /**
     * 根据关键字进行搜索
     * @return
     */
    public String doSearch(){
        rxSearchService.doSearchByKeyWords(keyWords);
        return "success";
    }

    public IRxSearchService getRxSearchService() {
        return rxSearchService;
    }

    public void setRxSearchService(IRxSearchService rxSearchService) {
        this.rxSearchService = rxSearchService;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
