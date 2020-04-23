# Buttleプロジェクトの概要
    Hero: 複数
    Enemy: 複数

    Hero対Enemyの勝負

    互いに攻撃していく
    攻撃者、被攻撃者はランダム
    攻撃力もランダム

    誰か1人の体力が0以下になったら負け
    (同時に両方負けたら引き分け)

# クラスの構成

### Appクラス
- 全体のMain

### Buttleクラス
- 登場人物の設定(initメソッド)
- バトルのループ(startButtleメソッド)

### Characterクラス
- Hero, Enemyの継承元
- 攻撃する(attackメソッド)
- 攻撃をうける(receiveAttackメソッド)

####Heroクラス
####Enemyクラス
Characterクラスを継承
全てのメソッドをオーバーライド
