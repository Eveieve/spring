package me.nanhee.springbootdeveloper.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 엔티티로 지정
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id // ID필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // title 이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Article(String title, String content) { // 빌더 패턴으로 객체 생성 - 객체를 유연하고 직관적으로 생성하기 위해.
        this.title = title;
        this.content = content;
    }
}

// 빌더 패턴을 사용하면 어느 필드에 어느 값이 매칭되는지 쉽게 확인 가능.
//new Article("abc", "def");
//
//Article.builder()
//.title("abc")
//.content("def")
//.build();