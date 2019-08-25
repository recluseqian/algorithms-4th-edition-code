package ch01_fundamental.segment3;

public interface Collection<Item> extends Iterable<Item> {

    int size();

    boolean isEmpty();
}
