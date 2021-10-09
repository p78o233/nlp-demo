package com.example.demo;
/*
 * @author p78o2
 * @date 2021/10/8
 */

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.nlp.AipNlp;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@CrossOrigin
@RestController
@RequestMapping(value = "/nlp")
public class Sample {
    public AipNlp client = ClientSingle.getClient();
    @GetMapping("/lexer")
    public JSONObject lexer(@RequestParam(defaultValue = "百度是一家高科技公司") String text){
//        词法分析  文档地址 https://cloud.baidu.com/doc/NLP/s/fk6z52f2u
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();

        // 词法分析
        JSONObject res = JSONObject.parseObject(client.lexer(text, options).toString());
        return res;
    }
}
