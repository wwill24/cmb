package com.coffeemeetsbagel.feature.chat.features.photo;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.image_loader.b;
import com.coffeemeetsbagel.models.constants.Extra;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import j5.r;
import java.io.File;
import java.util.Collections;
import kotlin.Unit;
import l7.c;
import l7.d;
import l7.e;
import l7.f;
import l7.g;
import org.jivesoftware.smackx.message_fastening.element.ExternalElement;

public class FullscreenPhotoActivity extends r implements f {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public e f12827b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f12828c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f12829d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f12830e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12831f;

    /* renamed from: g  reason: collision with root package name */
    private final long f12832g = 10000000;

    /* renamed from: h  reason: collision with root package name */
    private final String f12833h = "FullscreenPhotoActivity";

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            FullscreenPhotoActivity.this.f12827b.q();
        }
    }

    private static String k(Context context, Uri uri, String str, String[] strArr) {
        String[] strArr2 = {"_data"};
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, strArr2, str, strArr, (String) null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow(strArr2[0]));
                        if (!query.isClosed()) {
                            query.close();
                        }
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    cursor.close();
                    throw th;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    private File l(String str) {
        String m10 = m(this, Uri.parse(str));
        if (!TextUtils.isEmpty(m10)) {
            return new File(m10);
        }
        return null;
    }

    private String m(Context context, Uri uri) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("uri:");
        sb2.append(uri.getAuthority());
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] split = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                String str = split[0];
                if ("primary".equalsIgnoreCase(str)) {
                    return Environment.getExternalStorageDirectory() + RemoteSettings.FORWARD_SLASH_STRING + split[1];
                }
                return "/storage/" + str + RemoteSettings.FORWARD_SLASH_STRING + split[1];
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                return k(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
            } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                return k(context, MediaStore.Files.getContentUri(ExternalElement.ELEMENT), "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return k(context, uri, (String) null, (String[]) null);
        } else {
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit n() {
        if (!this.f12831f) {
            return null;
        }
        this.f12830e.setVisibility(8);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit o(Bitmap bitmap) {
        if (!this.f12831f) {
            return null;
        }
        this.f12830e.setVisibility(8);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit p() {
        if (!this.f12831f) {
            return null;
        }
        this.f12830e.setVisibility(8);
        s();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit q(Bitmap bitmap) {
        if (!this.f12831f) {
            return null;
        }
        this.f12829d.setVisibility(0);
        this.f12830e.setVisibility(8);
        return null;
    }

    private void s() {
        sb.a.g(getWindow().getDecorView().findViewById(16908290), R.string.media_upload_error);
    }

    public void a() {
        setResult(0);
        finish();
    }

    public void b(String str) {
        this.f12830e.setVisibility(0);
        b.f13967a.b(this, str, this.f12828c, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, Collections.emptyList(), Collections.emptyMap(), new c(this), new d(this), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
    }

    public void c(String str) {
        if (str == null) {
            a();
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(Extra.IMAGE_URI, str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public void d() {
        this.f12829d.setOnClickListener(new a());
    }

    public void e(String str) {
        this.f12830e.setVisibility(0);
        File l10 = l(str);
        if (l10 == null || l10.length() > 10000000) {
            if (l10 == null) {
                fa.a.i(new NullPointerException("photo file null"));
            } else if (l10.length() > 10000000) {
                fa.a.i(new Exception("photo file too large"));
            }
            this.f12830e.setVisibility(8);
            r();
            return;
        }
        b.f13967a.b(this, str, this.f12828c, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, Collections.emptyList(), Collections.emptyMap(), new l7.a(this), new l7.b(this), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
    }

    public void onBackPressed() {
        this.f12827b.r();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fullscreen_photo);
        this.f12828c = (ImageView) findViewById(R.id.photo_view);
        this.f12829d = (ImageView) findViewById(R.id.send_button);
        this.f12830e = (ProgressBar) findViewById(R.id.progress_bar);
        g gVar = new g(this, getIntent());
        this.f12827b = gVar;
        gVar.start();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f12831f = false;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f12831f = true;
    }

    public void r() {
        setResult(53);
        finish();
    }
}
