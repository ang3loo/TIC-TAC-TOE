import java.util.Scanner;
public class Game {
    Player p1,p2,p;
    char[][] map;
    Move hand = new Move();
    boolean moved = false;
    int[] coordinates = new int[2];
    int countMove = 0;
    Scanner scan = new Scanner(System.in);
    public Game(Player p1,Player p2,char[][] map){
        this.p1 = p1;
        this.p2 = p2;
        this.map = map;
        this.p = p1;
    }
    public boolean won(Player p,int[] c){
        char s = p.getSign();
        //riga 0
        if(c[0] == 0){
            if(c[1] == 0){
                //0,0
                if(map[1][0] == s && map[2][0] == s) return true; //down
                if(map[0][1] == s && map[0][2] == s) return true; //right
                if(map[1][1] == s && map[2][2] == s) return true; //diagonal

            }else if(c[1] == 1){
                //0,1
            }else if(c[1] == 2){
                //0,2
            }
        }else if(c[0] == 1){
            if(c[1] == 0){
                //0,0
            }else if(c[1] == 1){
                //0,1
            }else if(c[1] == 2){
                //0,2
            }
        }else if(c[0] == 2){
            if(c[1] == 0){
                //0,0
            }else if(c[1] == 1){
                //0,1
            }else if(c[1] == 2){
                //0,2
            }
        }
        return false;
    }
    public void start(){
        boolean finish = false;
        while(!finish){
            System.out.println("your sign: ");
            System.out.println(p.getSign());

            System.out.println("riga: ");
            coordinates[0] = scan.nextInt();
            System.out.println("colonna: ");
            coordinates[1] = scan.nextInt();

            moved = hand.move(p,coordinates,map);
            //ADD CONTROL OF ILLEGAL MOVE


            for(int i = 0; i<3; i++){
                System.out.print(map[i][0]);
                System.out.print(" | ");
                System.out.print(map[i][1]);
                System.out.print(" | ");
                System.out.print(map[i][2]);
                System.out.println();
            }
            //cambio giocatore
            if (p.getId() == 0){
                p = p2;
            }else{
                p = p1;
            }

            //controllo vittoria
            if(won(p,coordinates)) {
                System.out.println("VINTO");
                finish = true;
            }
            countMove ++;
            if(countMove == 9) finish = true;
        }
        //vittoria di qualcuno o stallo?
    }
}
