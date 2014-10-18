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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.scene.control.Button;

import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;



/**
 * FXML Controller class
 *
 * @author jackie
 */
public class GalOneScreenController implements Initializable {
    @FXML
    private Menu fuelTab;
    @FXML
    private ImageView peachtreePlan;
    @FXML
    private ImageView gastatePLan;
    @FXML
    private ImageView gatechPlan;
    @FXML
    private ImageView poncePlan;

    private Universe universe = GameInstance.getInstance().getUniverse();
    private Player player = GameInstance.getInstance().getPlayer();
    private Ship ship = GameInstance.getInstance().getPlayer().getShip();
    private Game game = GameInstance.getInstance();
    private SolarSystem solar = universe.get(0);
    @FXML
    private Button returnButton;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game.setCurrentScreen("GalOneScreen.fxml");
        fuelTab.setText("Fuel: " + ship.getFuel());

        ArrayList<Planet> planets = solar.getPlanets();

        Planet planet = planets.get(0);
        peachtreePlan.setX(planet.getCoordinateX());
        peachtreePlan.setY(planet.getCoordinateY());

        planet = planets.get(1);
        gastatePLan.setX(planet.getCoordinateX());
        gastatePLan.setY(planet.getCoordinateY());

        planet = planets.get(2);
        gatechPlan.setX(planet.getCoordinateX());
        gatechPlan.setY(planet.getCoordinateY());

        planet = planets.get(3);
        poncePlan.setX(planet.getCoordinateX());
        poncePlan.setY(planet.getCoordinateY());
    }    

    @FXML
    private void goToPeachtreePlan(MouseEvent event) throws Exception {
        if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);
            player.setCurrentLocation(solar.getPlanets().get(1));

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            //hide this current window (if this is whant you want
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You do not have enough fuel to travel there.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

    }

    @FXML
    private void goToGastatePlan(MouseEvent event) throws Exception {
        if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);
            player.setCurrentLocation(solar.getPlanets().get(2));

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            //hide this current window (if this is whant you want
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You do not have enough fuel to travel there.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

    }

    @FXML
    private void goToGatechPlan(MouseEvent event) throws Exception {
        if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);
            player.setCurrentLocation(solar.getPlanets().get(0));

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            //hide this current window (if this is whant you want
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You do not have enough fuel to travel there.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

    }

    @FXML
    private void goToPoncePlan(MouseEvent event) throws Exception {
        if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);
            player.setCurrentLocation(solar.getPlanets().get(3));

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            //hide this current window (if this is whant you want
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You do not have enough fuel to travel there.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

    }

    @FXML
    private void returnToSolar(MouseEvent event) throws Exception {
        if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("UniverseScreen.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            //hide this current window (if this is whant you want
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You do not have enough fuel to travel there.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
    }

    @FXML
    private void saveGame(MouseEvent event) {
        GameInstance.saveModelBinary();
    }

    
}
