package com.es.util;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.lang3.StringUtils;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * Created by iwwenbo on 2016/7/27.
 * 搜索引擎工作类：用于Elasticsearch获取连接
 */
public class SearchUtil {

    /**
     * 创建Client的方法：支持多个地址
     * @param clusterName 参数,集群
     * @param url 地址
     * @return client
     */
    public static Client getElasticClient(String clusterName, String url) {
        //对配置文件中提供的多个url进行拆分
        String[] brokers = url.split(",");
        ImmutableSettings.settingsBuilder().build();
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("iwwenbo-es", clusterName)
                .build();
        //根据settings创建clent实例
        TransportClient client = new TransportClient(settings);
        if (brokers.length > 0) {
            for (String u : brokers) {
                if (StringUtils.isNotBlank(u)) {
                    String[] elem = u.trim().split(":");
                    //添加所有地址
                    client.addTransportAddress(new InetSocketTransportAddress(elem[0], Integer.parseInt(elem[1])));
                }
            }
        }
        return client;
    }
}
