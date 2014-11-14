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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

/**
 * FXML Controller class.
 *
 * @author sydnipeterson
 */
public class GalSixScreenController implements Initializable {
    /**
     * fuel tab.
     */
    @FXML
    private static transient Menu fuelTab;
    /**
     * universe.
     */
    private static final transient
            Universe UNIVERSE = GameInstance.getInstance().getUniverse();
    /**
     * player.
     */
    private static final transient
            Player PLAYER = GameInstance.getInstance().getPlayer();
    /**
     * Game.
     */
    private static final transient
            Game GAME = GameInstance.getInstance();
    /**
     * Ship.
     */
    private static final transient
            Ship SHIP = GameInstance.getInstance().getPlayer().getShip();
    /**
     * location of planet.
     */
    private static final transient int SOLARSYSTEMFIVE = 5;
    /**
     * holds solar system.
     */
    private final transient SolarSystem solar = UNIVERSE.get(SOLARSYSTEMFIVE);
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
     * @param url url
     * @param rb rb
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle rb) {
        GAME.setCurrentScreen("GalSixScreen.fxml");
        // TODO
        final String str = randEvent();
        // TODO
        fuelTab.setText("Fuel: " + SHIP.getFuel() + ". " + str);
    }

    /**
     * Goes to the FamCoHQ planet when planet image is clicked on.
     *
     * @param event e
     *            occurs when the user clicks on the planet
     * @throws Exception e
     */
    @FXML
    private void goToFamCoHQPlan(final MouseEvent event) throws Exception {
        if (SHIP.getFuel() >= 0) {
            randEvent();

            SHIP.setFuel(SHIP.getFuel() - 1);
            PLAYER.setCurrentLocation(solar.getPlanets().get(0));

            final Parent root = FXMLLoader.load(getClass().getResource(
                    "PlanetScreen.fxml"));
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
                                "You do not have enough fuel to travel there."))
                                    .alignment(Pos.CENTER)
                                    .padding(new Insets(PADDING)).build()));
            dialogStage.show();
        }
    }

    /**
     * Goes to the FamCoWarehouse planet when planet image is clicked on.
     *
     * @param event e
     *            occurs when the user clicks on the planet
     * @throws Exception e
     */
    @FXML
    private void goToFamCoWarehousePlan(final MouseEvent event)
            throws Exception {
        if (SHIP.getFuel() > 0) {
            // randEvent();
            
            SHIP.setFuel(SHIP.getFuel() - 1);
            PLAYER.setCurrentLocation(solar.getPlanets().get(2 + 1));

            final Parent root = FXMLLoader.load(getClass().getResource(
                    "PlanetScreen.fxml"));
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
                "You do not have enough fuel to travel there."))
                                    .alignment(Pos.CENTER)
                                    .padding(new Insets(PADDING)).build()));
            dialogStage.show();
        }
    }

    /**
     * Goes to the FamCoSattaliteBranch planet when planet image is clicked on.
     *
     * @param event e
     *            occurs when the user clicks on the planet
     * @throws Exception e
     */
    @FXML
    private void goToFamCoSatteliteBranchPlan(final MouseEvent event)
            throws Exception {
        if (SHIP.getFuel() > 0) {
            // randEvent();

            SHIP.setFuel(SHIP.getFuel() - 1);
            PLAYER.setCurrentLocation(solar.getPlanets().get(2));

            final Parent root = FXMLLoader.load(getClass().getResource(
                    "PlanetScreen.fxml"));
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
                        "You do not have enough fuel to travel there."))
                                    .alignment(Pos.CENTER)
                                    .padding(new Insets(PADDING)).build()));
            dialogStage.show();
	}
    }

    /**
     * Goes to the FamCoMoonBranch planet when planet image is clicked on.
     *
     * @param event e
     *            occurs when the user clicks on the planet
     * @throws Exception e
     */
    @FXML
    private void goToFamCoMoonBranchPlan(final MouseEvent event)
            throws Exception {
	if (SHIP.getFuel() > 0) {
	    // randEvent();

	    SHIP.setFuel(SHIP.getFuel() - 1);
	    PLAYER.setCurrentLocation(solar.getPlanets().get(1));

	    final Parent root = FXMLLoader.load(getClass().getResource(
		    "PlanetScreen.fxml"));
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
				"You do not have enough fuel to travel there."))
				    .alignment(Pos.CENTER)
				    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
    }

    /**
     * Returns the user to the Solar System screen when the button is clicked.
     *
     * @param event e
     *            occurs when the user clicks on the "RETURN" button
     * @throws Exception e
     */
    @FXML
    private void returnToUniverse(final MouseEvent event) throws Exception {
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
                string = "Your fuel tank has "
                        + "a hole in it and some spilled out!";
                SHIP.setFuel(SHIP.getFuel() - 1);
            } else if (val == (((2 ^ 2) ^ 2) + 1)) {
                string = "Pirates raided your ship and took $50!";
                PLAYER.subtractMoney(FIFTY);
            } else if (val == (((2 ^ 2) ^ 2) + 2)) {
                PLAYER.setWantedLevel(PLAYER.getWantedLevel() + 1);
                string = "You accidentally did "
                        + "something illegal. Wanted level: "
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
     * @param event e
     *            mouse event of when user clicks on "SAVE" button
     */
    @FXML
    private void saveGame(final MouseEvent event) {
	GameInstance.saveModelBinary();
    }

    /**
     * Exits the game and returns to the main screen.
     *
     * @param event e
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
