package com.google.android.gms.oss.licenses;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.google.android.gms.internal.oss_licenses.zza;

final class c implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ OssLicensesMenuActivity f40533a;

    c(OssLicensesMenuActivity ossLicensesMenuActivity) {
        this.f40533a = ossLicensesMenuActivity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        Intent intent = new Intent(this.f40533a, OssLicensesActivity.class);
        intent.putExtra("license", (zza) adapterView.getItemAtPosition(i10));
        this.f40533a.startActivity(intent);
    }
}
