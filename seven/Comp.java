package seven;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

class Comp extends JComponent {
    private static final long serialVersionUID = 1L;

    /**
     * constructs players with corresponding starting positions
     */
    Comp() {
        for (int i = 0; i < 11; i++) {
            players[i] = new Player(i, 100, 200 + 10 * i);
        }
        for (int i = 11; i < 22; i++) {
            players[i] = new Player(i, 500, 200 + 10 * (i - 11));
        }
    }

    Player[] players = new Player[22];
    Ball ball = new Ball(300, 300, 0);

    /**
     * Paints players and ball, moves them when necessary. Driver method. Stops when
     * a goal is made.
     */
    @Override
    public void paint(Graphics g) {
        for (Player p : players) {
            if (p.number < 11) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.red);
            }
            g.fillOval((int) p.x, (int) p.y, 5, 5);
            if (ball.x >= 600 || ball.x <= 0) {
                p.jump(1);
                System.out.println(ball);
            } else if (p.near(ball)) {
                p.kick(ball);
            } else {
                System.out.println("a");
                p.move(ball.x - p.x, ball.y - p.y);
            }
        }
        g.setColor(Color.black);
        g.fillOval((int) ball.x, (int) ball.y, 5, 5);
        repaint();
    }

}