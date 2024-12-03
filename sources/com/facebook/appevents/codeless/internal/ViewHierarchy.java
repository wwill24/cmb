package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import net.bytebuddy.jar.asm.Opcodes;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b9\u0010:J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0007J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001e\u0010!\u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010%\u001a\u00020\nH\u0002J\u0016\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010'2\u0006\u0010&\u001a\u00020\u0014H\u0002J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0002R\u001c\u0010+\u001a\n **\u0004\u0018\u00010\u00140\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00148\u0002XT¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020\u00148\u0002XT¢\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020\u00148\u0002XT¢\u0006\u0006\n\u0004\b/\u0010,R\u0014\u00100\u001a\u00020\u00148\u0002XT¢\u0006\u0006\n\u0004\b0\u0010,R\u0014\u00101\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ViewHierarchy;", "", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "getParentOfView", "", "getChildrenOfView", "Lorg/json/b;", "json", "", "updateBasicInfoOfView", "", "displayDensity", "updateAppearanceOfView", "getDictionaryOfView", "", "getClassTypeBitmask", "", "isAdapterViewItem", "", "getTextOfView", "getHintOfView", "getDimensionOfView", "Landroid/view/View$OnClickListener;", "getExistingOnClickListener", "newListener", "setOnClickListener", "Landroid/view/View$OnTouchListener;", "getExistingOnTouchListener", "", "location", "RCTRootView", "getTouchReactView", "isRCTRootView", "findRCTRootView", "getViewLocationOnScreen", "initTouchTargetHelperMethods", "className", "Ljava/lang/Class;", "getExistingClass", "isRCTButton", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "CLASS_RCTROOTVIEW", "CLASS_RCTVIEWGROUP", "CLASS_TOUCHTARGETHELPER", "METHOD_FIND_TOUCHTARGET_VIEW", "ICON_MAX_EDGE_LENGTH", "I", "Ljava/lang/ref/WeakReference;", "RCTRootViewReference", "Ljava/lang/ref/WeakReference;", "Ljava/lang/reflect/Method;", "methodFindTouchTargetView", "Ljava/lang/reflect/Method;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>((Object) null);
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static Method methodFindTouchTargetView;

    private ViewHierarchy() {
    }

    public static final View findRCTRootView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        while (view != null) {
            try {
                if (!INSTANCE.isRCTRootView(view)) {
                    ViewParent parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
        return null;
    }

    public static final List<View> getChildrenOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                int i10 = 0;
                if (childCount > 0) {
                    while (true) {
                        int i11 = i10 + 1;
                        arrayList.add(((ViewGroup) view).getChildAt(i10));
                        if (i11 >= childCount) {
                            break;
                        }
                        i10 = i11;
                    }
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final int getClassTypeBitmask(View view) {
        int i10;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            j.g(view, "view");
            if (view instanceof ImageView) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            if (view.isClickable()) {
                i10 |= 32;
            }
            if (isAdapterViewItem(view)) {
                i10 |= 512;
            }
            if (view instanceof TextView) {
                int i11 = i10 | 1024 | 1;
                if (view instanceof Button) {
                    i11 |= 4;
                    if (view instanceof Switch) {
                        i11 |= 8192;
                    } else if (view instanceof CheckBox) {
                        i11 |= 32768;
                    }
                }
                if (view instanceof EditText) {
                    return i11 | 2048;
                }
                return i11;
            }
            if (!(view instanceof Spinner)) {
                if (!(view instanceof DatePicker)) {
                    if (view instanceof RatingBar) {
                        return i10 | 65536;
                    }
                    if (view instanceof RadioGroup) {
                        return i10 | Opcodes.ACC_ENUM;
                    }
                    if (!(view instanceof ViewGroup) || !INSTANCE.isRCTButton(view, RCTRootViewReference.get())) {
                        return i10;
                    }
                    return i10 | 64;
                }
            }
            return i10 | Opcodes.ACC_SYNTHETIC;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return 0;
        }
    }

    public static final b getDictionaryOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(view, "view");
            if (j.b(view.getClass().getName(), CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            b bVar = new b();
            try {
                updateBasicInfoOfView(view, bVar);
                a aVar = new a();
                List<View> childrenOfView = getChildrenOfView(view);
                int i10 = 0;
                int size = childrenOfView.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i11 = i10 + 1;
                        aVar.E(getDictionaryOfView(childrenOfView.get(i10)));
                        if (i11 > size) {
                            break;
                        }
                        i10 = i11;
                    }
                }
                bVar.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, (Object) aVar);
            } catch (JSONException unused) {
            }
            return bVar;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final b getDimensionOfView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            b bVar = new b();
            try {
                bVar.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
                bVar.put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, view.getLeft());
                bVar.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
                bVar.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
                bVar.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
                bVar.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
                bVar.put(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, view.getVisibility());
            } catch (JSONException unused) {
            }
            return bVar;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final Class<?> getExistingClass(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public static final View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnTouchListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
        } catch (NoSuchFieldException e10) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e10);
        } catch (ClassNotFoundException e11) {
            Utility utility2 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e11);
        } catch (IllegalAccessException e12) {
            Utility utility3 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e12);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
        return null;
    }

    public static final String getHintOfView(View view) {
        CharSequence charSequence;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                charSequence = ((EditText) view).getHint();
            } else if (view instanceof TextView) {
                charSequence = ((TextView) view).getHint();
            } else {
                charSequence = null;
            }
            if (charSequence == null) {
                return "";
            }
            String obj = charSequence.toString();
            if (obj == null) {
                return "";
            }
            return obj;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final ViewGroup getParentOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final String getTextOfView(View view) {
        Object obj;
        Object selectedItem;
        String str;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view instanceof TextView) {
                obj = ((TextView) view).getText();
                if (view instanceof Switch) {
                    if (((Switch) view).isChecked()) {
                        str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    } else {
                        str = "0";
                    }
                    obj = str;
                }
            } else {
                if (!(view instanceof Spinner)) {
                    int i10 = 0;
                    if (view instanceof DatePicker) {
                        int year = ((DatePicker) view).getYear();
                        int month = ((DatePicker) view).getMonth();
                        int dayOfMonth = ((DatePicker) view).getDayOfMonth();
                        o oVar = o.f32141a;
                        obj = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)}, 3));
                        j.f(obj, "java.lang.String.format(format, *args)");
                    } else if (view instanceof TimePicker) {
                        Integer currentHour = ((TimePicker) view).getCurrentHour();
                        j.f(currentHour, "view.currentHour");
                        int intValue = currentHour.intValue();
                        Integer currentMinute = ((TimePicker) view).getCurrentMinute();
                        j.f(currentMinute, "view.currentMinute");
                        int intValue2 = currentMinute.intValue();
                        o oVar2 = o.f32141a;
                        obj = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)}, 2));
                        j.f(obj, "java.lang.String.format(format, *args)");
                    } else if (view instanceof RadioGroup) {
                        int checkedRadioButtonId = ((RadioGroup) view).getCheckedRadioButtonId();
                        int childCount = ((RadioGroup) view).getChildCount();
                        if (childCount > 0) {
                            while (true) {
                                int i11 = i10 + 1;
                                View childAt = ((RadioGroup) view).getChildAt(i10);
                                if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                                    obj = ((RadioButton) childAt).getText();
                                    break;
                                } else if (i11 >= childCount) {
                                    break;
                                } else {
                                    i10 = i11;
                                }
                            }
                        }
                    } else if (view instanceof RatingBar) {
                        obj = String.valueOf(((RatingBar) view).getRating());
                    }
                } else if (((Spinner) view).getCount() > 0 && (selectedItem = ((Spinner) view).getSelectedItem()) != null) {
                    obj = selectedItem.toString();
                }
                obj = null;
            }
            if (obj == null) {
                return "";
            }
            String obj2 = obj.toString();
            if (obj2 == null) {
                return "";
            }
            return obj2;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final View getTouchReactView(float[] fArr, View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            Method method = methodFindTouchTargetView;
            if (!(method == null || view == null)) {
                if (method != null) {
                    Object invoke = method.invoke((Object) null, new Object[]{fArr, view});
                    if (invoke != null) {
                        View view2 = (View) invoke;
                        if (view2.getId() > 0) {
                            ViewParent parent = view2.getParent();
                            if (parent != null) {
                                return (View) parent;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        } catch (IllegalAccessException e10) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e10);
        } catch (InvocationTargetException e11) {
            Utility utility2 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e11);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
        return null;
    }

    private final float[] getViewLocationOnScreen(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new float[]{(float) iArr[0], (float) iArr[1]};
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final void initTouchTargetHelperMethods() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (methodFindTouchTargetView == null) {
                    Method declaredMethod = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, new Class[]{float[].class, ViewGroup.class});
                    methodFindTouchTargetView = declaredMethod;
                    if (declaredMethod != null) {
                        declaredMethod.setAccessible(true);
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } catch (ClassNotFoundException e10) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e10);
            } catch (NoSuchMethodException e11) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e11);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private static final boolean isAdapterViewItem(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            ViewHierarchy viewHierarchy = INSTANCE;
            Class<?> existingClass = viewHierarchy.getExistingClass("android.support.v4.view.NestedScrollingChild");
            if (existingClass != null && existingClass.isInstance(parent)) {
                return true;
            }
            Class<?> existingClass2 = viewHierarchy.getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass2 == null || !existingClass2.isInstance(parent)) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    private final boolean isRCTRootView(View view) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return j.b(view.getClass().getName(), CLASS_RCTROOTVIEW);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setOnClickListener(android.view.View r5, android.view.View.OnClickListener r6) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "view"
            kotlin.jvm.internal.j.g(r5, r1)     // Catch:{ all -> 0x004b }
            r1 = 0
            java.lang.String r2 = "android.view.View"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0028 }
            java.lang.String r3 = "mListenerInfo"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0028 }
            java.lang.String r3 = "android.view.View$ListenerInfo"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0029 }
            java.lang.String r4 = "mOnClickListener"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0029 }
            goto L_0x002a
        L_0x0028:
            r2 = r1
        L_0x0029:
            r3 = r1
        L_0x002a:
            if (r2 == 0) goto L_0x0047
            if (r3 != 0) goto L_0x002f
            goto L_0x0047
        L_0x002f:
            r4 = 1
            r2.setAccessible(r4)     // Catch:{ Exception -> 0x004a }
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x004a }
            r2.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x003d }
            java.lang.Object r1 = r2.get(r5)     // Catch:{ IllegalAccessException -> 0x003d }
        L_0x003d:
            if (r1 != 0) goto L_0x0043
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x004a }
            return
        L_0x0043:
            r3.set(r1, r6)     // Catch:{ Exception -> 0x004a }
            goto L_0x004a
        L_0x0047:
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            return
        L_0x004b:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.setOnClickListener(android.view.View, android.view.View$OnClickListener):void");
    }

    public static final void updateAppearanceOfView(View view, b bVar, float f10) {
        Bitmap bitmap;
        Typeface typeface;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(view, "view");
                j.g(bVar, JsonPacketExtension.ELEMENT);
                b bVar2 = new b();
                if ((view instanceof TextView) && (typeface = ((TextView) view).getTypeface()) != null) {
                    bVar2.put(ViewHierarchyConstants.TEXT_SIZE, (double) ((TextView) view).getTextSize());
                    bVar2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                    bVar2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                    bVar.put(ViewHierarchyConstants.TEXT_STYLE, (Object) bVar2);
                }
                if (view instanceof ImageView) {
                    Drawable drawable = ((ImageView) view).getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        float f11 = (float) 44;
                        if (((float) view.getHeight()) / f10 <= f11 && ((float) view.getWidth()) / f10 <= f11 && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                            bVar.put(ViewHierarchyConstants.ICON_BITMAP, (Object) Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                        }
                    }
                }
            } catch (JSONException e10) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e10);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void updateBasicInfoOfView(View view, b bVar) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(view, "view");
                j.g(bVar, JsonPacketExtension.ELEMENT);
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                bVar.put(ViewHierarchyConstants.CLASS_NAME_KEY, (Object) view.getClass().getCanonicalName());
                bVar.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
                bVar.put("id", view.getId());
                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    bVar.put("text", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                } else {
                    bVar.put("text", (Object) "");
                    bVar.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
                }
                bVar.put(ViewHierarchyConstants.HINT_KEY, (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    bVar.put("tag", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    bVar.put("description", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                bVar.put(ViewHierarchyConstants.DIMENSION_KEY, (Object) INSTANCE.getDimensionOfView(view));
            } catch (JSONException e10) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e10);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public final boolean isRCTButton(View view, View view2) {
        View touchReactView;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            j.g(view, "view");
            if (!j.b(view.getClass().getName(), CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null || touchReactView.getId() != view.getId()) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }
}
