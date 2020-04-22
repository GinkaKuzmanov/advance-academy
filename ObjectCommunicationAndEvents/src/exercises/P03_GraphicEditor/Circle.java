package exercises.P03_GraphicEditor;

/**
 * Created by Buro on 3.4.2017 г..
 */
public class Circle extends Shape {

    public Circle(int height, int width) {
        super(height, width);
    }

    @Override
    public void getDrawing() {
        System.out.println("I am a drawn circle.");
    }
}
