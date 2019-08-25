package ch01_fundamental.segment3;

public interface Stack<Item> extends Collection<Item> {

    void push(Item item);

    Item pop();
}
