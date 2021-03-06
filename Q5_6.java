/**
 * List5-8のプログラムは、入力された文字列に応じて、
 * 「あ」なら「オレンジジュースです。」
 * 「い」なら「コーヒーです。」
 * 「あ」「い」以外なら「どちらでもありません。」
 * と表示するプログラムです。if文を使っていますが、これをswitch文を使うように変更してください。
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_6 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str;
            System.out.println("飲み物は何が好きですか？");
            System.out.println("あ＝オレンジジュース");
            System.out.println("い＝コーヒー");
            System.out.println("う＝どちらでもない");
            System.out.println("あ、い、う、のどれかを選んでください");

            switch (reader.readLine()) {
            case "あ":
                str = "オレンジジュースです。";
                break;
            case "い":
                str = "コーヒーです。";
                break;
            default:
                str = "どちらでもありません。";
                break;
            }

            System.out.println(str);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
