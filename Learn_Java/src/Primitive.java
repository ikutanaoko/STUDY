public class Primitive {
  public static void main(String[] args) throws Exception {
    int intValue = 123;
    long longValue = intValue;
    // 大きさが違うため互換不可
    // short shortValue = (short)intValue;
    short shortValue = (short)longValue;
    System.out.println(longValue);
    System.out.println(intValue);
    System.out.println(shortValue);
    
  }
}
