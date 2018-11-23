package be.technifutur.mobile.controller;

import be.technifutur.mobile.service.UserService;
import be.technifutur.mobile.service.impl.UserServiceImpl;
import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import be.technifutur.mobile.util.ServiceLocator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController implements EventHandler<MouseEvent> {

    private UserService userService;

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Label lblError;

    @FXML
    private Button loginButton;

    public void initialize() {

        userService = ServiceLocator.getInstance().getUserService();

        loginButton.setOnMouseClicked(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() == loginButton) {

            String username = tfUsername.getText();
            String password = pfPassword.getText();

            boolean valid = userService.login(username, password);

            if (valid) {
                lblError.setVisible(false);
                NavigationMessenger.getInstance().navigateTo(Page.MENU);
            } else {
                lblError.setVisible(true);
                pfPassword.setText("");
            }
        } else {
            System.out.println("Clic non géré");
        }
    }
}
