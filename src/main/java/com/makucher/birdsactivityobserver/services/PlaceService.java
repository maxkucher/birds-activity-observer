package com.makucher.birdsactivityobserver.services;


import com.makucher.birdsactivityobserver.domains.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();

    Place findPlaceById(long id);
}
