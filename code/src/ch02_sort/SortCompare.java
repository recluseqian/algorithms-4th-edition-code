package ch02_sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

    public static double time(String alg, Comparable[] arr) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case "selection":
                SelectionSort.sort(arr);
                break;
            case "insertion":
                InsertSort.sort(arr);
                break;
            case "shell":
                ShellSort.sort(arr);
                break;
            case "merge":
                MergeSort.sort(arr);
            case "quick":
                QuickSort.sort(arr);
        }
        assert SortUtils.isSorted(arr);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] arr = new Double[N];

        for (int t = 0; t < T; t++) {
            for (int n = 0; n < N; n++) {
                arr[n] = StdRandom.uniform();
            }
            total += time(alg, arr);
        }
        return total;
    }

    public static void main(String[] args) {
        String[] algList1 = {"selection", "insertion", "shell"};
        String[] algList2 = {"merge", "quick", "shell"};
        for (String alg : algList2) {
            int N = 400000, T = 10;
            double total_time = timeRandomInput(alg, N, T);
            System.out.printf("For %d random number %s sort cost %f sec average\n",
                    N, alg, total_time / T);
        }
    }
}
