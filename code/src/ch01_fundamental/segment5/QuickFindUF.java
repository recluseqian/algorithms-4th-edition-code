package ch01_fundamental.segment5;

public class QuickFindUF extends AbstractUnionFind {

    public QuickFindUF(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];

        if (pID == qID) {
            return;
        }
        for (int i = 0; i < count; i ++) {
            if (id[i] == pID) {
                id[i] = qID;
                count--;
            }
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    public static void main(String[] args) {

    }
}
