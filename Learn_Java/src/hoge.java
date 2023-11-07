import java.util.HashMap;
import java.util.Map;

public class hoge {
  public static void main(String[]args) {

    int[] array = new int[3];
    array[0] = 1;
    array[1] = 2;
    array[2] = 3;



    Map<Integer, int[]> hoge = new HashMap<>();

    hoge.put(1," hoge");
    hoge.put(2," fuga");
    
    String test = hoge.get(1);

    System.out.println(hoge.get(1));

    test = "テスト";
    
      System.out.println(hoge.get(1));



  }
  
}
