package app;

public class Buttle {
  // ヒーロー達
  public Hero[] heros;
  // 敵達
  public Enemy[] enemies;

  // 登場人物の用意 heroNumber: ヒーローの数 enemyNumber: 敵の数
  public void init(int heroNumber, int enemyNumber) {
    // 'try'はsleepを使うためのおまじない
    try {
      System.out.println("===============================================================");
      System.out.println();

      // 配列の初期化
      heros = new Hero[heroNumber];
      enemies = new Enemy[enemyNumber];

      for (int i = 0; i < heroNumber; i++) {
        // Hero(体力, 名前)でヒーローを作る
        Hero hero = new Hero(100, "hero" + i);
        heros[i] = hero;
      }

      for (int i = 0; i < enemyNumber; i++) {
        // Enemy(体力, 名前)で敵を作る
        Enemy enemy = new Enemy(100, "enemy" + i);
        enemies[i] = enemy;
      }

      // 画面に表示
      System.out.println("Heros");
      for (int i = 0; i < heros.length; i++) {
          System.out.println("Name: " + heros[i].name + ", HP: " + heros[i].hp);
      }
      System.out.println("Enemies");
      for (int i = 0; i < enemies.length; i++) {
          System.out.println("Name: " + enemies[i].name + ", HP: " + enemies[i].hp);
      }

      System.out.println();
      System.out.println("===============================================================");
      System.out.println();
      // 2秒待つ
      Thread.sleep(2000);
    } catch (InterruptedException e) {} // sleepを使うためのおまじない
  }

  // バトルを始める
  public void startButtle() {
    try{
      // 無限ループ breakを呼ぶと終わる
      while(true) {
        // 何番目のheroが攻撃するのか
        // (int)(Math.random() * n)で0~nのランダムな整数を作る
        int attackerNumber = (int)(Math.random() * heros.length);
        // 何番目のenemyが攻撃されるのか
        int receiverNumber = (int)(Math.random() * enemies.length);
        // 攻撃するhero
        Hero heroAttacker = heros[attackerNumber];
        // 攻撃されるenemy
        Enemy enemyReceiver = enemies[receiverNumber];
        // 攻撃の実行
        heroAttacker.attack(enemyReceiver);
        // 1秒待つ
        Thread.sleep(1000);

        System.out.println();

        // 攻守交代
        attackerNumber = (int)(Math.random() * enemies.length);
        receiverNumber = (int)(Math.random() * heros.length);
        Enemy enemyAttacker = enemies[attackerNumber];
        Hero heroReceiver = heros[receiverNumber];
        enemyAttacker.attack(heroReceiver);

        System.out.println();
        System.out.println("===============================================================");
        System.out.println();
        Thread.sleep(1500);

        // 互いにさっきの攻撃で死んだかどうか
        Boolean isDeadHero = heroReceiver.isDead();
        Boolean isDeadEnemy = enemyReceiver.isDead();

        // &&: 左右のどっちもtrueならtrue
        // !: 後に来るBooleanを逆転
        if (isDeadHero && !isDeadEnemy) {
            Thread.sleep(1000);
            System.out.println("Enemyの勝ち");
            break;
        } else if (!isDeadHero && isDeadEnemy) {
            Thread.sleep(1000);
            System.out.println("Heroの勝ち");
            break;
        } else if (isDeadHero && isDeadEnemy) {
            Thread.sleep(1000);
            System.out.println("引き分け");
            break;
        }
      }
    } catch (InterruptedException e) {}
  }
}
