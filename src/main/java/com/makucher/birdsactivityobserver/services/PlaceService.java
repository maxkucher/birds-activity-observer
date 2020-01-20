package com.makucher.birdsactivityobserver.services;


import com.makucher.birdsactivityobserver.domains.Place;
import com.makucher.birdsactivityobserver.dto.AddPlaceDto;

import java.util.List;

public interface PlaceService {
    List<Place> getAllPlaces();

    Place findPlaceById(long id);

    Place addPlace(AddPlaceDto addPlaceDto);
}
