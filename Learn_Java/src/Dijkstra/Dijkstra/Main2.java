package Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main2 {
  public static void main(String[]args) {

    // ノードの情報をプログラムにあたえる
    
    int[][] nodeDates = new int[][] {
      {0, 1, 1}, {0, 2, 3}, {1, 0, 1}, {1, 2, 2}, {2, 0, 2}, {2, 1, 1}
    
    };

    // Vertexのリストを作成
    List<Vertex> vertexList = new ArrayList<>();
    for (int i = 0; i < nodeDates.length; i++) {
        int startingPointId = nodeDates[i][0];
        int endingPointId = nodeDates[i][1];
        if (!containsVertex(vertexList, startingPointId)) {
            vertexList.add(new Vertex(startingPointId));
        }
        if (!containsVertex(vertexList, endingPointId)) {
            vertexList.add(new Vertex(endingPointId));
        }
    }

    // Nodeのリストを生成
    List<Node> nodeList = new ArrayList<>();
    for (int i = 0; i < nodeDates.length; i++) {
        int startingPointId = nodeDates[i][0];
        int endingPointId = nodeDates[i][1];
        int cost = nodeDates[i][2];
        Vertex startingPoint = findVertex(vertexList, startingPointId);
        Vertex endingPoint = findVertex(vertexList, endingPointId);
        nodeList.add(new Node(startingPoint, endingPoint, cost));
    }

      System.out.println("地点0は現時点で" + vertexList.get(0).confirmed);


    // スタート地点を決める 今回は2をスタートにする
    
      Vertex start = vertexList.get(2);

      start.shortestCost = 0;
      start.confirmed = true;

      // 情報更新状況の確認
      System.out.println("地点0は現時点で" + vertexList.get(0).confirmed);
      System.out.println("地点1は現時点で" + vertexList.get(1).confirmed);
      System.out.println("地点2は現時点で" + vertexList.get(2).confirmed);


    
    // 現在地の情報をcurrentVertexに格納
    Vertex currentVertex = start;
    int currentCost = 0;

//     for (Node node : nodeList) {
//       if (node.startingPoint == start) {

//         if (node.endingPoint.confirmed = false) {
//           currentCost += node.cost;
//           if (node.endingPoint.shortestCost == Integer.MAX_VALUE) {
//             node.endingPoint.shortestCost = currentCost; 

//           } else {
//             node.endingPoint.shortestCost = Math.min(node.endingPoint.shortestCost, currentCost);
//           }
//         }
//       }
//     }

// // 出てきているコストの中で最小値のものを確定させる
//     int min = 0;

//     for (Entry<Integer, Vertex> entry : vertexMap.entrySet()) {
//       Vertex value = entry.getValue();
//       if (value.confirmed == false) {
//         // 最小値のものを探す
//         min = Math.min(min, value.shortestCost);

//       }

//     }

//     System.out.println(min);
//     for (Entry<Integer, Vertex> entry : vertexMap.entrySet()) {
//       Vertex value = entry.getValue();
//       if (value.shortestCost == min) {
//         value.confirmed = true;

//       }
//     }

//     System.out.println("スタート地点は現時点で" + start.confirmed); // スタート地点のコストが0で確定されたか確認
//     System.out.println("地点1は現時点で" + vertexMap.get(1).confirmed);
//     System.out.println("地点0は現時点で" + vertexMap.get(0).confirmed);




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
