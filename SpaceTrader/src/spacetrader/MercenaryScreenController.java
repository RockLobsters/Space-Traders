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
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.lang.NumberFormatException;
/**
 * FXML Controller class
 *
 * @author sydnipeterson
 */
public class MercenaryScreenController implements Initializable {
    @FXML
    private Text EngineerSkillText;
    @FXML
    private Text InvestorSkillText;
    @FXML
    private Text engineerText;
    @FXML
    private Text fighterSkillText;
    @FXML
    private Text fighterText;
    @FXML
    private TextField hiringNumber;
    @FXML
    private Text investorText;
    @FXML
    private Text moneyText;
    @FXML
    private Text nameText;
    @FXML
    private Text numberText;
    @FXML
    private Text pilotSkillText;
    @FXML
    private Text pilotText;
    private Player player = GameInstance.getInstance().getPlayer();
    PersonnelRoster roster = new PersonnelRoster();
    @FXML
    private Text traderSkillText;
    @FXML
    private Text traderText;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateSkills();
        populateRoster();
        
    }    

    @FXML
    private void hireMercenary(MouseEvent event) {
        try{
            int wantedMercenary = Integer.parseInt(hiringNumber.getText());
            if(wantedMercenary >= roster.getList().size()){
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.setScene(new Scene(VBoxBuilder.create().
                        children(new Text("That number is not on the list. Please try again.")).
                        alignment(Pos.CENTER).padding(new Insets(30)).build()));
                dialogStage.show();
            } else {
                boolean result = roster.hireMercenary(wantedMercenary);
                if(!result){
                    Stage dialogStage = new Stage();
                    dialogStage.initModality(Modality.WINDOW_MODAL);
                    dialogStage.setScene(new Scene(VBoxBuilder.create().
                            children(new Text("You do not have enough room.")).
                            alignment(Pos.CENTER).padding(new Insets(30)).build()));
                    dialogStage.show();
                }
                populateSkills();
                populateRoster();
            }
        } catch(NumberFormatException e){
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setScene(new Scene(VBoxBuilder.create().
                    children(new Text("Please enter Roster Number.")).
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
    
    private void populateSkills(){
        EngineerSkillText.setText("Engineer: " + player.getEngineer());
        pilotSkillText.setText("Pilot: " + player.getPilot());
        InvestorSkillText.setText("Investor: " + player.getInvestor());
        fighterSkillText.setText("Fighter " + player.getFighter());
        traderSkillText.setText("Trader " + player.getTrader());
    }
    
    private void populateRoster(){
        roster.populateList(player.getCurrentLocation());
        String name = "";
        String pilot = "";
        String fighter = "";
        String trader = "";
        String engineer = "";
        String investor = "";
        String number = "";
        List<Mercenary> mercenaries = roster.getList();
        for(int i = 0; i < mercenaries.size(); i++){
            Mercenary mercenary = mercenaries.get(i);
            name = name + mercenary.getName() + "\r\n " ;
            pilot = pilot +String.valueOf(mercenary.getPilot());
            fighter = fighter +String.valueOf(mercenary.getFighter());
            trader = trader +String.valueOf(mercenary.getTrader());
            engineer = engineer +String.valueOf(mercenary.getEngineer());
            investor = investor +String.valueOf(mercenary.getInvestor());
            number += i;
            numberText.setText(number);
            nameText.setText(name);
            pilotText.setText(pilot);
            fighterText.setText(fighter);
            traderText.setText(trader);
            engineerText.setText(engineer);
            investorText.setText(investor);
        }
    }
}
