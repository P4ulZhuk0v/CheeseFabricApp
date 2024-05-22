package com.example.Practicheskaya;

import com.example.Practicheskaya.utills.MyRestClient;
import com.example.Practicheskaya.utills.DateParser;
import org.junit.jupiter.api.Test;

public class MyRestClientTest {

    @Test
    public void testConnection(){
        MyRestClient restClient = new MyRestClient();
        restClient.getConnection(DateParser.getLocalDate());
    }



}
