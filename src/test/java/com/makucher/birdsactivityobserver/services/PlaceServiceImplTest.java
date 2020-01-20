package com.makucher.birdsactivityobserver.services;

import com.makucher.birdsactivityobserver.domains.Place;
import com.makucher.birdsactivityobserver.dto.AddPlaceDto;
import com.makucher.birdsactivityobserver.exceptions.PlaceNotFoundException;
import com.makucher.birdsactivityobserver.repositories.PlaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PlaceServiceImplTest {

    @Mock
    PlaceRepository placeRepository;

    @InjectMocks
    PlaceServiceImpl placeService;

    @BeforeEach
    void setUp() {
    }

    static List<Place> getFakePlaces() {
        return List.of(
                Place.builder()
                        .latitude(new BigDecimal("10.58"))
                        .longitude(new BigDecimal("20.43"))
                        .label("test")
                        .build(),
                Place.builder()
                        .latitude(new BigDecimal("10.58"))
                        .longitude(new BigDecimal("20.43"))
                        .label("test2")
                        .build()
        );
    }

    static Place getFakePlace() {
        return Place.builder()
                .label("test")
                .latitude(new BigDecimal("150.0"))
                .longitude(new BigDecimal("130.0"))
                .build();
    }

    @Test
    void getAllPlaces() {
        when(placeRepository.findAll())
                .thenReturn(getFakePlaces());

        List<Place> places = placeService.getAllPlaces();

        assertEquals(places, getFakePlaces());
        verify(placeRepository, times(1)).findAll();
    }

    @Test
    void whenFindPlaceByIdSuccess_thenReturnsPlace() {
        when(placeRepository.findById(any()))
                .thenReturn(Optional.of(getFakePlace()));

        Place place = placeService.findPlaceById(1L);

        assertEquals(place, getFakePlace());

        verify(placeRepository, times(1)).findById(1L);
    }

    @Test
    void whenFindPlaceByIdFails_thenThrowsException() {
        when(placeRepository.findById(any()))
                .thenReturn(Optional.empty());

        assertThrows(PlaceNotFoundException.class, () -> placeService.findPlaceById(1L));
    }

    @Test
    void whenPlaceAdded_returnsPlace() {
        when(placeRepository.save(any()))
                .thenReturn(getFakePlace());

        AddPlaceDto dto = AddPlaceDto.builder()
                .label("test")
                .longitude(new BigDecimal("300.0")
                ).latitude(new BigDecimal("90.0")).build();

        assertEquals(placeService.addPlace(dto), getFakePlace());
        verify(placeRepository, times(1))
                .save(Place.builder()
                        .label(dto.getLabel())
                        .latitude(dto.getLatitude())
                        .longitude(dto.getLongitude())
                        .build());

    }
}
