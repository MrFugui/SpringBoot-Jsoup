package com.wangfugui.jsoup.csdn;

import cn.hutool.core.util.RandomUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 3.创建一个SchedulingTest类来完成这个任务
 */
@Component
public class SchedulingPlan {

    @Value("${csdnurl}")
    String csdnUrl;

    static List<String> textId;

    private int i = 0;

    @Scheduled(fixedRate = 1000)
    void doSomethingWith() {

        int i = RandomUtil.randomInt(textId.size());
        String url = textId.get(i);
        Tool.doGet(url);

        this.i++;
        System.out.println("第" + this.i + "次访问,地址为："+url);

    }

    @Scheduled(fixedRate = 1000 * 60 * 60 * 24)
    void getUrl() {
        textId = Tool.getTextId(csdnUrl);
    }

}


