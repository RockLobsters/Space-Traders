/*
 * Copyright (C) 2014 jackie
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

import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.Random;

/**
 * FXML Controller class.
 *
 * @author jackie
 */
public class PlanetScreenController implements Initializable {

    /**
    * Tab for fuel.
    */
    @FXML
    private static transient Menu fuelTab;
    /**
     * Instance of player.
     */
    private static final Player PLAYER = GameInstance.getInstance().getPlayer();
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
     * Instance of planet.
     */
    private static final Planet PLANET = PLAYER.getCurrentLocation();
    /**
     * Instance of shipyard.
     */
    private static final Shipyard YARD = new Shipyard(PLANET);

    /**
     * Button for shipyard.
     */
    @FXML
    private static transient Button shipYardButton;
    /**
    * INT they made me have.
    */
    private static final int PADDING = 30;
    /**
    * INT they made me have.
    */
    private static final int FIFTY = 50;

    /**
     * Initializes the controller class.
     * @param resource  resource
     * @param url   a url
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle resource) {
    YARD.setSolarSystem(PLANET.getSolarSystem());
    if (!YARD.makeVisible()) {
        shipYardButton.setVisible(false);
    }
    GAME.setCurrentScreen("PlanetScreen.fxml");
    final String string = randEvent();
    fuelTab.setText("Fuel: " + Integer.toString(SHIP.getFuel()) + "; "
        + PLANET.getName() + ". " + string);

    }
    /**
     * goin to the market place.
     * @param event
     * @throws Exception
     */
    @FXML
    private void goToMarket(final MouseEvent event) throws Exception {
    final Parent root = FXMLLoader.load(getClass().getResource(
        "MarketScreen.fxml"));
    final Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();

    // hide this current window (if this is whant you want
    ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    /**
     * goin to the ss n shit.
     * @param event
     * @throws Exception
     */
    @FXML
    private void returnToSystem(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        // randEvent();
        final SolarSystem system = PLANET.getSolarSystem();
        SHIP.setFuel(SHIP.getFuel() - 1);

        if (system.getName().equals("Atlantia")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalOneScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        } else if (system.getName().equals("Bardic Kingdom")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalTwoScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        } else if (system.getName().equals("Cyber Alliance")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalThreeScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        } else if (system.getName().equals("Disney System")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalFourScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        } else if (system.getName().equals("Engles Union")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalFiveScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        } else if (system.getName().equals("FamCo Ltd")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalSixScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        } else if (system.getName().equals("Golding Barrier Rim")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalSevenScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        } else if (system.getName().equals("Hipee Settlements")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalEightScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        } else if (system.getName().equals("iGalaxy")) {
        final Parent root = FXMLLoader.load(getClass().getResource(
            "GalNineScreen.fxml"));
        final Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        }
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            "You do not have enough fuel to travel there."))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }
    }

    /**
     * Generates a random event that will appear in the bottom of the screen.
     *
     * @return string of random event that happened
     */
    private String randEvent() {
    final Random rand = new Random();
    final int val = rand.nextInt(20);
    String string = "";

    if (val > (((2 ^ 2) ^ 2) - 1)) {
        // String string = "";

        if (val == ((2 ^ 2) ^ 2)) {
            string = "You found $10!";
            PLAYER.addMoney(FIFTY * 2);
        } else if (val == (((2 ^ 2) ^ 2) - 1)) {
            string = "Your fuel tank has a hole in it and some spilled out!";
            SHIP.setFuel(SHIP.getFuel() - 1);
        } else if (val == (((2 ^ 2) ^ 2) + 1)) {
            string = "Pirates raided your ship and took $50!";
            PLAYER.subtractMoney(FIFTY);
        } else if (val == (((2 ^ 2) ^ 2) + 2)) {
            PLAYER.setWantedLevel(PLAYER.getWantedLevel() + 1);
            string = "You accidentally did something illegal. Wanted level: "
                + PLAYER.getWantedLevel();
        } else if (val == (((2 ^ 2) ^ 2) + 1 + 2)) {
            PLAYER.addMoney(FIFTY + FIFTY);
            string = "You found a valueable stone and sold it for $100!";
        } else if (val == (((2 ^ 2) ^ 2) + 2 + 2)) {
            SHIP.setFuel(SHIP.getFuel() + 1);
            string = "You found some fuel!";
        }
    }
    return string;
    }

    /**
     * we savin the game n ish.
     * @param event
     */
    @FXML
    private void saveGame(final MouseEvent event) {
    GameInstance.saveModelBinary();
    }

    /**
     * goodbye game.
     * @param event
     * @throws Exception
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

    /**
     * travel to the shipyard it's fun.
     * @param event
     * @throws Exception
     */
    @FXML
    private void goToShipYard(final MouseEvent event) throws Exception {
    final Parent root = FXMLLoader.load(getClass().getResource(
        "ShipYardScreen.fxml"));
    final Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();

    // hide this current window (if this is whant you want
    ((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
