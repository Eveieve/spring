package me.nanhee.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.nanhee.springbootdeveloper.domain.Article;
import me.nanhee.springbootdeveloper.dto.ArticleResponse;
import me.nanhee.springbootdeveloper.service.BlogService;
import me.nanhee.springbootdeveloper.dto.AddArticleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.stream;

/**
 * url에 매핑하기 위한 컨트롤러 메서드를 작성한다. 컨트롤러 메서드에는 @GetMapping, PostMapping, PutMapping, DeleteMapping등 사용 가능.
 *
 * 각 메서드는 HTTP메서드에 대응한다.
 *
 * /api/articles 에 POST 요청이 오면 @PostMapping을 이용해 요청을 매핑한 뒤, 블로그 글을 생성하는 BlogService()의 save()메서드를 호출한 뒤, 생성 된 블로그 글을 반환하는 addArticle(
 * )메서드 작성하기.
 */
@RequiredArgsConstructor
// RestController - HTTP Response Body의 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
@RestController
public class BlogApiController {
    private final BlogService blogService;

    // Post Mapping - HTTP 메서드가 POST 일때 요청받은 URL과 동일한 메서드와 매핑함.
    @PostMapping("/api/articles") //url과 맞으면..
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        // 요청한 자원이 성공적으로 생성됨. 저장된 블로그 글 정보(savedArticle)를 응답 객체에 담아 전송하기.
        // 컨트롤러가 저번에 뭔갈 반환해야하지 않냐? 라고 질문한거 기억나지? 이제 반환함!
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    /**
     * 전체글을 조회한 뒤 반환하는 메서드
     * @return
     */
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
        .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok().body(articles);

    }
}

/**
 * 알아두면 좋은응답 코드
 *
 * 200 OK
 * 201 Created
 * 400 Bad Request
 * 403 Forbidden
 * 404 Not Found
 * 500 Internal Server Error
 */