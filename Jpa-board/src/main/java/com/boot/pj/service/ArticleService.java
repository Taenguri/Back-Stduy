package com.boot.pj.service;

import com.boot.pj.dto.ArticleFormDTO;
import com.boot.pj.entity.Article;
import com.boot.pj.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index(){
        return articleRepository.findAll();
    }
    public Article show(Long id){
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleFormDTO form){
        Article article = form.toEntity();
        if(article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }



    @PatchMapping("/api/articles/{id}")
    public Article update(@PathVariable Long id, @RequestBody ArticleFormDTO form){

        Article article = form.toEntity();

        Article target = articleRepository.findById(id).orElse(null);

        if(target == null || id != article.getId()){
            return null;
        }


        target.patch(article);
        Article updated = articleRepository.save(target);

        return updated;
    }



    public Article delete(Long id){
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null) {
            return null;
        }


        articleRepository.delete(target);
        return target;
    }

}
