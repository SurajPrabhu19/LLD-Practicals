package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.models.MainShow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShowResponseDto {
    private MainShow show;
}
