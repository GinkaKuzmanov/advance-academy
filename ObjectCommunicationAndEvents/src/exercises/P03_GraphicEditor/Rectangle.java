package exercises.P03_GraphicEditor;

public class Rectangle extends Shape {
    public Rectangle(int height, int width) {
        super(height, width);
    }

    @Override
    public void getDrawing() {
        System.out.println("I am a drawn rectangle.");
    }
}
