package be.technifutur.mobile.util;

import be.technifutur.mobile.service.ArtistService;
import be.technifutur.mobile.service.GenreService;
import be.technifutur.mobile.service.TrackService;
import be.technifutur.mobile.service.UserService;
import be.technifutur.mobile.service.impl.ArtistServiceImpl;
import be.technifutur.mobile.service.impl.GenreServiceImpl;
import be.technifutur.mobile.service.impl.TrackServiceImpl;
import be.technifutur.mobile.service.impl.UserServiceImpl;

public class ServiceLocator {

    // region Singleton

    private static ServiceLocator instance;

    public static ServiceLocator getInstance() {

        if (instance == null) {
            instance = new ServiceLocator();
        }

        return instance;
    }

    private ServiceLocator() {
    }

    // endregion

    private UserService userService;

    private ArtistService artistService;

    private GenreService genreService;

    private TrackService trackService;

    public UserService getUserService() {

        if (userService == null) {
            userService = new UserServiceImpl();
        }

        return userService;
    }

    public ArtistService getArtistService() {

        if (artistService == null) {
            artistService = new ArtistServiceImpl();
        }

        return artistService;
    }

    public  GenreService getGenreService() {

        if (genreService == null) {
            genreService = new GenreServiceImpl();
        }

        return genreService;
    }

    public TrackService getTrackService() {

        if (trackService == null) {
            trackService = new TrackServiceImpl(getArtistService(), getGenreService());
        }

        return trackService;
    }
}
