import java.util.*;

class Graph {
    private int totalNodes;
    private LinkedList<Integer>[] adjList;

    public void BFS(int startNode) {
        boolean[] visited = new boolean[totalNodes];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll(); // remove first element from queue
            System.out.print(node + " ");

            // for each adjacent node of the current node
            for (int adjNode : adjList[node]) { 
                if (!visited[adjNode]) { // if not visited
                    visited[adjNode] = true; // mark as visited
                    queue.add(adjNode); // add to queue
                }
            }
        }
    }
}
