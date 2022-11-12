import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Testa {

    public static void main(String[] args) {
        Cliente cli1 = new Cliente ("Fabiano",true, "123",9);
        Cliente cli2 = new Cliente ("Mentorama",true, "iop",30);
        Cliente cli3 = new Cliente ("Brasil",false, "qwe",50);
        Cliente cli4 = new Cliente ("José",false, "qwe",57);
        Cliente cli5 = new Cliente ("Mariana",false, "qwe",5);
        Cliente cli6 = new Cliente ("Luiz",false, "qwe",23);
        Cliente cli7 = new Cliente ("Jéssica",false, "qwe",2);
        Cliente cli8 = new Cliente ("Alexandre",false, "qwe",12);
        Cliente cli9 = new Cliente ("Marcela",false, "qwe",57);
        Cliente cli10 = new Cliente ("Kiko",false, "qwe",57);

        List<Cliente> clientes = Arrays.asList(cli1,cli2,cli3,cli4,cli5,cli6,cli7,cli8,cli9,cli10);

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
        clientes.forEach(cli -> System.out.print(cli.getCompras() + "; "));

        // Criando um Stream para filtrar os clientes com mais do que 20 compras:
        Stream<Cliente> stream = clientes.stream()
                .filter(cliente -> cliente.getCompras() > 10);
        // Executando apenas até o código acima, exibe os números de compras dos três clientes, pois não foi criada uma
        // nova lista.

        // Criando uma lista para que seja possível imprimir os clientes filtrados:
        List<Cliente> selecionados = stream.collect(Collectors.toList());
        System.out.print("Filtrando maior que 10: ");
        // Imprimindo a lista dos objetos filtrados:
        selecionados.forEach(c -> System.out.print(c.getCompras() + "; "));
        System.out.println("");

        // ATIVIDADE MÓDULO 9:

        // Cliente que fez mais compras:

        // Maior número de compras:
        int maiorNumeroDeCompras = clientes.stream()
                .max(Comparator.comparing(cliente -> cliente.getCompras()))
                .get().getCompras();
        // Filtro com clientes que fizeram maior número de compras:
        System.out.println(" - Cliente(s) que fez(fizeram) mais compras: ");
        List<Cliente> listaClientesMaisCompras = clientes.stream()
                .filter(cliente -> cliente.getCompras() == maiorNumeroDeCompras)
                .toList();
        listaClientesMaisCompras.forEach(cliente ->
                System.out.println("     - " + cliente.getNome() +
                        ", que comprou " + cliente.getCompras() + " vezes."));

        // Cliente que fez menos compras:
        Stream<Cliente> streamMenosCompras = clientes.stream()
                .min(Comparator.comparing(Cliente :: getCompras))
                .stream();
        System.out.print(" - Cliente que fez menos compras: ");
        Cliente clienteMenosCompras = streamMenosCompras.findFirst().get();
        System.out.println(clienteMenosCompras.getNome() + ", que comprou " + clienteMenosCompras.getCompras() + " vezes.");

        // Média de compras dos clientes da lista:
        double mediaCompras = clientes.stream()
                .mapToDouble(Cliente :: getCompras)
                .average()
                .getAsDouble();
        System.out.print(" - Média das compras dos clientes: " + mediaCompras);
    }
}
