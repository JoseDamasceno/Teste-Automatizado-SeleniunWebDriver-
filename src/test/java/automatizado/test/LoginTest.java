package automatizado.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.Pege.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Metodo para executar os teste de foram crecente
public class LoginTest extends BaseTeste {

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);

    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailSenhaEmBrancos() {
        /**
         * loginPage.escrever(loginPage.inputEmail, "");// LoginPO faz a funcao de
         * escrever
         * // loginPage.inputEmail.sendKeys("");
         * loginPage.escrever(loginPage.inputSenha, "");
         * // loginPage.inputSenha.sendKeys("");
         * loginPage.buttonEntar.click();
         * String mensagem = loginPage.obterMensagem();
         * assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser
         * brancos.");
         * }Um forma alternativa de tertar o login
         */

        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.obterMensagem();
        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailPreenchidoE_SenhaVazia() {
        loginPage.executarAcaoDeLogar("teste", "");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioE_SenhapPreenchida() {
        loginPage.executarAcaoDeLogar("", "12312345");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailE_SenhaInvalidos() {
        loginPage.executarAcaoDeLogar("teste", "12312345");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailValidoE_SenhaInvalidos() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "12312345");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailInvalidoE_SenhaValidos() {
        loginPage.executarAcaoDeLogar("teste", "admin@123");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC007_DeveLogarNoSistemaComEmailSenhaEmValidos() {
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        assertEquals(loginPage.obterTitoloPagina(), "Controle de Produtos");

    }

}
