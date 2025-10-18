
import java.util.*;
// import java.util.Random;

class Tictactoe {

    /*
 * ===============================================
 *          🎮 TIC TAC TOE - COMMAND LINE GAME 🎮
 * ===============================================
 *
 * Overview:
 * ----------
 * This is a simple, two-player Tic Tac Toe game that runs in the command line.
 * Players take turns placing their marks ('X' or 'O') on a 3×3 grid.
 * The first player to align three of their marks in a row—either horizontally,
 * vertically, or diagonally—wins the match.
 *
 * How to Play:
 * -------------
 * • The game board has 3 rows and 3 columns, numbered 0, 1, and 2.
 * • On your turn, enter the position as: row column
 *   → Example: "0 2" means Row 0 and Column 2.
 * • Player 1 uses 'X' and Player 2 uses 'O'.
 * • You can’t place your mark in a cell that’s already filled.
 * • After each move, the updated board is displayed.
 * • The game ends when a player wins or the board is full (draw).
 * • At the end, you’ll be asked if you’d like to play again.
 *
 * Notes:
 * -------
 * - The program validates every move and prevents invalid entries.
 * - It’s designed to be easy to follow and fun to play in a console.
 *
 * Developed in Java 💻
     */
    static String p1, p2;
    static int toss;
    static char mat[][];
    static Scanner sc;
    static boolean gameover;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        System.out.println("\n===== Welcome to Tic Tac Toe =====");
        System.out.println("Instructions:");
        System.out.println(" - The board has 3 rows and 3 columns (indices 0, 1, 2).");
        System.out.println(" - Enter your move as: row column (e.g., 0 2 for top-right).");
        System.out.println(" - Player 1 uses X, Player 2 uses O.\n");

        System.out.print("Enter the name of first player: ");
        String player1 = sc.next();
        System.out.print("Enter the name of second player: ");
        String player2 = sc.next();

        p1 = player1;
        p2 = player2;
        mat = new char[3][3];

        boolean playAgain = true;

        do {
            // Initialize board
            // new game everytime
            mat = new char[3][3];
            create_mat(mat);

            System.out.println("\nAn empty Matrix is created:");
            print_mat(mat);

            toss = 0;
            gameover = false;

            // Loop until game ends or draw occurs
            while (true) {
                if (toss % 2 == 0) {
                    player1();
                    toss++;
                } else {
                    player2();
                    toss++;
                }

                print_mat(mat);
                check_status();

                if (gameover) {
                    break;
                }

                if (!gameover && toss == 9) {
                    System.out.println("Match Drawn!");
                    break;
                }
            }

            //play again
            System.out.print("Do you want to play again? (y/n): ");
            String answer = sc.next();
            if (!answer.equalsIgnoreCase("y")) {
                playAgain = false;
            }
            String temp = p1;
            p1 = p2;
            p2 = temp;
        } while (playAgain);
    }

    // ----------------------------------------------------------
    // FUNCTION: check_status()
    // PURPOSE: Checks all rows, columns, and diagonals to detect
    //          if a player has won the game.
    // ----------------------------------------------------------
    static public void check_status() {

        // check rows
        for (int i = 0; i < 3; i++) {
            if (mat[i][0] == mat[i][1] && mat[i][0] == mat[i][2]) {
                if (mat[i][0] == 'X') {
                    System.out.println(p1 + " won");
                    gameover = true;
                } else if (mat[i][0] == 'O') {
                    System.out.println(p2 + " won");
                    gameover = true;
                }
                break;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (mat[0][i] == mat[1][i] && mat[0][i] == mat[2][i]) {
                if (mat[0][i] == 'X') {
                    gameover = true;
                    System.out.println(p1 + " won");
                } else if (mat[0][i] == 'O') {
                    System.out.println(p2 + " won");
                    gameover = true;
                }
                break;
            }
        }

        // check diagonals
        if (mat[0][0] == mat[1][1] && mat[0][0] == mat[2][2] && mat[0][0] != ' ') {
            if (mat[0][0] == 'X') {
                gameover = true;
                System.out.println(p1 + " won");
            } else if (mat[0][0] == 'O') {
                System.out.println(p2 + " won");
                gameover = true;
            }
        } else if (mat[0][2] == mat[1][1] && mat[0][2] == mat[2][0] && mat[0][2] != ' ') {
            if (mat[0][2] == 'X') {
                gameover = true;
                System.out.println(p1 + " won");
            } else if (mat[0][2] == 'O') {
                gameover = true;
                System.out.println(p2 + " won");
            }

        }

    }

    static void player1() {
        System.out.println(p1 + "'s turn'");
        System.out.println(" Enter Your Choice");
        System.out.println("Enter row and column");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (row < 0 || col < 0 || row >= 3 || col >= 3) {
            System.out.println("Invalid Selection , Enter Again");
            toss--;
        } else if (mat[row][col] != ' ') {
            System.out.println("Invalid Selection ,Already Filled, Enter Again");
            toss--;

        } else {
            mat[row][col] = 'X';
        }

    }

    static void player2() {
        System.out.println(p2 + "'s turn'");
        System.out.println(" Enter Your Choice");
        System.out.println("Enter row and column");
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (row < 0 || col < 0 || row >= 3 || col >= 3) {
            System.out.println("Invalid Selection , Enter Again");
            toss--;
        } else if (mat[row][col] != ' ') {
            System.out.println("Invalid Selection ,Already Filled, Enter Again");
            toss--;

        } else {
            mat[row][col] = 'O';
        }

    }

    //   function to create an empty matrix
    static void create_mat(char[][] mat) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat[i][j] = ' ';
            }
        }
    }

    // ----------------------------------------------------------
    // FUNCTION: print_mat()
    // PURPOSE: Displays the current state of the game board
    // ----------------------------------------------------------
    static void print_mat(char[][] mat) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

}
