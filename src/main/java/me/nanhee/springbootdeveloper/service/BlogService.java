package me.nanhee.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.nanhee.springbootdeveloper.domain.Article;
import me.nanhee.springbootdeveloper.dto.AddArticleRequest;
import me.nanhee.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    /**
     * JPA 지원 메서드 findAll - article 테이블에 저장되어있는 모든 데이터 조회하기.
     * @return
     */
    public List<Article> findAll() {
        return blogRepository.findAll();
    }
}
