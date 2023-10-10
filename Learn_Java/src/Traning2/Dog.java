package Traning2;
/**
 * 犬を表すクラスです。
 */
public class Dog {

  //名前
  private String setName = "名無しの犬";
  //鳴く回数
  private int cryCount = 1;

//名前の設定　@param name 名前
  public void setSetName(String name) {
    this.setName = name;
  }

  //鳴く回数を設定 @param cryCount 鳴く回数
  public void setCryCount(int cryCount) {
    this.cryCount = cryCount;
  }

 /**
  * 鳴きます
  *インスタンス変数は自身のクラスのインスタンス変数をthis.～で利用できる
  */
  public void cry(){
    System.out.print(this.setName + "「");
    for(int i = 0; i < this.cryCount; i ++) {
 
     System.out.print("ワン");
    }
   System.out.println("」");

  }

  /**
   * お座りします
   */
  public void sitDown() {
    System.out.println(this.setName + "は座りました");
  }
 
}
