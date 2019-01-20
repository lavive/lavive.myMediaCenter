package lavive.myMediaCenter.client.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import lavive.myMediaCenter.client.model.MediaModel;
import lavive.myMediaCenter.client.model.MediaModelView;
import lavive.myMediaCenter.client.view.MediasDisplayController;

public class MediasDisplayHelper {

    private static final Comparator<MediaModel> mediaModelComparator = 
    		(MediaModel m1, MediaModel m2) -> 
            NaturalOrderComparator.NUMERICAL_ORDER.compare(m1.getTitle(), m2.getTitle());
	
	public static void addMedias(List<MediaModel> mediaModels, TilePane tilePane, int start, int end){
		/* sort model list */
		Collections.sort(mediaModels, mediaModelComparator);
		
		/* fill the panes */
		int numberMedia = 0;
		for (int i = start; i < end; i++) {
			numberMedia++;			
			if (numberMedia <= Sizes.MEDIA_NUMBER_STAGE) {
				tilePane.getChildren().add(new MediaModelView(mediaModels.get(i)).getBox());
			}			
		}		
	}
	
	public static Stage createStage(Stage backStage, MediasDisplayController controller,
			                        BorderPane mainPane, String menu, int indiceStage){
        
		/* create the Scene */
		Scene scene = new Scene(mainPane);
        String css = MediasDisplayHelper.class.getResource(PathsProject.CSS_MEDIAS_PATH).toExternalForm(); 
        scene.getStylesheets().add(css);
		
		/* create the Stage */
		Stage nextStage = new Stage();
        StageSettings.setFitScreen(nextStage, false);
        nextStage.setScene(scene);

		/* set the controller */
		controller.setTitle(menu);
        controller.setMediasModels(MediasDisplayHelper.listModel(159),indiceStage);
        controller.setBackStage(backStage);
        controller.setCurrentStage(nextStage);
        
        return nextStage;
		
	}
	
	public static List<MediaModel> listModel(int size){
		List<MediaModel> models = new ArrayList<>();
		for (int i = 0; i< size; i++) {
			MediaModel mediaModel = new MediaModel();
			mediaModel.setTitle("Image test "+(i+1));
			mediaModel.setIconPaths(Arrays.asList("/home/vivien/Images/coloriage-tigre-1.gif"));
			models.add(mediaModel);
		}
		return models;
	}

}
