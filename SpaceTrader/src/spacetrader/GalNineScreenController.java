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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

/**
 * FXML Controller class
 *
 * @author sydnipeterson
 */
public class GalNineScreenController implements Initializable {

    @FXML
    private Menu fuelTab;
    @FXML
    private ImageView iPlanet2;
    @FXML
    private ImageView iPlanet5;
    @FXML
    private ImageView iPlanet3;
    @FXML
    private ImageView iPlanet4;
    @FXML
    private ImageView iPlanet1;
    private Universe universe = GameInstance.getInstance().getUniverse();
    private Player player = GameInstance.getInstance().getPlayer();
    private Ship ship = GameInstance.getInstance().getPlayer().getShip();

    private Game game = GameInstance.getInstance();

    private SolarSystem solar = universe.get(8);

    /**
     * Initializes the controller class.
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	game.setCurrentScreen("GalNineScreen.fxml");
	String s = randEvent();
	// TODO
	fuelTab.setText("Fuel: " + ship.getFuel() + ". " + s);
    }

    /**
     * Goes to the iplanet2 planet when planet image is clicked on
     *
     * @param event
     *            occours when the user clicks on the planet
     */
    @FXML
    private void goToiPlanet2(MouseEvent event) throws Exception {
	if (ship.getFuel() > 0) {
	    // randEvent();

	    ship.setFuel(ship.getFuel() - 1);
	    player.setCurrentLocation(solar.getPlanets().get(1));

	    // Game game = GameInstance.getInstance();
	    // game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
	    // look at this ^^^
	    Parent root = FXMLLoader.load(getClass().getResource(
		    "PlanetScreen.fxml"));
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();

	    // hide this current window (if this is whant you want
	    ((Node) (event.getSource())).getScene().getWindow().hide();
	} else {
	    Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage
		    .setScene(new Scene(
			    VBoxBuilder
				    .create()
				    .children(
					    new Text(
						    "You do not have enough fuel to travel there."))
				    .alignment(Pos.CENTER)
				    .padding(new Insets(30)).build()));
	    dialogStage.show();
	}
    }

    /**
     * Goes to the iplanet5 planet when planet image is clicked on
     *
     * @param event
     *            occours when the user clicks on the planet
     */
    @FXML
    private void goToiPlanet5(MouseEvent event) throws Exception {
	if (ship.getFuel() > 0) {
	    // randEvent();

	    ship.setFuel(ship.getFuel() - 1);
	    player.setCurrentLocation(solar.getPlanets().get(4));

	    // Game game = GameInstance.getInstance();
	    // game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
	    // look at this ^^^
	    Parent root = FXMLLoader.load(getClass().getResource(
		    "PlanetScreen.fxml"));
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();

	    // hide this current window (if this is whant you want
	    ((Node) (event.getSource())).getScene().getWindow().hide();
	} else {
	    Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage
		    .setScene(new Scene(
			    VBoxBuilder
				    .create()
				    .children(
					    new Text(
						    "You do not have enough fuel to travel there."))
				    .alignment(Pos.CENTER)
				    .padding(new Insets(30)).build()));
	    dialogStage.show();
	}
    }

    /**
     * Goes to the iPlanet3 planet when planet image is clicked on
     *
     * @param event
     *            occours when the user clicks on the planet
     */
    @FXML
    private void goToiPlanet3(MouseEvent event) throws Exception {
	if (ship.getFuel() > 0) {
	    // randEvent();

	    ship.setFuel(ship.getFuel() - 1);
	    player.setCurrentLocation(solar.getPlanets().get(2));

	    // Game game = GameInstance.getInstance();
	    // game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
	    // look at this ^^^
	    Parent root = FXMLLoader.load(getClass().getResource(
		    "PlanetScreen.fxml"));
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();

	    // hide this current window (if this is whant you want
	    ((Node) (event.getSource())).getScene().getWindow().hide();
	} else {
	    Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage
		    .setScene(new Scene(
			    VBoxBuilder
				    .create()
				    .children(
					    new Text(
						    "You do not have enough fuel to travel there."))
				    .alignment(Pos.CENTER)
				    .padding(new Insets(30)).build()));
	    dialogStage.show();
	}
    }

    /**
     * Goes to the iPlanet4 planet when planet image is clicked on
     *
     * @param event
     *            occours when the user clicks on the planet
     */
    @FXML
    private void goToiPlanet4(MouseEvent event) throws Exception {
	if (ship.getFuel() > 0) {
	    // randEvent();

	    ship.setFuel(ship.getFuel() - 1);
	    player.setCurrentLocation(solar.getPlanets().get(3));

	    // Game game = GameInstance.getInstance();
	    // game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
	    // look at this ^^^
	    Parent root = FXMLLoader.load(getClass().getResource(
		    "PlanetScreen.fxml"));
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();

	    // hide this current window (if this is whant you want
	    ((Node) (event.getSource())).getScene().getWindow().hide();
	} else {
	    Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage
		    .setScene(new Scene(
			    VBoxBuilder
				    .create()
				    .children(
					    new Text(
						    "You do not have enough fuel to travel there."))
				    .alignment(Pos.CENTER)
				    .padding(new Insets(30)).build()));
	    dialogStage.show();
	}
    }

