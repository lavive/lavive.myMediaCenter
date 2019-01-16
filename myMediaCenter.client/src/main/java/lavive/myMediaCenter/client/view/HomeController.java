package lavive.myMediaCenter.client.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import lavive.myMediaCenter.client.tools.PathsProject;
import lavive.myMediaCenter.client.tools.Sizes;

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
	
	//ImageView
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
	
	/* Constructor */
	public HomeController() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
		videos.getStyleClass().add("menu_item");
		music.getStyleClass().add("menu_item");
		pictures.getStyleClass().add("menu_item");
		tv.getStyleClass().add("menu_item");
		radio.getStyleClass().add("menu_item");
		quit.getStyleClass().add("quit");
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
	
	/* helper method */
	private void infoMenuClicked(String menu) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(menu + " has been clicked!");

		alert.showAndWait();
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
