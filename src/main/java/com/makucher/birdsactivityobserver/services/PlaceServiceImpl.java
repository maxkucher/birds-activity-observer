package com.makucher.birdsactivityobserver.services;

import com.makucher.birdsactivityobserver.domains.Place;
import com.makucher.birdsactivityobserver.dto.AddPlaceDto;
import com.makucher.birdsactivityobserver.exceptions.PlaceNotFoundException;
import com.makucher.birdsactivityobserver.repositories.PlaceRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;

    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public Place findPlaceById(long id) {
        return placeRepository.findById(id).orElseThrow(() -> new PlaceNotFoundException(String.format("Place with id %d not found", id)));
    }

    @Override
    public Place addPlace(AddPlaceDto addPlaceDto) {
        Place place = Place.builder()
                .label(addPlaceDto.getLabel())
                .latitude(addPlaceDto.getLatitude())
                .longitude(addPlaceDto.getLongitude())
                .build();
        place = placeRepository.save(place);
        return place;
    }
}
