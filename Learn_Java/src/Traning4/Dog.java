package Traning4;
/**
 * 犬を表すクラスです。
 */
public class Dog {

  //名前
  private String name;
  //鳴く回数
  private int cryCount;


  //コンストラクタ @param name 名前
  public Dog(String name) {
    this(name,1);
  } 

  //コンストラクタ @param name 名前 @param cryCount 鳴く回数
  public Dog(String name, int cryCount) {
    this.setName(name);
    this.cryCount = cryCount;
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
  *インスタンス変数は自身のクラスのインスタンス変数をthis.～で利用できる
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
