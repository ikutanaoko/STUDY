package Dijkstra;

public class Edge {

  Vertex startingPoint;
  Vertex endingPoint;
  int cost;

  public Edge(Vertex startingPoint, Vertex endingPoint, int cost) {
    this.startingPoint = startingPoint;
    this.endingPoint = endingPoint;
    this.cost = cost;
  }

}
