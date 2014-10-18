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
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
public class PlanetScreenController implements Initializable {
    @FXML
    private Menu fuelTab;
    @FXML
    private Button stockButton;
    @FXML
    private Button marketButton;
    @FXML
    private Button personnelButton;
    private Player player = GameInstance.getInstance().getPlayer();
    private Ship ship = GameInstance.getInstance().getPlayer().getShip();
    private Planet planet = player.getCurrentLocation();
    @FXML
    private Button returnButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fuelTab.setText("Fuel: " + Integer.toString(ship.getFuel()) + "; " + planet.getName());
    }    

    @FXML
    private void goToStock(MouseEvent event) {
        //
    }

    @FXML
    private void goToMarket(MouseEvent event)  throws Exception {
        // Game game = GameInstance.getInstance();
        // game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
        // look at this ^^^
        Parent root = FXMLLoader.load(getClass().getResource("MarketScreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        //hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void goToPersonnel(MouseEvent event) {
        //
    }

    @FXML
    private void returnToSystem(MouseEvent event) throws Exception {
       if (ship.getFuel() >0){
            SolarSystem system = planet.getSolarSystem();
            ship.setFuel(ship.getFuel()-1);

            if (system.getName().equals("Atlantia")) {
                Parent root = FXMLLoader.load(getClass().getResource("GalOneScreen.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                //hide this current window (if this is whant you want
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (system.getName().equals("Bardic Kingdom")) {
                Parent root = FXMLLoader.load(getClass().getResource("GalTwoScreen.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                //hide this current window (if this is whant you want
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (system.getName().equals("Cyber Alliance")) {
                Parent root = FXMLLoader.load(getClass().getResource("GalThreeScreen.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                //hide this current window (if this is whant you want
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (system.getName().equals("Disney System")) {
                Parent root = FXMLLoader.load(getClass().getResource("GalFourScreen.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                //hide this current window (if this is whant you want
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (system.getName().equals("Engles Union")) {
                Parent root = FXMLLoader.load(getClass().getResource("GalFiveScreen.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                //hide this current window (if this is whant you want
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (system.getName().equals("FamCo Ltd")) {
                Parent root = FXMLLoader.load(getClass().getResource("GalSixScreen.fxml"));
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.show();

               //hide this current window (if this is whant you want
              ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (system.getName().equals("Golding Barrier Rim")) {
               Parent root = FXMLLoader.load(getClass().getResource("GalSevenScreen.fxml"));
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.show();

               //hide this current window (if this is whant you want
               ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (system.getName().equals("Hipee Settlements")) {
               Parent root = FXMLLoader.load(getClass().getResource("GalEightScreen.fxml"));
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.show();

             //hide this current window (if this is whant you want
             ((Node) (event.getSource())).getScene().getWindow().hide();
            } else if (system.getName().equals("iGalaxy")) {
               Parent root = FXMLLoader.load(getClass().getResource("GalNineScreen.fxml"));
               Stage stage = new Stage();
               stage.setScene(new Scene(root));
               stage.show();

               //hide this current window (if this is whant you want
               ((Node) (event.getSource())).getScene().getWindow().hide();
             }
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
