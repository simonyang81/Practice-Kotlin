package sm.practice.kotlin

class KotlinCallback {

    fun test(callback: (String, Int) -> String) {
        val name = "Simon Yang"
        val age = 39
        val result = callback(name, age)
        println(result)
    }

}