package pkg4.en.raya;

import java.util.*;

public class EnRaya {

    static Scanner sc = new Scanner(System.in);
    static boolean game = false; //Mientras sea true, los jugadores seguirán jugando
    
    static int used = 0; //Recoge cuantas casillas han sido usadas para determinar el empate si se llena el tablero
     
    static int res = 0; //Almacena la columna a la cual se tirará la ficha
    static int win = 1; //Para ganar, deberá llegar a 4. Empieza en 1 ya que al tirar 1 ficha ya se tiene colocado 1/4 fichas para ganar.
    
    static int columna = 0; //Almacenará la columna en cada movimineto
    static int fila = 0; //Almacenará la fila en cada movimiento
    
    static char token = '.'; //Representará una X o una O dependiendo del jugador que tire
    static int currentPlayer = 1; //Alternará dependiendo del jugador que juegue.

    private static void startGame(char[][] matrix) { //Crea el tablero y renderiza, si es necesario, el tutorial.
        System.out.println("Introduce 1 si quieres leer el tutorial");
        System.out.println("Introduce cualquier otro número si quieres omitir el tutorial");
        if (sc.nextInt() == 1) {
            System.out.println("Bienvenido a 4EnRayaProgramadoEnJavaUsandoLaConsolaComoMotorGrafico.");
            System.out.println("Este es un juego multijugador local en el cual los jugadores deben de turnarse.");
            System.out.println("Para ganar, junta de forma horizontal, vertical o diagonal 4 fichas.");
            System.out.println("Empieza Jugador1");
            System.out.println("");
            System.out.println("Las fichas colocadas por Jugador1 serán representadas como X");
            System.out.println("Las fichas colocadas por Jugador2 serán representadas como O");
            System.out.println("============================================================");
            System.out.println("Introduce cualquier valor para jugar");
            sc.next();
        }
        for (int i = 0; i < 4; i++) { //Se llena el tablero de puntos
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = '.';
            }
        }
    }

    private static void showGame(char[][] matrix) { //Muestra en pantalla el tablero.
        System.out.println("");
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 6; i++) {
            System.out.print("   " + (i + 1) + "   ");
        }
        System.out.println("");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("   " + matrix[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("-----------------------------------------");
    }

    private static void throwToken(char[][] matrix) { //Tira una ficha
        if (currentPlayer == 1) { //Dependiendo del jugador, token será X u O
            System.out.println("Juega Jugador1");
            token = 'X';
        } else {
            System.out.println("Juega Jugador2");
            token = 'O';
        }
        System.out.print("Introduce columna: ");
        res = sc.nextInt();
        columna = res - 1;
        if (used == 24) { //Si el tablero está lleno, se dejará de jugar.
            System.out.println("¡El tablero se ha llenado!");
            game = false;
            return;
        } 
        
         if (res > 6 || res < 1){ //Si la columna introducida no existe, se vuelve a ejecutar la función de forma recursiva.
            System.out.println("Introduce un valor de columna correcto (1-6)");
            throwToken(matrix);
        } else if (matrix[0][res - 1] != '.'){ //Si la columna está llena, se vuelve a ejecutar la función de forma recursiva.
            System.out.println("¡Columna llena!");
            throwToken(matrix);
        }
        else {
            used +=1;
            currentPlayer = currentPlayer == 1 ? 0 : 1; //Se cambia de jugador
            for (int i = 3; i >= 0; i--) { //Se introduce la ficha
                if (matrix[i][res - 1] == '.') {
                    matrix[i][res - 1] = token;
                    fila = i;
                    break;
                }
            }
            checkGame(matrix); //Se comprueba si el último movimiento ha hecho que un jugador gane
        }
    }

    private static void checkGame(char[][] matrix) { //Se comprueba si se ha ganado
            //Se comprueba de forma vertical;
            win = 0;
            for (int j = fila; j <= 3; j++) { 
                if (matrix[j][columna] == token) {
                    win++;
                } else {
                    break;
                }
            }
            for (int j = fila - 1; j >= 0; j--) {
                if (matrix[j][columna] == token) {
                    win++;
                } else {
                    break;
                }
            }
            if (win >= 4) {
                win = 1;
                game = false;
                return;
                
            } else {
                win = 1;
            }
            
            //Se comprueba de forma horizontal
            win = 1;
            for (int j = columna + 1; j < 6; j++) {
                if (matrix[fila][j] == token) {
                    win++;
                } else {
                    break;
                }
            }
            for (int j = columna - 1; j >= 0; j--) {
                if (matrix[fila][j] == token) {
                    win++;
                } else {
                    break;
                }
            }
            if (win >= 4) {
                game = false;
                return;
            } else {
                win = 1;
            }

            //Se comprueba de forma diagonal
            int tempFila = fila + 1;
            int tempCol = columna + 1;
            while (tempFila >= 0 && tempFila <= 3 && tempCol <= 5 && tempCol >= 0) {
                if (matrix[tempFila][tempCol] == token) {
                    win++;
                } else {
                    break;
                }
                tempFila++;
                tempCol++;

            }
            tempFila = fila - 1;
            tempCol = columna - 1;
            while (tempFila >= 0 && tempFila <= 3 && tempCol <= 5 && tempCol >= 0) {
                if (matrix[tempFila][tempCol] == token) {
                    win++;
                } else {
                    break;
                }
                tempFila--;
                tempCol--;
            }
            if (win >= 4) {
                game = false;
                return;
            } else {
                win = 1;
            }

            tempFila = fila - 1;
            tempCol = columna + 1;
            while (tempFila >= 0 && tempFila <= 3 && tempCol <= 5 && tempCol >= 0) {
                if (matrix[tempFila][tempCol] == token) {
                    win++;
                } else {
                    break;
                }
                tempFila--;
                tempCol++;
            }

            tempFila = fila + 1;
            tempCol = columna - 1;
            while (tempFila >= 0 && tempFila <= 3 && tempCol <= 5 && tempCol >= 0) {
                if (matrix[tempFila][tempCol] == token) {
                    win++;
                } else {
                    break;
                }
                tempFila++;
                tempCol--;

            }
            if (win >= 4) {
                game = false;
            } else {
                win = 1;
            }
    }
    
    private static String whoWon(){ //Devuelve el ganador
        String winner;
        if (currentPlayer == 2) {
            winner = "Jugador 1";
        }  else if(used == 24){
            winner = "Ninguno";
        }
        else {
            winner = "Jugador 2";
        }
        return winner;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[4][6]; //Representa el tablero
        
        startGame(matrix);
        game = true;
        while (game) {
            showGame(matrix);
            throwToken(matrix);
        }
        System.out.println("==========================");
        System.out.println("El juego ha terminado");
        System.out.println("Ha ganado " + whoWon());
        showGame(matrix);
    }

}
