package com.trenddyol.primekata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeKatasTest {

    PrimeKatas primeKatas;

    @BeforeEach
    void setUp() {
        primeKatas = new PrimeKatas();
    }

    @Test
    void it_should_return_minus_one_if_number_is_negative(){
        //given
        //when
        List<Integer> output = primeKatas.calculate(-1);

        //then
        assertThat(output.size()).isEqualTo(1);
        assertThat(output.get(0)).isEqualTo(-1);
    }

    @Test
    void it_should_return_empty_list_if_input_is_not_prime() {
        // given
        int number = 1;

        // when
        List<Integer> output = primeKatas.calculate(number);

        // then
        assertThat(output.size()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource(value = "inputs")
    void it_should_calculate_prime_katas(int number, List<Integer> expectedResult){
        // given
        // when
        List<Integer> output = primeKatas.calculate(number);

        // then
        assertEquals(output, expectedResult);
    }

    static Stream<Arguments> inputs(){
        return Stream.of(
                Arguments.of(2, List.of(2)),
                Arguments.of(3, List.of(3)),
                Arguments.of(6, List.of(2,3)),
                Arguments.of(8, List.of(2, 2, 2)),
                Arguments.of(18, List.of(2, 3, 3)),
                Arguments.of(25, List.of(5, 5)),
                Arguments.of(64, List.of(2, 2, 2, 2, 2, 2)),
                Arguments.of(74, List.of(2, 37))
        );
    }
}


