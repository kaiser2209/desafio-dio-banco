package one.digitalinnovation;

import one.digitalinnovation.entidades.*;
import one.digitalinnovation.util.Utils;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Meu Banco");
        ContaCorrente corrente = new ContaCorrente(new Cliente("Charles"));
        ContaPoupanca poupanca = new ContaPoupanca(corrente.getCliente());
        poupanca.setTaxa(0.0085f);
        corrente.setChequeEspecial(100);
        corrente.depositar(500);
        corrente.transferir(600, poupanca);
        poupanca.calculaRendimento();
        banco.getContas().add(corrente);
        banco.getContas().add(poupanca);
        System.out.println(banco);
        System.out.println(banco.searchConta(1, Conta.Tipo.POUPANCA, 2, 3));
    }
}