    /**
     * Goes to the iPlanet1 planet when planet image is clicked on
     *
     * @param event
     *            occours when the user clicks on the planet
     */
    @FXML
    private void goToiPlanet1(MouseEvent event) throws Exception {
	if (ship.getFuel() >= 0) {
	    // randEvent();

	    ship.setFuel(ship.getFuel() - 1);
	    player.setCurrentLocation(solar.getPlanets().get(0));

	    // Game game = GameInstance.getInstance();
	    // game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
	    // look at this ^^^
	    Parent root = FXMLLoader.load(getClass().getResource(
		    "PlanetScreen.fxml"));
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();

	    // hide this current window (if this is whant you want
	    ((Node) (event.getSource())).getScene().getWindow().hide();
	} else {
	    Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage
		    .setScene(new Scene(
			    VBoxBuilder
				    .create()
				    .children(
					    new Text(
						    "You do not have enough fuel to travel there."))
				    .alignment(Pos.CENTER)
				    .padding(new Insets(30)).build()));
	    dialogStage.show();
	}
    }

    /**
     * Returns the user to the Solar System screen when the button is clicked
     *
     * @param event
     *            occours when the user clicks on the "RETURN" button
     */
    @FXML
    private void returnToUniverse(MouseEvent event) throws Exception {
	if (ship.getFuel() > 0) {
	    // randEvent();

	    ship.setFuel(ship.getFuel() - 1);

	    // Game game = GameInstance.getInstance();
	    // game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
	    // look at this ^^^
	    Parent root = FXMLLoader.load(getClass().getResource(
		    "UniverseScreen.fxml"));
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();

	    // hide this current window (if this is whant you want
	    ((Node) (event.getSource())).getScene().getWindow().hide();
	} else {
	    Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage
		    .setScene(new Scene(
			    VBoxBuilder
				    .create()
				    .children(
					    new Text(
						    "You do not have enough fuel to travel there."))
				    .alignment(Pos.CENTER)
				    .padding(new Insets(30)).build()));
	    dialogStage.show();
	}
    }

    /**
     * Generates a random event that will appear in the bottom of the screen.
     *
     * @return string of random event that happened
     */
    private String randEvent() {
	Random rand = new Random();
	int x = rand.nextInt(20);
	String string = "";

	if (x > 15) {
	    // String string = "";

	    if (x == 16) {
		string = "You found $10!";
		player.addMoney(100);
	    } else if (x == 15) {
		string = "Your fuel tank has a hole in it and some spilled out!";
		ship.setFuel(ship.getFuel() - 1);
	    } else if (x == 17) {
		string = "Pirates raided your ship and took $50!";
		player.subtractMoney(50);
	    } else if (x == 18) {
		player.setWantedLevel(player.getWantedLevel() + 1);
		string = "You accidentally did something illegal. Wanted level: "
			+ player.getWantedLevel();
	    } else if (x == 19) {
		player.addMoney(100);
		string = "You found a valueable stone and sold it for $100!";
	    } else if (x == 20) {
		ship.setFuel(ship.getFuel() + 1);
		string = "You found some fuel!";
	    }

	    // return string;
	    // Stage dialogStage = new Stage();
	    // dialogStage.initModality(Modality.WINDOW_MODAL);
	    // dialogStage.setScene(new Scene(VBoxBuilder.create().
	    // children(new Text(string)).
	    // alignment(Pos.CENTER).padding(new Insets(30)).build()));
	    // dialogStage.show();
	    // try {
	    // Thread.sleep(2000); //1000 milliseconds is one second.
	    // } catch(InterruptedException ex) {
	    // Thread.currentThread().interrupt();
	    // }
	}
	return string;
    }

    /**
     * Saves the game
     *
     * @param event
     *            mouse event of when user clicks on "SAVE" button
     */
    @FXML
    private void saveGame(MouseEvent event) {
	GameInstance.saveModelBinary();
    }

    /**
     * Exits the game and returns to the main screen
     *
     * @param event
     *            mouse event of when user clicks on "EXIT" button
     */
    @FXML
    private void exit(MouseEvent event) throws Exception {
	Parent root = FXMLLoader
		.load(getClass().getResource("RootWindow.fxml"));
	Stage stage = new Stage();
	stage.setScene(new Scene(root));
	stage.show();

	// hide this current window (if this is whant you want
	((Node) (event.getSource())).getScene().getWindow().hide();
    }

}
