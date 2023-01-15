public class Client {
    private final int timpSosire;
    private final int timpServire;
    private final int id;
    private static int index=1;

    public Client(int timpSosire,int timpServire){
        this.timpSosire=timpSosire;
        this.timpServire=timpServire;
        id=index;
        index++;
    }

    public int getTimpSosire() {
        return timpSosire;
    }

    public int getTimpAsteptare(){
        return this.timpServire;
    }

    @Override
    public String toString(){
        return "\uD83D\uDED2ヽ( ͡° ͜⌞ ͡°)⸍  ⫷"+id+","+timpServire+"⫸";
    }

    public String toStringFisier(){
        return "⫷"+id+","+timpSosire+","+timpServire+"⫸";
    }
}
