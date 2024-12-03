package com.coffeemeetsbagel.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityPhotoSelect;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.models.responses.ResponseFbAlbums;
import com.coffeemeetsbagel.transport.SuccessStatus;
import f5.c;
import h5.l;
import jc.b;

public class z0 extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar f13896a;

    /* renamed from: b  reason: collision with root package name */
    private ListView f13897b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public TextView f13898c;

    /* renamed from: d  reason: collision with root package name */
    private c f13899d;

    /* renamed from: e  reason: collision with root package name */
    private b<ResponseFbAlbums> f13900e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f13901f;

    class a implements b<ResponseFbAlbums> {
        a() {
        }

        public void b(CmbErrorCode cmbErrorCode) {
            fa.a.f("FragmentAlbumFb", "error=" + cmbErrorCode.getErrorMessage());
            if (z0.this.getActivity() != null) {
                sb.a.i(z0.this.f13901f, R.string.error_getting_fb_albums);
            }
            z0.this.f13896a.setVisibility(8);
            z0.this.f13898c.setVisibility(0);
        }

        /* renamed from: c */
        public void a(ResponseFbAlbums responseFbAlbums, SuccessStatus successStatus) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("status=");
            sb2.append(successStatus);
            z0.this.G0(responseFbAlbums);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F0(AdapterView adapterView, View view, int i10, long j10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("position=");
        sb2.append(i10);
        ((ActivityPhotoSelect) requireActivity()).H1(this.f13899d.getItem(i10).getId(), this.f13899d.getItem(i10).getName());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
        r1 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        r4.f13898c.setVisibility(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        if (r4.f13899d.getCount() != 0) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        if (r4.f13899d.getCount() == 0) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void G0(com.coffeemeetsbagel.models.responses.ResponseFbAlbums r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "responseFbAlbums="
            r0.append(r1)
            r0.append(r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 8
            java.util.List r3 = r5.getFacebookAlbums()     // Catch:{ Exception -> 0x0049 }
            r0.addAll(r3)     // Catch:{ Exception -> 0x0049 }
            com.coffeemeetsbagel.models.FacebookAlbum r5 = r5.getTaggedAlbum()     // Catch:{ Exception -> 0x0049 }
            f5.c r3 = r4.f13899d
            r3.h(r0)
            if (r5 == 0) goto L_0x0032
            java.lang.String r0 = r5.getId()
            if (r0 == 0) goto L_0x0032
            f5.c r0 = r4.f13899d
            r0.c(r5, r1)
        L_0x0032:
            android.widget.ProgressBar r5 = r4.f13896a
            r5.setVisibility(r2)
            f5.c r5 = r4.f13899d
            int r5 = r5.getCount()
            if (r5 != 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r1 = r2
        L_0x0041:
            android.widget.TextView r5 = r4.f13898c
            r5.setVisibility(r1)
            goto L_0x0066
        L_0x0047:
            r5 = move-exception
            goto L_0x0067
        L_0x0049:
            r5 = move-exception
            java.lang.String r3 = "FragmentAlbumFb"
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0047 }
            fa.a.f(r3, r5)     // Catch:{ all -> 0x0047 }
            f5.c r5 = r4.f13899d
            r5.h(r0)
            android.widget.ProgressBar r5 = r4.f13896a
            r5.setVisibility(r2)
            f5.c r5 = r4.f13899d
            int r5 = r5.getCount()
            if (r5 != 0) goto L_0x0040
            goto L_0x0041
        L_0x0066:
            return
        L_0x0067:
            f5.c r3 = r4.f13899d
            r3.h(r0)
            android.widget.ProgressBar r0 = r4.f13896a
            r0.setVisibility(r2)
            f5.c r0 = r4.f13899d
            int r0 = r0.getCount()
            if (r0 != 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r1 = r2
        L_0x007b:
            android.widget.TextView r0 = r4.f13898c
            r0.setVisibility(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.fragments.z0.G0(com.coffeemeetsbagel.models.responses.ResponseFbAlbums):void");
    }

    private void H0() {
        this.f13897b.setOnItemClickListener(new y0(this));
    }

    public void E0() {
        this.f13898c.setVisibility(8);
        l.g(this.f13900e);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_albums_dls, viewGroup, false);
        this.f13896a = (ProgressBar) inflate.findViewById(R.id.progress);
        this.f13898c = (TextView) inflate.findViewById(R.id.txt_no_albums);
        this.f13897b = (ListView) inflate.findViewById(R.id.listview_albums);
        this.f13901f = (RelativeLayout) inflate.findViewById(R.id.relative_layout);
        H0();
        if (this.f13899d == null) {
            this.f13899d = new c(getActivity());
        }
        this.f13897b.setAdapter(this.f13899d);
        if (!this.f13899d.isEmpty()) {
            this.f13896a.setVisibility(8);
        }
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        this.f13900e = null;
    }

    public void onResume() {
        super.onResume();
        this.f13900e = new a();
        if (this.f13899d.isEmpty()) {
            E0();
        }
    }
}
