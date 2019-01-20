package lavive.myMediaCenter.client.tools;

import java.io.File;

/**
 * Constants to get files path
 * 
 * @author lavive
 *
 */
public class PathsProject {
	
	/* general path */
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	
	private static final String PACKAGE_PATH = "lavive.myMediaCenter.client";
	
    /* I18n path */
    public static final String I18N_PATH = PACKAGE_PATH + ".internationalization.I18n"; 
	
	/* Images paths */
	private static final String IMAGES_PATH = File.separator + "lavive" +
	                                          File.separator + "myMediaCenter" + 
			                                  File.separator + "client" + 
	                                          File.separator + "images";
	
	// home page images
	private static final String IMAGES_HOME_PATH = IMAGES_PATH + File.separator + "home";
	
	public static final String IMAGES_VIDEOS_PATH = IMAGES_HOME_PATH + File.separator +
			                                       "baseline_local_movies_black_48dp.png";
	
	public static final String IMAGES_MUSIC_PATH = IMAGES_HOME_PATH + File.separator +
			                                       "baseline_audiotrack_black_48dp.png";
	
	public static final String IMAGES_PICTURES_PATH = IMAGES_HOME_PATH + File.separator +
			                                       "baseline_photo_album_black_48dp.png";
	
	public static final String IMAGES_TV_PATH = IMAGES_HOME_PATH + File.separator +
			                                       "baseline_tv_black_48dp.png";
	
	public static final String IMAGES_RADIO_PATH = IMAGES_HOME_PATH + File.separator +
			                                       "baseline_router_black_48dp.png";
	
	public static final String IMAGES_QUIT_PATH = IMAGES_HOME_PATH + File.separator +
			                                       "baseline_power_settings_new_black_36dp.png";

	// MediasDisplay images
	private static final String IMAGES_MEDIAS_PATH = IMAGES_PATH + File.separator + "mediasDisplay";
	
	public static final String IMAGES_RETURN_PATH = IMAGES_MEDIAS_PATH + File.separator +
			                                       "baseline_subdirectory_arrow_left_black_36dp.png";
	
	public static final String IMAGES_FIRST_PATH = IMAGES_MEDIAS_PATH + File.separator +
			                                       "baseline_fast_rewind_black_24dp.png";
	
	public static final String IMAGES_LAST_PATH = IMAGES_MEDIAS_PATH + File.separator +
			                                       "baseline_fast_forward_black_24dp.png";
	
	public static final String IMAGES_NEXT_PATH = IMAGES_MEDIAS_PATH + File.separator +
			                                       "baseline_skip_next_black_24dp.png";
	
	public static final String IMAGES_BACK_PATH = IMAGES_MEDIAS_PATH + File.separator +
			                                       "baseline_skip_previous_black_24dp.png";
	
	/* CSS paths */
	private static final String CSS_PATH = File.separator + "lavive" + 
                                           File.separator + "myMediaCenter" + 
                                           File.separator + "client" + 
                                           File.separator + "css";
                                          
	public static final String CSS_HOME_PATH = CSS_PATH + File.separator +
                                              "css_home.css";
    
    public static final String CSS_MEDIAS_PATH = CSS_PATH + File.separator +
                                                 "css_mediasDisplay.css";
    
    public static final String CSS_MEDIA_VIEW_PATH = CSS_PATH + File.separator +
                                                     "css_mediaView.css";
	
	/* Font paths */
	private static final String FONTS_PATH = File.separator + "lavive" + 
            							     File.separator + "myMediaCenter" + 
            							     File.separator + "client" + 
            							     File.separator + "fonts";
           
    public static final String FONTS_HOME_PATH = FONTS_PATH + File.separator +
                                                 "VideoPhreak.ttf";   

}
