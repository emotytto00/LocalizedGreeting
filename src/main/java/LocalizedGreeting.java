import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedGreeting {

    public static void main(String[] args) {
        Locale currentLocale = Locale.getDefault();

        if (args.length == 2) {
            currentLocale = new Locale(args[0], args[1]);
        }

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);

        System.out.println(messages.getString("greeting"));
    }
}
