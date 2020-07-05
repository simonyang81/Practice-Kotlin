package sm.practice.kotlin

import sm.practice.java.*
import java.util.concurrent.ForkJoinPool
import java.util.stream.LongStream

class Main {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            while (true) run breaking@{

                println("This mac has '${Runtime.getRuntime().availableProcessors()}' available processors")

                println("*********************************************")
                println("* 0, Print IAM client info.                 *")
                println("* 1, Kotlin Steam.                          *")
                println("* 2, Java Steam.                            *")
                println("* 3, Kotlin Collect.                        *")
                println("* 4, Java Collect.                          *")
                println("* 5, Kotlin Time function.                  *")
                println("* 6, Java Time function.                    *")
                println("* 7, Kotlin Generic.                        *")
                println("* 8, Java Generic.                          *")
                println("* 9, Kotlin List Collector.                 *")
                println("* a, Kotlin Coroutines.                     *")
                println("* b, Java Parallel.                         *")
                println("* c, Java Collection.                       *")
                println("* d, Java Fork / Join.                      *")
                println("*********************************************")

                val menuNumber = readLine()
                if (menuNumber.isNullOrBlank()) {
                    return@breaking
                }

                when (menuNumber) {
                    "0" -> {
                        println("\n ------------ Client Base64 Info ------------\n")
                        IAMClient().printClient()
                        println("\n ------------ Client Base64 End -------------\n")
                    }
                    "1" -> {
                        println("\n -------------- Kotlin Steam ---------------\n")
                        KotlinSteam().test()
                        println("\n ------------ Kotlin Steam End -------------\n")
                    }
                    "2" -> {
                        println("\n -------------- Java Steam ---------------\n")
                        JavaSteam().test()
                        println("\n ------------ Java Steam End -------------\n")
                    }
                    "3" -> {
                        println("\n -------------- Kotlin Collect ---------------\n")
                        KotlinCollect().test()
                        println("\n ------------ Kotlin Collect End -------------\n")
                    }
                    "4" -> {
                        println("\n -------------- Java Collect ---------------\n")
                        JavaCollect().test()
                        println("\n ------------ Java Collect End -------------\n")
                    }
                    "5" -> {
                        println("\n -------------- Kotlin Date/Time Fun ---------------\n")
                        KotlinTimePractice().test()
                        println("\n ------------ Kotlin Date/Time Fun End -------------\n")
                    }
                    "6" -> {
                        println("\n -------------- Java Date/Time Fun ---------------\n")
                        JavaTimePractice().test()
                        println("\n ------------ Java Date/Time Fun End -------------\n")
                    }
                    "7" -> {
                        println("\n -------------- Kotlin Generic ---------------\n")
                        KotlinGeneric<String>().test("SIMON", 0)
                        println("\n ------------ Kotlin Generic End -------------\n")
                    }
                    "8" -> {
                        println("\n -------------- Java Generic ---------------\n")
                        JavaGeneric<String>().test("SIMON", "a")
                        println("\n ------------ Java Generic End -------------\n")
                    }
                    "9" -> {
                        println("\n -------------- Kotlin List Collector ---------------\n")
                        KotlinCollect().testToListCollector()
                        println("\n -------------- Kotlin List Collector End -----------\n")
                    }
                    "a" -> {
                        println("\n -------------- Kotlin Coroutines ---------------\n")
                        KotlinCoroutines().test()
                        println("\n -------------- Kotlin Coroutines End ---------------\n")
                    }
                    "b" -> {
                        println("\n -------------- Java Parallel ---------------\n")
                        JavaParallel().test()
                        println("\n -------------- Java Parallel End ---------------\n")
                    }
                    "c" -> {
                        println("\n -------------- Java Collection ---------------\n")
                        JavaCollection().test()
                        println("\n -------------- Java Collection End ---------------\n")
                    }
                    "d" -> {
                        println("\n -------------- Java Fork / Join ---------------\n")
                        val numbers = LongStream.rangeClosed(1, 1_000_000).toArray()
                        val task = ForkJoinSumCalculator(numbers)
                        val result = ForkJoinPool().invoke(task)
                        println("1 to 1,000,000 sum is $result")
                        println("\n -------------- Java Fork / Join End ---------------\n")
                    }

                    else -> {
                        return@breaking
                    }
                }
            }


        }

    }

}