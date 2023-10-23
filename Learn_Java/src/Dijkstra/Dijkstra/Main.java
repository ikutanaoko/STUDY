package Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[]args) {

    // ノードの情報をプログラムにあたえる
    
    int[][] edgeDates = new int[][] {
      {0, 1, 1}, {0, 2, 3}, {1, 0, 1}, {1, 2, 2}, {2, 0, 3}, {2, 1, 2}
    
    };

    // Vertexオブジェクトのマップを生成
    Map<Integer, Vertex> vertexMap = new HashMap<>();


    // マップから既存のVertexオブジェクトを取得するか、新しいVertexオブジェクトを生成してマップに追加する
    for (int[] data : edgeDates) {
      int startingPoint = data[0];
     
      Vertex startingVertex = vertexMap.get(startingPoint);
      if (startingVertex == null) {
        startingVertex = new Vertex();
        vertexMap.put(startingPoint, startingVertex);
      }
    }


    // edgeインスタンスを格納するリストを生成 ※最大値が分からないのでリスト
    List<Edge> edgeList = new ArrayList<>();

    for (int[] data : edgeDates) {
      Vertex startingPoint = getVertex(vertexMap, data[0]);
      Vertex endingPoint = getVertex(vertexMap, data[1]);
      int cost = data[2];

      edgeList.add(new Edge(startingPoint, endingPoint, cost));

    }

    // スタート地点を決める 今回は2をスタートにする
    
    Vertex start = getVertex(vertexMap, 2);

    start.shortestCost = 0;
    start.confirmed = true;

    // 情報を格納できているか確認
    System.out.println("スタート地点は現時点で" + start.confirmed);
    System.out.println("地点0は現時点で" + getVertex(vertexMap, 0).confirmed);
    System.out.println("------------------------------");

    
    // 現在地の情報をcurrentVertexに格納
    Vertex currentVertex = start;
    int currentCost = start.shortestCost;

    for (Edge edge : edgeList) {
      int entryCost = currentCost;
      if (edge.startingPoint == currentVertex) {
        if (edge.endingPoint.confirmed == false) {
          entryCost += edge.cost;
          if (edge.endingPoint.shortestCost == Integer.MAX_VALUE) {
            edge.endingPoint.shortestCost = entryCost; 

          } else {
            edge.endingPoint.shortestCost = Math.min(edge.endingPoint.shortestCost, entryCost);
          }
        }
      } 
    }

    System.out.println("地点0の最短コストは3?" + getVertex(vertexMap, 0).shortestCost);
    System.out.println("地点1の最短コストは2?" + getVertex(vertexMap, 1).shortestCost);
    System.out.println("地点2の最短コストは0?" + getVertex(vertexMap, 2).shortestCost);


// 出てきているコストの中で最小値のものを確定させる
    int confirmingCost = Integer.MAX_VALUE;
    Vertex confirmingVertex = currentVertex;
    for (Vertex mapValue : vertexMap.values()) {

     if (mapValue.confirmed == false) {
        // 最小値のものを探す
        confirmingCost = Math.min(confirmingCost, mapValue.shortestCost);
        if (confirmingCost == mapValue.shortestCost) {
          confirmingVertex = mapValue;
        }

      }

    }


    confirmingVertex.confirmed = true;

    System.out.println("スタート地点は現時点で" + start.confirmed + start.shortestCost); // スタート地点のコストが0で確定されたか確認
    System.out.println("地点1は現時点で" + getVertex(vertexMap,1).confirmed + getVertex(vertexMap,1).shortestCost);
    System.out.println("地点0は現時点で" + getVertex(vertexMap,0).confirmed + getVertex(vertexMap,0).shortestCost);

  //------------------------------------------------------------------


    currentVertex = confirmingVertex;
    currentCost = confirmingCost;

    for (Edge edge : edgeList) {
      int entryCost = currentCost;
      if (edge.startingPoint == currentVertex) {
        if (edge.endingPoint.confirmed == false) {
          entryCost += edge.cost;
          if (edge.endingPoint.shortestCost == Integer.MAX_VALUE) {
            edge.endingPoint.shortestCost = entryCost; 

          } else {
            edge.endingPoint.shortestCost = Math.min(edge.endingPoint.shortestCost, entryCost);
          }
        }
      } 
    }

    System.out.println("地点0の最短コストは3?" + getVertex(vertexMap, 0).shortestCost);
    System.out.println("地点1の最短コストは2?" + getVertex(vertexMap, 1).shortestCost);
    System.out.println("地点2の最短コストは0?" + getVertex(vertexMap, 2).shortestCost);


// 出てきているコストの中で最小値のものを確定させる
    confirmingCost = Integer.MAX_VALUE;
    confirmingVertex = currentVertex;
    for (Vertex mapValue : vertexMap.values()) {

     if (mapValue.confirmed == false) {
        // 最小値のものを探す
        confirmingCost = Math.min(confirmingCost, mapValue.shortestCost);
        if (confirmingCost == mapValue.shortestCost) {
          confirmingVertex = mapValue;
        }

      }

    }


    confirmingVertex.confirmed = true;

    System.out.println("スタート地点は現時点で" + start.confirmed + start.shortestCost); // スタート地点のコストが0で確定されたか確認
    System.out.println("地点1は現時点で" + getVertex(vertexMap,1).confirmed + getVertex(vertexMap,1).shortestCost);
    System.out.println("地点0は現時点で" + getVertex(vertexMap,0).confirmed + getVertex(vertexMap,0).shortestCost);

  //------------------------------------------------------------------

  }


  

    
  // マップからVertexを取得するメソッド
  private static Vertex getVertex(Map<Integer,Vertex> vertexMap,int vertex) {  

    return vertexMap.get(vertex);

  }


 
}
