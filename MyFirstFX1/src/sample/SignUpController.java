package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SignUpController {

    @FXML
    private TextField signUpLastName;

    @FXML
    private PasswordField passwordFild;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField loginFild;

    @FXML
    private TextField signUpCountry;

    @FXML
    private CheckBox signUpChekBoxMael;

    @FXML
    private CheckBox signUpChekBoxFemal;

    @FXML
    void initialize() {

        signUpButton.setOnAction(event -> {
            try {
                signUpNewUser();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
    private void signUpNewUser() throws SQLException, ClassNotFoundException {
        DateBaseHandler dbHandler = new DateBaseHandler();

        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = loginFild.getText();
        String password = passwordFild.getText();
        String location = signUpCountry.getText();
        String gender = "";
        if (signUpChekBoxMael.isSelected()) {
            gender = "Man";
        } else {
            gender = "Woman";
        }

        User user = new User(firstName, lastName, userName, gender, password, location);
        dbHandler.signUpUser(user);
    }
}
