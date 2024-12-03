package com.coffeemeetsbagel.fragments;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.responses.ResponseFbAlbum;
import com.coffeemeetsbagel.transport.SuccessStatus;
import f5.d;
import h5.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.Unit;
import lc.c;
import lc.f;
import r7.b;
import r7.h;
import t8.m;
import t8.n;
import t8.o;

public class x0 extends b implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: d  reason: collision with root package name */
    private View f13866d;

    /* renamed from: e  reason: collision with root package name */
    private GridView f13867e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f13868f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13869g;

    /* renamed from: h  reason: collision with root package name */
    private d f13870h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f13871j;

    /* renamed from: k  reason: collision with root package name */
    private String f13872k;

    /* renamed from: l  reason: collision with root package name */
    private String f13873l;

    /* renamed from: m  reason: collision with root package name */
    private jc.b<ResponseFbAlbum> f13874m;

    /* renamed from: n  reason: collision with root package name */
    private int f13875n;

    /* renamed from: p  reason: collision with root package name */
    private String f13876p;

    /* renamed from: q  reason: collision with root package name */
    private String f13877q;

    /* renamed from: t  reason: collision with root package name */
    private h f13878t;

    /* renamed from: w  reason: collision with root package name */
    private long f13879w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f13880x;

    /* renamed from: y  reason: collision with root package name */
    private String f13881y;

    /* renamed from: z  reason: collision with root package name */
    private m f13882z;

    class a implements jc.b<ResponseFbAlbum> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f13883a;

        a(String str) {
            this.f13883a = str;
        }

        public void b(CmbErrorCode cmbErrorCode) {
            fa.a.f("FragmentAlbumFb", "error=" + cmbErrorCode.getErrorMessage());
            if (x0.this.getActivity() != null) {
                sb.a.i(x0.this.f13868f, R.string.error_getting_fb_album);
            }
            x0.this.d1();
        }

        /* renamed from: c */
        public void a(ResponseFbAlbum responseFbAlbum, SuccessStatus successStatus) {
            x0.this.W0(responseFbAlbum);
            if (!TextUtils.isEmpty(responseFbAlbum.getAfter())) {
                x0.this.X0(this.f13883a, (String) null, responseFbAlbum.getAfter());
            }
        }
    }

    /* access modifiers changed from: private */
    public void W0(ResponseFbAlbum responseFbAlbum) {
        if (!this.f13871j) {
            this.f13870h.g(new ArrayList(responseFbAlbum.getFacebookPhotos()));
            int i10 = 0;
            this.f13866d.setVisibility(0);
            if (this.f13870h.getCount() != 0) {
                i10 = 8;
            }
            this.f13869g.setVisibility(i10);
            this.f13867e.setClickable(true);
            this.f13867e.setOnItemClickListener(this);
        }
    }

    /* access modifiers changed from: private */
    public void X0(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("albumId=");
        sb2.append(str);
        sb2.append(", pagingUrl=");
        sb2.append(str2);
        this.f13869g.setVisibility(8);
        a aVar = new a(str);
        this.f13874m = aVar;
        l.f(aVar, str, str2, str3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit Y0() {
        b1();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit Z0(Bitmap bitmap) {
        c1(bitmap);
        return null;
    }

    /* access modifiers changed from: private */
    public void d1() {
        if (getActivity() != null) {
            this.f13869g.setVisibility(0);
        }
    }

    public void b1() {
        if (isAdded()) {
            sb.a.i(this.f13868f, R.string.error_photo_selection);
            c.h(this.f13878t);
        }
    }

    public void c1(Bitmap bitmap) {
        if (isAdded()) {
            String i10 = f.i(bitmap, 100, Bakery.w().getFilesDir() + "/temp.png");
            Uri f10 = FileProvider.f(requireActivity(), "com.coffeemeetsbagel.fileprovider", new File(i10));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("path=");
            sb2.append(i10);
            this.f13882z.f(f10, this.f13876p, this.f13875n, getActivity(), this.f13880x, i10, i10, (String) null, true);
            c.h(this.f13878t);
        }
    }

    public void onClick(View view) {
        requireActivity().onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f13882z = new o(L0(), (n) null);
        if (arguments != null) {
            this.f13877q = arguments.getString("id");
            this.f13880x = arguments.getBoolean(Extra.SHOULD_SHOW_CAPTION_FLOW, true);
            this.f13875n = arguments.getInt(Extra.PHOTO_INDEX);
            this.f13876p = arguments.getString(Extra.PHOTO_ID);
            this.f13881y = arguments.getString(Extra.IMAGE_PATH, this.f13882z.d());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mPhotoIndex=");
        sb2.append(this.f13875n);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_photos_grid_dls, viewGroup, false);
        this.f13868f = (RelativeLayout) inflate.findViewById(R.id.relative_layout);
        this.f13870h = new d(getActivity(), 3);
        this.f13871j = false;
        return inflate;
    }

    public void onDestroyView() {
        this.f13871j = true;
        super.onDestroyView();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        int i11 = i10;
        if (SystemClock.elapsedRealtime() - this.f13879w >= 1000) {
            this.f13879w = SystemClock.elapsedRealtime();
            if (isAdded()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("position=");
                sb2.append(i11);
                this.f13872k = this.f13870h.h(i11);
                this.f13873l = this.f13870h.i(i11);
                h hVar = new h(getActivity());
                this.f13878t = hVar;
                hVar.setCancelable(false);
                this.f13878t.show();
                com.coffeemeetsbagel.image_loader.b.f13967a.b(requireContext(), this.f13873l, (ImageView) null, (Integer) null, (Integer) null, (ImageLoaderContract.b) null, Collections.emptyList(), Collections.emptyMap(), new v0(this), new w0(this), (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.f13874m = null;
        c.h(this.f13878t);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("id", this.f13872k);
        bundle.putString("source", this.f13873l);
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f13867e = (GridView) view.findViewById(R.id.grid_photos);
        this.f13869g = (TextView) view.findViewById(R.id.txt_no_pics);
        this.f13866d = view.findViewById(R.id.grid_container);
        this.f13867e.setAdapter(this.f13870h);
        X0(this.f13877q, (String) null, (String) null);
    }
}
