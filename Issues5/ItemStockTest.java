import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * （JUnit実践入門より）
 * 商品を表すItemクラスが定義されているとき、
 * 商品を追加／削除／数量の変更などができるItemStockクラスを作成したい。
 * 商品を追加するaddメソッドのテストを作成せよ。
 * なお、商品は商品名（name）で一意に識別できるとする。
 *
 * public class Item {
 *     public final String name;
 *     public final int price;
 *     public Item(String name, int price) {
 *         this.name = name;
 *         this.price = price;
 *     }
 * }
 *
 * ヒント
 * 設計
 * ItemStockクラスにaddメソッドを定義する
 * addメソッドはItem型の引数を１つ持ち、戻り値はvoidとする
 * ItemStockクラスは、指定したItemオブジェクトの数量を返すgetNumメソッドを持つ
 * getNumメソッドは、Item型の引数を１つ持ち、戻り値はintとする
 * getNumメソッドは、指定したItemオブジェクトが登録されていない場合は0を返す
 * テストケース
 * 初期状態で、getNumで0が取得できる
 * 初期状態で、addでItemを追加するとgetNumで1が取得できる
 * Itemが１つ追加されている状態で、getNumで1が取得できる
 * Itemが１つ追加されている状態で、addで同じItemオブジェクトを追加するとgetNumで2が取得できる
 * Itemが１つ追加されている状態で、addで同じItemオブジェクトを追加するとgetNumで1が取得できる
*/

@RunWith(Enclosed.class)
public class ItemStockTest {

    public static class 初期状態でのテスト {
        ItemStock itemStock;

        @Before
        public void setup() {
            itemStock = new ItemStock();
        }

        @Test
        public void 初期状態だった場合にgetNumで0が得られること() {
            Item item = new Item("item", 1);
            assertThat(itemStock.getNum(item), is(0));
        }

        @Test
        public void 初期状態でItemをaddするとgetNumで1が得られること() {
            Item item = new Item("item", 1);
            itemStock.add(item);
            assertThat(itemStock.getNum(item), is(1));
        }
    }

    public static class Itemが1つ追加されている状態でのテスト {
        ItemStock itemStock;

        @Before
        public void setup() {
            itemStock = new ItemStock();
            Item item = new Item("item", 1);
            itemStock.add(item);
        }

        @Test
        public void Itemが1つ追加されている状態でのgetNumで1が得られること() {
            Item item = new Item("item", 1);
            assertThat(itemStock.getNum(item), is(1));
        }

        @Test
        public void Itemが1つ追加されている状態でaddで同じItemオブジェクトを追加するとgetNumで2が得られること() {
            Item item = new Item("item", 1);
            itemStock.add(item);
            assertThat(itemStock.getNum(item), is(2));
        }

        @Test
        public void Itemが1つ追加されている状態でaddで別のItemオブジェクトを追加するとgetNumでそれぞれ1が得られること() {
            Item item = new Item("item", 1);
            Item item2 = new Item("item2", 2);
            itemStock.add(item2);
            assertThat(itemStock.getNum(item), is(1));
            assertThat(itemStock.getNum(item2), is(1));
        }
    }
}
