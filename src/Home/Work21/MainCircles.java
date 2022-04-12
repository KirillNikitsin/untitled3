package Home.Work21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private Ball[] sprites = new Ball[10];
    private int a;
    private void plus(Sprite s){
        if(a == sprites.length){
            Sprite [] b = new Sprite[sprites.length + 1];
            System.arraycopy(sprites, 0, b, 0, sprites.length);
            sprites = (Ball[]) b;
            }
        sprites[a++] = (Ball) s;
        }
    private void minus(){
        if(a > 1) {
            a--;
        }
        }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < a; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < a; i++) {
            sprites[i].render(canvas, g);
        }
    }
    void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime) {
        update(c, deltaTime);
        render(c, g);
    }

    private void initApplication() {
        for (int i = 0; i < a; i++) {
            sprites[i] = new Ball();
        }
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);
        initApplication();
        setVisible(true);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    plus(new Ball());
                    new Ball();
                }
                else if(e.getButton() == MouseEvent.BUTTON3) {
                    minus();

                }
                }
            });
        }


    public static void main(String[] args) {
        new MainCircles();
    }

}