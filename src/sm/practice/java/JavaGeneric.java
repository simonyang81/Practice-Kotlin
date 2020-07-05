package sm.practice.java;

/**
 *
 *
 */
public class JavaGeneric<T> {

    /**
     * 泛型T，是通过class Generic定义
     * 泛型V，是通过函数自己定义，与class Generic的泛型定义无关
     */
    public <V> void test(T t, V v) {
        System.out.println("t's class is " + t.getClass() + "; v's class is " + v.getClass());
    }

}
