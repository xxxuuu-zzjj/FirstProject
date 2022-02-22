package com.xzj.springbootandvue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.Collator;
import java.util.*;

@Slf4j
@SpringBootTest
class SpringBootAndVueApplicationTests {

    @Test
    void sortWhitChina() {
        //中文排序
        List<String> sortList = new ArrayList<>();
        sortList.add("zhangsan");
        sortList.add("李四");
        sortList.add("342");
        sortList.add("wangwu");
        sortList.add("赵六");
        sortList.add("孙琪");
        Comparator c = Collator.getInstance(Locale.CHINA);
        sortList.sort(c);
        log.info(sortList.toString());
        //TODO: 补充 可以解决绝大多数的中文排序 GB2312内的中文
        //TODO: pinyon4j可以把汉字转换为拼音 考虑诸如算法,同音字,多音字等众多问题
    }
}
