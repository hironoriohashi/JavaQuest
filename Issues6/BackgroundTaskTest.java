
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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class BackgroundTaskTest {

    @Test
    public void Runnableオブジェクトを渡すとバックグラウンドでrunが実行されること() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(1);

        //スレッドに行わせる処理
        Runnable rn = () -> {
            queue.add(1);
        };

        BackgroundTask backgroundTask = new BackgroundTask(rn);
        backgroundTask.invoke();

        //スレッドを動作させると、キューに1が挿入されていること
        assertThat(queue.take(), is(1));
    }
}
