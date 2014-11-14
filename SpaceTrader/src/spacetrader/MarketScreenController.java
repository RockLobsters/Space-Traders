/*
 * Copyright (C) 2014 sydnipeterson.
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

/**
 * FXML Controller class.
 *
 * @author sydnipeterson
 */
public class MarketScreenController implements Initializable {

    /**
    * Quantity for water.
    */
    @FXML
    private static transient Label waterQuantity;
    /**
    * Price for water.
    */
    @FXML
    private static transient Label waterPrice;
    /**
    * Quantity for fur.
    */
    @FXML
    private static transient Label furQuantity;
    /**
    * Price for fur.
    */
    @FXML
    private static transient Label furPrice;
    /**
    * Price for food.
    */
    @FXML
    private static transient Label foodPrice;
    /**
    * Quantity for food.
    */
    @FXML
    private static transient Label foodQuantity;
    /**
    * Price for ore.
    */
    @FXML
    private static transient Label orePrice;
    /**
    * Quantity for ore.
    */
    @FXML
    private static transient Label oreQuantity;
    /**
    * Quan for games.
    */
    @FXML
    private static transient Label gamesQuantity;
    /**
    * Price for games.
    */
    @FXML
    private static transient Label gamesPrice;
    /**
    * Quan for firearms.
    */
    @FXML
    private static transient Label firearmsQuantity;
    /**
    * Price for firearms.
    */
    @FXML
    private static transient Label firearmsPrice;
    /**
    * Quan for meds.
    */
    @FXML
    private static transient Label medicineQuantity;
    /**
    * Price for meds.
    */
    @FXML
    private static transient Label medicinePrice;
    /**
    * Quan for machines.
    */
    @FXML
    private static transient Label machinesQuantity;
    /**
    * Price for machines.
    */
    @FXML
    private static transient Label machinesPrice;
    /**
    * Price for narcotics.
    */
    @FXML
    private static transient Label narcoticsPrice;
    /**
    * Quan for narcotics.
    */
    @FXML
    private static transient Label narcoticsQuantity;
    /**
    * Quan for robos.
    */
    @FXML
    private static transient Label robotsQuantity;
    /**
    * Price for robots.
    */
    @FXML
    private static transient Label robotsPrice;
    /**
    * Amout to buy for water.
    */
    @FXML
    private static transient TextField waterToBuy;
    /**
    * Amout to buy for fur.
    */
    @FXML
    private static transient TextField furToBuy;
    /**
    * Amout to buy for food.
    */
    @FXML
    private static transient TextField foodToBuy;
    /**
    * Amout to buy for ore.
    */
    @FXML
    private static transient TextField oreToBuy;
    /**
    * Amout to buy for games.
    */
    @FXML
    private static transient TextField gamesToBuy;
    /**
    * Amout to buy for firearms.
    */
    @FXML
    private static transient TextField firearmsToBuy;
    /**
    * Amout to buy for meds.
    */
    @FXML
    private static transient TextField medicineToBuy;
    /**
    * Amout to buy for machines.
    */
    @FXML
    private static transient TextField machinesToBuy;
    /**
    * Amout to buy for narcotics.
    */
    @FXML
    private static transient TextField narcoticsToBuy;
    /**
    * Amout to buy for robots.
    */
    @FXML
    private static transient TextField robotsToBuy;

    /**
    * Instance of market.
    */
    private static final Market MARKET = GameInstance.getInstance().getPlayer()
        .getCurrentLocation().getMarket();
    /**
    * Instance of player.
    */
    private static final Player PLAYER = GameInstance.getInstance().getPlayer();
    /**
    * Instance of ship.
    */
    private static final Ship SHIP =
            GameInstance.getInstance().getPlayer().getShip();
    /**
    * CarboBox text area.
    */
    @FXML
    private static transient TextArea cargoBox;

    /**
    * Padding number.
    */
    private static final int PADDING = 30;

    /**
    * String they made me have.
    */
    private static final String MONEY = "Money: ";

    /**
    * String they made me have.
    */
    private static final String CANNOT =
            "You cannot buy more than you can hold or afford.";
    /**
    * String they made me have.
    */
    private static final String CANNOTSELL = "You cannot sell this here.";

