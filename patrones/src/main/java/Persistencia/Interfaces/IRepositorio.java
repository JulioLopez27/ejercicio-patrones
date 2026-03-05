package Persistencia.Interfaces;

import java.util.List;

public interface IRepositorio<T> {
    //metodos genericos entre las clases
    void guardar(T t);

    List<T> listar();
}
