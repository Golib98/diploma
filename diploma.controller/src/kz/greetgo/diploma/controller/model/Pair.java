package kz.greetgo.diploma.controller.model;

public class Pair<T, V> {

  public T key;
  public V value;

  public Pair(T key, V value) {
    this.key = key;
    this.value = value;
  }
}
