package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserAuthenticator {

    // Μέθοδος για να ελέγξουμε τον χρήστη στο αρχείο
    public static String authenticateUser(String username, char[] password) {
        String line;
        String filePath = "src/DB/users.txt"; 

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String user = parts[0].split(":")[1];
                String pass = parts[1].split(":")[1];
                String role = parts[2].split(":")[1];

                // Έλεγχος αν ταιριάζει το username και password
                if (user.equals(username) && pass.equals(new String(password))) {
                    return role; // Επιστρέφουμε το role αν βρεθεί ο χρήστης
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Αν δεν βρεθεί ο χρήστης
    }
}