    /**
     * Initializes the controller class.
     * @param resource  resource
     * @param url   a url
     */
    @Override
    public final void initialize(final URL url, final ResourceBundle resource) {
    final StringBuilder print =
            new StringBuilder(
                    MONEY + Double.toString(PLAYER.getMoney()) + "\n");
    print.append(SHIP.cargoToString());
    cargoBox.setText(print.toString());
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void waterTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.WATER);
    final int quantity = getQuantity(GoodType.WATER);
    waterPrice.setText(Double.toString(price));
    waterQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void furTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.FUR);
    final int quantity = getQuantity(GoodType.FUR);
    furPrice.setText(Double.toString(price));
    furQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void foodTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.FOOD);
    final int quantity = getQuantity(GoodType.FOOD);
    foodPrice.setText(Double.toString(price));
    foodQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @pram    event
    */
    @FXML
    private void oreTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.ORE);
    final int quantity = getQuantity(GoodType.ORE);
    orePrice.setText(Double.toString(price));
    oreQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void gamesTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.GAMES);
    final int quantity = getQuantity(GoodType.GAMES);
    gamesPrice.setText(Double.toString(price));
    gamesQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void fireamrsTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.FIREARMS);
    final int quantity = getQuantity(GoodType.FIREARMS);
    firearmsPrice.setText(Double.toString(price));
    firearmsQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void medicineTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.MEDICINE);
    final int quantity = getQuantity(GoodType.MEDICINE);
    medicinePrice.setText(Double.toString(price));
    medicineQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void machinesTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.MACHINES);
    final int quantity = getQuantity(GoodType.MACHINES);
    machinesPrice.setText(Double.toString(price));
    machinesQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void narcoticsTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.NARCOTICS);
    final int quantity = getQuantity(GoodType.NARCOTICS);
    narcoticsPrice.setText(Double.toString(price));
    narcoticsQuantity.setText(Integer.toString(quantity));
    }

    /**
    * When tab opens.
    * @param    event
    */
    @FXML
    private void robotsTabOpen(final MouseEvent event) {
    final double price = getPrice(GoodType.ROBOTS);
    final int quantity = getQuantity(GoodType.ROBOTS);
    robotsPrice.setText(Double.toString(price));
    robotsQuantity.setText(Integer.toString(quantity));
    }

    /**
    * Gets price.
    * @param     type of good
    */
    private double getPrice(final GoodType type) {
    return MARKET.getPrice(new Good(type, 0));
    }

    /**
    * Gets quan.
    * @param    type
    */
    private int getQuantity(final GoodType type) {
    return MARKET.getQuantity(new Good(type, 0));
    }

    /**
    * When buying water.
    * @param    event will happen
    */
    @FXML
    private void handleWaterBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(waterToBuy.getText());
    final boolean success = MARKET.buy(GoodType.WATER, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.WATER);
        final int quantity = getQuantity(GoodType.WATER);
        waterPrice.setText(Double.toString(price));
        waterQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }

    }

    /**
    * When selling water.
    * @param    event
    */
    @FXML
    private void handleWaterSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(waterToBuy.getText());
    final boolean success = MARKET.sell(GoodType.WATER, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.WATER);
        final int quantity = getQuantity(GoodType.WATER);
        waterPrice.setText(Double.toString(price));
        waterQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling fur.
    * @param    event
    */
    @FXML
    private void handleFurSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(furToBuy.getText());
    final boolean success = MARKET.sell(GoodType.FUR, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.FUR);
        final int quantity = getQuantity(GoodType.FUR);
        furPrice.setText(Double.toString(price));
        furQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When buying fur.
    * @param    event
    */
    @FXML
    private void handleFurBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(furToBuy.getText());
    final boolean success = MARKET.buy(GoodType.FUR, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.FUR);
        final int quantity = getQuantity(GoodType.FUR);
        furPrice.setText(Double.toString(price));
        furQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling meds.
    * @param    event
    */
    @FXML
    private void handleMedicineSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(medicineToBuy.getText());
    final boolean success = MARKET.sell(GoodType.MEDICINE, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.MEDICINE);
        final int quantity = getQuantity(GoodType.MEDICINE);
        medicinePrice.setText(Double.toString(price));
        medicineQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When buying meds.
    * @param    event
    */
    @FXML
    private void handleMedicineBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(medicineToBuy.getText());
    final boolean success = MARKET.buy(GoodType.MEDICINE, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.MEDICINE);
        final int quantity = getQuantity(GoodType.MEDICINE);
        medicinePrice.setText(Double.toString(price));
        medicineQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling narcotics.
    * @param    event
    */
    @FXML
    private void handleNarcoticsSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(narcoticsToBuy.getText());
    final boolean success = MARKET.sell(GoodType.NARCOTICS, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.NARCOTICS);
        final int quantity = getQuantity(GoodType.NARCOTICS);
        narcoticsPrice.setText(Double.toString(price));
        narcoticsQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When buing narcotics.
    * @param    event
    */
    @FXML
    private void handlNarcoticsBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(narcoticsToBuy.getText());
    final boolean success = MARKET.buy(GoodType.NARCOTICS, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.NARCOTICS);
        final int quantity = getQuantity(GoodType.NARCOTICS);
        narcoticsPrice.setText(Double.toString(price));
        narcoticsQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }


    /**
    * When buying food.
    * @param    event
    */
    @FXML
    private void handleFoodBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(foodToBuy.getText());
    final boolean success = MARKET.buy(GoodType.FOOD, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.FOOD);
        final int quantity = getQuantity(GoodType.FOOD);
        foodPrice.setText(Double.toString(price));
        foodQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling food.
    * @param    event
    */
    @FXML
    private void handleFoodSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(foodToBuy.getText());
    final boolean success = MARKET.sell(GoodType.FOOD, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.FOOD);
        final int quantity = getQuantity(GoodType.FOOD);
        foodPrice.setText(Double.toString(price));
        foodQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling ore.
    * @param event
    */
    @FXML
    private void handleOreSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(oreToBuy.getText());
    final boolean success = MARKET.sell(GoodType.ORE, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.ORE);
        final int quantity = getQuantity(GoodType.ORE);
        orePrice.setText(Double.toString(price));
        oreQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When buying ore.
    * @param event
    */
    @FXML
    private void handleOreBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(oreToBuy.getText());
    final boolean success = MARKET.buy(GoodType.ORE, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.ORE);
        final int quantity = getQuantity(GoodType.ORE);
        orePrice.setText(Double.toString(price));
        oreQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling games.
    * @param event
    */
    @FXML
    private void handleGamesSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(gamesToBuy.getText());
    final boolean success = MARKET.sell(GoodType.GAMES, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.GAMES);
        final int quantity = getQuantity(GoodType.GAMES);
        gamesPrice.setText(Double.toString(price));
        gamesQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When byin games.
    * @param event
    */
    @FXML
    private void handleGamesBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(gamesToBuy.getText());
    final boolean success = MARKET.sell(GoodType.GAMES, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.GAMES);
        final int quantity = getQuantity(GoodType.GAMES);
        gamesPrice.setText(Double.toString(price));
        gamesQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling firearms.
    * @param event
    */
    @FXML
    private void handleFirearmsSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(firearmsToBuy.getText());
    final boolean success = MARKET.sell(GoodType.FIREARMS, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.FIREARMS);
        final int quantity = getQuantity(GoodType.FIREARMS);
        firearmsPrice.setText(Double.toString(price));
        firearmsQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When buying firearms.
    * @param event
    */
    @FXML
    private void handleFirearmsBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(firearmsToBuy.getText());
    final boolean success = MARKET.buy(GoodType.FIREARMS, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.FIREARMS);
        final int quantity = getQuantity(GoodType.FIREARMS);
        firearmsPrice.setText(Double.toString(price));
        firearmsQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When buying machines.
    * @param event
    */
    @FXML
    private void handleMachinesBuyAction(final MouseEvent event) {
    final int quan = Integer.parseInt(machinesToBuy.getText());
    final boolean success = MARKET.buy(GoodType.MACHINES, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.MACHINES);
        final int quantity = getQuantity(GoodType.MACHINES);
        machinesPrice.setText(Double.toString(price));
        machinesQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling machines.
    * @param event
    */
    @FXML
    private void handleMachinesSellAction(final MouseEvent event) {
    final int quan = Integer.parseInt(machinesToBuy.getText());
    final boolean success = MARKET.sell(GoodType.MACHINES, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.MACHINES);
        final int quantity = getQuantity(GoodType.MACHINES);
        machinesPrice.setText(Double.toString(price));
        machinesQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When selling robos.
    * @param event
    */
    @FXML
    private void handleRobotsSellAction(final ActionEvent event) {
    final int quan = Integer.parseInt(robotsToBuy.getText());
    final boolean success = MARKET.sell(GoodType.ROBOTS, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.ROBOTS);
        final int quantity = getQuantity(GoodType.ROBOTS);
        robotsPrice.setText(Double.toString(price));
        robotsQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(VBoxBuilder.create()
            .children(new Text(CANNOTSELL))
            .alignment(Pos.CENTER).padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
    * When buying robos.
    * @param event
    */
    @FXML
    private void handleRobotsBuyAction(final ActionEvent event) {
    final int quan = Integer.parseInt(robotsToBuy.getText());
    final boolean success = MARKET.buy(GoodType.ROBOTS, quan, PLAYER);

    if (success) {
        final double price = getPrice(GoodType.ROBOTS);
        final int quantity = getQuantity(GoodType.ROBOTS);
        robotsPrice.setText(Double.toString(price));
        robotsQuantity.setText(Integer.toString(quantity));
        final StringBuilder print = new StringBuilder(
                MONEY + Double.toString(PLAYER.getMoney()) + "\n");
        print.append(SHIP.cargoToString());
        cargoBox.setText(print.toString());
    } else {
        final Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage
            .setScene(new Scene(
                VBoxBuilder
                    .create()
                    .children(
                        new Text(
                            CANNOT))
                    .alignment(Pos.CENTER)
                    .padding(new Insets(PADDING)).build()));
        dialogStage.show();

    }
    }

    /**
     * Returns the user to the PlanetScreen when the button is clicked.
     *
     * @param event
     *            occurs when the user clicks on the "RETURN" button
     * @throws      exception
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
}