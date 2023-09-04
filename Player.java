public class Player {
    String name;
    int id;
    char sign;
    public Player(String n, char s, int id){
        this.name = n;
        this.sign = s;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public char getSign(){
        return sign;
    }
    public int getId(){
        return id;
    }

}
