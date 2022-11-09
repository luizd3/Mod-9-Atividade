import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestaConta {
    public static void main (String[] args) {

        ContaCorrente cc1 = new ContaCorrente(1, 1, "Banco 1", 100, 1000);
        ContaCorrente cc2 = new ContaCorrente(2, 1, "Banco 1", 0, 100);
        ContaCorrente cc3 = new ContaCorrente(3, 1, "Banco 1", 0, 0);

        // Cria uma lista de contas a partir de um conjunto de objetos:
        List<ContaCorrente> contas = Arrays.asList(cc1,cc2,cc3);

        // 'for' tradicional: define uma variável inicial, uma variável final e define um incremento:
        // 'for-each' tradicional: informa o tipo (ContaCorrente), o ponteiro (conta) e a lista que você quer trabalhar (contas)
        for (ContaCorrente conta : contas) {
            System.out.println(conta);
        }

        Cliente cli1 = new Cliente ("Fabiano",true, "123",10); // Instância 1 da classe Cliente
        Cliente cli2 = new Cliente ("Mentorama",true, "abc",30); // Instância 2 da classe Cliente
        cli1.autentica("456"); //Executar o método autentica(), comparando a senha entrada com a senha do cliente.

        List<Cliente> clientes = Arrays.asList(cli1,cli2);
        MostraCliente mostra = new MostraCliente(); // Instância da classe MostraCliente.
        clientes.forEach(mostra); // Método forEach: varre uma lista e executa algo. Neste caso, executando o método 'mostra'.

        clientes.forEach(Cliente :: getNome); // Referência ao método getNome.

        // Para imprimir somente 1 determinado objeto (cliente):
        Consumer<Cliente> consumer = Cliente :: getNome;
        consumer.accept(cli2);

    }
}
