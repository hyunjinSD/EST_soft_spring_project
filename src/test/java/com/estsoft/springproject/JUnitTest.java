package com.estsoft.springproject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitTest {
    @Test
    public void test() {
        // given
        int a = 1;
        int b = 2;

        // when : 검증하고싶은 메소드 호출
        int sum = a + b;

        // then : when절 실행한 결과 검증
//        Assertions.assertEquals(3, sum);

        Assertions.assertThat(sum).isEqualTo(3); // AssertJ 사용
    }
}
