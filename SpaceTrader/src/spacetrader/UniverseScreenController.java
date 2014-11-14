/*
 * Copyright (C) 2014 sydnipeterson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spacetrader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.stage.Modality;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * FXML Controller class.
 *
 * @author sydnipeterson
 */
public class UniverseScreenController implements Initializable {
    /**
    * Tab for fuel.
    */
    @FXML
    private static transient Menu fuelTab;

    /**
     * Instance of ship.
     */
    private static final Ship SHIP =
            GameInstance.getInstance().getPlayer().getShip();
    /**
     * Instance of game.
     */
    private static final Game GAME = GameInstance.getInstance();

    /**
    * String they made me have.
    */
    private static final String ENOUGH =
            "You do not have enough fuel to travel there.";
    /**
    * INT they made me have.
    */
    private static final int PADDING = 30;

    /**
     * Initializes the controller class.
     * @param resource  resource
     * @param url   a url
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle resource) {
    GAME.setCurrentScreen("UniverseScreen.fxml");
    // TODO
    // fuelTab.setText("Fuel: ");
    fuelTab.setText("Fuel: " + Integer.toString(SHIP.getFuel()));
    }

    /**
     * Returns to main menu when clicked.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void returnMainMenu(final MouseEvent event) throws Exception {
    final Parent root = FXMLLoader
        .load(getClass().getResource("RootWindow.fxml"));
    final Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();

    // hide this current window (if this is whant you want
    ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Takes player to first galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal1(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalOneScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Takes player to fourth galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal4(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalFourScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Takes player to seventh galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal7(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalSevenScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Takes player to fifth galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal5(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalFiveScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Takes player to second galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal2(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalTwoScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Takes player to eighth galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal8(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalEightScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Takes player to three galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal3(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalThreeScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Takes player to sixth galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal6(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalSixScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Takes player to ninth (0) galaxy.
     *
     * @param event that triggers this action
     * @throws Exception
     */
    @FXML
    private void goToGal0(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalNineScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            ENOUGH))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }

    }

    /**
     * Saves the game.
     *
     * @param event
     *            mouse event of when user clicks on "SAVE" button
     */
    @FXML
    private void saveGame(final MouseEvent event) {
    GameInstance.saveModelBinary();
    }

    /**
     * Exits the game and returns to the main screen.
     *
     * @param event
     *            mouse event of when user clicks on "EXIT" button
     * @throws  Exception
     */
    @FXML
    private void exit(final MouseEvent event) throws Exception {
    final Parent root = FXMLLoader
        .load(getClass().getResource("RootWindow.fxml"));
    final Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();

    // hide this current window (if this is whant you want
    ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}