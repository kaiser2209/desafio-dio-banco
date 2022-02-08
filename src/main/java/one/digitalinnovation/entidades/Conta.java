package one.digitalinnovation.entidades;

import one.digitalinnovation.exceptions.SaldoInsuficienteException;
import one.digitalinnovation.interfaces.IConta;
import one.digitalinnovation.util.Utils;

import java.util.Objects;

public abstract class Conta implements IConta {
    public enum Tipo {
        CORRENTE(1),
        POUPANCA(2);

        private Integer codigo;

        Tipo(Integer codigo) {
            this.codigo = codigo;
        }

        public Integer getCodigo() {
            return codigo;
        }
    }

    private static Integer SEQUENCIAL_CONTA = 1;
    private static final Integer AGENCIA_PADRAO = 1;

    private int agencia;
    private int numero;
    protected double saldo;
    private Cliente cliente;
    protected Tipo tipo;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL_CONTA++;
        this.saldo = 0.0;
    }

    @Override
    public void sacar(double valor) {
        if (saldo - valor < 0) {
            throw new SaldoInsuficienteException("Saldo Insuficiente para realização do Saque");
        }
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta destino) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    public String getNumero() {
        return String.format("%05d", numero) + "-" + Utils.getDigitoVerificador(agencia, tipo, numero);
    }

    public String getAgencia() {
        return String.format("%03d", agencia);
    }

    public String getTipo() {
        return String.format("%02d", tipo.getCodigo());
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public String toString() {
        return "Conta: " + getAgencia() + getTipo() + getNumero() + "\n" +
                "Tipo: " + this.tipo + "\n" +
                "Titular: " + this.cliente.getNome() + "\n" +
                "Saldo: R$ " + String.format("%.2f", this.saldo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return agencia == conta.agencia && numero == conta.numero  && tipo == conta.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero, tipo);
    }

    public boolean igual(int agencia, Tipo tipo, int numero) {
        return this.agencia == agencia && this.tipo == tipo && this.numero == numero;
    }
}
