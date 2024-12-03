package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import java.io.Serializable;
import java.util.Objects;
import lg.c;

public class GiveTake implements Serializable, Model, GiveTakeBase {
    public static final int ACTION_LIKED = 1;
    private String dateShown;
    private String endDate;

    /* renamed from: id  reason: collision with root package name */
    private String f34707id;
    private boolean isBlocked;
    @c("given")
    private boolean isGiven;
    @c("shown")
    private boolean isShown;
    @c("taken")
    private boolean isTaken;
    private String lastUpdated;
    private NetworkProfile profile;
    private String profileId;
    private String startDate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f34707id, ((GiveTake) obj).f34707id);
    }

    public String getDateShown() {
        return this.dateShown;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getId() {
        return this.f34707id;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
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
        return Objects.hash(new Object[]{this.f34707id});
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isGiven() {
        return this.isGiven;
    }

    public boolean isLiked() {
        return this.isTaken;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public void setDateShown(String str) {
        this.dateShown = str;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setId(String str) {
        this.f34707id = str;
    }

    public void setIsGiven(boolean z10) {
        this.isGiven = z10;
    }

    public void setIsShown(boolean z10) {
        this.isShown = z10;
    }

    public void setIsTaken(boolean z10) {
        this.isTaken = z10;
    }

    public void setLastUpdated(String str) {
        this.lastUpdated = str;
    }

    public void setProfile(NetworkProfile networkProfile) {
        this.profile = networkProfile;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }
}
