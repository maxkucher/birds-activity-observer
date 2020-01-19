package com.makucher.birdsactivityobserver.repositories;

import com.makucher.birdsactivityobserver.domains.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
