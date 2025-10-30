package padroescomportamentais.state;

public class PedidoEstadoConcluido extends PedidoEstado {

    private PedidoEstadoConcluido() {}

    private static PedidoEstadoConcluido instance = new PedidoEstadoConcluido();

    public static PedidoEstadoConcluido getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Concluído";
    }
}
