package com.google.android.gms.oss.licenses;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.c;
import androidx.loader.app.a;
import androidx.loader.content.b;
import com.google.android.gms.internal.oss_licenses.zza;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class OssLicensesMenuActivity extends c implements a.C0065a<List<zza>> {

    /* renamed from: e  reason: collision with root package name */
    private static String f40526e;

    /* renamed from: c  reason: collision with root package name */
    private ArrayAdapter<zza> f40527c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40528d;

    private static boolean D0(@NonNull Context context, @NonNull String str) {
        boolean z10 = false;
        InputStream inputStream = null;
        try {
            Resources resources = context.getResources();
            InputStream openRawResource = resources.openRawResource(resources.getIdentifier(str, "raw", resources.getResourcePackageName(xe.a.license_list)));
            if (openRawResource.available() > 0) {
                z10 = true;
            }
            try {
                openRawResource.close();
            } catch (IOException unused) {
            }
            return z10;
        } catch (Resources.NotFoundException | IOException unused2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            return false;
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th2;
        }
    }

    /* renamed from: C0 */
    public final void K(b<List<zza>> bVar, List<zza> list) {
        this.f40527c.clear();
        this.f40527c.addAll(list);
        this.f40527c.notifyDataSetChanged();
    }

    public final b<List<zza>> L(int i10, Bundle bundle) {
        if (this.f40528d) {
            return new b(this);
        }
        return null;
    }

    public final void b0(b<List<zza>> bVar) {
        this.f40527c.clear();
        this.f40527c.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f40528d = D0(this, "third_party_licenses") && D0(this, "third_party_license_metadata");
        if (f40526e == null) {
            Intent intent = getIntent();
            if (intent.hasExtra("title")) {
                f40526e = intent.getStringExtra("title");
            }
        }
        String str = f40526e;
        if (str != null) {
            setTitle(str);
        }
        if (p0() != null) {
            p0().u(true);
        }
        if (this.f40528d) {
            setContentView(xe.b.libraries_social_licenses_license_menu_activity);
            this.f40527c = new ArrayAdapter<>(this, xe.b.libraries_social_licenses_license, xe.a.license, new ArrayList());
            getSupportLoaderManager().d(54321, (Bundle) null, this);
            ListView listView = (ListView) findViewById(xe.a.license_list);
            listView.setAdapter(this.f40527c);
            listView.setOnItemClickListener(new c(this));
            return;
        }
        setContentView(xe.b.license_menu_activity_no_licenses);
    }

    public final void onDestroy() {
        getSupportLoaderManager().a(54321);
        super.onDestroy();
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
