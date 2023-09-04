import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        //initialize scanner for user input
        Scanner myObj = new Scanner(System.in);

        Player player1,player2;
        String name;
        char sign;

        char[][] map = new char[3][3];
        for(int i = 0; i<3; i++)
            for(int j = 0; j<3; j++)
                map[i][j] = ' ';
        System.out.println(map [0][0]);

        //scegli se fare 1 vs 1 o 1 vs bot

        //scegli nome e simbolo di gioco
        //player 1
        System.out.println("Enter name of the first player: ");
        name = myObj.nextLine();
        player1 = new Player(name,'O',0);

        //player 2
        System.out.println("Enter name of the second player: ");
        name = myObj.nextLine();
        player2 = new Player(name,'X',1);
        //implements the choice for the sign

        //fai partire il gioco passandogli la matrice iniziale
        Game game = new Game(player1,player2,map);
        game.start();
    }
}
