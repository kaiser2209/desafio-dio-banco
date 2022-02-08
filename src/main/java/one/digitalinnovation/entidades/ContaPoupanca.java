package one.digitalinnovation.entidades;

public class ContaPoupanca extends Conta {
    private float taxa;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.tipo = Tipo.POUPANCA;
    }

    public float getTaxa() {
        return taxa;
    }

    public float getTaxaPercentual() {
        return taxa * 100;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public void calculaRendimento() {
        this.saldo += this.saldo * this.taxa;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Juros: " + getTaxaPercentual() + "%";

    }
}
