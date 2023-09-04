public class Move {
    public boolean move(Player p, int[] c, char[][] m){
        if(m[c[0]][c[1]] != ' ') return false;
        m[c[0]][c[1]] = p.getSign();
        return true;
    }

}
