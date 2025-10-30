package padroescomportamentais.state;

public class Pedido {

    private String descricao;
    private PedidoEstado estado;

    public Pedido() {
        // Define o estado inicial como "Criado"
        this.estado = PedidoEstadoCriado.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean criar() {
        return estado.criar(this);
    }

    public boolean pagar() {
        return estado.pagar(this);
    }

    public boolean enviar() {
        return estado.enviar(this);
    }

    public boolean concluir() {
        return estado.concluir(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PedidoEstado getEstado() {
        return estado;
    }
}
