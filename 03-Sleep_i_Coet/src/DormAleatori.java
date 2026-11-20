import java.util.Random;

public class DormAleatori extends Thread{
    private long tempsCreacio;
    private Random random;

    public DormAleatori(String nom){
        super(nom);
        this.tempsCreacio = System.currentTimeMillis();
        this.random = new Random();
    }
    @Override 
    public void run() {
        for(int i = 0; i < 10; i++){
            int intervalAleatori = random.nextInt(1000);
            long totalTemps = System.currentTimeMillis() - tempsCreacio;
            System.out.printf("%s (%d) a dormir %dms total %dms%n", 
                getName(), i ,intervalAleatori, totalTemps
            );
            try{
                Thread.sleep(intervalAleatori);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}
