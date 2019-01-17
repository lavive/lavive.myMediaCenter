package lavive.myMediaCenter.client.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

import lavive.myMediaCenter.client.tools.PathsProject;

public class I18n {
	
	
	private static Locale currentLocale = Locale.getDefault();
    
    public static String getString(String text) {
    	ResourceBundle i18n = 
    			ResourceBundle.getBundle(PathsProject.I18N_PATH, currentLocale);
    	return i18n.getString(text);
    }
}
