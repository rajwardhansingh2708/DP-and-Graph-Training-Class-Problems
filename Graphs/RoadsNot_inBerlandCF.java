import java.util.*;

public class RoadsNot_inBerlandCF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int parent[] = new int[n + 1];
        int size[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        ArrayList<int[]> extraEdges = new ArrayList<>(); // unlinke leetcode 1319 que, here we have to make an arraylist
                                                         // of extraedge bcoz here we have to print that extraedge also
                                                         // not just have to count them
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (union(u, v, parent, size)) {
                extraEdges.add(new int[] { u, v });
            }
        }
        ArrayList<Integer> newRoad = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (parent[i] == i) {
                newRoad.add(i); // jo node pr cycle mila h uss node ko components wale list m daal do
            }
        }
        int components = newRoad.size();
        System.out.println(components - 1); // mtlb agr total components k hai toh minimum k-1 edges chahiye components
                                            // ko connect krne k liye

        for (int i = 0; i < components - 1; i++) {
            int removed[] = extraEdges.get(i); // arraylist m se array ko nikal rhe
            int u = removed[0];
            int v = removed[1];

            int a = newRoad.get(i);
            int b = newRoad.get(i + 1);

            System.out.println(u + " " + v + " " + a + " " + b);
        }
    }

    static boolean union(int a, int b, int[] parent, int[] size) {
        int pa = find(a, parent);
        int pb = find(b, parent);

        if (pa == pb)
            return true; // cycle found

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
        return false;
    }

    static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}