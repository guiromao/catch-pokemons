package co.catchpokemons;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(){
        x = 0;
        y = 0;
    }

    public Coordinate(Coordinate c){
        this.x  = c.getX();
        this.y = c.getY();
    }

    public boolean isSamePos(Coordinate c){
        return x == c.getX() && y == c.getY();
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void moveUp(){
        y--;
    }

    public void moveDown(){
        y++;
    }

    public void moveRight(){
        x++;
    }

    public void moveLeft(){
        x--;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
