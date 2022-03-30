package com.boot.pj.service;

import com.boot.pj.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {


    @Autowired
    ArticleService articleService;


    @Test
    void index() {

        Article a = new Article(1L, "ㄴㅇ" , "ㅈㅁ");
        Article b = new Article(2L, "ㄴㅇ" , "ㅈㅁ");
        Article c = new Article(3L, "ㄴㅇ" , "ㅈㅁ");
        List<Article> ex = new ArrayList<Article>(Arrays.asList(a,b,c));

        List<Article> articles = articleService.index();

        assertEquals(ex.toString(),articles.toString());

    }

    @Test
    void show(){
        Long id = 1L;
        Article ex = new Article(id,"s","s");
        Article article = articleService.show(id);

        assertEquals(ex.toString(),article.toString());
    }




}