package sm.practice.kotlin

import java.util.*
import java.util.function.BiConsumer
import java.util.function.BinaryOperator
import java.util.function.Function
import java.util.function.Supplier
import java.util.stream.Collector

/**
 *
 * 收集器接口 Collector<T, A, R>
 *     T 是流中要收集的项目的泛型
 *     A 是累加器的类型，累加器是在收集过程中用于累加部分结果的对象
 *     R 是收集操作得到的对象的类型
 *
 * @author simonist.yang@gmail.com
 */
class ToListCollector<T: Any>: Collector<T, MutableList<T>, MutableList<T>> {

    /**
     * 创建集合操作的起始点
     */
    override fun supplier(): Supplier<MutableList<T>> {
        return Supplier { mutableListOf<T>() }
    }

    /**
     * 累积遍历过的项目
     */
    override fun accumulator(): BiConsumer<MutableList<T>, T> {
        return BiConsumer { t, u -> t.add(u) }
    }

    /**
     * 恒等函数
     * 在遍历完流后，finisher 方法必须返回累积过程的最后要调用的一个函数，以便将累加器对象转换为整个集合操作的最终结果
     * 通常，就像ToListCollector的情况一样，累加器对象恰好符合预期的最终结果，因此无须进行转换
     */
    override fun finisher(): Function<MutableList<T>, MutableList<T>> {
        return Function { t -> t }
    }

    /**
     * 原始流会以递归方式拆分为子流，直到定义流是否需要进一步拆分的一个条件为非（如果分布工作单位太小，并行计算往往比顺序计算要慢，
     * 而且要是生成的并行任务比处理器内核数多很多的话就毫无意义）
     *
     * 最后使用收集器 combiner 方法返回的函数，将所有的部分结果两两合并。这时会把原始流每次拆分时得到的子流对应的结果合并起来
     */
    override fun combiner(): BinaryOperator<MutableList<T>> {
        return BinaryOperator {t, u ->
            t.addAll(u)
            t
        }
    }

    /**
     * 定义收集器的行为 —— 尤其是关于流是否可以并行规约，以及可以使用哪些优化的提示
     *
     * UNORDERED，规约结果不受流中项目的遍历和累积顺序的影响
     * CONCURRENT，accumulator 函数可以从多线程同时调用，且该收集器可以并行规约流
     * IDENTITY_FINISH，不需要进行转换。用来累积流中元素的List已经是我们要的结果，用不着进一步转换
     */
    override fun characteristics(): Set<Collector.Characteristics> {
        return Collections.unmodifiableSet(
            setOf(Collector.Characteristics.CONCURRENT, Collector.Characteristics.IDENTITY_FINISH))
    }

}