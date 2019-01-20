package lavive.myMediaCenter.client.view;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import lavive.myMediaCenter.client.Client;
import lavive.myMediaCenter.client.model.MediaModel;
import lavive.myMediaCenter.client.tools.MediasDisplayHelper;
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
	
	private List<MediaModel> mediasModels;
	
	private int indiceStage;
	
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
		mediasDisplayView.setMaxWidth(Sizes.SCREEN_WIDTH);
		mediasDisplayView.setMaxHeight(8*Sizes.SCREEN_HEIGHT/10);
		//TilePane.setMargin(mediasDisplayView, new Insets(Sizes.MEDIAS_DISPLAY_MARGING));
		mediasDisplayView.setHgap(Sizes.MEDIAS_DISPLAY_SPACING);
		mediasDisplayView.setVgap(Sizes.MEDIAS_DISPLAY_SPACING);
		mediasDisplayView.setPadding(new Insets(Sizes.MEDIAS_DISPLAY_MARGING));
		
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
		mediasDisplayView.getStyleClass().add("back");
		
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
        Stage nextStage = MediasDisplayHelper.createStage(backStage, controller, rootLayout, title.getText(),
        		                                          (int)mediasModels.size()/Sizes.MEDIA_NUMBER_STAGE);
        currentStage.close();
        nextStage.show();
	}

	@FXML
	public void goToFirstPane() {
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
        Stage nextStage = MediasDisplayHelper.createStage(backStage, controller, rootLayout, title.getText(), 0);
        currentStage.close();
        nextStage.show();
	}

	@FXML
	public void skipBackPane() {
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
        Stage nextStage = MediasDisplayHelper.createStage(backStage, controller, rootLayout, title.getText(), indiceStage-1);
        currentStage.close();
        nextStage.show();
	}

	@FXML
	public void skipNextPane() {
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
        Stage nextStage = MediasDisplayHelper.createStage(backStage, controller, rootLayout, title.getText(), indiceStage+1);
        currentStage.close();
        nextStage.show();
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

	public void setMediasModels(List<MediaModel> mediasModels, int indiceStage) {
		this.mediasModels = mediasModels;	
		this.indiceStage = indiceStage;	
		if(mediasModels.size() <= Sizes.MEDIA_NUMBER_STAGE) {
			menuTopPane.setVisible(false);
			menuBottomPane.setVisible(false);
		} else if(indiceStage == 0) {
			skipToFirst1Box.setVisible(false);
			skipToFirst2Box.setVisible(false);	
			skipBack1Box.setVisible(false);
			skipBack2Box.setVisible(false);			
		} else if((indiceStage+1)*Sizes.MEDIA_NUMBER_STAGE > mediasModels.size()) {
			skipToLast1Box.setVisible(false);
			skipToLast2Box.setVisible(false);	
			skipNext1Box.setVisible(false);
			skipNext2Box.setVisible(false);
		}
		MediasDisplayHelper.addMedias(this.mediasModels, mediasDisplayView,
				                      indiceStage*Sizes.MEDIA_NUMBER_STAGE,
				                      Math.min(mediasModels.size(),(indiceStage+1)*Sizes.MEDIA_NUMBER_STAGE));
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
