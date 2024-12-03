package om;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Character, Inet4Address> f33475a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Character, Inet6Address> f33476b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    protected static final Inet4Address[] f33477c = {c('a', Opcodes.IFNULL, 41, 0, 4), c('b', 192, 228, 79, 201), c('c', 192, 33, 4, 12), c(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, Opcodes.IFNONNULL, 7, 91, 13), c('e', 192, 203, 230, 10), c('f', 192, 5, 5, 241), c('g', 192, 112, 36, 4), c('h', Opcodes.IFNULL, 97, 190, 53), c('i', 192, 36, Opcodes.LCMP, 17), c('j', 192, 58, 128, 30), c('k', Opcodes.INSTANCEOF, 0, 14, 129), c('l', Opcodes.IFNONNULL, 7, 83, 42), c(Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 202, 12, 27, 33)};

    /* renamed from: d  reason: collision with root package name */
    protected static final Inet6Address[] f33478d = {d('a', 8193, 1283, 47678, 0, 0, 0, 2, 48), d('b', 8193, 1280, Opcodes.IINC, 0, 0, 0, 0, 11), d('c', 8193, 1280, 2, 0, 0, 0, 0, 12), d(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 8193, 1280, 45, 0, 0, 0, 0, 13), d('f', 8193, 1280, 47, 0, 0, 0, 0, 15), d('h', 8193, 1280, 1, 0, 0, 0, 0, 83), d('i', 8193, 2046, 0, 0, 0, 0, 0, 83), d('j', 8193, 1283, 3111, 0, 0, 0, 2, 48), d('l', 8193, 1280, 3, 0, 0, 0, 0, 66), d(Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 8193, 3523, 0, 0, 0, 0, 0, 53)};

    public static Inet4Address a(Random random) {
        Inet4Address[] inet4AddressArr = f33477c;
        return inet4AddressArr[random.nextInt(inet4AddressArr.length)];
    }

    public static Inet6Address b(Random random) {
        Inet6Address[] inet6AddressArr = f33478d;
        return inet6AddressArr[random.nextInt(inet6AddressArr.length)];
    }

    private static Inet4Address c(char c10, int i10, int i11, int i12, int i13) {
        try {
            Inet4Address inet4Address = (Inet4Address) InetAddress.getByAddress(c10 + ".root-servers.net", new byte[]{(byte) i10, (byte) i11, (byte) i12, (byte) i13});
            f33475a.put(Character.valueOf(c10), inet4Address);
            return inet4Address;
        } catch (UnknownHostException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static Inet6Address d(char c10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        try {
            Inet6Address inet6Address = (Inet6Address) InetAddress.getByAddress(c10 + ".root-servers.net", new byte[]{(byte) (i10 >> 8), (byte) i10, (byte) (i11 >> 8), (byte) i11, (byte) (i12 >> 8), (byte) i12, (byte) (i13 >> 8), (byte) i13, (byte) (i14 >> 8), (byte) i14, (byte) (i15 >> 8), (byte) i15, (byte) (i16 >> 8), (byte) i16, (byte) (i17 >> 8), (byte) i17});
            f33476b.put(Character.valueOf(c10), inet6Address);
            return inet6Address;
        } catch (UnknownHostException e10) {
            throw new RuntimeException(e10);
        }
    }
}
