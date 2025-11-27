package tauon.app.services;

import java.awt.*;
import java.util.prefs.Preferences;

public class InternalPreferencesManager {
    
    // Load stored preferences
    static final Preferences prefs = Preferences.userRoot().node("tauonPrefs");
    
    
    private static final String PREF_X = "frame_x";
    private static final String PREF_Y = "frame_y";
    private static final String PREF_WIDTH = "frame_width";
    private static final String PREF_HEIGHT = "frame_height";
    
    public static void setLastLocation(Rectangle bounds){
        prefs.putInt(PREF_X, bounds.x);
        prefs.putInt(PREF_Y, bounds.y);
        prefs.putInt(PREF_WIDTH, bounds.width);
        prefs.putInt(PREF_HEIGHT, bounds.height);
    }
    
    public static Rectangle getLastLocation(){
        Rectangle r = new Rectangle(
            prefs.getInt(PREF_X, 0),
            prefs.getInt(PREF_Y, 0),
            prefs.getInt(PREF_WIDTH, 0),
            prefs.getInt(PREF_HEIGHT, 0)
        );
        if(r.width == 0 || r.height == 0)
            return null;
        return r;
    }
    
}
