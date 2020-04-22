package exercises.P05_Square;

public class Square extends BaseRect implements RectangleProperties {


    public Square(int m_width, int m_height) {
        super(m_width, m_height);

    }

    protected void setWidth(int width) {
        m_width = width;
    }

    protected void setHeight(int height) {
        if(height != this.getWidth()){
            throw new
                    IllegalArgumentException(
                    "Do not violate the properties of the square");
        }
        m_height = height;
    }
}
