package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

class p extends LinearLayoutManager {

    class a extends androidx.recyclerview.widget.p {
        a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    p(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    public void J1(RecyclerView recyclerView, RecyclerView.z zVar, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i10);
        K1(aVar);
    }
}
