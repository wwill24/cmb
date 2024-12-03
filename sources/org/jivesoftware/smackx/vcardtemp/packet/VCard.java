package org.jivesoftware.smackx.vcardtemp.packet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.vcardtemp.VCardManager;
import org.jxmpp.jid.EntityBareJid;

public final class VCard extends IQ {
    private static final String DEFAULT_MIME_TYPE = "image/jpeg";
    public static final String ELEMENT = "vCard";
    private static final Logger LOGGER = Logger.getLogger(VCard.class.getName());
    public static final String NAMESPACE = "vcard-temp";
    private String emailHome;
    private String emailWork;
    private String firstName;
    private final Map<String, String> homeAddr = new HashMap();
    private final Map<String, String> homePhones = new HashMap();
    private String lastName;
    private String middleName;
    private String organization;
    private String organizationUnit;
    private final Map<String, String> otherSimpleFields = new HashMap();
    private final Map<String, String> otherUnescapableFields = new HashMap();
    private String photoBinval;
    private String photoMimeType;
    private String prefix;
    private String suffix;
    private final Map<String, String> workAddr = new HashMap();
    private final Map<String, String> workPhones = new HashMap();

    public VCard() {
        super("vCard", "vcard-temp");
    }

    private void copyFieldsFrom(VCard vCard) {
        Class<VCard> cls = VCard.class;
        for (Field field : cls.getDeclaredFields()) {
            if (field.getDeclaringClass() == cls && !Modifier.isFinal(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    field.set(this, field.get(vCard));
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException("This cannot happen:" + field, e10);
                }
            }
        }
    }

    public static byte[] getBytes(URL url) throws IOException {
        File file = new File(url.getPath());
        if (file.exists()) {
            return getFileBytes(file);
        }
        return null;
    }

