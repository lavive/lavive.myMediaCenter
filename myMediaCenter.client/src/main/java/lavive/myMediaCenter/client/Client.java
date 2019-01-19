package lavive.myMediaCenter.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lavive.myMediaCenter.client.tools.PathsProject;
import lavive.myMediaCenter.client.tools.StageSettings;
import lavive.myMediaCenter.client.view.HomeController;

public class Client extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Client.class.getResource("view/home.fxml"));
        
        AnchorPane rootLayout = (AnchorPane) loader.load();
        HomeController controller = loader.getController();
        
        // Set the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        String css = this.getClass().getResource(PathsProject.CSS_HOME_PATH).toExternalForm(); 
        scene.getStylesheets().add(css);
        
        // Set the stage
        StageSettings.setFitScreen(primaryStage, false);
        primaryStage.setScene(scene);
        controller.setCurrentStage(primaryStage);
        primaryStage.show();

	}

	public static void main(String[] args) {
        Application.launch(Client.class, args);
	}
	

}