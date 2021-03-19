import java.awt.Color;

class RectTester_5BoxbergerSpencer {
    public static void main(String[] args) {
        Shape shapeObjectVariable = new Shape(0, 0, new Color(0, 0, 0));
        Rectangle rectangleObject = new Rectangle(0, 0, new Color(255, 255, 255), 10, 20);
        
        System.out.println(shapeObjectVariable);
        System.out.println(rectangleObject);
        System.out.println(shapeObjectVariable.equals(rectangleObject));
        System.out.println(shapeObjectVariable.equals(shapeObjectVariable));
        System.out.println(rectangleObject.equals(rectangleObject));
    
        /*
        Runtime Error
        System.out.println(rectangleObject.equals(shapeObjectVariable));
        */
    }
}

class Shape {
    private int xLoc;
    private int yLoc;
    private Color color;


    public Shape( int xLocation, int yLocation ) {
    	xLoc = xLocation;
    	yLoc = yLocation;
    }

    public Shape ( int xLocation, int yLocation, Color c) {
    	xLoc = xLocation;
    	yLoc = yLocation;
        color = c;
    }

    public int getX() {return xLoc;}

    public int getY() {return yLoc;}

    @Override
    public boolean equals(Object obj) {
        Shape shape = (Shape) obj;
        return shape.getX() == xLoc && shape.getY() == yLoc && shape.getColor() == color;
    }

    @Override
    public String toString() {
        return "X Location: " + xLoc + ", Y Location: " + yLoc + ", Color: " + color;
    }

    public double getArea( ) { return 0; }

    public Color getColor() { return color; }

} // end class Shape

class Circle extends Shape {
    private int r;

    public Circle(int xLocation, int yLocation, Color c, int radius) {
        super(xLocation, yLocation, c);
        r = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    public int getRadius() {
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        Circle circle = (Circle) obj;
        return super.equals(circle) && r == circle.getRadius();
    }

    @Override
    public String toString() {
        return super.toString() + ", Radius: " + r;
    }
}

class Rectangle extends Shape {
    private int w;
    private int l;

    public Rectangle(int xLocation, int yLocation, Color c, int width, int length) {
        super(xLocation, yLocation, c);
        w = width;
        l = length;
    }

    @Override
    public double getArea() {
        return w * l;
    }

    public int getWidth() {
        return w;
    }

    public int getLength() {
        return l;
    }

    @Override
    public boolean equals(Object obj) {
        Rectangle rect = (Rectangle) obj;
        return super.equals(rect) && rect.getWidth() == w && rect.getLength() == l;
    }

    @Override
    public String toString() {
        return super.toString() + ", Width: " + w + ", Length: " + l;
    }
}