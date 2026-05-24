public class Main {

    public static void main(String[] args) {
        graphTheory();
    }

    public static void graphTheory() {
        String[] cities = {"San Francisco", "Los Angeles", "Denver", "Detroit", "New York"};

        int[][] costs = {
                {0, 69, 179, 329, 359},    // San Francisco
                {69, 0, 209, 349, 379},    // Los Angeles
                {179, 209, 0, 229, 279},   // Denver
                {329, 349, 229, 0, 189},   // Detroit
                {359, 379, 279, 189, 0}    // New York
        };

        new Graph(cities, costs).graphFunc();
    }

}
