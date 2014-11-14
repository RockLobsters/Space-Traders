/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package spacetrader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
*
* @author addison
*/
public class SpaceTrader extends Application {

    @Override
    public final void start(final Stage stage) throws Exception {
        final Parent root = FXMLLoader
                .load(getClass().getResource("RootWindow.fxml"));

        final Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }

}
