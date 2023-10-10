package Traning;
/**
 * 猫を表すクラスです。
 */
 public class Cat {

  //名前
  public String name = "花子";
  //鳴く回数
  public int cryCount = 1;
  /**
  * 鳴きます
  */
  public void cry(){
   System.out.print(this.name + "「");
   for(int i = 0; i < this.cryCount; i ++) {

    System.out.print("ニャー");
   }
  System.out.println("」");
  }
 
}
