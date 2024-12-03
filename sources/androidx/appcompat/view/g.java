package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.k0;
import androidx.core.view.z;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.bytebuddy.jar.asm.Opcodes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class<?>[] f668e;

    /* renamed from: f  reason: collision with root package name */
    static final Class<?>[] f669f;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f670a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f671b;

    /* renamed from: c  reason: collision with root package name */
    Context f672c;

    /* renamed from: d  reason: collision with root package name */
    private Object f673d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?>[] f674c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f675a;

        /* renamed from: b  reason: collision with root package name */
        private Method f676b;

        public a(Object obj, String str) {
            this.f675a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f676b = cls.getMethod(str, f674c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f676b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f676b.invoke(this.f675a, new Object[]{menuItem})).booleanValue();
                }
                this.f676b.invoke(this.f675a, new Object[]{menuItem});
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    private class b {
        androidx.core.view.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f677a;

        /* renamed from: b  reason: collision with root package name */
        private int f678b;

        /* renamed from: c  reason: collision with root package name */
        private int f679c;

        /* renamed from: d  reason: collision with root package name */
        private int f680d;

        /* renamed from: e  reason: collision with root package name */
        private int f681e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f682f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f683g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f684h;

        /* renamed from: i  reason: collision with root package name */
        private int f685i;

        /* renamed from: j  reason: collision with root package name */
        private int f686j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f687k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f688l;

        /* renamed from: m  reason: collision with root package name */
        private int f689m;

        /* renamed from: n  reason: collision with root package name */
        private char f690n;

        /* renamed from: o  reason: collision with root package name */
        private int f691o;

        /* renamed from: p  reason: collision with root package name */
        private char f692p;

        /* renamed from: q  reason: collision with root package name */
        private int f693q;

        /* renamed from: r  reason: collision with root package name */
        private int f694r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f695s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f696t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f697u;

        /* renamed from: v  reason: collision with root package name */
        private int f698v;

        /* renamed from: w  reason: collision with root package name */
        private int f699w;

        /* renamed from: x  reason: collision with root package name */
        private String f700x;

        /* renamed from: y  reason: collision with root package name */
        private String f701y;

        /* renamed from: z  reason: collision with root package name */
        private String f702z;

        public b(Menu menu) {
            this.f677a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f672c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot instantiate class: ");
                sb2.append(str);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z10;
            MenuItem enabled = menuItem.setChecked(this.f695s).setVisible(this.f696t).setEnabled(this.f697u);
            boolean z11 = false;
            if (this.f694r >= 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            enabled.setCheckable(z10).setTitleCondensed(this.f688l).setIcon(this.f689m);
            int i10 = this.f698v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f702z != null) {
                if (!g.this.f672c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f702z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f694r >= 2) {
                if (menuItem instanceof i) {
                    ((i) menuItem).t(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).h(true);
                }
            }
            String str = this.f700x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f668e, g.this.f670a));
                z11 = true;
            }
            int i11 = this.f699w;
            if (i11 > 0 && !z11) {
                menuItem.setActionView(i11);
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                z.a(menuItem, bVar);
            }
            z.c(menuItem, this.B);
            z.g(menuItem, this.C);
            z.b(menuItem, this.f690n, this.f691o);
            z.f(menuItem, this.f692p, this.f693q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                z.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                z.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f684h = true;
            i(this.f677a.add(this.f678b, this.f685i, this.f686j, this.f687k));
        }

        public SubMenu b() {
            this.f684h = true;
            SubMenu addSubMenu = this.f677a.addSubMenu(this.f678b, this.f685i, this.f686j, this.f687k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f684h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f672c.obtainStyledAttributes(attributeSet, d.j.MenuGroup);
            this.f678b = obtainStyledAttributes.getResourceId(d.j.MenuGroup_android_id, 0);
            this.f679c = obtainStyledAttributes.getInt(d.j.MenuGroup_android_menuCategory, 0);
            this.f680d = obtainStyledAttributes.getInt(d.j.MenuGroup_android_orderInCategory, 0);
            this.f681e = obtainStyledAttributes.getInt(d.j.MenuGroup_android_checkableBehavior, 0);
            this.f682f = obtainStyledAttributes.getBoolean(d.j.MenuGroup_android_visible, true);
            this.f683g = obtainStyledAttributes.getBoolean(d.j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            boolean z10;
            h1 u10 = h1.u(g.this.f672c, attributeSet, d.j.MenuItem);
            this.f685i = u10.n(d.j.MenuItem_android_id, 0);
            this.f686j = (u10.k(d.j.MenuItem_android_menuCategory, this.f679c) & Opcodes.V_PREVIEW) | (u10.k(d.j.MenuItem_android_orderInCategory, this.f680d) & 65535);
            this.f687k = u10.p(d.j.MenuItem_android_title);
            this.f688l = u10.p(d.j.MenuItem_android_titleCondensed);
            this.f689m = u10.n(d.j.MenuItem_android_icon, 0);
            this.f690n = c(u10.o(d.j.MenuItem_android_alphabeticShortcut));
            this.f691o = u10.k(d.j.MenuItem_alphabeticModifiers, Opcodes.ACC_SYNTHETIC);
            this.f692p = c(u10.o(d.j.MenuItem_android_numericShortcut));
            this.f693q = u10.k(d.j.MenuItem_numericModifiers, Opcodes.ACC_SYNTHETIC);
            int i10 = d.j.MenuItem_android_checkable;
            if (u10.s(i10)) {
                this.f694r = u10.a(i10, false) ? 1 : 0;
            } else {
                this.f694r = this.f681e;
            }
            this.f695s = u10.a(d.j.MenuItem_android_checked, false);
            this.f696t = u10.a(d.j.MenuItem_android_visible, this.f682f);
            this.f697u = u10.a(d.j.MenuItem_android_enabled, this.f683g);
            this.f698v = u10.k(d.j.MenuItem_showAsAction, -1);
            this.f702z = u10.o(d.j.MenuItem_android_onClick);
            this.f699w = u10.n(d.j.MenuItem_actionLayout, 0);
            this.f700x = u10.o(d.j.MenuItem_actionViewClass);
            String o10 = u10.o(d.j.MenuItem_actionProviderClass);
            this.f701y = o10;
            if (o10 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && this.f699w == 0 && this.f700x == null) {
                this.A = (androidx.core.view.b) e(o10, g.f669f, g.this.f671b);
            } else {
                this.A = null;
            }
            this.B = u10.p(d.j.MenuItem_contentDescription);
            this.C = u10.p(d.j.MenuItem_tooltipText);
            int i11 = d.j.MenuItem_iconTintMode;
            if (u10.s(i11)) {
                this.E = k0.e(u10.k(i11, -1), this.E);
            } else {
                this.E = null;
            }
            int i12 = d.j.MenuItem_iconTint;
            if (u10.s(i12)) {
                this.D = u10.c(i12);
            } else {
                this.D = null;
            }
            u10.w();
            this.f684h = false;
        }

        public void h() {
            this.f678b = 0;
            this.f679c = 0;
            this.f680d = 0;
            this.f681e = 0;
            this.f682f = true;
            this.f683g = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            f668e = r0
            f669f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.g.<clinit>():void");
    }

    public g(Context context) {
        super(context);
        this.f672c = context;
        Object[] objArr = {context};
        this.f670a = objArr;
        this.f671b = objArr;
    }

    private Object a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z11 && name2.equals(str)) {
                            str = null;
                            z11 = false;
                        } else if (name2.equals("group")) {
                            bVar.h();
                        } else if (name2.equals("item")) {
                            if (!bVar.d()) {
                                androidx.core.view.b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z10 = true;
                        }
                    }
                } else if (!z11) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.f(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.g(attributeSet);
                    } else if (name3.equals("menu")) {
                        c(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z11 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object b() {
        if (this.f673d == null) {
            this.f673d = a(this.f672c);
        }
        return this.f673d;
    }

    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof u0.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f672c.getResources().getLayout(i10);
            c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e10) {
            throw new InflateException("Error inflating menu XML", e10);
        } catch (IOException e11) {
            throw new InflateException("Error inflating menu XML", e11);
        } catch (Throwable th2) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th2;
        }
    }
}
