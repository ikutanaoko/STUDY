package Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
  public static void main(String[]args) {

    // ノードの情報をプログラムにあたえる
    
    int[][] nodeDates = new int[][] {
      {0, 1, 1}, {0, 2, 3}, {1, 0, 1}, {1, 2, 2}, {2, 0, 2}, {2, 1, 1}
    
    };

    // Vertexオブジェクトのマップを生成
    Map<Integer, Vertex> vertexMap = new HashMap<>();


    // Nodeインスタンスを格納するリストを生成 ※最大値が分からないのでリスト
    List<Node> nodeList = new ArrayList<>();

    for (int[] data : nodeDates) {
      int startingPointId = data[0];
      int endingPointId = data[1];
      int cost = data[2];

      // マップから既存のVertexオブジェクトを取得するか、新しいVertexオブジェクトを生成してマップに追加する
      Vertex startingPoint = vertexMap.get(startingPointId);
      if (startingPoint == null) {
        startingPoint = new Vertex(startingPointId);
        vertexMap.put(startingPointId, startingPoint);

      }

      // マップから既存のVertexオブジェクトを取得するか、新しいVertexオブジェクトを生成してマップに追加する
      Vertex endingPoint = vertexMap.get(endingPointId);
      if (endingPoint == null) {
        endingPoint = new Vertex(endingPointId);
        vertexMap.put(endingPointId, startingPoint);

      }

      Node node = new Node(startingPoint, endingPoint, cost);
      nodeList.add(node);

    }

        System.out.println("地点0は現時点で" + vertexMap.get(0).confirmed);


    // スタート地点を決める 今回は2をスタートにする
    
    Vertex start = vertexMap.get(2);

    start.shortestCost = 0;
    start.confirmed = true;

    System.out.println(start.confirmed); // スタート地点のコストが0で確定されたか確認
        System.out.println("地点0は現時点で" + vertexMap.get(0).confirmed);


    
    // 現在地の情報をcurrentVertexに格納
    Vertex currentVertex = start;
    int currentCost = 0;

    for (Node node : nodeList) {
      if (node.startingPoint == start) {

        if (node.endingPoint.confirmed = false) {
          currentCost += node.cost;
          if (node.endingPoint.shortestCost == Integer.MAX_VALUE) {
            node.endingPoint.shortestCost = currentCost; 

          } else {
            node.endingPoint.shortestCost = Math.min(node.endingPoint.shortestCost, currentCost);
          }
        }
      }
    }

// 出てきているコストの中で最小値のものを確定させる
    int min = 0;

    for (Entry<Integer, Vertex> entry : vertexMap.entrySet()) {
      Vertex value = entry.getValue();
      if (value.confirmed == false) {
        // 最小値のものを探す
        min = Math.min(min, value.shortestCost);

      }

    }

    System.out.println(min);
    for (Entry<Integer, Vertex> entry : vertexMap.entrySet()) {
      Vertex value = entry.getValue();
      if (value.shortestCost == min) {
        value.confirmed = true;

      }
    }

    System.out.println("スタート地点は現時点で" + start.confirmed); // スタート地点のコストが0で確定されたか確認
    System.out.println("地点1は現時点で" + vertexMap.get(1).confirmed);
    System.out.println("地点0は現時点で" + vertexMap.get(0).confirmed);




  }  


 
}
