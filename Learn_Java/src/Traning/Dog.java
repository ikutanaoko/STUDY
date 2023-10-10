package Traning;
/**
 * 犬を表すクラスです。
 */
public class Dog {

   //名前
  public String name = "太郎";
  //鳴く回数
  public int cryCount = 1;


 /**
  * 鳴きます
  */
  public void cry(){
    System.out.print(this.name + "「");
    for(int i = 0; i < this.cryCount; i ++) {
 
     System.out.print("ワン");
    }
   System.out.println("」");

  }

  /**
   * お座りします
   */
  public void sitDown() {
    System.out.println(this.name + "は座りました");
  }
 
}
