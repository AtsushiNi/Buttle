package app;

public class Hero extends Character {
    // コンストラクタ
    public Hero(int hp, String name) {
        super(hp, name);
    }

    // 攻撃する
    public void attack(Enemy enemy) {
        System.out.print(this.name + "の攻撃！ 悪よくたばれ！！");
        super.attack(enemy);
    }

    // 攻撃される
    public void receiveAttack(int power) {
        super.receiveAttack(power);
        System.out.println("このヒーロー" + this.name + "が負けるわけにはいかない！ しかし体力はあと" + this.hp + "しか...");
    }

    // 死んだかどうか
    public Boolean isDead() {
        Boolean isDead = super.isDead();
        if (isDead) {
            System.out.println("この正義の味方" + this.name + "が負けるなんて... もう終わりだ...");
        }
        return isDead;
    }
}
