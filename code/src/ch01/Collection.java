package ch01;

public interface Collection<Item> extends Iterable<Item> {

    int size();

    boolean isEmpty();
}
