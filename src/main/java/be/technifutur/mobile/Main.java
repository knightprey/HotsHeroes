package be.technifutur.mobile;

import be.technifutur.mobile.util.NavigationMessenger;
import be.technifutur.mobile.util.Page;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application implements NavigationMessenger.Listener {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("MediaT3K");
        primaryStage.setMaximized(false);
        // primaryStage.setFullScreen(true);

        goToFirstScene();

        NavigationMessenger.getInstance().register(this);

        primaryStage.show();
    }

    @Override
    public void onNavigateTo(Page page) {

        switch (page) {
            case MAIN:
                goToFirstScene();
                break;
            case MENU:
                goToSecondScene();
                break;
            case Heia:
                goToThirdScene();
                break;
            case Nox4u:
                goToFourthScene();
                break;
            case TazZ:
                goToFithScene();
                break;
            case Wulfric:
                goToSixthScene();
                break;
            default:
                System.err.println("Unknown page : " + page);
                break;
        }
    }

    private void goToFirstScene() {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/main.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToSecondScene() {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/menu.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void goToThirdScene() {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/Heia.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void goToFourthScene() {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/Nox4u.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void goToFithScene() {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/TazZ.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void goToSixthScene() {
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("/views/Wulfric.fxml"));
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
