//https://www.milk-island.net/document/java/kihon/k1/

package Traning4;

public class Animal {

 /**
  *メインメソッド 
  *@param argsuments 引数
  */

  public static void main(String[]args){
   //インスタンスを作成
   Dog dog1 = new Dog("ポチ");
   Dog dog2 = new Dog("クロ",5);

   Cat cat1 = new Cat();
   Cat cat2 = new Cat("タマ");
   Cat cat3 = new Cat("ミケ",4);

   //犬のインスタンスメソッドを実行
   dog1.cry();
   dog1.sitDown();
   dog2.cry();

   //猫のインスタンスメソッドを実行
   cat1.cry();
   cat2.cry();
   cat3.cry();


  }
 
}
