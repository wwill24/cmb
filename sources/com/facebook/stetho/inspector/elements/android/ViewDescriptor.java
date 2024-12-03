package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewDebug;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.ReflectionUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import com.facebook.stetho.inspector.helper.IntegerFormatter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

final class ViewDescriptor extends AbstractChainedDescriptor<View> implements HighlightableDescriptor<View> {
    private static final String ACCESSIBILITY_STYLE_RULE_NAME = "Accessibility Properties";
    private static final String ID_NAME = "id";
    private static final String NONE_MAPPING = "<no mapping>";
    private static final String NONE_VALUE = "(none)";
    private static final String VIEW_STYLE_RULE_NAME = "<this_view>";
    private static final boolean sHasSupportNodeInfo = (ReflectionUtil.tryGetClassForName("androidx.core.view.accessibility.AccessibilityNodeInfoCompat") != null);
    private final MethodInvoker mMethodInvoker;
    private volatile List<ViewCSSProperty> mViewProperties;
    private Pattern mWordBoundaryPattern;

    private final class FieldBackedCSSProperty extends ViewCSSProperty {
        private final Field mField;

        public FieldBackedCSSProperty(Field field, String str, ViewDebug.ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mField = field;
            field.setAccessible(true);
        }

        public Object getValue(View view) throws InvocationTargetException, IllegalAccessException {
            return this.mField.get(view);
        }
    }

    private final class MethodBackedCSSProperty extends ViewCSSProperty {
        private final Method mMethod;

        public MethodBackedCSSProperty(Method method, String str, ViewDebug.ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mMethod = method;
            method.setAccessible(true);
        }

        public Object getValue(View view) throws InvocationTargetException, IllegalAccessException {
            return this.mMethod.invoke(view, new Object[0]);
        }
    }

    private abstract class ViewCSSProperty {
        private final ViewDebug.ExportedProperty mAnnotation;
        private final String mCSSName;

        public ViewCSSProperty(String str, ViewDebug.ExportedProperty exportedProperty) {
            this.mCSSName = str;
            this.mAnnotation = exportedProperty;
        }

        public final ViewDebug.ExportedProperty getAnnotation() {
            return this.mAnnotation;
        }

        public final String getCSSName() {
            return this.mCSSName;
        }

        public abstract Object getValue(View view) throws InvocationTargetException, IllegalAccessException;
    }

    public ViewDescriptor() {
        this(new MethodInvoker());
    }

    private static boolean canFlagsBeMappedToString(ViewDebug.ExportedProperty exportedProperty) {
        if (exportedProperty == null || exportedProperty.flagMapping() == null || exportedProperty.flagMapping().length <= 0) {
            return false;
        }
        return true;
    }

    private static boolean canIntBeMappedToString(ViewDebug.ExportedProperty exportedProperty) {
        if (exportedProperty == null || exportedProperty.mapping() == null || exportedProperty.mapping().length <= 0) {
            return false;
        }
        return true;
    }

    private static String capitalize(String str) {
        if (str == null || str.length() == 0 || Character.isTitleCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str);
        sb2.setCharAt(0, Character.toTitleCase(sb2.charAt(0)));
        return sb2.toString();
    }

