package BusinessLogic;

public class Log {
    private String username;
    private String password;
    private String type;

    public Log(){

    }
    public Log(String username,String password,String type){
        this.username=username;
        this.password=password;
        this.type=type;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }
    public String toString2(){
        return username+","+password+","+type+"\n";
    }

    public static Log createLog(String[] data){
        String username=data[0];
        String password=data[1];
        String type=data[2];
        return new Log(username,password,type);
    }

}
