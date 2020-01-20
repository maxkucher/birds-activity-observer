package com.makucher.birdsactivityobserver.controllers;

import com.makucher.birdsactivityobserver.dto.AddPlaceDto;
import com.makucher.birdsactivityobserver.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/places")
@RequiredArgsConstructor
public class PlacesControllerV1 {

    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<?> getPlaces() {
        return ResponseEntity.ok(placeService.getAllPlaces());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlacesById(@PathVariable long id) {
        return ResponseEntity.ok(placeService.findPlaceById(id));
    }

    @PostMapping
    public ResponseEntity<?> createPlace(@RequestBody AddPlaceDto addPlaceDto) {
        return ResponseEntity.ok(placeService.addPlace(addPlaceDto));
    }


}
