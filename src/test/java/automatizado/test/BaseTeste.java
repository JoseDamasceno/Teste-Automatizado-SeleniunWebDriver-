package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTeste {

    protected static WebDriver driver;
    private static final String URL_BASE = "file:///C:/Users/Lais/Downloads/1253QUANTUMVM.UNRARMETRO_ckbnxvahp5f44!App/Extracted/sistema/login.html";
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resurce/chromedriver1- v100.0.4896.60.exe";

    @BeforeClass // <-- Roda antes de todos os Testes
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterClass // <-- Roda depois de todos od Testes
    public static void finalizar() {
        driver.quit();
    }

}
