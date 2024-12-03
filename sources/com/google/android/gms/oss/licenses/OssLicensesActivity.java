package com.google.android.gms.oss.licenses;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.google.android.gms.internal.oss_licenses.zza;
import com.google.android.gms.internal.oss_licenses.zzc;
import xe.a;
import xe.b;

public final class OssLicensesActivity extends c {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.libraries_social_licenses_license_activity);
        zza zza = (zza) getIntent().getParcelableExtra("license");
        if (p0() != null) {
            p0().A(zza.toString());
            p0().w(true);
            p0().u(true);
            p0().y((Drawable) null);
        }
        TextView textView = (TextView) findViewById(a.license_activity_textview);
        String zza2 = zzc.zza(this, zza);
        if (zza2 == null) {
            zza2 = getString(xe.c.license_content_error);
        }
        textView.setText(zza2);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        ScrollView scrollView = (ScrollView) findViewById(a.license_activity_scrollview);
        scrollView.post(new a(this, bundle.getInt("scroll_pos"), scrollView));
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TextView textView = (TextView) findViewById(a.license_activity_textview);
        bundle.putInt("scroll_pos", textView.getLayout().getLineStart(textView.getLayout().getLineForVertical(((ScrollView) findViewById(a.license_activity_scrollview)).getScrollY())));
    }
}
