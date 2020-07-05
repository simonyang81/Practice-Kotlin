package sm.practice.kotlin

/**
 *
 *
 * @simonist.yang@gmail.com
 */
class KotlinCollect {

    enum class Type {
        MEAT,
        FISH,
        OTHER
    }

    data class Transaction(val currency: Currency, val value: Double) {
        override fun toString(): String {
            return "Transaction(currency=$currency, value=$value)"
        }
    }

    data class Dish(
        val name: String,
        val vegetarian: Boolean,
        val calories: Int,
        val type: Type) {

        override fun toString(): String {
            return "Dish(name='$name', vegetarian=$vegetarian, calories=$calories, type=$type)"
        }
    }

    private var transactions: List<Transaction>
    private var menu: List<Dish>

    init {
        transactions = listOf(
            Transaction(Currency.EUR, 1500.0),
            Transaction(Currency.USD, 2300.0),
            Transaction(Currency.GBP, 9900.0),
            Transaction(Currency.EUR, 1100.0),
            Transaction(Currency.JPY, 7800.0),
            Transaction(Currency.CHF, 6700.0),
            Transaction(Currency.EUR, 5600.0),
            Transaction(Currency.USD, 4500.0),
            Transaction(Currency.CHF, 3400.0),
            Transaction(Currency.GBP, 3200.0),
            Transaction(Currency.USD, 4600.0),
            Transaction(Currency.JPY, 5700.0),
            Transaction(Currency.EUR, 6800.0)
        )

        menu = listOf(
            Dish("pork", false, 800, Type.MEAT),
            Dish("beef", false, 700, Type.MEAT),
            Dish("chicken", false, 400, Type.MEAT),
            Dish("french fries", true, 530, Type.OTHER),
            Dish("rice", true, 350, Type.OTHER),
            Dish("season fruit", true, 120, Type.OTHER),
            Dish("pizza", true, 550, Type.OTHER),
            Dish("prawns", false, 400, Type.FISH),
            Dish("salmon", false, 450, Type.FISH)
        )
    }

    fun test() {
        val group = transactions.sortedBy { it.currency }.groupBy { it.currency }
        println("group: $group")

        val g2 = transactions.groupingBy { it.currency }
        g2.sourceIterator().forEach { println(it) }

        val maxMenu = menu.maxBy { it.calories }
        println("Max calories menu: $maxMenu")

        val sumCalories = menu.sumBy { it.calories }
        println("Sum calories: $sumCalories")

        val nameJoin = menu.joinToString("") { it.name }
        println("Menu name join: $nameJoin")

        val dishNameMap = menu.groupBy(Dish::type, Dish::name)
        println("dishNameMap: $dishNameMap")

        val map = mapOf("name" to "simon", "job" to "dev")
        map.forEach { (t, u) ->
            println("Key: $t; Value: $u")
        }

    }

    fun testToListCollector() {
        val dish = menu.stream().collect(ToListCollector<Dish>())
        println("dish: $dish")
    }

}