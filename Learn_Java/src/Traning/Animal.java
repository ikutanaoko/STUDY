//https://www.milk-island.net/document/java/kihon/k1/

package Traning;

public class Animal {

 /**
  *メインメソッド 
  *@param argsuments 引数
  */

  public static void main(String[]args){
   //インスタンスを作成
   Dog dog1 = new Dog();
   dog1.cryCount = 2;

   Dog dog2 = new Dog();
   dog2.name = "クロ";
   dog2.cryCount = 5;

   Cat cat1 = new Cat();
   cat1.cryCount = 3;

   //犬のインスタンスメソッドを実行
   System.out.println(dog1.name);
   dog1.set();

   System.out.println(dog1.name);
   dog1.cry();
   dog1.sitDown();
   dog2.cry();

   //猫のインスタンスメソッドを実行
   cat1.cry();


  }
 
}
