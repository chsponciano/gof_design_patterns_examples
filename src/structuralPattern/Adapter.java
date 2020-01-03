package structuralPattern;

interface Vector {
    int getPosX();
    int getPosY();
    int getWidth();
    int getHeight();
}

class Figure implements Vector {
    private int posX, posY, width, height;

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}

class DragBox {
    private Coordinate headerLeft, footerRight;

    public Coordinate getFooterRight() {
        return footerRight;
    }

    public Coordinate getHeaderLeft() {
        return headerLeft;
    }
}

class Coordinate {
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class DragBoxAdpter implements Vector {
    private DragBox dragBox = new DragBox();

    @Override
    public int getPosX() {
        Coordinate coordinate = dragBox.getHeaderLeft();
        return coordinate.getX();
    }

    @Override
    public int getPosY() {
        Coordinate coordinate = dragBox.getHeaderLeft();
        return coordinate.getY();
    }

    @Override
    public int getWidth() {
        Coordinate coorHeader = dragBox.getHeaderLeft();
        Coordinate coorFooter = dragBox.getFooterRight();
        return coorFooter.getX() - coorHeader.getX();
    }

    @Override
    public int getHeight() {
        Coordinate coorHeader = dragBox.getHeaderLeft();
        Coordinate coorFooter = dragBox.getFooterRight();
        return coorFooter.getY() - coorHeader.getY();
    }
}

public class Adapter {

}
