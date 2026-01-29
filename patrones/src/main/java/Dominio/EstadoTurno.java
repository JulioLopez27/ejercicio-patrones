package Dominio;

import Exceptions.TransicionEstadoInvalidaException;
//El enum declara que se puede hacer
//cada estado decide como se hace
public enum EstadoTurno {

    CONFIRMADO {
        @Override
        public EstadoTurno confirmar() {
            throw new TransicionEstadoInvalidaException("CONFIRMADO", "CONFIRMADO");
        }

        @Override
        public EstadoTurno reprogramar() {
            return REPROGRAMADO;
        }

        @Override
        public EstadoTurno cancelar() {
            return CANCELADO;
        }

    },
    REPROGRAMADO {
        @Override
        public EstadoTurno confirmar() {
            return CONFIRMADO;
        }

        @Override
        public EstadoTurno reprogramar() {
            throw new TransicionEstadoInvalidaException("REPROGRAMADO", "REPROGRAMADO");
        }

        @Override
        public EstadoTurno cancelar() {
            return CANCELADO;
        }
    },

    CANCELADO {
        @Override
        public EstadoTurno confirmar() {
            throw new TransicionEstadoInvalidaException("CANCELADO", "CONFIRMADO");
        }
        @Override
        public EstadoTurno reprogramar() {
            throw new TransicionEstadoInvalidaException("CANCELADO", "REPROGRAMADO");
        }
        @Override
        public EstadoTurno cancelar() {
            throw new TransicionEstadoInvalidaException("CANCELADO", "CANCELADO");
        }
    };

    public abstract EstadoTurno confirmar();

    public abstract EstadoTurno reprogramar();

    public abstract EstadoTurno cancelar();

}
