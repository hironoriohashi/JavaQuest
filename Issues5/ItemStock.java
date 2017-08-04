import java.util.ArrayList;

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

public class ItemStock {
    ArrayList<Item> itemStock = new ArrayList<>();

    public void add(Item item) {
        itemStock.add(item);
    }

    public int getNum(Item item) {
        int itemCount = 0;
        for (Item itemCompare : itemStock) {
            if (itemCompare.name.equals(item.name)) {
                itemCount++;
            }
        }
        return itemCount;
    }
}
