package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.w0;
import d.c;
import d.d;
import d.e;

public final class h {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f1280b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static h f1281c;

    /* renamed from: a  reason: collision with root package name */
    private w0 f1282a;

    class a implements w0.c {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f1283a = {e.abc_textfield_search_default_mtrl_alpha, e.abc_textfield_default_mtrl_alpha, e.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        private final int[] f1284b = {e.abc_ic_commit_search_api_mtrl_alpha, e.abc_seekbar_tick_mark_material, e.abc_ic_menu_share_mtrl_alpha, e.abc_ic_menu_copy_mtrl_am_alpha, e.abc_ic_menu_cut_mtrl_alpha, e.abc_ic_menu_selectall_mtrl_alpha, e.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        private final int[] f1285c = {e.abc_textfield_activated_mtrl_alpha, e.abc_textfield_search_activated_mtrl_alpha, e.abc_cab_background_top_mtrl_alpha, e.abc_text_cursor_material, e.abc_text_select_handle_left_mtrl, e.abc_text_select_handle_middle_mtrl, e.abc_text_select_handle_right_mtrl};

        /* renamed from: d  reason: collision with root package name */
        private final int[] f1286d = {e.abc_popup_background_mtrl_mult, e.abc_cab_background_internal_bg, e.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e  reason: collision with root package name */
        private final int[] f1287e = {e.abc_tab_indicator_material, e.abc_textfield_search_material};

        /* renamed from: f  reason: collision with root package name */
        private final int[] f1288f = {e.abc_btn_check_material, e.abc_btn_radio_material, e.abc_btn_check_material_anim, e.abc_btn_radio_material_anim};

        a() {
        }

        private boolean f(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(@NonNull Context context) {
            return h(context, 0);
        }

        private ColorStateList h(@NonNull Context context, int i10) {
            int c10 = c1.c(context, d.a.colorControlHighlight);
            int b10 = c1.b(context, d.a.colorButtonNormal);
            return new ColorStateList(new int[][]{c1.f1217b, c1.f1220e, c1.f1218c, c1.f1224i}, new int[]{b10, androidx.core.graphics.a.h(c10, i10), androidx.core.graphics.a.h(c10, i10), i10});
        }

        private ColorStateList i(@NonNull Context context) {
            return h(context, c1.c(context, d.a.colorAccent));
        }

        private ColorStateList j(@NonNull Context context) {
            return h(context, c1.c(context, d.a.colorButtonNormal));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i10 = d.a.colorSwitchThumbNormal;
            ColorStateList e10 = c1.e(context, i10);
            if (e10 == null || !e10.isStateful()) {
                iArr[0] = c1.f1217b;
                iArr2[0] = c1.b(context, i10);
                iArr[1] = c1.f1221f;
                iArr2[1] = c1.c(context, d.a.colorControlActivated);
                iArr[2] = c1.f1224i;
                iArr2[2] = c1.c(context, i10);
            } else {
                int[] iArr3 = c1.f1217b;
                iArr[0] = iArr3;
                iArr2[0] = e10.getColorForState(iArr3, 0);
                iArr[1] = c1.f1221f;
                iArr2[1] = c1.c(context, d.a.colorControlActivated);
                iArr[2] = c1.f1224i;
                iArr2[2] = e10.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable l(@NonNull w0 w0Var, @NonNull Context context, int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable i11 = w0Var.i(context, e.abc_star_black_48dp);
            Drawable i12 = w0Var.i(context, e.abc_star_half_black_48dp);
            if ((i11 instanceof BitmapDrawable) && i11.getIntrinsicWidth() == dimensionPixelSize && i11.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) i11;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                i11.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                i11.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((i12 instanceof BitmapDrawable) && i12.getIntrinsicWidth() == dimensionPixelSize && i12.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) i12;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                i12.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                i12.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        private void m(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (k0.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = h.f1280b;
            }
            drawable.setColorFilter(h.e(i10, mode));
        }

        public Drawable a(@NonNull w0 w0Var, @NonNull Context context, int i10) {
            if (i10 == e.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{w0Var.i(context, e.abc_cab_background_internal_bg), w0Var.i(context, e.abc_cab_background_top_mtrl_alpha)});
            } else if (i10 == e.abc_ratingbar_material) {
                return l(w0Var, context, d.abc_star_big);
            } else {
                if (i10 == e.abc_ratingbar_indicator_material) {
                    return l(w0Var, context, d.abc_star_medium);
                }
                if (i10 == e.abc_ratingbar_small_material) {
                    return l(w0Var, context, d.abc_star_small);
                }
                return null;
            }
        }

        public ColorStateList b(@NonNull Context context, int i10) {
            if (i10 == e.abc_edit_text_material) {
                return e.a.a(context, c.abc_tint_edittext);
            }
            if (i10 == e.abc_switch_track_mtrl_alpha) {
                return e.a.a(context, c.abc_tint_switch_track);
            }
            if (i10 == e.abc_switch_thumb_material) {
                return k(context);
            }
            if (i10 == e.abc_btn_default_mtrl_shape) {
                return j(context);
            }
            if (i10 == e.abc_btn_borderless_material) {
                return g(context);
            }
            if (i10 == e.abc_btn_colored_material) {
                return i(context);
            }
            if (i10 == e.abc_spinner_mtrl_am_alpha || i10 == e.abc_spinner_textfield_background_material) {
                return e.a.a(context, c.abc_tint_spinner);
            }
            if (f(this.f1284b, i10)) {
                return c1.e(context, d.a.colorControlNormal);
            }
            if (f(this.f1287e, i10)) {
                return e.a.a(context, c.abc_tint_default);
            }
            if (f(this.f1288f, i10)) {
                return e.a.a(context, c.abc_tint_btn_checkable);
            }
            if (i10 == e.abc_seekbar_thumb_material) {
                return e.a.a(context, c.abc_tint_seek_thumb);
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(@androidx.annotation.NonNull android.content.Context r7, int r8, @androidx.annotation.NonNull android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.h.f1280b
                int[] r1 = r6.f1283a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0017
                int r2 = d.a.colorControlNormal
            L_0x0014:
                r8 = r3
            L_0x0015:
                r1 = r5
                goto L_0x0044
            L_0x0017:
                int[] r1 = r6.f1285c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x0022
                int r2 = d.a.colorControlActivated
                goto L_0x0014
            L_0x0022:
                int[] r1 = r6.f1286d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L_0x002d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L_0x0014
            L_0x002d:
                int r1 = d.e.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L_0x003c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L_0x0015
            L_0x003c:
                int r1 = d.e.abc_dialog_material_background
                if (r8 != r1) goto L_0x0041
                goto L_0x0014
            L_0x0041:
                r8 = r3
                r1 = r4
                r2 = r1
            L_0x0044:
                if (r1 == 0) goto L_0x0061
                boolean r1 = androidx.appcompat.widget.k0.a(r9)
                if (r1 == 0) goto L_0x0050
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L_0x0050:
                int r7 = androidx.appcompat.widget.c1.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.h.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L_0x0060
                r9.setAlpha(r8)
            L_0x0060:
                return r5
            L_0x0061:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.h.a.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        public PorterDuff.Mode d(int i10) {
            if (i10 == e.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public boolean e(@NonNull Context context, int i10, @NonNull Drawable drawable) {
            if (i10 == e.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i11 = d.a.colorControlNormal;
                m(findDrawableByLayerId, c1.c(context, i11), h.f1280b);
                m(layerDrawable.findDrawableByLayerId(16908303), c1.c(context, i11), h.f1280b);
                m(layerDrawable.findDrawableByLayerId(16908301), c1.c(context, d.a.colorControlActivated), h.f1280b);
                return true;
            } else if (i10 != e.abc_ratingbar_material && i10 != e.abc_ratingbar_indicator_material && i10 != e.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                m(layerDrawable2.findDrawableByLayerId(16908288), c1.b(context, d.a.colorControlNormal), h.f1280b);
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                int i12 = d.a.colorControlActivated;
                m(findDrawableByLayerId2, c1.c(context, i12), h.f1280b);
                m(layerDrawable2.findDrawableByLayerId(16908301), c1.c(context, i12), h.f1280b);
                return true;
            }
        }
    }

    public static synchronized h b() {
        h hVar;
        synchronized (h.class) {
            if (f1281c == null) {
                h();
            }
            hVar = f1281c;
        }
        return hVar;
    }

    public static synchronized PorterDuffColorFilter e(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter k10;
        synchronized (h.class) {
            k10 = w0.k(i10, mode);
        }
        return k10;
    }

    public static synchronized void h() {
        synchronized (h.class) {
            if (f1281c == null) {
                h hVar = new h();
                f1281c = hVar;
                hVar.f1282a = w0.g();
                f1281c.f1282a.t(new a());
            }
        }
    }

    static void i(Drawable drawable, f1 f1Var, int[] iArr) {
        w0.v(drawable, f1Var, iArr);
    }

    public synchronized Drawable c(@NonNull Context context, int i10) {
        return this.f1282a.i(context, i10);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable d(@NonNull Context context, int i10, boolean z10) {
        return this.f1282a.j(context, i10, z10);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList f(@NonNull Context context, int i10) {
        return this.f1282a.l(context, i10);
    }

    public synchronized void g(@NonNull Context context) {
        this.f1282a.r(context);
    }
}
