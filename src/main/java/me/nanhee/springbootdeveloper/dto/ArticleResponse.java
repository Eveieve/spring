package me.nanhee.springbootdeveloper.dto;

import lombok.Getter;
import me.nanhee.springbootdeveloper.domain.Article;

/**
 * findAllArticles메서드에 대한 응답을 위한 DTO
 */
@Getter
public class ArticleResponse {
    // 글에는 제목과 내용 포함. 필드를 가지는 클래스 만들기
    private final String title;
    private final String content;

    /**
     * Article를 파라미터로 받는 생성자 추가
     * @param article
     */
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
