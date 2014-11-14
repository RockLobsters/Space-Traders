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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class.
 *
 * @author jackie
 */
public class ShipYardScreenController implements Initializable {
    /**
     * Player.
     */
    private static final transient
            Player PLAYER = GameInstance.getInstance().getPlayer();
    /**
     * Player's Ship.
     */
    private static final transient
            Ship SHIP = GameInstance.getInstance().getPlayer().getShip();
    /**
     * tech level.
     */
    private static final transient int
            TECHLEVEL = PLAYER.getCurrentLocation().getSolarSystem()
	    .getTechLevel();
    /**
     * Shipyard.
     */
    private static final transient 
            Shipyard YARD = new Shipyard(PLAYER.getCurrentLocation());
    /**
     * laserTypes.
     */
    private transient Laser laserType;
    /**
     * gadetTypes.
     */
    private transient Gadget gadgetType;
    /**
     * shieldTypes.
     */
    private transient Shield shieldType;
    /**
     *
     */
    @FXML
    private static transient Text shipName;
    /**
     *
     */
    @FXML
    private static transient TextArea fleaText;
    /**
     *
     */
    @FXML
    private static transient TextArea gnatText;
    /**
     *
     */
    @FXML
    private static transient TextArea fireflyText;
    /**
     *
     */
    @FXML
    private static transient TextArea mosquitoText;
    /**
     *
     */
    @FXML
    private static transient TextArea bumbleBeeText;
    /**
     *
     */
    @FXML
    private static transient Text pulseLasers;
    /**
     *
     */
    @FXML
    private static transient Text beamLasers;
    /**
     *
     */
    @FXML
    private static transient Text energyShield;
    /**
     *
     */
    @FXML
    private static transient Text reflectiveShield;
    /**
     *
     */
    @FXML
    private static transient Text cargoBays;
     /**
     *
     */
    @FXML
    private static transient Text navigatingSystem;
     /**
     *
     */
    @FXML
    private static transient Text autoRepairSystem;
     /**
     *
     */
    @FXML
    private static transient Text targetingSystem;
     /**
     *
     */
    @FXML
    private static transient Text cloakingDevice;
     /**
     *
     */
    @FXML
    private static transient Text escapePod;
     /**
     *
     */
    @FXML
    private static transient Text militaryLasers;
     /**
     *
     */
    @FXML
    private static transient Text money;
     /**
     *
     */
    @FXML
    private static transient Text listWeapons;
     /**
     *
     */
    @FXML
    private static transient Text listShield;
     /**
     *
     */
    @FXML
    private static transient Text gadgetList;
     /**
     *
     */
    @FXML
    private static transient Text escapePodBool;
     /**
     *
     */
    @FXML
    private static transient Text fuelPrice;
     /**
     *
     */
    @FXML
    private static transient TextField fuelQuantity;
    /**
     *
     */
    private static final transient int PADDING = 30;

