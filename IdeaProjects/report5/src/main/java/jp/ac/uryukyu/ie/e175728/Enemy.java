package jp.ac.uryukyu.ie.e175728;

public class Enemy extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    int hit_num;

    public Enemy (String name, int maximumHP, int attack) {
        super(name,attack);
        setHitPoint(maximumHP);
        setDead(false);
        this.hit_num=getHitPoint();
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */

    @Override
    public void wounded(int damage){
        int leftover_hitpoint=hit_num -= damage;
        setHitPoint(leftover_hitpoint);
        if( getHitPoint() < 1 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }
}
