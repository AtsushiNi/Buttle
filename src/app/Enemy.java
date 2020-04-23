package app;

public class Enemy extends Character {
    // コンストラクタ
    public Enemy(int hp, String name) {
        super(hp, name);
    }

    // 攻撃する
    public void attack(Hero hero) {
        System.out.print("この俺" + this.name + "様の攻撃！　死ねぇぇぇ！！");
        super.attack(hero);
    }

    // 攻撃される
    public void receiveAttack(int power) {
        super.receiveAttack(power);
        System.out.println("この俺様" + this.name + "が死ぬ訳ねぇっ！　しかし体力はあと" + this.hp + "しか...");
    }

    // 死んだかどうか
    public Boolean isDead() {
        Boolean isDead = super.isDead();
        if (isDead) {
            System.out.println("この俺様" + this.name + "があいつらなんかに負けるなんて...");
        }
        return isDead;
    }
}
