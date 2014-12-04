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

/**
 * FXML Controller class
 *
 * @author jackie
 */
public class TraderScreenController implements Initializable {
    @FXML
    private TitledPane NarcoticsTab;
    @FXML
    private TextArea cargoBox;
    @FXML
    private Button firearmsBuy;
    @FXML
    private Label firearmsPrice;
    @FXML
    private Label firearmsQuantity;
    @FXML
    private Button firearmsSell;
    @FXML
    private TitledPane firearmsTab;
    @FXML
    private TextField firearmsToBuy;
    @FXML
    private Button foodBuy;
    @FXML
    private Label foodPrice;
    @FXML
    private Label foodQuantity;
    @FXML
    private Button foodSell;
    @FXML
    private TitledPane foodTab;
    @FXML
    private TextField foodToBuy;
    @FXML
    private Button furBuy;
    @FXML
    private Label furPrice;
    @FXML
    private Label furQuantity;
    @FXML
    private Button furSell;
    @FXML
    private TitledPane furTab;
    @FXML
    private TextField furToBuy;
    @FXML
    private Button gamesBuy;
    @FXML
    private Label gamesPrice;
    @FXML
    private Label gamesQuantity;
    @FXML
    private Button gamesSell;
    @FXML
    private TitledPane gamesTab;
    @FXML
    private TextField gamesToBuy;
    @FXML
    private Button machinesBuy;
    @FXML
    private Label machinesPrice;
    @FXML
    private Label machinesQuantity;
    @FXML
    private Button machinesSell;
    @FXML
    private TitledPane machinesTab;
    @FXML
    private TextField machinesToBuy;
    @FXML
    private Button medicineBuy;
    @FXML
    private Label medicinePrice;
    @FXML
    private Label medicineQuantity;
    @FXML
    private Button medicineSell;
    @FXML
    private TitledPane medicineTab;
    @FXML
    private TextField medicineToBuy;
    @FXML
    private Button narcoticsBuy;
    @FXML
    private Label narcoticsPrice;
    @FXML
    private Label narcoticsQuantity;
    @FXML
    private Button narcoticsSell;
    @FXML
    private TextField narcoticsToBuy;
    @FXML
    private Button oreBuy;
    @FXML
    private Label orePrice;
    @FXML
    private Label oreQuantity;
    @FXML
    private Button oreSell;
    @FXML
    private TitledPane oreTab;
    @FXML
    private TextField oreToBuy;
    @FXML
    private Button robotsBuy;
    @FXML
    private Label robotsPrice;
    @FXML
    private Label robotsQuantity;
    @FXML
    private Button robotsSell;
    @FXML
    private TitledPane robotsTab;
    @FXML
    private TextField robotsToBuy;
    @FXML
    private Button waterBuy;
    @FXML
    private Label waterPrice;
    @FXML
    private Label waterQuantity;
    @FXML
    private Button waterSell;
    @FXML
    private TitledPane waterTab;
    @FXML
    private TextField waterToBuy;

    private Player player = GameInstance.getInstance().getPlayer();
    private Planet planet = player.getCurrentLocation();
    RandomEncounter traderEncounter = new RandomEncounter(player, planet.getSolarSystem(), "TRADER");
    NonPlayer np = traderEncounter.getNonPlayer();
    Ship ship = GameInstance.getInstance().getPlayer().getShip();
    Ship npShip = np.ship();
    ArrayList<Good> goods = npShip.getCargo();



