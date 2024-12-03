package org.jivesoftware.smack.sasl.core;

import com.mparticle.kits.AppsFlyerKit;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.security.auth.callback.CallbackHandler;
import mm.a;
import net.bytebuddy.asm.Advice;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;
import org.jivesoftware.smack.util.SHA1;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jxmpp.util.cache.LruCache;

public abstract class ScramMechanism extends SASLMechanism {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final a<String, Keys> CACHE = new LruCache(10);
    private static final byte[] CLIENT_KEY_BYTES = SASLMechanism.toBytes("Client Key");
    private static final byte[] ONE = {0, 0, 0, 1};
    private static final int RANDOM_ASCII_BYTE_COUNT = 32;
    private static final ThreadLocal<SecureRandom> SECURE_RANDOM = new ThreadLocal<SecureRandom>() {
        /* access modifiers changed from: protected */
        public SecureRandom initialValue() {
            return new SecureRandom();
        }
    };
    private static final byte[] SERVER_KEY_BYTES = SASLMechanism.toBytes("Server Key");
    private String clientFirstMessageBare;
    private String clientRandomAscii;
    private final ScramHmac scramHmac;
    private byte[] serverSignature;
    private State state = State.INITIAL;

    /* renamed from: org.jivesoftware.smack.sasl.core.ScramMechanism$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$sasl$core$ScramMechanism$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.sasl.core.ScramMechanism$State[] r0 = org.jivesoftware.smack.sasl.core.ScramMechanism.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$sasl$core$ScramMechanism$State = r0
                org.jivesoftware.smack.sasl.core.ScramMechanism$State r1 = org.jivesoftware.smack.sasl.core.ScramMechanism.State.AUTH_TEXT_SENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$sasl$core$ScramMechanism$State     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.sasl.core.ScramMechanism$State r1 = org.jivesoftware.smack.sasl.core.ScramMechanism.State.RESPONSE_SENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.sasl.core.ScramMechanism.AnonymousClass2.<clinit>():void");
        }
    }

    private static class Keys {
        /* access modifiers changed from: private */
        public final byte[] clientKey;
        /* access modifiers changed from: private */
        public final byte[] serverKey;

