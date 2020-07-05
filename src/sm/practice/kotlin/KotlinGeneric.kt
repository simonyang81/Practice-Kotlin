package sm.practice.kotlin

class KotlinGeneric<T: Any> {

    /**
     * 泛型T，是通过class Generic定义
     * 泛型V，是通过函数自己定义，与class Generic的泛型定义无关
     */
    fun<V: Any> test(t: T, v: V) {
        println("t's class is ${t::class.java}; v's class is ${v::class.java}")
    }

}