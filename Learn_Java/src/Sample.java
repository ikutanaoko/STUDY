import java.util.ArrayList;
import java.util.List;

import Dijkstra.Node;
import Dijkstra.Vertex;

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
                
    public class Main {
        public static void main(String[] args) {
            int[][] inputArray = {
                {0, 1, 1}, {0, 2, 3}, {1, 0, 1}, {1, 2, 2}, {2, 0, 2}, {2, 1, 1}
            };
    
            // Vertexのリストを作成
            List<Vertex> vertexList = new ArrayList<>();
            for (int i = 0; i < inputArray.length; i++) {
                int startingPointId = inputArray[i][0];
                int endingPointId = inputArray[i][1];
                if (!containsVertex(vertexList, startingPointId)) {
                    vertexList.add(new Vertex(startingPointId));
                }
                if (!containsVertex(vertexList, endingPointId)) {
                    vertexList.add(new Vertex(endingPointId));
                }
            }
    
            // Nodeのリストを生成
            List<Node> nodeList = new ArrayList<>();
            for (int i = 0; i < inputArray.length; i++) {
                int startingPointId = inputArray[i][0];
                int endingPointId = inputArray[i][1];
                int cost = inputArray[i][2];
                Vertex startingPoint = findVertex(vertexList, startingPointId);
                Vertex endingPoint = findVertex(vertexList, endingPointId);
                nodeList.add(new Node(startingPoint, endingPoint, cost));
            }
    
            // Nodeの情報を出力
            for (Node node : nodeList) {
                System.out.println("StartingPoint ID: " + node.startingPoint.id +
                        ", EndingPoint ID: " + node.endingPoint.id +
                        ", Cost: " + node.cost);
            }
    
            // 各Vertexの情報を書き換え
            for (Node node : nodeList) {
                node.startingPoint.setConfirmed(true);
                node.endingPoint.setConfirmed(true);
                node.startingPoint.setCost(10);
                node.endingPoint.setCost(20);
            }
    
            // 書き換えたVertexの情報を出力
            System.out.println("===== 書き換え後 =====");
            for (Vertex vertex : vertexList) {
                System.out.println("Vertex ID: " + vertex.id +
                        ", Cost: " + vertex.cost +
                        ", Confirmed: " + vertex.confirmed);
            }
        }
    
        private static boolean containsVertex(List<Vertex> vertexList, int id) {
            for (Vertex vertex : vertexList) {
                if (vertex.id == id) {
                    return true;
                }
            }
            return false;
        }
    
        private static Vertex findVertex(List<Vertex> vertexList, int id) {
            for (Vertex vertex : vertexList) {
                if (vertex.id == id) {
                    return vertex;
                }
            }
            return null;
        }
    }
    
}