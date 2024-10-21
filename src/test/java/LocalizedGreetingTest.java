import org.junit.jupiter.api.Test;
import java.util.Locale;
import java.util.ResourceBundle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizedGreetingTest {

    @Test
    void testEnglishLocale() {
        Locale locale = new Locale("en", "US");
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Hello! Welcome to our application.", messages.getString("greeting"));
    }

    @Test
    void testFrenchLocale() {
        Locale locale = new Locale("fr", "FR");
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Bonjour! Bienvenue dans notre application.", messages.getString("greeting"));
    }

    @Test
    void testSpanishLocale() {
        Locale locale = new Locale("es", "ES");
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("¡Hola! Bienvenido a nuestra aplicación.", messages.getString("greeting"));
    }

    @Test
    void testFarsiLocale() {
        Locale locale = new Locale("fa", "IR");
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("سلام! به برنامه ما خوش آمدید", messages.getString("greeting"));
    }
    @Test
    void testFinnishLocale() {
        Locale locale = new Locale("fi", "FI");
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Hei! Tervetuloa sovellukseemme.", messages.getString("greeting"));
    }
}