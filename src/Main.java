import model.Graph;
import util.LoadData;

public class Main {
    public static void main(String[] args) {
        Graph graph = LoadData.loadFile("src/data/data.txt");

        System.out.println(graph.isDirected());
    }
}