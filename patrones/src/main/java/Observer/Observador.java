package Observer;

import Observer.Observable.Eventos;

public interface Observador {
    public void update(Observable o, Eventos e);
}
