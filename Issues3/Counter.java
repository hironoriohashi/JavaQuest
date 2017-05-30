
/**
 * （JUnit実践入門より）
 * Counterクラスのincrementメソッドは、
 * 呼び出すごとに１ずつ加算された値を返す。
 * このメソッドのテストを作成せよ。
 * なお、初回のincrementメソッドの呼び出し時には１を返すこと。
 * ヒント
 * 設計
 * Counterクラスにincrementメソッドを定義する
 * Counterクラスに現在値を保持する初期値0のint型フィールドを定義する
 * incrementメソッドは引数を持たず、戻り値をint型とする
 * テストケース
 * 初期状態で、incrementメソッドを実行すると1が取得できる
 * incrementメソッドを１回実行した状態で、incrementメソッドを実行すると2が取得できる
 * incrementメソッドを50回実行した状態で、incrementメソッドを実行すると51が取得できる
*/

class Counter {
    private int numCounter;

    public Counter() {
        numCounter = 0;
    }

    public int increment() {
        return ++numCounter;
    }
}
