package com.coffeemeetsbagel.models.dto;

import com.coffeemeetsbagel.models.entities.ProfileEntity;
import kotlin.jvm.internal.j;

public final class ProfileDataContractKt {
    public static final ProfileEntity toRoomEntity(ProfileDataContract profileDataContract) {
        j.g(profileDataContract, "<this>");
        return new ProfileEntity(profileDataContract.getId(), profileDataContract.getAge(), profileDataContract.getCity(), profileDataContract.getCountry(), profileDataContract.getEducation(), profileDataContract.getEmployer(), profileDataContract.getEthnicities(), profileDataContract.getFirstName(), profileDataContract.getGender(), profileDataContract.getHeight(), profileDataContract.getLastName(), profileDataContract.getOccupation(), profileDataContract.getReligion(), profileDataContract.getSecondaryEducation(), profileDataContract.getState());
    }
}
