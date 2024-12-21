package com.devteria.profile.dto.response;

import java.time.LocalDate;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserProfileResponse {
    String id;
    String firstName;
    String lastName;
    LocalDate dob;
    String city;
}
