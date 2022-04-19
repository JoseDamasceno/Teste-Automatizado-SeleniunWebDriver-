package automatizado.Pege;

import org.openqa.selenium.Keys;

/**
 * Classe base para criação das novas PageObjects.
 * Todas as pages deve ser herdadas desta classe.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO {

    /** Driver base que sera usado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para criação de fabricas de elementos.(PageFactory)
     * 
     * @param driver Driver da página atual.
     */

    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);// a pagenia que estiver executa:Toda a fabrica para trabalhar com o
                                               // pageFactory

    }

    public String obterTitoloPagina() {
        return driver.getTitle();
    }

    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

}
