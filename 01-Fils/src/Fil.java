public class Fil extends Thread {
    public  String nom;
    private boolean esTercer;
    public Fil (String nom, boolean esTercer){
        this.nom = nom;
        this.esTercer = esTercer;
    }
    @Override 
    public void run(){
        for(int i = 1; i <= 9; i++){
            System.out.println(nom + " " + i);
            if(esTercer){
                try{
                    Thread.sleep(1);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            } else {
                for(int j = 0;j < 1000; j ++){
                    int feina = j * 2;
                }
            }
        }
        String accio = esTercer ? "Termina" : "Acabar";
        System.out.println(accio + " el fil " + nom);
    }
}
