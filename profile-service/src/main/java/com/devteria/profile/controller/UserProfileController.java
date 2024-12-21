package com.devteria.profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.service.UserProfileServie;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/users")
public class UserProfileController {
    UserProfileServie userProfileService;

    @GetMapping("/{profileId}")
    public UserProfileResponse getMethodName(@PathVariable String profileId) {
        return userProfileService.getProfile(profileId);
    }
}
