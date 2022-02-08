package one.digitalinnovation.entidades;

import one.digitalinnovation.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.chequeEspecial = 0.0;
        this.tipo = Tipo.CORRENTE;
    }

    @Override
    public void sacar(double valor) {
        if((this.saldo + this.chequeEspecial) - valor < 0) {
            throw new SaldoInsuficienteException("Saldo Insuficiente para realização do Saque");
        }

        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Limite Cheque Especial: R$ " + String.format("%.2f", this.chequeEspecial);

    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}
