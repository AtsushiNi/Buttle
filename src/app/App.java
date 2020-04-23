package app;

public class App {
    public static void main(String[] args) throws Exception {
      Buttle buttle = new Buttle();
      // 登場人物を用意
      buttle.init(3, 3);
      // バトル開始
      buttle.startButtle();
    }
}
