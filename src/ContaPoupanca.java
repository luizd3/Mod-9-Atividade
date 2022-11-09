public class ContaPoupanca extends Conta{
    private int diaAniversario;
    private double taxaDeJuros;

    public ContaPoupanca(int numero, int agencia, String banco, double saldo, int diaAniversario, double taxaDeJuros) {
        super(numero, agencia, banco, saldo);
        this.diaAniversario = diaAniversario;
        this.taxaDeJuros = taxaDeJuros;
    }

    public double getSaldo(int dia) { // Agora este método recebe um parâmetro do tipo inteiro.
        if (dia >= this.diaAniversario) {
            this.saldo = this.saldo + this.saldo * this.taxaDeJuros;
            return this.saldo;
        }
        else
            return this.saldo;
    }

    @Override
    public boolean sacar(double quantia) {
        this.saldo -= quantia;
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "ContaPoupanca{" +
                "diaAniversario=" + diaAniversario +
                ", taxaDeJuros=" + taxaDeJuros +
                '}';
    }
}
