import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Testa {

    public static void main(String[] args) {
        Cliente cli1 = new Cliente ("Fabiano",true, "123",10);
        Cliente cli2 = new Cliente ("Mentorama",true, "iop",30);
        Cliente cli3 = new Cliente ("Brasil",false, "qwe",50);

        List<Cliente> clientes = Arrays.asList(cli1,cli2,cli3);

//        Consumer<Cliente> consumer = new Consumer<Cliente>() {
//            @Override
//            public void accept(Cliente cli) {
//                System.out.println(cli.getNome());
//            }
//        };
//        clientes.forEach(consumer);

        // Usando expressão Lambda:
//        Consumer<Cliente> consumer = (Cliente cli) -> {System.out.println(cli.getNome());};
//        clientes.forEach(consumer);

        // Resumindo mais:
        clientes.forEach(cli -> System.out.println(cli.getCompras()));

        // Criando um Stream para filtrar os clientes com mais do que 20 compras:
        Stream<Cliente> stream = clientes.stream().filter(cliente -> cliente.getCompras() > 10);
        // Executando apenas até o código acima, exibe os números de compras dos três clientes, pois não foi criada uma
        // nova lista.

        // Criando uma lista para poder imprimir os clientes filtrados:
        List<Cliente> selecionados = stream.collect(Collectors.toList());
        System.out.println("Filtrando maior que 10:");
        // Imprimindo a lista dos objetos filtrados:
        selecionados.forEach(c -> System.out.println(c.getCompras()));

    }
}
