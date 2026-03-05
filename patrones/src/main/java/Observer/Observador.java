package Observer;

import Observer.Observable.Evento;

public interface Observador {
    public void update(Observable o, Evento e);
}
