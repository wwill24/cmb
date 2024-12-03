package com.coffeemeetsbagel.models.dto;

import com.coffeemeetsbagel.models.entities.EthnicityType;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.models.entities.Height;
import com.coffeemeetsbagel.models.entities.ProfileEducationEntity;
import com.coffeemeetsbagel.models.entities.ReligionType;
import java.util.List;

public interface ProfileDataContract {
    int getAge();

    String getCity();

    String getCountry();

    ProfileEducationEntity getEducation();

    String getEmployer();

    List<EthnicityType> getEthnicities();

    String getFirstName();

    GenderType getGender();

    Height getHeight();

    String getId();

    String getLastName();

    String getOccupation();

    ReligionType getReligion();

    ProfileEducationEntity getSecondaryEducation();

    String getState();
}
