import java.awt.*;
import java.awt.event.*;

public class LoginForm extends Frame {
    private Label usernameLabel;
    private Label passwordLabel;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private Button loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));

        usernameLabel = new Label("Username:");
        passwordLabel = new Label("Password:");
        usernameTextField = new TextField();
        passwordTextField = new TextField();
        passwordTextField.setEchoChar('*');
        loginButton = new Button("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();

                if (username.equals("USER") && password.equals("CONSUMER")) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Login failed. Please check your username and password.");
                }
            }
        });

        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(new Label("")); // Empty label for spacing
        add(loginButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}
