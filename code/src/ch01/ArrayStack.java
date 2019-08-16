package ch01;

import java.util.Iterator;

public class ArrayStack<Item> implements Stack<Item> {

    private Item[] mData = (Item[]) new Object[10];
    private int mCurIndex = 0;

    public ArrayStack() {
    }

    private void resize(int capacity) {
        Item[] newData = (Item[]) new Object[capacity];
        System.arraycopy(mData, 0, newData, 0, mData.length);
        mData = newData;
    }
    @Override
    public void push(Item item) {
        if (mCurIndex >= mData.length) {
            resize(mData.length * 2);
        }
        mData[mCurIndex++] = item;
    }

    @Override
    public Item pop() {
        if (mCurIndex == 0) {
            return null;
        }
        Item item = mData[--mCurIndex];

        if (mCurIndex <= mData.length/4) {
            resize(mData.length/2);
        }
        return item;
    }

    @Override
    public int size() {
        return mCurIndex;
    }

    @Override
    public boolean isEmpty() {
        return mCurIndex == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        private int mIterIndex = mCurIndex;
        @Override
        public boolean hasNext() {
            return mIterIndex > 0;
        }

        @Override
        public Item next() {
            return mData[--mIterIndex];
        }
    }


    public static void main(String[] args) {
        
    }
}
