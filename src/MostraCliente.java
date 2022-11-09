import java.util.function.Consumer;

public class MostraCliente implements Consumer {

    @Override
    public void accept(Object o) { // Método accept: recebe um objeto (o) e executa uma ação nele.
        System.out.println(o); // A ação que está sendo executada é imprimir o objeto.
    }

}
