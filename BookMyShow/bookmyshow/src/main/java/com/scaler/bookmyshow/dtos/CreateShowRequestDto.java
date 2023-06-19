package com.scaler.bookmyshow.dtos;

import java.util.Date;

public class CreateShowRequestDto {
    private Date startTime;
    private Date endTime;
    private Long movieId;
    private Long auditoriumId;
    private Long featureId;
    private double price;
}
