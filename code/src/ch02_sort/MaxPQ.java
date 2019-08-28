package ch02_sort;

public class MaxPQ<T extends Comparable<T>> {

    private T[] pq;
    private int N = 0;
    private int capacity = 0;

    public MaxPQ(int max) {
        pq = (T[]) new Object[max+1];
        capacity = max;
        N = 0;
    }

    public void insert(T t) {
        if (N + 1 >= capacity) {
            return;
        }
        pq[++N] = t;
        swim(N);
    }

    public T max() {
        return pq[1];
    }

    public T delMax() {
        T ret = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return ret;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = pq[j];
        pq[j] = pq[i];
        pq[i] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2 * k;
            if (less(j, j+1)) {
                j += 1;
            }
            exch(k, j);
            k = j;
        }
    }
}
