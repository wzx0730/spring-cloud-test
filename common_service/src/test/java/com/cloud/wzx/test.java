package com.cloud.wzx;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {

        String url = "https://club.jd.com/comment/productPageComments.action";
        int num = 1;
        ArrayList<Map> list = new ArrayList<>();
        List<Map> newList;
    while (true){
        System.out.println("开始所搜第"+num+"页");
        newList=getTargetData(url, num,10);
        if (newList.size()==0){
            System.out.println("总共"+(num-1)+"搜索结束");
            break;
        }
        list.addAll(newList);
        num++;
    }
        Map<String, Integer> sizeCountMap = new HashMap<>();
        Map<String, Integer> colorCountMap = new HashMap<>();
        for (Map targetDatum : list) {
            String productSize = (String)targetDatum.get("productSize");
            String productColor = (String)targetDatum.get("productColor");
            if (sizeCountMap.containsKey(productSize)){
                sizeCountMap.put(productSize,sizeCountMap.get(productSize) + 1);
            }else{
                sizeCountMap.put(productSize, 1);
            }
            if (colorCountMap.containsKey(productColor)){
                colorCountMap.put(productColor,colorCountMap.get(productColor) + 1);
            }else{
                colorCountMap.put(productColor, 1);
            }
        }
        System.out.println(colorCountMap);
        System.out.println(sizeCountMap);
    }


    private static List<Map> getTargetData(String url,int num,int size) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        CloseableHttpClient client = HttpClients.createDefault();
        String body;
        StringBuilder sb = new StringBuilder();
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter("callback", "fetchJSON_comment98");
            uriBuilder.addParameter("productId", "10135487607");
            uriBuilder.addParameter("score", "0");
            uriBuilder.addParameter("sortType", "10");
            uriBuilder.addParameter("page",num+"");
            uriBuilder.addParameter("pageSize", size+"");
            uriBuilder.addParameter("isShadowSku", "100");
            uriBuilder.addParameter("rid", "0");
            uriBuilder.addParameter("fold", "1");
            HttpGet get = new HttpGet(uriBuilder.build());
            CloseableHttpResponse response = client.execute(get);
            RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).build();
            get.setConfig(config);
            HttpEntity entity = response.getEntity();
            if (entity!=null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent(), "GBK"));
                while ((body = bufferedReader.readLine()) != null) {
                    sb.append(body);
                }
                String substring = sb.substring(20, sb.length() - 2);
                returnMap = (Map<String, Object>) JSON.parseObject(substring);
                JSONArray comments = (JSONArray) returnMap.get("comments");
                List<Map> mapList = JSON.parseArray(comments.toJSONString(), Map.class);
                return mapList;
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
