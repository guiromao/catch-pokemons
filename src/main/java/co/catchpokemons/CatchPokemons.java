package co.catchpokemons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatchPokemons {

    private static final char NORTH = 'N';
    private static final char SOUTH = 'S';
    private static final char EAST = 'E';
    private static final char WEST = 'O';

    public static void main(String[] args) {
        System.out.println(caughtPokemons("E"));
        System.out.println(caughtPokemons("NESO"));
        System.out.println(caughtPokemons("NE    SO   "));
        System.out.println(caughtPokemons("NSNSNSNSNS"));
        System.out.println(caughtPokemons("N SNSNS NSNSOSSEE11"));

        System.out.print("Write your own directions to Ash: ");
        Scanner scanner = new Scanner(System.in);
        String directions = scanner.nextLine();
        System.out.println(caughtPokemons(directions));
    }

    /**
     * Method that will count number of caught pokemons in a given string of directions
     * @param input string of directions
     * @return
     */
    private static String caughtPokemons(String input){
        String result;
        input = removeSpaces(input.toUpperCase());

        if(areValidDirections(input)){
            result = String.valueOf(countCatches(input));
        }
        else {
            result = "The directions given aren\'t valid!";
        }

        return result;
    }

    /**
     * Counting new catches of Pokemons, based on new Coordinates visited
     * @param dir the string with the directions
     * @return
     */
    public static long countCatches(String dir){

        if(dir.length() == 0){
            return 0;
        }

        List<Coordinate> visitedPos = new ArrayList<>();
        visitedPos.add(new Coordinate());
        Coordinate currentPos = new Coordinate();

        for(int i = 0; i < dir.length(); i++){

            switch(dir.charAt(i)){
                case NORTH: currentPos.moveUp(); break;
                case SOUTH: currentPos.moveDown(); break;
                case EAST: currentPos.moveRight(); break;
                case WEST: currentPos.moveLeft(); break;
            }

            if(!hasVisitedPos(visitedPos, currentPos)){
                visitedPos.add(new Coordinate(currentPos));
            }
        }

        return visitedPos.size();
    }

    /**
     * Method will state if list of positions contains the coordinate passed in arguments
     * @param listPos List of positions visited
     * @param position position to check if contained in above list
     * @return
     */
    private static boolean hasVisitedPos(List<Coordinate> listPos, Coordinate position){
        for(int i = 0; i < listPos.size(); i++){
            if(listPos.get(i).isSamePos(position)){
                return true;
            }
        }
        return false;
    }

    /**
     * Removes spaces from the string of directions
     * @param string a string with the directions given
     * @return
     */
    private static String removeSpaces(String string){
        String result = "";
        string = string.trim();

        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) != ' '){
                result += string.charAt(i);
            }
        }

        return result;
    }

    /**
     * Method will tell if all the directions given in the string are valid ones
     * @param directions string of directions
     * @return
     */
    public static boolean areValidDirections(String directions){
        for(int i = 0; i < directions.length(); i++){
            if(directions.charAt(i) != NORTH &&
                    directions.charAt(i) != SOUTH &&
                    directions.charAt(i) != EAST &&
                    directions.charAt(i) != WEST){
                return false;
            }
        }
        return true;
    }

}
