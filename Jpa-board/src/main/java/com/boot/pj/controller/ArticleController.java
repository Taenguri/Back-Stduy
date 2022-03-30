package com.boot.pj.controller;

import com.boot.pj.dto.ArticleFormDTO;
import com.boot.pj.entity.Article;
import com.boot.pj.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public  String ArticleForm(){
        return "articles/new";
    }


    @PostMapping("/articles/create")
    public String articleCreate(ArticleFormDTO form){

        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        return "redirect:/articles";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",article);
        return"articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList",articleList);
        return"articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){

        Article article = articleRepository.findById(id).orElse(null);
        model.addAttribute( "article",article);
        return"articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleFormDTO form){

        Article article = form.toEntity();
        Article target = articleRepository.findById(article.getId()).orElse(null);
        if(target != null){
            articleRepository.save(article);
        }
        return"redirect:/articles/" + article.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes ra){

       Article target =  articleRepository.findById(id).orElse(null);
       if(target != null){
           articleRepository.delete(target);
           ra.addFlashAttribute("msg","삭제 완료");
       }

       return "redirect:/articles";
    }


}
