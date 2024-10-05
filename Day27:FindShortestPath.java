import java.util.*;

public class ShortestPathUnweightedGraph {

    // Method to find the shortest path length between start and end nodes
    public static int shortestPath(int V, List<List<Integer>> edges, int start, int end) {
        // Adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected)
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // BFS to find the shortest path
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        // Start BFS from the start node
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            // If we reach the end node, return the distance
            if (node == end) {
                return distance[node];
            }

            // Explore all neighbors of the current node
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // If we exit the loop without finding the end node, return -1 (no path found)
        return -1;
    }

    public static void main(String[] args) {
        // Example 1
        int V1 = 5;
        List<List<Integer>> edges1 = new ArrayList<>();
        edges1.add(Arrays.asList(0, 1));
        edges1.add(Arrays.asList(0, 2));
        edges1.add(Arrays.asList(1, 3));
        edges1.add(Arrays.asList(2, 3));
        edges1.add(Arrays.asList(3, 4));
        int start1 = 0, end1 = 4;
        System.out.println(shortestPath(V1, edges1, start1, end1));  // Output: 3

        // Example 2
        int V2 = 3;
        List<List<Integer>> edges2 = new ArrayList<>();
        edges2.add(Arrays.asList(0, 1));
        edges2.add(Arrays.asList(1, 2));
        int start2 = 0, end2 = 2;
        System.out.println(shortestPath(V2, edges2, start2, end2));  // Output: 2

        // Example 3
        int V3 = 4;
        List<List<Integer>> edges3 = new ArrayList<>();
        edges3.add(Arrays.asList(0, 1));
        edges3.add(Arrays.asList(1, 2));
        int start3 = 2, end3 = 3;
        System.out.println(shortestPath(V3, edges3, start3, end3));  // Output: -1
    }
}