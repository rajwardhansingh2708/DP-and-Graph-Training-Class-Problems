//making genome in berland 

//this code gives wrong answer on test case 10

// import java.util.*;

// public class CF638b {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();

//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < 26; i++) {
//             adj.add(new ArrayList<>());

//         }
//         int indegree[] = new int[26];
//         boolean[] used = new boolean[26];

//         for (int i = 0; i < n; i++) {
//             String s = sc.next();

//             for (char ch : s.toCharArray()) {
//                 used[ch - 'a'] = true;
//             }
//             for (int j = 0; j < s.length() - 1; j++) {
//                 int u = s.charAt(j) - 'a';
//                 int v = s.charAt(j + 1) - 'a';

//                 if (!adj.get(u).contains(v)) {
//                     adj.get(u).add(v);
//                     indegree[v]++;
//                 }
//             }
//         }
//         Queue<Integer> q = new LinkedList<>();

//         for (int i = 0; i < 26; i++) {
//             if (used[i] && indegree[i] == 0) {
//                 q.offer(i);
//             }
//         }
//         StringBuilder ans = new StringBuilder();

//         while (!q.isEmpty()) {
//             int node = q.poll();
//             ans.append((char) (node + 'a'));

//             for (int neigh : adj.get(node)) {
//                 indegree[neigh]--;

//                 if (indegree[neigh] == 0) {
//                     q.offer(neigh);
//                 }
//             }
//         }
//         System.out.println(ans.toString());
//     }
// }

import java.util.*;

public class CF638b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[26];
        boolean[] used = new boolean[26];
        int[] visited = new int[26];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (char c : s.toCharArray()) {
                used[c - 'a'] = true;
            }

            for (int j = 0; j < s.length() - 1; j++) {
                int u = s.charAt(j) - 'a';
                int v = s.charAt(j + 1) - 'a';
                if (!adj.get(u).contains(v)) {
                    adj.get(u).add(v);
                    indegree[v]++;
                }
            }
        }

        // Queue<Integer> q = new LinkedList<>();
        // for(int i=0; i<26; i++){
        // if(used[i] && indegree[i] == 0){
        // q.add(i);
        // }
        // }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (used[i] && indegree[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = 1;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    sb.append((char) (node + 'a'));
                    for (int neigh : adj.get(node)) {
                        if (visited[neigh] == 0) {
                            visited[neigh] = 1;
                            q.add(neigh);
                        }
                    }
                }
            }
        }

        // while(!q.isEmpty()){
        // int u = q.poll();
        // sb.append((char) (u + 'a'));

        // for(int neigh : adj.get(u)){
        // indegree[neigh]--;
        // if(indegree[neigh] == 0){
        // q.add(neigh);
        // }
        // }
        // }

        System.out.println(sb.toString());
    }
}