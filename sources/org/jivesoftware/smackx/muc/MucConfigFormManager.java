package org.jivesoftware.smackx.muc;

import im.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jxmpp.jid.Jid;
import org.jxmpp.stringprep.XmppStringprepException;

public class MucConfigFormManager {
    public static final String FORM_TYPE = "http://jabber.org/protocol/muc#roomconfig";
    private static final String HASH_ROOMCONFIG = "#roomconfig";
    public static final String MUC_ROOMCONFIG_MEMBERSONLY = "muc#roomconfig_membersonly";
    public static final String MUC_ROOMCONFIG_PASSWORDPROTECTEDROOM = "muc#roomconfig_passwordprotectedroom";
    public static final String MUC_ROOMCONFIG_ROOMOWNERS = "muc#roomconfig_roomowners";
    public static final String MUC_ROOMCONFIG_ROOMSECRET = "muc#roomconfig_roomsecret";
    private final FillableForm answerForm;
    private final MultiUserChat multiUserChat;
    private final List<Jid> owners;

    MucConfigFormManager(MultiUserChat multiUserChat2) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        this.multiUserChat = multiUserChat2;
        FillableForm fillableForm = multiUserChat2.getConfigurationForm().getFillableForm();
        this.answerForm = fillableForm;
        FormField field = fillableForm.getDataForm().getField(MUC_ROOMCONFIG_ROOMOWNERS);
        if (field != null) {
            List<? extends CharSequence> values = field.getValues();
            ArrayList arrayList = new ArrayList(values.size());
            this.owners = arrayList;
            a.e(values, arrayList, (List<XmppStringprepException>) null);
            return;
        }
        this.owners = null;
    }

    public MucConfigFormManager makeMembersOnly() throws MultiUserChatException.MucConfigurationNotSupportedException {
        return setMembersOnly(true);
    }

    public MucConfigFormManager makePasswordProtected() throws MultiUserChatException.MucConfigurationNotSupportedException {
        return setIsPasswordProtected(true);
    }

    public MucConfigFormManager setAndEnablePassword(String str) throws MultiUserChatException.MucConfigurationNotSupportedException {
        return setIsPasswordProtected(true).setRoomSecret(str);
    }

    public MucConfigFormManager setIsPasswordProtected(boolean z10) throws MultiUserChatException.MucConfigurationNotSupportedException {
        if (supportsMembersOnly()) {
            this.answerForm.setAnswer(MUC_ROOMCONFIG_PASSWORDPROTECTEDROOM, z10);
            return this;
        }
        throw new MultiUserChatException.MucConfigurationNotSupportedException(MUC_ROOMCONFIG_PASSWORDPROTECTEDROOM);
    }

    public MucConfigFormManager setMembersOnly(boolean z10) throws MultiUserChatException.MucConfigurationNotSupportedException {
        if (supportsMembersOnly()) {
            this.answerForm.setAnswer(MUC_ROOMCONFIG_MEMBERSONLY, z10);
            return this;
        }
        throw new MultiUserChatException.MucConfigurationNotSupportedException(MUC_ROOMCONFIG_MEMBERSONLY);
    }

    public MucConfigFormManager setRoomOwners(Collection<? extends Jid> collection) throws MultiUserChatException.MucConfigurationNotSupportedException {
        if (supportsRoomOwners()) {
            this.owners.clear();
            this.owners.addAll(collection);
            return this;
        }
        throw new MultiUserChatException.MucConfigurationNotSupportedException(MUC_ROOMCONFIG_ROOMOWNERS);
    }

    public MucConfigFormManager setRoomSecret(String str) throws MultiUserChatException.MucConfigurationNotSupportedException {
        if (this.answerForm.hasField(MUC_ROOMCONFIG_ROOMSECRET)) {
            this.answerForm.setAnswer(MUC_ROOMCONFIG_ROOMSECRET, (CharSequence) str);
            return this;
        }
        throw new MultiUserChatException.MucConfigurationNotSupportedException(MUC_ROOMCONFIG_ROOMSECRET);
    }

    public void submitConfigurationForm() throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        List<Jid> list = this.owners;
        if (list != null) {
            this.answerForm.setAnswer(MUC_ROOMCONFIG_ROOMOWNERS, (Collection<? extends CharSequence>) a.f(list));
        }
        this.multiUserChat.sendConfigurationForm(this.answerForm);
    }

    public boolean supportsMembersOnly() {
        return this.answerForm.hasField(MUC_ROOMCONFIG_MEMBERSONLY);
    }

    public boolean supportsPasswordProtected() {
        return this.answerForm.hasField(MUC_ROOMCONFIG_PASSWORDPROTECTEDROOM);
    }

    public boolean supportsRoomOwners() {
        return this.owners != null;
    }
}
