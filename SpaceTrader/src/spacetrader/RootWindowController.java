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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author addison
 */
public class RootWindowController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button newGameButton;
    @FXML
    private Button loadGameButton;
    @FXML
    private Button exitButton;
    
    @FXML
    private void handleNewGameAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("NewGameWindow.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        //hide this current window (if this is whant you want
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void handleLoadGameAction(ActionEvent event) throws Exception {
        GameInstance.loadModelBinary();
        Parent root = FXMLLoader.load(getClass().getResource(GameInstance.getInstance().getCurrentScreen()));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        //hide this current window (if this is whant you want
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }
  
    @FXML
    private void handleExitAction(ActionEvent event) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
