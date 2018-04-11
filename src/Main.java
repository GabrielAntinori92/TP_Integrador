import java.util.ArrayList;


public class Main {

    public static void main(String[] args){
        ArrayList<Carta> mazo = new ArrayList<>();

        for(int i=0; i<50; i++){
            mazo.add(new Carta(i+1));
        }

        Juez juez = new Juez();
        Repartidor r1 = new Repartidor("Repartidor",mazo);
        r1.addObserver(juez);

        Jugador j1 = new Jugador("j1",r1);
        j1.addObserver(r1);

        Jugador j2 = new Jugador("j2",r1);
        j2.addObserver(r1);

        Jugador j3 = new Jugador("j3",r1);
        j3.addObserver(r1);

        Jugador j4 = new Jugador("j4",r1);
        j4.addObserver(r1);

        Thread t1 = new Thread(j1);
        Thread t2 = new Thread(j2);
        Thread t3 = new Thread(j3);
        Thread t4 = new Thread(j4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch (Exception e){}

        r1.determinarGanador();
    }
}
