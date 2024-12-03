package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import java.util.Objects;

public class RisingGiveTake implements Model, GiveTakeBase {
    public static final int ACTION_LIKED = 1;
    private int action;
    private String endDate;
    private boolean given;

    /* renamed from: id  reason: collision with root package name */
    private String f34712id;
    private boolean isBlocked;
    private int pairBagelType;
    private String pairLikeComment;
    private NetworkProfile profile;
    private String profileId;
    private boolean shown;
    private String startDate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f34712id, ((RisingGiveTake) obj).f34712id);
    }

    public int getAction() {
        return this.action;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getId() {
        return this.f34712id;
    }

    public int getPairBagelType() {
        return this.pairBagelType;
    }

    public String getPairLikeComment() {
        return this.pairLikeComment;
    }

    public NetworkProfile getProfile() {
        return this.profile;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f34712id});
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isGiven() {
        return this.given;
    }

    public boolean isShown() {
        return this.shown;
    }

    public void setAction(int i10) {
        this.action = i10;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setGiven(boolean z10) {
        this.given = z10;
    }

    public void setId(String str) {
        this.f34712id = str;
    }

    public void setPairBagelType(int i10) {
        this.pairBagelType = i10;
    }

    public void setPairLikeComment(String str) {
        this.pairLikeComment = str;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public void setShown(boolean z10) {
        this.shown = z10;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public void setUserProfile(NetworkProfile networkProfile) {
        this.profile = networkProfile;
    }
}
