public class Futbolista extends Thread {
    public static int NUM_JUGADORS = 11;
    public static int NUM_TIRADES = 20;
    public static float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    public int getNgols() {
        return ngols;
    }
    
    @Override 
    public void run(){
        for(int i = 0; i< NUM_TIRADES; i++){
            this.ntirades++;
            if( Math.random() < PROBABILITAT){
                this.ngols++;
            }
        }
    }

    public static void main(String[] args) {
        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau","Aspas","Messi","MBapé"};
        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

        System.out.println("Inici dels xuts ------------------------");
        for(int i = 0; i < NUM_JUGADORS; i++){
            jugadors[i] = new Futbolista(noms[i]);
            jugadors[i].start();
        }
        for (int i = 0; i < NUM_JUGADORS; i++) {
            try {
                jugadors[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fi dels xuts ---------------------------");
        System.out.println("Estadístiques");
        for (int i = 0; i < NUM_JUGADORS; i++) {
            System.out.println(jugadors[i].getName() + " -> " + jugadors[i].getNgols() + " gols");
        }
    }
}
