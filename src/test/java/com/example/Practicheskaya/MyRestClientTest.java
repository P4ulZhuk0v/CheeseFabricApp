package com.example.Practicheskaya;

import com.example.Practicheskaya.utils.MyRestClient;
import com.example.Practicheskaya.utils.DateParser;
import org.junit.jupiter.api.Test;

public class MyRestClientTest {

    @Test
    public void testConnection(){
        MyRestClient restClient = new MyRestClient();
        restClient.getConnection(DateParser.getLocalDate());
    }



}
