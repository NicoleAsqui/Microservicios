package com.relatosdepapel.ms_books_catalog.controller;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.MainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthCheckController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @GetMapping("/elasticsearch")
    public String checkElasticsearch() {
        try {
            MainResponse response = restHighLevelClient.info(RequestOptions.DEFAULT);
            return "Conexión exitosa a Elasticsearch: " + response.getClusterName();
        } catch (Exception e) {
            return "Error al conectar a Elasticsearch: " + e.getMessage();
        }
    }
}