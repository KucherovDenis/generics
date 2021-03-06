package ru.rzn.sbt.javaschool.lesson6.abonents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {
    public static <T, R> Collection<R> transform(Collection<T> src, Function<T, R> function) {
        Collection<R> result = new ArrayList<>();
        for (T entity : src) {
            R newEntity = function.apply(entity);
            if (newEntity != null) result.add(newEntity);
        }
        return result;
    }

    public static <T> Collection<T> filter(Collection<T> src, Predicate<T> predicate) {
        Collection<T> result = new ArrayList<>();
        for (T entity : src)
            if (predicate.test(entity)) {
                result.add(entity);
            }
        return result;
    }

    public static <T> int count(Collection<T> src, Predicate<T> predicate) {
        int result = 0;
        for (T entity : src)
            if (predicate.test(entity)) {
                result++;
            }
        return result;
    }

    public static <T> boolean contains(Collection<T> src, Predicate<T> predicate) {
        boolean result = false;
        for (T entity : src)
            if (predicate.test(entity)) {
                result = true;
                break;
            }
        return result;
    }
}
