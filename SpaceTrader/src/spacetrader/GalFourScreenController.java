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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.stage.Modality;
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
public class GalFourScreenController implements Initializable {


    /**
     * Tab for fuel.
     */
    @FXML
    private static transient Menu fuelTab;
    /**
     * Image for planet.
     */
    @FXML
    private static transient ImageView disneyPlanet;
    /**
     * Image for planet.
     */
    @FXML
    private static transient ImageView disneyResort;

     /**
     * Instance of universe.
     */
    private static final Universe UNIVERSE =
            GameInstance.getInstance().getUniverse();
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
     * Instance of current solar system.
     */
    private static final SolarSystem SOLAR = UNIVERSE.get(4);

    /**
     * Final string cause it's an error which is dumb.
     */
    private static final String PLANETSTRING = "PlanetScreen.fxml";
    /**
     * Final string cause it's an error which is dumb.
     */
    private static final String FUELERROR =
            "You do not have enough fuel to travel there.";
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
    GAME.setCurrentScreen("GalFourScreen.fxml");
    final String string = randEvent();
    // TODO
    fuelTab.setText("Fuel: " + SHIP.getFuel() + ". " + string);

    final ArrayList<Planet> planets = SOLAR.getPlanets();

    Planet planet = planets.get(0);
    disneyPlanet.setX(planet.getCoordinateX());
    disneyPlanet.setY(planet.getCoordinateY());

    planet = planets.get(1);
    disneyResort.setX(planet.getCoordinateX());
    disneyResort.setY(planet.getCoordinateY());
    }

    /**
     * Returns the user to the Solar System screen when the button is clicked.
     *
     * @param event
     *            occurs when the user clicks on the "RETURN" button
     * @throws Exception e
     */
    @FXML
    private void returnToSolar(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        // randEvent();

        SHIP.setFuel(SHIP.getFuel() - 1);

        final Parent root = FXMLLoader.load(getClass().getResource(
            "UniverseScreen.fxml"));
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
                            FUELERROR))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }
    }

    /**
     * Goes to the Disney planet when planet image is clicked on.
     *
     * @param event
     *            occours when the user clicks on the planet
     * @throws Exception e
     */
    @FXML
    private void goToDisneyPlanet(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        // randEvent();

        SHIP.setFuel(SHIP.getFuel() - 1);
        PLAYER.setCurrentLocation(SOLAR.getPlanets().get(0));

        final Parent root = FXMLLoader.load(getClass().getResource(
            PLANETSTRING));
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
                            FUELERROR))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();
    }
    }

    /**
     * Goes to the Disney Resort planet when planet image is clicked on.
     *
     * @param event
     *            occurs when the user clicks on the planet
     * @throws Exception e
     */
    @FXML
    private void goToDisneyResort(final MouseEvent event) throws Exception {
    if (SHIP.getFuel() > 0) {
        // randEvent();

        SHIP.setFuel(SHIP.getFuel() - 1);
        PLAYER.setCurrentLocation(SOLAR.getPlanets().get(1));

        final Parent root = FXMLLoader.load(getClass().getResource(
            PLANETSTRING));
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
                            FUELERROR))
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
     * @throws Exception e
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
