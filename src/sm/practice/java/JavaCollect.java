package sm.practice.java;

import com.google.common.collect.Lists;
import sm.practice.kotlin.Currency;
import sm.practice.kotlin.KotlinCollect;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaCollect {

    private List<KotlinCollect.Transaction> transactions;
    private List<KotlinCollect.Dish> menus;

    public JavaCollect() {
        transactions = Lists.newArrayList(
                new KotlinCollect.Transaction(Currency.EUR, 1500.0),
                new KotlinCollect.Transaction(Currency.USD, 2300.0),
                new KotlinCollect.Transaction(Currency.GBP, 9900.0),
                new KotlinCollect.Transaction(Currency.EUR, 1100.0),
                new KotlinCollect.Transaction(Currency.JPY, 7800.0),
                new KotlinCollect.Transaction(Currency.CHF, 6700.0),
                new KotlinCollect.Transaction(Currency.EUR, 5600.0),
                new KotlinCollect.Transaction(Currency.USD, 4500.0),
                new KotlinCollect.Transaction(Currency.CHF, 3400.0),
                new KotlinCollect.Transaction(Currency.GBP, 3200.0),
                new KotlinCollect.Transaction(Currency.USD, 4600.0),
                new KotlinCollect.Transaction(Currency.JPY, 5700.0),
                new KotlinCollect.Transaction(Currency.EUR, 6800.0)
        );

        menus = Lists.newArrayList(
                new KotlinCollect.Dish("pork", false, 800, KotlinCollect.Type.MEAT),
                new KotlinCollect.Dish("beef", false, 700, KotlinCollect.Type.MEAT),
                new KotlinCollect.Dish("chicken", false, 400, KotlinCollect.Type.MEAT),
                new KotlinCollect.Dish("french fries", true, 530, KotlinCollect.Type.OTHER),
                new KotlinCollect.Dish("rice", true, 350, KotlinCollect.Type.OTHER),
                new KotlinCollect.Dish("season fruit", true, 120, KotlinCollect.Type.OTHER),
                new KotlinCollect.Dish("pizza", true, 550, KotlinCollect.Type.OTHER),
                new KotlinCollect.Dish("prawns", false, 400, KotlinCollect.Type.FISH),
                new KotlinCollect.Dish("salmon", false, 450, KotlinCollect.Type.FISH)
        );
    }

    public void test() {
        var group = transactions.stream().sorted(Comparator.comparing(KotlinCollect.Transaction::getCurrency))
                .collect(Collectors.groupingBy(KotlinCollect.Transaction::getCurrency));
        System.out.println(group);

        var maxMenu = menus.stream().max(Comparator.comparing(KotlinCollect.Dish::getCalories));
        System.out.println("Max calories menu: " + maxMenu);

        var sumCalories = menus.stream().mapToInt(KotlinCollect.Dish::getCalories).sum();
        System.out.println("Sum calories: " + sumCalories);

        var dishMap = menus.stream().collect(Collectors.groupingBy(KotlinCollect.Dish::getType,
                Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));
        System.out.println("Dish Map: " + dishMap);

        var typesCount = menus.stream().collect(Collectors.groupingBy(KotlinCollect.Dish::getType, Collectors.counting()));
        System.out.println("Menu types count: " + typesCount);
    }


}
