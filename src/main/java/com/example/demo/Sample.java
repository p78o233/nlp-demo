package com.example.demo;
/*
 * @author p78o2
 * @date 2021/10/8
 */

import com.alibaba.fastjson.JSONObject;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;
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
    @GetMapping("/word_emb_sim")
    public JSONObject word_emb_sim(@RequestParam(defaultValue = "广州")String word_1,@RequestParam(defaultValue = "深圳")String word_2){
//        词义相似度  https://cloud.baidu.com/doc/NLP/s/Fk6z52fjc
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 词义相似度
        JSONObject res = JSONObject.parseObject(client.wordSimEmbedding(word_1, word_2, options).toString());
        return res;
    }
    @GetMapping("/simnet")
    public JSONObject simnet(@RequestParam(defaultValue = "早呀猪猪")String text1,@RequestParam(defaultValue = "早呀宝宝")String text2){
//        短文相似度  https://cloud.baidu.com/doc/NLP/s/ek6z52frp
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("model", "CNN");
        // 短文本相似度
        JSONObject res = JSONObject.parseObject(client.simnet(text1, text2, options).toString());
        return res;
    }
    @GetMapping("/comment_tag")
    public JSONObject word_emb_sim(@RequestParam(defaultValue = "三星电脑电池不给力")String text){
//        评论观点抽取   https://cloud.baidu.com/doc/NLP/s/ok6z52g8q
        HashMap<String, Object> options = new HashMap<String, Object>();
        JSONObject res = JSONObject.parseObject(client.commentTag(text, ESimnetType.SHOPPING, options).toString());
        return res;
    }
    @GetMapping("/sentiment_classify")
    public JSONObject sentiment_classify(@RequestParam(defaultValue = "苹果是一家伟大的公司")String text){
//        情感倾向分析接口   https://cloud.baidu.com/doc/NLP/s/zk6z52hds
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 情感倾向分析
        JSONObject res = JSONObject.parseObject(client.sentimentClassify(text, options).toString());
        return res;
    }
    @GetMapping("/keyword")
    public JSONObject keyword(){
//        文章标签 https://cloud.baidu.com/doc/NLP/s/7k6z52ggx
        String title = "iphone手机出现“白苹果”原因及解决办法，用苹果手机的可以看下";
        String content = "如果下面的方法还是没有解决你的问题建议来我们门店看下成都市锦江区红星路三段99号银石广场24层01室。";
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 文章标签
        JSONObject res = JSONObject.parseObject(client.keyword(title, content, options).toString());
        return res;
    }
    @GetMapping("/topic")
    public JSONObject topic(){
//        文章分类 https://cloud.baidu.com/doc/NLP/s/wk6z52gxe
        String title = "欧洲冠军杯足球赛";
        String content = "欧洲冠军联赛是欧洲足球协会联盟主办的年度足球比赛，代表欧洲俱乐部足球最高荣誉和水平，被认为是全世界最高素质、最具影响力以及最高水平的俱乐部赛事，亦是世界上奖金最高的足球赛事和体育赛事之一。";
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        // 文章分类
        JSONObject res = JSONObject.parseObject(client.topic(title, content, options).toString());
        return res;
    }
    @GetMapping("/news_summary")
    public JSONObject news_summary(@RequestParam String title,@RequestParam String content,@RequestParam int maxSummaryLen){
//        新闻摘要 https://cloud.baidu.com/doc/NLP/s/Gk6z52hu3
//        String content = "原标题：硕士起步，博士扎堆，教师岗位真的“挤破头”？\n" +
//                "\n" +
//                "　　中新网客户端北京10月12日电（任靖）教师资格考试报名火爆，名校硕博竞争中小学老师名额……近日，“教师热”的话题引发舆论热议。教师行业真的这么“吃香”？竞聘教师真的需要“挤破头”？\n" +
//                "\n" +
//                "　　硕博扎堆，应聘教师为啥“挤破头”？\n" +
//                "\n" +
//                "　　近日，深圳某中学招聘时硕博扎堆的现象引发舆论热议。对此，不少网友表示“博士当中小学老师是大材小用”，还有网友感慨“教师的尽头是博士”。\n" +
//                "\n" +
//                "　　但这样的现象在深圳其实并不少见。深圳“四大校”对于教师的要求较高，以深圳中学、深圳实验学校发布的2022年应届毕业生招聘公告为例，两所学校招聘的最低学历要求均为研究生，且多数岗位要求应聘者具有对应的专业背景。\n" +
//                "\n" +
//                "　　而除“四大校”外，其他学校招聘的学历门槛也不低。据深圳市龙岗区近期发布的招聘公告，不少学校的招聘也是硕士起步。\n" +
//                "\n" +
//                "　　除招聘要求高外，待遇和发展前景也是吸引众多硕士、博士报考的重要因素。北京某重点高校硕士研究生刘嘉（化名）去年参加了深圳市龙岗区教师招聘，应聘的原因是：这里的教师工资待遇很优厚。\n" +
//                "\n" +
//                "　　入职深圳某小学一年的老师王雪（化名）也告诉中新网，深圳的教师薪资待遇确实比较好，年薪高、解决编制、提供教师宿舍、解决孩子上学问题。因此，报考的硕博生很多，竞争也比较激烈。\n" +
//                "\n" +
//                "　　待遇优渥、工作稳定、假期长、发展前景好，这样的教师岗位竞争火爆，不难理解。" +
//                "“教师热”背后，“教资”更热\n" +
//                "\n" +
//                "　　与高学历毕业生扎堆竞聘教师岗位相对应的是，近年来，越来越多的大学生加入中小学教资考试的大军，“教资热”成为一种现象被舆论聚焦。\n" +
//                "\n" +
//                "　　从报名数据来看，2016年，全年教师资格考试报名人数共有260万人，2017年达410万人，到2019年则攀升至900万人。而今年以来，共有191万人次通过认定获得教师资格证书，较去年全年增长28.7%。\n" +
//                "\n" +
//                "　　中国教育研究院研究员储朝晖分析，教资考试“热”是因为近年来不断攀升的大学毕业生规模，2021届高校毕业生总规模达到909万人，就业竞争之下，持证就意味着多了一条“出路”。\n" +
//                "\n" +
//                "　　“近年来，国家提高了教师入职门槛，教师资格证成为编内外教师上岗的必要条件。此外，近年来，国家逐渐要求培训机构任职的一些教师也要取得教师资格证，这些都增加了教资考试的热度。”华图教育教师研究院负责人张晓静对媒体分析。\n" +
//                "\n" +
//                "　　张晓静认为，从大环境来看，教师的薪资待遇不断提高，国家在编制上也予以优先保障需求，未来教师职业的吸引力在不断增大。\n" +
//                "\n" +
//                "　　“教师热”普遍吗？\n" +
//                "\n" +
//                "　　一些地区依然存在招人难、留人难\n" +
//                "\n" +
//                "　　正如专家所言，近年来，随着待遇保障的不断提高，教师岗位的吸引力持续上升，但是，与一些发达地区“教师热”形成对比的是，中西部欠发达地区和乡村教师的“招人难、留人难”的问题并未完全解决。\n" +
//                "\n" +
//                "　　河南浚县2021年公开招聘教师部分岗位的招聘人数与报名通过人数未达到1：3，按规定核减或取消部分岗位；安徽巢湖市2021年中小学新任教师招聘“高中物理”岗位因达不到开考比例取消招聘计划……诸如此类，教师招人难的消息每年都有不少。" +
//                "关于浚县2021年公开招聘教师部分岗位核减取消公告。 图片来源：浚县人民政府官网\n" +
//                "　　今年7月《桂林晚报》曾以“桂林中小学老师缺口有多大”为题报道该市的教师招聘现状。报道中，桂林中学负责人介绍，现在各学科想招聘到优质的教师是难上加难。部分学科在招聘时可能会出现报不满或者空岗的情况，有些岗位可能就只有一二人报名，都达不到开考比例，特别是数学、物理和地理老师真的很难招。\n" +
//                "\n" +
//                "　　报道中还提到，“与市区学校、重点学校部分学科教师有缺口形成鲜明对比的是，各县乡镇中小学的教师招聘却依然十分困难”。\n" +
//                "\n" +
//                "　　对于当前教师招聘存在的冷热不均现象，专家表示，现阶段我国教师数量总体超编，但结构性缺编，即出现结构性不平衡，比如音、体、美等学科教师短缺，贫困和偏远地区教师短缺。\n" +
//                "\n" +
//                "　　21世纪教育研究院院长熊丙奇分析，地域间的冷热不均与基础教育资源的统筹配置有关。“财政实力强的地区，教育投入力度大，教师工资待遇高，收入水平远高于财政实力薄弱的地区。”\n" +
//                "\n" +
//                "　　熊丙奇说，要真正解决教师招聘冷热不均的状况，提高不发达地区的教育投入水平以及教师的整体待遇，需要强化省级财政对基础教育资源的统筹。即由省级财政保障一省的基础教育经费，包括教师的工资待遇，这才能做到一省范围内基础教育教师的待遇一致，缩小省域内的办学条件、质量差距。\n" +
//                "\n" +
//                "　　“如果这一问题不能解决，教师职业‘吃香’只会发生在局部地区，而并非整体生态。”熊丙奇说。（完）";

        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("title", title);

        // 新闻摘要接口
        JSONObject res = JSONObject.parseObject(client.newsSummary(content, maxSummaryLen, options).toString());
        return res;
    }

    @GetMapping(value = "/emotion")
    public JSONObject emotion(@RequestParam(defaultValue = "本来今天高高兴兴")String text){
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("scene", "talk");

        // 对话情绪识别接口
        JSONObject res = JSONObject.parseObject(client.emotion(text, options).toString());
        return res;
    }
}
