package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.dto.ProfileDataContract;

public final class ProfileDtoImplementationKt {
    public static final ProfileDtoImplementation profileDtoToImplementation(ProfileDataContract profileDataContract) {
        ProfileDataContract profileDataContract2 = profileDataContract;
        if (profileDataContract2 instanceof ProfileDtoImplementation) {
            return (ProfileDtoImplementation) profileDataContract2;
        }
        if (profileDataContract2 != null) {
            return new ProfileDtoImplementation(profileDataContract.getId(), profileDataContract.getAge(), profileDataContract.getCity(), profileDataContract.getCountry(), profileDataContract.getEducation(), profileDataContract.getEmployer(), profileDataContract.getEthnicities(), profileDataContract.getFirstName(), profileDataContract.getGender(), profileDataContract.getHeight(), profileDataContract.getLastName(), profileDataContract.getOccupation(), profileDataContract.getReligion(), profileDataContract.getSecondaryEducation(), profileDataContract.getState());
        }
        return null;
    }
}
