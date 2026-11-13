public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", true);
        Fil pepe = new Fil("Pepe", true);

        
        pepe.start();
        juan.start();
        System.out.println("Termina thread main");
    }
    
    
}
