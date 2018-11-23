package be.technifutur.mobile.util;

public class NavigationMessenger {

    // region Singleton

    private static NavigationMessenger instance;

    public static NavigationMessenger getInstance() {

        if (instance == null) {
            instance = new NavigationMessenger();
        }

        return instance;
    }

    private NavigationMessenger() {
    }

    // endregion

    private Listener listener;

    public void navigateTo(Page page) {

        if (this.listener != null) {
            this.listener.onNavigateTo(page);
        }
    }

    public void register(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {

        void onNavigateTo(Page page);
    }
}
