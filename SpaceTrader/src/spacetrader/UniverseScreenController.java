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

import java.util.Random;


/**
 * FXML Controller class
 *
 * @author sydnipeterson
 */
public class UniverseScreenController implements Initializable {
    @FXML
    private BorderPane MenuButton;
    @FXML
    private ImageView gal1;
    @FXML
    private ImageView gal4;
    @FXML
    private ImageView gal7;
    @FXML
    private ImageView gal5;
    @FXML
    private ImageView gal2;
    @FXML
    private ImageView gal8;
    @FXML
    private ImageView gal3;
    @FXML
    private ImageView gal6;
    @FXML
    private ImageView gal0;
    @FXML
    private Menu fuelTab;
    private Player player = GameInstance.getInstance().getPlayer();
    private Ship ship = GameInstance.getInstance().getPlayer().getShip();
    private Universe universe = GameInstance.getInstance().getUniverse();
    private Game game = GameInstance.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game.setCurrentScreen("UniverseScreen.fxml");
        // TODO
        String s = randEvent();
        // TODO
        fuelTab.setText("Fuel: " + ship.getFuel() + ". " + s);
    }    

    @FXML
    private void ReturnMainMenu(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RootWindow.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        //hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        }

    @FXML
    private void goToGal1(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalOneScreen.fxml"));
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
    private void goToGal4(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalFourScreen.fxml"));
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
    private void goToGal7(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalSevenScreen.fxml"));
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
    private void goToGal5(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalFiveScreen.fxml"));
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
    private void goToGal2(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalTwoScreen.fxml"));
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
    private void goToGal8(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalEightScreen.fxml"));
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
    private void goToGal3(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalThreeScreen.fxml"));
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
    private void goToGal6(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalSixScreen.fxml"));
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
    private void goToGal0(MouseEvent event) throws Exception {
         if (ship.getFuel() >0){
            ship.setFuel(ship.getFuel()-1);

            //Game game = GameInstance.getInstance();
            //game.getPlayer().setCurrentLocation(game.getUniverse().get(0).getPlanets().get(0));
            // look at this ^^^
            Parent root = FXMLLoader.load(getClass().getResource("GalNineScreen.fxml"));
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

        private String randEvent() {
        Random rand = new Random();
        int x = rand.nextInt(20);

        String string = "";
        
        if (x > 15) {
            
            if(x == 16){
                string = "You found $10!";
                player.addMoney(100);
            } else if (x == 15) {
                string = "Your fuel tank has a hole in it and some spilled out!";
                ship.setFuel(ship.getFuel() - 1);
            } else if (x == 17) {
                string = "Pirates raided your ship and took $50!";
                player.subtractMoney(50);
            } else if (x==18) {
                player.setWantedLevel(player.getWantedLevel() + 1);
                string = "You accidentally did something illegal. Wanted level: " + player.getWantedLevel();
            } else if (x==19) {
                player.addMoney(100);
                string = "You found a valueable stone and sold it for $100!";
            } else if (x==20) {
                ship.setFuel(ship.getFuel() + 1);
                string = "You found some fuel!";
            }

            //return string;
        
            // Stage dialogStage = new Stage();
            // dialogStage.initModality(Modality.WINDOW_MODAL);
            // dialogStage.setScene(new Scene(VBoxBuilder.create().
            // children(new Text(string)).
            // alignment(Pos.CENTER).padding(new Insets(30)).build()));
            // dialogStage.show();

            // try {
            //     Thread.sleep(2000);                 //1000 milliseconds is one second.
            // } catch(InterruptedException ex) {
            //     Thread.currentThread().interrupt();
            // }
        }
        return string;
    }

    @FXML
    private void saveGame(MouseEvent event) {
    }

    
}
