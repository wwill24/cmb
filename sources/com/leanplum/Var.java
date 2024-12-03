package com.leanplum;

import android.text.TextUtils;
import com.leanplum.callbacks.VariableCallback;
import com.leanplum.internal.Constants;
import com.leanplum.internal.FileManager;
import com.leanplum.internal.LeanplumInternal;
import com.leanplum.internal.Log;
import com.leanplum.internal.OperationQueue;
import com.leanplum.internal.Util;
import com.leanplum.internal.VarCache;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Var<T> {
    private static boolean printedCallbackWarning;
    /* access modifiers changed from: private */
    public byte[] data;
    private T defaultValue;
    private boolean fileIsPending;
    private final List<VariableCallback<T>> fileReadyHandlers = new ArrayList();
    private boolean hadStarted;
    /* access modifiers changed from: private */
    public String hash;
    /* access modifiers changed from: private */
    public boolean isAsset;
    private boolean isInternal;
    public boolean isResource;
    private String kind;
    private String name;
    private String[] nameComponents;
    private Double numberValue;
    private int overrideResId;
    /* access modifiers changed from: private */
    public int size;
    public String stringValue;
    private T value;
    private final List<VariableCallback<T>> valueChangedHandlers = new ArrayList();
    private boolean valueIsInAssets = false;

    private interface VarInitializer<T> {
        void init(Var<T> var);
    }

    protected Var() {
    }

    private void cacheComputedValues() {
        T t10 = this.value;
        if (t10 instanceof String) {
            String str = (String) t10;
            this.stringValue = str;
            modifyNumberValue(str);
            modifyValue(this.numberValue);
        } else if (t10 instanceof Number) {
            this.stringValue = "" + this.value;
            this.numberValue = Double.valueOf(((Number) this.value).doubleValue());
            modifyValue((Number) this.value);
        } else if (t10 == null || (t10 instanceof Iterable) || (t10 instanceof Map)) {
            this.stringValue = null;
            this.numberValue = null;
        } else {
            this.stringValue = t10.toString();
            this.numberValue = null;
        }
    }

    /* access modifiers changed from: private */
    public InputStream defaultStream() {
        try {
            if (!"file".equals(this.kind)) {
                return null;
            }
            boolean z10 = this.isResource;
            Boolean valueOf = Boolean.valueOf(this.isAsset);
            Boolean valueOf2 = Boolean.valueOf(this.valueIsInAssets);
            T t10 = this.defaultValue;
            return FileManager.stream(z10, valueOf, valueOf2, (String) t10, (String) t10, this.data);
        } catch (Throwable th2) {
            Log.exception(th2);
            return null;
        }
    }

    private static <T> Var<T> define(String str, T t10, String str2, VarInitializer<T> varInitializer) {
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            Log.e("Empty name parameter provided.", new Object[0]);
            return null;
        }
        Var<T> variable = VarCache.getVariable(str);
        if (variable != null) {
            return variable;
        }
        if (LeanplumInternal.hasCalledStart() && !str.startsWith(Constants.Values.RESOURCES_VARIABLE)) {
            Log.i("You should not create new variables after calling start (name=" + str + ")", new Object[0]);
        }
        Var<T> var = new Var<>();
        try {
            var.name = str;
            var.nameComponents = VarCache.getNameComponents(str);
            var.defaultValue = t10;
            var.value = t10;
            var.kind = str2;
            if (str.startsWith(Constants.Values.RESOURCES_VARIABLE)) {
                var.isInternal = true;
            }
            if (varInitializer != null) {
                varInitializer.init(var);
            }
            var.cacheComputedValues();
            VarCache.registerVariable(var);
            if ("file".equals(var.kind)) {
                if (var.isResource) {
                    VarCache.registerFile(var.stringValue, new w(var), var.hash, var.size);
                } else {
                    if (var.defaultValue() != null) {
                        str3 = var.defaultValue().toString();
                    }
                    VarCache.registerFile(var.stringValue, str3, new w(var));
                }
            }
            var.update();
        } catch (Throwable th2) {
            Log.exception(th2);
        }
        return var;
    }

    public static Var<String> defineAsset(String str, String str2) {
        return define(str, str2, "file", new VarInitializer<String>() {
            public void init(Var<String> var) {
                boolean unused = var.isAsset = true;
            }
        });
    }

    public static Var<Integer> defineColor(String str, int i10) {
        return define(str, Integer.valueOf(i10), Constants.Kinds.COLOR, (VarInitializer) null);
    }

    public static Var<String> defineFile(String str, String str2) {
        return define(str, str2, "file", (VarInitializer) null);
    }

    public static Var<String> defineResource(String str, int i10) {
        return define(str, Util.generateResourceNameFromId(i10), "file", new VarInitializer<String>() {
            public void init(Var<String> var) {
                var.isResource = true;
            }
        });
    }

    private void modifyNumberValue(String str) {
        try {
            this.numberValue = Double.valueOf(str);
        } catch (NumberFormatException unused) {
            this.numberValue = null;
            T t10 = this.defaultValue;
            if (t10 instanceof Number) {
                this.numberValue = Double.valueOf(((Number) t10).doubleValue());
            }
        }
    }

    private void modifyValue(Number number) {
        if (number != null) {
            T t10 = this.defaultValue;
            if (t10 instanceof Byte) {
                this.value = Byte.valueOf(number.byteValue());
            } else if (t10 instanceof Short) {
                this.value = Short.valueOf(number.shortValue());
            } else if (t10 instanceof Integer) {
                this.value = Integer.valueOf(number.intValue());
            } else if (t10 instanceof Long) {
                this.value = Long.valueOf(number.longValue());
            } else if (t10 instanceof Float) {
                this.value = Float.valueOf(number.floatValue());
            } else if (t10 instanceof Double) {
                this.value = Double.valueOf(number.doubleValue());
            } else if (t10 instanceof Character) {
                this.value = Character.valueOf((char) number.intValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public void triggerFileIsReady() {
        synchronized (this.fileReadyHandlers) {
            this.fileIsPending = false;
            for (VariableCallback next : this.fileReadyHandlers) {
                next.setVariable(this);
                OperationQueue.sharedInstance().addUiOperation(next);
            }
        }
    }

    private void triggerValueChanged() {
        synchronized (this.valueChangedHandlers) {
            for (VariableCallback next : this.valueChangedHandlers) {
                next.setVariable(this);
                OperationQueue.sharedInstance().addUiOperation(next);
            }
        }
    }

    private void warnIfNotStarted() {
        if (!this.isInternal && !Leanplum.hasStarted() && !printedCallbackWarning) {
            Log.i("Leanplum hasn't finished retrieving values from the server. You should use a callback to make sure the value for '%s' is ready. Otherwise, your app may not use the most up-to-date value.", this.name);
            printedCallbackWarning = true;
        }
    }

    public void addFileReadyHandler(VariableCallback<T> variableCallback) {
        if (variableCallback == null) {
            Log.e("Invalid handler parameter provided.", new Object[0]);
            return;
        }
        synchronized (this.fileReadyHandlers) {
            this.fileReadyHandlers.add(variableCallback);
        }
        if (Leanplum.hasStarted() && !this.fileIsPending) {
            variableCallback.handle(this);
        }
    }

    public void addValueChangedHandler(VariableCallback<T> variableCallback) {
        if (variableCallback == null) {
            Log.e("Invalid handler parameter provided.", new Object[0]);
            return;
        }
        synchronized (this.valueChangedHandlers) {
            this.valueChangedHandlers.add(variableCallback);
        }
        if (Leanplum.hasStarted()) {
            variableCallback.handle(this);
        }
    }

    public int count() {
        try {
            warnIfNotStarted();
            Object mergedValueFromComponentArray = VarCache.getMergedValueFromComponentArray(this.nameComponents);
            if (mergedValueFromComponentArray instanceof List) {
                return ((List) mergedValueFromComponentArray).size();
            }
            LeanplumInternal.maybeThrowException(new UnsupportedOperationException("This variable is not a list."));
            return 0;
        } catch (Throwable th2) {
            Log.exception(th2);
            return 0;
        }
    }

    public T defaultValue() {
        return this.defaultValue;
    }

    public String fileValue() {
        try {
            warnIfNotStarted();
            if ("file".equals(this.kind)) {
                return FileManager.fileValue(this.stringValue, (String) this.defaultValue, Boolean.valueOf(this.valueIsInAssets));
            }
            return null;
        } catch (Throwable th2) {
            Log.exception(th2);
            return null;
        }
    }

    public String kind() {
        return this.kind;
    }

    public String name() {
        return this.name;
    }

    public String[] nameComponents() {
        return this.nameComponents;
    }

    public Number numberValue() {
        warnIfNotStarted();
        return this.numberValue;
    }

    public Object objectForKeyPath(Object... objArr) {
        try {
            warnIfNotStarted();
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, this.nameComponents);
            if (objArr != null && objArr.length > 0) {
                Collections.addAll(arrayList, objArr);
            }
            return VarCache.getMergedValueFromComponentArray(arrayList.toArray(new Object[arrayList.size()]));
        } catch (Throwable th2) {
            Log.exception(th2);
            return null;
        }
    }

    public int overrideResId() {
        return this.overrideResId;
    }

    public void removeFileReadyHandler(VariableCallback<T> variableCallback) {
        if (variableCallback == null) {
            Log.e("Invalid handler parameter provided.", new Object[0]);
            return;
        }
        synchronized (this.fileReadyHandlers) {
            this.fileReadyHandlers.remove(variableCallback);
        }
    }

    public void removeValueChangedHandler(VariableCallback<T> variableCallback) {
        synchronized (this.valueChangedHandlers) {
            this.valueChangedHandlers.remove(variableCallback);
        }
    }

    public void setOverrideResId(int i10) {
        this.overrideResId = i10;
    }

    public InputStream stream() {
        try {
            if (!"file".equals(this.kind)) {
                return null;
            }
            warnIfNotStarted();
            InputStream stream = FileManager.stream(this.isResource, Boolean.valueOf(this.isAsset), Boolean.valueOf(this.valueIsInAssets), fileValue(), (String) this.defaultValue, this.data);
            if (stream == null) {
                return defaultStream();
            }
            return stream;
        } catch (Throwable th2) {
            Log.exception(th2);
            return null;
        }
    }

    public String stringValue() {
        warnIfNotStarted();
        return this.stringValue;
    }

    public String toString() {
        return "Var(" + this.name + ")=" + this.value;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void update() {
        /*
            r6 = this;
            monitor-enter(r6)
            T r0 = r6.value     // Catch:{ all -> 0x00a0 }
            java.lang.String[] r1 = r6.nameComponents     // Catch:{ all -> 0x00a0 }
            java.lang.Object r1 = com.leanplum.internal.VarCache.getMergedValueFromComponentArray(r1)     // Catch:{ all -> 0x00a0 }
            r6.value = r1     // Catch:{ all -> 0x00a0 }
            if (r1 != 0) goto L_0x0011
            if (r0 != 0) goto L_0x0011
            monitor-exit(r6)
            return
        L_0x0011:
            if (r1 == 0) goto L_0x0021
            if (r0 == 0) goto L_0x0021
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0021
            boolean r0 = r6.hadStarted     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0021
            monitor-exit(r6)
            return
        L_0x0021:
            r6.cacheComputedValues()     // Catch:{ all -> 0x00a0 }
            boolean r0 = com.leanplum.internal.VarCache.silent()     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r6.name     // Catch:{ all -> 0x00a0 }
            java.lang.String r1 = "__Android Resources"
            boolean r0 = r0.startsWith(r1)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = "file"
            java.lang.String r1 = r6.kind     // Catch:{ all -> 0x00a0 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0045
            boolean r0 = r6.fileIsPending     // Catch:{ all -> 0x00a0 }
            if (r0 != 0) goto L_0x0045
            r6.triggerFileIsReady()     // Catch:{ all -> 0x00a0 }
        L_0x0045:
            boolean r0 = com.leanplum.internal.VarCache.silent()     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x004d
            monitor-exit(r6)
            return
        L_0x004d:
            boolean r0 = com.leanplum.Leanplum.hasStarted()     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0056
            r6.triggerValueChanged()     // Catch:{ all -> 0x00a0 }
        L_0x0056:
            java.lang.String r0 = "file"
            java.lang.String r1 = r6.kind     // Catch:{ all -> 0x00a0 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00a0 }
            r1 = 1
            if (r0 == 0) goto L_0x0096
            boolean r0 = com.leanplum.internal.Constants.isNoop()     // Catch:{ all -> 0x00a0 }
            if (r0 != 0) goto L_0x0089
            boolean r0 = r6.isResource     // Catch:{ all -> 0x00a0 }
            java.lang.String r2 = r6.stringValue     // Catch:{ all -> 0x00a0 }
            T r3 = r6.defaultValue     // Catch:{ all -> 0x00a0 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00a0 }
            r4 = 0
            com.leanplum.Var$4 r5 = new com.leanplum.Var$4     // Catch:{ all -> 0x00a0 }
            r5.<init>()     // Catch:{ all -> 0x00a0 }
            com.leanplum.internal.FileManager$DownloadFileResult r0 = com.leanplum.internal.FileManager.maybeDownloadFile(r0, r2, r3, r4, r5)     // Catch:{ all -> 0x00a0 }
            r2 = 0
            r6.valueIsInAssets = r2     // Catch:{ all -> 0x00a0 }
            com.leanplum.internal.FileManager$DownloadFileResult r2 = com.leanplum.internal.FileManager.DownloadFileResult.DOWNLOADING     // Catch:{ all -> 0x00a0 }
            if (r0 != r2) goto L_0x0083
            r6.fileIsPending = r1     // Catch:{ all -> 0x00a0 }
            goto L_0x0089
        L_0x0083:
            com.leanplum.internal.FileManager$DownloadFileResult r2 = com.leanplum.internal.FileManager.DownloadFileResult.EXISTS_IN_ASSETS     // Catch:{ all -> 0x00a0 }
            if (r0 != r2) goto L_0x0089
            r6.valueIsInAssets = r1     // Catch:{ all -> 0x00a0 }
        L_0x0089:
            boolean r0 = com.leanplum.Leanplum.hasStarted()     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x0096
            boolean r0 = r6.fileIsPending     // Catch:{ all -> 0x00a0 }
            if (r0 != 0) goto L_0x0096
            r6.triggerFileIsReady()     // Catch:{ all -> 0x00a0 }
        L_0x0096:
            boolean r0 = com.leanplum.Leanplum.hasStarted()     // Catch:{ all -> 0x00a0 }
            if (r0 == 0) goto L_0x009e
            r6.hadStarted = r1     // Catch:{ all -> 0x00a0 }
        L_0x009e:
            monitor-exit(r6)
            return
        L_0x00a0:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.Var.update():void");
    }

    public T value() {
        warnIfNotStarted();
        return this.value;
    }

    public static Var<String> defineResource(String str, String str2, final int i10, final String str3, final byte[] bArr) {
        return define(str, str2, "file", new VarInitializer<String>() {
            public void init(Var<String> var) {
                var.isResource = true;
                int unused = var.size = i10;
                String unused2 = var.hash = str3;
                byte[] unused3 = var.data = bArr;
            }
        });
    }

    public static <T> Var<T> define(String str, T t10) {
        return define(str, t10, VarCache.kindFromValue(t10), (VarInitializer) null);
    }

    public static <T> Var<T> define(String str, T t10, String str2) {
        return define(str, t10, str2, (VarInitializer) null);
    }
}
