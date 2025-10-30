package padroescomportamentais.state;

public class PedidoEstadoCancelar extends PedidoEstado {

    private PedidoEstadoCancelar() {}
    private static PedidoEstadoCancelar instance = new PedidoEstadoCancelar();
    public static PedidoEstadoCancelar getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelar";
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelar.getInstance());
        return true;
    }
}
