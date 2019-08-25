package ch01_fundamental.segment3;

public interface Queue<Item> extends Collection<Item> {

    void enqueue(Item item);

    Item dequeue(Item item);

}
