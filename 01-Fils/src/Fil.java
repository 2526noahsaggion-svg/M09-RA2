public class Fil extends Thread {
    private String nom;
    
    public Fil (String nom){
        this.nom = nom;
    }
    @Override 
    public void run(){
        for(int i = 0; i <= 9; i++){
            System.out.println(nom + " " + i);
        }
    }
}
