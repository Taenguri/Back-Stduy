package com.boot.pj.dto;

import com.boot.pj.entity.Article;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleFormDTO {

    private Long id;
    private String title;
    private String content;


    public Article toEntity() {
        return new Article(id,title,content);
    }
}
