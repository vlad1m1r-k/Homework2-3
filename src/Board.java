public class Board {
    private Shape[] shapeBoard = new Shape[4];

    public enum Sides {
        ONE(0), TWO(1), THREE(2), FOUR(3);
        private int index;
        private Sides(int index){
            this.index = index;
        }
        public int getIndex(){
            return index;
        }
    }

    public void add(Shape shape){
        boolean added = false;
        for (int i = 0; i < shapeBoard.length; i++) {
            if (shapeBoard[i] == null){
                shapeBoard[i] = shape;
                added = true;
                break;
            }
        }
        if (!added) System.out.println("Not enough space.");
    }

    public  void add(Shape shape, Sides side){
        shapeBoard[side.getIndex()] = shape;
    }

    public void delete(Sides side){
        shapeBoard[side.getIndex()] = null;
    }

    public void getInfo(){
        double totalArea = 0;
        System.out.println("Shapes on the board:");
        for (Shape shape: shapeBoard) {
            if (shape != null){
                System.out.println(shape.getClass().getName());
                totalArea += shape.getArea();
            }
        }
        System.out.println("Total area = " + totalArea);
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.add(new Triangle(new Point(0,0), new Point(0, 3), new Point(3, 0)));
        board.add(new Circle(new Point(0,0), new Point(0,3)), Sides.FOUR);
        board.add(new Rectangle(new Point(0,0), new Point(2,2)));
        board.getInfo();
    }
}
