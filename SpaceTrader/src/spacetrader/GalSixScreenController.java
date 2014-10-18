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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author sydnipeterson
 */
public class GalSixScreenController implements Initializable {
    @FXML
    private Menu fuelTab;
    @FXML
    private ImageView FamCoHQPlan;
    @FXML
    private ImageView FamCoWarehousePlan;
    @FXML
    private ImageView FamCoSatteliteBranchPlan;
    @FXML
    private ImageView FamCoMoonBranchPlan;
    
    private Universe universe = GameInstance.getInstance().getUniverse();
    private Player player = GameInstance.getInstance().getPlayer();
    private Ship ship = GameInstance.getInstance().getPlayer().getShip();

    private SolarSystem solar = universe.get(5);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToFamCoHQPlan(MouseEvent event) throws Exception {
       if (ship.getFuel() >=0){
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
    private void goToFamCoWarehousePlan(MouseEvent event) throws Exception{
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
    private void goToFamCoSatteliteBranchPlan(MouseEvent event) throws Exception {
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
    private void goToFamCoMoonBranchPlan(MouseEvent event) throws Exception {
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
    private void returnToUniverse(MouseEvent event) throws Exception{
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
    
}
