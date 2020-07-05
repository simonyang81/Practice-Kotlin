package sm.practice.kotlin

class KotlinSteam {

    data class Trader(val name: String, val city: String) {
        override fun toString(): String {
            return "Trader(name='$name', city='$city')"
        }
    }

    data class Transaction(
        val trader: Trader,
        val year: Int,
        val value: Int) {
        override fun toString(): String {
            return "Transaction(trader=$trader, year=$year, value=$value)"
        }
    }

    private var transactions: List<Transaction>

    init {
        val raoul = Trader("Raoul", "Cambridge")
        val mario = Trader("Mario", "Milan")
        val alan = Trader("Alan", "Cambridge")
        val brian = Trader("Brian", "Cambridge")
        transactions = listOf(
            Transaction(brian, 2011, 300),
            Transaction(raoul, 2012, 1000),
            Transaction(raoul, 2011, 400),
            Transaction(mario, 2012, 710),
            Transaction(mario, 2012, 700),
            Transaction(alan, 2012, 950)
        )
    }

    fun test() {

        println("-->> tr2011 -->>")
        val tr2011
                = transactions.asSequence().filter { it.year == 2011 }.sortedBy { it.value }.toList()
        tr2011.forEach(System.out::println)

        println("-->> cities -->>")
        val cities = transactions.asSequence().map { it.trader.city }.distinct().toList()
        cities.forEach(System.out::println)

        println("-->> traders -->>")
        val traders = transactions.asSequence().map { it.trader }.filter { it.city.toLowerCase() == "cambridge" }.map { it.name }.sortedBy { it }.distinct().toList()
        traders.forEach(System.out::println)

        println("-->> traderStr -->>")
        val traderStr = transactions.asSequence().map { it.trader.name.toLowerCase() }.distinct().sortedBy { it }
        traderStr.forEach(System.out::print)

        println()

    }


}