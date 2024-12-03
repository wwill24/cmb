package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.internal.Validate;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.IOException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 02\u00020\u0001:\u00010B\u0019\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+B\u0011\b\u0010\u0012\u0006\u0010,\u001a\u00020\u0012¢\u0006\u0004\b*\u0010-B\u0011\b\u0010\u0012\u0006\u0010.\u001a\u00020\t¢\u0006\u0004\b*\u0010/J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000f\u0010\f\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010(\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001b¨\u00061"}, d2 = {"Lcom/facebook/AuthenticationToken;", "Landroid/os/Parcelable;", "", "headerString", "claimsString", "sigString", "kid", "", "isValidSignature", "Lorg/json/b;", "toJSONObject$facebook_core_release", "()Lorg/json/b;", "toJSONObject", "", "other", "equals", "", "hashCode", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "describeContents", "token", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "expectedNonce", "getExpectedNonce", "Lcom/facebook/AuthenticationTokenHeader;", "header", "Lcom/facebook/AuthenticationTokenHeader;", "getHeader", "()Lcom/facebook/AuthenticationTokenHeader;", "Lcom/facebook/AuthenticationTokenClaims;", "claims", "Lcom/facebook/AuthenticationTokenClaims;", "getClaims", "()Lcom/facebook/AuthenticationTokenClaims;", "signature", "getSignature", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "jsonObject", "(Lorg/json/b;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AuthenticationToken implements Parcelable {
    public static final String AUTHENTICATION_TOKEN_KEY = "id_token";
    private static final String CLAIMS_KEY = "claims";
    public static final Parcelable.Creator<AuthenticationToken> CREATOR = new AuthenticationToken$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXPECTED_NONCE_KEY = "expected_nonce";
    private static final String HEADER_KEY = "header";
    private static final String SIGNATURE_KEY = "signature";
    private static final String TOKEN_STRING_KEY = "token_string";
    private final AuthenticationTokenClaims claims;
    private final String expectedNonce;
    private final AuthenticationTokenHeader header;
    private final String signature;
    private final String token;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/AuthenticationToken$Companion;", "", "()V", "AUTHENTICATION_TOKEN_KEY", "", "CLAIMS_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationToken;", "EXPECTED_NONCE_KEY", "HEADER_KEY", "SIGNATURE_KEY", "TOKEN_STRING_KEY", "getCurrentAuthenticationToken", "setCurrentAuthenticationToken", "", "authenticationToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthenticationToken getCurrentAuthenticationToken() {
            return AuthenticationTokenManager.Companion.getInstance().getCurrentAuthenticationToken();
        }

        public final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
            AuthenticationTokenManager.Companion.getInstance().setCurrentAuthenticationToken(authenticationToken);
        }
    }

    public AuthenticationToken(String str, String str2) {
        j.g(str, "token");
        j.g(str2, "expectedNonce");
        Validate.notEmpty(str, "token");
        Validate.notEmpty(str2, "expectedNonce");
        List C0 = StringsKt__StringsKt.C0(str, new String[]{"."}, false, 0, 6, (Object) null);
        if (C0.size() == 3) {
            String str3 = (String) C0.get(0);
            String str4 = (String) C0.get(1);
            String str5 = (String) C0.get(2);
            this.token = str;
            this.expectedNonce = str2;
            AuthenticationTokenHeader authenticationTokenHeader = new AuthenticationTokenHeader(str3);
            this.header = authenticationTokenHeader;
            this.claims = new AuthenticationTokenClaims(str4, str2);
            if (isValidSignature(str3, str4, str5, authenticationTokenHeader.getKid())) {
                this.signature = str5;
                return;
            }
            throw new IllegalArgumentException("Invalid Signature".toString());
        }
        throw new IllegalArgumentException("Invalid IdToken string".toString());
    }

    public static final AuthenticationToken getCurrentAuthenticationToken() {
        return Companion.getCurrentAuthenticationToken();
    }

    private final boolean isValidSignature(String str, String str2, String str3, String str4) {
        try {
            String rawKeyFromEndPoint = OidcSecurityUtil.getRawKeyFromEndPoint(str4);
            if (rawKeyFromEndPoint == null) {
                return false;
            }
            PublicKey publicKeyFromString = OidcSecurityUtil.getPublicKeyFromString(rawKeyFromEndPoint);
            return OidcSecurityUtil.verify(publicKeyFromString, str + '.' + str2, str3);
        } catch (IOException | InvalidKeySpecException unused) {
            return false;
        }
    }

    public static final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
        Companion.setCurrentAuthenticationToken(authenticationToken);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationToken)) {
            return false;
        }
        AuthenticationToken authenticationToken = (AuthenticationToken) obj;
        if (!j.b(this.token, authenticationToken.token) || !j.b(this.expectedNonce, authenticationToken.expectedNonce) || !j.b(this.header, authenticationToken.header) || !j.b(this.claims, authenticationToken.claims) || !j.b(this.signature, authenticationToken.signature)) {
            return false;
        }
        return true;
    }

    public final AuthenticationTokenClaims getClaims() {
        return this.claims;
    }

    public final String getExpectedNonce() {
        return this.expectedNonce;
    }

    public final AuthenticationTokenHeader getHeader() {
        return this.header;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return ((((((((527 + this.token.hashCode()) * 31) + this.expectedNonce.hashCode()) * 31) + this.header.hashCode()) * 31) + this.claims.hashCode()) * 31) + this.signature.hashCode();
    }

    public final b toJSONObject$facebook_core_release() throws JSONException {
        b bVar = new b();
        bVar.put(TOKEN_STRING_KEY, (Object) this.token);
        bVar.put(EXPECTED_NONCE_KEY, (Object) this.expectedNonce);
        bVar.put("header", (Object) this.header.toJSONObject$facebook_core_release());
        bVar.put(CLAIMS_KEY, (Object) this.claims.toJSONObject$facebook_core_release());
        bVar.put(SIGNATURE_KEY, (Object) this.signature);
        return bVar;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "dest");
        parcel.writeString(this.token);
        parcel.writeString(this.expectedNonce);
        parcel.writeParcelable(this.header, i10);
        parcel.writeParcelable(this.claims, i10);
        parcel.writeString(this.signature);
    }

    public AuthenticationToken(Parcel parcel) {
        j.g(parcel, "parcel");
        this.token = Validate.notNullOrEmpty(parcel.readString(), "token");
        this.expectedNonce = Validate.notNullOrEmpty(parcel.readString(), "expectedNonce");
        Parcelable readParcelable = parcel.readParcelable(AuthenticationTokenHeader.class.getClassLoader());
        if (readParcelable != null) {
            this.header = (AuthenticationTokenHeader) readParcelable;
            Parcelable readParcelable2 = parcel.readParcelable(AuthenticationTokenClaims.class.getClassLoader());
            if (readParcelable2 != null) {
                this.claims = (AuthenticationTokenClaims) readParcelable2;
                this.signature = Validate.notNullOrEmpty(parcel.readString(), SIGNATURE_KEY);
                return;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public AuthenticationToken(b bVar) throws JSONException {
        j.g(bVar, "jsonObject");
        String string = bVar.getString(TOKEN_STRING_KEY);
        j.f(string, "jsonObject.getString(TOKEN_STRING_KEY)");
        this.token = string;
        String string2 = bVar.getString(EXPECTED_NONCE_KEY);
        j.f(string2, "jsonObject.getString(EXPECTED_NONCE_KEY)");
        this.expectedNonce = string2;
        String string3 = bVar.getString(SIGNATURE_KEY);
        j.f(string3, "jsonObject.getString(SIGNATURE_KEY)");
        this.signature = string3;
        b jSONObject = bVar.getJSONObject("header");
        b jSONObject2 = bVar.getJSONObject(CLAIMS_KEY);
        j.f(jSONObject, "headerJSONObject");
        this.header = new AuthenticationTokenHeader(jSONObject);
        AuthenticationTokenClaims.Companion companion = AuthenticationTokenClaims.Companion;
        j.f(jSONObject2, "claimsJSONObject");
        this.claims = companion.createFromJSONObject$facebook_core_release(jSONObject2);
    }
}
