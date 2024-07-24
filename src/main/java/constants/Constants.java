package constants;
import org.openqa.selenium.By;

public class Constants {
    public static String profileURL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static String forgotPasswordURL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static String loginURL = "https://stellarburgers.nomoreparties.site/login";
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String registerURL = "https://stellarburgers.nomoreparties.site/register";
    public static final By accountProfile = By.xpath("//a[contains(@class, 'Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9') and @href='/account/profile']");
    public static final By constructorButton = By.xpath("//a[contains(@class, 'AppHeader_header__link__3D_hX') and @href='/']");
    public static final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");
    public static final By accountLogo = By.xpath("//a[@href='/']");
    public static final By exitButton = By.xpath(".//button[text()='Выход']");
    public static final By loginPageHeader = By.xpath("//h2[text()='Вход']");
    public static final By loginLink = By.xpath("//a[contains(@class, 'Auth_link__1fOlj') and @href='/login']");
    public static final By nameBy = By.name("name");
    public static final By passwordBy = By.name("Пароль");
    public static final By loginButton = By.xpath("//button[text()='Войти']");
    public static final By registerTo = By.xpath(".//input[@placeholder='Зарегистрироваться']");
    public static final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    public static final By loginToAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    public static final By accountLink = By.xpath("//a[contains(@class, 'AppHeader_header__link__3D_hX') and @href='/account']");
    public static final By bunsTab = By.xpath("//span[text()='Булки']");
    public static final By bunsHeader = By.xpath("//h2[text()='Булки']");
    public static final By saucesTab = By.xpath(".//span[text()='Соусы']");
    public static final By saucesHeader = By.xpath("//h2[text()='Соусы']");
    public static final By toppingsTab = By.xpath(".//span[text()='Начинки']");
    public static final By toppingsHeader = By.xpath("//h2[text()='Начинки']");
}
