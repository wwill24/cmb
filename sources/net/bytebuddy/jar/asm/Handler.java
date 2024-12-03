package net.bytebuddy.jar.asm;

import com.google.android.gms.common.api.a;

final class Handler {
    final int catchType;
    final String catchTypeDescriptor;
    final Label endPc;
    final Label handlerPc;
    Handler nextHandler;
    final Label startPc;

    Handler(Label label, Label label2, Label label3, int i10, String str) {
        this.startPc = label;
        this.endPc = label2;
        this.handlerPc = label3;
        this.catchType = i10;
        this.catchTypeDescriptor = str;
    }

    static int getExceptionTableLength(Handler handler) {
        int i10 = 0;
        while (handler != null) {
            i10++;
            handler = handler.nextHandler;
        }
        return i10;
    }

    static int getExceptionTableSize(Handler handler) {
        return (getExceptionTableLength(handler) * 8) + 2;
    }

    static void putExceptionTable(Handler handler, ByteVector byteVector) {
        byteVector.putShort(getExceptionTableLength(handler));
        while (handler != null) {
            byteVector.putShort(handler.startPc.bytecodeOffset).putShort(handler.endPc.bytecodeOffset).putShort(handler.handlerPc.bytecodeOffset).putShort(handler.catchType);
            handler = handler.nextHandler;
        }
    }

    static Handler removeRange(Handler handler, Label label, Label label2) {
        int i10;
        if (handler == null) {
            return null;
        }
        Handler removeRange = removeRange(handler.nextHandler, label, label2);
        handler.nextHandler = removeRange;
        Label label3 = handler.startPc;
        int i11 = label3.bytecodeOffset;
        Label label4 = handler.endPc;
        int i12 = label4.bytecodeOffset;
        int i13 = label.bytecodeOffset;
        if (label2 == null) {
            i10 = a.e.API_PRIORITY_OTHER;
        } else {
            i10 = label2.bytecodeOffset;
        }
        if (i13 >= i12 || i10 <= i11) {
            return handler;
        }
        if (i13 <= i11) {
            if (i10 >= i12) {
                return removeRange;
            }
            return new Handler(handler, label2, label4);
        } else if (i10 >= i12) {
            return new Handler(handler, label3, label);
        } else {
            handler.nextHandler = new Handler(handler, label2, label4);
            return new Handler(handler, handler.startPc, label);
        }
    }

    Handler(Handler handler, Label label, Label label2) {
        this(label, label2, handler.handlerPc, handler.catchType, handler.catchTypeDescriptor);
        this.nextHandler = handler.nextHandler;
    }
}
