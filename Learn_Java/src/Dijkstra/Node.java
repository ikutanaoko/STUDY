package Dijkstra;

public class Node {

  Vertex startingPoint;
  Vertex endingPoint;
  int cost;

  public Node(Vertex startingPoint, Vertex endingPoint, int cost) {
    this.startingPoint = startingPoint;
    this.endingPoint = endingPoint;
    this.cost = cost;
  }

 
}
