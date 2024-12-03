package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.enums.UpgradeAvailability;

public class ResponseLogin extends ResponseGeneric {
    private String errorRedirectLink;
    private String profileId;
    private UpgradeAvailability upgradeAvailable;

    public ResponseLogin(String str, int i10) {
        setErrorMessage(str);
        setStatusCode(i10);
    }

    public String getErrorRedirectLink() {
        return this.errorRedirectLink;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public UpgradeAvailability getUpgradeAvailable() {
        return this.upgradeAvailable;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public String toString() {
        return "Profile ID: " + this.profileId + "\nUpgrade Available : " + this.upgradeAvailable.name() + "\nSuccess: " + isSuccessful();
    }

    public ResponseLogin(int i10, String str) {
        setErrorMessage(str);
        setErrorCode(i10);
        setSuccess(false);
        if (i10 == 3) {
            this.errorRedirectLink = str;
        }
    }
}
