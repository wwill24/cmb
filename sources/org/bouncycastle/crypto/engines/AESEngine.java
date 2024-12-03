package org.bouncycastle.crypto.engines;

import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.lang.reflect.Array;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class AESEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, Framer.STDOUT_FRAME_PREFIX, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, Framer.ENTER_FRAME_PREFIX, Tnaf.POW_2_WIDTH, -1, -13, -46, -51, 12, 19, -20, Framer.STDIN_REQUEST_FRAME_PREFIX, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, Framer.STDERR_FRAME_PREFIX, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, Framer.EXIT_FRAME_PREFIX, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, Framer.STDIN_FRAME_PREFIX, 15, -80, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, Framer.STDERR_FRAME_PREFIX, -90, -62, 35, 61, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, Framer.EXIT_FRAME_PREFIX, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, Framer.STDOUT_FRAME_PREFIX, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, Byte.MIN_VALUE, -20, Framer.STDIN_REQUEST_FRAME_PREFIX, 96, 81, Byte.MAX_VALUE, -87, 25, -75, 74, 13, Framer.STDIN_FRAME_PREFIX, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, Framer.ENTER_FRAME_PREFIX, 12, 125};
    private static final int[] T0 = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};
    private static final int[] Tinv0 = {1353184337, 1399144830, -1012656358, -1772214470, -882136261, -247096033, -1420232020, -1828461749, 1442459680, -160598355, -1854485368, 625738485, -52959921, -674551099, -2143013594, -1885117771, 1230680542, 1729870373, -1743852987, -507445667, 41234371, 317738113, -1550367091, -956705941, -413167869, -1784901099, -344298049, -631680363, 763608788, -752782248, 694804553, 1154009486, 1787413109, 2021232372, 1799248025, -579749593, -1236278850, 397248752, 1722556617, -1271214467, 407560035, -2110711067, 1613975959, 1165972322, -529046351, -2068943941, 480281086, -1809118983, 1483229296, 436028815, -2022908268, -1208452270, 601060267, -503166094, 1468997603, 715871590, 120122290, 63092015, -1703164538, -1526188077, -226023376, -1297760477, -1167457534, 1552029421, 723308426, -1833666137, -252573709, -1578997426, -839591323, -708967162, 526529745, -1963022652, -1655493068, -1604979806, 853641733, 1978398372, 971801355, -1427152832, 111112542, 1360031421, -108388034, 1023860118, -1375387939, 1186850381, -1249028975, 90031217, 1876166148, -15380384, 620468249, -1746289194, -868007799, 2006899047, -1119688528, -2004121337, 945494503, -605108103, 1191869601, -384875908, -920746760, 0, -2088337399, 1223502642, -1401941730, 1316117100, -67170563, 1446544655, 517320253, 658058550, 1691946762, 564550760, -783000677, 976107044, -1318647284, 266819475, -761860428, -1634624741, 1338359936, -1574904735, 1766553434, 370807324, 179999714, -450191168, 1138762300, 488053522, 185403662, -1379431438, -1180125651, -928440812, -2061897385, 1275557295, -1143105042, -44007517, -1624899081, -1124765092, -985962940, 880737115, 1982415755, -590994485, 1761406390, 1676797112, -891538985, 277177154, 1076008723, 538035844, 2099530373, -130171950, 288553390, 1839278535, 1261411869, -214912292, -330136051, -790380169, 1813426987, -1715900247, -95906799, 577038663, -997393240, 440397984, -668172970, -275762398, -951170681, -1043253031, -22885748, 906744984, -813566554, 685669029, 646887386, -1530942145, -459458004, 227702864, -1681105046, 1648787028, -1038905866, -390539120, 1593260334, -173030526, -1098883681, 2090061929, -1456614033, -1290656305, 999926984, -1484974064, 1852021992, 2075868123, 158869197, -199730834, 28809964, -1466282109, 1701746150, 2129067946, 147831841, -420997649, -644094022, -835293366, -737566742, -696471511, -1347247055, 824393514, 815048134, -1067015627, 935087732, -1496677636, -1328508704, 366520115, 1251476721, -136647615, 240176511, 804688151, -1915335306, 1303441219, 1414376140, -553347356, -474623586, 461924940, -1205916479, 2136040774, 82468509, 1563790337, 1937016826, 776014843, 1511876531, 1389550482, 861278441, 323475053, -1939744870, 2047648055, -1911228327, -1992551445, -299390514, 902390199, -303751967, 1018251130, 1507840668, 1064563285, 2043548696, -1086863501, -355600557, 1537932639, 342834655, -2032450440, -2114736182, 1053059257, 741614648, 1598071746, 1925389590, 203809468, -1958134744, 1100287487, 1895934009, -558691320, -1662733096, -1866377628, 1636092795, 1890988757, 1952214088, 1113045200};

    /* renamed from: m1  reason: collision with root package name */
    private static final int f41402m1 = -2139062144;

    /* renamed from: m2  reason: collision with root package name */
    private static final int f41403m2 = 2139062143;

    /* renamed from: m3  reason: collision with root package name */
    private static final int f41404m3 = 27;

    /* renamed from: m4  reason: collision with root package name */
    private static final int f41405m4 = -1061109568;

    /* renamed from: m5  reason: collision with root package name */
    private static final int f41406m5 = 1061109567;
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, Opcodes.LOOKUPSWITCH, 77, Opcodes.IFNE, 47, 94, 188, 99, Opcodes.IFNULL, Opcodes.DCMPL, 53, 106, 212, Opcodes.PUTSTATIC, 125, MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT, 239, Opcodes.MULTIANEWARRAY, Opcodes.I2B};
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    /* renamed from: s  reason: collision with root package name */
    private byte[] f41407s;

    private static int FFmulX(int i10) {
        return (((i10 & f41402m1) >>> 7) * 27) ^ ((f41403m2 & i10) << 1);
    }

    private static int FFmulX2(int i10) {
        int i11 = i10 & f41405m4;
        int i12 = i11 ^ (i11 >>> 1);
        return (i12 >>> 5) ^ (((f41406m5 & i10) << 2) ^ (i12 >>> 2));
    }

    private void decryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11, int[][] iArr) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int littleEndianToInt = Pack.littleEndianToInt(bArr3, i10 + 0);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr3, i10 + 4);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr3, i10 + 8);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr3, i10 + 12);
        int i12 = this.ROUNDS;
        int[] iArr2 = iArr[i12];
        char c10 = 0;
        int i13 = littleEndianToInt ^ iArr2[0];
        int i14 = littleEndianToInt2 ^ iArr2[1];
        int i15 = littleEndianToInt3 ^ iArr2[2];
        int i16 = i12 - 1;
        int i17 = littleEndianToInt4 ^ iArr2[3];
        for (int i18 = 1; i16 > i18; i18 = 1) {
            int[] iArr3 = Tinv0;
            int shift = (((shift(iArr3[(i17 >> 8) & 255], 24) ^ iArr3[i13 & 255]) ^ shift(iArr3[(i15 >> 16) & 255], 16)) ^ shift(iArr3[(i14 >> 24) & 255], 8)) ^ iArr[i16][c10];
            int shift2 = (((shift(iArr3[(i13 >> 8) & 255], 24) ^ iArr3[i14 & 255]) ^ shift(iArr3[(i17 >> 16) & 255], 16)) ^ shift(iArr3[(i15 >> 24) & 255], 8)) ^ iArr[i16][i18];
            int shift3 = (((shift(iArr3[(i14 >> 8) & 255], 24) ^ iArr3[i15 & 255]) ^ shift(iArr3[(i13 >> 16) & 255], 16)) ^ shift(iArr3[(i17 >> 24) & 255], 8)) ^ iArr[i16][2];
            int shift4 = ((iArr3[i17 & 255] ^ shift(iArr3[(i15 >> 8) & 255], 24)) ^ shift(iArr3[(i14 >> 16) & 255], 16)) ^ shift(iArr3[(i13 >> 24) & 255], 8);
            int i19 = i16 - 1;
            int i20 = shift4 ^ iArr[i16][3];
            int shift5 = (((iArr3[shift & 255] ^ shift(iArr3[(i20 >> 8) & 255], 24)) ^ shift(iArr3[(shift3 >> 16) & 255], 16)) ^ shift(iArr3[(shift2 >> 24) & 255], 8)) ^ iArr[i19][0];
            int shift6 = (((iArr3[shift2 & 255] ^ shift(iArr3[(shift >> 8) & 255], 24)) ^ shift(iArr3[(i20 >> 16) & 255], 16)) ^ shift(iArr3[(shift3 >> 24) & 255], 8)) ^ iArr[i19][1];
            int i21 = i19 - 1;
            i17 = (((iArr3[i20 & 255] ^ shift(iArr3[(shift3 >> 8) & 255], 24)) ^ shift(iArr3[(shift2 >> 16) & 255], 16)) ^ shift(iArr3[(shift >> 24) & 255], 8)) ^ iArr[i19][3];
            i13 = shift5;
            i14 = shift6;
            i15 = (((iArr3[shift3 & 255] ^ shift(iArr3[(shift2 >> 8) & 255], 24)) ^ shift(iArr3[(shift >> 16) & 255], 16)) ^ shift(iArr3[(i20 >> 24) & 255], 8)) ^ iArr[i19][2];
            i16 = i21;
            c10 = 0;
        }
        int[] iArr4 = Tinv0;
        int shift7 = (((iArr4[i13 & 255] ^ shift(iArr4[(i17 >> 8) & 255], 24)) ^ shift(iArr4[(i15 >> 16) & 255], 16)) ^ shift(iArr4[(i14 >> 24) & 255], 8)) ^ iArr[i16][0];
        int shift8 = (((iArr4[i14 & 255] ^ shift(iArr4[(i13 >> 8) & 255], 24)) ^ shift(iArr4[(i17 >> 16) & 255], 16)) ^ shift(iArr4[(i15 >> 24) & 255], 8)) ^ iArr[i16][1];
        int shift9 = (((iArr4[i15 & 255] ^ shift(iArr4[(i14 >> 8) & 255], 24)) ^ shift(iArr4[(i13 >> 16) & 255], 16)) ^ shift(iArr4[(i17 >> 24) & 255], 8)) ^ iArr[i16][2];
        int shift10 = (((iArr4[i17 & 255] ^ shift(iArr4[(i15 >> 8) & 255], 24)) ^ shift(iArr4[(i14 >> 16) & 255], 16)) ^ shift(iArr4[(i13 >> 24) & 255], 8)) ^ iArr[i16][3];
        byte[] bArr5 = Si;
        byte[] bArr6 = this.f41407s;
        int[] iArr5 = iArr[0];
        byte b10 = ((((bArr5[shift7 & 255] & 255) ^ ((bArr6[(shift10 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(shift9 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(shift8 >> 24) & 255] << 24)) ^ iArr5[0];
        byte b11 = ((((bArr6[shift8 & 255] & 255) ^ ((bArr6[(shift7 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(shift10 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(shift9 >> 24) & 255] << 24)) ^ iArr5[1];
        int i22 = (bArr5[(shift8 >> 8) & 255] & 255) << 8;
        byte b12 = ((((bArr5[shift10 & 255] & 255) ^ ((bArr6[(shift9 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(shift8 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(shift7 >> 24) & 255] << 24)) ^ iArr5[3];
        Pack.intToLittleEndian((int) b10, bArr4, i11 + 0);
        Pack.intToLittleEndian((int) b11, bArr4, i11 + 4);
        Pack.intToLittleEndian((int) (((i22 ^ (bArr6[shift9 & 255] & 255)) ^ ((bArr5[(shift7 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(shift10 >> 24) & 255] << 24)) ^ iArr5[2], bArr4, i11 + 8);
        Pack.intToLittleEndian((int) b12, bArr4, i11 + 12);
    }

    private void encryptBlock(byte[] bArr, int i10, byte[] bArr2, int i11, int[][] iArr) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int littleEndianToInt = Pack.littleEndianToInt(bArr3, i10 + 0);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr3, i10 + 4);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr3, i10 + 8);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr3, i10 + 12);
        char c10 = 0;
        int[] iArr2 = iArr[0];
        int i12 = littleEndianToInt ^ iArr2[0];
        int i13 = 1;
        int i14 = littleEndianToInt2 ^ iArr2[1];
        int i15 = littleEndianToInt3 ^ iArr2[2];
        int i16 = littleEndianToInt4 ^ iArr2[3];
        int i17 = 1;
        while (i17 < this.ROUNDS - i13) {
            int[] iArr3 = T0;
            int shift = (((shift(iArr3[(i14 >> 8) & 255], 24) ^ iArr3[i12 & 255]) ^ shift(iArr3[(i15 >> 16) & 255], 16)) ^ shift(iArr3[(i16 >> 24) & 255], 8)) ^ iArr[i17][c10];
            int shift2 = (((shift(iArr3[(i15 >> 8) & 255], 24) ^ iArr3[i14 & 255]) ^ shift(iArr3[(i16 >> 16) & 255], 16)) ^ shift(iArr3[(i12 >> 24) & 255], 8)) ^ iArr[i17][i13];
            int shift3 = (((shift(iArr3[(i16 >> 8) & 255], 24) ^ iArr3[i15 & 255]) ^ shift(iArr3[(i12 >> 16) & 255], 16)) ^ shift(iArr3[(i14 >> 24) & 255], 8)) ^ iArr[i17][2];
            int shift4 = ((iArr3[i16 & 255] ^ shift(iArr3[(i12 >> 8) & 255], 24)) ^ shift(iArr3[(i14 >> 16) & 255], 16)) ^ shift(iArr3[(i15 >> 24) & 255], 8);
            int i18 = i17 + 1;
            int i19 = shift4 ^ iArr[i17][3];
            int shift5 = (((iArr3[shift & 255] ^ shift(iArr3[(shift2 >> 8) & 255], 24)) ^ shift(iArr3[(shift3 >> 16) & 255], 16)) ^ shift(iArr3[(i19 >> 24) & 255], 8)) ^ iArr[i18][0];
            int shift6 = (((iArr3[shift2 & 255] ^ shift(iArr3[(shift3 >> 8) & 255], 24)) ^ shift(iArr3[(i19 >> 16) & 255], 16)) ^ shift(iArr3[(shift >> 24) & 255], 8)) ^ iArr[i18][1];
            int shift7 = ((iArr3[i19 & 255] ^ shift(iArr3[(shift >> 8) & 255], 24)) ^ shift(iArr3[(shift2 >> 16) & 255], 16)) ^ shift(iArr3[(shift3 >> 24) & 255], 8);
            int i20 = i18 + 1;
            i16 = shift7 ^ iArr[i18][3];
            i12 = shift5;
            i14 = shift6;
            i15 = (((iArr3[shift3 & 255] ^ shift(iArr3[(i19 >> 8) & 255], 24)) ^ shift(iArr3[(shift >> 16) & 255], 16)) ^ shift(iArr3[(shift2 >> 24) & 255], 8)) ^ iArr[i18][2];
            i13 = 1;
            i17 = i20;
            c10 = 0;
        }
        int[] iArr4 = T0;
        int shift8 = (((iArr4[i12 & 255] ^ shift(iArr4[(i14 >> 8) & 255], 24)) ^ shift(iArr4[(i15 >> 16) & 255], 16)) ^ shift(iArr4[(i16 >> 24) & 255], 8)) ^ iArr[i17][0];
        int shift9 = (((iArr4[i14 & 255] ^ shift(iArr4[(i15 >> 8) & 255], 24)) ^ shift(iArr4[(i16 >> 16) & 255], 16)) ^ shift(iArr4[(i12 >> 24) & 255], 8)) ^ iArr[i17][1];
        int shift10 = (((iArr4[i15 & 255] ^ shift(iArr4[(i16 >> 8) & 255], 24)) ^ shift(iArr4[(i12 >> 16) & 255], 16)) ^ shift(iArr4[(i14 >> 24) & 255], 8)) ^ iArr[i17][2];
        int shift11 = (((iArr4[i16 & 255] ^ shift(iArr4[(i12 >> 8) & 255], 24)) ^ shift(iArr4[(i14 >> 16) & 255], 16)) ^ shift(iArr4[(i15 >> 24) & 255], 8)) ^ iArr[i17][3];
        byte[] bArr5 = S;
        byte b10 = (bArr5[shift8 & 255] & 255) ^ ((bArr5[(shift9 >> 8) & 255] & 255) << 8);
        byte[] bArr6 = this.f41407s;
        int[] iArr5 = iArr[i17 + 1];
        byte b11 = ((b10 ^ ((bArr6[(shift10 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(shift11 >> 24) & 255] << 24)) ^ iArr5[0];
        byte b12 = ((((bArr6[shift9 & 255] & 255) ^ ((bArr5[(shift10 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(shift11 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr6[(shift8 >> 24) & 255] << 24)) ^ iArr5[1];
        int i21 = (bArr5[(shift11 >> 8) & 255] & 255) << 8;
        byte b13 = ((((bArr6[shift11 & 255] & 255) ^ ((bArr6[(shift8 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(shift9 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(shift10 >> 24) & 255] << 24)) ^ iArr5[3];
        Pack.intToLittleEndian((int) b11, bArr4, i11 + 0);
        Pack.intToLittleEndian((int) b12, bArr4, i11 + 4);
        Pack.intToLittleEndian((int) (((i21 ^ (bArr6[shift10 & 255] & 255)) ^ ((bArr5[(shift8 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH)) ^ (bArr5[(shift9 >> 24) & 255] << 24)) ^ iArr5[2], bArr4, i11 + 8);
        Pack.intToLittleEndian((int) b13, bArr4, i11 + 12);
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z10) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i10 = length >>> 2;
        int i11 = i10 + 6;
        this.ROUNDS = i11;
        int[] iArr = new int[2];
        iArr[1] = 4;
        iArr[0] = i11 + 1;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i12 = 8;
        char c10 = 3;
        if (i10 == 4) {
            int littleEndianToInt = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt;
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt2;
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt3;
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt4;
            for (int i13 = 1; i13 <= 10; i13++) {
                littleEndianToInt ^= subWord(shift(littleEndianToInt4, 8)) ^ rcon[i13 - 1];
                int[] iArr3 = iArr2[i13];
                iArr3[0] = littleEndianToInt;
                littleEndianToInt2 ^= littleEndianToInt;
                iArr3[1] = littleEndianToInt2;
                littleEndianToInt3 ^= littleEndianToInt2;
                iArr3[2] = littleEndianToInt3;
                littleEndianToInt4 ^= littleEndianToInt3;
                iArr3[3] = littleEndianToInt4;
            }
        } else if (i10 == 6) {
            int littleEndianToInt5 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt5;
            int littleEndianToInt6 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt6;
            int littleEndianToInt7 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt7;
            int littleEndianToInt8 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt8;
            int littleEndianToInt9 = Pack.littleEndianToInt(bArr2, 16);
            int littleEndianToInt10 = Pack.littleEndianToInt(bArr2, 20);
            int i14 = 1;
            int i15 = 1;
            while (true) {
                int[] iArr4 = iArr2[i14];
                iArr4[0] = littleEndianToInt9;
                iArr4[1] = littleEndianToInt10;
                int subWord = subWord(shift(littleEndianToInt10, 8)) ^ i15;
                int i16 = i15 << 1;
                int i17 = littleEndianToInt5 ^ subWord;
                int[] iArr5 = iArr2[i14];
                iArr5[2] = i17;
                int i18 = littleEndianToInt6 ^ i17;
                iArr5[3] = i18;
                int i19 = littleEndianToInt7 ^ i18;
                int[] iArr6 = iArr2[i14 + 1];
                iArr6[0] = i19;
                int i20 = littleEndianToInt8 ^ i19;
                iArr6[1] = i20;
                int i21 = littleEndianToInt9 ^ i20;
                iArr6[2] = i21;
                int i22 = littleEndianToInt10 ^ i21;
                iArr6[3] = i22;
                int subWord2 = subWord(shift(i22, 8)) ^ i16;
                i15 = i16 << 1;
                littleEndianToInt5 = i17 ^ subWord2;
                int[] iArr7 = iArr2[i14 + 2];
                iArr7[0] = littleEndianToInt5;
                littleEndianToInt6 = i18 ^ littleEndianToInt5;
                iArr7[1] = littleEndianToInt6;
                littleEndianToInt7 = i19 ^ littleEndianToInt6;
                iArr7[2] = littleEndianToInt7;
                littleEndianToInt8 = i20 ^ littleEndianToInt7;
                iArr7[3] = littleEndianToInt8;
                i14 += 3;
                if (i14 >= 13) {
                    break;
                }
                littleEndianToInt9 = i21 ^ littleEndianToInt8;
                littleEndianToInt10 = i22 ^ littleEndianToInt9;
            }
        } else if (i10 == 8) {
            int littleEndianToInt11 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt11;
            int littleEndianToInt12 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt12;
            int littleEndianToInt13 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt13;
            int littleEndianToInt14 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt14;
            int littleEndianToInt15 = Pack.littleEndianToInt(bArr2, 16);
            iArr2[1][0] = littleEndianToInt15;
            int littleEndianToInt16 = Pack.littleEndianToInt(bArr2, 20);
            iArr2[1][1] = littleEndianToInt16;
            int littleEndianToInt17 = Pack.littleEndianToInt(bArr2, 24);
            iArr2[1][2] = littleEndianToInt17;
            int littleEndianToInt18 = Pack.littleEndianToInt(bArr2, 28);
            iArr2[1][3] = littleEndianToInt18;
            int i23 = 2;
            int i24 = 1;
            while (true) {
                int subWord3 = subWord(shift(littleEndianToInt18, i12)) ^ i24;
                i24 <<= 1;
                littleEndianToInt11 ^= subWord3;
                int[] iArr8 = iArr2[i23];
                iArr8[0] = littleEndianToInt11;
                littleEndianToInt12 ^= littleEndianToInt11;
                iArr8[1] = littleEndianToInt12;
                littleEndianToInt13 ^= littleEndianToInt12;
                iArr8[2] = littleEndianToInt13;
                littleEndianToInt14 ^= littleEndianToInt13;
                iArr8[c10] = littleEndianToInt14;
                int i25 = i23 + 1;
                if (i25 >= 15) {
                    break;
                }
                littleEndianToInt15 ^= subWord(littleEndianToInt14);
                int[] iArr9 = iArr2[i25];
                iArr9[0] = littleEndianToInt15;
                littleEndianToInt16 ^= littleEndianToInt15;
                iArr9[1] = littleEndianToInt16;
                littleEndianToInt17 ^= littleEndianToInt16;
                iArr9[2] = littleEndianToInt17;
                littleEndianToInt18 ^= littleEndianToInt17;
                iArr9[3] = littleEndianToInt18;
                i23 = i25 + 1;
                i12 = 8;
                c10 = 3;
            }
        } else {
            throw new IllegalStateException("Should never get here");
        }
        if (!z10) {
            for (int i26 = 1; i26 < this.ROUNDS; i26++) {
                for (int i27 = 0; i27 < 4; i27++) {
                    int[] iArr10 = iArr2[i26];
                    iArr10[i27] = inv_mcol(iArr10[i27]);
                }
            }
        }
        return iArr2;
    }

    private static int inv_mcol(int i10) {
        int shift = shift(i10, 8) ^ i10;
        int FFmulX = i10 ^ FFmulX(shift);
        int FFmulX2 = shift ^ FFmulX2(FFmulX);
        return FFmulX ^ (FFmulX2 ^ shift(FFmulX2, 16));
    }

    private static int shift(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    private static int subWord(int i10) {
        byte[] bArr = S;
        return (bArr[(i10 >> 24) & 255] << 24) | (bArr[i10 & 255] & 255) | ((bArr[(i10 >> 8) & 255] & 255) << 8) | ((bArr[(i10 >> 16) & 255] & 255) << Tnaf.POW_2_WIDTH);
    }

    public String getAlgorithmName() {
        return "AES";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z10);
            this.forEncryption = z10;
            if (z10) {
                this.f41407s = Arrays.clone(S);
            } else {
                this.f41407s = Arrays.clone(Si);
            }
        } else {
            throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
        }
    }

    public int processBlock(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[][] iArr = this.WorkingKey;
        if (iArr == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i10 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i11 <= bArr2.length - 16) {
            if (this.forEncryption) {
                encryptBlock(bArr, i10, bArr2, i11, iArr);
            } else {
                decryptBlock(bArr, i10, bArr2, i11, iArr);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
