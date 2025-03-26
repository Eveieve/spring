import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @DisplayName("1 + 2는 3이다")

    @Test // 테스트를 수행하는 메서드
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        // junit에서 제공하는 검증 메서드 assertEquals로 원하는 값인지 확인
        // 파라미터1에는 기대하는 값, 파라미터2는 실제로 검증할 값
        Assertions.assertEquals(a + b, sum); // check if it's a correct result
    }
}
