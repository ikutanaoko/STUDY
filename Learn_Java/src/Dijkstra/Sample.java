import java.util.List;

public class Sample {
  public static void dijkstra(List<Node> graph, Vertex startVertex) {
        startVertex.shortestDistance = 0;

        while (true) {
            Vertex current = null;
            int minDistance = Integer.MAX_VALUE;

            for (Node node : graph) {
                if (!node.startingPoint.confirmed && node.startingPoint.shortestDistance < minDistance) {
                    current = node.startingPoint;
                    minDistance = node.startingPoint.shortestDistance;
                }
            }
            if (current == null) {
              break;
          }

          current.confirmed = true;

          for (Node node : graph) {
              if (node.startingPoint == current && !node.endingPoint.confirmed &&
                      current.shortestDistance + node.cost < node.endingPoint.shortestDistance) {
                  node.endingPoint.shortestDistance = current.shortestDistance + node.cost;
              }
          }

        }  
      }  
}