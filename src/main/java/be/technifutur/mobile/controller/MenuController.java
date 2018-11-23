package be.technifutur.mobile.controller;

import be.technifutur.mobile.Main;
import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MenuController implements EventHandler<MouseEvent> {

    @FXML
    private Button Nox4uButton;
    @FXML
    private Button HeiaButton;
    @FXML
    private Button TazZButton;
    @FXML
    private Button WulfricButton;

    public void initialize() {

        System.out.println("initialize() menu");

        Nox4uButton.setText("Nox4u");
        Nox4uButton.setOnMouseClicked(this);
        HeiaButton.setText("Heia");
        HeiaButton.setOnMouseClicked(this);
        TazZButton.setText("TazZ");
        TazZButton.setOnMouseClicked(this);
        WulfricButton.setText("Wulfric");
        WulfricButton.setOnMouseClicked(this);
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() == Nox4uButton) {
            System.out.println("Clicked !");
            Nox4uButton.setText("Already clicked");
            Nox4uButton.setDisable(true);

            NavigationMessenger.getInstance().navigateTo(Page.Nox4u);
        } else {
            System.out.println("Clic non géré");
        }

        if (mouseEvent.getSource() == HeiaButton) {
            System.out.println("Clicked !");
            HeiaButton.setText("Already clicked");
            HeiaButton.setDisable(true);

            NavigationMessenger.getInstance().navigateTo(Page.Heia);
        } else {
            System.out.println("Clic non géré");
        }

        if (mouseEvent.getSource() == TazZButton) {
            System.out.println("Clicked !");
            TazZButton.setText("Already clicked");
            TazZButton.setDisable(true);

            NavigationMessenger.getInstance().navigateTo(Page.TazZ);
        } else {
            System.out.println("Clic non géré");
        }

        if (mouseEvent.getSource() == WulfricButton) {
            System.out.println("Clicked !");
            WulfricButton.setText("Already clicked");
            WulfricButton.setDisable(true);

            NavigationMessenger.getInstance().navigateTo(Page.Wulfric);
        } else {
            System.out.println("Clic non géré");
        }
    }
}
