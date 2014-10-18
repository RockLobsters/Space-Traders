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

/**
 * FXML Controller class
 *
 * @author sydnipeterson
 */
public class MarketScreenController implements Initializable {
    @FXML
    private TitledPane waterTab;
    @FXML
    private TitledPane foodTab;
    @FXML
    private TitledPane oreTab;
    @FXML
    private TitledPane gamesTab;
    @FXML
    private TitledPane firearmsTab;
    @FXML
    private TitledPane medicineTab;
    @FXML
    private TitledPane machinesTab;
    @FXML
    private TitledPane NarcoticsTab;
    @FXML
    private TitledPane robotsTab;
    @FXML
    private TitledPane furTab;
    @FXML
    private Label waterQuantity;
    @FXML
    private Label waterPrice;
    @FXML
    private Button waterBuy;
    @FXML
    private Button waterSell;
    @FXML
    private Button furSell;
    @FXML
    private Label furQuantity;
    @FXML
    private Label furPrice;
    @FXML
    private Button furBuy;
    @FXML
    private Button foodBuy;
    @FXML
    private Button foodSell;
    @FXML
    private Label foodPrice;
    @FXML
    private Label foodQuantity;
    @FXML
    private Label orePrice;
    @FXML
    private Button oreSell;
    @FXML
    private Button oreBuy;
    @FXML
    private Label oreQuantity;
    @FXML
    private Button gamesSell;
    @FXML
    private Button gamesBuy;
    @FXML
    private Label gamesQuantity;
    @FXML
    private Label gamesPrice;
    @FXML
    private Button firearmsSell;
    @FXML
    private Button firearmsBuy;
    @FXML
    private Label firearmsQuantity;
    @FXML
    private Label firearmsPrice;
    @FXML
    private Button medicineSell;
    @FXML
    private Button medicineBuy;
    @FXML
    private Label medicineQuantity;
    @FXML
    private Label medicinePrice;
    @FXML
    private Button machinesSell;
    @FXML
    private Button machinesBuy;
    @FXML
    private Label machinesQuantity;
    @FXML
    private Label machinesPrice;
    @FXML
    private Label narcoticsPrice;
    @FXML
    private Button narcoticsSell;
    @FXML
    private Button narcoticsBuy;
    @FXML
    private Label narcoticsQuantity;
    @FXML
    private Button robotsSell;
    @FXML
    private Button robotsBuy;
    @FXML
    private Label robotsQuantity;
    @FXML
    private Label robotsPrice;
    @FXML
    private TextField waterToBuy;
    @FXML
    private TextField furToBuy;
    @FXML
    private TextField foodToBuy;
    @FXML
    private TextField oreToBuy;
    @FXML
    private TextField gamesToBuy;
    @FXML
    private TextField firearmsToBuy;
    @FXML
    private TextField medicineToBuy;
    @FXML
    private TextField machinesToBuy;
    @FXML
    private TextField narcoticsToBuy;
    @FXML
    private TextField robotsToBuy;
    private Market market = GameInstance.getInstance().getPlayer().getCurrentLocation().getMarket();
    private Player player = GameInstance.getInstance().getPlayer();
    private Ship ship = GameInstance.getInstance().getPlayer().getShip();
    @FXML
    private TextArea cargoBox;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String print = "Money: " + Double.toString(player.getMoney()) + "\n";
        print = print + ship.cargoToString();
        cargoBox.setText(print);
    }    

    @FXML
    private void waterTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.WATER);
        int quantity = getQuantity(GoodType.WATER);
        waterPrice.setText(Double.toString(price));
        waterQuantity.setText(Integer.toString(quantity));
    }




    @FXML
    private void furTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.FUR);
        int quantity = getQuantity(GoodType.FUR);
        furPrice.setText(Double.toString(price));
        furQuantity.setText(Integer.toString(quantity));
    }

    @FXML
    private void foodTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.FOOD);
        int quantity = getQuantity(GoodType.FOOD);
        foodPrice.setText(Double.toString(price));
        foodQuantity.setText(Integer.toString(quantity));
    }

    @FXML
    private void oreTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.ORE);
        int quantity = getQuantity(GoodType.ORE);
        orePrice.setText(Double.toString(price));
        oreQuantity.setText(Integer.toString(quantity));
    }

    @FXML
    private void gamesTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.GAMES);
        int quantity = getQuantity(GoodType.GAMES);
        gamesPrice.setText(Double.toString(price));
        gamesQuantity.setText(Integer.toString(quantity));
    }

    @FXML
    private void fireamrsTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.FIREARMS);
        int quantity = getQuantity(GoodType.FIREARMS);
        firearmsPrice.setText(Double.toString(price));
        firearmsQuantity.setText(Integer.toString(quantity));
    }

    @FXML
    private void medicineTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.MEDICINE);
        int quantity = getQuantity(GoodType.MEDICINE);
        medicinePrice.setText(Double.toString(price));
        medicineQuantity.setText(Integer.toString(quantity));
    }

    @FXML
    private void machinesTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.MACHINES);
        int quantity = getQuantity(GoodType.MACHINES);
        machinesPrice.setText(Double.toString(price));
        machinesQuantity.setText(Integer.toString(quantity));
    }

    @FXML
    private void narcoticsTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.NARCOTICS);
        int quantity = getQuantity(GoodType.NARCOTICS);
        narcoticsPrice.setText(Double.toString(price));
        narcoticsQuantity.setText(Integer.toString(quantity));
    }

    @FXML
    private void robotsTabOpen(MouseEvent event) {
        double price = getPrice(GoodType.ROBOTS);
        int quantity = getQuantity(GoodType.ROBOTS);
        robotsPrice.setText(Double.toString(price));
        robotsQuantity.setText(Integer.toString(quantity));
    }
    
    
    private double getPrice(GoodType type) {
        return market.getPrice(new Good(type, 0));
    }

    private int getQuantity(GoodType type) {
        return market.getQuantity(new Good(type, 0));
    }

  
    @FXML
    private void openTab(MouseEvent event) {
    }

    @FXML
    private void handleWaterBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        boolean success = market.buy(GoodType.WATER, quan, player);

        if (success) {
            double price = getPrice(GoodType.WATER);
            int quantity = getQuantity(GoodType.WATER);
            waterPrice.setText(Double.toString(price));
            waterQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy more than you can hold or afford.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }

    }

    @FXML
    private void handleWaterSellAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        boolean success = market.sell(GoodType.WATER, quan, player);
        
        if (success) {
            double price = getPrice(GoodType.WATER);
            int quantity = getQuantity(GoodType.WATER);
            waterPrice.setText(Double.toString(price));
            waterQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot sell this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFurSellAction(ActionEvent event) {
        int quan = Integer.parseInt(furToBuy.getText());
        boolean success = market.sell(GoodType.FUR, quan, player);

        if (success) {
            double price = getPrice(GoodType.FUR);
            int quantity = getQuantity(GoodType.FUR);
            furPrice.setText(Double.toString(price));
            furQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot sell this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFurBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(furToBuy.getText());
        boolean success = market.buy(GoodType.FUR, quan, player);


        if (success) {
            double price = getPrice(GoodType.FUR);
            int quantity = getQuantity(GoodType.FUR);
            furPrice.setText(Double.toString(price));
            furQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy more than you can hold or afford.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFoodBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(foodToBuy.getText());
        boolean success = market.buy(GoodType.FOOD, quan, player);

        if (success) {
            double price = getPrice(GoodType.FOOD);
            int quantity = getQuantity(GoodType.FOOD);
            foodPrice.setText(Double.toString(price));
            foodQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy more than you can hold or afford.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFoodSellAction(ActionEvent event) {
        int quan = Integer.parseInt(foodToBuy.getText());
        boolean success = market.sell(GoodType.FOOD, quan, player);

        if (success) {
            double price = getPrice(GoodType.FOOD);
            int quantity = getQuantity(GoodType.FOOD);
            foodPrice.setText(Double.toString(price));
            foodQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot sell this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleOreSellAction(ActionEvent event) {
        int quan = Integer.parseInt(oreToBuy.getText());
        boolean success = market.sell(GoodType.ORE, quan, player);

        if (success) {
            double price = getPrice(GoodType.ORE);
            int quantity = getQuantity(GoodType.ORE);
            orePrice.setText(Double.toString(price));
            oreQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot sell this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleOreBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(oreToBuy.getText());
        boolean success = market.buy(GoodType.ORE, quan, player);

        if (success) {
            double price = getPrice(GoodType.ORE);
            int quantity = getQuantity(GoodType.ORE);
            orePrice.setText(Double.toString(price));
            oreQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy more than you can hold or afford.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleGamesSellAction(ActionEvent event) {
        int quan = Integer.parseInt(gamesToBuy.getText());
        boolean success = market.sell(GoodType.GAMES, quan, player);

        if (success) {
            double price = getPrice(GoodType.GAMES);
            int quantity = getQuantity(GoodType.GAMES);
            gamesPrice.setText(Double.toString(price));
            gamesQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy more than you can hold or afford.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleGamesBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(gamesToBuy.getText());
        boolean success = market.sell(GoodType.GAMES, quan, player);

        if (success) {
            double price = getPrice(GoodType.GAMES);
            int quantity = getQuantity(GoodType.GAMES);
            gamesPrice.setText(Double.toString(price));
            gamesQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot sell this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFirearmsSellAction(ActionEvent event) {
        int quan = Integer.parseInt(firearmsToBuy.getText());
        boolean success = market.sell(GoodType.FIREARMS, quan, player);

        if (success) {
            double price = getPrice(GoodType.FIREARMS);
            int quantity = getQuantity(GoodType.FIREARMS);
            firearmsPrice.setText(Double.toString(price));
            firearmsQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot sell this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFirearmsBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(firearmsToBuy.getText());
        boolean success = market.buy(GoodType.FIREARMS, quan, player);

        if (success) {
            double price = getPrice(GoodType.FIREARMS);
            int quantity = getQuantity(GoodType.FIREARMS);
            firearmsPrice.setText(Double.toString(price));
            firearmsQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy more than you can hold or afford.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleMachinesBuyAction(MouseEvent event) {
        int quan = Integer.parseInt(machinesToBuy.getText());
        boolean success = market.buy(GoodType.MACHINES, quan, player);

        if (success) {
            double price = getPrice(GoodType.MACHINES);
            int quantity = getQuantity(GoodType.MACHINES);
            machinesPrice.setText(Double.toString(price));
            machinesQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy more than you can hold or afford.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleMachinesSellAction(MouseEvent event) {
        int quan = Integer.parseInt(machinesToBuy.getText());
        boolean success = market.sell(GoodType.MACHINES, quan, player);

        if (success) {
            double price = getPrice(GoodType.MACHINES);
            int quantity = getQuantity(GoodType.MACHINES);
            machinesPrice.setText(Double.toString(price));
            machinesQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot sell this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleRobotsSellAction(ActionEvent event) {
        int quan = Integer.parseInt(robotsToBuy.getText());
        boolean success = market.sell(GoodType.ROBOTS, quan, player);

        if (success) {
            double price = getPrice(GoodType.ROBOTS);
            int quantity = getQuantity(GoodType.ROBOTS);
            robotsPrice.setText(Double.toString(price));
            robotsQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot sell this here.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleRobotsBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(robotsToBuy.getText());
        boolean success = market.buy(GoodType.ROBOTS, quan, player);

        if (success) {
            double price = getPrice(GoodType.ROBOTS);
            int quantity = getQuantity(GoodType.ROBOTS);
            robotsPrice.setText(Double.toString(price));
            robotsQuantity.setText(Integer.toString(quantity));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                children(new Text("You cannot buy more than you can hold or afford.")).
                alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void returnToPlanet(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        //hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();

    }


    
}

