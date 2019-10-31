package ru.rzn.sbt.javaschool.lesson6.bff;

import java.util.*;

public class Solution {

    /**
     * 1. Создайте обобщённый класс TwoItems, параметризовынный типом <T> и хранящий две ссылки на объекты типа T.
     * Введите конструктор, принимающий два аргумента и get-методы.
     * <p>
     * 2. В {@link Collection} persons найдите персоны, у которых взаимно совпадают ссылки на лучших друзей
     * {@link Person#bestFriend}, сформируйте из них экземпляры класса TwoItems<Person> и разместите
     * в {@link Collection}<TwoItems>.
     * <p>
     * 3. В качестве результата выполнения метода {@link Solution#findBestFriends(Collection)} верните размер коллекции
     * с парами лучших друзей.
     */
    public static int findBestFriends(Collection<Person> persons) {
        Collection<TwoItems<Person>> bestFriends = new ArrayList<>();
        for (Person p1 : persons) {
            Person f1 = p1.getBestFriend();
            if (f1 != null) {
                Person f2 = f1.getBestFriend();
                TwoItems<Person> friends = new TwoItems<>(p1, f1);
                if (p1 == f2 && !contains(bestFriends, friends))
                    bestFriends.add(friends);
            }
        }

        return bestFriends.size();
    }

    public static <T> boolean contains(Collection<TwoItems<T>> src, TwoItems<T> twoItems) {
        boolean result = false;
        for (TwoItems<T> element : src) {
            if (element.getItem1() == twoItems.getItem2() && element.getItem2() == twoItems.getItem1()) {
                result = true;
                break;
            }
        }
        return result;
    }
}
