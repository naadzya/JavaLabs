import java.lang.Integer;

public class Birdhouse {
    private String wood;
    private int length; //in sm
    private int width;  //in sm
    private int height; //in sm

    public Birdhouse(String wood, int length, int width, int height) {
        this.wood = wood;
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new ArithmeticException("Wrong size of a birdhouse");
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getWood() {
        return wood;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWood(String wood) {
        this.wood = wood;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return "A birdhouse from " + wood + " with the next size (l, w, h) = ("
               + String.valueOf(length) + ", " + String.valueOf(width) + ", "
               + String.valueOf(height) + ")";
    }

    public int hashCode() {
        String uniqueSize = String.valueOf(length) + "0" + String.valueOf(width) + "0"
                            + String.valueOf(height);
        return wood.hashCode() + uniqueSize.hashCode();
    }

    public boolean equals(Birdhouse anotherBH) {
        return wood == anotherBH.wood &&
               length == anotherBH.length &&
               width == anotherBH.width &&
               height == anotherBH.height;
    }

    public static void main(String[] args) {
        Birdhouse testb = new Birdhouse("oak", 10, 10, 25);
        Birdhouse test2 = new Birdhouse("oak", 10, 25, 10);
        System.out.println(testb.toString());
        System.out.println(test2.toString());
        System.out.println(testb.hashCode() == test2.hashCode());
    }
}  
