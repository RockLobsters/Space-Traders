/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author addison
 */
public class RootWindowController implements Initializable {

    /**
     *
     * @param event e
     * @throws Exception e
     */
    @FXML
    private void handleNewGameAction(final ActionEvent event) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getResource(
                "NewGameWindow.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    /**
     *
     * @param event e
     * @throws Exception e
     */
    @FXML
    private void handleLoadGameAction(final ActionEvent event) 
            throws Exception {
        GameInstance.loadModelBinary();
        final Parent root = FXMLLoader.load(getClass().getResource(
                GameInstance.getInstance().getCurrentScreen()));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    /**
     *
     * @param event e
     */
    @FXML
    private void handleExitAction(final ActionEvent event) {
        System.exit(0);
    }
    /**
     *
     * @param url url
     * @param rb rb
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        // TODO
    }

}
