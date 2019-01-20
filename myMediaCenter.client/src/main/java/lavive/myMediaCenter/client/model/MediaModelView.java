package lavive.myMediaCenter.client.model;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import lavive.myMediaCenter.client.tools.PathsProject;
import lavive.myMediaCenter.client.tools.Sizes;

/**
 * View to display a media model
 * 
 * @author lavive
 *
 */
public class MediaModelView {
	
	/* Attribute */
	private VBox box;
	
	/* Constructor */
	public MediaModelView(MediaModel mediaModel) {
		
		/* init */
		double width = Sizes.SCREEN_WIDTH/5-Sizes.MEDIAS_DISPLAY_SPACING-Sizes.MEDIAS_DISPLAY_MARGING;
		double height = 8*Sizes.SCREEN_HEIGHT/40-Sizes.MEDIAS_DISPLAY_SPACING-Sizes.MEDIAS_DISPLAY_MARGING;
        String css = this.getClass().getResource(PathsProject.CSS_MEDIA_VIEW_PATH).toExternalForm(); 
		
		/* build the icon */
		ImageView icon = new ImageView();
		File fileIcon = new File(mediaModel.getIconPaths().get(0));
		String pathIcon = fileIcon.toURI().toString();
		Image image = new Image(pathIcon);
		icon.setImage(image);
		icon.setPreserveRatio(true);
		icon.setFitWidth(width);
		icon.setFitHeight(3*height/4);
		
		/* build the label */
		Label title = new Label();
		title.setText(mediaModel.getTitle());
		title.setWrapText(true);
		title.setAlignment(Pos.TOP_CENTER);
		title.setTextAlignment(TextAlignment.CENTER);
		title.setMaxWidth(width);
		title.setMaxHeight(height/4);
        title.getStyleClass().add("title_label");
		
		/* build the box */
		box = new VBox();
		box.setMinSize(width, height);
		box.setAlignment(Pos.TOP_CENTER);
		box.getChildren().add(icon);
		box.getChildren().add(title);
        box.getStylesheets().add(css);
        box.getStyleClass().add("main_pane");
	}
	
	/* method */
//	public void addTo(Pane pane) {
//		pane.getChildren().add(box);
//	}
	
	/* getter */

	public VBox getBox() {
		return box;
	}
	
}