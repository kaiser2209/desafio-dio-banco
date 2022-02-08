package one.digitalinnovation.entidades;

import one.digitalinnovation.exceptions.ContaInvalidaException;
import one.digitalinnovation.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        if (this.contas == null) {
            this.contas = new ArrayList<>();
        }
        return this.contas;
    }

    @Override
    public String toString() {
        String retorno = "Banco: " + this.nome + "\n" +
                "Contas Cadastradas: [" + "\n\n";
        for(Conta c : this.contas) {
            retorno += c + "\n\n";
        }

        retorno += "]";

        return retorno;
    }

    public Conta searchConta(int agencia, Conta.Tipo tipo, int numero, int dv) {
        if (Utils.isContaValida(agencia, tipo, numero, dv)) {
            return getConta(agencia, tipo, numero);
        } else {
            throw new ContaInvalidaException("A conta informada não é válida!");
        }
    }

    private Conta getConta(int agencia, Conta.Tipo tipo, int numero) {
        for(Conta c : this.contas) {
            if (c.igual(agencia, tipo, numero)) {
                return c;
            }
        }

        return null;
    }
}
