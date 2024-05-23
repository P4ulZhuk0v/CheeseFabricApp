package com.example.Practicheskaya.utills;

import com.example.Practicheskaya.exeptions.ConnectionFailedExeption;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MyRestClient {

    private RestClient restClient;

    public Map<String, Double> getMatches() {
        return matches;
    }

    private Map<String, Double> matches;
    private String body;

    //getting connected and recieving html code
    public MyRestClient getConnection(String localDate){
        if(localDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            restClient = RestClient.builder().baseUrl("https://www.cbr.ru/currency_base/daily?UniDbQuery.Posted=True&UniDbQuery.To=" + localDate).build();
        }else{
            restClient = RestClient.builder().baseUrl("https://www.cbr.ru/currency_base/daily").build();
        }

        body = restClient.get().retrieve().body(new ParameterizedTypeReference<String>() {});
        if(body == null){
            try {
                throw new ConnectionFailedExeption("Your connection to server is not successful. Please, fix it to continue");
            } catch (ConnectionFailedExeption e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    public Map<String, Double> findOnSiteByPattern(){//(String pattern){
        matches = new HashMap<>();
        Pattern patternOfName = Pattern.compile("<td>[а-яА-Я ]+</td>");
        Matcher matcherOfName = patternOfName.matcher(body);
        Pattern patternOfValue = Pattern.compile("<td>\\d+,\\d+</td>");
        Matcher matcherOfValue = patternOfValue.matcher(body);

        while(matcherOfValue.find() && matcherOfName.find()){
            String name = matcherOfName.group();
            String value = matcherOfValue.group();

            name = name.substring(4, name.length()-5);
            value = value.substring(4, value.length()-5).replace(',', '.');
            Double doubleValue = Double.parseDouble(value);
            matches.put(name, doubleValue);
        }

        return matches;
    }
}
