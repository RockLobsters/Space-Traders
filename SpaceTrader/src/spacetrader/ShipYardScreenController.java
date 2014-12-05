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
    @FXML
    private TextArea beetleText;
    @FXML
    private TextArea grasshopperText;
    @FXML
    private TextArea hornetText;

    private Player player = GameInstance.getInstance().getPlayer();
    private Ship ship = GameInstance.getInstance().getPlayer().getShip();
    private int techLevel = player.getCurrentLocation().getSolarSystem().getTechLevel();
    @FXML
    private TextArea termiteText;
    @FXML
    private TextArea waspText;
    private Shipyard yard = new Shipyard(player.getCurrentLocation());
    private Laser laserType;
    private Gadget gadgetType;
    private Shield shieldType;

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
    @FXML
    private Text money;
    @FXML
    private Text listWeapons;
    @FXML
    private Text listShield;
    @FXML
    private Text gadgetList;
    @FXML
    private Text escapePodBool;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shipName.setText("Current Ship: " + ship.getName());
        money.setText("Money: " + player.getMoney());
        escapePod.setText("Price: 200");
        setLaser();
        setGadget();
        setSheild();
        populateFields();
    }

    @FXML
    private void beetleOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Beetle()) + "\n";
        beetleText.setText(text);
    }

    @FXML
    private void buyBeetle(MouseEvent event) {
        if (techLevel >= 5) {
            int success = yard.buyShip(player, new Beetle(), false);

            if (success == 0) {
                Action response;
                response = Dialogs.create()
                        //.owner( isOwnerSelected() ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Beetle(), true);
                    shipName.setText("Current Ship: Beetle");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {

                shipName.setText("Current Ship: Beetle");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void buyGrasshopper(MouseEvent event) {
        if (techLevel >= 5) {
            int success = yard.buyShip(player, new Grasshopper(), false);

            if (success == 0) {
                Action response;
                response = Dialogs.create()
                        //.owner( isOwnerSelected() ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Grasshopper(), true);
                    shipName.setText("Current Ship: Grasshopper");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {

                shipName.setText("Current Ship: Grasshopper");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void buyHornet(MouseEvent event) {
         if (techLevel >= 5) {
            int success = yard.buyShip(player, new Hornet(), false);

            if (success == 0) {
                Action response;
                response = Dialogs.create()
                        //.owner( isOwnerSelected() ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Hornet(), true);
                    shipName.setText("Current Ship: Hornet");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {

                shipName.setText("Current Ship: Hornet");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void buyTermite(MouseEvent event) {
        if (techLevel >= 5) {
            int success = yard.buyShip(player, new Termite(), false);

            if (success == 0) {
                Action response;
                response = Dialogs.create()
                        //.owner( isOwnerSelected() ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Termite(), true);
                    shipName.setText("Current Ship: Termite");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {

                shipName.setText("Current Ship: Termite");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void buyWasp(MouseEvent event) {
        if (techLevel >= 5) {
            int success = yard.buyShip(player, new Wasp(), false);

            if (success == 0) {
                Action response;
                response = Dialogs.create()
                        //.owner( isOwnerSelected() ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Wasp(), true);
                    shipName.setText("Current Ship: Wasp");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {

                shipName.setText("Current Ship: Wasp");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void grasshopperOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Grasshopper()) + "\n";
        grasshopperText.setText(text);
    }

    @FXML
    private void hornetOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Hornet()) + "\n";
        hornetText.setText(text);
    }

    private void setLaser() {
        Laser[] allWeapons = Laser.values();
        ArrayList<Laser> weapons = Shipyard.visibleWeapons();
        for (Laser allWeapon : allWeapons) {
            switch (allWeapon) {
                case PULSE:
                    if (weapons.contains(laserType.PULSE)) {
                        pulseLasers.setText("Price: " + laserType.PULSE.getPrice());
                    }
                    else {
                        pulseLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case BEAM:
                    if (weapons.contains(laserType.BEAM)) {
                        beamLasers.setText("Price: " + laserType.BEAM.getPrice());
                    }
                    else {
                        beamLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case MILITARY:
                    if (weapons.contains(laserType.MILITARY)) {
                        militaryLasers.setText("Price: " + laserType.MILITARY.getPrice());
                    }
                    else {
                        militaryLasers.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
            }
        }
    }

    private void setSheild() {
        Shield[] allShields = Shield.values();
        ArrayList<Shield> shields = Shipyard.visibleShields();
        for (Shield allWeapon : allShields) {
            switch (allWeapon) {
                case ENERGY:
                    if (shields.contains(shieldType.ENERGY)) {
                        energyShield.setText("Price: " + shieldType.ENERGY.getPrice());
                    }
                    else {
                        energyShield.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case REFLECTIVE:
                    if (shields.contains(shieldType.REFLECTIVE)) {
                        reflectiveShield.setText("Price: " + shieldType.REFLECTIVE.getPrice());
                    }
                    else {
                        reflectiveShield.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
            }
        }
    }

    private void setGadget() {
        Gadget[] allGadgets = Gadget.values();
        ArrayList<Gadget> gadgets = Shipyard.visibleGadgets();
        for (Gadget allGadget : allGadgets) {
            switch (allGadget) {
                case CARGO_BAYS:
                    if (gadgets.contains(gadgetType.CARGO_BAYS)) {
                        cargoBays.setText("Price: " + gadgetType.CARGO_BAYS.getPrice());
                    }
                    else {
                        cargoBays.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case NAV_SYSTEM:
                    if (gadgets.contains(gadgetType.NAV_SYSTEM)) {
                        navigatingSystem.setText("Price: " + gadgetType.NAV_SYSTEM.getPrice());
                    }
                    else {
                        navigatingSystem.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case AUTO_REPAIR_SYSTEM:
                    if (gadgets.contains(gadgetType.AUTO_REPAIR_SYSTEM)) {
                        autoRepairSystem.setText("Price: " + gadgetType.AUTO_REPAIR_SYSTEM.getPrice());
                    }
                    else {
                        autoRepairSystem.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case TARGET_SYSTEM:
                    if (gadgets.contains(gadgetType.TARGET_SYSTEM)) {
                        targetingSystem.setText("Price: " + gadgetType.TARGET_SYSTEM.getPrice());
                    }
                    else {
                        targetingSystem.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
                case CLOAK_DEVICE:
                    if (gadgets.contains(gadgetType.CLOAK_DEVICE)) {
                        cloakingDevice.setText("Price: " + gadgetType.CLOAK_DEVICE.getPrice());
                    }
                    else {
                        cloakingDevice.setText("NOT SOLD IN THIS MARKET");
                    }
                    break;
            }
        }
    }

    /**
     * Returns player to planet screen
     *
     * @param event when mouse is clicked
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
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void buyFlea(MouseEvent event) {

        if (techLevel >= 4) {
            int success = yard.buyShip(player, new Flea(), false);

            if (success == 0) {
                Action response;
                response = Dialogs.create()
                        //.owner( isOwnerSelected() ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Flea(), true);
                    shipName.setText("Current Ship: Flea");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {

                shipName.setText("Current Ship: Flea");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

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
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void buyGnat(MouseEvent event) {
        if (techLevel >= 5) {
            int success = yard.buyShip(player, new Gnat(), false);

            if (success == 0) {
                Action response = Dialogs.create()
                        //.owner( isOwnerSelected ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Gnat(), true);
                    shipName.setText("Current Ship: Gnat");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                shipName.setText("Current Ship: Gnat");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

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
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void buyFirefly(MouseEvent event) {
        if (techLevel >= 5) {
            int success = yard.buyShip(player, new Firefly(), false);

            if (success == 0) {
                Action response = Dialogs.create()
                        //.owner( isOwnerSelected ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Firefly(), true);
                    shipName.setText("Current Ship: Firefly");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                shipName.setText("Current Ship: Firefly");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

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
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void buyMosquito(MouseEvent event) {
        if (techLevel >= 5) {
            int success = yard.buyShip(player, new Mosquito(), false);

            if (success == 0) {
                Action response = Dialogs.create()
                        //.owner( isOwnerSelected ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Mosquito(), true);
                    shipName.setText("Current Ship: Mosquito");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                shipName.setText("Current Ship: Mosquito");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

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
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void buyBumblebee(MouseEvent event) {
        if (techLevel >= 5) {
            int success = yard.buyShip(player, new Bumblebee(), false);

            if (success == 0) {
                Action response = Dialogs.create()
                        //.owner( isOwnerSelected ? stage : null)
                        .title("CARGO NOT ALLOWED")
                        //.masthead(isMastheadVisible() ? "Just Checkin'" : null)
                        .message("Some of your cargo cannot be sold here. Sell anyway?")
                        .showConfirm();

                if (response == Dialog.ACTION_YES) {
                    success = yard.buyShip(player, new Bumblebee(), true);
                    shipName.setText("Current Ship: Bumblebee");
                    money.setText("Money: " + player.getMoney());
                }
                else {
                    // ... user cancelled, reset form to default
                    return;
                }
            }
            if (success == -1) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot afford this.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
            if (success == 1) {
                shipName.setText("Current Ship: Bumblebee");
                money.setText("Money: " + player.getMoney());
            }
        }
        else {

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
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void fleaOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Flea()) + "\n";
        fleaText.setText(text);
    }

    /**
     * sets text to text area when opened
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void gnatOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Gnat()) + "\n";
        gnatText.setText(text);
    }

    /**
     * sets text to text area when opened
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void fireflyOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Firefly()) + "\n";
        fireflyText.setText(text);
    }

    /**
     * sets text to text area when opened
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void mosquitoOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Mosquito()) + "\n";
        mosquitoText.setText(text);
    }

    /**
     * sets text to text area when opened
     *
     * @param event when mouse is clicked
     */
    @FXML
    private void bumbleBeeOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Bumblebee()) + "\n";
        bumbleBeeText.setText(text);
    }

    @FXML
    private void buyPulseLasers(MouseEvent event) {
        int success = -2;
        if (!pulseLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyWeapon(player, laserType.PULSE);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough weapon space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();

    }

    @FXML
    private void buyBeamLasers(MouseEvent event) {
        int success = -2;
        if (!beamLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyWeapon(player, laserType.BEAM);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough weapon space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyMilitaryLasers(MouseEvent event) {
        int success = -2;
        if (!militaryLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyWeapon(player, laserType.MILITARY);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough weapon space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyEnergyShield(MouseEvent event) {
        int success = -2;
        if (!energyShield.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyDefense(player, shieldType.ENERGY);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough sheild space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyReflectiveShield(MouseEvent event) {
        int success = -2;
        if (!reflectiveShield.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyDefense(player, shieldType.REFLECTIVE);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough sheild space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyNavigatingSystem(MouseEvent event) {
        int success = -2;
        if (!navigatingSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyGadget(player, gadgetType.NAV_SYSTEM);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough gadget space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyAutoRepairSystem(MouseEvent event) {
        int success = -2;
        if (!autoRepairSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyGadget(player, gadgetType.AUTO_REPAIR_SYSTEM);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough gadget space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyCargoBays(MouseEvent event) {
        int success = -2;
        if (!cargoBays.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyGadget(player, gadgetType.CARGO_BAYS);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough gadget space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyTargetingSystem(MouseEvent event) {
        int success = -2;
        if (!targetingSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyGadget(player, gadgetType.TARGET_SYSTEM);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough gadget space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyCloakingDevice(MouseEvent event) {
        int success = -2;
        if (!cloakingDevice.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.buyGadget(player, gadgetType.CLOAK_DEVICE);
        }
        if (success == -2) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }

        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You do not have enough gadget space.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void buyEscapePod(MouseEvent event) {
        int success = yard.buyEscapePod(player);
        if (success == 1) {
            money.setText("Money: " + player.getMoney());
        }
        if (success == 0) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You already have an escape pod.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        if (success == -1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot afford this.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellPulseLasers(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!pulseLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellWeapon(player, "Pulse Laser");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellBeamLasers(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!beamLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellWeapon(player, "Beam Laser");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellEnergyShield(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!energyShield.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellShield(player, "Energy Shield");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellReflectiveShield(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!reflectiveShield.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellShield(player, "Reflective Shield");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellCargoBays(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!cargoBays.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellGadget(player, "5 Cargo Bays");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellNavigatingSystem(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!navigatingSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellGadget(player, "Navigation System");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellAutoRepairSystem(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!autoRepairSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellGadget(player, "Auto-Repair System");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellCloakingDevice(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!cloakingDevice.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellGadget(player, "Cloaking Device");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellEscapePod(MouseEvent event) {
        boolean success = yard.sellEscapePod(player);
        if (success) {
            money.setText("Money: " + player.getMoney());
        }
        if (!success) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot sell something you don't own.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellMilitaryLasers(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!militaryLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellWeapon(player, "Military Laser");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    @FXML
    private void sellTargetingSystem(MouseEvent event) {
        boolean success;
        int notInMarket = 1;
        if (!targetingSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
            success = yard.sellGadget(player, "Targeting System");
            notInMarket = 0;
            if (success) {
                money.setText("Money: " + player.getMoney());
            }
            if (!success) {
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("You cannot sell something you don't own.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            }
        }
        if (notInMarket == 1) {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("NOT SOLD IN THIS MARKET")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();
        }
        populateFields();
    }

    private void populateFields() {
        String weapons = "";
        String shields = "";
        String gadgets = "";
        String escapePod = "";
        Ship ship = GameInstance.getInstance().getPlayer().getShip();
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
    }

    @FXML
    private void termiteOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Termite()) + "\n";
        termiteText.setText(text);
    }

    @FXML
    private void waspOpen(MouseEvent event) {
        String text = "Price:" + yard.shipPrice(player, new Wasp()) + "\n";
        waspText.setText(text);
    }

}
