import java.util.Scanner;

public class Coet {
    
    private Motor[] motors;

    public Coet(){
        motors = new Motor[4];
        for(int i = 0; i < 4; i++){
            motors[i] = new Motor(i);
        }
    }
    public void passaAPotencia(int p){
        if(p < 0 || p > 10){
            System.out.print("Error: La potència ha d'estar entre 0 i 10");
            return;
        }
        System.out.println("Passant a potència " + p);
        for(Motor motor:motors){
            motor.setPotencia(p);
        }
    }
    public void arranca(){
        for(Motor motor: motors){
            motor.start();
        }
    }
    public static void main(String[] args){
        Coet coet = new Coet();
        coet.arranca();

        Scanner scanner = new Scanner(System.in);
        int potencia = -1;

        while (potencia != 0) {
            if(scanner.hasNextInt()){
                potencia = scanner.nextInt();
                coet.passaAPotencia(potencia);
            }else{
                System.out.println("Error: Introdueix un valor numéric vàlid.");
                scanner.next();
            }
        }
        scanner.close();
    }

}
