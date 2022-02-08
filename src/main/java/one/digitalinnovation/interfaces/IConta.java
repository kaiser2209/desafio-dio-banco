package one.digitalinnovation.interfaces;

import one.digitalinnovation.entidades.Conta;
import one.digitalinnovation.exceptions.SaldoInsuficienteException;

public interface IConta {
    void sacar(double valor) throws SaldoInsuficienteException;
    void depositar(double valor);
    void transferir(double valor, Conta destino);
}
