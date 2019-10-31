package ru.rzn.sbt.javaschool.lesson6.map;

import java.util.*;

public class CountMapImpl<T> implements CountMap<T> {

    private Map<T, Integer> map;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public void add(T o) {
        Objects.requireNonNull(o);
        Integer value = map.get(o);
        if (value == null) value = 1;
        else value++;
        map.put(o, value);
    }

    @Override
    public int getCount(T o) {
        Objects.requireNonNull(o);
        Integer value = map.get(o);
        if (value == null) return 0;
        else return value;
    }

    @Override
    public int remove(T o) {
        Objects.requireNonNull(o);
        Integer value = map.get(o);
        if (value == null) return 0;
        else {
            int newValue = value - 1;
            if (newValue == 0) map.remove(o);
            else map.put(o, newValue);
        }
        return value;
    }

    @Override
    public int size() {
        return map.size();
    }

    private void addAll(Map<T, Integer> source, Map<T, Integer> destionation) {
        for (T key : source.keySet()) {
            Integer value = destionation.get(key);
            if (value == null) {
                Integer srcValue = source.get(key);
                destionation.put(key, srcValue);
            } else {
                int newValue = value + source.get(key);
                destionation.put(key, newValue);
            }
        }
    }

    @Override
    public void addAll(CountMap<T> source) {
        Objects.requireNonNull(source);
        Map<T, Integer> src = source.toMap();
        addAll(src, map);
    }

    @Override
    public Map toMap() {
        Map<T, Integer> result = new HashMap<>();
        for (Map.Entry<T, Integer> entry : map.entrySet())
            result.put(entry.getKey(), entry.getValue());
        return result;
    }

    @Override
    public void toMap(Map destination) {
        Objects.requireNonNull(destination);
        addAll(map, destination);
    }
}
