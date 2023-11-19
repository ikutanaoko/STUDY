import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class sample1 {
  public static void main(String[] args) {
    
    int[][] array = {{1, 2, 3}, {1, 2, 3}};

    int[] array2 = array[1].clone();


    System.out.println((array[0][1]).equals(array2[1]));
    // System.out.println(array.equals(array2));
    
    array2[1] = 3;
    System.out.println(array[1]);
    System.out.println(array2[1]);






  }


}