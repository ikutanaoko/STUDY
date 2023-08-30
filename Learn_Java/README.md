---------------------------
このコードは、Javaプログラムの簡単な例を示しています。以下でその内容を解説します。

- public class App:
クラスの定義を始めています。Javaプログラムは通常、クラスという基本的な構造を持ちます。
クラス名は "App" です。このクラスはプログラムのエントリポイントとなります。

- public static void main(String[] args) throws 
Exception:
main メソッドの定義です。Javaプログラムの実行は、main メソッドから始まります。
public はアクセス修飾子であり、static は静的メソッドを示します。void はメソッドが戻り値を返さないことを示します。

- String[] args 
はコマンドライン引数を表す文字列の配列です。プログラムを実行する際にコマンドライン引数を指定することができます。
throws Exception は例外の処理を示しており、ここでは例外をそのままスローしているだけです。

- System.out.println("Hello, World");:
文字列 "Hello, World" を表示するための命令です。System.out は標準出力を指します。
---------------------------

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
