import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitQuiz {

    @Test
    public void junitTest() {
        String name1 = "JUnit Quiz";
        String name2 = "JUnit Quiz";
        String name3 = "JUnit Quizd";

        // 모든 변수가 null이 아닌지 확인
        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        // is name1 and name2 different
        assertThat(name1).isEqualTo(name2);

        assertThat(name1).isNotEqualTo(name3);
    }
}
