package sm.practice.java;

import com.google.common.collect.Lists;
import sm.practice.kotlin.KotlinSteam;

import java.util.stream.Collectors;

public class JavaSteam {

    public void test() {
        var raoul = new KotlinSteam.Trader("Raoul", "Cambridge");
        var mario = new KotlinSteam.Trader("Mario", "Milan");
        var alan = new KotlinSteam.Trader("Alan", "Cambridge");
        var brian = new KotlinSteam.Trader("Brian", "Cambridge");

        var transactions = Lists.newArrayList(
                new KotlinSteam.Transaction(brian, 2011, 300),
                new KotlinSteam.Transaction(raoul, 2012, 1000),
                new KotlinSteam.Transaction(raoul, 2011, 400),
                new KotlinSteam.Transaction(mario, 2012, 710),
                new KotlinSteam.Transaction(mario, 2012, 700),
                new KotlinSteam.Transaction(alan, 2012, 950)
        );

        System.out.println("-->> tr2011 -->>");

        var tr2011 = transactions.stream().filter(it -> it.getYear() == 2011).distinct().collect(Collectors.toList());
        tr2011.forEach(System.out::println);

    }

}
