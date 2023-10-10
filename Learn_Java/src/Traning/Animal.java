package Traning;

public class Animal {

 /**
  *メインメソッド 
  *@param argsuments 引数
  */

  public static void main(String[]args){
   //インスタンスを作成
   Dog dog1 = new Dog();
   Dog dog2 = new Dog();
   Cat cat1 = new Cat();

   //犬のインスタンスメソッドを実行
   dog1.cry();
   dog1.sitDown();
   dog2.cry();

  }
 
}
