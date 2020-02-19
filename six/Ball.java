package six;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    /**
     * Constructs with fields based on params
     * 
     * @param x         x
     * @param y         y
     * @param radius    radius
     * @param speed     used in calculating deltas
     * @param direction used in calculating deltas
     * @throws IllegalArgumentException if direction is out of bounds [-180, 180]
     */
    public Ball(float x, float y, int radius, int speed, int direction) throws IllegalArgumentException {
        if (Math.abs(direction) > 180) {
            throw new IllegalArgumentException("Direction out of bounds");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) ((float) speed * Math.cos(Math.toRadians(direction)));
        this.yDelta = (float) ((float) speed * Math.sin(Math.toRadians(direction)));
    }

    /**
     * Gets x
     * 
     * @return x
     */
    public float getX() {
        return this.x;
    }

    /**
     * Sets x
     * 
     * @param x set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets y
     * 
     * @return y
     */
    public float getY() {
        return this.y;
    }

    /**
     * Sets y
     * 
     * @param y set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Gets radius
     * 
     * @return radius
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Sets radius
     * 
     * @param radius set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Gets xDelta
     * 
     * @return xDelta
     */
    public float getXDelta() {
        return this.xDelta;
    }

    /**
     * Sets xDelta
     * 
     * @param xDelta set
     */
    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    /**
     * Gets yDelta
     * 
     * @return yDelta
     */
    public float getYDelta() {
        return this.yDelta;
    }

    /**
     * Sets yDelta
     * 
     * @param yDelta set
     */
    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    /**
     * Changes x and y based on xDelta and yDelta
     */
    public void move() {
        this.x += this.xDelta;
        this.y += this.yDelta;
    }

    /**
     * Reverses xDelta
     */
    public void reflectHorizontal() {
        this.xDelta *= -1;
    }

    /**
     * Reverses yDelta
     */
    public void reflectVertical() {
        this.yDelta *= -1;
    }

    @Override
    public String toString() {
        return "Ball at (" + this.x + ", " + this.y + ") of velocity (" + this.xDelta + ", " + this.yDelta + ')';
    }
}