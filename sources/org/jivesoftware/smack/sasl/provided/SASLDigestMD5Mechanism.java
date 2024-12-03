package org.jivesoftware.smack.sasl.provided;

import com.mparticle.kits.AppsFlyerKit;
import java.nio.charset.StandardCharsets;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.util.ByteUtils;
import org.jivesoftware.smack.util.MD5;
import org.jivesoftware.smack.util.StringUtils;

public class SASLDigestMD5Mechanism extends SASLMechanism {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String INITAL_NONCE = "00000001";
    public static final String NAME = "DIGEST-MD5";
    private static final String QOP_VALUE = "auth";
    private static boolean verifyServerResponse = true;
    private String cnonce;
    private String digestUri;
    private String hex_hashed_a1;
    private String nonce;
    private State state = State.INITIAL;

    /* renamed from: org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism$State[] r0 = org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State = r0
                org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism$State r1 = org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism.State.INITIAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism$State r1 = org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism.State.RESPONSE_SENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.sasl.provided.SASLDigestMD5Mechanism.AnonymousClass1.<clinit>():void");
        }
    }

    private enum DigestType {
        ClientResponse,
        ServerResponse
    }

    private enum State {
        INITIAL,
        RESPONSE_SENT,
        VALID_SERVER_RESPONSE
    }

    static {
        Class<SASLDigestMD5Mechanism> cls = SASLDigestMD5Mechanism.class;
    }

    private String calcResponse(DigestType digestType) {
        StringBuilder sb2 = new StringBuilder();
        if (digestType == DigestType.ClientResponse) {
            sb2.append("AUTHENTICATE");
        }
        sb2.append(':');
        sb2.append(this.digestUri);
        String encodeHex = StringUtils.encodeHex(MD5.bytes(sb2.toString()));
        return StringUtils.encodeHex(MD5.bytes(this.hex_hashed_a1 + ':' + this.nonce + ':' + INITAL_NONCE + ':' + this.cnonce + ':' + "auth" + ':' + encodeHex));
    }

    public static String quoteBackslash(String str) {
        return str.replace("\\", "\\\\");
    }

    public static void setVerifyServerResponse(boolean z10) {
        verifyServerResponse = z10;
    }

    /* access modifiers changed from: protected */
    public void authenticateInternal(CallbackHandler callbackHandler) {
        throw new UnsupportedOperationException("CallbackHandler not (yet) supported");
    }

    public boolean authzidSupported() {
        return true;
    }

    public void checkIfSuccessfulOrThrow() throws SmackException.SmackSaslException {
        if (verifyServerResponse && this.state != State.VALID_SERVER_RESPONSE) {
            throw new SmackException.SmackSaslException("DIGEST-MD5 no valid server response");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] evaluateChallenge(byte[] bArr) throws SmackException.SmackSaslException {
        String str;
        if (bArr.length != 0) {
            String[] split = new String(bArr, StandardCharsets.UTF_8).split(AppsFlyerKit.COMMA);
            int i10 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$sasl$provided$SASLDigestMD5Mechanism$State[this.state.ordinal()];
            if (i10 == 1) {
                int length = split.length;
                int i11 = 0;
                while (true) {
                    String str2 = "";
                    if (i11 < length) {
                        String[] split2 = split[i11].split("=", 2);
                        String replaceFirst = split2[0].replaceFirst("^\\s+", str2);
                        String str3 = split2[1];
                        if ("nonce".equals(replaceFirst)) {
                            if (this.nonce == null) {
                                this.nonce = str3.replace("\"", str2);
                            } else {
                                throw new SmackException.SmackSaslException("Nonce value present multiple times");
                            }
                        } else if ("qop".equals(replaceFirst)) {
                            String replace = str3.replace("\"", str2);
                            if (!replace.equals("auth")) {
                                throw new SmackException.SmackSaslException("Unsupported qop operation: " + replace);
                            }
                        } else {
                            continue;
                        }
                        i11++;
                    } else if (this.nonce != null) {
                        byte[] bytes = MD5.bytes(this.authenticationId + ':' + this.serviceName + ':' + this.password);
                        this.cnonce = StringUtils.randomString(32);
                        byte[] concat = ByteUtils.concat(bytes, SASLMechanism.toBytes(':' + this.nonce + ':' + this.cnonce));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("xmpp/");
                        sb2.append(this.serviceName);
                        this.digestUri = sb2.toString();
                        this.hex_hashed_a1 = StringUtils.encodeHex(MD5.bytes(concat));
                        String calcResponse = calcResponse(DigestType.ClientResponse);
                        if (this.authorizationId != null) {
                            str2 = ",authzid=\"" + this.authorizationId + '\"';
                        }
                        byte[] bytes2 = SASLMechanism.toBytes("username=\"" + quoteBackslash(this.authenticationId) + '\"' + str2 + ",realm=\"" + this.serviceName + '\"' + ",nonce=\"" + this.nonce + '\"' + ",cnonce=\"" + this.cnonce + '\"' + ",nc=" + INITAL_NONCE + ",qop=auth,digest-uri=\"" + this.digestUri + '\"' + ",response=" + calcResponse + ",charset=utf-8");
                        this.state = State.RESPONSE_SENT;
                        return bytes2;
                    } else {
                        throw new SmackException.SmackSaslException("nonce value not present in initial challenge");
                    }
                }
            } else if (i10 == 2) {
                if (verifyServerResponse) {
                    int length2 = split.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length2) {
                            str = null;
                            break;
                        }
                        String[] split3 = split[i12].split("=");
                        String str4 = split3[0];
                        str = split3[1];
                        if ("rspauth".equals(str4)) {
                            break;
                        }
                        i12++;
                    }
                    if (str == null) {
                        throw new SmackException.SmackSaslException("No server response received while performing DIGEST-MD5 authentication");
                    } else if (!str.equals(calcResponse(DigestType.ServerResponse))) {
                        throw new SmackException.SmackSaslException("Invalid server response  while performing DIGEST-MD5 authentication");
                    }
                }
                this.state = State.VALID_SERVER_RESPONSE;
                return null;
            } else {
                throw new IllegalStateException();
            }
        } else {
            throw new SmackException.SmackSaslException("Initial challenge has zero length");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getAuthenticationText() {
        return null;
    }

    public String getName() {
        return "DIGEST-MD5";
    }

    public int getPriority() {
        return 210;
    }

    public SASLDigestMD5Mechanism newInstance() {
        return new SASLDigestMD5Mechanism();
    }
}
