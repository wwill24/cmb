package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessToken;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u0000 -2\u00020\u0001:\u0001-BQ\b\u0017\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b'\u0010(B\u0011\b\u0010\u0012\u0006\u0010)\u001a\u00020\f¢\u0006\u0004\b'\u0010*B\u0011\b\u0012\u0012\u0006\u0010+\u001a\u00020\u000f¢\u0006\u0004\b'\u0010,J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u0019\u0010!\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010%\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$¨\u0006."}, d2 = {"Lcom/facebook/Profile;", "Landroid/os/Parcelable;", "", "width", "height", "Landroid/net/Uri;", "getProfilePictureUri", "", "other", "", "equals", "hashCode", "Lorg/json/b;", "toJSONObject", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "firstName", "getFirstName", "middleName", "getMiddleName", "lastName", "getLastName", "name", "getName", "linkUri", "Landroid/net/Uri;", "getLinkUri", "()Landroid/net/Uri;", "pictureUri", "getPictureUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;)V", "jsonObject", "(Lorg/json/b;)V", "source", "(Landroid/os/Parcel;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new Profile$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LINK_URI_KEY = "link_uri";
    private static final String MIDDLE_NAME_KEY = "middle_name";
    private static final String NAME_KEY = "name";
    private static final String PICTURE_URI_KEY = "picture_uri";
    /* access modifiers changed from: private */
    public static final String TAG = Profile.class.getSimpleName();
    private final String firstName;

    /* renamed from: id  reason: collision with root package name */
    private final String f37727id;
    private final String lastName;
    private final Uri linkUri;
    private final String middleName;
    private final String name;
    private final Uri pictureUri;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/Profile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/Profile;", "FIRST_NAME_KEY", "", "ID_KEY", "LAST_NAME_KEY", "LINK_URI_KEY", "MIDDLE_NAME_KEY", "NAME_KEY", "PICTURE_URI_KEY", "TAG", "kotlin.jvm.PlatformType", "fetchProfileForCurrentAccessToken", "", "getCurrentProfile", "setCurrentProfile", "profile", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void fetchProfileForCurrentAccessToken() {
            AccessToken.Companion companion = AccessToken.Companion;
            AccessToken currentAccessToken = companion.getCurrentAccessToken();
            if (currentAccessToken != null) {
                if (!companion.isCurrentAccessTokenActive()) {
                    setCurrentProfile((Profile) null);
                    return;
                }
                Utility utility = Utility.INSTANCE;
                Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new Profile$Companion$fetchProfileForCurrentAccessToken$1());
            }
        }

        public final Profile getCurrentProfile() {
            return ProfileManager.Companion.getInstance().getCurrentProfile();
        }

        public final void setCurrentProfile(Profile profile) {
            ProfileManager.Companion.getInstance().setCurrentProfile(profile);
        }
    }

    public /* synthetic */ Profile(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        this(str, str2, str3, str4, str5, uri, (Uri) null, 64, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, uri, (i10 & 64) != 0 ? null : uri2);
    }

    public static final void fetchProfileForCurrentAccessToken() {
        Companion.fetchProfileForCurrentAccessToken();
    }

    public static final Profile getCurrentProfile() {
        return Companion.getCurrentProfile();
    }

    public static final void setCurrentProfile(Profile profile) {
        Companion.setCurrentProfile(profile);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Uri uri;
        Uri uri2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        String str5 = this.f37727id;
        if (((str5 != null || ((Profile) obj).f37727id != null) && !j.b(str5, ((Profile) obj).f37727id)) || ((((str = this.firstName) != null || ((Profile) obj).firstName != null) && !j.b(str, ((Profile) obj).firstName)) || ((((str2 = this.middleName) != null || ((Profile) obj).middleName != null) && !j.b(str2, ((Profile) obj).middleName)) || ((((str3 = this.lastName) != null || ((Profile) obj).lastName != null) && !j.b(str3, ((Profile) obj).lastName)) || ((((str4 = this.name) != null || ((Profile) obj).name != null) && !j.b(str4, ((Profile) obj).name)) || ((((uri = this.linkUri) != null || ((Profile) obj).linkUri != null) && !j.b(uri, ((Profile) obj).linkUri)) || (((uri2 = this.pictureUri) != null || ((Profile) obj).pictureUri != null) && !j.b(uri2, ((Profile) obj).pictureUri)))))))) {
            return false;
        }
        return true;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getId() {
        return this.f37727id;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getPictureUri() {
        return this.pictureUri;
    }

    public final Uri getProfilePictureUri(int i10, int i11) {
        String str;
        Uri uri = this.pictureUri;
        if (uri != null) {
            return uri;
        }
        AccessToken.Companion companion = AccessToken.Companion;
        if (companion.isCurrentAccessTokenActive()) {
            AccessToken currentAccessToken = companion.getCurrentAccessToken();
            if (currentAccessToken == null) {
                str = null;
            } else {
                str = currentAccessToken.getToken();
            }
        } else {
            str = "";
        }
        return ImageRequest.Companion.getProfilePictureUri(this.f37727id, i10, i11, str);
    }

    public int hashCode() {
        int i10;
        String str = this.f37727id;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i11 = 527 + i10;
        String str2 = this.firstName;
        if (str2 != null) {
            i11 = (i11 * 31) + str2.hashCode();
        }
        String str3 = this.middleName;
        if (str3 != null) {
            i11 = (i11 * 31) + str3.hashCode();
        }
        String str4 = this.lastName;
        if (str4 != null) {
            i11 = (i11 * 31) + str4.hashCode();
        }
        String str5 = this.name;
        if (str5 != null) {
            i11 = (i11 * 31) + str5.hashCode();
        }
        Uri uri = this.linkUri;
        if (uri != null) {
            i11 = (i11 * 31) + uri.hashCode();
        }
        Uri uri2 = this.pictureUri;
        if (uri2 != null) {
            return (i11 * 31) + uri2.hashCode();
        }
        return i11;
    }

    public final b toJSONObject() {
        b bVar = new b();
        try {
            bVar.put("id", (Object) this.f37727id);
            bVar.put(FIRST_NAME_KEY, (Object) this.firstName);
            bVar.put("middle_name", (Object) this.middleName);
            bVar.put(LAST_NAME_KEY, (Object) this.lastName);
            bVar.put("name", (Object) this.name);
            Uri uri = this.linkUri;
            if (uri != null) {
                bVar.put(LINK_URI_KEY, (Object) uri.toString());
            }
            Uri uri2 = this.pictureUri;
            if (uri2 != null) {
                bVar.put(PICTURE_URI_KEY, (Object) uri2.toString());
            }
            return bVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i10) {
        String str;
        j.g(parcel, "dest");
        parcel.writeString(this.f37727id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        Uri uri = this.linkUri;
        String str2 = null;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        parcel.writeString(str);
        Uri uri2 = this.pictureUri;
        if (uri2 != null) {
            str2 = uri2.toString();
        }
        parcel.writeString(str2);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2) {
        Validate.notNullOrEmpty(str, "id");
        this.f37727id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
        this.pictureUri = uri2;
    }

    public Profile(b bVar) {
        Uri uri;
        j.g(bVar, "jsonObject");
        Uri uri2 = null;
        this.f37727id = bVar.optString("id", (String) null);
        this.firstName = bVar.optString(FIRST_NAME_KEY, (String) null);
        this.middleName = bVar.optString("middle_name", (String) null);
        this.lastName = bVar.optString(LAST_NAME_KEY, (String) null);
        this.name = bVar.optString("name", (String) null);
        String optString = bVar.optString(LINK_URI_KEY, (String) null);
        if (optString == null) {
            uri = null;
        } else {
            uri = Uri.parse(optString);
        }
        this.linkUri = uri;
        String optString2 = bVar.optString(PICTURE_URI_KEY, (String) null);
        this.pictureUri = optString2 != null ? Uri.parse(optString2) : uri2;
    }

    private Profile(Parcel parcel) {
        Uri uri;
        this.f37727id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        Uri uri2 = null;
        if (readString == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString);
        }
        this.linkUri = uri;
        String readString2 = parcel.readString();
        this.pictureUri = readString2 != null ? Uri.parse(readString2) : uri2;
    }
}
