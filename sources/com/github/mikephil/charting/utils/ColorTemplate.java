package com.github.mikephil.charting.utils;

import android.content.res.Resources;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

public class ColorTemplate {
    public static final int[] COLORFUL_COLORS = {Color.rgb(Opcodes.INSTANCEOF, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, Opcodes.IFNONNULL, 0), Color.rgb(106, Opcodes.FCMPG, 31), Color.rgb(Opcodes.PUTSTATIC, 100, 53)};
    public static final int COLOR_NONE = -1;
    public static final int COLOR_SKIP = -2;
    public static final int[] JOYFUL_COLORS = {Color.rgb(217, 80, Opcodes.L2D), Color.rgb(254, Opcodes.FCMPL, 7), Color.rgb(254, 247, 120), Color.rgb(106, Opcodes.GOTO, 134), Color.rgb(53, Opcodes.MONITORENTER, 209)};
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, 248, 246), Color.rgb(Opcodes.LCMP, 212, 212), Color.rgb(136, Opcodes.GETFIELD, Opcodes.NEW), Color.rgb(118, Opcodes.FRETURN, Opcodes.DRETURN), Color.rgb(42, 109, Opcodes.IXOR)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(Opcodes.FCMPL, Opcodes.IF_ACMPEQ, 124), Color.rgb(217, Opcodes.INVOKESTATIC, Opcodes.IF_ICMPGE), Color.rgb(Opcodes.ATHROW, 134, 134), Color.rgb(Opcodes.PUTSTATIC, 48, 80)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(192, 255, Opcodes.F2L), Color.rgb(255, 247, Opcodes.F2L), Color.rgb(255, 208, Opcodes.F2L), Color.rgb(Opcodes.F2L, 234, 255), Color.rgb(255, Opcodes.F2L, Opcodes.IFGT)};

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int color : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(color)));
        }
        return arrayList;
    }

    public static int getHoloBlue() {
        return Color.rgb(51, Opcodes.PUTFIELD, 229);
    }

    public static int rgb(String str) {
        int parseLong = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, (parseLong >> 0) & 255);
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }
}
