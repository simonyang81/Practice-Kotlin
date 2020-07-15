package sm.practice.kotlin

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.sendBlocking
import java.util.*

class KotlinCoroutines {

    fun test() {

        // runBlocking 是会阻塞主线程的，直到 runBlocking 内部全部子任务执行完毕，才会继续执行下一步的操作！
        runBlocking {

            val a1 = async {
                repeat(20) {
                    println("-->> async1: $it")
                    delay(1000)
                }
            }

            val a2 = async {
                repeat(20) {
                    println("-->> async2: $it")
                    delay(1000)
                }
            }
            a1.await()
            a2.await()

            println("-->> runBlocking")
        }

        repeat(20) {
            println("-->> main thread: $it")
        }

    }

    fun testGlobalScope() {

        GlobalScope.launch {
            println("---------")
            val channel = Channel<String>()
//            launch {

            async {
                channel.send("11")
            }
            println("")
            delay(5000)

            val data = channel.receive()
            println("data: $data")

        }

        println("---------")

    }

}