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
                return map[1][1] == s && map[2][2] == s; //diagonal

            }else if(c[1] == 1){
                //0,1
                if(map[1][1] == s && map[2][1] == s) return true; //down
                return map[0][0] == s && map[0][2] == s; //right left
            }else if(c[1] == 2){
                //0,2
                if(map[1][2] == s && map[2][2] == s) return true; //down
                if(map[0][0] == s && map[0][1] == s) return true; //left
                return map[1][1] == s && map[2][0] == s; //diagonal
            }
        }else if(c[0] == 1){
            if(c[1] == 0){
                //1,0
                if(map[0][0] == s && map[2][0] == s) return true; //up down
                return map[1][1] == s && map[1][2] == s; //right
            }else if(c[1] == 1){
                //1,1
                if(map[0][1] == s && map[2][1] == s) return true; //up down
                if(map[1][0] == s && map[1][2] == s) return true; //right left
                if(map[0][0] == s && map[2][2] == s) return true; //diagonal 1
                return map[2][0] == s && map[0][2] == s; //diagonal 2
            }else if(c[1] == 2){
                //1,2
                if(map[0][2] == s && map[2][2] == s) return true; //up down
                return map[1][1] == s && map[1][0] == s; //left
            }
        }else if(c[0] == 2){
            if(c[1] == 0){
                //2,0
                if(map[1][0] == s && map[0][0] == s) return true; //up
                if(map[2][1] == s && map[2][2] == s) return true; //right
                return map[1][1] == s && map[0][2] == s; //diagonal
            }else if(c[1] == 1){
                //2,1
                if(map[1][1] == s && map[0][1] == s) return true; //up
                return map[2][0] == s && map[2][2] == s; //right left
            }else if(c[1] == 2){
                //2,2
                if(map[1][2] == s && map[0][2] == s) return true; //up
                if(map[2][1] == s && map[2][0] == s) return true; //left
                return map[1][1] == s && map[0][0] == s; //diagonal
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


            for(int i = 0; i<3; i++){
                System.out.print(map[i][0]);
                System.out.print(" | ");
                System.out.print(map[i][1]);
                System.out.print(" | ");
                System.out.print(map[i][2]);
                System.out.println();
            }
            //controllo vittoria
            if(won(p,coordinates)) {
                System.out.println("VINTO");
                finish = true;
            }
            //cambio giocatore
            if (p.getId() == 0){
                p = p2;
            }else{
                p = p1;
            }

            countMove ++;
            if(countMove == 9) finish = true;
        }
        /*vittoria di qualcuno o stallo?
        if(finish ){
            System.out.print("HA VINTO: ");
            System.out.print(p.getName());
        }else if{
            System.out.print("STALLO");
        }

         */
    }
}
