package be.technifutur.mobile.controller;

import be.technifutur.mobile.Main;
import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Nox4uController implements EventHandler<MouseEvent> {

    @FXML
    private Button FenixButton;
    @FXML
    private Button GenjiButton;
    @FXML
    private Button MaievButton;
    @FXML
    private Button ThrallButton;

    public void initialize() {

        System.out.println("initialize() menu");

        FenixButton.setText("Fenix");
        FenixButton.setOnMouseClicked(this);
        GenjiButton.setText("Genji");
        GenjiButton.setOnMouseClicked(this);
        MaievButton.setText("Maiev");
        MaievButton.setOnMouseClicked(this);
        ThrallButton.setText("Thrall");
        ThrallButton.setOnMouseClicked(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() == FenixButton) {
            System.out.println("Clicked !");
            FenixButton.setText("Already clicked");
            FenixButton.setDisable(true);

            NavigationMessenger.getInstance().navigateTo(Page.Fenix);
        } else {
            System.out.println("Clic non géré");
        }

        if (mouseEvent.getSource() == GenjiButton) {
            System.out.println("Clicked !");
            GenjiButton.setText("Already clicked");
            GenjiButton.setDisable(true);

            NavigationMessenger.getInstance().navigateTo(Page.Genji);
        } else {
            System.out.println("Clic non géré");
        }

        if (mouseEvent.getSource() == MaievButton) {
            System.out.println("Clicked !");
            MaievButton.setText("Already clicked");
            MaievButton.setDisable(true);

            NavigationMessenger.getInstance().navigateTo(Page.Maiev);
        } else {
            System.out.println("Clic non géré");
        }

        if (mouseEvent.getSource() == ThrallButton) {
            System.out.println("Clicked !");
            ThrallButton.setText("Already clicked");
            ThrallButton.setDisable(true);

            NavigationMessenger.getInstance().navigateTo(Page.Thrall);
        } else {
            System.out.println("Clic non géré");
        }
    }
}
