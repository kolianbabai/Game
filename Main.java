import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String cross = "[X]";
        String star = "[*]";
        String empty = "   ";
        String box = "[ ]";

        String[][] boardX = { {"  ", "1 ",   " 2 ",   " 3 ", empty},
                            {  "1",  empty, box, empty, empty},
                            {  "2",  box, box, box, empty},
                            {  "3",  box, star, box, empty},
                            {  "4",  cross, box, cross, empty},
                            {  "5",  empty, cross, empty, empty},
                            { empty, empty, empty, empty, empty}};

        while (true) {

            for (int i = 0; i < boardX.length; i++) {
                for (int j = 0; j < boardX[i].length; j++) {
                    System.out.print(boardX[i][j]);
                }
                System.out.println();
            }
            if(boardX[1][2].equals(cross)) {
                System.out.println("Первый игрок выиграл!");
                break;
            }

            Scanner input = new Scanner(System.in);
            int line = 0;
            int column = 0;

            while (true){

                line = input.nextInt();
                column = input.nextInt();

                if(!(boardX[line][column].equals(cross))){
                    System.out.println("Выберите координаты крестика!");

                }  if(boardX[line -1][column].equals(star)) {
                    System.out.println("Так ходить нельзя! Мешает звёздочка!");

                } else {break;}

            }


             if(!boardX[line -1][column].equals(box) && !boardX[line][column -1].equals(box)) {
                String s = boardX[line][column];
                boardX[line][column] = boardX[line - 1][column + 1];
                boardX[line - 1][column + 1] = s;
            }else if(!boardX[line -1][column].equals(box) && !boardX[line][column + 1].equals(box)) {
                String s = boardX[line][column];
                boardX[line][column] = boardX[line - 1][column - 1];
                boardX[line - 1][column - 1] = s;
            }
            else {
                String s = boardX[line][column];
                boardX[line][column] = boardX[line - 1][column];
                boardX[line - 1][column] = s;
            }




        }
    }
}
