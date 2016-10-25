package gui.shape;

import javafx.scene.shape.Polyline;

public class ArrowHead extends Polyline {

    public static int NORTH = 270;
    public static int SOUTH = 90;
    public static int WEST = 180;
    public static int EAST = 0;

    /**
     * Initializes a arrow head so that it points to the right.
     */
    public ArrowHead() {
        this(EAST);
    }
    
    /**
     * Initializes a arrow head so that it points to a certain direction; North, South, West, or East.
     * 
     * @param direction the direction for the arrow to point.
     */
    public ArrowHead(int direction) {
        this.getPoints().addAll(new Double[]{
            0.0, 0.0,
            20.0, 10.0,
            0.0, 20.0});
        this.setRotate(direction);
    }

}
