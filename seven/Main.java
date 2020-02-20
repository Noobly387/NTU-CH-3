package seven;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main extends JFrame {
    private static final long serialVersionUID = 930103831987201154L;
    Player[] players = new Player[22];

    public static void main(String[] args) {
        JFrame frame = new JFrame();

    }

    Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        pack();
        repaint();
        for (int i = 0; i < 22; i++) {
            players[i] = new Player(10 * (i / 11), 10 * i, 0);
        }
    }

    @Override
    public void paint(Graphics g) {

    }
}