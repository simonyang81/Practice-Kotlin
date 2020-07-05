package sm.practice.java;

import java.util.stream.Stream;

public class JavaParallel {

    public void test() {
        var value = this.parallelSum(100);
        System.out.println("parallelSum: " + value);
    }

    private long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

}
