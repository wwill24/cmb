package org.jivesoftware.smackx.muc;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.EntityBareJid;

public class RoomInfo {
    private static final Logger LOGGER = Logger.getLogger(RoomInfo.class.getName());
    private final List<EntityBareJid> contactJid;
    private final String description;
    private final DataForm form;
    private final String lang;
    private final String ldapgroup;
    private final URL logs;
    private final int maxhistoryfetch;
    private final boolean membersOnly;
    private final boolean moderated;
    private final String name;
    private final boolean nonanonymous;
    private final int occupantsCount;
    private final boolean passwordProtected;
    private final boolean persistent;
    private final String pubsub;
    private final EntityBareJid room;
    private final String subject;
    private final Boolean subjectmod;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.util.List<org.jxmpp.jid.EntityBareJid>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.util.List<org.jxmpp.jid.EntityBareJid>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.List<org.jxmpp.jid.EntityBareJid>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.util.List<org.jxmpp.jid.EntityBareJid>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.List<org.jxmpp.jid.EntityBareJid>} */
    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    RoomInfo(org.jivesoftware.smackx.disco.packet.DiscoverInfo r13) {
        /*
            r12 = this;
            r12.<init>()
            org.jxmpp.jid.Jid r0 = r13.getFrom()
            r1 = 0
            if (r0 == 0) goto L_0x0015
            org.jxmpp.jid.Jid r0 = r13.getFrom()
            org.jxmpp.jid.EntityBareJid r0 = r0.h1()
            r12.room = r0
            goto L_0x0017
        L_0x0015:
            r12.room = r1
        L_0x0017:
            java.lang.String r0 = "muc_membersonly"
            boolean r0 = r13.containsFeature(r0)
            r12.membersOnly = r0
            java.lang.String r0 = "muc_moderated"
            boolean r0 = r13.containsFeature(r0)
            r12.moderated = r0
            java.lang.String r0 = "muc_nonanonymous"
            boolean r0 = r13.containsFeature(r0)
            r12.nonanonymous = r0
            java.lang.String r0 = "muc_passwordprotected"
            boolean r0 = r13.containsFeature(r0)
            r12.passwordProtected = r0
            java.lang.String r0 = "muc_persistent"
            boolean r0 = r13.containsFeature(r0)
            r12.persistent = r0
            java.util.List r0 = r13.getIdentities()
            boolean r2 = r0.isEmpty()
            r3 = 0
            java.lang.String r4 = ""
            if (r2 != 0) goto L_0x0059
            java.lang.Object r0 = r0.get(r3)
            org.jivesoftware.smackx.disco.packet.DiscoverInfo$Identity r0 = (org.jivesoftware.smackx.disco.packet.DiscoverInfo.Identity) r0
            java.lang.String r0 = r0.getName()
            r12.name = r0
            goto L_0x0075
        L_0x0059:
            java.util.logging.Logger r0 = LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "DiscoverInfo does not contain any Identity: "
            r2.append(r5)
            java.lang.CharSequence r5 = r13.toXML()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.warning(r2)
            r12.name = r4
        L_0x0075:
            org.jivesoftware.smackx.xdata.packet.DataForm r13 = org.jivesoftware.smackx.xdata.packet.DataForm.from(r13)
            r12.form = r13
            r0 = -1
            if (r13 == 0) goto L_0x01a5
            java.lang.String r2 = "muc#roominfo_description"
            org.jivesoftware.smackx.xdata.FormField r2 = r13.getField(r2)
            if (r2 == 0) goto L_0x0095
            java.util.List r5 = r2.getValues()
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0095
            java.lang.String r2 = r2.getFirstValue()
            goto L_0x0096
        L_0x0095:
            r2 = r4
        L_0x0096:
            java.lang.String r5 = "muc#roominfo_subject"
            org.jivesoftware.smackx.xdata.FormField r5 = r13.getField(r5)
            if (r5 == 0) goto L_0x00ac
            java.util.List r6 = r5.getValues()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x00ac
            java.lang.String r4 = r5.getFirstValue()
        L_0x00ac:
            java.lang.String r5 = "muc#roominfo_occupants"
            org.jivesoftware.smackx.xdata.FormField r5 = r13.getField(r5)
            if (r5 == 0) goto L_0x00c7
            java.util.List r6 = r5.getValues()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x00c7
            java.lang.String r5 = r5.getFirstValue()
            int r5 = java.lang.Integer.parseInt(r5)
            goto L_0x00c8
        L_0x00c7:
            r5 = r0
        L_0x00c8:
            java.lang.String r6 = "muc#maxhistoryfetch"
            org.jivesoftware.smackx.xdata.FormField r6 = r13.getField(r6)
            if (r6 == 0) goto L_0x00e2
            java.util.List r7 = r6.getValues()
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x00e2
            java.lang.String r0 = r6.getFirstValue()
            int r0 = java.lang.Integer.parseInt(r0)
        L_0x00e2:
            java.lang.String r6 = "muc#roominfo_contactjid"
            org.jivesoftware.smackx.xdata.FormField r6 = r13.getField(r6)
            if (r6 == 0) goto L_0x0101
            java.util.List r7 = r6.getValues()
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0101
            java.util.List r6 = r6.getValues()
            java.util.Set r6 = im.a.d(r6)
            java.util.List r6 = im.a.c(r6)
            goto L_0x0102
        L_0x0101:
            r6 = r1
        L_0x0102:
            java.lang.String r7 = "muc#roominfo_lang"
            org.jivesoftware.smackx.xdata.FormField r7 = r13.getField(r7)
            if (r7 == 0) goto L_0x0119
            java.util.List r8 = r7.getValues()
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0119
            java.lang.String r7 = r7.getFirstValue()
            goto L_0x011a
        L_0x0119:
            r7 = r1
        L_0x011a:
            java.lang.String r8 = "muc#roominfo_ldapgroup"
            org.jivesoftware.smackx.xdata.FormField r8 = r13.getField(r8)
            if (r8 == 0) goto L_0x0131
            java.util.List r9 = r8.getValues()
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x0131
            java.lang.String r8 = r8.getFirstValue()
            goto L_0x0132
        L_0x0131:
            r8 = r1
        L_0x0132:
            java.lang.String r9 = "muc#roominfo_subjectmod"
            org.jivesoftware.smackx.xdata.FormField r9 = r13.getField(r9)
            if (r9 == 0) goto L_0x015e
            java.util.List r10 = r9.getValues()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x015e
            java.lang.String r9 = r9.getFirstValue()
            java.lang.String r10 = "true"
            boolean r10 = r10.equals(r9)
            if (r10 != 0) goto L_0x0158
            java.lang.String r10 = "1"
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x0159
        L_0x0158:
            r3 = 1
        L_0x0159:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x015f
        L_0x015e:
            r3 = r1
        L_0x015f:
            java.lang.String r9 = "muc#roominfo_logs"
            org.jivesoftware.smackx.xdata.FormField r13 = r13.getField(r9)
            if (r13 == 0) goto L_0x0185
            java.util.List r9 = r13.getValues()
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x0185
            java.lang.String r13 = r13.getFirstValue()
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x017b }
            r9.<init>(r13)     // Catch:{ MalformedURLException -> 0x017b }
            goto L_0x0186
        L_0x017b:
            r13 = move-exception
            java.util.logging.Logger r9 = LOGGER
            java.util.logging.Level r10 = java.util.logging.Level.SEVERE
            java.lang.String r11 = "Could not parse URL"
            r9.log(r10, r11, r13)
        L_0x0185:
            r9 = r1
        L_0x0186:
            org.jivesoftware.smackx.xdata.packet.DataForm r13 = r12.form
            java.lang.String r10 = "muc#roominfo_pubsub"
            org.jivesoftware.smackx.xdata.FormField r13 = r13.getField(r10)
            if (r13 == 0) goto L_0x019e
            java.util.List r10 = r13.getValues()
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x019e
            java.lang.String r1 = r13.getFirstValue()
        L_0x019e:
            r13 = r0
            r0 = r5
            r5 = r4
            r4 = r2
            r2 = r1
            r1 = r6
            goto L_0x01ac
        L_0x01a5:
            r13 = r0
            r2 = r1
            r3 = r2
            r7 = r3
            r8 = r7
            r9 = r8
            r5 = r4
        L_0x01ac:
            r12.description = r4
            r12.subject = r5
            r12.occupantsCount = r0
            r12.maxhistoryfetch = r13
            r12.contactJid = r1
            r12.lang = r7
            r12.ldapgroup = r8
            r12.subjectmod = r3
            r12.logs = r9
            r12.pubsub = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smackx.muc.RoomInfo.<init>(org.jivesoftware.smackx.disco.packet.DiscoverInfo):void");
    }

    public List<EntityBareJid> getContactJids() {
        return Collections.unmodifiableList(this.contactJid);
    }

    public String getDescription() {
        return this.description;
    }

    public DataForm getForm() {
        return this.form;
    }

    public String getLang() {
        return this.lang;
    }

    public String getLdapGroup() {
        return this.ldapgroup;
    }

    public URL getLogsUrl() {
        return this.logs;
    }

    public int getMaxHistoryFetch() {
        return this.maxhistoryfetch;
    }

    public String getName() {
        return this.name;
    }

    public int getOccupantsCount() {
        return this.occupantsCount;
    }

    public String getPubSub() {
        return this.pubsub;
    }

    public EntityBareJid getRoom() {
        return this.room;
    }

    public String getSubject() {
        return this.subject;
    }

    public boolean isMembersOnly() {
        return this.membersOnly;
    }

    public boolean isModerated() {
        return this.moderated;
    }

    public boolean isNonanonymous() {
        return this.nonanonymous;
    }

    public boolean isPasswordProtected() {
        return this.passwordProtected;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public Boolean isSubjectModifiable() {
        return this.subjectmod;
    }
}
