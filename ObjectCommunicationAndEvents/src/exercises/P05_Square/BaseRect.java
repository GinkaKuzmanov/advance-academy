package exercises.P05_Square;

public abstract class BaseRect implements RectangleProperties{
    int m_width;
    int m_height;

    public BaseRect(int m_width, int m_height) {
        this.setWidth(m_width);
        this.setHeight(m_height);
    }

    protected int getWidth() {
        return m_width;
    }

    protected int getHeight() {
        return m_height;
    }

    protected void setWidth(int width) {
        m_width = width;
    }

    protected void setHeight(int height) {
        m_height = height;
    }

    public int getArea() {
        return m_width * m_height;
    }
}
