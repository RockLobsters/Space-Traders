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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 * FXML Controller class.
 *
 * @author addison
 */
public class NewGameWindowController implements Initializable {
    /**
     * fighter skills.
     */
    @FXML
    private static transient Slider fighterSlider;
    /**
     * trader skills.
     */
    @FXML
    private static transient Slider traderSlider;
    /**
     * engineer skills.
     */
    @FXML
    private static transient Slider engineerSlider;
    /**
     * investor skills.
     */
    @FXML
    private static transient Slider investorSlider;
    /**
     * pilot skills.
     */
    @FXML
    private static transient Slider pilotSlider;
    /**
     * Remaining points for player to have.
     */
    @FXML
    private static transient Label pointsRemaining;
    /**
     * takes in players name.
     */
    @FXML
    private static transient TextField name;
    /**
     * Max skill points a player can have.
     */
    private static final transient int MAXSKILL = 10;
    /**
     *
     */
    private static final transient int PADDING = 30;
    /**
     *
     * @param event e
     * @throws Exception e
     */
    @FXML
    private void handleCancelAction(final ActionEvent event) throws Exception {
        final Parent root = FXMLLoader
                .load(getClass().getResource("RootWindow.fxml"));
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
    private void handleStartGameAction(final ActionEvent event)
            throws Exception {
        final int fighterValue = (int) fighterSlider.getValue();
        final int traderValue = (int) traderSlider.getValue();
        final int engineerValue = (int) engineerSlider.getValue();
        final int investorValue = (int) investorSlider.getValue();
        final int pilotValue = (int) pilotSlider.getValue();
        final int skillPoints = fighterValue + traderValue + engineerValue
                + investorValue + pilotValue;

        final String playerName = name.getText();
        if (skillPoints == MAXSKILL && !playerName.isEmpty()) {
            final Player player = new Player(playerName);
            player.setEngineer(engineerValue);
            player.setFighter(fighterValue);
            player.setInvestor(investorValue);
            player.setPilot(pilotValue);
            player.setTrader(traderValue);

            final Game newGame = GameInstance.getInstance();
            newGame.createUniverse();
            newGame.setPlayer(player);

            final Parent root = FXMLLoader.load(getClass().getResource(
                    "UniverseScreen.fxml"));
            final Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // hide this current window (if this is whant you want
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } else if (playerName.isEmpty()) {
            final Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create()
                    .children(new Text("Please Enter a Valid Name"))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
            dialogStage.show();
        } else {
            final Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage
                    .setScene(new Scene(
                            VBoxBuilder
                                    .create()
                                    .children(
                                            new Text(
            "You can only allocate 10 stat points to your "
                    + "player.\nPlease do that to continue."))
                                    .alignment(Pos.CENTER)
                                    .padding(new Insets(PADDING)).build()));
            dialogStage.show();

                }

    }

    /**
     * Initializes the controller class.
     * @param rb rb
     * @param url url
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        //not needed
    }
    /**
     *
     * @param event e
     */
    @FXML
    private void slider(final MouseEvent event) {

        // to do add lable to tell current values
        final int fighterValue = (int) fighterSlider.getValue();
        final int traderValue = (int) traderSlider.getValue();
        final int engineerValue = (int) engineerSlider.getValue();
        final int investorValue = (int) investorSlider.getValue();
        final int pilotValue = (int) pilotSlider.getValue();

        int remaining = fighterValue + traderValue + engineerValue
                + investorValue + pilotValue;
        remaining = MAXSKILL - remaining;
        pointsRemaining.setText(Integer.toString(remaining));
    }

}
