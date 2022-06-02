package com.trenddyol.primekata;

import java.util.ArrayList;
import java.util.List;

public class PrimeKatas {

    public List<Integer> calculate(int number) {
        if (!checkPositive(number)) {
            return List.of(-1);
        }

        if (number == 1) {
            return List.of();
        }

        return findKatas(number, new ArrayList<>());
    }

    private List<Integer> findKatas(int number, List<Integer> result) {
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                if (isDividable(number, i)) {
                    result.add(i);
                    return findKatas(number/i, result);
                }
            }
        }
        return result;
    }

    private boolean checkPositive(int number ) {
        return number >= 1;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (isDividable(number, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isDividable(int number, int i) {
        return number % i == 0;
    }


}
