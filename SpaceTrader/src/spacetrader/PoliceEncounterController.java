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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

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
public class PoliceEncounterController implements Initializable {
    @FXML
    private Button bribeButton;


    private Player player = GameInstance.getInstance().getPlayer();
    private Planet planet = player.getCurrentLocation();
    RandomEncounter policeEncounter = new RandomEncounter(player, planet.getSolarSystem(), "Police");
    NonPlayer np = policeEncounter.getNonPlayer();
    Ship ship = GameInstance.getInstance().getPlayer().getShip();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!policeEncounter.bribable()) {
            bribeButton.setVisible(false);
        }
    }    

    @FXML
    private void bribeClicked(MouseEvent event) throws Exception {
       policeEncounter.Bribe();
            Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            //hide this current window (if this is whant you want
            ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void checkClicked(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        //hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
        
        boolean found = false;
        ArrayList<Good> playerCargo = ship.getCargo();
        Good narcotic = null;
        for (int i = 0; i < playerCargo.size() && !found; i++) {
                if (playerCargo.get(i).getType() == GoodType.NARCOTICS) {
                    narcotic = playerCargo.get(i);
                    found = true;
                }
            }
        if(found = true && narcotic != null){
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You had Narcotics on your ship. Police took them and fined you $600.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
            player.subtractMoney(600);
            playerCargo.remove(narcotic);
            ship.adjustCargo(playerCargo);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You had nothing on you. Police let you go.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
    }

    @FXML
    private void fleeClicked(MouseEvent event) throws Exception {
        String fleed = policeEncounter.Flee();
        if (fleed.equals("Flee successful")) {
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
                    children(new Text("Flee unsuccessful.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
    }
    
}
