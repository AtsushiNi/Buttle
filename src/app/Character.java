package app;

public class Character {
  // 体力
  public int hp;
  // 名前
  public String name;

  // コンストラクタ
  public Character(int hp, String name) {
    this.hp = hp;
    this.name = name;
  }

  // 攻撃する
  public void attack(Character receiver) {
    // (int)(Math.random() * n)で0~nのランダムな整数を作る
    int power = (int)(Math.random() * 100) + 1;
    System.out.println("(攻撃力: " + power + ")");

    // 攻撃された側の処理(powerだけhpを減らす)
    receiver.receiveAttack(power);
  }

  // 攻撃をされる
  public void receiveAttack(int power) {
    this.hp = this.hp - power;
  }

  // hpが0以下なら死亡
  public Boolean isDead() {
    if (this.hp < 0) {
      return true;
    } else {
      return false;
    }
  }
}
