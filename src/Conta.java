
public abstract class Conta {
    private int numero;
    private int agencia;
    private String banco;
    protected double saldo; // modificador "protected" faz com que a variável saldo seja acessível em todas as classes
                            // da hierarquia.

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    // Método é abstrato, pois a forma de retornar o saldo varia conforme o tipo de conta (corrente, poupança, salário).
    // Métodos abstratos não têm um corpo e só são construídos de fato na classe filha.
    public double getSaldo() { // Método deixa de ser abstrato para que o método getSaldo da classe 'ContaPoupanca'
                               // receba um parâmetro, como exemplo de Polimorfismo.
        return this.saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(int numero, int agencia, String banco, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.banco = banco;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", agencia=" + agencia +
                ", banco='" + banco + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public boolean sacar(double quantia) { // Método 'sacar' deixa de ser abstrato.
        return false; // Retorno 'false' apenas para satisfazer as restrições da classe ContaPoupanca.
    }

    public void depositar(double quantia) {
        this.saldo += quantia;
    }
}
