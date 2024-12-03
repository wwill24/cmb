package org.jivesoftware.smackx.bookmarks;

import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.parts.Resourcepart;

public class BookmarkedConference implements SharedBookmark {
    private boolean autoJoin;
    private boolean isShared;
    private final EntityBareJid jid;
    private String name;
    private Resourcepart nickname;
    private String password;

    protected BookmarkedConference(EntityBareJid entityBareJid) {
        this.jid = entityBareJid;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BookmarkedConference)) {
            return false;
        }
        return ((BookmarkedConference) obj).getJid().Y(this.jid);
    }

    public EntityBareJid getJid() {
        return this.jid;
    }

    public String getName() {
        return this.name;
    }

    public Resourcepart getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public int hashCode() {
        return getJid().hashCode();
    }

    public boolean isAutoJoin() {
        return this.autoJoin;
    }

    public boolean isShared() {
        return this.isShared;
    }

    /* access modifiers changed from: protected */
    public void setAutoJoin(boolean z10) {
        this.autoJoin = z10;
    }

    /* access modifiers changed from: protected */
    public void setName(String str) {
        this.name = str;
    }

    /* access modifiers changed from: protected */
    public void setNickname(Resourcepart resourcepart) {
        this.nickname = resourcepart;
    }

    /* access modifiers changed from: protected */
    public void setPassword(String str) {
        this.password = str;
    }

    /* access modifiers changed from: protected */
    public void setShared(boolean z10) {
        this.isShared = z10;
    }

    protected BookmarkedConference(String str, EntityBareJid entityBareJid, boolean z10, Resourcepart resourcepart, String str2) {
        this.name = str;
        this.jid = entityBareJid;
        this.autoJoin = z10;
        this.nickname = resourcepart;
        this.password = str2;
    }
}
