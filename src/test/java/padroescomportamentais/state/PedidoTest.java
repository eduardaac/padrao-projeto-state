package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido(); // O pedido já começa no estado Criado
    }

    // Pedido criado
    @Test
    public void naoDeveCriarPedidoJaCriado() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        assertFalse(pedido.criar());
    }

    @Test
    public void devePagarPedidoCriado() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        assertTrue(pedido.pagar());
        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoNaoPago() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveConcluirPedidoNaoEnviado() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        assertFalse(pedido.concluir());
    }

    @Test
    public void deveCancelarPedidoCriado() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        // Este teste agora passa com a correção em PedidoEstadoCriado.java
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelar.getInstance(), pedido.getEstado());
    }

    // Pedido pago
    @Test
    public void naoDeveCriarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.criar());
    }

    @Test
    public void naoDevePagarPedidoJaPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.pagar());
    }

    @Test
    public void deveEnviarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.enviar());
        assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveConcluirPedidoNaoEnviadoAinda() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.concluir());
    }

    @Test
    public void deveCancelarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        // Este teste agora passa com a correção em PedidoEstadoPago.java
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelar.getInstance(), pedido.getEstado());
    }

    // Pedido enviado
    @Test
    public void naoDeveCriarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.criar());
    }

    @Test
    public void naoDevePagarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        // Adicionada a asserção faltante
        assertFalse(pedido.pagar());
    }

    @Test
    public void naoDeveEnviarPedidoJaEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.enviar());
    }

    @Test
    public void deveConcluirPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertTrue(pedido.concluir());
        assertEquals(PedidoEstadoConcluido.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoEnviado() {
        // Pela lógica atual (herdando 'return false'), não é possível cancelar um pedido enviado
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.cancelar());
    }


    // Pedido concluido
    @Test
    public void naoDeveFazerNadaComPedidoConcluido() {
        pedido.setEstado(PedidoEstadoConcluido.getInstance());
        assertFalse(pedido.criar());
        assertFalse(pedido.pagar());
        assertFalse(pedido.enviar());
        assertFalse(pedido.concluir());
        assertFalse(pedido.cancelar());
    }


    // Pedido cancelado
    @Test
    public void naoDeveFazerNadaComPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelar.getInstance());
        assertFalse(pedido.criar());
        assertFalse(pedido.pagar());
        assertFalse(pedido.enviar());
        assertFalse(pedido.concluir());
    }

    @Test
    public void deveCancelarPedidoJaCancelado() {
        // O estado Cancelar se auto-referencia, então retorna true
        pedido.setEstado(PedidoEstadoCancelar.getInstance());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelar.getInstance(), pedido.getEstado());
    }
}