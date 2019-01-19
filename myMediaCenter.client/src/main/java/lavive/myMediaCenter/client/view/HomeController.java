package lavive.myMediaCenter.client.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lavive.myMediaCenter.client.Client;
import lavive.myMediaCenter.client.internationalization.I18n;
import lavive.myMediaCenter.client.tools.PathsProject;
import lavive.myMediaCenter.client.tools.Sizes;
import lavive.myMediaCenter.client.tools.StageSettings;

/**
 * Home page Controller
 * 
 * @author lavive
 *
 */
public class HomeController implements Initializable {
	
	/* Attributes */
	
	// Pane
	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private GridPane menu;

	@FXML
	private Pane quit;
	
	@FXML
	private Pane emptyRight;
	
	// HBox
	@FXML
	private HBox videos;
	
	@FXML
	private HBox music;

	@FXML
	private HBox pictures;

	@FXML
	private HBox tv;

	@FXML
	private HBox radio;
	
	// ImageView
	@FXML
	private ImageView videosIcon;
	
	@FXML
	private ImageView musicIcon;
	
	@FXML
	private ImageView picturesIcon;
	
	@FXML
	private ImageView tvIcon;
	
	@FXML
	private ImageView radioIcon;

	@FXML
	private ImageView quitView;	
	
	// Label
	@FXML
	private Label videosLabel;
	
	@FXML
	private Label musicLabel;
	
	@FXML
	private Label picturesLabel;
	
	@FXML
	private Label tvLabel;
	
	@FXML
	private Label radioLabel;
	
	/* Other attributes */
	private Stage currentStage;
	
	/* Constructor */
	public HomeController() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/* set Text */
		videosLabel.setText(I18n.getString("home.menu.videos"));
		musicLabel.setText(I18n.getString("home.menu.music"));
		picturesLabel.setText(I18n.getString("home.menu.pictures"));
		tvLabel.setText(I18n.getString("home.menu.tv"));
		radioLabel.setText(I18n.getString("home.menu.radio"));
		
		/* set sizes */
		menu.setMaxWidth(Sizes.SCREEN_WIDTH/4);
		emptyRight.setMinWidth(3*Sizes.SCREEN_WIDTH/4);
		
		/* load images */
		String css = this.getClass().getResource(PathsProject.IMAGES_VIDEOS_PATH).toExternalForm(); 
		Image image = new Image(css);
        videosIcon.setImage(image);

        css = this.getClass().getResource(PathsProject.IMAGES_MUSIC_PATH).toExternalForm(); 
		image = new Image(css);
		musicIcon.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_PICTURES_PATH).toExternalForm(); 
		image = new Image(css);
		picturesIcon.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_TV_PATH).toExternalForm(); 
		image = new Image(css);
		tvIcon.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_RADIO_PATH).toExternalForm(); 
		image = new Image(css);
		radioIcon.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_QUIT_PATH).toExternalForm(); 
		image = new Image(css);
		quitView.setImage(image);
        
		/* apply css */
		mainPane.getStyleClass().add("main_pane");
		videos.getStyleClass().add("menu_item");
		music.getStyleClass().add("menu_item");
		pictures.getStyleClass().add("menu_item");
		tv.getStyleClass().add("menu_item");
		radio.getStyleClass().add("menu_item");
		quit.getStyleClass().add("quit");
		
		/* apply font */
		String font = this.getClass().getResource(PathsProject.FONTS_HOME_PATH).toExternalForm();
		Font.loadFont(font, 10);
		videosLabel.getStyleClass().add("menu_item_label");
		musicLabel.getStyleClass().add("menu_item_label");
		picturesLabel.getStyleClass().add("menu_item_label");
		tvLabel.getStyleClass().add("menu_item_label");
		radioLabel.getStyleClass().add("menu_item_label");
	}
	
	/* Effect method */	
	@FXML
	public void videosEnter() {
		menuItemEntered(videos);
	}	
	@FXML
	public void musicEnter() {
		menuItemEntered(music);
	}
	@FXML
	public void picturesEnter() {
		menuItemEntered(pictures);
	}
	@FXML
	public void tvEnter() {
		menuItemEntered(tv);
	}
	@FXML
	public void radioEnter() {
		menuItemEntered(radio);
	}
	@FXML
	public void quitEnter() {
		quitEntered(quit);
	}
	@FXML
	public void videosExited() {
		menuItemExited(videos);
	}	
	@FXML
	public void musicExited() {
		menuItemExited(music);
	}
	@FXML
	public void picturesExited() {
		menuItemExited(pictures);
	}
	@FXML
	public void tvExited() {
		menuItemExited(tv);
	}
	@FXML
	public void radioExited() {
		menuItemExited(radio);
	}
	@FXML
	public void quitExited() {
		quitExited(quit);
	}
	
	/* Action method */	
	@FXML
	public void goToVideos() {
		infoMenuClicked("Videos");
	}
	
	@FXML
	public void goToMusic() {
		infoMenuClicked("Music");
	}
	
	@FXML
	public void goToPictures() {
		infoMenuClicked("Pictures");
	}
	
	@FXML
	public void goToTV() {
		infoMenuClicked("TV");
	}
	
	@FXML
	public void goToRadio() {
		infoMenuClicked("Radio");
	}
	
	@FXML
	public void quit() {
		Platform.exit();
	}
	
	/* setters */
	
	public void setCurrentStage(Stage currentStage) {
		this.currentStage = currentStage;
	}
	
	
	/* helper method */
	private void infoMenuClicked(String menu) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(menu + " has been clicked!");

		alert.showAndWait();
		

        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Client.class.getResource("view/mediasDisplay.fxml"));
        
        BorderPane rootLayout = null;
		try {
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MediasDisplayController controller = loader.getController();
		controller.setTitle(I18n.getString("home.menu."+menu.toLowerCase()));
        
        // Set the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        String css = this.getClass().getResource(PathsProject.CSS_MEDIAS_PATH).toExternalForm(); 
        scene.getStylesheets().add(css);
        
        // Set the stage
		Stage nextStage = new Stage();
        StageSettings.setFitScreen(nextStage, false);
        nextStage.setScene(scene);

        controller.setBackStage(currentStage);
        controller.setCurrentStage(nextStage);
        currentStage.close();
        nextStage.show();
		
	}

	private void menuItemEntered(HBox menuItem) {
		menuItem.getStyleClass().add("menu_item_hovering");
	}
	
	private void menuItemExited(HBox menuItem) {
		menuItem.getStyleClass().remove("menu_item_hovering");
	}
	
	private void quitEntered(Pane quit) {
		quit.getStyleClass().add("quit_hovering");
	}
	
	private void quitExited(Pane quit) {
		quit.getStyleClass().remove("quit_hovering");
	}
	
}
