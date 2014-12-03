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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sydnipeterson
 */
public class PirateScreenController implements Initializable {
    @FXML
    private Button attackButton;
    @FXML
    private Text battleText;
    @FXML
    private Text escapePodBool;
    @FXML
    private Button fleeButton;
    @FXML
    private Text gadgetList;
    @FXML
    private Text listShield;
    @FXML
    private Text listWeapons;
    @FXML
    private ProgressBar pirateHealthBar;
    @FXML
    private ProgressBar playerHealthBar;
    @FXML
    private Text playerHealthNum;
    @FXML
    private Text priateHealthNum;
    private Player player = GameInstance.getInstance().getPlayer();
    private Planet planet = player.getCurrentLocation();
    RandomEncounter pirateEncounter = new RandomEncounter(player, planet.getSolarSystem(), "Pirate");
    NonPlayer np = pirateEncounter.getNonPlayer();
    Ship ship = GameInstance.getInstance().getPlayer().getShip();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String weapons = "";
        String shields = "";
        String gadgets = "";
        String escapePod = "";
        
        for (Laser x : ship.weapons) {
            weapons = weapons + x.name + "\n";
        }
        for (Shield x : ship.shields) {
            shields = shields + x.name + "\n";
        }
        for (Gadget x : ship.gadgets) {
            gadgets = gadgets + x.name + "\n";
        }
        if (ship.getEscapePod()) {
            escapePod = "Owned";
        }
        else {
            escapePod = "Not owned";
        }
        listWeapons.setText(weapons);
        listShield.setText(shields);
        gadgetList.setText(gadgets);
        escapePodBool.setText(escapePod);
        priateHealthNum.setText(""+ np.ship().getHealth());
        playerHealthNum.setText("" + ship.getHealth());
    }    

    @FXML
    private void attackPirate(MouseEvent event) throws Exception {
        if((np.ship().getHealth() != 0) && (ship.getHealth() != 0)){
            pirateEncounter.Battle();
            priateHealthNum.setText(""+ np.ship().getHealth());
            playerHealthNum.setText("" + ship.getHealth());
            pirateHealthBar.setProgress((np.ship().getHealth())/np.ship.getHullStrength());
            playerHealthBar.setProgress(ship.getHealth()/ship.getHullStrength());
        } else {
            int result = pirateEncounter.battleOver();
            if(result == 1){
                battleText.setText("You Won!");
            }
            if(result == 0){
                battleText.setText("You Escaped in your Escape Pod!");
            }
            if(result == -1){
                battleText.setText("You Died. Game Over.");
            }
            changeScreen(result);
        }
    }

    @FXML
    private void fleePirate(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    private void changeScreen(int result)throws Exception {
        int counter = 0;
        while(counter <= 50){
            if(counter == 50){
                if(result == 1 || result == 0){
                    Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
                if(result == -1){
                    Parent root = FXMLLoader.load(getClass().getResource("RootWindow.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            }
        }
    }
}
