package org.example.structures;

public interface CustomList<T> {
    public void add(T value);

    public void insert(int index, T value);

    public boolean contains(T value);

    public boolean deleteByValue(T value);

    public void deleteByIndex(int index);
}
