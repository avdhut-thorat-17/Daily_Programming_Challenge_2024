import java.util.*;

class CycleDetection {
    private boolean[] visited;
    private int[] parent;

    public boolean detectCycle(int V, List<List<Integer>> adj) {
        visited = new boolean[V];
        parent = new int[V];
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                parent[neighbor] = node;
                if (dfs(neighbor, adj)) {
                    return true;
                }
            } else if (neighbor != parent[node]) {
                return true; // Found a cycle
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        CycleDetection cd = new CycleDetection();
        boolean hasCycle = cd.detectCycle(V, adj);
        System.out.println("Graph contains cycle: " + hasCycle);
    }
}