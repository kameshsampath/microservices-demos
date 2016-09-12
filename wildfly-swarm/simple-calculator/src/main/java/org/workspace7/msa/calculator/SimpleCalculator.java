package org.workspace7.msa.calculator;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kameshs
 */
@ApplicationScoped
public class SimpleCalculator implements CalculatorService {

    @Override
    public int calculate(String opr, Integer... arrNumbers) {
        if (arrNumbers != null && arrNumbers.length > 1) {
            List<Integer> numbers = Arrays.asList(arrNumbers);
            switch (opr) {
                case "+": {
                    return add(numbers);
                }
                case "-": {
                    return sub(numbers);
                }
                case "*": {
                    return div(numbers);
                }
                case "/": {
                    return div(numbers);
                }
                default: {
                    return 0;
                }
            }
        } else {
            throw new IllegalStateException("Invalid operands count");
        }
    }

    public int add(List<Integer> numbers) {
        AtomicInteger sum = new AtomicInteger();
        numbers.forEach(n -> sum.addAndGet(n));
        return sum.intValue();
    }

    int div(List<Integer> numbers) {
        AtomicInteger sum = new AtomicInteger();
        numbers.stream().filter(n -> n != 0).forEach(n -> sum.set(sum.intValue() / n));
        return sum.intValue();
    }

    int mul(List<Integer> numbers) {
        AtomicInteger sum = new AtomicInteger();
        numbers.stream().filter(n -> n != 0).forEach(n -> sum.set(sum.intValue() * n));
        return sum.intValue();
    }

    int sub(List<Integer> numbers) {
        AtomicInteger sum = new AtomicInteger();
        numbers.forEach(n -> sum.set(sum.intValue() - n));
        return sum.intValue();
    }
}
