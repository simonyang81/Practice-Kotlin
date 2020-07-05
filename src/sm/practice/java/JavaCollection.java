package sm.practice.java;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class JavaCollection {

    public void test() {
        // 不能修改，创建的是只读列表
        var friends = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends);

        var friends2 = Lists.newArrayList("Raphael", "Olivia", "Thibaut");
        friends2.add("Simon");
        System.out.println(friends2);

        var familyMap = Maps.newHashMap();
        familyMap.put("Teo", "Star Wars");
        familyMap.put("Cristina", "James Bond");

        var friendsMap = Map.ofEntries(
                Map.entry("Raphael", "Star Wars"),
                Map.entry("Cristina", "Matrix")
        );

        friendsMap.forEach((k, v) -> familyMap.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println("Merge Map: " + familyMap);
    }

}
