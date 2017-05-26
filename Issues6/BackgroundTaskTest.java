
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

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class BackgroundTaskTest {

    @Test
    public void Runnableオブジェクトを渡すとバックグラウンドでrunが実行されること() throws InterruptedException, ExecutionException {

        Callable<Integer> rn = () -> {//スレッドに行わせる処理
                Integer a = 0;
            a++;
            return a;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> retian = executor.submit(rn);
        BackgroundTask backgroundTask = new BackgroundTask((Runnable) retian);
        backgroundTask.invoke();

        //スレッドでaのインクリメントが行われたかを確認する
        assertThat(retian.get(), is(1));
    }

}
