package com.makucher.birdsactivityobserver;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.makucher.birdsactivityobserver.controllers.PlacesControllerV1;
import com.makucher.birdsactivityobserver.services.PlaceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PlacesControllerV1.class)
public class WebLayerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private PlaceService placeService;

    @Test
    void whenGetPlacesOk_thenStatus200() throws Exception {

        mockMvc.perform(get("/api/v1/places")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(placeService, times(1)).getAllPlaces();
    }
}
