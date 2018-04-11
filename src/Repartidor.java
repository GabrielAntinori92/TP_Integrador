import java.util.*;

public class Repartidor extends Observable implements Observer {
    private String nombre;
    private List<Carta> mazo;
    private List<Jugador> jugadores;//para determinar el ganador
    private Random dado;

    public Repartidor(String nombre, List<Carta> mazo){
        this.nombre = nombre;
        this.mazo = mazo;
        this.jugadores = new ArrayList<>();
        this.dado = new Random();
    }

    public synchronized Carta getCarta(){
        int index;
        Carta carta;

        try{
            while(!isDisponible()){
                wait();
            }
        }catch (Exception e){}


        if(mazo.size()==0){
            Thread.interrupted();
        }

        index = dado.nextInt(mazo.size());
        carta = mazo.remove(index);
        notifyAll();
        return carta;
    }

    public boolean isDisponible(){
        return (mazo.size()>0);
    }


    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof Jugador){
            Jugador j = (Jugador)o;

            jugadores.add(j);

            System.out.println(arg);
        }

    }

    public Jugador determinarGanador(){
        Jugador ganador = jugadores.get(0);
        String msg;

        for (Jugador j: jugadores) {
            if(ganador.getPuntos() < j.getPuntos()){
                ganador = j;
            }
        }
        msg = "Ganador: " + ganador.getNombre() + " Puntos: " + ganador.getPuntos();
        setChanged();
        notifyObservers(msg);

        return ganador;
    }
}
