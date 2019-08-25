package ch01_fundamental.segment5;

public class PathCompressWeightedQuickUnionUF extends WeightedQuickUnionUF {

    public PathCompressWeightedQuickUnionUF(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        int orig = p;
        while (p != id[p]) {
            p = id[p];
        }
        int root = p;
        p = orig;
        while (id[p] != root) {
            int pRoot = id[p];
            id[p] = root;
            p = pRoot;
        }
        return root;
    }
}
