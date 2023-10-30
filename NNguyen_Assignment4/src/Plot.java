public class Plot {
    private int x;
    private int y;
    private int depth;
    private int width;

    public Plot() {
        this.width = 1;
        this.depth = 1;
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.width = width;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.depth, otherPlot.width);
    }

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

    public boolean encompasses(Plot plot) {
        int x2 = plot.x;
        int y2 = plot.y;
        int depth2 = plot.depth;
        int width2 = plot.width;

        return x2 >= x && y2 >= y
            && (x2 + width2) <= (x + width) && (y2 + depth2) <= (y + depth);
    }

    public boolean overlaps(Plot plot) {
        int x2 = plot.x;
        int y2 = plot.y;
        int depth2 = plot.depth;
        int width2 = plot.width;

        boolean horizontalOverlap = (x >= x2 && x < (x2 + width2)) || (x2 >= x && x2 < (x + width));
        boolean verticalOverlap = (y >= y2 && y < (y2 + depth2)) || (y2 >= y && y2 < (y + depth));


        return horizontalOverlap && verticalOverlap;
    }

    @Override
    public String toString() {
        return getX() + "," + getY() + "," + getWidth() + "," + getDepth();
    }

}
