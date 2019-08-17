package fundamentals;

public interface Stack<Item> extends Collection<Item> {

    void push(Item item);

    Item pop();
}
