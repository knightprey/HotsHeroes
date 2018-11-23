package be.technifutur.mobile.service.impl;

import be.technifutur.mobile.service.ArtistService;
import be.technifutur.mobile.service.GenreService;
import be.technifutur.mobile.service.TrackService;

public class TrackServiceImpl implements TrackService {

    private ArtistService artistService;

    private GenreService genreService;

    public TrackServiceImpl(ArtistService artistService, GenreService genreService) {
        this.artistService = artistService;
        this.genreService = genreService;
    }
}
