package e8;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b8.c;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.instagram.api.models.InstagramMediaItem;
import com.coffeemeetsbagel.models.constants.Extra;
import java.util.List;
import r7.b;
import r7.h;
import t8.m;
import t8.n;
import t8.o;

public class d extends b implements b8.d {

    /* renamed from: d  reason: collision with root package name */
    RelativeLayout f14592d;

    /* renamed from: e  reason: collision with root package name */
    GridView f14593e;

    /* renamed from: f  reason: collision with root package name */
    TextView f14594f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f14595g;

    /* renamed from: h  reason: collision with root package name */
    private int f14596h;

    /* renamed from: j  reason: collision with root package name */
    private String f14597j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14598k;

    /* renamed from: l  reason: collision with root package name */
    private String f14599l;

    /* renamed from: m  reason: collision with root package name */
    private Dialog f14600m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public c f14601n;

    /* renamed from: p  reason: collision with root package name */
    private m f14602p;

    class a implements AbsListView.OnScrollListener {
        a() {
        }

        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 == 0 && d.this.f14593e.getLastVisiblePosition() >= d.this.f14595g.getCount() - 1) {
                d.this.f14601n.b();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U0(AdapterView adapterView, View view, int i10, long j10) {
        this.f14601n.e((InstagramMediaItem) this.f14595g.getItem(i10));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V0() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void C() {
        this.f14594f.setVisibility(8);
    }

    public void E() {
        this.f14594f.setVisibility(0);
    }

    public void H(Uri uri, String str) {
        this.f14602p.f(uri, this.f14597j, this.f14596h, getActivity(), this.f14598k, str, this.f14599l, (String) null, true);
    }

    public void f0(List<InstagramMediaItem> list) {
        this.f14595g.g(list);
        this.f14595g.notifyDataSetChanged();
    }

    public void j() {
        this.f14600m.show();
    }

    public void j0() {
        sb.a.g(requireActivity().getWindow().getDecorView().findViewById(16908290), R.string.instagram_failed_to_load);
    }

    public void k() {
        lc.c.h(this.f14600m);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f14598k = arguments.getBoolean(Extra.SHOULD_SHOW_CAPTION_FLOW, true);
        this.f14596h = arguments.getInt(Extra.PHOTO_INDEX);
        this.f14597j = arguments.getString(Extra.PHOTO_ID);
        o oVar = new o(L0(), (n) null);
        this.f14602p = oVar;
        this.f14599l = arguments.getString(Extra.IMAGE_PATH, oVar.d());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mPhotoIndex=");
        sb2.append(this.f14596h);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_photos_grid_dls, (ViewGroup) null);
        this.f14592d = (RelativeLayout) inflate.findViewById(R.id.relative_layout);
        this.f14593e = (GridView) inflate.findViewById(R.id.grid_photos);
        this.f14594f = (TextView) inflate.findViewById(R.id.txt_no_pics);
        a aVar = new a(getActivity(), 3);
        this.f14595g = aVar;
        this.f14593e.setAdapter(aVar);
        this.f14593e.setOnScrollListener(new a());
        this.f14593e.setOnItemClickListener(new b(this));
        this.f14600m = new h(getActivity());
        f fVar = new f(this, I0());
        this.f14601n = fVar;
        fVar.start();
        return inflate;
    }

    public void onDestroyView() {
        this.f14601n.stop();
        this.f14601n = null;
        super.onDestroyView();
    }

    public void z() {
        sb.a.g(requireActivity().getWindow().getDecorView().findViewById(16908290), R.string.instagram_failed_not_authed);
        new Handler().postDelayed(new c(this), 2750);
    }
}
