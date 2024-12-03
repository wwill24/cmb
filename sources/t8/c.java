package t8;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.content.FileProvider;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityCaption;
import com.coffeemeetsbagel.activities.ActivityPhotoSelect;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.domain.repository.PhotoRepository;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.models.enums.HttpMethod;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.util.RequestCode;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.ServerProtocol;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.FieldNamingPolicy;
import h5.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lc.f;
import lc.o;
import lc.r;
import okhttp3.a0;
import okhttp3.x;
import t8.l;

public class c implements l {

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f17861i = {"com.sec.android.mimage.photoretouching"};

    /* renamed from: a  reason: collision with root package name */
    private final PhotoRepository f17862a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f17863b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f17864c;

    /* renamed from: d  reason: collision with root package name */
    private String f17865d;

    /* renamed from: e  reason: collision with root package name */
    private String f17866e;

    /* renamed from: f  reason: collision with root package name */
    private final k f17867f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final y7.a f17868g;

    /* renamed from: h  reason: collision with root package name */
    private final ProfileContract$Manager f17869h;

    class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17870a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f17871b;

        a(String str, int i10) {
            this.f17870a = str;
            this.f17871b = i10;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            f.j(this.f17870a, true, c.this.a(this.f17871b));
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            c.this.f17868g.a(EventType.PROFILE_UPDATE);
        }
    }

    class b implements AccessToken.AccessTokenRefreshCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l.a f17873a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f17874b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f17875c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f17876d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f17877e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f17878f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ View f17879g;

        b(l.a aVar, Activity activity, int i10, boolean z10, String str, String str2, View view) {
            this.f17873a = aVar;
            this.f17874b = activity;
            this.f17875c = i10;
            this.f17876d = z10;
            this.f17877e = str;
            this.f17878f = str2;
            this.f17879g = view;
        }

        public void OnTokenRefreshFailed(FacebookException facebookException) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Exception refreshing facebook token ");
            sb2.append(facebookException.getMessage());
            if (facebookException.getMessage().equals("No current access token to refresh")) {
                c.this.D(this.f17874b, this.f17875c, this.f17876d, this.f17877e, this.f17878f, this.f17879g, this.f17873a);
                LoginManager.getInstance().logInWithReadPermissions(this.f17874b, (Collection<String>) h5.l.i());
                return;
            }
            this.f17873a.a();
            c.this.E(this.f17874b, R.string.error_getting_fb_albums);
        }

        public void OnTokenRefreshed(AccessToken accessToken) {
            Bakery.w().r().b(accessToken);
            if (!h5.l.l("user_photos") || accessToken.isExpired()) {
                c.this.D(this.f17874b, this.f17875c, this.f17876d, this.f17877e, this.f17878f, this.f17879g, this.f17873a);
                if (accessToken.isExpired()) {
                    LoginManager.getInstance().logInWithReadPermissions(this.f17874b, (Collection<String>) Collections.singletonList("user_photos"));
                } else {
                    LoginManager.getInstance().logInWithReadPermissions(this.f17874b, (Collection<String>) h5.l.i());
                }
            } else {
                this.f17873a.a();
                c.this.F(this.f17874b, this.f17875c, this.f17876d, this.f17877e, this.f17878f);
            }
        }
    }

    /* renamed from: t8.c$c  reason: collision with other inner class name */
    class C0209c implements FacebookCallback<LoginResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l.a f17881a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f17882b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f17883c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f17884d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f17885e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f17886f;

        C0209c(l.a aVar, Activity activity, int i10, boolean z10, String str, String str2) {
            this.f17881a = aVar;
            this.f17882b = activity;
            this.f17883c = i10;
            this.f17884d = z10;
            this.f17885e = str;
            this.f17886f = str2;
        }

        /* renamed from: a */
        public void onSuccess(LoginResult loginResult) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("loginResult=");
            sb2.append(loginResult);
            this.f17881a.a();
            Bakery.w().r().b(loginResult.getAccessToken());
            c.this.F(this.f17882b, this.f17883c, this.f17884d, this.f17885e, this.f17886f);
        }

        public void onCancel() {
            this.f17881a.a();
            c.this.E(this.f17882b, R.string.error_permissions);
        }

        public void onError(FacebookException facebookException) {
            fa.a.f("ManagerPhotos", facebookException.getMessage());
            this.f17881a.a();
            c.this.E(this.f17882b, R.string.error_permissions);
        }
    }

    class d extends AsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17888a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Uri f17889b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17890c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f17891d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f17892e;

        d(Activity activity, Uri uri, String str, boolean z10, boolean z11) {
            this.f17888a = activity;
            this.f17889b = uri;
            this.f17890c = str;
            this.f17891d = z10;
            this.f17892e = z11;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0038 A[SYNTHETIC, Splitter:B:20:0x0038] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0048 A[SYNTHETIC, Splitter:B:30:0x0048] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0054 A[SYNTHETIC, Splitter:B:37:0x0054] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0033=Splitter:B:17:0x0033, B:27:0x0043=Splitter:B:27:0x0043} */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.Void... r8) {
            /*
                r7 = this;
                r8 = 0
                android.app.Activity r0 = r7.f17888a     // Catch:{ IOException -> 0x0041, SecurityException -> 0x0031, all -> 0x002c }
                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ IOException -> 0x0041, SecurityException -> 0x0031, all -> 0x002c }
                android.net.Uri r1 = r7.f17889b     // Catch:{ IOException -> 0x0041, SecurityException -> 0x0031, all -> 0x002c }
                java.io.InputStream r0 = r0.openInputStream(r1)     // Catch:{ IOException -> 0x0041, SecurityException -> 0x0031, all -> 0x002c }
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ IOException -> 0x002a, SecurityException -> 0x0028 }
                t8.c r2 = t8.c.this     // Catch:{ IOException -> 0x002a, SecurityException -> 0x0028 }
                android.app.Activity r3 = r7.f17888a     // Catch:{ IOException -> 0x002a, SecurityException -> 0x0028 }
                android.net.Uri r4 = r7.f17889b     // Catch:{ IOException -> 0x002a, SecurityException -> 0x0028 }
                java.lang.String r5 = r7.f17890c     // Catch:{ IOException -> 0x002a, SecurityException -> 0x0028 }
                java.lang.String r8 = r2.g(r1, r3, r4, r5)     // Catch:{ IOException -> 0x002a, SecurityException -> 0x0028 }
                if (r0 == 0) goto L_0x0027
                r0.close()     // Catch:{ IOException -> 0x0023 }
                goto L_0x0027
            L_0x0023:
                r0 = move-exception
                fa.a.i(r0)
            L_0x0027:
                return r8
            L_0x0028:
                r1 = move-exception
                goto L_0x0033
            L_0x002a:
                r1 = move-exception
                goto L_0x0043
            L_0x002c:
                r0 = move-exception
                r6 = r0
                r0 = r8
                r8 = r6
                goto L_0x0052
            L_0x0031:
                r1 = move-exception
                r0 = r8
            L_0x0033:
                fa.a.i(r1)     // Catch:{ all -> 0x0051 }
                if (r0 == 0) goto L_0x0040
                r0.close()     // Catch:{ IOException -> 0x003c }
                goto L_0x0040
            L_0x003c:
                r0 = move-exception
                fa.a.i(r0)
            L_0x0040:
                return r8
            L_0x0041:
                r1 = move-exception
                r0 = r8
            L_0x0043:
                fa.a.i(r1)     // Catch:{ all -> 0x0051 }
                if (r0 == 0) goto L_0x0050
                r0.close()     // Catch:{ IOException -> 0x004c }
                goto L_0x0050
            L_0x004c:
                r0 = move-exception
                fa.a.i(r0)
            L_0x0050:
                return r8
            L_0x0051:
                r8 = move-exception
            L_0x0052:
                if (r0 == 0) goto L_0x005c
                r0.close()     // Catch:{ IOException -> 0x0058 }
                goto L_0x005c
            L_0x0058:
                r0 = move-exception
                fa.a.i(r0)
            L_0x005c:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: t8.c.d.doInBackground(java.lang.Void[]):java.lang.String");
        }

        /* renamed from: b */
        public void onPostExecute(String str) {
            if (str != null) {
                c cVar = c.this;
                cVar.k(this.f17889b, cVar.f17863b, c.this.f17864c, this.f17888a, this.f17891d, str, this.f17890c, (String) null, true, this.f17892e);
                i.b(EventType.PHOTO_DOWNLOAD_OPERATION_COMPLETE);
                return;
            }
            i.b(EventType.PHOTO_DOWNLOAD_OPERATION_FAILED);
        }
    }

    class e implements z9.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17894a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Uri f17895b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17896c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f17897d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f17898e;

        e(Activity activity, Uri uri, String str, boolean z10, boolean z11) {
            this.f17894a = activity;
            this.f17895b = uri;
            this.f17896c = str;
            this.f17897d = z10;
            this.f17898e = z11;
        }

        public void a(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            i.b(EventType.PHOTO_DOWNLOAD_OPERATION_COMPLETE);
            if (bitmap2 == null) {
                c.this.E(this.f17894a, R.string.error_downloading_bitmap_from_url);
                return;
            }
            try {
                String g10 = c.this.g(f.c(bitmap2, 1284, 1284), this.f17894a, this.f17895b, this.f17896c);
                c cVar = c.this;
                cVar.k(this.f17895b, cVar.f17863b, c.this.f17864c, this.f17894a, this.f17897d, g10, this.f17896c, (String) null, true, this.f17898e);
            } catch (IllegalStateException e10) {
                fa.a.g("ManagerPhotos", "Failed to prep image " + this.f17895b, e10);
                c.this.E(this.f17894a, R.string.error_downloading_bitmap_from_url);
            }
        }
    }

    public c(PhotoRepository photoRepository, y7.a aVar, k kVar, ProfileContract$Manager profileContract$Manager) {
        this.f17862a = photoRepository;
        this.f17867f = kVar;
        this.f17868g = aVar;
        this.f17869h = profileContract$Manager;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void A(Integer num) throws Exception {
    }

    private List<ResolveInfo> C(List<ResolveInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo next : list) {
            if (z(next.activityInfo.packageName)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void D(Activity activity, int i10, boolean z10, String str, String str2, View view, l.a aVar) {
        LoginManager.getInstance().registerCallback(h5.l.h(), new C0209c(aVar, activity, i10, z10, str, str2));
    }

    /* access modifiers changed from: private */
    public void E(Activity activity, int i10) {
        sb.a.i(activity.getWindow().getDecorView().findViewById(16908290), i10);
    }

    /* access modifiers changed from: private */
    public void F(Activity activity, int i10, boolean z10, String str, String str2) {
        this.f17864c = i10;
        this.f17863b = str;
        Intent intent = new Intent(activity, ActivityPhotoSelect.class);
        intent.putExtra(Extra.PHOTO_INDEX, i10);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(Extra.PHOTO_ID, str);
        }
        intent.putExtra(Extra.SHOULD_SHOW_CAPTION_FLOW, z10);
        intent.putExtra(Extra.IMAGE_PATH, str2);
        intent.putExtra(Extra.KEY_PHOTO_SELECT_SOURCE, Extra.SOURCE_FACEBOOK);
        lc.a.d(activity, intent, RequestCode.PICK_PHOTO_FACEBOOK_OR_INSTAGRAM);
    }

    private void u(Intent intent, int i10) {
        intent.putExtra("crop", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
    }

    private void v(Intent intent, Uri uri) {
        intent.putExtra("output", uri);
        intent.addFlags(3);
        intent.setClipData(ClipData.newRawUri("output", uri));
    }

    public static ResponseGeneric w(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("photoId=");
        sb2.append(str);
        x d10 = r.d();
        String str2 = x4.a.f18540d + "photo" + RemoteSettings.FORWARD_SLASH_STRING + str;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("url=");
        sb3.append(str2);
        try {
            a0 f10 = d10.a(lc.e.c(str2, HttpMethod.DELETE, (String) null, (String) null)).f();
            int f11 = f10.f();
            String string = f10.a().string();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("responseCode=");
            sb4.append(f11);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("responseBody=");
            sb5.append(string);
            if (f10.f() == 200) {
                ResponseGeneric responseGeneric = (ResponseGeneric) new com.google.gson.e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b().k(string, ResponseGeneric.class);
                responseGeneric.setStatusCode(f11);
                return responseGeneric;
            }
            throw new Exception("Response Code " + f10.f());
        } catch (Exception e10) {
            Log.getStackTraceString(e10);
            ResponseGeneric responseGeneric2 = new ResponseGeneric("Error: " + e10.getMessage(), 0);
            responseGeneric2.setStatusCode(0);
            return responseGeneric2;
        }
    }

    private int x(Uri uri, Context context) {
        boolean z10;
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"orientation"}, (String) null, (String[]) null, (String) null);
            if (cursor != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            ha.a.d(z10, "Cursor from ImageLoader Photos is null");
            int i10 = -1;
            if (cursor != null) {
                if (cursor.getCount() != 1) {
                    cursor.close();
                    return -1;
                }
                cursor.moveToFirst();
                i10 = cursor.getInt(0);
            }
            return i10;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void y(String str, Activity activity, String str2, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("goToCaptionFlow()--path=");
        sb2.append(str);
        f.f(str);
        Intent intent = new Intent(activity, ActivityCaption.class);
        intent.putExtra(Extra.IMAGE_PATH, str);
        intent.putExtra("caption", str2);
        intent.putExtra(Extra.USE_2020_DESIGN_LANGUAGE, z10);
        lc.a.d(activity, intent, RequestCode.CAPTION);
    }

    private boolean z(String str) {
        return !Arrays.asList(f17861i).contains(str);
    }

    public void G(int i10, String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("photoIdSelected=");
        sb2.append(str2);
        sb2.append(", imagePath=");
        sb2.append(str);
        sb2.append(", photoIndex=");
        sb2.append(i10);
        sb2.append(", caption=");
        sb2.append(str3);
        Bundle bundle = new Bundle();
        bundle.putString(Extra.PHOTO_ID, str2);
        bundle.putInt(Extra.PHOTO_INDEX, i10);
        bundle.putString("caption", str3);
        this.f17868g.b(EventType.PHOTO_PRE_UPLOAD_DONE, bundle);
        this.f17867f.d(str2, i10, str3, str);
        new a(str, i10).execute(new Void[0]);
    }

    public String a(int i10) {
        return Bakery.w().getFilesDir() + "/profile_image" + i10 + ".png";
    }

    @SuppressLint({"CheckResult"})
    public void b(List<Photo> list) {
        if (!CollectionUtils.isEmpty((List) list)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                Photo photo = list.get(i10);
                arrayList.add(new Photo(photo.c(), photo.a(), i10, photo.e(), photo.getUrl()));
                arrayList2.add(new NetworkPhoto(i10, photo.getUrl(), photo.c(), photo.e(), photo.a()));
            }
            this.f17862a.n(arrayList).b(new a(), new b());
            this.f17869h.j().setPhotos(arrayList2);
            i.b(EventType.PROFILE_UPDATE);
            this.f17867f.b(arrayList2);
        }
    }

    public void c(jc.b<Integer> bVar, String str, int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("photoIdSelected=");
        sb2.append(str);
        sb2.append(", photoIndex=");
        sb2.append(i10);
        this.f17867f.c(bVar, str, i10);
    }

    public void clear() {
        NetworkProfile j10 = this.f17869h.j();
        if (j10 != null) {
            for (NetworkPhoto position : j10.getPhotos()) {
                o.b(a(position.getPosition()));
            }
        }
    }

    public String d() {
        return Bakery.w().getFilesDir() + "/output.png";
    }

    public String e() {
        return Bakery.w().getFilesDir() + "/profile_image_temp.png";
    }

    public void f(int i10) {
        o.b(a(i10));
    }

    public String g(Bitmap bitmap, Activity activity, Uri uri, String str) {
        int i10;
        try {
            i10 = x(uri, activity);
        } catch (Exception e10) {
            fa.a.g("ManagerPhotos", "Could not get image orientation for " + uri, e10);
            i10 = -1;
        }
        f.i(f.c(f.d(bitmap, i10), 1284, 1284), 100, str);
        return str;
    }

    public void h(Activity activity, int i10, boolean z10, String str, String str2) {
        this.f17864c = i10;
        this.f17863b = str;
        Intent intent = new Intent(activity, ActivityPhotoSelect.class);
        intent.putExtra(Extra.PHOTO_INDEX, i10);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(Extra.PHOTO_ID, str);
        }
        intent.putExtra(Extra.SHOULD_SHOW_CAPTION_FLOW, z10);
        intent.putExtra(Extra.IMAGE_PATH, str2);
        intent.putExtra(Extra.KEY_PHOTO_SELECT_SOURCE, Extra.SOURCE_INSTAGRAM);
        lc.a.d(activity, intent, RequestCode.PICK_PHOTO_FACEBOOK_OR_INSTAGRAM);
    }

    public void i(Activity activity, int i10, int i11, Intent intent) {
        boolean z10;
        String str;
        Activity activity2 = activity;
        int i12 = i10;
        int i13 = i11;
        Intent intent2 = intent;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("requestCode=");
        sb2.append(i12);
        sb2.append(", resultCode=");
        sb2.append(i13);
        sb2.append(", data=");
        sb2.append(intent2);
        if (intent2 == null || !intent2.getBooleanExtra(Extra.USE_2020_DESIGN_LANGUAGE, false)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (i12 != 1003) {
            if (i12 == 6600 || i12 == 6500) {
                if (i13 == -1) {
                    G(this.f17864c, this.f17865d, this.f17863b, intent2.getStringExtra("caption"));
                }
            } else if (i12 == 6501 && i13 == -1) {
                Uri data = intent.getData();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("result from #gallery #photo pick uri = ");
                sb3.append(data);
                if (intent2.hasExtra(Extra.IMAGE_PATH)) {
                    str = intent2.getStringExtra(Extra.IMAGE_PATH);
                } else {
                    str = d();
                }
                String str2 = str;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("#photo sPhotoIndexSelected=");
                sb4.append(this.f17864c);
                boolean booleanExtra = intent2.getBooleanExtra(Extra.SHOULD_SHOW_CAPTION_FLOW, true);
                if (data.getAuthority() != null) {
                    i.b(EventType.PHOTO_DOWNLOADING);
                    new d(activity, data, str2, booleanExtra, z10).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                }
                try {
                    String c10 = o.c(data);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("#photo path=");
                    sb5.append(c10);
                    int indexOf = c10.indexOf("http");
                    if (indexOf >= 0) {
                        String substring = c10.substring(indexOf, c10.length() - 1);
                        E(activity2, R.string.downloading_bitmap_from_url);
                        i.b(EventType.PHOTO_DOWNLOADING);
                        new ac.a(new e(activity, data, str2, booleanExtra, z10)).execute(new String[]{substring});
                        return;
                    }
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Filesystem photo path =");
                    sb6.append(c10);
                    k(data, this.f17863b, this.f17864c, activity, booleanExtra, c10, str2, (String) null, true, z10);
                } catch (Exception unused) {
                    fa.a.f("ManagerPhotos", "Could not get path for image, maybe deleted");
                }
            }
        } else if (i13 == -1) {
            y(this.f17865d, activity2, this.f17866e, z10);
        }
    }

    public void j(Activity activity, int i10, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("activity=");
        sb2.append(activity);
        this.f17864c = i10;
        this.f17863b = str;
        try {
            lc.a.d(activity, new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), RequestCode.PICK_PHOTO_GALLERY);
        } catch (ActivityNotFoundException unused) {
            E(activity, R.string.error_no_picker_intent);
        }
    }

    public boolean k(Uri uri, String str, int i10, Activity activity, boolean z10, String str2, String str3, String str4, boolean z11, boolean z12) {
        String str5;
        Uri uri2 = uri;
        String str6 = str;
        int i11 = i10;
        Activity activity2 = activity;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pictureUri=");
        sb2.append(uri2);
        sb2.append(", photoIdSelected=");
        sb2.append(str6);
        sb2.append(", photoIndex=");
        sb2.append(i11);
        sb2.append(", outputFilePath=");
        sb2.append(str8);
        if (z11) {
            str5 = "com.android.camera.action.CROP";
        } else {
            str5 = "android.intent.action.EDIT";
        }
        File file = new File(str8);
        Uri f10 = FileProvider.f(activity2, "com.coffeemeetsbagel.fileprovider", file);
        Intent intent = new Intent(str5);
        intent.setDataAndType(f10, "image/*");
        v(intent, f10);
        u(intent, 1284);
        this.f17863b = str6;
        this.f17864c = i11;
        this.f17866e = str9;
        try {
            List<ResolveInfo> C = C(activity.getPackageManager().queryIntentActivities(intent, 0));
            if (!C.isEmpty()) {
                this.f17865d = str8;
                ArrayList arrayList = new ArrayList();
                for (ResolveInfo resolveInfo : C) {
                    String str10 = resolveInfo.activityInfo.packageName;
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setPackage(str10);
                    arrayList.add(intent2);
                }
                Intent createChooser = Intent.createChooser((Intent) arrayList.remove(0), activity2.getString(R.string.edit_with));
                createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
                lc.a.d(activity2, createChooser, 1003);
                return true;
            }
            throw new IllegalStateException("No photo editing app!!!");
        } catch (Exception e10) {
            fa.a.f("ManagerPhotos", "error listing edit image apps=" + e10.getMessage());
            if (z10) {
                this.f17865d = str7;
                y(str7, activity2, str9, z12);
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt(Extra.PHOTO_INDEX, i11);
                bundle.putString(Extra.PHOTO_ID, str6);
                new File(str7).renameTo(file);
                bundle.putString(Extra.IMAGE_PATH, str8);
                Intent intent3 = new Intent();
                intent3.setData(uri2);
                intent3.putExtra(Extra.PHOTO_INDEX, i11);
                activity2.setIntent(intent3);
                i.c(EventType.PHOTO_READY_NO_CAPTION, bundle);
            }
            return false;
        }
    }

    public void l(Activity activity, int i10, boolean z10, String str, String str2, View view, l.a aVar) {
        AccessToken.refreshCurrentAccessTokenAsync(new b(aVar, activity, i10, z10, str, str2, view));
    }
}
