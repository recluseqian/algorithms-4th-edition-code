package fundamentals;

public interface Queue<Item> extends Collection<Item> {

    void enqueue(Item item);

    Item dequeue(Item item);

}
