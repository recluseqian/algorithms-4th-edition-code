package ch01_fundamental.segment5;

public interface UnionFind {

    void union(int p, int q);

    int find(int p);

    boolean connected(int p, int q);

    int count();
}
