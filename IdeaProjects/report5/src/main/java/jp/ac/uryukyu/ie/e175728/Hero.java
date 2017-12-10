package jp.ac.uryukyu.ie.e175728;

public class Hero extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name      ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack    ヒーローの攻撃力
     */
    int hit_num;

    public Hero(String name, int maximumHP, int attack) {
        super(name,attack);
        setHitPoint(maximumHP);
        setDead(false);
        this.hit_num=getHitPoint();
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    @Override
    public void attack(LivingThing opponent){
        if (isDead()==false){
            int damage = (int) (Math.random() * getAttack());
            //ダメージが０かどうかの判定
            if (damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            }
            else {
                int critical_hit = (int) (Math.random() * 10 +1);
                if (critical_hit <= 4){
                    //クリティカルだった場合
                    damage = damage*2;
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n",getName(),opponent.getName(),damage);
                } else{
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                }
                opponent.wounded(damage);
            }
        }
    }
    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     *
     * @param damage 受けたダメージ
     */

    @Override
    public void wounded(int damage) {
        int leftover_hitpoint=hit_num -= damage;
        setHitPoint(leftover_hitpoint);
        if (getHitPoint() < 1) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}