    private String convertViewPropertyNameToCSSName(String str) {
        String[] split = getWordBoundaryPattern().split(str);
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < split.length; i10++) {
            if (!split[i10].equals("get") && !split[i10].equals(NetworkProfile.MALE)) {
                sb2.append(split[i10].toLowerCase());
                if (i10 < split.length - 1) {
                    sb2.append(SignatureVisitor.SUPER);
                }
            }
        }
        return sb2.toString();
    }

    private static String getIdAttribute(View view) {
        int id2 = view.getId();
        if (id2 == -1) {
            return null;
        }
        return ResourcesUtil.getIdStringQuietly(view, view.getResources(), id2);
    }

    private void getIdStyle(View view, StyleAccumulator styleAccumulator) {
        String idAttribute = getIdAttribute(view);
        if (idAttribute == null) {
            styleAccumulator.store("id", NONE_VALUE, false);
        } else {
            styleAccumulator.store("id", idAttribute, false);
        }
    }

    private void getStyleFromInteger(String str, Integer num, ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        String format2 = IntegerFormatter.getInstance().format(num, exportedProperty);
        if (canIntBeMappedToString(exportedProperty)) {
            styleAccumulator.store(str, format2 + " (" + mapIntToStringUsingAnnotation(num.intValue(), exportedProperty) + ")", false);
        } else if (canFlagsBeMappedToString(exportedProperty)) {
            styleAccumulator.store(str, format2 + " (" + mapFlagsToStringUsingAnnotation(num.intValue(), exportedProperty) + ")", false);
        } else {
            Boolean bool = Boolean.TRUE;
            if (num.intValue() != 0 || canFlagsBeMappedToString(exportedProperty) || canIntBeMappedToString(exportedProperty)) {
                bool = Boolean.FALSE;
            }
            styleAccumulator.store(str, format2, bool.booleanValue());
        }
    }

    private void getStyleFromValue(View view, String str, Object obj, ViewDebug.ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        if (str.equals("id")) {
            getIdStyle(view, styleAccumulator);
        } else if (obj instanceof Integer) {
            getStyleFromInteger(str, (Integer) obj, exportedProperty, styleAccumulator);
        } else {
            boolean z10 = true;
            if (obj instanceof Float) {
                String valueOf = String.valueOf(obj);
                if (((Float) obj).floatValue() != 0.0f) {
                    z10 = false;
                }
                styleAccumulator.store(str, valueOf, z10);
            } else if (obj instanceof Boolean) {
                styleAccumulator.store(str, String.valueOf(obj), false);
            } else if (obj instanceof Short) {
                String valueOf2 = String.valueOf(obj);
                if (((Short) obj).shortValue() != 0) {
                    z10 = false;
                }
                styleAccumulator.store(str, valueOf2, z10);
            } else if (obj instanceof Long) {
                String valueOf3 = String.valueOf(obj);
                if (((Long) obj).longValue() != 0) {
                    z10 = false;
                }
                styleAccumulator.store(str, valueOf3, z10);
            } else if (obj instanceof Double) {
                String valueOf4 = String.valueOf(obj);
                if (((Double) obj).doubleValue() != 0.0d) {
                    z10 = false;
                }
                styleAccumulator.store(str, valueOf4, z10);
            } else if (obj instanceof Byte) {
                String valueOf5 = String.valueOf(obj);
                if (((Byte) obj).byteValue() != 0) {
                    z10 = false;
                }
                styleAccumulator.store(str, valueOf5, z10);
            } else if (obj instanceof Character) {
                String valueOf6 = String.valueOf(obj);
                if (((Character) obj).charValue() != 0) {
                    z10 = false;
                }
                styleAccumulator.store(str, valueOf6, z10);
            } else if (obj instanceof CharSequence) {
                String valueOf7 = String.valueOf(obj);
                if (((CharSequence) obj).length() != 0) {
                    z10 = false;
                }
                styleAccumulator.store(str, valueOf7, z10);
            } else {
                getStylesFromObject(view, str, obj, exportedProperty, styleAccumulator);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        if (r7.equals("topMargin") == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getStylesFromObject(android.view.View r14, java.lang.String r15, java.lang.Object r16, android.view.ViewDebug.ExportedProperty r17, com.facebook.stetho.inspector.elements.StyleAccumulator r18) {
        /*
            r13 = this;
            r1 = r16
            if (r17 == 0) goto L_0x00d6
            boolean r0 = r17.deepExport()
            if (r0 == 0) goto L_0x00d6
            if (r1 != 0) goto L_0x000e
            goto L_0x00d6
        L_0x000e:
            java.lang.Class r0 = r16.getClass()
            java.lang.reflect.Field[] r0 = r0.getFields()
            int r2 = r0.length
            r3 = 0
            r4 = r3
        L_0x0019:
            if (r4 >= r2) goto L_0x00d4
            r5 = r0[r4]
            int r6 = r5.getModifiers()
            boolean r6 = java.lang.reflect.Modifier.isStatic(r6)
            if (r6 == 0) goto L_0x002a
            r6 = r13
            goto L_0x00ac
        L_0x002a:
            r6 = 1
            r5.setAccessible(r6)     // Catch:{ IllegalAccessException -> 0x00b0 }
            java.lang.Object r10 = r5.get(r1)     // Catch:{ IllegalAccessException -> 0x00b0 }
            java.lang.String r7 = r5.getName()
            r7.hashCode()
            r8 = -1
            int r9 = r7.hashCode()
            switch(r9) {
                case -599904534: goto L_0x0062;
                case -414179485: goto L_0x0059;
                case 1928835221: goto L_0x004e;
                case 2064613305: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            r6 = r8
            goto L_0x006c
        L_0x0043:
            java.lang.String r6 = "bottomMargin"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x004c
            goto L_0x0041
        L_0x004c:
            r6 = 3
            goto L_0x006c
        L_0x004e:
            java.lang.String r6 = "leftMargin"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x0057
            goto L_0x0041
        L_0x0057:
            r6 = 2
            goto L_0x006c
        L_0x0059:
            java.lang.String r9 = "topMargin"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x006c
            goto L_0x0041
        L_0x0062:
            java.lang.String r6 = "rightMargin"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x006b
            goto L_0x0041
        L_0x006b:
            r6 = r3
        L_0x006c:
            switch(r6) {
                case 0: goto L_0x0098;
                case 1: goto L_0x0094;
                case 2: goto L_0x0090;
                case 3: goto L_0x008b;
                default: goto L_0x006f;
            }
        L_0x006f:
            java.lang.String r6 = r17.prefix()
            if (r6 != 0) goto L_0x0076
            goto L_0x0085
        L_0x0076:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
        L_0x0085:
            r6 = r13
            java.lang.String r7 = r13.convertViewPropertyNameToCSSName(r7)
            goto L_0x008e
        L_0x008b:
            r6 = r13
            java.lang.String r7 = "margin-bottom"
        L_0x008e:
            r9 = r7
            goto L_0x009c
        L_0x0090:
            r6 = r13
            java.lang.String r7 = "margin-left"
            goto L_0x008e
        L_0x0094:
            r6 = r13
            java.lang.String r7 = "margin-top"
            goto L_0x008e
        L_0x0098:
            r6 = r13
            java.lang.String r7 = "margin-right"
            goto L_0x008e
        L_0x009c:
            java.lang.Class<android.view.ViewDebug$ExportedProperty> r7 = android.view.ViewDebug.ExportedProperty.class
            java.lang.annotation.Annotation r5 = r5.getAnnotation(r7)
            r11 = r5
            android.view.ViewDebug$ExportedProperty r11 = (android.view.ViewDebug.ExportedProperty) r11
            r7 = r13
            r8 = r14
            r12 = r18
            r7.getStyleFromValue(r8, r9, r10, r11, r12)
        L_0x00ac:
            int r4 = r4 + 1
            goto L_0x0019
        L_0x00b0:
            r0 = move-exception
            r6 = r13
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "failed to get property of name: \""
            r2.append(r3)
            r3 = r15
            r2.append(r15)
            java.lang.String r3 = "\" of object: "
            r2.append(r3)
            java.lang.String r1 = java.lang.String.valueOf(r16)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.facebook.stetho.common.LogUtil.e((java.lang.Throwable) r0, (java.lang.String) r1)
            return
        L_0x00d4:
            r6 = r13
            return
        L_0x00d6:
            r6 = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.elements.android.ViewDescriptor.getStylesFromObject(android.view.View, java.lang.String, java.lang.Object, android.view.ViewDebug$ExportedProperty, com.facebook.stetho.inspector.elements.StyleAccumulator):void");
    }

    private List<ViewCSSProperty> getViewProperties() {
        if (this.mViewProperties == null) {
            synchronized (this) {
                if (this.mViewProperties == null) {
                    ArrayList arrayList = new ArrayList();
                    for (Method method : View.class.getDeclaredMethods()) {
                        ViewDebug.ExportedProperty exportedProperty = (ViewDebug.ExportedProperty) method.getAnnotation(ViewDebug.ExportedProperty.class);
                        if (exportedProperty != null) {
                            arrayList.add(new MethodBackedCSSProperty(method, convertViewPropertyNameToCSSName(method.getName()), exportedProperty));
                        }
                    }
                    for (Field field : View.class.getDeclaredFields()) {
                        ViewDebug.ExportedProperty exportedProperty2 = (ViewDebug.ExportedProperty) field.getAnnotation(ViewDebug.ExportedProperty.class);
                        if (exportedProperty2 != null) {
                            arrayList.add(new FieldBackedCSSProperty(field, convertViewPropertyNameToCSSName(field.getName()), exportedProperty2));
                        }
                    }
                    Collections.sort(arrayList, new Comparator<ViewCSSProperty>() {
                        public int compare(ViewCSSProperty viewCSSProperty, ViewCSSProperty viewCSSProperty2) {
                            return viewCSSProperty.getCSSName().compareTo(viewCSSProperty2.getCSSName());
                        }
                    });
                    this.mViewProperties = Collections.unmodifiableList(arrayList);
                }
            }
        }
        return this.mViewProperties;
    }

    private Pattern getWordBoundaryPattern() {
        if (this.mWordBoundaryPattern == null) {
            this.mWordBoundaryPattern = Pattern.compile("(?<=\\p{Lower})(?=\\p{Upper})");
        }
        return this.mWordBoundaryPattern;
    }

    private static String mapFlagsToStringUsingAnnotation(int i10, ViewDebug.ExportedProperty exportedProperty) {
        boolean z10;
        if (canFlagsBeMappedToString(exportedProperty)) {
            StringBuilder sb2 = null;
            boolean z11 = false;
            for (ViewDebug.FlagToString flagToString : exportedProperty.flagMapping()) {
                boolean outputIf = flagToString.outputIf();
                if ((flagToString.mask() & i10) == flagToString.equals()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (outputIf == z10) {
                    if (sb2 == null) {
                        sb2 = new StringBuilder();
                    }
                    if (z11) {
                        sb2.append(" | ");
                    }
                    sb2.append(flagToString.name());
                    z11 = true;
                }
            }
            if (z11) {
                return sb2.toString();
            }
            return NONE_MAPPING;
        }
        throw new IllegalStateException("Cannot map using this annotation");
    }

    private static String mapIntToStringUsingAnnotation(int i10, ViewDebug.ExportedProperty exportedProperty) {
        if (canIntBeMappedToString(exportedProperty)) {
            for (ViewDebug.IntToString intToString : exportedProperty.mapping()) {
                if (intToString.from() == i10) {
                    return intToString.to();
                }
            }
            return NONE_MAPPING;
        }
        throw new IllegalStateException("Cannot map using this annotation");
    }

    public View getViewAndBoundsForHighlighting(View view, Rect rect) {
        return view;
    }

    public ViewDescriptor(MethodInvoker methodInvoker) {
        this.mMethodInvoker = methodInvoker;
    }

    public Object getElementToHighlightAtPosition(View view, int i10, int i11, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        return view;
    }

    /* access modifiers changed from: protected */
    public void onGetAttributes(View view, AttributeAccumulator attributeAccumulator) {
        String idAttribute = getIdAttribute(view);
        if (idAttribute != null) {
            attributeAccumulator.store("id", idAttribute);
        }
    }

    /* access modifiers changed from: protected */
    public void onGetComputedStyles(View view, ComputedStyleAccumulator computedStyleAccumulator) {
        computedStyleAccumulator.store(ViewHierarchyConstants.DIMENSION_LEFT_KEY, Integer.toString(view.getLeft()));
        computedStyleAccumulator.store(ViewHierarchyConstants.DIMENSION_TOP_KEY, Integer.toString(view.getTop()));
        computedStyleAccumulator.store("right", Integer.toString(view.getRight()));
        computedStyleAccumulator.store("bottom", Integer.toString(view.getBottom()));
    }

    /* access modifiers changed from: protected */
    public String onGetNodeName(View view) {
        String name = view.getClass().getName();
        return StringUtil.removePrefix(name, "android.view.", StringUtil.removePrefix(name, "android.widget."));
    }

    /* access modifiers changed from: protected */
    public void onGetStyleRuleNames(View view, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        styleRuleNameAccumulator.store(VIEW_STYLE_RULE_NAME, false);
        if (sHasSupportNodeInfo) {
            styleRuleNameAccumulator.store(ACCESSIBILITY_STYLE_RULE_NAME, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onGetStyles(View view, String str, StyleAccumulator styleAccumulator) {
        if (VIEW_STYLE_RULE_NAME.equals(str)) {
            List<ViewCSSProperty> viewProperties = getViewProperties();
            int size = viewProperties.size();
            for (int i10 = 0; i10 < size; i10++) {
                ViewCSSProperty viewCSSProperty = viewProperties.get(i10);
                try {
                    getStyleFromValue(view, viewCSSProperty.getCSSName(), viewCSSProperty.getValue(view), viewCSSProperty.getAnnotation(), styleAccumulator);
                } catch (Exception e10) {
                    if ((e10 instanceof IllegalAccessException) || (e10 instanceof InvocationTargetException)) {
                        LogUtil.e((Throwable) e10, "failed to get style property " + viewCSSProperty.getCSSName() + " of element= " + view.toString());
                    } else {
                        throw ExceptionUtil.propagate(e10);
                    }
                }
            }
        } else if (ACCESSIBILITY_STYLE_RULE_NAME.equals(str) && sHasSupportNodeInfo) {
            boolean ignored = AccessibilityNodeInfoWrapper.getIgnored(view);
            getStyleFromValue(view, "ignored", Boolean.valueOf(ignored), (ViewDebug.ExportedProperty) null, styleAccumulator);
            if (ignored) {
                getStyleFromValue(view, "ignored-reasons", AccessibilityNodeInfoWrapper.getIgnoredReasons(view), (ViewDebug.ExportedProperty) null, styleAccumulator);
            }
            getStyleFromValue(view, "focusable", Boolean.valueOf(!ignored), (ViewDebug.ExportedProperty) null, styleAccumulator);
            if (!ignored) {
                getStyleFromValue(view, "focusable-reasons", AccessibilityNodeInfoWrapper.getFocusableReasons(view), (ViewDebug.ExportedProperty) null, styleAccumulator);
                View view2 = view;
                getStyleFromValue(view2, "focused", Boolean.valueOf(AccessibilityNodeInfoWrapper.getIsAccessibilityFocused(view)), (ViewDebug.ExportedProperty) null, styleAccumulator);
                getStyleFromValue(view, "description", AccessibilityNodeInfoWrapper.getDescription(view), (ViewDebug.ExportedProperty) null, styleAccumulator);
                getStyleFromValue(view2, "actions", AccessibilityNodeInfoWrapper.getActions(view), (ViewDebug.ExportedProperty) null, styleAccumulator);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSetAttributesAsText(View view, String str) {
        for (Map.Entry next : Descriptor.parseSetAttributesAsTextArg(str).entrySet()) {
            this.mMethodInvoker.invoke(view, "set" + capitalize((String) next.getKey()), (String) next.getValue());
        }
    }
}
