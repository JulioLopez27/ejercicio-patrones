package Observer;

import java.util.List;
import java.util.ArrayList;

public abstract class Observable {

    private List<Observador> observadores;

    public Observable() {
        observadores = new ArrayList<>();
    }

    public enum Evento {
        Turno_Cancelado,
        Turno_Reprogramado,
    }

    public void suscribir(Observador o) {
        this.observadores.add(o);
    }

    public void desuscribir(Observador o) {
        this.observadores.remove(o);
    }

    public void notificar(Observable.Evento e) {
        for(Observador o: observadores){
            o.update(this, e);
        }
    }

}
