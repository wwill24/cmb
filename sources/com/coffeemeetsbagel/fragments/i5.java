package com.coffeemeetsbagel.fragments;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import f5.g;
import java.io.File;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import lc.c;
import lc.f;
import r7.b;
import r7.h;
import sb.a;
import t8.m;
import t8.n;
import t8.o;

public class i5 extends b implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: q  reason: collision with root package name */
    private static final String f13729q = (Bakery.w().getFilesDir() + "/output_a.png");

    /* renamed from: t  reason: collision with root package name */
    private static final String f13730t = (Bakery.w().getFilesDir() + "/output_b.png");

    /* renamed from: d  reason: collision with root package name */
    private GridView f13731d;

    /* renamed from: e  reason: collision with root package name */
    private g f13732e;

    /* renamed from: f  reason: collision with root package name */
    private String f13733f;

    /* renamed from: g  reason: collision with root package name */
    private String f13734g;

    /* renamed from: h  reason: collision with root package name */
    private int f13735h;

    /* renamed from: j  reason: collision with root package name */
    private String f13736j;

    /* renamed from: k  reason: collision with root package name */
    private h f13737k;

    /* renamed from: l  reason: collision with root package name */
    private long f13738l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f13739m;

    /* renamed from: n  reason: collision with root package name */
    private View f13740n;

    /* renamed from: p  reason: collision with root package name */
    private m f13741p;

    private void S0(Bitmap bitmap) {
        String str;
        if (isAdded()) {
            String i10 = f.i(bitmap, 100, Bakery.w().getFilesDir() + "/temp.png");
            Uri f10 = FileProvider.f(getActivity(), "com.coffeemeetsbagel.fileprovider", new File(i10));
            int i11 = this.f13735h;
            if (i11 == 0) {
                str = f13729q;
            } else {
                str = f13730t;
            }
            this.f13741p.f(f10, this.f13736j, i11, getActivity(), false, i10, str, (String) null, true);
            c.h(this.f13737k);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit T0(View view) {
        if (!isAdded()) {
            return null;
        }
        a.i(view, R.string.error_photo_selection);
        c.h(this.f13737k);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit U0(Bitmap bitmap) {
        S0(bitmap);
        return null;
    }

    public void onClick(View view) {
        getActivity().onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f13735h = arguments.getInt(Extra.PHOTO_INDEX);
        this.f13736j = arguments.getString(Extra.PHOTO_ID);
        this.f13741p = new o(L0(), (n) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f13740n = layoutInflater.inflate(R.layout.fragment_photos_grid_dls, (ViewGroup) null);
        this.f13732e = new g(getActivity(), 3);
        return this.f13740n;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        int i11 = i10;
        if (SystemClock.elapsedRealtime() - this.f13738l >= 1000) {
            this.f13738l = SystemClock.elapsedRealtime();
            if (isAdded()) {
                this.f13733f = this.f13732e.d(i11);
                this.f13734g = this.f13732e.e(i11);
                com.coffeemeetsbagel.image_loader.b.f13967a.b(requireContext(), this.f13734g, (ImageView) null, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, Collections.emptyList(), Collections.emptyMap(), new g5(this, view), new h5(this), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, (ImageLoaderContract.MemoryConfig[]) null);
                h hVar = new h(getActivity());
                this.f13737k = hVar;
                hVar.setCancelable(false);
                this.f13737k.show();
            }
        }
    }

    public void onPause() {
        super.onPause();
        c.h(this.f13737k);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("id", this.f13733f);
        bundle.putString("source", this.f13734g);
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f13731d = (GridView) view.findViewById(R.id.grid_photos);
        this.f13739m = (TextView) view.findViewById(R.id.txt_no_pics);
        this.f13731d.setAdapter(this.f13732e);
        this.f13731d.setOnItemClickListener(this);
        List<NetworkPhoto> photos = M0().j().getPhotos();
        this.f13732e.c(photos);
        if (CollectionUtils.isEmpty((List) photos)) {
            this.f13739m.setVisibility(0);
        } else {
            this.f13739m.setVisibility(8);
        }
    }
}
