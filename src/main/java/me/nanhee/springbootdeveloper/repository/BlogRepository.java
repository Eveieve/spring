package me.nanhee.springbootdeveloper.repository;

import me.nanhee.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 클래스를 상속받을때 엔티티 Article과 엔티티의 PK 타입 Long을 인수로 넣기
// 이 레포지토리를 사용할때 JpaRepository에서 제공하는 여러 메서드 사용 가능.
public interface BlogRepository extends JpaRepository<Article, Long> {
}
