package Traning4;
/**
 * 猫を表すクラスです。
 */
 public class Cat {

  //名前
  private String name;
  //鳴く回数
  private int cryCount;

  //コンストラクタ
  public Cat() {
    this("名無しの猫",1);
    ;
  }
  //コンストラクタ @param name 名前
  public Cat(String name) {
    this(name,1);
  } 

  //コンストラクタ @param name 名前 @param cryCount 鳴く回数
  public Cat(String name, int cryCount) {
    this.setName(name);
    this.setCryCount(cryCount);
  }


  //名前の設定　@param name 名前
  public void setName(String name) {
    this.name = name;
  }

  //鳴く回数を設定 @param cryCount 鳴く回数
  public void setCryCount(int cryCount) {
    this.cryCount = cryCount;
  }


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
