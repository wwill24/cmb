package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.google.android.gms.common.g;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f39044a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39045b;

    public r(@NonNull Context context) {
        p.k(context);
        Resources resources = context.getResources();
        this.f39044a = resources;
        this.f39045b = resources.getResourcePackageName(g.common_google_play_services_unknown_issue);
    }

    public String a(@NonNull String str) {
        int identifier = this.f39044a.getIdentifier(str, "string", this.f39045b);
        if (identifier == 0) {
            return null;
        }
        return this.f39044a.getString(identifier);
    }
}
