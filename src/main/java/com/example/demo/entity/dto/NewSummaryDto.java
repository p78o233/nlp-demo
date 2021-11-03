package com.example.demo.entity.dto;
/*
 * @author p78o2
 * @date 2021/11/3
 */

public class NewSummaryDto {
//    标题
    private String title;
//    摘要长度
    private int maxSummaryLen;
//    正文
    private String content;

    @Override
    public String toString() {
        return "NewSummaryDto{" +
                "title='" + title + '\'' +
                ", maxSummaryLen=" + maxSummaryLen +
                ", content='" + content + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxSummaryLen() {
        return maxSummaryLen;
    }

    public void setMaxSummaryLen(int maxSummaryLen) {
        this.maxSummaryLen = maxSummaryLen;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewSummaryDto() {
    }

    public NewSummaryDto(String title, int maxSummaryLen, String content) {
        this.title = title;
        this.maxSummaryLen = maxSummaryLen;
        this.content = content;
    }
}
