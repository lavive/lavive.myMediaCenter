package lavive.myMediaCenter.client.model;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Set the model media to display
 * 
 * @author lavive
 *
 */
public class MediaModel {

	/* Attributes */
	
	private String mainPath;
	
	private List<String> iconPaths;
	
	private String fileName;
	
	private StringProperty title = new SimpleStringProperty();

	public String getMainPath() {
		return mainPath;
	}
	
	/* Getters and Setters */

	public void setMainPath(String mainPath) {
		this.mainPath = mainPath;
	}

	public List<String> getIconPaths() {
		return iconPaths;
	}

	public void setIconPaths(List<String> iconPaths) {
		this.iconPaths = iconPaths;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}
	
	
}
