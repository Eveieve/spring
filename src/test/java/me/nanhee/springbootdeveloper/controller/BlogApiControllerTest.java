package me.nanhee.springbootdeveloper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.nanhee.springbootdeveloper.domain.Article;
import me.nanhee.springbootdeveloper.dto.AddArticleRequest;
import me.nanhee.springbootdeveloper.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // 테스트용 애플리케이션 컨텍스트
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class BlogApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    /**
     * 이 클래스로 만든 클래스는 자바 객체를 JSON 데이터로 변환하는 직렬화 또는 반대로 JSON데이터를 자바에서 사용하기 위해 자바 객체로 변환하는 역질렬화 할때 사용.
     */
    @Autowired
    protected ObjectMapper objectMapper; // 직렬화, 역질렬화 위한 클래스

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        blogRepository.deleteAll();
    }

    @DisplayName("addArticls: 블로그 글 추가 성공. ")
    @Test
    public void addArticle() throws Exception {
        //given
        // 변경되지 않아야 할 대상에 final 붙이기.
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";
        final AddArticleRequest userRequest = new AddArticleRequest(title, content); // 객체 생성.

        // 객체를 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result.andExpect(status().isCreated());

        List<Article> articles = blogRepository.findAll();

        assertThat(articles.size()).isEqualTo(1); // 크기가 1인지 검증
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
        assertThat(articles.get(0).getContent()).isEqualTo(content);

    }

}
/**
 * 직렬화와 역질렬화란?
 * HTTP에서는 JSON, 자바에선 객체 사용함. 서로 형식이 다르기 때문에 변환하는 작업 필요.
 * 이걸 직렬화, 역질렬화라고 함. 직렬화는 자바 시스템 내부에서 사용되는 객체를 오비ㅜ에서 사용하도록 데이터 변환하는 작업.
 * JSON 형식으로 직렬화 하는 것임.
 * 반면, JSON 에서 자바 시스템에서 사용할 수 있게 하는건 '역질렬화' 라고 함.
 */

/**
 * Given - when - Then ?
 * Given : 글 추가에 필요한 요청 객체 만듦.
 * when : 글 추가 API 요청 보냄. 요청 타입은 JSON, given절에서 만들어둔 객체를 요청 본문으로 보냄.
 * Then : 응답 코드가 201 Created 인지 확인함.
 */