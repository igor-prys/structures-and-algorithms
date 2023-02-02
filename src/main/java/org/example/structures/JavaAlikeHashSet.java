package org.example.structures;

import java.util.LinkedHashSet;
import java.util.Set;

public class JavaAlikeHashSet<T> {
    private CustomHashMap<T, Void> chm;

    public JavaAlikeHashSet() {
        chm = new CustomHashMap<>();
    }

    public JavaAlikeHashSet(int capacity) {
        chm = new CustomHashMap<>(capacity);
    }

    public void add(T value) {
        chm.add(value, null);
    }

    public boolean contains(T value) {
        return chm.containsKey(value);
    }

    public int getSize() {
        return chm.getSize();
    }

    public String toString() {
        String result = "";
        Set<CustomHashMap<T, Void>.Node> set = chm.getNodes();
        LinkedHashSet<String> l = new LinkedHashSet<>();
        for (CustomHashMap.Node node : set) {
            result += node.key + " ";
        }
        return result.trim();
    }
}

