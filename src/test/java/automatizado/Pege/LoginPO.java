package automatizado.Pege;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    /**
     * Construtor padrao para uma nova instacia da pagina de login.
     * 
     * @param driver Driver da pagina de login
     */

    public LoginPO(WebDriver driver) {
        super(driver);

    }

    public String obterMensagem() {
        return this.spanMensagem.getText();
    }

    /**
     * Metodo que tenta executar a acao de Logar no sistem
     * 
     * @param email E-mail para tentativa de login
     * @param senha senha para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha) {

        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonEntar.click();

    }

}
