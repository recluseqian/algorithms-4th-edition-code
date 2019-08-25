package ch01_fundamental.segment3;

import java.util.Iterator;

public class LinkedListQueue<Item> implements Queue<Item> {

    private Node mFirst = null;
    private Node mLast = null;
    private int mCount = 0;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public void enqueue(Item item) {
        Node oldLast = mLast;
        mLast = new Node();
        mLast.item = item;
        mLast.next = null;
        if (oldLast == null) {
            mFirst = mLast;
        } else {
            oldLast.next = mLast;
        }
        mCount++;
    }

    @Override
    public Item dequeue(Item item) {
        if (mFirst == null) {
            return null;
        }
        Node oldFirst = mFirst;
        mFirst = mFirst.next;
        mCount--;
        return oldFirst.item;
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
        return null;
    }

    private class ListIterator implements Iterator<Item> {

        Node mCurrent = mFirst;

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

    public static void main(String[] args) {

    }
}
