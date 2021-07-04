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
        String output = (args.length == 0) ? "Please write a set of directions so that Ash can catch Pokemons!" :
                caughtPokemons(args[0]);
        System.out.println(output);
    }

    /**
     * Method that will count number of caught pokemons in a given string of directions
     * @param input string of directions
     * @return string with the number of caught pokemons
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
     * @return number of caught pokemons
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
     * @return whether the current position is a newly visited one
     */
    private static boolean hasVisitedPos(List<Coordinate> listPos, Coordinate position){
        return listPos.stream()
                .filter((c) -> c.isSamePos(position))
                .parallel()
                .findAny()
                .isPresent();
    }

    /**
     * Removes spaces from the string of directions
     * @param string a string with the directions given
     * @return direction's string without any spaces
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
     * @return whether the string of directions contains valid directions only
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
