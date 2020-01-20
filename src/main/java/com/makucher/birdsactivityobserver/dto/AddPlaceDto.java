package com.makucher.birdsactivityobserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddPlaceDto {
    @NotEmpty
    private String label;
    @NotNull
    private BigDecimal latitude;
    @NotNull
    private BigDecimal longitude;
}
