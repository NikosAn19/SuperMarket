import Services.UserAuthenticator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import Entities.User;
import UserPanels.AdminPanel;

public class MainFrame extends JFrame {
    private User currentUser; // Αποθήκευση του τρέχοντος χρήστη

    public MainFrame() {
        // Ο κώδικας για το UI του MainFrame
        initUI();
    }
    public void initUI() {
        setTitle("Login Form");
        setSize(1250, 750);  // Ορισμός μεγέθους παραθύρου
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Στοίχιση στο κέντρο της οθόνης

        // Δημιουργία και προσθήκη της φόρμας στο JFrame
        LoginForm loginForm = new LoginForm();

        // Χρήση GridBagLayout για τη φόρμα
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Ρυθμίσεις για να τοποθετηθεί λίγο πιο πάνω
        gbc.insets = new Insets(20, 20, 20, 20); // Κενό από πάνω
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Η φόρμα καλύπτει 2 στήλες για να είναι κεντραρισμένη
        add(loginForm, gbc);

        // Ορισμός του ActionListener για το κουμπί
        loginForm.setSubmitActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginForm.getUsername();
                char[] password = loginForm.getPassword();

                // Έλεγχος του role του χρήστη μέσω της κλάσης services.UserAuthenticator
                String role = UserAuthenticator.authenticateUser(username, password);

                if (role != null) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Login successful! Role: " + role);
                    currentUser = new User(username,role);
                    showAdminPanel();
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Invalid username or password.");
                }
            }
        });
    }

    private void showAdminPanel() {
        AdminPanel adminPanel = new AdminPanel(currentUser);
        setContentPane(adminPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
