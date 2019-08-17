package fundamentals;

import java.util.Iterator;

public class LinkedListStack<Item> implements Stack<Item> {

    private int mCount = 0;
    private Node mFirst = null;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public void push(Item item) {
        Node oldFirst = mFirst;
        mFirst = new Node();
        mFirst.item = item;
        mFirst.next = oldFirst;
        mCount++;
    }

    @Override
    public Item pop() {
        if (mFirst == null) {
            return null;
        }
        Item item = mFirst.item;
        mFirst = mFirst.next;
        mCount--;
        return item;
    }

    @Override
    public int size() {
        return mCount;
    }

    @Override
    public boolean isEmpty() {
        return mFirst == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node mCurrent = mFirst;

        @Override
        public boolean hasNext() {
            return mCurrent == null;
        }

        @Override
        public Item next() {
            Item item = mCurrent.item;
            mCurrent = mCurrent.next;
            return item;
        }

        @Override
        public void remove() {
        }
    }
}
