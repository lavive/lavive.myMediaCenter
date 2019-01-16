package lavive.myMediaCenter.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lavive.myMediaCenter.client.tools.PathsProject;
import lavive.myMediaCenter.client.tools.Sizes;

public class Client extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Client.class.getResource("view/home.fxml"));
        
        AnchorPane rootLayout = (AnchorPane) loader.load();
        
        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        String css = this.getClass().getResource(PathsProject.CSS_HOME_PATH).toExternalForm(); 
        scene.getStylesheets().add(css);
        //rootLayout.getStyleClass().add("menu_item");
        primaryStage.setScene(scene);
        //primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        primaryStage.setX(Sizes.SCREEN_X);//primaryScreenBounds.getMinX());
        primaryStage.setY(Sizes.SCREEN_Y);//primaryScreenBounds.getMinY());
        primaryStage.setWidth(Sizes.SCREEN_WIDTH);//primaryScreenBounds.getWidth());
        primaryStage.setHeight(Sizes.SCREEN_HEIGHT);//primaryScreenBounds.getHeight());
        primaryStage.show();

	}

	public static void main(String[] args) {
        Application.launch(Client.class, args);
	}
	

}