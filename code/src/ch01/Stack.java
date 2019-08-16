package ch01;

public interface Stack<Item> extends Collection<Item> {

    void push(Item item);

    Item pop();
}
