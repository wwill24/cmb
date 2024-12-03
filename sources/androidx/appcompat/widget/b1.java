package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.coffeemeetsbagel.models.util.FacebookParse;
import com.google.firebase.sessions.settings.RemoteSettings;
import d.f;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;
import x0.c;

class b1 extends c implements View.OnClickListener {
    private int B = -1;
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private int F = -1;

    /* renamed from: m  reason: collision with root package name */
    private final SearchView f1198m;

    /* renamed from: n  reason: collision with root package name */
    private final SearchableInfo f1199n;

    /* renamed from: p  reason: collision with root package name */
    private final Context f1200p;

    /* renamed from: q  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1201q;

    /* renamed from: t  reason: collision with root package name */
    private final int f1202t;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1203w = false;

    /* renamed from: x  reason: collision with root package name */
    private int f1204x = 1;

    /* renamed from: y  reason: collision with root package name */
    private ColorStateList f1205y;

    /* renamed from: z  reason: collision with root package name */
    private int f1206z = -1;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1207a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1208b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1209c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1210d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1211e;

        public a(View view) {
            this.f1207a = (TextView) view.findViewById(16908308);
            this.f1208b = (TextView) view.findViewById(16908309);
            this.f1209c = (ImageView) view.findViewById(16908295);
            this.f1210d = (ImageView) view.findViewById(16908296);
            this.f1211e = (ImageView) view.findViewById(f.edit_query);
        }
    }

    public b1(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1198m = searchView;
        this.f1199n = searchableInfo;
        this.f1202t = searchView.getSuggestionCommitIconResId();
        this.f1200p = context;
        this.f1201q = weakHashMap;
    }

    private void A(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    private Drawable j(String str) {
        Drawable.ConstantState constantState = this.f1201q.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence k(CharSequence charSequence) {
        if (this.f1205y == null) {
            TypedValue typedValue = new TypedValue();
            this.f1200p.getTheme().resolveAttribute(d.a.textColorSearchUrl, typedValue, true);
            this.f1205y = this.f1200p.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1205y, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable l(ComponentName componentName) {
        PackageManager packageManager = this.f1200p.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid icon resource ");
            sb2.append(iconResource);
            sb2.append(" for ");
            sb2.append(componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.toString();
            return null;
        }
    }

    private Drawable m(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1201q.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f1201q.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1200p.getResources());
        }
        Drawable l10 = l(componentName);
        if (l10 != null) {
            constantState = l10.getConstantState();
        }
        this.f1201q.put(flattenToShortString, constantState);
        return l10;
    }

    public static String n(Cursor cursor, String str) {
        return v(cursor, cursor.getColumnIndex(str));
    }

    private Drawable o() {
        Drawable m10 = m(this.f1199n.getSearchActivity());
        if (m10 != null) {
            return m10;
        }
        return this.f1200p.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|21|22|23|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0050 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0050=Splitter:B:22:0x0050, B:4:0x000f=Splitter:B:4:0x000f, B:16:0x003f=Splitter:B:16:0x003f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable p(android.net.Uri r5) {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing icon stream for "
            r1 = 0
            java.lang.String r2 = r5.getScheme()     // Catch:{ FileNotFoundException -> 0x0073 }
            java.lang.String r3 = "android.resource"
            boolean r2 = r3.equals(r2)     // Catch:{ FileNotFoundException -> 0x0073 }
            if (r2 == 0) goto L_0x002b
            android.graphics.drawable.Drawable r5 = r4.q(r5)     // Catch:{ NotFoundException -> 0x0014 }
            return r5
        L_0x0014:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0073 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0073 }
            java.lang.String r3 = "Resource does not exist: "
            r2.append(r3)     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.append(r5)     // Catch:{ FileNotFoundException -> 0x0073 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0073 }
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0073 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0073 }
        L_0x002b:
            android.content.Context r2 = r4.f1200p     // Catch:{ FileNotFoundException -> 0x0073 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0073 }
            java.io.InputStream r2 = r2.openInputStream(r5)     // Catch:{ FileNotFoundException -> 0x0073 }
            if (r2 == 0) goto L_0x005c
            android.graphics.drawable.Drawable r3 = android.graphics.drawable.Drawable.createFromStream(r2, r1)     // Catch:{ all -> 0x004b }
            r2.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x004a
        L_0x003f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.append(r0)     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.append(r5)     // Catch:{ FileNotFoundException -> 0x0073 }
        L_0x004a:
            return r3
        L_0x004b:
            r3 = move-exception
            r2.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x005b
        L_0x0050:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.append(r0)     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.append(r5)     // Catch:{ FileNotFoundException -> 0x0073 }
        L_0x005b:
            throw r3     // Catch:{ FileNotFoundException -> 0x0073 }
        L_0x005c:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0073 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0073 }
            java.lang.String r3 = "Failed to open "
            r2.append(r3)     // Catch:{ FileNotFoundException -> 0x0073 }
            r2.append(r5)     // Catch:{ FileNotFoundException -> 0x0073 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0073 }
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0073 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0073 }
        L_0x0073:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Icon not found: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = ", "
            r2.append(r5)
            java.lang.String r5 = r0.getMessage()
            r2.append(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b1.p(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable r(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1200p.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + parseInt;
            Drawable j10 = j(str2);
            if (j10 != null) {
                return j10;
            }
            Drawable drawable = androidx.core.content.a.getDrawable(this.f1200p, parseInt);
            z(str2, drawable);
            return drawable;
        } catch (NumberFormatException unused) {
            Drawable j11 = j(str);
            if (j11 != null) {
                return j11;
            }
            Drawable p10 = p(Uri.parse(str));
            z(str, p10);
            return p10;
        } catch (Resources.NotFoundException unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Icon resource not found: ");
            sb2.append(str);
            return null;
        }
    }

    private Drawable s(Cursor cursor) {
        int i10 = this.D;
        if (i10 == -1) {
            return null;
        }
        Drawable r10 = r(cursor.getString(i10));
        if (r10 != null) {
            return r10;
        }
        return o();
    }

    private Drawable t(Cursor cursor) {
        int i10 = this.E;
        if (i10 == -1) {
            return null;
        }
        return r(cursor.getString(i10));
    }

    private static String v(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception unused) {
            return null;
        }
    }

    private void x(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void y(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void z(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1201q.put(str, drawable.getConstantState());
        }
    }

    public void a(Cursor cursor) {
        if (!this.f1203w) {
            try {
                super.a(cursor);
                if (cursor != null) {
                    this.f1206z = cursor.getColumnIndex("suggest_text_1");
                    this.B = cursor.getColumnIndex("suggest_text_2");
                    this.C = cursor.getColumnIndex("suggest_text_2_url");
                    this.D = cursor.getColumnIndex("suggest_icon_1");
                    this.E = cursor.getColumnIndex("suggest_icon_2");
                    this.F = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception unused) {
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public Cursor b(CharSequence charSequence) {
        String str;
        if (charSequence == null) {
            str = "";
        } else {
            str = charSequence.toString();
        }
        if (this.f1198m.getVisibility() == 0 && this.f1198m.getWindowVisibility() == 0) {
            try {
                Cursor u10 = u(this.f1199n, str, 50);
                if (u10 != null) {
                    u10.getCount();
                    return u10;
                }
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    public CharSequence convertToString(Cursor cursor) {
        String n10;
        String n11;
        if (cursor == null) {
            return null;
        }
        String n12 = n(cursor, "suggest_intent_query");
        if (n12 != null) {
            return n12;
        }
        if (this.f1199n.shouldRewriteQueryFromData() && (n11 = n(cursor, "suggest_intent_data")) != null) {
            return n11;
        }
        if (!this.f1199n.shouldRewriteQueryFromText() || (n10 = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return n10;
    }

    public void d(View view, Context context, Cursor cursor) {
        int i10;
        CharSequence charSequence;
        a aVar = (a) view.getTag();
        int i11 = this.F;
        if (i11 != -1) {
            i10 = cursor.getInt(i11);
        } else {
            i10 = 0;
        }
        if (aVar.f1207a != null) {
            y(aVar.f1207a, v(cursor, this.f1206z));
        }
        if (aVar.f1208b != null) {
            String v10 = v(cursor, this.C);
            if (v10 != null) {
                charSequence = k(v10);
            } else {
                charSequence = v(cursor, this.B);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = aVar.f1207a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1207a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1207a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1207a.setMaxLines(1);
                }
            }
            y(aVar.f1208b, charSequence);
        }
        ImageView imageView = aVar.f1209c;
        if (imageView != null) {
            x(imageView, s(cursor), 4);
        }
        ImageView imageView2 = aVar.f1210d;
        if (imageView2 != null) {
            x(imageView2, t(cursor), 8);
        }
        int i12 = this.f1204x;
        if (i12 == 2 || (i12 == 1 && (i10 & 1) != 0)) {
            aVar.f1211e.setVisibility(0);
            aVar.f1211e.setTag(aVar.f1207a.getText());
            aVar.f1211e.setOnClickListener(this);
            return;
        }
        aVar.f1211e.setVisibility(8);
    }

    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        View g10 = super.g(context, cursor, viewGroup);
        g10.setTag(new a(g10));
        ((ImageView) g10.findViewById(f.edit_query)).setImageResource(this.f1202t);
        return g10;
    }

    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View f10 = f(this.f1200p, c(), viewGroup);
            if (f10 != null) {
                ((a) f10.getTag()).f1207a.setText(e10.toString());
            }
            return f10;
        }
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View g10 = g(this.f1200p, c(), viewGroup);
            if (g10 != null) {
                ((a) g10.getTag()).f1207a.setText(e10.toString());
            }
            return g10;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        A(c());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        A(c());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1198m.S((CharSequence) tag);
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable q(Uri uri) throws FileNotFoundException {
        int i10;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f1200p.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i10 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i10 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i10 != 0) {
                        return resourcesForApplication.getDrawable(i10);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* access modifiers changed from: package-private */
    public Cursor u(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter(FacebookParse.FB_PARAM_FIELD_LIMIT, String.valueOf(i10));
        }
        return this.f1200p.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public void w(int i10) {
        this.f1204x = i10;
    }
}
