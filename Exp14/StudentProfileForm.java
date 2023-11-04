import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class StudentProfileForm extends Frame {
    private TextField nameField;
    private TextField ageField;
    private TextField emailField;
    private TextField rollNoField;
    private TextField branchField;
    private TextField courseField;
    private Button submitButton;

    public StudentProfileForm() {
        setTitle("Student Profile Form");
        setSize(400, 250);
        setLayout(new GridLayout(7, 2));

        Label nameLabel = new Label("Name:");
        nameField = new TextField(30);
        Label ageLabel = new Label("Age:");
        ageField = new TextField(30);
        Label emailLabel = new Label("Email:");
        emailField = new TextField(30);
        Label rollNoLabel = new Label("Roll No:");
        rollNoField = new TextField(30);
        Label branchLabel = new Label("Branch:");
        branchField = new TextField(30);
        Label courseLabel = new Label("Course:");
        courseField = new TextField(30);
        submitButton = new Button("Submit");

        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(emailLabel);
        add(emailField);
        add(rollNoLabel);
        add(rollNoField);
        add(branchLabel);
        add(branchField);
        add(courseLabel);
        add(courseField);
        add(new Label(""));
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    String email = emailField.getText();
                    String rollNo = rollNoField.getText();
                    String branch = branchField.getText();
                    String course = courseField.getText();

                    if (isValidData(name, age, email, rollNo, branch, course)) {
                        System.out.println("Student Profile Submitted:");
                        System.out.println("Name: " + name);
                        System.out.println("Age: " + age);
                        System.out.println("Email: " + email);
                        System.out.println("Roll No: " + rollNo);
                        System.out.println("Branch: " + branch);
                        System.out.println("Course: " + course);
                    } else {
                        showMessage("Invalid input. Please check your data.");
                    }
                } catch (NumberFormatException ex) {
                    showMessage("Invalid age. Please enter a valid number.");
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private boolean isValidData(String name, int age, String email, String rollNo, String branch, String course) {
        if (name.isEmpty() || email.isEmpty() || rollNo.isEmpty() || branch.isEmpty() || course.isEmpty()) {
            return false;
        }
        if (age < 0 || age > 120) {
            return false;
        }
        if (!isValidEmail(email)) {
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailRegex, email);
    }

    private void showMessage(String message) {
        Dialog dialog = new Dialog(this, "Error", true);
        Label label = new Label(message);
        dialog.add(label);
        dialog.setSize(300, 100);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        StudentProfileForm profileForm = new StudentProfileForm();
        profileForm.setVisible(true);
    }
}
