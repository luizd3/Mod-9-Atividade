@FunctionalInterface
public interface Autenticador {

//    default boolean autentica(String senha) { // Métodos de interfaces não podem ter um corpo.
//                                             // Coloca-se como default para permitir ter um corpo.
//        // Agora, como este método é default, a subclasse 'Cliente' já o tem implementado.
//        if (this.senha != senha){
//            System.out.println("Não autenticado!");
//            return false;
//        } else {
//            System.out.println("Autenticado!");
//            return true;
//        }
//    }

    public abstract boolean autentica(String senha);

}