        Keys(byte[] bArr, byte[] bArr2) {
            this.clientKey = bArr;
            this.serverKey = bArr2;
        }
    }

    private enum State {
        INITIAL,
        AUTH_TEXT_SENT,
        RESPONSE_SENT,
        VALID_SERVER_RESPONSE
    }

    static {
        Class<ScramMechanism> cls = ScramMechanism.class;
    }

    protected ScramMechanism(ScramHmac scramHmac2) {
        this.scramHmac = scramHmac2;
    }

    private static String escape(String str) {
        StringBuilder sb2 = new StringBuilder((int) (((double) str.length()) * 1.1d));
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt == ',') {
                sb2.append("=2C");
            } else if (charAt != '=') {
                sb2.append(charAt);
            } else {
                sb2.append("=3D");
            }
        }
        return sb2.toString();
    }

    private byte[] getCBindInput() throws SmackException.SmackSaslException {
        byte[] channelBindingData = getChannelBindingData();
        byte[] bytes = SASLMechanism.toBytes(getGS2Header());
        if (channelBindingData == null) {
            return bytes;
        }
        return ByteUtils.concat(bytes, channelBindingData);
    }

    private String getGS2Header() {
        String str;
        if (this.authorizationId != null) {
            str = "a=" + this.authorizationId;
        } else {
            str = "";
        }
        return getGs2CbindFlag() + ',' + str + AppsFlyerKit.COMMA;
    }

    private byte[] hi(String str, byte[] bArr, int i10) throws SmackException.SmackSaslException {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] hmac = hmac(bytes, ByteUtils.concat(bArr, ONE));
        byte[] bArr2 = (byte[]) hmac.clone();
        for (int i11 = 1; i11 < i10; i11++) {
            hmac = hmac(bytes, hmac);
            for (int i12 = 0; i12 < hmac.length; i12++) {
                bArr2[i12] = (byte) (bArr2[i12] ^ hmac[i12]);
            }
        }
        return bArr2;
    }

    private byte[] hmac(byte[] bArr, byte[] bArr2) throws SmackException.SmackSaslException {
        try {
            return this.scramHmac.hmac(bArr, bArr2);
        } catch (InvalidKeyException e10) {
            throw new SmackException.SmackSaslException(getName() + " Exception", e10);
        }
    }

    private static boolean isPrintableNonCommaAsciiChar(char c10) {
        return c10 != ',' && c10 > ' ' && c10 < 127;
    }

    private static Map<Character, String> parseAttributes(String str) throws SmackException.SmackSaslException {
        if (str.length() == 0) {
            return Collections.emptyMap();
        }
        String[] split = str.split(AppsFlyerKit.COMMA);
        HashMap hashMap = new HashMap(split.length, 1.0f);
        int length = split.length;
        int i10 = 0;
        while (i10 < length) {
            String str2 = split[i10];
            if (str2.length() >= 3) {
                char charAt = str2.charAt(0);
                if (str2.charAt(1) == '=') {
                    hashMap.put(Character.valueOf(charAt), str2.substring(2));
                    i10++;
                } else {
                    throw new SmackException.SmackSaslException("Invalid Key-Value pair: " + str2);
                }
            } else {
                throw new SmackException.SmackSaslException("Invalid Key-Value pair: " + str2);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void authenticateInternal(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    public boolean authzidSupported() {
        return true;
    }

    public void checkIfSuccessfulOrThrow() throws SmackException.SmackSaslException {
        if (this.state != State.VALID_SERVER_RESPONSE) {
            throw new SmackException.SmackSaslException("SCRAM-SHA1 is missing valid server response");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] evaluateChallenge(byte[] bArr) throws SmackException.SmackSaslException {
        byte[] bArr2;
        byte[] bArr3;
        String str = new String(bArr, StandardCharsets.UTF_8);
        int i10 = AnonymousClass2.$SwitchMap$org$jivesoftware$smack$sasl$core$ScramMechanism$State[this.state.ordinal()];
        if (i10 == 1) {
            Map<Character, String> parseAttributes = parseAttributes(str);
            String str2 = parseAttributes.get(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL));
            if (str2 == null) {
                throw new SmackException.SmackSaslException("Server random ASCII is null");
            } else if (str2.length() > this.clientRandomAscii.length()) {
                if (str2.substring(0, this.clientRandomAscii.length()).equals(this.clientRandomAscii)) {
                    String str3 = parseAttributes.get('i');
                    if (str3 != null) {
                        try {
                            int parseInt = Integer.parseInt(str3);
                            String str4 = parseAttributes.get(Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL));
                            if (str4 != null) {
                                String str5 = ("c=" + Base64.encodeToString(getCBindInput())) + ",r=" + str2;
                                byte[] bytes = SASLMechanism.toBytes(this.clientFirstMessageBare + ',' + str + ',' + str5);
                                String str6 = this.password + ',' + str4 + ',' + getName();
                                a<String, Keys> aVar = CACHE;
                                Keys a10 = aVar.a(str6);
                                if (a10 == null) {
                                    byte[] hi2 = hi(SASLMechanism.saslPrep(this.password), Base64.decode(str4), parseInt);
                                    bArr3 = hmac(hi2, SERVER_KEY_BYTES);
                                    bArr2 = hmac(hi2, CLIENT_KEY_BYTES);
                                    aVar.put(str6, new Keys(bArr2, bArr3));
                                } else {
                                    bArr3 = a10.serverKey;
                                    bArr2 = a10.clientKey;
                                }
                                this.serverSignature = hmac(bArr3, bytes);
                                byte[] hmac = hmac(SHA1.bytes(bArr2), bytes);
                                int length = bArr2.length;
                                byte[] bArr4 = new byte[length];
                                for (int i11 = 0; i11 < length; i11++) {
                                    bArr4[i11] = (byte) (bArr2[i11] ^ hmac[i11]);
                                }
                                String str7 = str5 + ",p=" + Base64.encodeToString(bArr4);
                                this.state = State.RESPONSE_SENT;
                                return SASLMechanism.toBytes(str7);
                            }
                            throw new SmackException.SmackSaslException("SALT not send");
                        } catch (NumberFormatException e10) {
                            throw new SmackException.SmackSaslException("Exception parsing iterations", e10);
                        }
                    } else {
                        throw new SmackException.SmackSaslException("Iterations attribute not set");
                    }
                } else {
                    throw new SmackException.SmackSaslException("Received client random ASCII does not match client random ASCII");
                }
            } else {
                throw new SmackException.SmackSaslException("Server random ASCII is shorter then client random ASCII");
            }
        } else if (i10 == 2) {
            if (("v=" + Base64.encodeToString(this.serverSignature)).equals(str)) {
                this.state = State.VALID_SERVER_RESPONSE;
                return null;
            }
            throw new SmackException.SmackSaslException("Server final message does not match calculated one");
        } else {
            throw new SmackException.SmackSaslException("Invalid state");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getAuthenticationText() {
        this.clientRandomAscii = getRandomAscii();
        String saslPrep = SASLMechanism.saslPrep(this.authenticationId);
        this.clientFirstMessageBare = "n=" + escape(saslPrep) + ",r=" + this.clientRandomAscii;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getGS2Header());
        sb2.append(this.clientFirstMessageBare);
        String sb3 = sb2.toString();
        this.state = State.AUTH_TEXT_SENT;
        return SASLMechanism.toBytes(sb3);
    }

    /* access modifiers changed from: protected */
    public byte[] getChannelBindingData() throws SmackException.SmackSaslException {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getGs2CbindFlag() {
        if (this.sslSession == null) {
            return "n";
        }
        ConnectionConfiguration connectionConfiguration = this.connectionConfiguration;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getName());
        sb2.append("-PLUS");
        return connectionConfiguration.isEnabledSaslMechanism(sb2.toString()) ? "y" : "n";
    }

    public String getName() {
        return "SCRAM-" + this.scramHmac.getHmacName();
    }

    /* access modifiers changed from: package-private */
    public String getRandomAscii() {
        char[] cArr = new char[32];
        Random random = SECURE_RANDOM.get();
        int i10 = 0;
        while (i10 < 32) {
            char nextInt = (char) random.nextInt(128);
            if (isPrintableNonCommaAsciiChar(nextInt)) {
                cArr[i10] = nextInt;
                i10++;
            }
        }
        return new String(cArr);
    }
}
