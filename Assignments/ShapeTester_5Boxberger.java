import java.awt.Color;

/** 5) Create a public tester class: ShapeTester_Lastna
       Create a few objects, print out thier areas
*/
class ShapeTester_5Boxberger {
    public static void main(String[] args) {
        Circle testCircle = new Circle(0, 0, new Color(0, 255, 0), 5);
        Circle testCircle2 = new Circle(0, 0, new Color(0, 0, 255), 20);
        Shape testShape = new Shape(0, 0, new Color(255, 255, 255));
        Shape testShape2 = new Shape(0, 0, new Color(0, 0, 0));
        
        System.out.println(testCircle.getArea());
        System.out.println(testCircle2.getArea());
        System.out.println(testShape.getArea());
        System.out.println(testShape2.getArea());
    }
}

class Shape {
    private int xLoc;
    private int yLoc;
    // 1) Add an instance variable for Color...
    private Color color;


    public Shape( int xLocation, int yLocation ) {
    	xLoc = xLocation;
    	yLoc = yLocation;
    }

    public int getX() {return xLoc;}

    public int getY() {return yLoc;}

    /**
     2) Write an alternate constructor that takes the x, y location AND
     	a color object and initializes all instance variables.
    */
    public Shape ( int xLocation, int yLocation, Color c) {
    	xLoc = xLocation;
    	yLoc = yLocation;
        color = c;
    }

    public double getArea( ) { return 0; }

} // end class Shape

/** 3) Write a class Circle that has an instance field for radius and
	   inherits the x,y and color from the Shape class. 
      (3b) Write a constructor for Circle that initializes all instance variables,
	   including location.
      (3c) Write a getArea method that returns the area of the circle

*/
class Circle extends Shape {
    private int r;

    public Circle(int xLocation, int yLocation, Color c, int radius) {
        super(xLocation, yLocation, c);
        r = radius;
    }

    public double getArea() {
        return Math.PI * r * r;
    }
}