package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.Validate;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!B\u0011\b\u0010\u0012\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b \u0010#B\u0011\b\u0010\u0012\u0006\u0010$\u001a\u00020\u0012¢\u0006\u0004\b \u0010%B!\b\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b \u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000f\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0007R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a¨\u0006("}, d2 = {"Lcom/facebook/AuthenticationTokenHeader;", "Landroid/os/Parcelable;", "", "headerString", "", "isValidHeader", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "describeContents", "toString", "", "other", "equals", "hashCode", "Lorg/json/b;", "toJSONObject$facebook_core_release", "()Lorg/json/b;", "toJSONObject", "toEnCodedString", "alg", "Ljava/lang/String;", "getAlg", "()Ljava/lang/String;", "typ", "getTyp", "kid", "getKid", "encodedHeaderString", "<init>", "(Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "jsonObject", "(Lorg/json/b;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AuthenticationTokenHeader implements Parcelable {
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new AuthenticationTokenHeader$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String alg;
    private final String kid;
    private final String typ;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/AuthenticationTokenHeader$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationTokenHeader;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AuthenticationTokenHeader(String str) {
        j.g(str, "encodedHeaderString");
        if (isValidHeader(str)) {
            byte[] decode = Base64.decode(str, 0);
            j.f(decode, "decodedBytes");
            b bVar = new b(new String(decode, d.f32216b));
            String string = bVar.getString("alg");
            j.f(string, "jsonObj.getString(\"alg\")");
            this.alg = string;
            String string2 = bVar.getString("typ");
            j.f(string2, "jsonObj.getString(\"typ\")");
            this.typ = string2;
            String string3 = bVar.getString("kid");
            j.f(string3, "jsonObj.getString(\"kid\")");
            this.kid = string3;
            return;
        }
        throw new IllegalArgumentException("Invalid Header".toString());
    }

    private final boolean isValidHeader(String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Validate.notEmpty(str, "encodedHeaderString");
        byte[] decode = Base64.decode(str, 0);
        j.f(decode, "decodedBytes");
        try {
            b bVar = new b(new String(decode, d.f32216b));
            String optString = bVar.optString("alg");
            j.f(optString, "alg");
            if (optString.length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 || !j.b(optString, "RS256")) {
                z11 = false;
            } else {
                z11 = true;
            }
            String optString2 = bVar.optString("kid");
            j.f(optString2, "jsonObj.optString(\"kid\")");
            if (optString2.length() > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            String optString3 = bVar.optString("typ");
            j.f(optString3, "jsonObj.optString(\"typ\")");
            if (optString3.length() > 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (!z11 || !z12 || !z13) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        if (!j.b(this.alg, authenticationTokenHeader.alg) || !j.b(this.typ, authenticationTokenHeader.typ) || !j.b(this.kid, authenticationTokenHeader.kid)) {
            return false;
        }
        return true;
    }

    public final String getAlg() {
        return this.alg;
    }

    public final String getKid() {
        return this.kid;
    }

    public final String getTyp() {
        return this.typ;
    }

    public int hashCode() {
        return ((((527 + this.alg.hashCode()) * 31) + this.typ.hashCode()) * 31) + this.kid.hashCode();
    }

    public final String toEnCodedString() {
        String authenticationTokenHeader = toString();
        Charset charset = d.f32216b;
        if (authenticationTokenHeader != null) {
            byte[] bytes = authenticationTokenHeader.getBytes(charset);
            j.f(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 0);
            j.f(encodeToString, "encodeToString(claimsJsonString.toByteArray(), Base64.DEFAULT)");
            return encodeToString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final b toJSONObject$facebook_core_release() {
        b bVar = new b();
        bVar.put("alg", (Object) this.alg);
        bVar.put("typ", (Object) this.typ);
        bVar.put("kid", (Object) this.kid);
        return bVar;
    }

    public String toString() {
        String bVar = toJSONObject$facebook_core_release().toString();
        j.f(bVar, "headerJsonObject.toString()");
        return bVar;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "dest");
        parcel.writeString(this.alg);
        parcel.writeString(this.typ);
        parcel.writeString(this.kid);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        j.g(parcel, "parcel");
        this.alg = Validate.notNullOrEmpty(parcel.readString(), "alg");
        this.typ = Validate.notNullOrEmpty(parcel.readString(), "typ");
        this.kid = Validate.notNullOrEmpty(parcel.readString(), "kid");
    }

    public AuthenticationTokenHeader(b bVar) throws JSONException {
        j.g(bVar, "jsonObject");
        String string = bVar.getString("alg");
        j.f(string, "jsonObject.getString(\"alg\")");
        this.alg = string;
        String string2 = bVar.getString("typ");
        j.f(string2, "jsonObject.getString(\"typ\")");
        this.typ = string2;
        String string3 = bVar.getString("kid");
        j.f(string3, "jsonObject.getString(\"kid\")");
        this.kid = string3;
    }

    public AuthenticationTokenHeader(String str, String str2, String str3) {
        j.g(str, "alg");
        j.g(str2, "typ");
        j.g(str3, "kid");
        this.alg = str;
        this.typ = str2;
        this.kid = str3;
    }
}
