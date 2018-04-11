import java.util.Objects;
import java.util.Observable;

public class Jugador extends Observable implements Runnable {
    private String nombre;
    private Repartidor repartidor;
    private int puntos;

    public Jugador(String nombre, Repartidor repartidor){
        this.nombre = nombre;
        this.repartidor = repartidor;
        this.puntos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }


    @Override
    public void run() {
        String msg;
        Carta carta;

        while(repartidor.isDisponible()){
            carta = repartidor.getCarta();
            puntos = puntos + carta.getNumero();

            setChanged();
            msg = "Nombre: " + nombre + " Puntos: " + Integer.toString(puntos);
            notifyObservers(msg);
        }
    }
}
