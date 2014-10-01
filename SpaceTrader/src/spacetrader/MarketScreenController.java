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
import javafx.fxml.Initializable;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;

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
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   /* @FXML
    private void waterTabOpen(MouseEvent event) {
        int price = getPrice(Enum.WATER);
        int quantity = getQuantity(Enum.WATER);

        
    }


    @FXML
    private void furTabOpen(MouseEvent event) {
        int price = getPrice(Enum.FUR);
        int quantity = getQuantity(Enum.FUR);
    }

    @FXML
    private void foodTabOpen(MouseEvent event) {
        int price = getPrice(Enum.FOOD);
        int quantity = getQuantity(Enum.FOOD);
    }

    @FXML
    private void oreTabOpen(MouseEvent event) {
        int price = getPrice(Enum.ORE);
        int quantity = getQuantity(Enum.ORE);
    }

    @FXML
    private void gamesTabOpen(MouseEvent event) {
        int price = getPrice(Enum.GAMES);
        int quantity = getQuantity(Enum.GAMES);
    }

    @FXML
    private void fireamrsTabOpen(MouseEvent event) {
        int price = getPrice(Enum.FIREARMS);
        int quantity = getQuantity(Enum.FIREARMS);
    }

    @FXML
    private void medicineTabOpen(MouseEvent event) {
        int price = getPrice(Enum.MEDICINE);
        int quantity = getQuantity(Enum.MEDICINE);
    }

    @FXML
    private void machinesTabOpen(MouseEvent event) {
        int price = getPrice(Enum.MACHINES);
        int quantity = getQuantity(Enum.MACHINES);
    }

    @FXML
    private void narcoticsTabOpen(MouseEvent event) {
        int price = getPrice(Enum.NARCOTICS);
        int quantity = getQuantity(Enum.NARCOTICS);
    }

    @FXML
    private void robotsTabOpen(MouseEvent event) {
        int price = getPrice(Enum.ROBOTS);
        int quantity = getQuantity(Enum.ROBOTS);
    }
    
    
    private int getPrice(GoodType type) {
        if (market.containsGood(type)) {
            ArrayList<Good> goods = market.getGoods();
            Good on = goods.get(0);
            for( int i = 0; i < goods.size(); i++) {
                on = goods.get(i);
                if (on.getType().equals(type)) {
                    return on.getPrice();
                }
            }
        } else {
            return 0;
        }
    }

    private int getQuantity(GoodType type) {
        if (market.containsGood(type)) {
            ArrayList<Good> goods = market.getGoods();
            Good on = goods.get(0);
            for( int i = 0; i < goods.size(); i++) {
                on = goods.get(i);
                if (on.getType().equals(type)) {
                    return on.getQuantity();
                }
            }
        } else {
            return 0;
        }
    }*/
    
}
