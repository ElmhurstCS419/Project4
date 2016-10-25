package gui;

import java.util.Arrays;

import gui.shape.ArrowHead;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Launcher extends Application {

    /**
     * The Applications width.
     */
    private static final int WINDOW_WIDTH = 600;
    
    /**
     * The Applications height.
     */
    private static final int WINDOW_HEIGHT = 400;

    /**
     * The x axis line.
     */
    private static final Line AXIS_X = new Line(10, 100, 390, 100);
    
    /**
     * The y axis line.
     */
    private static final Line AXIS_Y = new Line(200, 10, 200, 190);

    /**
     * The x axis line label.
     */
    private static final Label X_LABEL = new Label("X");
    
    /** 
     * The y axis line label.
     */
    private static final Label Y_LABEL = new Label("Y");

    /**
     * The pi symbol.
     */
    private static final String PI = "\u03C0";

    /**
     * The x axis pi labels; ranging from -3pi to 3pi.
     */
    private static final Label[] PI_LABELS = {
        new Label("-3" + PI),
        new Label("-2" + PI),
        new Label("-" + PI),
        new Label("0"),
        new Label(PI),
        new Label("2" + PI),
        new Label("3" + PI)
    };

    /**
     * The y axis lines arrow.
     */
    private static final ArrowHead ARROW_Y = new ArrowHead(ArrowHead.NORTH);
    
    /** 
     * the x axis lines arrow.
     */
    private static final ArrowHead ARROW_X = new ArrowHead(ArrowHead.EAST);

    /**
     * The graph points for Sine.
     */
    private static final Polyline SIN = new Polyline();
    
    /**
     * The graph points for Cosine.
     */
    private static final Polyline COS = new Polyline();

    /**
     * The root pane to hold all the nodes.
     */
    private static final StackPane ROOT = new StackPane();

    
    @Override
    public void start(Stage primaryStage) {
        buildLabels();
        buildGraph();
        buildPoints();
        buildPane();
        Scene scene = new Scene(ROOT, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setTitle("sin and cos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Adds all the nodes to the root Pane.
     */
    private void buildPane() {
        ROOT.getChildren().addAll(ARROW_Y, ARROW_X, Y_LABEL, X_LABEL, AXIS_X, AXIS_Y, SIN, COS);
        ROOT.getChildren().addAll(Arrays.asList(PI_LABELS));
    }

    /**
     * Sets all the points to be graphed for our Sine and Cosine lines.
     */
    private void buildPoints() {
        ObservableList<Double> sinePoints = SIN.getPoints();
        ObservableList<Double> cosinePoints = COS.getPoints();

        double scaleFactor = 50;
        for (int x = -170; x <= 170; x++) {
            sinePoints.add(x + 200.0);
            sinePoints.add(100 - scaleFactor * Math.sin((x / 100.0) * 2 * Math.PI));
            cosinePoints.add(x + 200.0);
            cosinePoints.add(100 - scaleFactor * Math.cos((x / 100.0) * 2 * Math.PI));
        }
    }

    /**
     * Positions the graphs x and y axis and sets the colors of the Sine and Cosine lines.
     */
    private void buildGraph() {
        ARROW_Y.setTranslateY(-80);
        ARROW_X.setTranslateX(183);
        SIN.setStroke(Color.RED);
        COS.setStroke(Color.BLUE);
    }

    /**
     * Positions all of the PI labels, as well as the x and y axis labels.
     */
    private void buildLabels() {
        X_LABEL.translateXProperty().setValue(186);
        X_LABEL.translateYProperty().setValue(-25);
        Y_LABEL.translateXProperty().setValue(25);
        Y_LABEL.translateYProperty().setValue(-86);

        for (int i = 0, j = -144; i < PI_LABELS.length; i++, j += 48) {
            Label label = PI_LABELS[i];
            label.setTranslateX(j);
            label.setTranslateY(7);
        }
    }

    /**
     * Launches the Application.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
