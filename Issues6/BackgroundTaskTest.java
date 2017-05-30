
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;

public class BackgroundTaskTest {
    ByteArrayOutputStream output;
    CountDownLatch doneSignal;

    @Before
    public void setup() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        doneSignal = new CountDownLatch(1);
    }

    @Test
    public void Runnableオブジェクトを渡すとバックグラウンドでrunが実行されること() throws Exception {

        //スレッドに行わせる処理
        Runnable rn = () -> {
            System.out.print("Process");
            doneSignal.countDown();
        };

        BackgroundTask backgroundTask = new BackgroundTask(rn);
        backgroundTask.invoke();

        //処理が終わるまで待つ
        doneSignal.await();

        //スレッドを動作させると標準出力に"Process"の文字列が出力されること
        assertThat(output.toString(), is("Process"));
    }
}
