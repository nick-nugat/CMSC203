/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description:
 * Due: 11/06/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */
public class Plot {
    //instance variables/fields
    private int x;
    private int y;
    private int depth;
    private int width;

    //no-arg constructor
    public Plot() {
        this.width = 1;
        this.depth = 1;
    }

    //parameterized constructor
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.width = width;
    }

    //copy constructor
    public Plot(Plot otherPlot) {
        this(otherPlot.x,
             otherPlot.y,
             otherPlot.depth,
             otherPlot.width);
    }

    //getters and setters
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    //checks if current plot encompases the plot parameter passed
    public boolean encompasses(Plot plot) {
        int x2 = plot.x;
        int y2 = plot.y;
        int depth2 = plot.depth;
        int width2 = plot.width;

        return x2 >= x
            && y2 >= y
            && (x2 + width2) <= (x + width)
            && (y2 + depth2) <= (y + depth);
    }

    //checks if current plot and plot parameter overlap in any way
    public boolean overlaps(Plot plot) {
        int x2 = plot.x;
        int y2 = plot.y;
        int depth2 = plot.depth;
        int width2 = plot.width;

        boolean horizontalOverlap = (x >= x2 && x >= (x2 + width2)) || (x2 >= x && x2 >= (x + width));
        boolean verticalOverlap = (y >= y2 && y >= (y2 + depth2)) || (y2 >= y && y2 >= (y + depth));

        return horizontalOverlap || verticalOverlap;
    }

    //toString() override
    @Override
    public String toString() {
        return getX() + "," + getY() + "," + getWidth() + "," + getDepth();
    }

}
