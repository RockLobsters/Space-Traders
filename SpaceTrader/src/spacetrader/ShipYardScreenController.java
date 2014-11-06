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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.input.ContextMenuEvent;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;


/**
 * FXML Controller class
 *
 * @author jackie
 */
public class ShipYardScreenController implements Initializable {
    
    private Player player = GameInstance.getInstance().getPlayer();
    private Ship ship = GameInstance.getInstance().getPlayer().getShip();
    private int techLevel = player.getCurrentLocation().getSolarSystem().getTechLevel();
    private Shipyard yard = new Shipyard(player.getCurrentLocation());
    private Laser laserType;
    private Gadget gadgetType;
    private Shield sheildType;

    @FXML
    private Text shipName;
    @FXML
    private TextArea fleaText;
    @FXML
    private TextArea gnatText;
    @FXML
    private TextArea fireflyText;
    @FXML
    private TextArea mosquitoText;
    @FXML
    private TextArea bumbleBeeText;
    @FXML
    private Text pulseLasers;
    @FXML
    private Text beamLasers;
    @FXML
    private Text energyShield;
    @FXML
    private Text reflectiveShield;
    @FXML
    private Text cargoBays;
    @FXML
    private Text navigatingSystem;
    @FXML
    private Text autoRepairSystem;
    @FXML
    private Text targetingSystem;
    @FXML
    private Text cloakingDevice;
    @FXML
    private Text escapePod;
    @FXML
    private Text militaryLasers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shipName.setText("Current Ship: " + ship.getName() + "    Money: " + player.getMoney());
        setLaser();
        
    } 
    
    private void setLaser(){
        Laser[] allWeapons = Laser.values();
        ArrayList<Laser> weapons = Shipyard.visibleWeapons();
        for (Laser allWeapon : allWeapons) {
            switch (allWeapon) {
                case PULSE:
                    if(weapons.contains(laserType.PULSE)){
                        pulseLasers.setText("Price: " + laserType.PULSE.getPrice());
                    } else {
                        pulseLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case BEAM:
                    if(weapons.contains(laserType.BEAM)){
                        beamLasers.setText("Price: " + laserType.BEAM.getPrice());
                    } else {
                        beamLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case MILITARY:
                    if(weapons.contains(laserType.MILITARY)){
                        militaryLasers.setText("Price: " + laserType.MILITARY.getPrice());
                    } else {
                        militaryLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
            }
        }
    }
    
    private void setGadget(){
        Gadget[] allGadgets = Gadget.values();
        ArrayList<Gadget> weapons = Shipyard.visibleGadgets();
        for (Gadget allGadget : allGadgets) {
            switch (allGadget) {
                case CARGO_BAYS:
                    if(weapons.contains(laserType.PULSE)){
                        pulseLasers.setText("Price: " + laserType.PULSE.getPrice());
                    } else {
                        pulseLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case NAV_SYSTEM:
                    if(weapons.contains(laserType.BEAM)){
                        beamLasers.setText("Price: " + laserType.BEAM.getPrice());
                    } else {
                        beamLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case AUTO_REPAIR_SYSTEM:
                    if(weapons.contains(laserType.MILITARY)){
                        militaryLasers.setText("Price: " + laserType.MILITARY.getPrice());
                    } else {
                        militaryLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
            }
        }
    }
    /**
    * Returns player to planet screen
    * @param  event     when mouse is clicked
    */
    @FXML
    private void returnToPlanet(MouseEvent event) throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        //hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    /**
    * Buys a flea ship.
    * @param  event     when mouse is clicked
    */
    @FXML
    private void buyFlea(MouseEvent event) {

        if (techLevel >= 4){
            int success = yard.buyShip(player, new Flea(), false);

            if (success == 0) {
                Action response;
                response = Dialogs.create()
                        //.owner( isOwnerSelected() ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message( "Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                    if (response == Dialog.ACTION_YES) {
                        success = yard.buyShip(player, new Flea(), true);
                        shipName.setText("Current Ship: Flea" + "   Money: " + player.getMoney());
                    } else {
                    // ... user cancelled, reset form to default
                        return;
                    }
            }
            if (success == -1 ){
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                
                shipName.setText("Current Ship: Flea" + "   Money: " + player.getMoney());
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    /**
    * Buys a gnat ship
    * @param  event     when mouse is clicked
    */
    @FXML
    private void buyGnat(MouseEvent event) {
        if (techLevel >= 5){
            int success = yard.buyShip(player, new Gnat(), false);

            if (success == 0) {
                Action response = Dialogs.create()
                    //.owner( isOwnerSelected ? stage : null)
                    .title("CARGO NOT ALLOWED")
                    //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                    .message( "Some of your cargo cannot be sold here. Sell anyway?")
                    .showConfirm();

                    if (response == Dialog.ACTION_YES) {
                        success = yard.buyShip(player, new Gnat(), true);
                        shipName.setText("Current Ship: Gnat" + "   Money: " + player.getMoney());
                    } else {
                    // ... user cancelled, reset form to default
                        return;
                    }
            }
            if (success == -1 ){
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                shipName.setText("Current Ship: Gnat" + "   Money: " + player.getMoney());
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    /**
    * Buys a firefly ship.
    * @param  event     when mouse is clicked
    */
    @FXML
    private void buyFirefly(MouseEvent event) {
        if (techLevel >= 5){
            int success = yard.buyShip(player, new Firefly(), false);

            if (success == 0) {
                Action response = Dialogs.create()
                    //.owner( isOwnerSelected ? stage : null)
                    .title("CARGO NOT ALLOWED")
                    //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                    .message( "Some of your cargo cannot be sold here. Sell anyway?")
                    .showConfirm();

                    if (response == Dialog.ACTION_YES) {
                        success = yard.buyShip(player, new Firefly(), true);
                        shipName.setText("Current Ship: Firefly" + "    Money: " + player.getMoney());
                    } else {
                    // ... user cancelled, reset form to default
                        return;
                    }
            }
            if (success == -1 ){
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                shipName.setText("Current Ship: Firefly" + "    Money: " + player.getMoney());
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    /**
    * Buys a mosquito ship.
    * @param  event     when mouse is clicked
    */
    @FXML
    private void buyMosquito(MouseEvent event) {
        if (techLevel >= 5){
            int success = yard.buyShip(player, new Mosquito(), false);

            if (success == 0) {
                Action response = Dialogs.create()
                    //.owner( isOwnerSelected ? stage : null)
                    .title("CARGO NOT ALLOWED")
                    //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                    .message( "Some of your cargo cannot be sold here. Sell anyway?")
                    .showConfirm();

                    if (response == Dialog.ACTION_YES) {
                        success = yard.buyShip(player, new Mosquito(), true);
                        shipName.setText("Current Ship: Mosquito" + "   Money: " + player.getMoney());
                    } else {
                    // ... user cancelled, reset form to default
                        return;
                    }
            }
            if (success == -1 ){
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                shipName.setText("Current Ship: Mosquito" + "   Money: " + player.getMoney());
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    /**
    * Buys a bumblebee ship.
    * @param  event     when mouse is clicked
    */
    @FXML
    private void buyBumblebee(MouseEvent event) {
        if (techLevel >= 5){
            int success = yard.buyShip(player, new Bumblebee(), false);

            if (success == 0) {
                Action response = Dialogs.create()
                    //.owner( isOwnerSelected ? stage : null)
                    .title("CARGO NOT ALLOWED")
                    //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                    .message( "Some of your cargo cannot be sold here. Sell anyway?")
                    .showConfirm();

                    if (response == Dialog.ACTION_YES) {
                        success = yard.buyShip(player, new Bumblebee(), true);
                        shipName.setText("Current Ship: Bumblebee" + "  Money: " + player.getMoney());
                    } else {
                    // ... user cancelled, reset form to default
                        return;
                    }
            }
            if (success == -1 ){
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                shipName.setText("Current Ship: Bumblebee" + "  Money: " + player.getMoney());
            }
        } else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }


    /**
    * sets text to text area when opened
    * @param  event     when mouse is clicked
    */
    @FXML
    private void fleaOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Flea())+ "\n";
        fleaText.setText(text);
    }

    /**
    * sets text to text area when opened
    * @param  event     when mouse is clicked
    */
    @FXML
    private void gnatOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Gnat())+ "\n";
        gnatText.setText(text);
    }

    /**
    * sets text to text area when opened
    * @param  event     when mouse is clicked
    */
    @FXML
    private void fireflyOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Firefly())+ "\n";
        fireflyText.setText(text);
    }

    /**
    * sets text to text area when opened
    * @param  event     when mouse is clicked
    */
    @FXML
    private void mosquitoOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Mosquito())+ "\n";
        mosquitoText.setText(text);
    }

    /**
    * sets text to text area when opened
    * @param  event     when mouse is clicked
    */
    @FXML
    private void bumbleBeeOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Bumblebee())+ "\n";
        bumbleBeeText.setText(text);
    }

    @FXML
    private void buyPulseLasers(MouseEvent event) {
    }

    @FXML
    private void buyBeamLasers(MouseEvent event) {
    }

    @FXML
    private void buyMilitaryLasers(MouseEvent event) {
    }

    @FXML
    private void weaponsInfo(MouseEvent event) {
    }

    @FXML
    private void buyEnergyShield(MouseEvent event) {
    }

    @FXML
    private void buyReflectiveShield(MouseEvent event) {
    }

    @FXML
    private void shieldsInfo(MouseEvent event) {
    }

    @FXML
    private void buyNavigatingSystem(MouseEvent event) {
    }

    @FXML
    private void buyAutoRepairSystem(MouseEvent event) {
    }

    @FXML
    private void buyCargoBays(MouseEvent event) {
    }

    @FXML
    private void buyTargetingSystem(ContextMenuEvent event) {
    }

    @FXML
    private void buyCloakingDevice(MouseEvent event) {
    }

    @FXML
    private void gadgetsInfo(MouseEvent event) {
    }

    @FXML
    private void buyEscapePod(MouseEvent event) {
    }

    @FXML
    private void escapePodInfo(MouseEvent event) {
    }

    @FXML
    private void sellPulseLasers(MouseEvent event) {
    }

    @FXML
    private void sellBeamLasers(MouseEvent event) {
    }

    @FXML
    private void sellMilitaryLasers(MouseEvent event) {
    }

    @FXML
    private void sellEnergyShield(MouseEvent event) {
    }

    @FXML
    private void sellReflectiveShield(MouseEvent event) {
    }

    @FXML
    private void sellCargoBays(MouseEvent event) {
    }

    @FXML
    private void sellNavigatingSystem(MouseEvent event) {
    }

    @FXML
    private void sellAutoRepairSystem(MouseEvent event) {
    }

    @FXML
    private void sellTargetingSystem(ContextMenuEvent event) {
    }

    @FXML
    private void sellCloakingDevice(MouseEvent event) {
    }
    
}
