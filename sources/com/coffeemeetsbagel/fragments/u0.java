package com.coffeemeetsbagel.fragments;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.mediaitemtype.MediaItemViewPager;
import com.coffeemeetsbagel.image_loader.ImageLoaderContract;
import com.coffeemeetsbagel.models.enums.MediaItemType;
import com.coffeemeetsbagel.models.interfaces.MediaItemContract;
import com.coffeemeetsbagel.photo.Photo;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

public class u0 extends androidx.fragment.app.c {

    /* renamed from: a  reason: collision with root package name */
    private final List<MediaItemContract.MediaItem> f13841a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private MediaItemViewPager f13842b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f13843c;

    /* renamed from: d  reason: collision with root package name */
    private CmbTextView f13844d;

    /* renamed from: e  reason: collision with root package name */
    private c f13845e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13846f;

    class a extends ViewPager.m {
        a() {
        }

        public void q(int i10) {
            u0.this.S0(i10);
            u0.this.R0(i10);
            u0.this.O0();
        }
    }

    class b extends ShapeDrawable.ShaderFactory {
        b() {
        }

        public Shader resize(int i10, int i11) {
            return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i11, new int[]{-16777216, 285212672, 0}, new float[]{0.0f, 0.88f, 1.0f}, Shader.TileMode.REPEAT);
        }
    }

    public interface c {
        void a(int i10);

        void b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I0() {
        if (H0()) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J0(View view) {
        if (H0()) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean L0(ImageView imageView, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            imageView.setAlpha(0.5f);
            return false;
        } else if (motionEvent.getAction() != 2) {
            return false;
        } else {
            imageView.setAlpha(1.0f);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean M0(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            dismiss();
        }
        return true;
    }

    public static androidx.fragment.app.c N0(ArrayList<Photo> arrayList, int i10, c cVar) {
        u0 u0Var = new u0();
        u0Var.setCancelable(false);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("photos", arrayList);
        bundle.putInt("current_photo", i10);
        u0Var.setArguments(bundle);
        u0Var.Q0(cVar);
        return u0Var;
    }

    /* access modifiers changed from: private */
    public void O0() {
        c cVar = this.f13845e;
        if (cVar != null) {
            cVar.a(this.f13842b.getCurrentItem());
        }
    }

    private void P0(View view) {
        b bVar = new b();
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(bVar);
        ((LinearLayout) view.findViewById(R.id.top_transparent_action_bar)).setBackground(paintDrawable);
    }

    /* access modifiers changed from: private */
    public void R0(int i10) {
        if (this.f13841a.size() != 0) {
            MediaItemContract.MediaItem mediaItem = this.f13841a.get(i10);
            if (mediaItem.getType() == MediaItemType.PHOTO) {
                String a10 = ((Photo) mediaItem).a();
                if (!TextUtils.isEmpty(a10)) {
                    this.f13843c.setText(a10);
                } else {
                    this.f13843c.setText("");
                }
            } else {
                this.f13843c.setText("");
            }
        }
    }

    /* access modifiers changed from: private */
    public void S0(int i10) {
        this.f13844d.setText((i10 + 1) + RemoteSettings.FORWARD_SLASH_STRING + this.f13841a.size());
    }

    /* access modifiers changed from: protected */
    public boolean H0() {
        return !this.f13846f;
    }

    public void Q0(c cVar) {
        this.f13845e = cVar;
    }

    public void dismiss() {
        super.dismiss();
        dismissAllowingStateLoss();
        c cVar = this.f13845e;
        if (cVar != null) {
            cVar.b();
            this.f13845e = null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.dialog_fullscreen_dls);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_photos_full, viewGroup, false);
        if (getArguments() != null) {
            this.f13841a.addAll(getArguments().getParcelableArrayList("photos"));
        }
        for (MediaItemContract.MediaItem next : this.f13841a) {
            if (next.getType() == MediaItemType.PHOTO) {
                com.coffeemeetsbagel.image_loader.b.f13967a.b(requireContext(), next.getUrl(), (ImageView) null, Integer.valueOf(R.drawable.icon_profile_placeholder), (Integer) null, (ImageLoaderContract.b) null, Collections.emptyList(), Collections.emptyMap(), (Function0<Unit>) null, (Function1<? super Bitmap, Unit>) null, (Bitmap.Config) null, (ImageLoaderContract.ImageBucketSize) null, new ImageLoaderContract.MemoryConfig[0]);
            }
        }
        MediaItemViewPager mediaItemViewPager = (MediaItemViewPager) inflate.findViewById(R.id.gallery_photos_pager);
        this.f13842b = mediaItemViewPager;
        mediaItemViewPager.setListener(new q0(this));
        this.f13842b.setMediaItems(this.f13841a);
        this.f13842b.c(new a());
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageView_button_up);
        imageView.setOnClickListener(new r0(this));
        imageView.setOnTouchListener(new s0(imageView));
        P0(inflate);
        int i10 = getArguments().getInt("current_photo");
        if (i10 >= this.f13841a.size()) {
            i10 = this.f13841a.size() - 1;
        }
        this.f13843c = (CmbTextView) inflate.findViewById(R.id.profile_gallery_photo_caption);
        this.f13844d = (CmbTextView) inflate.findViewById(R.id.textView_photo_indicator);
        R0(i10);
        S0(i10);
        this.f13842b.setCurrentItem(i10);
        if (bundle != null) {
            new Handler().post(new t0(this));
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        this.f13846f = false;
        getDialog().setOnKeyListener(new p0(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f13846f = true;
        setTargetFragment((Fragment) null, -1);
    }

    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setLayout(-1, -1);
            }
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setStatusBarColor(getResources().getColor(R.color.black));
            }
        }
    }
}
