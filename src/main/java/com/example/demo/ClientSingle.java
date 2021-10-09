package com.example.demo;
/*
 * @author p78o2
 * @date 2021/10/9
 */

import com.baidu.aip.nlp.AipNlp;
import org.springframework.stereotype.Component;

public class ClientSingle {
    //设置APPID/AK/SK
    public static final String APP_ID = "24955707";
    public static final String API_KEY = "fXvv99wqvsuYKrdRgb7WvG4N";
    public static final String SECRET_KEY = "1izuebQINljOGBGzVBEibsgzUc64p13d";

    private static AipNlp client;

    private ClientSingle(){}

    public static AipNlp getClient() {
        if (client == null) {
            client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        }
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }

    public static void setClient(AipNlp client) {
        ClientSingle.client = client;
    }
}
