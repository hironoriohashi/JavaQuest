
/**
 * （JUnit実践入門より）
 * 整数値を引数として持ち、
 * 偶数である場合にtrueを返すisEvenメソッドのテストを作成せよ。
 * isEvenメソッドはNumberUtilsクラスにstaticメソッドとして定義する。
 * ヒント
 * 設計
 * NumberUtilsクラスにisEventメソッドを定義する
 * isEvenメソッドはint型の引数xを持ち、戻り値をboolean型とする
 * xが2で割り切れる場合にtrueを返す
 * テストケース
 * 入力値に10を与えると、trueを返す
 * 入力値に7を与えると、falseを返す
*/

class NumberUtils {
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