    /**
     * Initialize controller.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
	shipName.setText("Current Ship: " + SHIP.getName());
	money.setText("Money: " + PLAYER.getMoney());
	escapePod.setText("Price: 200");
	setLaser();
	setGadget();
	setShield();
	populateFields();
    }
    /**
     * Sets visible weapons.
     */
    private void setLaser() {
	final Laser[] allWeapons = Laser.values();
	final ArrayList<Laser> weapons = Shipyard.visibleWeapons();
	for (Laser allWeapon : allWeapons) {
	    switch (allWeapon) {
	    case PULSE:
		if (weapons.contains(laserType.PULSE)) {
		    pulseLasers.setText("Price: " + laserType.PULSE.getPrice());
		} else {
		    pulseLasers.setText("NOT SOLD IN THIS MARKET");
		}
		break;
	    case BEAM:
		if (weapons.contains(laserType.BEAM)) {
		    beamLasers.setText("Price: " + laserType.BEAM.getPrice());
		} else {
		    beamLasers.setText("NOT SOLD IN THIS MARKET");
		}
		break;
	    case MILITARY:
		if (weapons.contains(laserType.MILITARY)) {
		    militaryLasers.setText("Price: "
			    + laserType.MILITARY.getPrice());
		} else {
		    militaryLasers.setText("NOT SOLD IN THIS MARKET");
		}
		break;
        default:
        throw new AssertionError(allWeapon.name());
	    }
	}
    }
    /**
     * Sets visible Shields.
     */
    private void setShield() {
	final Shield[] allShields = Shield.values();
	final ArrayList<Shield> shields = Shipyard.visibleShields();
	for (Shield allWeapon : allShields) {
	    switch (allWeapon) {
	    case ENERGY:
		if (shields.contains(shieldType.ENERGY)) {
		    energyShield.setText("Price: "
			    + shieldType.ENERGY.getPrice());
		} else {
		    energyShield.setText("NOT SOLD IN THIS MARKET");
		}
		break;
	    case REFLECTIVE:
		if (shields.contains(shieldType.REFLECTIVE)) {
		    reflectiveShield.setText("Price: "
			    + shieldType.REFLECTIVE.getPrice());
		} else {
		    reflectiveShield.setText("NOT SOLD IN THIS MARKET");
		}
		break;

        default:
        throw new AssertionError(allWeapon.name());

	    }
	}
    }
    /**
     * Sets visible gadgets.
     */
    private void setGadget() {
	final Gadget[] allGadgets = Gadget.values();
	final ArrayList<Gadget> gadgets = Shipyard.visibleGadgets();
	for (Gadget allGadget : allGadgets) {
	    switch (allGadget) {
	    case CARGO_BAYS:
		if (gadgets.contains(gadgetType.CARGO_BAYS)) {
		    cargoBays.setText("Price: "
			    + gadgetType.CARGO_BAYS.getPrice());
		} else {
		    cargoBays.setText("NOT SOLD IN THIS MARKET");
		}
		break;
	    case NAV_SYSTEM:
		if (gadgets.contains(gadgetType.NAV_SYSTEM)) {
		    navigatingSystem.setText("Price: "
			    + gadgetType.NAV_SYSTEM.getPrice());
		} else {
		    navigatingSystem.setText("NOT SOLD IN THIS MARKET");
		}
		break;
	    case AUTO_REPAIR_SYSTEM:
		if (gadgets.contains(gadgetType.AUTO_REPAIR_SYSTEM)) {
		    autoRepairSystem.setText("Price: "
			    + gadgetType.AUTO_REPAIR_SYSTEM.getPrice());
		} else {
		    autoRepairSystem.setText("NOT SOLD IN THIS MARKET");
		}
		break;
	    case TARGET_SYSTEM:
		if (gadgets.contains(gadgetType.TARGET_SYSTEM)) {
		    targetingSystem.setText("Price: "
			    + gadgetType.TARGET_SYSTEM.getPrice());
		} else {
		    targetingSystem.setText("NOT SOLD IN THIS MARKET");
		}
		break;
	    case CLOAK_DEVICE:
		if (gadgets.contains(gadgetType.CLOAK_DEVICE)) {
		    cloakingDevice.setText("Price: "
			    + gadgetType.CLOAK_DEVICE.getPrice());
		} else {
		    cloakingDevice.setText("NOT SOLD IN THIS MARKET");
		}
		break;
        default:
        throw new AssertionError(allGadget.name());
	    }
	}
    }

