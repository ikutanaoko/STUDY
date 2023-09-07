public class Primitive {
  public static void main(String[] args) throws Exception {
    int intValue = 123;
    long longValue = intValue;
    short shortValue = (short)intValue;
    System.out.println(longValue);
    System.out.println(intValue);
    System.out.println(shortValue);
  }
}
