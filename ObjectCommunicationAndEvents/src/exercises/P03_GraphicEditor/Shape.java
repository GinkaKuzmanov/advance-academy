package exercises.P03_GraphicEditor;

public abstract class Shape {
        private int height;
        private int width;

        public Shape(int height,int width){
            this.height = height;
            this.width = width;
        }

        public abstract void getDrawing();

}
