package com.coffeemeetsbagel.models;

import java.io.Serializable;
import lg.c;

public class RosterElement implements Serializable, Model {
    @c("group_name")
    private String groupName;
    private String jid;
    @c("profile_id")
    private String profileId;

    public RosterElement() {
    }

    public boolean equals(Object obj) {
        return (obj instanceof RosterElement) && this.jid.equals(((RosterElement) obj).getJid());
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getJid() {
        return this.jid;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setJid(String str) {
        this.jid = str;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public RosterElement(String str, String str2, String str3) {
        this.profileId = str;
        this.jid = str2;
        this.groupName = str3;
    }
}
