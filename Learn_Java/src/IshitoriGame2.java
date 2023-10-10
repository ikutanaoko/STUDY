import java.util.Random;
import java.util.Scanner;

/**
 * 石取りゲームを実行するクラス
 */
public class IshitoriGame2 {
    public static void main(String[] args) {
        // Scannerクラスのインスタンスを生成、引数は標準入力
        Scanner scanner = new Scanner(System.in);
        // Randomクラスのインスタンスを生成
        Random random = new Random();
        // ルール説明の表示
        System.out.println("石取りゲームを始めます。");
        System.out.println("あなたとコンピュータで1〜3個の任意の数の石を取り合い、");
        System.out.println("最後の石をとった方が負けです。");
        System.out.println("Enterキーをタップしてゲームを開始してください。");
        scanner.nextLine();
        // 取る石の数
        int stone = 0;
        // 10から50の中からランダムで石の初期値を決める
        int totalStone = random.nextInt(41) + 10;
        System.out.println(totalStone + "個の石がある状態でゲームを開始します。");
        System.out.println("Enterキーをタップして先攻後攻を決めてください。");
        scanner.nextLine();
        // 0か1の乱数を出し0ならプレイヤーが先攻、1の場合コンピュータが先攻として残りの石が0より大きい間順番に石をとる
        if (random.nextInt(2) == 0) {
            System.out.println("あなたが先攻です。");
            while (totalStone > 0) {
                totalStone = playerTurn(stone, totalStone, scanner);
                // 残りの石の数が0より大きい場合コンピュータのターンにうつる
                if (totalStone > 0) {
                    totalStone = computerTurn(stone, totalStone, random);
                } else {
                    break;
                }
            }
        } else {
            // コンピュータを先攻とし、残りの石の数が0より大きい間順番に石をとる
            System.out.println("コンピュータが先攻です。");
            while (totalStone > 0) {
                totalStone = computerTurn(stone, totalStone, random);
                // 残りの石の数が0より大きい場合プレイヤーのターンにうつる
                if (totalStone > 0) {
                    totalStone = playerTurn(stone, totalStone, scanner);
                } else {
                    break;
                }
            }
        }
        System.out.println("ゲームを終了します。");
        scanner.close();
    }


    /**
     *プレイヤーのターンの石を取る処理です。
     * @param stone プレイヤーが選択した取る石の数
     * @param totalStone 石の山のトータルの数
     * @param scanner scanner
     * @return 残った山の石の総数
//     * @exception 整数以外の値が入力された場合再入力をするようループします。
     */
    private static int playerTurn(int stone, int totalStone, Scanner scanner) {
        System.out.println("あなたのターンです。");
        // 取る石の数を入力させる
        System.out.println("取る石の数を入力してください。");
        // 1以上3以下の数字が入力されるまで繰り返し入力させる
        while (totalStone > 0) {
            try {
                stone = scanner.nextInt();
                // 入力された数値が1より小さいか3より大きい場合は再度入力をさせる
                while (stone < 1 || stone > 3) {
                    System.out.println("取る石の数は1個以上3個以下としてください。");
                    stone = scanner.nextInt();
                }
                // 石の数が0以下となったらプレイヤーが負けとなりゲームを終了させる
                if (totalStone - stone < 1) {
                    System.out.println("石がなくなりました。コンピュータの勝ちです。");
                    break;
                }
                // 石が残った場合は次のターンへ
                System.out.println((totalStone - stone) + "個の石が残っています。");
                break;
                // 整数以外の入力がされた場合は再度入力をさせる
            } catch (Exception e) {
                System.out.println("取る石の数は1以上3以下の数値で入力してください。");
                scanner.next();
            }
        }
        // 残りの石の数をtotalStoneに代入する
        totalStone -= stone;
        return totalStone;
    }
    /**
     *プレイヤーのターンの石を取る処理です。
     * @param stone コンピュータがランダムに選択した取る石の数
     * @param totalStone 石の山のトータルの数
     * @return 残った山の石の総数
     */
    private static int computerTurn(int stone, int totalStone, Random random) {
        // コンピュータのターンではランダムで1から3個の石をとる
        System.out.println("コンピュータのターンです。");
        stone = random.nextInt(3) + 1;
        // 石の数が０以下となったらコンピュータが負けとなりゲームを終了させる
        if (totalStone == stone) {
            System.out.println(stone + "個の石を取りました。");
            System.out.println("石がなくなりました。あなたの勝ちです。");
            // 残りの石よりも多い数を取ろうとした場合も負けだが表示を変える
        } else if (totalStone < stone ) {
            System.out.println(stone + "個の石を取ろうとしましたが石がなくなりました。あなたの勝ちです。");
            // 石が残った場合は次のターンへ
        } else {
            System.out.println(stone + "個の石を取りました。");
            System.out.println((totalStone - stone) + "個の石が残っています。");
        }
        // 残りの石の数をtotalStoneに代入する
        totalStone -= stone;
        return totalStone;
    }
}

