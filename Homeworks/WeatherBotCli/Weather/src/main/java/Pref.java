import java.util.prefs.Preferences;

public class Pref {
    Preferences preferences;
    public Pref() {
        this.preferences = Preferences.userNodeForPackage(Pref.class);
    }

    public void setService(int service) {
        preferences.putInt("serviceId", service);
    }

    public int getService() {
        return preferences.getInt("serviceId", 0);
    }

//    public static void main(String[] args) {
//        Pref pref = new Pref();
//        pref.setService(0);
//    }
}
