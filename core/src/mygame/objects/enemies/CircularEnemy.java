package mygame.objects.enemies;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class CircularEnemy extends EnemyBasics {

    private int radX = 400;
    private int radY = 400;
    private float degree = 0;
    private int radious;
    private int speed;

    @Override
    public void init(int damage, int healthUpValue, Stage stage) {
        super.init(damage, healthUpValue, stage);
        setColor(Color.RED);
        setWidth(15);
        setHeight(15);

        radious = 60;
        speed = 100;
    }


    @Override
    protected void move(float delta) {
        double rads = Math.toRadians(90 - degree);
        // Calculate the otter point of the line
        int xPosy = Math.round((float) (radX + Math.cos(rads) * radious));
        int yPosy = Math.round((float) (radY + Math.sin(rads) * radious));

//        System.out.println("Radx is: " + radX);
//        System.out.println(String.format("Math.cos(%f): ", rads) + Math.cos(rads));
//        System.out.println(String.format("Math.cos(%f) * 100: ", rads) + Math.cos(rads) * 100);
        setX(xPosy);
        setY(yPosy);

        degree += delta * speed;
        radY -= delta;
        degree = degree % 360;


    }
}