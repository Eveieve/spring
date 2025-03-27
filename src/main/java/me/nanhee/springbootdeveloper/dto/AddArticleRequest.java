package me.nanhee.springbootdeveloper.dto;

// 블로그에 글을 추가하는 코드 (서비스 계층)
// 서비스계층에서 요청을 받는 AddArticleRequest 객체 생성하기.
// 블로그 글 추가 메서드 save() 구현하기.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.nanhee.springbootdeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() { // DTO 를 엔티티로 만들어주는 일반 메서드.
        // 빌더 패턴을 이용해 Article 클래스의 생성자를 간접 호출
        return Article.builder().title(title).content(content).build();
    }
}
