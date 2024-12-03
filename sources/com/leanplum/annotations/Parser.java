package com.leanplum.annotations;

import android.text.TextUtils;
import com.leanplum.Var;
import com.leanplum.callbacks.VariableCallback;
import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class Parser {
    private static void defineFileVariable(Object obj, String str, String str2, final Field field) {
        final boolean z10;
        final Var<String> defineFile = Var.defineFile(str, str2);
        if (obj != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        final WeakReference weakReference = new WeakReference(obj);
        defineFile.addFileReadyHandler(new VariableCallback<String>() {
            public void handle(Var<String> var) {
                Field field;
                Object obj = weakReference.get();
                if ((!z10 || obj != null) && (field = field) != null) {
                    try {
                        boolean isAccessible = field.isAccessible();
                        if (!isAccessible) {
                            field.setAccessible(true);
                        }
                        field.set(obj, defineFile.fileValue());
                        if (!isAccessible) {
                            field.setAccessible(false);
                        }
                    } catch (IllegalArgumentException e10) {
                        Log.e("Invalid value " + ((String) defineFile.value()) + " for field " + defineFile.name(), (Throwable) e10);
                    } catch (IllegalAccessException e11) {
                        Log.e("Error setting value for field " + defineFile.name(), (Throwable) e11);
                    }
                } else {
                    defineFile.removeFileReadyHandler(this);
                }
            }
        });
    }

    private static <T> void defineVariable(Object obj, String str, T t10, String str2, final Field field) {
        final boolean z10;
        final Var define = Var.define(str, t10, str2);
        if (obj != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        final WeakReference weakReference = new WeakReference(obj);
        define.addValueChangedHandler(new VariableCallback<T>() {
            public void handle(Var<T> var) {
                Field field;
                Object obj = weakReference.get();
                if ((!z10 || obj != null) && (field = field) != null) {
                    try {
                        boolean isAccessible = field.isAccessible();
                        if (!isAccessible) {
                            field.setAccessible(true);
                        }
                        field.set(obj, define.value());
                        if (!isAccessible) {
                            field.setAccessible(false);
                        }
                    } catch (IllegalArgumentException e10) {
                        Log.e("Invalid value " + define.value() + " for field " + define.name(), (Throwable) e10);
                    } catch (IllegalAccessException e11) {
                        Log.e("Error setting value for field " + define.name(), (Throwable) e11);
                    }
                } else {
                    define.removeValueChangedHandler(this);
                }
            }
        });
    }

    public static void parseVariables(Object... objArr) {
        try {
            for (Object obj : objArr) {
                parseVariablesHelper(obj, obj.getClass());
            }
        } catch (Throwable th2) {
            Log.e("Error parsing variables", th2);
        }
    }

    public static void parseVariablesForClasses(Class<?>... clsArr) {
        try {
            for (Class<?> parseVariablesHelper : clsArr) {
                parseVariablesHelper((Object) null, parseVariablesHelper);
            }
        } catch (Throwable th2) {
            Log.e("Error parsing variables", th2);
        }
    }

    private static void parseVariablesHelper(Object obj, Class<?> cls) throws IllegalArgumentException, IllegalAccessException {
        boolean z10;
        String str;
        String str2;
        String str3;
        for (Field field : cls.getFields()) {
            if (field.isAnnotationPresent(Variable.class)) {
                Variable variable = (Variable) field.getAnnotation(Variable.class);
                str = variable.group();
                str2 = variable.name();
                z10 = false;
            } else if (field.isAnnotationPresent(File.class)) {
                File file = (File) field.getAnnotation(File.class);
                str = file.group();
                str2 = file.name();
                z10 = true;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = field.getName();
            }
            if (!TextUtils.isEmpty(str)) {
                str2 = str + "." + str2;
            }
            Class<?> type = field.getType();
            String cls2 = type.toString();
            if (cls2.equals(org.apache.commons.validator.Var.JSTYPE_INT)) {
                defineVariable(obj, str2, Integer.valueOf(field.getInt(obj)), Constants.Kinds.INT, field);
            } else if (cls2.equals("byte")) {
                defineVariable(obj, str2, Byte.valueOf(field.getByte(obj)), Constants.Kinds.INT, field);
            } else if (cls2.equals("short")) {
                defineVariable(obj, str2, Short.valueOf(field.getShort(obj)), Constants.Kinds.INT, field);
            } else if (cls2.equals("long")) {
                defineVariable(obj, str2, Long.valueOf(field.getLong(obj)), Constants.Kinds.INT, field);
            } else if (cls2.equals("char")) {
                defineVariable(obj, str2, Character.valueOf(field.getChar(obj)), Constants.Kinds.INT, field);
            } else if (cls2.equals(Constants.Kinds.FLOAT)) {
                defineVariable(obj, str2, Float.valueOf(field.getFloat(obj)), Constants.Kinds.FLOAT, field);
            } else if (cls2.equals("double")) {
                defineVariable(obj, str2, Double.valueOf(field.getDouble(obj)), Constants.Kinds.FLOAT, field);
            } else if (cls2.equals("boolean")) {
                defineVariable(obj, str2, Boolean.valueOf(field.getBoolean(obj)), Constants.Kinds.BOOLEAN, field);
            } else if (type.isPrimitive()) {
                Log.e("Variable " + str2 + " is an unsupported primitive type.", new Object[0]);
            } else if (type.isArray()) {
                Log.e("Variable " + str2 + " should be a List instead of an Array.", new Object[0]);
            } else if (type.isAssignableFrom(List.class)) {
                defineVariable(obj, str2, field.get(obj), "list", field);
            } else if (type.isAssignableFrom(Map.class)) {
                defineVariable(obj, str2, field.get(obj), "group", field);
            } else {
                Object obj2 = field.get(obj);
                if (obj2 == null) {
                    str3 = null;
                } else {
                    str3 = obj2.toString();
                }
                if (z10) {
                    defineFileVariable(obj, str2, str3, field);
                } else {
                    defineVariable(obj, str2, str3, "string", field);
                }
            }
        }
    }
}
