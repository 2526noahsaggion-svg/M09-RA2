import java.util.Random;

public class Motor extends Thread {
    private int id;
    private int potenciaActual;
    private int potenciaObjectiu;
    private boolean enMarxa;
    private Random random;

    public Motor(int id) {
        this.id = id;
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.enMarxa = false;
        this.random = new Random();
    }
    
    public synchronized void setPotencia(int p) {
        this.potenciaObjectiu = p;
        this.enMarxa = true;
    }
    
    @Override
    public void run() {
        boolean ferResMostrat = false;
        while (true) {
            try {
                if (!enMarxa) {
                    Thread.sleep(100);
                    continue;
                }

                if (potenciaObjectiu == 0 && potenciaActual == 0) {
                    System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d%n",
                            id, potenciaObjectiu, potenciaActual);
                    break;
                }
                
                if (potenciaActual < potenciaObjectiu) {
                    ferResMostrat = false;
                    int tempsEspera = 1000 + random.nextInt(1001); 
                    Thread.sleep(tempsEspera);
                    potenciaActual++;
                    System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d%n",
                            id, potenciaObjectiu, potenciaActual);
                } else if (potenciaActual > potenciaObjectiu) {
                    ferResMostrat = false;
                    int tempsEspera = 1000 + random.nextInt(1001);
                    Thread.sleep(tempsEspera);
                    potenciaActual--;
                    System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d%n",
                            id, potenciaObjectiu, potenciaActual);
                } else {
                
                    if (!ferResMostrat) {
                        System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d%n",
                                id, potenciaObjectiu, potenciaActual);
                        ferResMostrat = true;
                    }
                
                    Thread.sleep(100);
                }
            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}
