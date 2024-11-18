import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JPanel {
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton submitButton;

    // Constructor για τη φόρμα
    public LoginForm() {
        setLayout(new GridBagLayout());  // Χρήση του GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // Ρυθμίσεις για τη διάταξη των στοιχείων

        // Ρυθμίσεις για τα GridBagConstraints
        gbc.insets = new Insets(10, 10, 10, 10); // Πρόσθετο κενό γύρω από τα στοιχεία
        gbc.anchor = GridBagConstraints.CENTER; // Ευθυγράμμιση στο κέντρο

        // Δημιουργία του label "Login" στο πάνω μέρος της φόρμας
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Ορισμός μεγαλύτερης γραμματοσειράς
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Το label θα καλύπτει 2 στήλες
        add(titleLabel, gbc);

        // Δημιουργία στοιχείων φόρμας
        JLabel userLabel = new JLabel("Username:");
        userText = new JTextField(20);  // Ορίζουμε μέγεθος 20 για το πεδίο κειμένου

        JLabel passwordLabel = new JLabel("Password:");
        passwordText = new JPasswordField(20);  // Ορίζουμε μέγεθος 20 για το πεδίο κωδικού

        submitButton = new JButton("Submit");

        // Προσθήκη του πρώτου label και του πεδίου εισαγωγής (Username)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Επαναφορά σε 1 στήλη
        add(userLabel, gbc);
        gbc.gridx = 1;
        add(userText, gbc);

        // Προσθήκη του δεύτερου label και του πεδίου εισαγωγής (Password)
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        add(passwordText, gbc);

        // Προσθήκη του κουμπιού υποβολής
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(submitButton, gbc);
    }

    // Μέθοδος για να πάρεις τα δεδομένα της φόρμας
    public String getUsername() {
        return userText.getText();
    }

    public char[] getPassword() {
        return passwordText.getPassword();
    }

    // Μέθοδος για να ρυθμίσεις τον ActionListener στο κουμπί
    public void setSubmitActionListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
