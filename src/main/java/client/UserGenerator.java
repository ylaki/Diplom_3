package client;
import models.UserData;
import static utils.Utils.randomEmail;
import static utils.Utils.randomString;

    public class UserGenerator {

        static int emailLength = 10;
        static int passwordLength = 10;
        static int nameLength = 20;

        public static UserData randomUser() {
            return new UserData()
                    .withEmail(randomEmail(emailLength))
                    .withPassword(randomString(passwordLength))
                    .withName(randomString(nameLength));
        }
    }