    public int getIndex(Good good) {
        for (int i = 0; i < goods.size(); i++) {
            if (good.type == goods.get(i).type) {
                return i;
            }
        }
        return -1;
    }
    public Good getGood(Good good) {
        int index = getIndex(good);
        if (index != -1) {
            return goods.get(index);
        }
        return null;
    }

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
    private void fireamrsTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.FIREARMS, 1));
        if(fire != null) {
            firearmsPrice.setText(Double.toString(fire.getPrice()));
            firearmsQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void foodTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.FOOD,1));
        if(fire != null) {
            foodPrice.setText(Double.toString(fire.getPrice()));
            foodQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void furTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.FUR,1));
        if(fire != null) {
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void gamesTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.GAMES,1));
        if(fire != null) {
            gamesPrice.setText(Double.toString(fire.getPrice()));
            gamesQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void handleFirearmsBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.FIREARMS,1));
        boolean success = np.buyFrom(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.FIREARMS,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy more than you can hold or afford.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFirearmsSellAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.FIREARMS,1));
        boolean success = np.sellTo(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.FUR,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot sell this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFoodBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.FOOD,1));
        boolean success = np.buyFrom(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.FUR,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
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
        int quan = Integer.parseInt(waterToBuy.getText());
            Good fire = getGood(new Good(GoodType.FOOD,1));
        boolean success = np.sellTo(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.FUR,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
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
        int quan = Integer.parseInt(waterToBuy.getText());
            Good fire = getGood(new Good(GoodType.FUR,1));
        boolean success = np.buyFrom(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.FUR,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy more than you can hold or afford.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleFurSellAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.FUR,1));
        boolean success = np.sellTo(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.FUR,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot sell this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleGamesBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
            Good fire = getGood(new Good(GoodType.GAMES,1));
        boolean success = np.buyFrom(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.GAMES,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
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
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.GAMES,1));
        boolean success = np.sellTo(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.GAMES,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot sell this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleMachinesBuyAction(MouseEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.MACHINES,1));
        boolean success = np.buyFrom(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.MACHINES,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
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
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.MACHINES,1));
        boolean success = np.sellTo(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.MACHINES,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
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
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.ORE,1));
        boolean success = np.buyFrom(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.ORE,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy more than you can hold or afford.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleOreSellAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.ORE,1));
        boolean success = np.sellTo(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.ORE,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
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
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.ROBOTS,1));
        boolean success = np.buyFrom(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.ROBOTS,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot buy more than you can hold or afford.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleRobotsSellAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.ROBOTS,1));
        boolean success = np.sellTo(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.ROBOTS,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot sell this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void handleWaterBuyAction(ActionEvent event) {
        int quan = Integer.parseInt(waterToBuy.getText());
        Good fire = getGood(new Good(GoodType.WATER,1));
        boolean success = np.buyFrom(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.WATER,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
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
        Good fire = getGood(new Good(GoodType.WATER,1));
        boolean success = np.sellTo(fire, quan);

        if (success) {
            fire = getGood(new Good(GoodType.WATER,1));
            furPrice.setText(Double.toString(fire.getPrice()));
            furQuantity.setText(Integer.toString(fire.getQuantity()));
            String print = "Money: " + Double.toString(player.getMoney()) + "\n";
            print = print + ship.cargoToString();
            cargoBox.setText(print);
        }
        else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("You cannot sell this here.")).
                    alignment(Pos.CENTER).padding(new Insets(30)).build()));
            dialogStage.show();

        }
    }

    @FXML
    private void machinesTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.MACHINES,1));
        if(fire != null) {
            machinesPrice.setText(Double.toString(fire.getPrice()));
            machinesQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void medicineTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.MEDICINE,1));
        if(fire != null) {
            medicinePrice.setText(Double.toString(fire.getPrice()));
            medicineQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void narcoticsTabOpen(MouseEvent event) {
        Good fire = fire = getGood(new Good(GoodType.NARCOTICS,1));
        if(fire != null) {
            narcoticsPrice.setText(Double.toString(fire.getPrice()));
            narcoticsQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void openTab(MouseEvent event) {
    }

    @FXML
    private void oreTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.ORE,1));
        if(fire != null) {
            orePrice.setText(Double.toString(fire.getPrice()));
            oreQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void returnToPlanet(MouseEvent event) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        //hide this current window (if this is whant you want
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void robotsTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.ROBOTS,1));
        if(fire != null) {
            robotsPrice.setText(Double.toString(fire.getPrice()));
            robotsQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }

    @FXML
    private void waterTabOpen(MouseEvent event) {
        Good fire = getGood(new Good(GoodType.WATER,1));
        if(fire != null) {
            waterPrice.setText(Double.toString(fire.getPrice()));
            waterQuantity.setText(Integer.toString(fire.getQuantity()));
        } else {
            machinesPrice.setText("0");
            machinesQuantity.setText("0");
        }
    }
    
}
