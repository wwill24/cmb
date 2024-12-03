package com.facebook.appevents.ml;

import com.coffeemeetsbagel.models.NetworkProfile;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001b\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J+\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u001e"}, d2 = {"Lcom/facebook/appevents/ml/Operator;", "", "()V", "addmv", "", "x", "Lcom/facebook/appevents/ml/MTensor;", "b", "concatenate", "tensors", "", "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "conv1D", "w", "dense", "embedding", "texts", "", "seqLength", "", "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "flatten", "startDim", "maxPool1D", "poolSize", "mul", "relu", "softmax", "transpose2D", "transpose3D", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Operator {
    public static final Operator INSTANCE = new Operator();

    private Operator() {
    }

    public static final void addmv(MTensor mTensor, MTensor mTensor2) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(mTensor, "x");
                j.g(mTensor2, NetworkProfile.BISEXUAL);
                int shape = mTensor.getShape(0);
                int shape2 = mTensor.getShape(1);
                int shape3 = mTensor.getShape(2);
                float[] data = mTensor.getData();
                float[] data2 = mTensor2.getData();
                if (shape > 0) {
                    int i10 = 0;
                    while (true) {
                        int i11 = i10 + 1;
                        if (shape2 > 0) {
                            int i12 = 0;
                            while (true) {
                                int i13 = i12 + 1;
                                if (shape3 > 0) {
                                    int i14 = 0;
                                    while (true) {
                                        int i15 = i14 + 1;
                                        int i16 = (i10 * shape2 * shape3) + (i12 * shape3) + i14;
                                        data[i16] = data[i16] + data2[i14];
                                        if (i15 >= shape3) {
                                            break;
                                        }
                                        i14 = i15;
                                    }
                                }
                                if (i13 >= shape2) {
                                    break;
                                }
                                i12 = i13;
                            }
                        }
                        if (i11 < shape) {
                            i10 = i11;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final MTensor concatenate(MTensor[] mTensorArr) {
        int i10;
        MTensor[] mTensorArr2 = mTensorArr;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(mTensorArr2, "tensors");
            int i11 = 0;
            int shape = mTensorArr2[0].getShape(0);
            int length = mTensorArr2.length - 1;
            if (length >= 0) {
                int i12 = 0;
                i10 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    i10 += mTensorArr2[i12].getShape(1);
                    if (i13 > length) {
                        break;
                    }
                    i12 = i13;
                }
            } else {
                i10 = 0;
            }
            MTensor mTensor = new MTensor(new int[]{shape, i10});
            float[] data = mTensor.getData();
            if (shape > 0) {
                int i14 = 0;
                while (true) {
                    int i15 = i14 + 1;
                    int i16 = i14 * i10;
                    int length2 = mTensorArr2.length - 1;
                    if (length2 >= 0) {
                        int i17 = i11;
                        while (true) {
                            int i18 = i17 + 1;
                            float[] data2 = mTensorArr2[i17].getData();
                            int shape2 = mTensorArr2[i17].getShape(1);
                            System.arraycopy(data2, i14 * shape2, data, i16, shape2);
                            i16 += shape2;
                            if (i18 > length2) {
                                break;
                            }
                            i17 = i18;
                        }
                    }
                    if (i15 >= shape) {
                        break;
                    }
                    i14 = i15;
                    i11 = 0;
                }
            }
            return mTensor;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final MTensor conv1D(MTensor mTensor, MTensor mTensor2) {
        Class<Operator> cls;
        MTensor mTensor3;
        Class<Operator> cls2;
        MTensor mTensor4 = mTensor;
        MTensor mTensor5 = mTensor2;
        Class<Operator> cls3 = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls3)) {
            return null;
        }
        try {
            j.g(mTensor4, "x");
            j.g(mTensor5, "w");
            int i10 = 0;
            int shape = mTensor4.getShape(0);
            int shape2 = mTensor4.getShape(1);
            int shape3 = mTensor4.getShape(2);
            int shape4 = mTensor5.getShape(0);
            int i11 = (shape2 - shape4) + 1;
            int shape5 = mTensor5.getShape(2);
            MTensor mTensor6 = new MTensor(new int[]{shape, i11, shape5});
            float[] data = mTensor.getData();
            float[] data2 = mTensor6.getData();
            float[] data3 = mTensor2.getData();
            if (shape <= 0) {
                return mTensor6;
            }
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                if (shape5 > 0) {
                    int i14 = i10;
                    while (true) {
                        int i15 = i14 + 1;
                        if (i11 > 0) {
                            int i16 = 0;
                            while (true) {
                                int i17 = i16 + 1;
                                float f10 = 0.0f;
                                if (shape4 > 0) {
                                    int i18 = 0;
                                    while (true) {
                                        cls2 = cls3;
                                        int i19 = i18 + 1;
                                        if (shape3 > 0) {
                                            int i20 = 0;
                                            while (true) {
                                                mTensor3 = mTensor6;
                                                int i21 = i20 + 1;
                                                try {
                                                    f10 += data[(shape2 * shape3 * i12) + ((i18 + i16) * shape3) + i20] * data3[(((i18 * shape3) + i20) * shape5) + i14];
                                                    if (i21 >= shape3) {
                                                        break;
                                                    }
                                                    i20 = i21;
                                                    mTensor6 = mTensor3;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    cls = cls2;
                                                    CrashShieldHandler.handleThrowable(th, cls);
                                                    return null;
                                                }
                                            }
                                        } else {
                                            mTensor3 = mTensor6;
                                        }
                                        if (i19 >= shape4) {
                                            break;
                                        }
                                        i18 = i19;
                                        cls3 = cls2;
                                        mTensor6 = mTensor3;
                                    }
                                } else {
                                    cls2 = cls3;
                                    mTensor3 = mTensor6;
                                }
                                data2[(i11 * shape5 * i12) + (i16 * shape5) + i14] = f10;
                                if (i17 >= i11) {
                                    break;
                                }
                                i16 = i17;
                                cls3 = cls2;
                                mTensor6 = mTensor3;
                            }
                        } else {
                            cls2 = cls3;
                            mTensor3 = mTensor6;
                        }
                        if (i15 >= shape5) {
                            break;
                        }
                        i14 = i15;
                        cls3 = cls2;
                        mTensor6 = mTensor3;
                    }
                } else {
                    cls2 = cls3;
                    mTensor3 = mTensor6;
                }
                if (i13 >= shape) {
                    return mTensor3;
                }
                i12 = i13;
                cls3 = cls2;
                mTensor6 = mTensor3;
                i10 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            cls = cls3;
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final MTensor dense(MTensor mTensor, MTensor mTensor2, MTensor mTensor3) {
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(mTensor, "x");
            j.g(mTensor2, "w");
            j.g(mTensor3, NetworkProfile.BISEXUAL);
            int shape = mTensor.getShape(0);
            int shape2 = mTensor3.getShape(0);
            MTensor mul = mul(mTensor, mTensor2);
            float[] data = mTensor3.getData();
            float[] data2 = mul.getData();
            if (shape > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (shape2 > 0) {
                        int i12 = 0;
                        while (true) {
                            int i13 = i12 + 1;
                            int i14 = (i10 * shape2) + i12;
                            data2[i14] = data2[i14] + data[i12];
                            if (i13 >= shape2) {
                                break;
                            }
                            i12 = i13;
                        }
                    }
                    if (i11 >= shape) {
                        break;
                    }
                    i10 = i11;
                }
            }
            return mul;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final MTensor embedding(String[] strArr, int i10, MTensor mTensor) {
        String[] strArr2 = strArr;
        int i11 = i10;
        MTensor mTensor2 = mTensor;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(strArr2, "texts");
            j.g(mTensor2, "w");
            int length = strArr2.length;
            int shape = mTensor2.getShape(1);
            MTensor mTensor3 = new MTensor(new int[]{length, i11, shape});
            float[] data = mTensor3.getData();
            float[] data2 = mTensor.getData();
            if (length > 0) {
                int i12 = 0;
                while (true) {
                    int i13 = i12 + 1;
                    int[] vectorize = Utils.INSTANCE.vectorize(strArr2[i12], i11);
                    if (i11 > 0) {
                        int i14 = 0;
                        while (true) {
                            int i15 = i14 + 1;
                            System.arraycopy(data2, vectorize[i14] * shape, data, (shape * i11 * i12) + (i14 * shape), shape);
                            if (i15 >= i11) {
                                break;
                            }
                            i14 = i15;
                        }
                    }
                    if (i13 >= length) {
                        break;
                    }
                    i12 = i13;
                }
            }
            return mTensor3;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final void flatten(MTensor mTensor, int i10) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(mTensor, "x");
                if (i10 < mTensor.getShapeSize()) {
                    int shapeSize = mTensor.getShapeSize();
                    int i11 = 1;
                    if (i10 < shapeSize) {
                        int i12 = i10;
                        while (true) {
                            int i13 = i12 + 1;
                            i11 *= mTensor.getShape(i12);
                            if (i13 >= shapeSize) {
                                break;
                            }
                            i12 = i13;
                        }
                    }
                    int[] iArr = new int[(i10 + 1)];
                    int i14 = 0;
                    if (i10 > 0) {
                        while (true) {
                            int i15 = i14 + 1;
                            iArr[i14] = mTensor.getShape(i14);
                            if (i15 >= i10) {
                                break;
                            }
                            i14 = i15;
                        }
                    }
                    iArr[i10] = i11;
                    mTensor.reshape(iArr);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final MTensor maxPool1D(MTensor mTensor, int i10) {
        int i11;
        MTensor mTensor2 = mTensor;
        int i12 = i10;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(mTensor2, "x");
            int i13 = 0;
            int shape = mTensor2.getShape(0);
            int shape2 = mTensor2.getShape(1);
            int shape3 = mTensor2.getShape(2);
            int i14 = (shape2 - i12) + 1;
            MTensor mTensor3 = new MTensor(new int[]{shape, i14, shape3});
            float[] data = mTensor.getData();
            float[] data2 = mTensor3.getData();
            if (shape > 0) {
                int i15 = 0;
                while (true) {
                    int i16 = i15 + 1;
                    if (shape3 > 0) {
                        int i17 = i13;
                        while (true) {
                            int i18 = i17 + 1;
                            if (i14 > 0) {
                                int i19 = i13;
                                while (true) {
                                    int i20 = i19 + 1;
                                    int i21 = i19 * shape3;
                                    int i22 = (i15 * i14 * shape3) + i21 + i17;
                                    int i23 = (i15 * shape2 * shape3) + i21 + i17;
                                    data2[i22] = Float.MIN_VALUE;
                                    if (i12 > 0) {
                                        int i24 = 0;
                                        while (true) {
                                            int i25 = i24 + 1;
                                            i11 = shape2;
                                            data2[i22] = Math.max(data2[i22], data[i23 + (i24 * shape3)]);
                                            if (i25 >= i12) {
                                                break;
                                            }
                                            i24 = i25;
                                            shape2 = i11;
                                        }
                                    } else {
                                        i11 = shape2;
                                    }
                                    if (i20 >= i14) {
                                        break;
                                    }
                                    i19 = i20;
                                    shape2 = i11;
                                }
                            } else {
                                i11 = shape2;
                            }
                            if (i18 >= shape3) {
                                break;
                            }
                            i17 = i18;
                            shape2 = i11;
                            i13 = 0;
                        }
                    } else {
                        i11 = shape2;
                    }
                    if (i16 >= shape) {
                        break;
                    }
                    i15 = i16;
                    shape2 = i11;
                    i13 = 0;
                }
            }
            return mTensor3;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final MTensor mul(MTensor mTensor, MTensor mTensor2) {
        MTensor mTensor3 = mTensor;
        MTensor mTensor4 = mTensor2;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(mTensor3, "x");
            j.g(mTensor4, "w");
            int i10 = 0;
            int shape = mTensor3.getShape(0);
            int shape2 = mTensor4.getShape(0);
            int shape3 = mTensor4.getShape(1);
            MTensor mTensor5 = new MTensor(new int[]{shape, shape3});
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            float[] data3 = mTensor5.getData();
            if (shape > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    if (shape3 > 0) {
                        int i13 = i10;
                        while (true) {
                            int i14 = i13 + 1;
                            int i15 = (i11 * shape3) + i13;
                            data3[i15] = 0.0f;
                            if (shape2 > 0) {
                                int i16 = i10;
                                while (true) {
                                    int i17 = i16 + 1;
                                    data3[i15] = data3[i15] + (data[(i11 * shape2) + i16] * data2[(i16 * shape3) + i13]);
                                    if (i17 >= shape2) {
                                        break;
                                    }
                                    i16 = i17;
                                }
                            }
                            if (i14 >= shape3) {
                                break;
                            }
                            i13 = i14;
                            i10 = 0;
                        }
                    }
                    if (i12 >= shape) {
                        break;
                    }
                    i11 = i12;
                    i10 = 0;
                }
            }
            return mTensor5;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final void relu(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(mTensor, "x");
                float[] data = mTensor.getData();
                int i10 = 0;
                int length = data.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i11 = i10 + 1;
                        if (data[i10] < 0.0f) {
                            data[i10] = 0.0f;
                        }
                        if (i11 <= length) {
                            i10 = i11;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final void softmax(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                j.g(mTensor, "x");
                int i10 = 0;
                int shape = mTensor.getShape(0);
                int shape2 = mTensor.getShape(1);
                float[] data = mTensor.getData();
                if (shape > 0) {
                    while (true) {
                        int i11 = i10 + 1;
                        int i12 = i10 * shape2;
                        int i13 = i12 + shape2;
                        float f10 = Float.MIN_VALUE;
                        float f11 = 0.0f;
                        if (i12 < i13) {
                            int i14 = i12;
                            while (true) {
                                int i15 = i14 + 1;
                                float f12 = data[i14];
                                if (f12 > f10) {
                                    f10 = f12;
                                }
                                if (i15 >= i13) {
                                    break;
                                }
                                i14 = i15;
                            }
                        }
                        if (i12 < i13) {
                            int i16 = i12;
                            while (true) {
                                int i17 = i16 + 1;
                                float exp = (float) Math.exp((double) (data[i16] - f10));
                                data[i16] = exp;
                                f11 += exp;
                                if (i17 >= i13) {
                                    break;
                                }
                                i16 = i17;
                            }
                        }
                        if (i12 < i13) {
                            while (true) {
                                int i18 = i12 + 1;
                                data[i12] = data[i12] / f11;
                                if (i18 >= i13) {
                                    break;
                                }
                                i12 = i18;
                            }
                        }
                        if (i11 < shape) {
                            i10 = i11;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public static final MTensor transpose2D(MTensor mTensor) {
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(mTensor, "x");
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            MTensor mTensor2 = new MTensor(new int[]{shape2, shape});
            float[] data = mTensor.getData();
            float[] data2 = mTensor2.getData();
            if (shape > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (shape2 > 0) {
                        int i12 = 0;
                        while (true) {
                            int i13 = i12 + 1;
                            data2[(i12 * shape) + i10] = data[(i10 * shape2) + i12];
                            if (i13 >= shape2) {
                                break;
                            }
                            i12 = i13;
                        }
                    }
                    if (i11 >= shape) {
                        break;
                    }
                    i10 = i11;
                }
            }
            return mTensor2;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final MTensor transpose3D(MTensor mTensor) {
        MTensor mTensor2 = mTensor;
        Class<Operator> cls = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(mTensor2, "x");
            int shape = mTensor2.getShape(0);
            int shape2 = mTensor2.getShape(1);
            int shape3 = mTensor2.getShape(2);
            MTensor mTensor3 = new MTensor(new int[]{shape3, shape2, shape});
            float[] data = mTensor.getData();
            float[] data2 = mTensor3.getData();
            if (shape > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (shape2 > 0) {
                        int i12 = 0;
                        while (true) {
                            int i13 = i12 + 1;
                            if (shape3 > 0) {
                                int i14 = 0;
                                while (true) {
                                    int i15 = i14 + 1;
                                    data2[(i14 * shape * shape2) + (i12 * shape) + i10] = data[(i10 * shape2 * shape3) + (i12 * shape3) + i14];
                                    if (i15 >= shape3) {
                                        break;
                                    }
                                    i14 = i15;
                                }
                            }
                            if (i13 >= shape2) {
                                break;
                            }
                            i12 = i13;
                        }
                    }
                    if (i11 >= shape) {
                        break;
                    }
                    i10 = i11;
                }
            }
            return mTensor3;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }
}
