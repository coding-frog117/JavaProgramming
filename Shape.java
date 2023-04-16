interface Shapes {
	final double PI = 3.14;
	void draw();
	double getArea();
	
    default public void redraw() {
    	System.out.printf("---다시 그립니다.");
    	draw();
    }
}

class Circle implements Shapes {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("반지름이"+radius+"인 원입니다.");
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Oval implements Shapes {
    private int  width;
    private int height;

    public Oval(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println(width+"X"+height+"에 내접하는 타원입니다.");
    }

    public double getArea() {
        return Math.PI * width * height ;
    }
}

class Rect implements Shapes {
    private int width;
    private int height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println(width+"X"+height+"크기의 사각형입니다.");
    }

    public double getArea() {
        return width * height;
    }
}

public class Shape {
    public static void main(String[] args) {
        Shapes [] list = new Shapes[3];
        list[0] = new Circle(10);
        list[1] = new Oval(20, 30);
        list[2] = new Rect(10, 40);

        for (int i = 0; i < list.length; i++) {
            list[i].redraw();
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println("면적은 " + list[i].getArea());
        }
    }
}

