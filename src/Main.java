import model.Graph;
import util.LoadData;
import view.ConsoleInterface;

public class Main {
    public static void main(String[] args) {
        Graph graph = LoadData.loadFile("src/data/data.txt");
        ConsoleInterface ui = new ConsoleInterface(graph);
        ui.printTableGraph();
        ui.runDijkstra();
    }
}