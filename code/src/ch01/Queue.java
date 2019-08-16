package ch01;

public interface Queue<Item> extends Collection<Item> {

    void enqueue(Item item);

    void dequeue(Item item);

}
