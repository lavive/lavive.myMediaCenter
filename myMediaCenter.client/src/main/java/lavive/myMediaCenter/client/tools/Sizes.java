package lavive.myMediaCenter.client.tools;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * Constants to set sizes
 * 
 * @author lavive
 *
 */
public class Sizes {

	/* screen size */
	private static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	
	public static double SCREEN_X = primaryScreenBounds.getMinX();
	public static double SCREEN_Y = primaryScreenBounds.getMinY();
	public static double SCREEN_WIDTH = primaryScreenBounds.getWidth();
	public static double SCREEN_HEIGHT = primaryScreenBounds.getHeight();
}
