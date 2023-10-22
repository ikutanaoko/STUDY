package Dijkstra;

public class Vertex {

  int id;
  int shortestCost;
  boolean confirmed = false;

  public Vertex(int id) {
    this.id = id;
    this.shortestCost = Integer.MAX_VALUE;
  }
  
 
}
