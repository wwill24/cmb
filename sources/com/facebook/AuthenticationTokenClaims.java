package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.text.d;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u001e\n\u0002\b\u0005\u0018\u0000 R2\u00020\u0001:\u0001RB\u0019\b\u0017\u0012\u0006\u0010K\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bL\u0010MB\u0002\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010'\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020\u0004\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010N\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010>\u0012\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010>\u0012\u0016\b\u0002\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010>\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bL\u0010OB\u0011\b\u0010\u0012\u0006\u0010P\u001a\u00020\b¢\u0006\u0004\bL\u0010QJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0007J\u000f\u0010\u0017\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u0017\u0010 \u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u0017\u0010#\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&R\u0017\u0010)\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010\u0019\u001a\u0004\b*\u0010\u001bR\u0019\u0010+\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001bR\u0019\u0010-\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001bR\u0019\u0010/\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b/\u0010\u0019\u001a\u0004\b0\u0010\u001bR\u0019\u00101\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010\u001bR\u0019\u00103\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b3\u0010\u0019\u001a\u0004\b4\u0010\u001bR\u0019\u00105\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b5\u0010\u0019\u001a\u0004\b6\u0010\u001bR\u001f\u00108\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010<\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b<\u0010\u0019\u001a\u0004\b=\u0010\u001bR%\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010>8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR%\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010>8\u0006¢\u0006\f\n\u0004\bC\u0010@\u001a\u0004\bD\u0010BR%\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010>8\u0006¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010BR\u0019\u0010G\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\bG\u0010\u0019\u001a\u0004\bH\u0010\u001bR\u0019\u0010I\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\bI\u0010\u0019\u001a\u0004\bJ\u0010\u001b¨\u0006S"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims;", "Landroid/os/Parcelable;", "Lorg/json/b;", "claimsJson", "", "expectedNonce", "", "isValidClaims", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "", "other", "equals", "hashCode", "toString", "describeContents", "toEnCodedString", "toJSONObject$facebook_core_release", "()Lorg/json/b;", "toJSONObject", "jti", "Ljava/lang/String;", "getJti", "()Ljava/lang/String;", "iss", "getIss", "aud", "getAud", "nonce", "getNonce", "", "exp", "J", "getExp", "()J", "iat", "getIat", "sub", "getSub", "name", "getName", "givenName", "getGivenName", "middleName", "getMiddleName", "familyName", "getFamilyName", "email", "getEmail", "picture", "getPicture", "", "userFriends", "Ljava/util/Set;", "getUserFriends", "()Ljava/util/Set;", "userBirthday", "getUserBirthday", "", "userAgeRange", "Ljava/util/Map;", "getUserAgeRange", "()Ljava/util/Map;", "userHometown", "getUserHometown", "userLocation", "getUserLocation", "userGender", "getUserGender", "userLink", "getUserLink", "encodedClaims", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class AuthenticationTokenClaims implements Parcelable {
    public static final Parcelable.Creator<AuthenticationTokenClaims> CREATOR = new AuthenticationTokenClaims$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String JSON_KEY_AUD = "aud";
    public static final String JSON_KEY_EMAIL = "email";
    public static final String JSON_KEY_EXP = "exp";
    public static final String JSON_KEY_FAMILY_NAME = "family_name";
    public static final String JSON_KEY_GIVEN_NAME = "given_name";
    public static final String JSON_KEY_IAT = "iat";
    public static final String JSON_KEY_ISS = "iss";
    public static final String JSON_KEY_JIT = "jti";
    public static final String JSON_KEY_MIDDLE_NAME = "middle_name";
    public static final String JSON_KEY_NAME = "name";
    public static final String JSON_KEY_NONCE = "nonce";
    public static final String JSON_KEY_PICTURE = "picture";
    public static final String JSON_KEY_SUB = "sub";
    public static final String JSON_KEY_USER_AGE_RANGE = "user_age_range";
    public static final String JSON_KEY_USER_BIRTHDAY = "user_birthday";
    public static final String JSON_KEY_USER_FRIENDS = "user_friends";
    public static final String JSON_KEY_USER_GENDER = "user_gender";
    public static final String JSON_KEY_USER_HOMETOWN = "user_hometown";
    public static final String JSON_KEY_USER_LINK = "user_link";
    public static final String JSON_KEY_USER_LOCATION = "user_location";
    public static final long MAX_TIME_SINCE_TOKEN_ISSUED = 600000;
    private final String aud;
    private final String email;
    private final long exp;
    private final String familyName;
    private final String givenName;
    private final long iat;
    private final String iss;
    private final String jti;
    private final String middleName;
    private final String name;
    private final String nonce;
    private final String picture;
    private final String sub;
    private final Map<String, Integer> userAgeRange;
    private final String userBirthday;
    private final Set<String> userFriends;
    private final String userGender;
    private final Map<String, String> userHometown;
    private final String userLink;
    private final Map<String, String> userLocation;

    @Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001b\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001d\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011R\u0014\u0010\u001f\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u0014\u0010 \u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u0011R\u0014\u0010!\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u0011R\u0014\u0010\"\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u0011R\u0014\u0010#\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0011R\u0014\u0010$\u001a\u00020\u00038\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u0011R\u0014\u0010&\u001a\u00020%8\u0006XT¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/facebook/AuthenticationTokenClaims$Companion;", "", "Lorg/json/b;", "", "name", "getNullableString$facebook_core_release", "(Lorg/json/b;Ljava/lang/String;)Ljava/lang/String;", "getNullableString", "jsonObject", "Lcom/facebook/AuthenticationTokenClaims;", "createFromJSONObject$facebook_core_release", "(Lorg/json/b;)Lcom/facebook/AuthenticationTokenClaims;", "createFromJSONObject", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "JSON_KEY_AUD", "Ljava/lang/String;", "JSON_KEY_EMAIL", "JSON_KEY_EXP", "JSON_KEY_FAMILY_NAME", "JSON_KEY_GIVEN_NAME", "JSON_KEY_IAT", "JSON_KEY_ISS", "JSON_KEY_JIT", "JSON_KEY_MIDDLE_NAME", "JSON_KEY_NAME", "JSON_KEY_NONCE", "JSON_KEY_PICTURE", "JSON_KEY_SUB", "JSON_KEY_USER_AGE_RANGE", "JSON_KEY_USER_BIRTHDAY", "JSON_KEY_USER_FRIENDS", "JSON_KEY_USER_GENDER", "JSON_KEY_USER_HOMETOWN", "JSON_KEY_USER_LINK", "JSON_KEY_USER_LOCATION", "", "MAX_TIME_SINCE_TOKEN_ISSUED", "J", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(b bVar) throws JSONException {
            List<String> list;
            Map<String, Object> map;
            Map<String, String> map2;
            b bVar2 = bVar;
            j.g(bVar2, "jsonObject");
            String string = bVar2.getString(AuthenticationTokenClaims.JSON_KEY_JIT);
            String string2 = bVar2.getString(AuthenticationTokenClaims.JSON_KEY_ISS);
            String string3 = bVar2.getString(AuthenticationTokenClaims.JSON_KEY_AUD);
            String string4 = bVar2.getString("nonce");
            long j10 = bVar2.getLong(AuthenticationTokenClaims.JSON_KEY_EXP);
            long j11 = bVar2.getLong(AuthenticationTokenClaims.JSON_KEY_IAT);
            String string5 = bVar2.getString("sub");
            long j12 = j11;
            String nullableString$facebook_core_release = getNullableString$facebook_core_release(bVar2, "name");
            String nullableString$facebook_core_release2 = getNullableString$facebook_core_release(bVar2, AuthenticationTokenClaims.JSON_KEY_GIVEN_NAME);
            String nullableString$facebook_core_release3 = getNullableString$facebook_core_release(bVar2, AuthenticationTokenClaims.JSON_KEY_MIDDLE_NAME);
            String nullableString$facebook_core_release4 = getNullableString$facebook_core_release(bVar2, AuthenticationTokenClaims.JSON_KEY_FAMILY_NAME);
            String nullableString$facebook_core_release5 = getNullableString$facebook_core_release(bVar2, "email");
            String nullableString$facebook_core_release6 = getNullableString$facebook_core_release(bVar2, "picture");
            a optJSONArray = bVar2.optJSONArray(AuthenticationTokenClaims.JSON_KEY_USER_FRIENDS);
            String str = nullableString$facebook_core_release;
            String nullableString$facebook_core_release7 = getNullableString$facebook_core_release(bVar2, AuthenticationTokenClaims.JSON_KEY_USER_BIRTHDAY);
            b optJSONObject = bVar2.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_AGE_RANGE);
            long j13 = j10;
            b optJSONObject2 = bVar2.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_HOMETOWN);
            b optJSONObject3 = bVar2.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION);
            String nullableString$facebook_core_release8 = getNullableString$facebook_core_release(bVar2, AuthenticationTokenClaims.JSON_KEY_USER_GENDER);
            String nullableString$facebook_core_release9 = getNullableString$facebook_core_release(bVar2, AuthenticationTokenClaims.JSON_KEY_USER_LINK);
            j.f(string, AuthenticationTokenClaims.JSON_KEY_JIT);
            j.f(string2, AuthenticationTokenClaims.JSON_KEY_ISS);
            j.f(string3, AuthenticationTokenClaims.JSON_KEY_AUD);
            j.f(string4, "nonce");
            j.f(string5, "sub");
            Map<String, String> map3 = null;
            if (optJSONArray == null) {
                list = null;
            } else {
                list = Utility.jsonArrayToStringList(optJSONArray);
            }
            if (optJSONObject == null) {
                map = null;
            } else {
                map = Utility.convertJSONObjectToHashMap(optJSONObject);
            }
            if (optJSONObject2 == null) {
                map2 = null;
            } else {
                map2 = Utility.convertJSONObjectToStringMap(optJSONObject2);
            }
            if (optJSONObject3 != null) {
                map3 = Utility.convertJSONObjectToStringMap(optJSONObject3);
            }
            return new AuthenticationTokenClaims(string, string2, string3, string4, j13, j12, string5, str, nullableString$facebook_core_release2, nullableString$facebook_core_release3, nullableString$facebook_core_release4, nullableString$facebook_core_release5, nullableString$facebook_core_release6, list, nullableString$facebook_core_release7, map, map2, map3, nullableString$facebook_core_release8, nullableString$facebook_core_release9);
        }

        public final String getNullableString$facebook_core_release(b bVar, String str) {
            j.g(bVar, "<this>");
            j.g(str, "name");
            if (bVar.has(str)) {
                return bVar.getString(str);
            }
            return null;
        }
    }

    public AuthenticationTokenClaims(String str, String str2) {
        Set<String> set;
        Map<String, Integer> map;
        Map<String, String> map2;
        j.g(str, "encodedClaims");
        j.g(str2, "expectedNonce");
        Validate.notEmpty(str, "encodedClaims");
        byte[] decode = Base64.decode(str, 8);
        j.f(decode, "decodedBytes");
        b bVar = new b(new String(decode, d.f32216b));
        if (isValidClaims(bVar, str2)) {
            String string = bVar.getString(JSON_KEY_JIT);
            j.f(string, "jsonObj.getString(JSON_KEY_JIT)");
            this.jti = string;
            String string2 = bVar.getString(JSON_KEY_ISS);
            j.f(string2, "jsonObj.getString(JSON_KEY_ISS)");
            this.iss = string2;
            String string3 = bVar.getString(JSON_KEY_AUD);
            j.f(string3, "jsonObj.getString(JSON_KEY_AUD)");
            this.aud = string3;
            String string4 = bVar.getString("nonce");
            j.f(string4, "jsonObj.getString(JSON_KEY_NONCE)");
            this.nonce = string4;
            this.exp = bVar.getLong(JSON_KEY_EXP);
            this.iat = bVar.getLong(JSON_KEY_IAT);
            String string5 = bVar.getString("sub");
            j.f(string5, "jsonObj.getString(JSON_KEY_SUB)");
            this.sub = string5;
            Companion companion = Companion;
            this.name = companion.getNullableString$facebook_core_release(bVar, "name");
            this.givenName = companion.getNullableString$facebook_core_release(bVar, JSON_KEY_GIVEN_NAME);
            this.middleName = companion.getNullableString$facebook_core_release(bVar, JSON_KEY_MIDDLE_NAME);
            this.familyName = companion.getNullableString$facebook_core_release(bVar, JSON_KEY_FAMILY_NAME);
            this.email = companion.getNullableString$facebook_core_release(bVar, "email");
            this.picture = companion.getNullableString$facebook_core_release(bVar, "picture");
            a optJSONArray = bVar.optJSONArray(JSON_KEY_USER_FRIENDS);
            Map<String, String> map3 = null;
            if (optJSONArray == null) {
                set = null;
            } else {
                set = Collections.unmodifiableSet(Utility.jsonArrayToSet(optJSONArray));
            }
            this.userFriends = set;
            this.userBirthday = companion.getNullableString$facebook_core_release(bVar, JSON_KEY_USER_BIRTHDAY);
            b optJSONObject = bVar.optJSONObject(JSON_KEY_USER_AGE_RANGE);
            if (optJSONObject == null) {
                map = null;
            } else {
                map = Collections.unmodifiableMap(Utility.convertJSONObjectToHashMap(optJSONObject));
            }
            this.userAgeRange = map;
            b optJSONObject2 = bVar.optJSONObject(JSON_KEY_USER_HOMETOWN);
            if (optJSONObject2 == null) {
                map2 = null;
            } else {
                map2 = Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(optJSONObject2));
            }
            this.userHometown = map2;
            b optJSONObject3 = bVar.optJSONObject(JSON_KEY_USER_LOCATION);
            this.userLocation = optJSONObject3 != null ? Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(optJSONObject3)) : map3;
            this.userGender = companion.getNullableString$facebook_core_release(bVar, JSON_KEY_USER_GENDER);
            this.userLink = companion.getNullableString$facebook_core_release(bVar, JSON_KEY_USER_LINK);
            return;
        }
        throw new IllegalArgumentException("Invalid claims".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j10, long j11, String str5) {
        this(str, str2, str3, str4, j10, j11, str5, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1048448, (DefaultConstructorMarker) null);
        j.g(str, JSON_KEY_JIT);
        j.g(str2, JSON_KEY_ISS);
        j.g(str3, JSON_KEY_AUD);
        j.g(str4, "nonce");
        j.g(str5, "sub");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6) {
        this(str, str2, str3, str4, j10, j11, str5, str6, (String) null, (String) null, (String) null, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1048320, (DefaultConstructorMarker) null);
        j.g(str, JSON_KEY_JIT);
        j.g(str2, JSON_KEY_ISS);
        j.g(str3, JSON_KEY_AUD);
        j.g(str4, "nonce");
        j.g(str5, "sub");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7) {
        this(str, str2, str3, str4, j10, j11, str5, str6, str7, (String) null, (String) null, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1048064, (DefaultConstructorMarker) null);
        j.g(str, JSON_KEY_JIT);
        j.g(str2, JSON_KEY_ISS);
        j.g(str3, JSON_KEY_AUD);
        j.g(str4, "nonce");
        j.g(str5, "sub");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, String str8) {
        this(str, str2, str3, str4, j10, j11, str5, str6, str7, str8, (String) null, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1047552, (DefaultConstructorMarker) null);
        j.g(str, JSON_KEY_JIT);
        j.g(str2, JSON_KEY_ISS);
        j.g(str3, JSON_KEY_AUD);
        j.g(str4, "nonce");
        j.g(str5, "sub");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, String str8, String str9) {
        this(str, str2, str3, str4, j10, j11, str5, str6, str7, str8, str9, (String) null, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1046528, (DefaultConstructorMarker) null);
        j.g(str, JSON_KEY_JIT);
        j.g(str2, JSON_KEY_ISS);
        j.g(str3, JSON_KEY_AUD);
        j.g(str4, "nonce");
        j.g(str5, "sub");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, String str8, String str9, String str10) {
        this(str, str2, str3, str4, j10, j11, str5, str6, str7, str8, str9, str10, (String) null, (Collection) null, (String) null, (Map) null, (Map) null, (Map) null, (String) null, (String) null, 1044480, (DefaultConstructorMarker) null);
        j.g(str, JSON_KEY_JIT);
        j.g(str2, JSON_KEY_ISS);
        j.g(str3, JSON_KEY_AUD);
        j.g(str4, "nonce");
        j.g(str5, "sub");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.j.g(r1, r0)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1040384(0xfe000, float:1.457889E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.j.g(r1, r0)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1032192(0xfc000, float:1.446409E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.j.g(r1, r0)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 1015808(0xf8000, float:1.42345E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44, java.util.Map<java.lang.String, java.lang.Integer> r45) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r18 = r45
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.j.g(r1, r0)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 983040(0xf0000, float:1.377532E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44, java.util.Map<java.lang.String, java.lang.Integer> r45, java.util.Map<java.lang.String, java.lang.String> r46) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r18 = r45
            r19 = r46
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.j.g(r1, r0)
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 917504(0xe0000, float:1.285697E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44, java.util.Map<java.lang.String, java.lang.Integer> r45, java.util.Map<java.lang.String, java.lang.String> r46, java.util.Map<java.lang.String, java.lang.String> r47) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r18 = r45
            r19 = r46
            r20 = r47
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.j.g(r1, r0)
            r21 = 0
            r22 = 0
            r23 = 786432(0xc0000, float:1.102026E-39)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map, java.util.Map, java.util.Map):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenClaims(java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, long r32, long r34, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.util.Collection<java.lang.String> r43, java.lang.String r44, java.util.Map<java.lang.String, java.lang.Integer> r45, java.util.Map<java.lang.String, java.lang.String> r46, java.util.Map<java.lang.String, java.lang.String> r47, java.lang.String r48) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r32
            r7 = r34
            r9 = r36
            r10 = r37
            r11 = r38
            r12 = r39
            r13 = r40
            r14 = r41
            r15 = r42
            r16 = r43
            r17 = r44
            r18 = r45
            r19 = r46
            r20 = r47
            r21 = r48
            r25 = r0
            java.lang.String r0 = "jti"
            r26 = r1
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "iss"
            r1 = r29
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "aud"
            r1 = r30
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "nonce"
            r1 = r31
            kotlin.jvm.internal.j.g(r1, r0)
            java.lang.String r0 = "sub"
            r1 = r36
            kotlin.jvm.internal.j.g(r1, r0)
            r22 = 0
            r23 = 524288(0x80000, float:7.34684E-40)
            r24 = 0
            r0 = r25
            r1 = r26
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.lang.String):void");
    }

    public static final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(b bVar) throws JSONException {
        return Companion.createFromJSONObject$facebook_core_release(bVar);
    }

    private final boolean isValidClaims(b bVar, String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (bVar == null) {
            return false;
        }
        String optString = bVar.optString(JSON_KEY_JIT);
        j.f(optString, JSON_KEY_JIT);
        if (optString.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return false;
        }
        try {
            String optString2 = bVar.optString(JSON_KEY_ISS);
            j.f(optString2, JSON_KEY_ISS);
            if (optString2.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && (j.b(new URL(optString2).getHost(), "facebook.com") || j.b(new URL(optString2).getHost(), "www.facebook.com"))) {
                String optString3 = bVar.optString(JSON_KEY_AUD);
                j.f(optString3, JSON_KEY_AUD);
                if (optString3.length() == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12 && j.b(optString3, FacebookSdk.getApplicationId())) {
                    long j10 = (long) 1000;
                    if (new Date().after(new Date(bVar.optLong(JSON_KEY_EXP) * j10))) {
                        return false;
                    }
                    if (new Date().after(new Date((bVar.optLong(JSON_KEY_IAT) * j10) + MAX_TIME_SINCE_TOKEN_ISSUED))) {
                        return false;
                    }
                    String optString4 = bVar.optString("sub");
                    j.f(optString4, "sub");
                    if (optString4.length() == 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        return false;
                    }
                    String optString5 = bVar.optString("nonce");
                    j.f(optString5, "nonce");
                    if (optString5.length() == 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14 || !j.b(optString5, str)) {
                        return false;
                    }
                    return true;
                }
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) obj;
        if (!j.b(this.jti, authenticationTokenClaims.jti) || !j.b(this.iss, authenticationTokenClaims.iss) || !j.b(this.aud, authenticationTokenClaims.aud) || !j.b(this.nonce, authenticationTokenClaims.nonce) || this.exp != authenticationTokenClaims.exp || this.iat != authenticationTokenClaims.iat || !j.b(this.sub, authenticationTokenClaims.sub) || !j.b(this.name, authenticationTokenClaims.name) || !j.b(this.givenName, authenticationTokenClaims.givenName) || !j.b(this.middleName, authenticationTokenClaims.middleName) || !j.b(this.familyName, authenticationTokenClaims.familyName) || !j.b(this.email, authenticationTokenClaims.email) || !j.b(this.picture, authenticationTokenClaims.picture) || !j.b(this.userFriends, authenticationTokenClaims.userFriends) || !j.b(this.userBirthday, authenticationTokenClaims.userBirthday) || !j.b(this.userAgeRange, authenticationTokenClaims.userAgeRange) || !j.b(this.userHometown, authenticationTokenClaims.userHometown) || !j.b(this.userLocation, authenticationTokenClaims.userLocation) || !j.b(this.userGender, authenticationTokenClaims.userGender) || !j.b(this.userLink, authenticationTokenClaims.userLink)) {
            return false;
        }
        return true;
    }

    public final String getAud() {
        return this.aud;
    }

    public final String getEmail() {
        return this.email;
    }

    public final long getExp() {
        return this.exp;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final long getIat() {
        return this.iat;
    }

    public final String getIss() {
        return this.iss;
    }

    public final String getJti() {
        return this.jti;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getSub() {
        return this.sub;
    }

    public final Map<String, Integer> getUserAgeRange() {
        return this.userAgeRange;
    }

    public final String getUserBirthday() {
        return this.userBirthday;
    }

    public final Set<String> getUserFriends() {
        return this.userFriends;
    }

    public final String getUserGender() {
        return this.userGender;
    }

    public final Map<String, String> getUserHometown() {
        return this.userHometown;
    }

    public final String getUserLink() {
        return this.userLink;
    }

    public final Map<String, String> getUserLocation() {
        return this.userLocation;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int hashCode = (((((((((((((527 + this.jti.hashCode()) * 31) + this.iss.hashCode()) * 31) + this.aud.hashCode()) * 31) + this.nonce.hashCode()) * 31) + Long.hashCode(this.exp)) * 31) + Long.hashCode(this.iat)) * 31) + this.sub.hashCode()) * 31;
        String str = this.name;
        int i22 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i23 = (hashCode + i10) * 31;
        String str2 = this.givenName;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int i24 = (i23 + i11) * 31;
        String str3 = this.middleName;
        if (str3 == null) {
            i12 = 0;
        } else {
            i12 = str3.hashCode();
        }
        int i25 = (i24 + i12) * 31;
        String str4 = this.familyName;
        if (str4 == null) {
            i13 = 0;
        } else {
            i13 = str4.hashCode();
        }
        int i26 = (i25 + i13) * 31;
        String str5 = this.email;
        if (str5 == null) {
            i14 = 0;
        } else {
            i14 = str5.hashCode();
        }
        int i27 = (i26 + i14) * 31;
        String str6 = this.picture;
        if (str6 == null) {
            i15 = 0;
        } else {
            i15 = str6.hashCode();
        }
        int i28 = (i27 + i15) * 31;
        Set<String> set = this.userFriends;
        if (set == null) {
            i16 = 0;
        } else {
            i16 = set.hashCode();
        }
        int i29 = (i28 + i16) * 31;
        String str7 = this.userBirthday;
        if (str7 == null) {
            i17 = 0;
        } else {
            i17 = str7.hashCode();
        }
        int i30 = (i29 + i17) * 31;
        Map<String, Integer> map = this.userAgeRange;
        if (map == null) {
            i18 = 0;
        } else {
            i18 = map.hashCode();
        }
        int i31 = (i30 + i18) * 31;
        Map<String, String> map2 = this.userHometown;
        if (map2 == null) {
            i19 = 0;
        } else {
            i19 = map2.hashCode();
        }
        int i32 = (i31 + i19) * 31;
        Map<String, String> map3 = this.userLocation;
        if (map3 == null) {
            i20 = 0;
        } else {
            i20 = map3.hashCode();
        }
        int i33 = (i32 + i20) * 31;
        String str8 = this.userGender;
        if (str8 == null) {
            i21 = 0;
        } else {
            i21 = str8.hashCode();
        }
        int i34 = (i33 + i21) * 31;
        String str9 = this.userLink;
        if (str9 != null) {
            i22 = str9.hashCode();
        }
        return i34 + i22;
    }

    public final String toEnCodedString() {
        String authenticationTokenClaims = toString();
        Charset charset = d.f32216b;
        if (authenticationTokenClaims != null) {
            byte[] bytes = authenticationTokenClaims.getBytes(charset);
            j.f(bytes, "(this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(bytes, 8);
            j.f(encodeToString, "encodeToString(claimsJsonString.toByteArray(), Base64.URL_SAFE)");
            return encodeToString;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final b toJSONObject$facebook_core_release() {
        b bVar = new b();
        bVar.put(JSON_KEY_JIT, (Object) this.jti);
        bVar.put(JSON_KEY_ISS, (Object) this.iss);
        bVar.put(JSON_KEY_AUD, (Object) this.aud);
        bVar.put("nonce", (Object) this.nonce);
        bVar.put(JSON_KEY_EXP, this.exp);
        bVar.put(JSON_KEY_IAT, this.iat);
        String str = this.sub;
        if (str != null) {
            bVar.put("sub", (Object) str);
        }
        String str2 = this.name;
        if (str2 != null) {
            bVar.put("name", (Object) str2);
        }
        String str3 = this.givenName;
        if (str3 != null) {
            bVar.put(JSON_KEY_GIVEN_NAME, (Object) str3);
        }
        String str4 = this.middleName;
        if (str4 != null) {
            bVar.put(JSON_KEY_MIDDLE_NAME, (Object) str4);
        }
        String str5 = this.familyName;
        if (str5 != null) {
            bVar.put(JSON_KEY_FAMILY_NAME, (Object) str5);
        }
        String str6 = this.email;
        if (str6 != null) {
            bVar.put("email", (Object) str6);
        }
        String str7 = this.picture;
        if (str7 != null) {
            bVar.put("picture", (Object) str7);
        }
        Set<String> set = this.userFriends;
        if (set != null) {
            bVar.put(JSON_KEY_USER_FRIENDS, (Object) new a((Collection<?>) set));
        }
        String str8 = this.userBirthday;
        if (str8 != null) {
            bVar.put(JSON_KEY_USER_BIRTHDAY, (Object) str8);
        }
        if (this.userAgeRange != null) {
            bVar.put(JSON_KEY_USER_AGE_RANGE, (Object) new b((Map<?, ?>) this.userAgeRange));
        }
        if (this.userHometown != null) {
            bVar.put(JSON_KEY_USER_HOMETOWN, (Object) new b((Map<?, ?>) this.userHometown));
        }
        if (this.userLocation != null) {
            bVar.put(JSON_KEY_USER_LOCATION, (Object) new b((Map<?, ?>) this.userLocation));
        }
        String str9 = this.userGender;
        if (str9 != null) {
            bVar.put(JSON_KEY_USER_GENDER, (Object) str9);
        }
        String str10 = this.userLink;
        if (str10 != null) {
            bVar.put(JSON_KEY_USER_LINK, (Object) str10);
        }
        return bVar;
    }

    public String toString() {
        String bVar = toJSONObject$facebook_core_release().toString();
        j.f(bVar, "claimsJsonObject.toString()");
        return bVar;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "dest");
        parcel.writeString(this.jti);
        parcel.writeString(this.iss);
        parcel.writeString(this.aud);
        parcel.writeString(this.nonce);
        parcel.writeLong(this.exp);
        parcel.writeLong(this.iat);
        parcel.writeString(this.sub);
        parcel.writeString(this.name);
        parcel.writeString(this.givenName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.familyName);
        parcel.writeString(this.email);
        parcel.writeString(this.picture);
        if (this.userFriends == null) {
            parcel.writeStringList((List) null);
        } else {
            parcel.writeStringList(new ArrayList(this.userFriends));
        }
        parcel.writeString(this.userBirthday);
        parcel.writeMap(this.userAgeRange);
        parcel.writeMap(this.userHometown);
        parcel.writeMap(this.userLocation);
        parcel.writeString(this.userGender);
        parcel.writeString(this.userLink);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AuthenticationTokenClaims(java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, long r31, long r33, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.util.Collection r42, java.lang.String r43, java.util.Map r44, java.util.Map r45, java.util.Map r46, java.lang.String r47, java.lang.String r48, int r49, kotlin.jvm.internal.DefaultConstructorMarker r50) {
        /*
            r26 = this;
            r0 = r49
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r13 = r2
            goto L_0x000b
        L_0x0009:
            r13 = r36
        L_0x000b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0011
            r14 = r2
            goto L_0x0013
        L_0x0011:
            r14 = r37
        L_0x0013:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0019
            r15 = r2
            goto L_0x001b
        L_0x0019:
            r15 = r38
        L_0x001b:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0022
            r16 = r2
            goto L_0x0024
        L_0x0022:
            r16 = r39
        L_0x0024:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x002b
            r17 = r2
            goto L_0x002d
        L_0x002b:
            r17 = r40
        L_0x002d:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0034
            r18 = r2
            goto L_0x0036
        L_0x0034:
            r18 = r41
        L_0x0036:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x003d
            r19 = r2
            goto L_0x003f
        L_0x003d:
            r19 = r42
        L_0x003f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0046
            r20 = r2
            goto L_0x0048
        L_0x0046:
            r20 = r43
        L_0x0048:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0051
            r21 = r2
            goto L_0x0053
        L_0x0051:
            r21 = r44
        L_0x0053:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x005b
            r22 = r2
            goto L_0x005d
        L_0x005b:
            r22 = r45
        L_0x005d:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0065
            r23 = r2
            goto L_0x0067
        L_0x0065:
            r23 = r46
        L_0x0067:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x006f
            r24 = r2
            goto L_0x0071
        L_0x006f:
            r24 = r47
        L_0x0071:
            r1 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0079
            r25 = r2
            goto L_0x007b
        L_0x0079:
            r25 = r48
        L_0x007b:
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r10 = r33
            r12 = r35
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Collection, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection<String> collection, String str12, Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3, String str13, String str14) {
        String str15 = str;
        String str16 = str2;
        String str17 = str3;
        String str18 = str4;
        String str19 = str5;
        Collection<String> collection2 = collection;
        Map<String, Integer> map4 = map;
        Map<String, String> map5 = map2;
        Map<String, String> map6 = map3;
        j.g(str15, JSON_KEY_JIT);
        j.g(str16, JSON_KEY_ISS);
        j.g(str17, JSON_KEY_AUD);
        j.g(str18, "nonce");
        j.g(str19, "sub");
        Validate.notEmpty(str15, JSON_KEY_JIT);
        Validate.notEmpty(str16, JSON_KEY_ISS);
        Validate.notEmpty(str17, JSON_KEY_AUD);
        Validate.notEmpty(str18, "nonce");
        Validate.notEmpty(str19, "sub");
        this.jti = str15;
        this.iss = str16;
        this.aud = str17;
        this.nonce = str18;
        this.exp = j10;
        this.iat = j11;
        this.sub = str19;
        this.name = str6;
        this.givenName = str7;
        this.middleName = str8;
        this.familyName = str9;
        this.email = str10;
        this.picture = str11;
        Map<String, String> map7 = null;
        this.userFriends = collection2 != null ? Collections.unmodifiableSet(new HashSet(collection2)) : null;
        this.userBirthday = str12;
        this.userAgeRange = map4 != null ? Collections.unmodifiableMap(new HashMap(map4)) : null;
        this.userHometown = map5 != null ? Collections.unmodifiableMap(new HashMap(map5)) : null;
        this.userLocation = map6 != null ? Collections.unmodifiableMap(new HashMap(map6)) : map7;
        this.userGender = str13;
        this.userLink = str14;
    }

    public AuthenticationTokenClaims(Parcel parcel) {
        j.g(parcel, "parcel");
        this.jti = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_JIT);
        this.iss = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_ISS);
        this.aud = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_AUD);
        this.nonce = Validate.notNullOrEmpty(parcel.readString(), "nonce");
        this.exp = parcel.readLong();
        this.iat = parcel.readLong();
        this.sub = Validate.notNullOrEmpty(parcel.readString(), "sub");
        this.name = parcel.readString();
        this.givenName = parcel.readString();
        this.middleName = parcel.readString();
        this.familyName = parcel.readString();
        this.email = parcel.readString();
        this.picture = parcel.readString();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        Map<String, String> map = null;
        this.userFriends = createStringArrayList != null ? Collections.unmodifiableSet(new HashSet(createStringArrayList)) : null;
        this.userBirthday = parcel.readString();
        HashMap readHashMap = parcel.readHashMap(i.f32135a.getClass().getClassLoader());
        readHashMap = !(readHashMap instanceof HashMap) ? null : readHashMap;
        this.userAgeRange = readHashMap != null ? Collections.unmodifiableMap(readHashMap) : null;
        o oVar = o.f32141a;
        HashMap readHashMap2 = parcel.readHashMap(oVar.getClass().getClassLoader());
        readHashMap2 = !(readHashMap2 instanceof HashMap) ? null : readHashMap2;
        this.userHometown = readHashMap2 != null ? Collections.unmodifiableMap(readHashMap2) : null;
        HashMap readHashMap3 = parcel.readHashMap(oVar.getClass().getClassLoader());
        readHashMap3 = !(readHashMap3 instanceof HashMap) ? null : readHashMap3;
        this.userLocation = readHashMap3 != null ? Collections.unmodifiableMap(readHashMap3) : map;
        this.userGender = parcel.readString();
        this.userLink = parcel.readString();
    }
}
