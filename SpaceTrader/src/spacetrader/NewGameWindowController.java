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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author addison
 */
public class NewGameWindowController implements Initializable {

    @FXML
    private Button startGameButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField Name;
    @FXML
    private Slider fighterSlider;
    @FXML
    private Slider traderSlider;
    @FXML
    private Slider engineerSlider;
    @FXML
    private Slider investorSlider;
    @FXML
    private Slider pilotSlider;
    @FXML
    private Label pointsRemaining;

    @FXML
    private void handleCancelAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RootWindow.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        //hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void handleStartGameAction(ActionEvent event) throws Exception{
        int fighterValue = (int) fighterSlider.getValue();
        int traderValue = (int) traderSlider.getValue();
        int engineerValue = (int) engineerSlider.getValue();
        int investorValue = (int) investorSlider.getValue();
        int pilotValue = (int) pilotSlider.getValue();

        int skillPoints = fighterValue + traderValue + engineerValue + investorValue + pilotValue;

        String name = Name.getText();
        if (skillPoints == 10 && !name.isEmpty()) {
            // Dialogs.create().owner(stage).title("Confirm Dialog").masthead("Look, a Confirm Dialog").message("Do you want to continue?").showConfirm();
            Player player = new Player(name);
            player.setEngineer(engineerValue);
            player.setFighter(fighterValue);
            player.setInvestor(investorValue);
            player.setPilot(pilotValue);
            player.setTrader(traderValue);
            
            Game newGame = GameInstance.getInstance();
            newGame.createUniverse();
            newGame.setPlayer(player);
            
            
            Parent root = FXMLLoader.load(getClass().getResource("UniverseScreen.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            //hide this current window (if this is whant you want
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } else if(name.isEmpty()) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("Please Enter a Valid Name")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
            System.out.println("invlaid name");
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You can only allocate 10 stat points to your player.\nPlease do that to continue.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

            System.out.println("wrong number of skill points");
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void slider(MouseEvent event) {
        //to do add lable to tell current values
        int fighterValue = (int) fighterSlider.getValue();
        int traderValue = (int) traderSlider.getValue();
        int engineerValue = (int) engineerSlider.getValue();
        int investorValue = (int) investorSlider.getValue();
        int pilotValue = (int) pilotSlider.getValue();

        int remaining = fighterValue + traderValue + engineerValue + investorValue + pilotValue;
        remaining = 10 - remaining;
        pointsRemaining.setText(Integer.toString(remaining));
    }

}
