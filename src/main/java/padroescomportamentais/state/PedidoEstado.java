package padroescomportamentais.state;

public abstract class PedidoEstado {

    public abstract String getEstado();

    public boolean criar(Pedido pedido) {
        return false;
    }

    public boolean pagar(Pedido pedido) {
        return false;
    }

    public boolean enviar(Pedido pedido) {
        return false;
    }

    public boolean concluir(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }
}
