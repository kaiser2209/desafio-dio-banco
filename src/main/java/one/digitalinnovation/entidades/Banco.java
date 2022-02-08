package one.digitalinnovation.entidades;

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
}
