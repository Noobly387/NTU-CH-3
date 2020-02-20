package seven;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Main extends JFrame {
    private static final long serialVersionUID = 930103831987201154L;

    public static void main(String[] args) {
        new Main();
    }

    /**
     * Starts the frame with a comp component
     */
    Main() {
        Comp comp = new Comp();
        setFocusable(true);
        setBackground(Color.white);
        setFocusTraversalKeysEnabled(false);
        setTitle("Hivolts Assignmnet");
        setResizable(true);
        setSize(600, 600);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(comp);
        pack();
        setVisible(true);
    }

}
