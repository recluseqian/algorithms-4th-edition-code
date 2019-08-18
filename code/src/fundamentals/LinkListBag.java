package fundamentals;

import java.util.Iterator;

public class LinkListBag<Item> implements Bag<Item> {

    private Node mFirst = null;
    private int mCount = 0;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public void add(Item item) {
        Node oldFirst = mFirst;
        mFirst = new Node();
        mFirst.item = item;
        mFirst.next = oldFirst;
        mCount++;
    }

    @Override
    public int size() {
        return mCount;
    }

    @Override
    public boolean isEmpty() {
        return mCount == 0;
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
    }
}
