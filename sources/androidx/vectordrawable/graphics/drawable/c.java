package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.h;
import androidx.core.content.res.m;
import java.io.IOException;
import java.util.ArrayList;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c extends e implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    private C0078c f7069b;

    /* renamed from: c  reason: collision with root package name */
    private Context f7070c;

    /* renamed from: d  reason: collision with root package name */
    private ArgbEvaluator f7071d;

    /* renamed from: e  reason: collision with root package name */
    d f7072e;

    /* renamed from: f  reason: collision with root package name */
    private Animator.AnimatorListener f7073f;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<b> f7074g;

    /* renamed from: h  reason: collision with root package name */
    final Drawable.Callback f7075h;

    class a implements Drawable.Callback {
        a() {
        }

        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            c.this.scheduleSelf(runnable, j10);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f7074g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((b) arrayList.get(i10)).b(c.this);
            }
        }

        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f7074g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((b) arrayList.get(i10)).c(c.this);
            }
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.c$c  reason: collision with other inner class name */
    private static class C0078c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f7078a;

        /* renamed from: b  reason: collision with root package name */
        f f7079b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f7080c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f7081d;

        /* renamed from: e  reason: collision with root package name */
        androidx.collection.a<Animator, String> f7082e;

        public C0078c(Context context, C0078c cVar, Drawable.Callback callback, Resources resources) {
            if (cVar != null) {
                this.f7078a = cVar.f7078a;
                f fVar = cVar.f7079b;
                if (fVar != null) {
                    Drawable.ConstantState constantState = fVar.getConstantState();
                    if (resources != null) {
                        this.f7079b = (f) constantState.newDrawable(resources);
                    } else {
                        this.f7079b = (f) constantState.newDrawable();
                    }
                    f fVar2 = (f) this.f7079b.mutate();
                    this.f7079b = fVar2;
                    fVar2.setCallback(callback);
                    this.f7079b.setBounds(cVar.f7079b.getBounds());
                    this.f7079b.g(false);
                }
                ArrayList<Animator> arrayList = cVar.f7081d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f7081d = new ArrayList<>(size);
                    this.f7082e = new androidx.collection.a<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = cVar.f7081d.get(i10);
                        Animator clone = animator.clone();
                        String str = cVar.f7082e.get(animator);
                        clone.setTarget(this.f7079b.c(str));
                        this.f7081d.add(clone);
                        this.f7082e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f7080c == null) {
                this.f7080c = new AnimatorSet();
            }
            this.f7080c.playTogether(this.f7081d);
        }

        public int getChangingConfigurations() {
            return this.f7078a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    c() {
        this((Context) null, (C0078c) null, (Resources) null);
    }

    public static c a(@NonNull Context context, int i10) {
        c cVar = new c(context);
        Drawable e10 = h.e(context.getResources(), i10, context.getTheme());
        cVar.f7084a = e10;
        e10.setCallback(cVar.f7075h);
        cVar.f7072e = new d(cVar.f7084a.getConstantState());
        return cVar;
    }

    private static void c(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.a());
    }

    private void d() {
        Animator.AnimatorListener animatorListener = this.f7073f;
        if (animatorListener != null) {
            this.f7069b.f7080c.removeListener(animatorListener);
            this.f7073f = null;
        }
    }

    private void e(String str, Animator animator) {
        animator.setTarget(this.f7069b.f7079b.c(str));
        C0078c cVar = this.f7069b;
        if (cVar.f7081d == null) {
            cVar.f7081d = new ArrayList<>();
            this.f7069b.f7082e = new androidx.collection.a<>();
        }
        this.f7069b.f7081d.add(animator);
        this.f7069b.f7082e.put(animator, str);
    }

    private static boolean g(AnimatedVectorDrawable animatedVectorDrawable, b bVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(bVar.a());
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    public void b(@NonNull b bVar) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            c((AnimatedVectorDrawable) drawable, bVar);
        } else if (bVar != null) {
            if (this.f7074g == null) {
                this.f7074g = new ArrayList<>();
            }
            if (!this.f7074g.contains(bVar)) {
                this.f7074g.add(bVar);
                if (this.f7073f == null) {
                    this.f7073f = new b();
                }
                this.f7069b.f7080c.addListener(this.f7073f);
            }
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f7069b.f7079b.draw(canvas);
        if (this.f7069b.f7080c.isStarted()) {
            invalidateSelf();
        }
    }

    public boolean f(@NonNull b bVar) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            g((AnimatedVectorDrawable) drawable, bVar);
        }
        ArrayList<b> arrayList = this.f7074g;
        if (arrayList == null || bVar == null) {
            return false;
        }
        boolean remove = arrayList.remove(bVar);
        if (this.f7074g.size() == 0) {
            d();
        }
        return remove;
    }

    public int getAlpha() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f7069b.f7079b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f7069b.f7078a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.f7069b.f7079b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f7084a != null) {
            return new d(this.f7084a.getConstantState());
        }
        return null;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f7069b.f7079b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f7069b.f7079b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f7069b.f7079b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray i10 = m.i(resources, theme, attributeSet, a.f7059e);
                    int resourceId = i10.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f b10 = f.b(resources, resourceId, theme);
                        b10.g(false);
                        b10.setCallback(this.f7075h);
                        f fVar = this.f7069b.f7079b;
                        if (fVar != null) {
                            fVar.setCallback((Drawable.Callback) null);
                        }
                        this.f7069b.f7079b = b10;
                    }
                    i10.recycle();
                } else if (TypeProxy.INSTANCE_FIELD.equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f7060f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f7070c;
                        if (context != null) {
                            e(string, d.a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f7069b.a();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return this.f7069b.f7079b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f7069b.f7080c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f7069b.f7079b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f7069b.f7079b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        return this.f7069b.f7079b.setLevel(i10);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f7069b.f7079b.setState(iArr);
    }

    public void setAlpha(int i10) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f7069b.f7079b.setAlpha(i10);
        }
    }

    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z10);
        } else {
            this.f7069b.f7079b.setAutoMirrored(z10);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i10) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i10);
        } else {
            this.f7069b.f7079b.setTint(i10);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.f7069b.f7079b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        } else {
            this.f7069b.f7079b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f7069b.f7079b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    public void start() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f7069b.f7080c.isStarted()) {
            this.f7069b.f7080c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f7069b.f7080c.end();
        }
    }

    private c(Context context) {
        this(context, (C0078c) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f7084a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f7069b.f7079b.setColorFilter(colorFilter);
        }
    }

    private static class d extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f7083a;

        public d(Drawable.ConstantState constantState) {
            this.f7083a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f7083a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f7083a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            c cVar = new c();
            Drawable newDrawable = this.f7083a.newDrawable();
            cVar.f7084a = newDrawable;
            newDrawable.setCallback(cVar.f7075h);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable newDrawable = this.f7083a.newDrawable(resources);
            cVar.f7084a = newDrawable;
            newDrawable.setCallback(cVar.f7075h);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable newDrawable = this.f7083a.newDrawable(resources, theme);
            cVar.f7084a = newDrawable;
            newDrawable.setCallback(cVar.f7075h);
            return cVar;
        }
    }

    private c(Context context, C0078c cVar, Resources resources) {
        this.f7071d = null;
        this.f7073f = null;
        this.f7074g = null;
        a aVar = new a();
        this.f7075h = aVar;
        this.f7070c = context;
        if (cVar != null) {
            this.f7069b = cVar;
        } else {
            this.f7069b = new C0078c(context, cVar, aVar, resources);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
