package automatizado.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import automatizado.Pege.ControleDeProdutoPO;
import automatizado.Pege.LoginPO;
import automatizado.builder.ProdutoBuilder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTeste {

        private static LoginPO loginPage;
        private static ControleDeProdutoPO controleProduroPage;

        @BeforeClass
        public static void prepararTestes() {
                loginPage = new LoginPO(driver);
                loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
                controleProduroPage = new ControleDeProdutoPO(driver);

                assertEquals(controleProduroPage.obterTitoloPagina(), "Controle de Produtos");

        }

        @Test
        public void TC001_deveAbriModalParaCadastroAoClicarCriar() {
                controleProduroPage.buttonAdicionar.click();
                controleProduroPage.buttonAdicionar.click();

                String titulo = controleProduroPage.tituloModal.getText();
                assertEquals("Produto", titulo);

                controleProduroPage.buttonSair.click();
                controleProduroPage.buttonSair.click();

                // assertEquals(controleProduroPage.obterTitoloPagina(), "Controle de
                // Produtos");

        }

        @Test
        public void TC002_naoDeveSerPossivelCadastrarProdutoSemPreencherTodosOsCampos() {
                controleProduroPage.buttonAdicionar.click();

                String mensagem = "Todos os campos são obrigatórios para o cadastro!";

                controleProduroPage.cadastrarProdudo("QWE22", "Furadeira", null, 229.90, "18/04/2022");
                assertEquals(mensagem, controleProduroPage.spanMensagem.getText());

        }

        @Test
        public void TC003_DeveVoltarParaPaginaLogin() {

                controleProduroPage.linkVoltar.click();

        }

        @Test
        public void TC004_naoDeveSerPossivelCadastrarProdutoSemPreencherTodosOsCampos() {
                String mensagem = "Todos os campos são obrigatórios para o cadastro!";

                // cria o Objeto para adicionar na tela.
                ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProduroPage);

                // Aqui adiciona as informações na tela.
                produtoBuilder
                                .builder();

                produtoBuilder
                                .adicionarCodigo("")
                                .adicionarQuantidade(15)
                                .adicionarNome("Martelo")
                                .builder();
                assertEquals(mensagem, controleProduroPage.spanMensagem.getText());
                // Testar de o produto e adicionado sem nome.
                produtoBuilder
                                .adicionarNome("")
                                .adicionarQuantidade(25)
                                .adicionarNome("Alicate")
                                .builder();

                assertEquals(mensagem, controleProduroPage.spanMensagem.getText());
                // Testar de o produto e adicionado sem qua ntidade.
                produtoBuilder
                                .adicionarData("17/04/2022")
                                .adicionarQuantidade(null)
                                .builder();

                assertEquals(mensagem, controleProduroPage.spanMensagem.getText());
                // Testar de o produto e adicionado sem valor
                produtoBuilder
                                .adicionarNome("Cimento")
                                .adicionarValor(null)
                                .builder();

                assertEquals(mensagem, controleProduroPage.spanMensagem.getText());

                produtoBuilder
                                .adicionarCodigo("0005")
                                .adicionarData("")
                                .builder();

                assertEquals(mensagem, controleProduroPage.spanMensagem.getText());

                controleProduroPage.buttonSair.click();

        }

}
