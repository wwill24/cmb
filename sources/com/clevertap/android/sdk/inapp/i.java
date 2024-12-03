package com.clevertap.android.sdk.inapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import i4.u;
import i4.v;

public class i extends f {
    /* access modifiers changed from: package-private */
    public ViewGroup M0(View view) {
        return (ViewGroup) view.findViewById(u.inapp_html_footer_frame_layout);
    }

    /* access modifiers changed from: package-private */
    public View N0(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(v.inapp_html_footer, viewGroup, false);
    }
}
