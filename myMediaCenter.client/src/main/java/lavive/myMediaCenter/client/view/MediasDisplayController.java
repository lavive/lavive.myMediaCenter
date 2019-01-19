package lavive.myMediaCenter.client.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import lavive.myMediaCenter.client.tools.PathsProject;
import lavive.myMediaCenter.client.tools.Sizes;

/**
 * Medias display page Controller
 * 
 * @author lavive
 *
 */
public class MediasDisplayController implements Initializable {
	
	/* Attributes */
	
	//Pane
	@FXML
	private BorderPane mainPane;
	
	@FXML
	private HBox topPane;
	
	@FXML
	private HBox menuTopPane;
	
	@FXML
	private HBox menuBottomPane;
	
	@FXML
	private TilePane mediasDisplayView;
	
	@FXML
	private HBox titleBox;
	
	@FXML
	private Label title;
	
	//Images
	@FXML
	private ImageView back;
	@FXML
	private HBox backBox;
	
	@FXML
	private ImageView skipToLast1;
	@FXML
	private HBox skipToLast1Box;
	
	@FXML
	private ImageView skipNext1;
	@FXML
	private HBox skipNext1Box;

	@FXML
	private ImageView skipBack1;
	@FXML
	private HBox skipBack1Box;

	@FXML
	private ImageView skipToFirst1;
	@FXML
	private HBox skipToFirst1Box;

	@FXML
	private ImageView skipToLast2;
	@FXML
	private HBox skipToLast2Box;
	
	@FXML
	private ImageView skipNext2;
	@FXML
	private HBox skipNext2Box;

	@FXML
	private ImageView skipBack2;
	@FXML
	private HBox skipBack2Box;

	@FXML
	private ImageView skipToFirst2;
	@FXML
	private HBox skipToFirst2Box;
	
	// other attributes
	private Stage backStage;
	
	private Stage currentStage;
	
	/* Constructor */
	public MediasDisplayController() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/* Set Sizes */
		titleBox.setMinWidth(Sizes.SCREEN_WIDTH);
		topPane.setMaxHeight(Sizes.SCREEN_HEIGHT/10);
		menuTopPane.setMaxHeight(Sizes.SCREEN_HEIGHT/20);
		menuBottomPane.setMaxHeight(Sizes.SCREEN_HEIGHT/20);
		mediasDisplayView.setMaxHeight(8*Sizes.SCREEN_HEIGHT/10);
		
		/* load images */
		String css = this.getClass().getResource(PathsProject.IMAGES_RETURN_PATH).toExternalForm(); 
		Image image = new Image(css);
        back.setImage(image);

        css = this.getClass().getResource(PathsProject.IMAGES_LAST_PATH).toExternalForm(); 
		image = new Image(css);
		skipToLast1.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_FIRST_PATH).toExternalForm(); 
		image = new Image(css);
		skipToFirst1.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_NEXT_PATH).toExternalForm(); 
		image = new Image(css);
		skipNext1.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_BACK_PATH).toExternalForm(); 
		image = new Image(css);
		skipBack1.setImage(image);

        css = this.getClass().getResource(PathsProject.IMAGES_LAST_PATH).toExternalForm(); 
		image = new Image(css);
		skipToLast2.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_FIRST_PATH).toExternalForm(); 
		image = new Image(css);
		skipToFirst2.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_NEXT_PATH).toExternalForm(); 
		image = new Image(css);
		skipNext2.setImage(image);

		css = this.getClass().getResource(PathsProject.IMAGES_BACK_PATH).toExternalForm(); 
		image = new Image(css);
		skipBack2.setImage(image);
		
		/* apply css */
		mainPane.getStyleClass().add("main_pane");
		menuTopPane.getStyleClass().add("skip_menu");
		menuBottomPane.getStyleClass().add("skip_menu");
		backBox.getStyleClass().add("back");
		skipToFirst1Box.getStyleClass().add("skip");
		skipToLast1Box.getStyleClass().add("skip");
		skipBack1Box.getStyleClass().add("skip");
		skipNext1Box.getStyleClass().add("skip");
		skipToFirst2Box.getStyleClass().add("skip");
		skipToLast2Box.getStyleClass().add("skip");
		skipBack2Box.getStyleClass().add("skip");
		skipNext2Box.getStyleClass().add("skip");
		title.getStyleClass().add("title_label");
		
	}
	
	/* Effect method */	
	@FXML
	public void lastEnter1() {
		menuSkipEntered(skipToLast1Box);
	}	
	@FXML
	public void firstEnter1() {
		menuSkipEntered(skipToFirst1Box);
	}
	@FXML
	public void nextEnter1() {
		menuSkipEntered(skipNext1Box);
	}
	@FXML
	public void backEnter1() {
		menuSkipEntered(skipBack1Box);
	}
	@FXML
	public void lastEnter2() {
		menuSkipEntered(skipToLast2Box);
	}	
	@FXML
	public void firstEnter2() {
		menuSkipEntered(skipToFirst2Box);
	}
	@FXML
	public void nextEnter2() {
		menuSkipEntered(skipNext2Box);
	}
	@FXML
	public void backEnter2() {
		menuSkipEntered(skipBack2Box);
	}
	@FXML
	public void backWindowEnter() {
		backEntered(backBox);
	}
	@FXML
	public void lastExited1() {
		menuSkipExited(skipToLast1Box);
	}	
	@FXML
	public void firstExited1() {
		menuSkipExited(skipToFirst1Box);
	}
	@FXML
	public void nextExited1() {
		menuSkipExited(skipNext1Box);
	}
	@FXML
	public void backExited1() {
		menuSkipExited(skipBack1Box);
	}
	@FXML
	public void lastExited2() {
		menuSkipExited(skipToLast2Box);
	}	
	@FXML
	public void firstExited2() {
		menuSkipExited(skipToFirst2Box);
	}
	@FXML
	public void nextExited2() {
		menuSkipExited(skipNext2Box);
	}
	@FXML
	public void backExited2() {
		menuSkipExited(skipBack2Box);
	}
	@FXML
	public void backWindowExited() {
		backExited(backBox);
	}
	
	/* Action method */	
	@FXML
	public void backToLastWindow() {
		currentStage.close();
		backStage.show();
	}

	@FXML
	public void goToLastPane() {
		
	}

	@FXML
	public void goToFirstPane() {
		
	}

	@FXML
	public void skipBackPane() {
		
	}

	@FXML
	public void skipNextPane() {
		
	}
	
	/* setter */

	public void setTitle(String titleText) {
		this.title.setText(titleText);
	}

	public void setBackStage(Stage backStage) {
		this.backStage = backStage;
	}

	public void setCurrentStage(Stage currentStage) {
		this.currentStage = currentStage;
	}
	
	/* helper methods */

	private void menuSkipEntered(HBox skip) {
		skip.getStyleClass().add("skip_hovering");
	}
	
	private void menuSkipExited(HBox skip) {
		skip.getStyleClass().remove("skip_hovering");
	}
	
	private void backEntered(HBox backBox) {
		backBox.getStyleClass().add("back_hovering");
	}
	
	private void backExited(HBox backBox) {
		backBox.getStyleClass().remove("back_hovering");
	}
	
}
