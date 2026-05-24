import java.util.ArrayList;
import java.util.List;

public class Graph {

    private static int minCost;
    private static List<Integer> bestRoute;
    private String[] cities;
    int[][] costs;

    public Graph(String[] cities, int[][] costs) {
        minCost = Integer.MAX_VALUE;
        List<Integer> bestRoute = new ArrayList<>();
        this.cities = cities;
        this.costs = costs;
    }

    public void graphFunc() {
        int numCities = cities.length;

        boolean[] visited = new boolean[numCities];
        visited[0] = true;

        List<Integer> currentRoute = new ArrayList<>();
        currentRoute.add(0);

        findCheapestRoute(costs, 0, visited, currentRoute, 0, numCities);

        System.out.print("Optimal Flight Route: ");
        for (int i = 0; i < bestRoute.size(); i++) {
            System.out.print(cities[bestRoute.get(i)]);
            if (i < bestRoute.size() - 1) System.out.print(" ➜ ");
        }
        System.out.println("\nTotal Minimal Airfare: $" + minCost);
    }

    private static void findCheapestRoute(int[][] graph, int currentCity, boolean[] visited,
                                          List<Integer> currentRoute, int currentCost, int numCities) {

        if (currentRoute.size() == numCities) {
            int returnCost = graph[currentCity][0];
            if (returnCost != 0 && returnCost != minCost) {
                int totalCost = currentCost + returnCost;
                if (totalCost < minCost) {
                    minCost = totalCost;
                    bestRoute = new ArrayList<>(currentRoute);
                    bestRoute.add(0);
                }
            }
            return;
        }

        if (currentCost >= minCost) {
            return;
        }

        for (int nextCity = 0; nextCity < numCities; nextCity++) {
            if (!visited[nextCity] && graph[currentCity][nextCity] != 0) {

                visited[nextCity] = true;
                currentRoute.add(nextCity);

                findCheapestRoute(graph, nextCity, visited, currentRoute, currentCost + graph[currentCity][nextCity], numCities);

                visited[nextCity] = false;
                currentRoute.remove(currentRoute.size() - 1);
            }
        }
    }
}