package six;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /**
     * Tests.
     * 
     * @param args doesn't matter
     */
    public static void main(String[] args) {
        Ball ball = new Ball(50, 50, 5, 10, 30);
        Container box = new Container(0, 0, 100, 100);
        for (int step = 0; step < 100; ++step) {
            ball.move();
            box.collides(ball);
            System.out.println(ball); // manual check the position of the ball
        }
    }

    /**
     * Constructs with params, x2 and y2 are set based on width and height
     * 
     * @param x      x1
     * @param y      y1
     * @param width  x2 is based on
     * @param height y2 is based on
     */
    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width - 1;
        this.y2 = y + height - 1;
    }

    /**
     * Gets x1
     * 
     * @return x1
     */
    public int getX() {
        return this.x1;
    }

    /**
     * Gets y1
     * 
     * @return y1
     */
    public int getY() {
        return this.y1;
    }

    /**
     * Gets width
     * 
     * @return width based on x2 and x1
     */
    public int getWidth() {
        return this.x2 - this.x1 + 1;
    }

    /**
     * Gets height
     * 
     * @return height based on y2 and y1
     */
    public int getHeight() {
        return this.y2 - this.y1 + 1;
    }

    /**
     * Moves ball and detects collision
     * 
     * @param ball ball being moved
     * @return whether impact occurs
     */
    public boolean collides(Ball ball) {
        boolean ret = false;
        if (ball.getX() - ball.getRadius() <= this.x1 || ball.getX() - ball.getRadius() >= this.x2) {
            ret = true;
            ball.reflectHorizontal();
        }
        if (ball.getY() - ball.getRadius() <= this.y1 || ball.getY() - ball.getRadius() >= this.y2) {
            ret = true;
            ball.reflectVertical();
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Container at (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ')';
    }
}