    private static byte[] getFileBytes(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            if (bufferedInputStream.read(bArr) == length) {
                bufferedInputStream.close();
                return bArr;
            }
            throw new IOException("Entire file not read");
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private boolean hasContent() {
        if (hasNameField() || hasOrganizationFields() || this.emailHome != null || this.emailWork != null || this.otherSimpleFields.size() > 0 || this.otherUnescapableFields.size() > 0 || this.homeAddr.size() > 0 || this.homePhones.size() > 0 || this.workAddr.size() > 0 || this.workPhones.size() > 0 || this.photoBinval != null) {
            return true;
        }
        return false;
    }

    private boolean hasNameField() {
        return (this.firstName == null && this.lastName == null && this.middleName == null && this.prefix == null && this.suffix == null) ? false : true;
    }

    private boolean hasOrganizationFields() {
        return (this.organization == null && this.organizationUnit == null) ? false : true;
    }

    private void updateFN() {
        StringBuilder sb2 = new StringBuilder();
        String str = this.firstName;
        if (str != null) {
            sb2.append(StringUtils.escapeForXml(str));
            sb2.append(' ');
        }
        String str2 = this.middleName;
        if (str2 != null) {
            sb2.append(StringUtils.escapeForXml(str2));
            sb2.append(' ');
        }
        String str3 = this.lastName;
        if (str3 != null) {
            sb2.append(StringUtils.escapeForXml(str3));
        }
        setField("FN", sb2.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || VCard.class != obj.getClass()) {
            return false;
        }
        VCard vCard = (VCard) obj;
        String str = this.emailHome;
        if (str == null ? vCard.emailHome != null : !str.equals(vCard.emailHome)) {
            return false;
        }
        String str2 = this.emailWork;
        if (str2 == null ? vCard.emailWork != null : !str2.equals(vCard.emailWork)) {
            return false;
        }
        String str3 = this.firstName;
        if (str3 == null ? vCard.firstName != null : !str3.equals(vCard.firstName)) {
            return false;
        }
        if (!this.homeAddr.equals(vCard.homeAddr) || !this.homePhones.equals(vCard.homePhones)) {
            return false;
        }
        String str4 = this.lastName;
        if (str4 == null ? vCard.lastName != null : !str4.equals(vCard.lastName)) {
            return false;
        }
        String str5 = this.middleName;
        if (str5 == null ? vCard.middleName != null : !str5.equals(vCard.middleName)) {
            return false;
        }
        String str6 = this.organization;
        if (str6 == null ? vCard.organization != null : !str6.equals(vCard.organization)) {
            return false;
        }
        String str7 = this.organizationUnit;
        if (str7 == null ? vCard.organizationUnit != null : !str7.equals(vCard.organizationUnit)) {
            return false;
        }
        if (!this.otherSimpleFields.equals(vCard.otherSimpleFields) || !this.workAddr.equals(vCard.workAddr)) {
            return false;
        }
        String str8 = this.photoBinval;
        if (str8 == null ? vCard.photoBinval == null : str8.equals(vCard.photoBinval)) {
            return this.workPhones.equals(vCard.workPhones);
        }
        return false;
    }

    public String getAddressFieldHome(String str) {
        return this.homeAddr.get(str);
    }

    public String getAddressFieldWork(String str) {
        return this.workAddr.get(str);
    }

    public byte[] getAvatar() {
        String str = this.photoBinval;
        if (str == null) {
            return null;
        }
        return Base64.decode(str);
    }

    public String getAvatarHash() {
        byte[] avatar = getAvatar();
        if (avatar == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(avatar);
            return StringUtils.encodeHex(instance.digest());
        } catch (NoSuchAlgorithmException e10) {
            LOGGER.log(Level.SEVERE, "Failed to get message digest", e10);
            return null;
        }
    }

    public String getAvatarMimeType() {
        return this.photoMimeType;
    }

    public String getEmailHome() {
        return this.emailHome;
    }

    public String getEmailWork() {
        return this.emailWork;
    }

    public String getField(String str) {
        return this.otherSimpleFields.get(str);
    }

    public String getFirstName() {
        return this.firstName;
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (!hasContent()) {
            iQChildElementXmlStringBuilder.setEmptyElement();
            return iQChildElementXmlStringBuilder;
        }
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (hasNameField()) {
            iQChildElementXmlStringBuilder.openElement("N");
            iQChildElementXmlStringBuilder.optElement("FAMILY", this.lastName);
            iQChildElementXmlStringBuilder.optElement("GIVEN", this.firstName);
            iQChildElementXmlStringBuilder.optElement("MIDDLE", this.middleName);
            iQChildElementXmlStringBuilder.optElement("PREFIX", this.prefix);
            iQChildElementXmlStringBuilder.optElement("SUFFIX", this.suffix);
            iQChildElementXmlStringBuilder.closeElement("N");
        }
        if (hasOrganizationFields()) {
            iQChildElementXmlStringBuilder.openElement("ORG");
            iQChildElementXmlStringBuilder.optElement("ORGNAME", this.organization);
            iQChildElementXmlStringBuilder.optElement("ORGUNIT", this.organizationUnit);
            iQChildElementXmlStringBuilder.closeElement("ORG");
        }
        for (Map.Entry next : this.otherSimpleFields.entrySet()) {
            iQChildElementXmlStringBuilder.optElement((String) next.getKey(), (String) next.getValue());
        }
        for (Map.Entry next2 : this.otherUnescapableFields.entrySet()) {
            String str = (String) next2.getValue();
            if (str != null) {
                iQChildElementXmlStringBuilder.openElement((String) next2.getKey());
                iQChildElementXmlStringBuilder.append((CharSequence) str);
                iQChildElementXmlStringBuilder.closeElement((String) next2.getKey());
            }
        }
        if (this.photoBinval != null) {
            iQChildElementXmlStringBuilder.openElement("PHOTO");
            iQChildElementXmlStringBuilder.escapedElement("BINVAL", this.photoBinval);
            iQChildElementXmlStringBuilder.element("TYPE", this.photoMimeType);
            iQChildElementXmlStringBuilder.closeElement("PHOTO");
        }
        if (this.emailWork != null) {
            iQChildElementXmlStringBuilder.openElement("EMAIL");
            iQChildElementXmlStringBuilder.emptyElement("WORK");
            iQChildElementXmlStringBuilder.emptyElement("INTERNET");
            iQChildElementXmlStringBuilder.emptyElement("PREF");
            iQChildElementXmlStringBuilder.element("USERID", this.emailWork);
            iQChildElementXmlStringBuilder.closeElement("EMAIL");
        }
        if (this.emailHome != null) {
            iQChildElementXmlStringBuilder.openElement("EMAIL");
            iQChildElementXmlStringBuilder.emptyElement("HOME");
            iQChildElementXmlStringBuilder.emptyElement("INTERNET");
            iQChildElementXmlStringBuilder.emptyElement("PREF");
            iQChildElementXmlStringBuilder.element("USERID", this.emailHome);
            iQChildElementXmlStringBuilder.closeElement("EMAIL");
        }
        for (Map.Entry next3 : this.workPhones.entrySet()) {
            String str2 = (String) next3.getValue();
            if (str2 != null) {
                iQChildElementXmlStringBuilder.openElement("TEL");
                iQChildElementXmlStringBuilder.emptyElement("WORK");
                iQChildElementXmlStringBuilder.emptyElement((String) next3.getKey());
                iQChildElementXmlStringBuilder.element("NUMBER", str2);
                iQChildElementXmlStringBuilder.closeElement("TEL");
            }
        }
        for (Map.Entry next4 : this.homePhones.entrySet()) {
            String str3 = (String) next4.getValue();
            if (str3 != null) {
                iQChildElementXmlStringBuilder.openElement("TEL");
                iQChildElementXmlStringBuilder.emptyElement("HOME");
                iQChildElementXmlStringBuilder.emptyElement((String) next4.getKey());
                iQChildElementXmlStringBuilder.element("NUMBER", str3);
                iQChildElementXmlStringBuilder.closeElement("TEL");
            }
        }
        if (!this.workAddr.isEmpty()) {
            iQChildElementXmlStringBuilder.openElement("ADR");
            iQChildElementXmlStringBuilder.emptyElement("WORK");
            for (Map.Entry next5 : this.workAddr.entrySet()) {
                String str4 = (String) next5.getValue();
                if (str4 != null) {
                    iQChildElementXmlStringBuilder.element((String) next5.getKey(), str4);
                }
            }
            iQChildElementXmlStringBuilder.closeElement("ADR");
        }
        if (!this.homeAddr.isEmpty()) {
            iQChildElementXmlStringBuilder.openElement("ADR");
            iQChildElementXmlStringBuilder.emptyElement("HOME");
            for (Map.Entry next6 : this.homeAddr.entrySet()) {
                String str5 = (String) next6.getValue();
                if (str5 != null) {
                    iQChildElementXmlStringBuilder.element((String) next6.getKey(), str5);
                }
            }
            iQChildElementXmlStringBuilder.closeElement("ADR");
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getJabberId() {
        return this.otherSimpleFields.get("JABBERID");
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getNickName() {
        return this.otherSimpleFields.get("NICKNAME");
    }

    public String getOrganization() {
        return this.organization;
    }

    public String getOrganizationUnit() {
        return this.organizationUnit;
    }

    public String getPhoneHome(String str) {
        return this.homePhones.get(str);
    }

    public String getPhoneWork(String str) {
        return this.workPhones.get(str);
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int hashCode = ((((((this.homePhones.hashCode() * 29) + this.workPhones.hashCode()) * 29) + this.homeAddr.hashCode()) * 29) + this.workAddr.hashCode()) * 29;
        String str = this.firstName;
        int i17 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i18 = (hashCode + i10) * 29;
        String str2 = this.lastName;
        if (str2 != null) {
            i11 = str2.hashCode();
        } else {
            i11 = 0;
        }
        int i19 = (i18 + i11) * 29;
        String str3 = this.middleName;
        if (str3 != null) {
            i12 = str3.hashCode();
        } else {
            i12 = 0;
        }
        int i20 = (i19 + i12) * 29;
        String str4 = this.emailHome;
        if (str4 != null) {
            i13 = str4.hashCode();
        } else {
            i13 = 0;
        }
        int i21 = (i20 + i13) * 29;
        String str5 = this.emailWork;
        if (str5 != null) {
            i14 = str5.hashCode();
        } else {
            i14 = 0;
        }
        int i22 = (i21 + i14) * 29;
        String str6 = this.organization;
        if (str6 != null) {
            i15 = str6.hashCode();
        } else {
            i15 = 0;
        }
        int i23 = (i22 + i15) * 29;
        String str7 = this.organizationUnit;
        if (str7 != null) {
            i16 = str7.hashCode();
        } else {
            i16 = 0;
        }
        int hashCode2 = (((i23 + i16) * 29) + this.otherSimpleFields.hashCode()) * 29;
        String str8 = this.photoBinval;
        if (str8 != null) {
            i17 = str8.hashCode();
        }
        return hashCode2 + i17;
    }

    @Deprecated
    public void load(XMPPConnection xMPPConnection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        load(xMPPConnection, (EntityBareJid) null);
    }

    public void removeAvatar() {
        this.photoBinval = null;
        this.photoMimeType = null;
    }

    @Deprecated
    public void save(XMPPConnection xMPPConnection) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        VCardManager.getInstanceFor(xMPPConnection).saveVCard(this);
    }

    public void setAddressFieldHome(String str, String str2) {
        this.homeAddr.put(str, str2);
    }

    public void setAddressFieldWork(String str, String str2) {
        this.workAddr.put(str, str2);
    }

    public void setAvatar(URL url) {
        byte[] bArr = new byte[0];
        try {
            bArr = getBytes(url);
        } catch (IOException e10) {
            Logger logger = LOGGER;
            Level level = Level.SEVERE;
            logger.log(level, "Error getting bytes from URL: " + url, e10);
        }
        setAvatar(bArr);
    }

    public void setEmailHome(String str) {
        this.emailHome = str;
    }

    public void setEmailWork(String str) {
        this.emailWork = str;
    }

    @Deprecated
    public void setEncodedImage(String str) {
        setAvatar(str, DEFAULT_MIME_TYPE);
    }

    public void setField(String str, String str2) {
        setField(str, str2, false);
    }

    public void setFirstName(String str) {
        this.firstName = str;
        updateFN();
    }

    public void setJabberId(CharSequence charSequence) {
        this.otherSimpleFields.put("JABBERID", charSequence.toString());
    }

    public void setLastName(String str) {
        this.lastName = str;
        updateFN();
    }

    public void setMiddleName(String str) {
        this.middleName = str;
        updateFN();
    }

    public void setNickName(String str) {
        this.otherSimpleFields.put("NICKNAME", str);
    }

    public void setOrganization(String str) {
        this.organization = str;
    }

    public void setOrganizationUnit(String str) {
        this.organizationUnit = str;
    }

    public void setPhoneHome(String str, String str2) {
        this.homePhones.put(str, str2);
    }

    public void setPhoneWork(String str, String str2) {
        this.workPhones.put(str, str2);
    }

    public void setPrefix(String str) {
        this.prefix = str;
        updateFN();
    }

    public void setSuffix(String str) {
        this.suffix = str;
        updateFN();
    }

    @Deprecated
    public void load(XMPPConnection xMPPConnection, EntityBareJid entityBareJid) throws SmackException.NoResponseException, XMPPException.XMPPErrorException, SmackException.NotConnectedException, InterruptedException {
        copyFieldsFrom(VCardManager.getInstanceFor(xMPPConnection).loadVCard(entityBareJid));
    }

    public void setField(String str, String str2, boolean z10) {
        if (!z10) {
            this.otherSimpleFields.put(str, str2);
        } else {
            this.otherUnescapableFields.put(str, str2);
        }
    }

    public void setAvatar(byte[] bArr) {
        setAvatar(bArr, DEFAULT_MIME_TYPE);
    }

    public void setAvatar(byte[] bArr, String str) {
        if (bArr == null) {
            removeAvatar();
        } else {
            setAvatar(Base64.encodeToString(bArr), str);
        }
    }

    public void setAvatar(String str, String str2) {
        this.photoBinval = str;
        this.photoMimeType = str2;
    }
}
