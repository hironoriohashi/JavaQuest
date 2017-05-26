/**
 * （JUnit実践入門より）
 * 処理をバックグラウンドのスレッドで非同期に実行したい。
 * バックグラウンドスレッドで処理するBackgroundTaskクラスを作成し、
 * タスクがバックグラウンドのスレッドで実行されることを検証するテストを作成せよ。
 * なお、タスクはRunnableオブジェクトに実装する。
 *
 * ヒント
 *
 * 設計
 * BackgroundTaskは、コンストラクタでRunnableオブジェクトを引数に持つ
 * BackgroundTaskクラスに、invokeメソッドを定義する
 * invokeメソッドは、引数を持たず、戻り値をvoid型とする
 * invokeメソッドでは、バックグラウンドスレッドでタスクを実行し、すぐに制御を呼び出し元に返す
 *
 * テストケース
 * invokeメソッドによりRunnableオブジェクトのrunメソッドが別スレッドで実行される
*/

class BackgroundTask {
    Thread background;

    BackgroundTask(Runnable run) {
        background = new Thread(run);
    }

    public void invoke() {
        background.start();
    }
}