    /**
     * Returns player to planet screen.
     *
     * @param event
     *            when mouse is clicked
     * @throws Exception
     */
    @FXML
    private void returnToPlanet(final MouseEvent event) throws Exception {
	final Parent root = FXMLLoader.load(getClass().getResource(
		"PlanetScreen.fxml"));
	final Stage stage = new Stage();
	stage.setScene(new Scene(root));
	stage.show();

	// hide this current window (if this is whant you want
	((Node) (event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Buys a flea ship.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void buyFlea(final MouseEvent event) {

	if (TECHLEVEL >= 2 + 2) {
	    final int success = YARD.buyShip(PLAYER, new Flea(), false);

	    if (success == -1) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(VBoxBuilder.create()
				.children(new Text("You cannot afford this."))
				.alignment(Pos.CENTER)
                                .padding(new Insets(PADDING))
				.build()));
		dialogStage.show();
	    }
	    if (success == 1) {

		shipName.setText("Current Ship: Flea");
		money.setText("Money: " + PLAYER.getMoney());
	    }
	} else {

	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot buy this here."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();

	}
    }

    /**
     * Buys a gnat ship.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void buyGnat(final MouseEvent event) {
	if (TECHLEVEL >= 2 + 2 + 1) {
	    final int success = YARD.buyShip(PLAYER, new Gnat(), false);

	    if (success == -1) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(VBoxBuilder.create()
				.children(new Text("You cannot afford this."))
				.alignment(Pos.CENTER).
                                padding(new Insets(PADDING))
				.build()));
		dialogStage.show();
	    }
	    if (success == 1) {
		shipName.setText("Current Ship: Gnat");
		money.setText("Money: " + PLAYER.getMoney());
	    }
	} else {

	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot buy this here."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();

	}
    }

    /**
     * Buys a firefly ship.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void buyFirefly(final MouseEvent event) {
	if (TECHLEVEL >= 2 + 2 + 1) {
	    final int success = YARD.buyShip(PLAYER, new Firefly(), false);

	    if (success == -1) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(VBoxBuilder.create()
				.children(new Text("You cannot afford this."))
				.alignment(Pos.CENTER)
                                .padding(new Insets(PADDING))
				.build()));
		dialogStage.show();
	    }
	    if (success == 1) {
		shipName.setText("Current Ship: Firefly");
		money.setText("Money: " + PLAYER.getMoney());
	    }
	} else {

	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot buy this here."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();

	}
    }

    /**
     * Buys a mosquito ship.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void buyMosquito(final MouseEvent event) {
	if (TECHLEVEL >= 2 + 2 + 1) {
	    final int success = YARD.buyShip(PLAYER, new Mosquito(), false);

	    
	    if (success == -1) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(VBoxBuilder.create()
				.children(new Text("You cannot afford this."))
				.alignment(Pos.CENTER)
                                .padding(new Insets(PADDING))
				.build()));
		dialogStage.show();
	    }
	    if (success == 1) {
		shipName.setText("Current Ship: Mosquito");
		money.setText("Money: " + PLAYER.getMoney());
	    }
	} else {

	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot buy this here."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();

	}
    }

    /**
     * Buys a bumblebee ship.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void buyBumblebee(final MouseEvent event) {
	if (TECHLEVEL >= 2 + 2 + 1) {
	    final int success = YARD.buyShip(PLAYER, new Bumblebee(), false);

	    if (success == -1) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(VBoxBuilder.create()
				.children(new Text("You cannot afford this."))
				.alignment(Pos.CENTER)
                                .padding(new Insets(PADDING))
				.build()));
		dialogStage.show();
	    }
	    if (success == 1) {
		shipName.setText("Current Ship: Bumblebee");
		money.setText("Money: " + PLAYER.getMoney());
	    }
	} else {

	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot buy this here."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();

	}
    }

    /**
     * sets text to text area when opened.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void fleaOpen(final MouseEvent event) {
	final String text = "Price:"
                + YARD.shipPrice(PLAYER, new Flea()) + "\n";
	fleaText.setText(text);
    }

    /**
     * sets text to text area when opened.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void gnatOpen(final MouseEvent event) {
	final String text = "Price:"
                + YARD.shipPrice(PLAYER, new Gnat()) + "\n";
	gnatText.setText(text);
    }

    /**
     * sets text to text area when opened.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void fireflyOpen(final MouseEvent event) {
	final String text = "Price:"
                + YARD.shipPrice(PLAYER, new Firefly()) + "\n";
	fireflyText.setText(text);
    }

    /**
     * sets text to text area when opened.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void mosquitoOpen(final MouseEvent event) {
	final String text = "Price:"
                + YARD.shipPrice(PLAYER, new Mosquito()) + "\n";
	mosquitoText.setText(text);
    }

    /**
     * sets text to text area when opened.
     *
     * @param event
     *            when mouse is clicked
     */
    @FXML
    private void bumbleBeeOpen(final MouseEvent event) {
	final String text = "Price:"
                + YARD.shipPrice(PLAYER, new Bumblebee()) + "\n";
	bumbleBeeText.setText(text);
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyPulseLasers(final MouseEvent event) {
	int success = -1 - 1;
	if (!pulseLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyWeapon(PLAYER, laserType.PULSE);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough weapon space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();

    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyBeamLasers(final MouseEvent event) {
	int success = -1 - 1;
	if (!beamLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyWeapon(PLAYER, laserType.BEAM);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough weapon space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyMilitaryLasers(final MouseEvent event) {
	int success = -1 - 1;
	if (!militaryLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyWeapon(PLAYER, laserType.MILITARY);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough weapon space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyEnergyShield(final MouseEvent event) {
	int success = -1 - 1;
	if (!energyShield.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyDefense(PLAYER, shieldType.ENERGY);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}

	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough sheild space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyReflectiveShield(final MouseEvent event) {
	int success = -1 - 1;
	if (!reflectiveShield.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyDefense(PLAYER, shieldType.REFLECTIVE);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}

	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough sheild space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyNavigatingSystem(final MouseEvent event) {
	int success = -1 - 1;
	if (!navigatingSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyGadget(PLAYER, gadgetType.NAV_SYSTEM);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough gadget space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyAutoRepairSystem(final MouseEvent event) {
	int success = -1 - 1;
	if (!autoRepairSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyGadget(PLAYER, gadgetType.AUTO_REPAIR_SYSTEM);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough gadget space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyCargoBays(final MouseEvent event) {
	int success = -1 - 1;
	if (!cargoBays.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyGadget(PLAYER, gadgetType.CARGO_BAYS);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}

	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough gadget space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER).
                    padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyTargetingSystem(final MouseEvent event) {
	int success = -1 - 1;
	if (!targetingSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyGadget(PLAYER, gadgetType.TARGET_SYSTEM);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}

	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough gadget space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyCloakingDevice(final MouseEvent event) {
	int success = -1 - 1;
	if (!cloakingDevice.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.buyGadget(PLAYER, gadgetType.CLOAK_DEVICE);
	}
	if (success == -1 - 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}

	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You do not have enough gadget space."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void buyEscapePod(final MouseEvent event) {
	final int success = YARD.buyEscapePod(PLAYER);
	if (success == 1) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (success == 0) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You already have an escape pod."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	if (success == -1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("You cannot afford this."))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellPulseLasers(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!pulseLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellWeapon(PLAYER, "Pulse Laser");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellBeamLasers(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!beamLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellWeapon(PLAYER, "Beam Laser");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellEnergyShield(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!energyShield.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellShield(PLAYER, "Energy Shield");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellReflectiveShield(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!reflectiveShield.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellShield(PLAYER, "Reflective Shield");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellCargoBays(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!cargoBays.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellGadget(PLAYER, "5 Cargo Bays");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellNavigatingSystem(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!navigatingSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellGadget(PLAYER, "Navigation System");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellAutoRepairSystem(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!autoRepairSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellGadget(PLAYER, "Auto-Repair System");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellCloakingDevice(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!cloakingDevice.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellGadget(PLAYER, "Cloaking Device");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellEscapePod(final MouseEvent event) {
	final boolean success = YARD.sellEscapePod(PLAYER);
	if (success) {
	    money.setText("Money: " + PLAYER.getMoney());
	}
	if (!success) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage
		    .setScene(new Scene(
			    VBoxBuilder
				    .create()
				    .children(
					    new Text(
			"You cannot sell something you don't own."))
				    .alignment(Pos.CENTER)
				    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellMilitaryLasers(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!militaryLasers.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellWeapon(PLAYER, "Military Laser");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     *
     * @param event
     */
    @FXML
    private void sellTargetingSystem(final MouseEvent event) {
	boolean success;
	int notInMarket = 1;
	if (!targetingSystem.getText().contains("NOT SOLD IN THIS MARKET")) {
	    success = YARD.sellGadget(PLAYER, "Targeting System");
	    notInMarket = 0;
	    if (success) {
		money.setText("Money: " + PLAYER.getMoney());
	    }
	    if (!success) {
		final Stage dialogStage = new Stage();
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage
			.setScene(new Scene(
				VBoxBuilder
					.create()
					.children(
						new Text(
				"You cannot sell something you don't own."))
					.alignment(Pos.CENTER)
					.padding(new Insets(PADDING)).build()));
		dialogStage.show();
	    }
	}
	if (notInMarket == 1) {
	    final Stage dialogStage = new Stage();
	    dialogStage.initModality(Modality.WINDOW_MODAL);
	    dialogStage.setScene(new Scene(VBoxBuilder.create()
		    .children(new Text("NOT SOLD IN THIS MARKET"))
		    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
	    dialogStage.show();
	}
	populateFields();
    }
    /**
     * 
     */
    private void populateFields() {
	String weapons = "";
	String shields = "";
	String gadgets = "";
	String escapePod = "";
<<<<<<< HEAD
	
	for (Laser x : SHIP.weapons) {
	    weapons = weapons + x.name + "\n";
	}
	for (Shield x : SHIP.shields) {
	    shields = shields + x.name + "\n";
	}
	for (Gadget x : SHIP.gadgets) {
	    gadgets = gadgets + x.name + "\n";
=======
	Ship ship = GameInstance.getInstance().getPlayer().getShip();
	for (Laser x : ship.weapons) {
	    weapons = weapons + x.getName() + "\n";
	}
	for (Shield x : ship.shields) {
	    shields = shields + x.getName() + "\n";
	}
	for (Gadget x : ship.gadgets) {
	    gadgets = gadgets + x.getName() + "\n";
>>>>>>> FETCH_HEAD
	}
	if (SHIP.getEscapePod()) {
	    escapePod = "Owned";
	} else {
	    escapePod = "Not owned";
	}
	listWeapons.setText(weapons);
	listShield.setText(shields);
	gadgetList.setText(gadgets);
	escapePodBool.setText(escapePod);
    }
    /**
     *
     * @param event
     */
   @FXML
    private void refuelTab(final MouseEvent event) {
    	fuelPrice.setText("Price: " + Integer.toString(SHIP.getFuelCost()));
    }

    /**
     *
     * @param event
     */
    @FXML
    private void buyFuel(final MouseEvent event) {
    	final boolean fueled =
                YARD.refuel(PLAYER, Integer.parseInt(fuelQuantity.getText()));
    	if (!(fueled)) {
    		final Stage dialogStage = new Stage();
		    dialogStage.initModality(Modality.WINDOW_MODAL);
		    dialogStage.setScene(new Scene(VBoxBuilder.create()
			    .children(new Text("INSUFFICIENT FUNDS"))
			    .alignment(Pos.CENTER)
                            .padding(new Insets(PADDING)).build()));
		    dialogStage.show();
    	}
    }


}
