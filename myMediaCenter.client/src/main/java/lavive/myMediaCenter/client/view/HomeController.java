package lavive.myMediaCenter.client.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Home page Controller
 * 
 * @author lavive
 *
 */
public class HomeController implements Initializable {
	
	/* Attributes */
	
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

	@FXML
	private ImageView quit;
	
	/* Constructor */
	public HomeController() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
	
}
