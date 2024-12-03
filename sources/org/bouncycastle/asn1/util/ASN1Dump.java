package org.bouncycastle.asn1.util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import org.apache.commons.beanutils.PropertyUtils;
import org.bouncycastle.asn1.ASN1ApplicationSpecific;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1External;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.ASN1UTCTime;
import org.bouncycastle.asn1.BERApplicationSpecific;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERGraphicString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERVideotexString;
import org.bouncycastle.asn1.DERVisibleString;
import org.bouncycastle.asn1.DLApplicationSpecific;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;
    private static final String TAB = "    ";

    static void _dumpAsString(String str, boolean z10, ASN1Primitive aSN1Primitive, StringBuffer stringBuffer) {
        String str2;
        StringBuilder sb2;
        StringBuilder sb3;
        BigInteger value;
        String str3;
        String time;
        StringBuilder sb4;
        int i10;
        String lineSeparator = Strings.lineSeparator();
        if (aSN1Primitive instanceof ASN1Sequence) {
            Enumeration objects = ((ASN1Sequence) aSN1Primitive).getObjects();
            String str4 = str + TAB;
            stringBuffer.append(str);
            stringBuffer.append(aSN1Primitive instanceof BERSequence ? "BER Sequence" : aSN1Primitive instanceof DERSequence ? "DER Sequence" : "Sequence");
            while (true) {
                stringBuffer.append(lineSeparator);
                while (objects.hasMoreElements()) {
                    Object nextElement = objects.nextElement();
                    if (nextElement == null || nextElement.equals(DERNull.INSTANCE)) {
                        stringBuffer.append(str4);
                        stringBuffer.append("NULL");
                    } else {
                        _dumpAsString(str4, z10, nextElement instanceof ASN1Primitive ? (ASN1Primitive) nextElement : ((ASN1Encodable) nextElement).toASN1Primitive(), stringBuffer);
                    }
                }
                return;
            }
        } else if (aSN1Primitive instanceof ASN1TaggedObject) {
            String str5 = str + TAB;
            stringBuffer.append(str);
            stringBuffer.append(aSN1Primitive instanceof BERTaggedObject ? "BER Tagged [" : "Tagged [");
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
            stringBuffer.append(Integer.toString(aSN1TaggedObject.getTagNo()));
            stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
            if (!aSN1TaggedObject.isExplicit()) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(lineSeparator);
            _dumpAsString(str5, z10, aSN1TaggedObject.getObject(), stringBuffer);
        } else if (aSN1Primitive instanceof ASN1Set) {
            Enumeration objects2 = ((ASN1Set) aSN1Primitive).getObjects();
            String str6 = str + TAB;
            stringBuffer.append(str);
            stringBuffer.append(aSN1Primitive instanceof BERSet ? "BER Set" : aSN1Primitive instanceof DERSet ? "DER Set" : "Set");
            while (true) {
                stringBuffer.append(lineSeparator);
                while (objects2.hasMoreElements()) {
                    Object nextElement2 = objects2.nextElement();
                    if (nextElement2 == null) {
                        stringBuffer.append(str6);
                        stringBuffer.append("NULL");
                    } else {
                        _dumpAsString(str6, z10, nextElement2 instanceof ASN1Primitive ? (ASN1Primitive) nextElement2 : ((ASN1Encodable) nextElement2).toASN1Primitive(), stringBuffer);
                    }
                }
                return;
            }
        } else {
            if (aSN1Primitive instanceof ASN1OctetString) {
                ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
                if (aSN1Primitive instanceof BEROctetString) {
                    sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append("BER Constructed Octet String[");
                    i10 = aSN1OctetString.getOctets().length;
                } else {
                    sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append("DER Octet String[");
                    i10 = aSN1OctetString.getOctets().length;
                }
                sb4.append(i10);
                sb4.append("] ");
                stringBuffer.append(sb4.toString());
                if (z10) {
                    str2 = dumpBinaryDataAsString(str, aSN1OctetString.getOctets());
                    stringBuffer.append(str2);
                    return;
                }
            } else {
                if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append("ObjectIdentifier(");
                    sb3.append(((ASN1ObjectIdentifier) aSN1Primitive).getId());
                } else if (aSN1Primitive instanceof ASN1Boolean) {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append("Boolean(");
                    sb3.append(((ASN1Boolean) aSN1Primitive).isTrue());
                } else {
                    if (aSN1Primitive instanceof ASN1Integer) {
                        sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append("Integer(");
                        value = ((ASN1Integer) aSN1Primitive).getValue();
                    } else {
                        if (aSN1Primitive instanceof DERBitString) {
                            DERBitString dERBitString = (DERBitString) aSN1Primitive;
                            stringBuffer.append(str + "DER Bit String[" + dERBitString.getBytes().length + ", " + dERBitString.getPadBits() + "] ");
                            if (z10) {
                                str2 = dumpBinaryDataAsString(str, dERBitString.getBytes());
                            }
                        } else {
                            if (aSN1Primitive instanceof DERIA5String) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("IA5String(");
                                time = ((DERIA5String) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof DERUTF8String) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("UTF8String(");
                                time = ((DERUTF8String) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof DERPrintableString) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("PrintableString(");
                                time = ((DERPrintableString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof DERVisibleString) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("VisibleString(");
                                time = ((DERVisibleString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof DERBMPString) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("BMPString(");
                                time = ((DERBMPString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof DERT61String) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("T61String(");
                                time = ((DERT61String) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof DERGraphicString) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("GraphicString(");
                                time = ((DERGraphicString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof DERVideotexString) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("VideotexString(");
                                time = ((DERVideotexString) aSN1Primitive).getString();
                            } else if (aSN1Primitive instanceof ASN1UTCTime) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("UTCTime(");
                                time = ((ASN1UTCTime) aSN1Primitive).getTime();
                            } else if (aSN1Primitive instanceof ASN1GeneralizedTime) {
                                sb2 = new StringBuilder();
                                sb2.append(str);
                                sb2.append("GeneralizedTime(");
                                time = ((ASN1GeneralizedTime) aSN1Primitive).getTime();
                            } else {
                                if (aSN1Primitive instanceof BERApplicationSpecific) {
                                    str3 = ASN1Encoding.BER;
                                } else if (aSN1Primitive instanceof DERApplicationSpecific) {
                                    str3 = ASN1Encoding.DER;
                                } else if (aSN1Primitive instanceof DLApplicationSpecific) {
                                    str3 = "";
                                } else if (aSN1Primitive instanceof ASN1Enumerated) {
                                    sb3 = new StringBuilder();
                                    sb3.append(str);
                                    sb3.append("DER Enumerated(");
                                    value = ((ASN1Enumerated) aSN1Primitive).getValue();
                                } else if (aSN1Primitive instanceof ASN1External) {
                                    ASN1External aSN1External = (ASN1External) aSN1Primitive;
                                    stringBuffer.append(str + "External " + lineSeparator);
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(str);
                                    sb5.append(TAB);
                                    String sb6 = sb5.toString();
                                    if (aSN1External.getDirectReference() != null) {
                                        stringBuffer.append(sb6 + "Direct Reference: " + aSN1External.getDirectReference().getId() + lineSeparator);
                                    }
                                    if (aSN1External.getIndirectReference() != null) {
                                        stringBuffer.append(sb6 + "Indirect Reference: " + aSN1External.getIndirectReference().toString() + lineSeparator);
                                    }
                                    if (aSN1External.getDataValueDescriptor() != null) {
                                        _dumpAsString(sb6, z10, aSN1External.getDataValueDescriptor(), stringBuffer);
                                    }
                                    stringBuffer.append(sb6 + "Encoding: " + aSN1External.getEncoding() + lineSeparator);
                                    _dumpAsString(sb6, z10, aSN1External.getExternalContent(), stringBuffer);
                                    return;
                                } else {
                                    sb2 = new StringBuilder();
                                    sb2.append(str);
                                    sb2.append(aSN1Primitive.toString());
                                    sb2.append(lineSeparator);
                                    str2 = sb2.toString();
                                }
                                str2 = outputApplicationSpecific(str3, str, z10, aSN1Primitive, lineSeparator);
                            }
                            sb2.append(time);
                            sb2.append(") ");
                            sb2.append(lineSeparator);
                            str2 = sb2.toString();
                        }
                        stringBuffer.append(str2);
                        return;
                    }
                    sb3.append(value);
                }
                sb2.append(")");
                sb2.append(lineSeparator);
                str2 = sb2.toString();
                stringBuffer.append(str2);
                return;
            }
            stringBuffer.append(lineSeparator);
        }
    }

    private static String calculateAscString(byte[] bArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = i10; i12 != i10 + i11; i12++) {
            byte b10 = bArr[i12];
            if (b10 >= 32 && b10 <= 126) {
                stringBuffer.append((char) b10);
            }
        }
        return stringBuffer.toString();
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    public static String dumpAsString(Object obj, boolean z10) {
        ASN1Primitive aSN1Primitive;
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof ASN1Primitive) {
            aSN1Primitive = (ASN1Primitive) obj;
        } else if (obj instanceof ASN1Encodable) {
            aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
        } else {
            return "unknown object type " + obj.toString();
        }
        _dumpAsString("", z10, aSN1Primitive, stringBuffer);
        return stringBuffer.toString();
    }

    private static String dumpBinaryDataAsString(String str, byte[] bArr) {
        String calculateAscString;
        String lineSeparator = Strings.lineSeparator();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + TAB;
        stringBuffer.append(lineSeparator);
        for (int i10 = 0; i10 < bArr.length; i10 += 32) {
            int length = bArr.length - i10;
            stringBuffer.append(str2);
            if (length > 32) {
                stringBuffer.append(Strings.fromByteArray(Hex.encode(bArr, i10, 32)));
                stringBuffer.append(TAB);
                calculateAscString = calculateAscString(bArr, i10, 32);
            } else {
                stringBuffer.append(Strings.fromByteArray(Hex.encode(bArr, i10, bArr.length - i10)));
                for (int length2 = bArr.length - i10; length2 != 32; length2++) {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(TAB);
                calculateAscString = calculateAscString(bArr, i10, bArr.length - i10);
            }
            stringBuffer.append(calculateAscString);
            stringBuffer.append(lineSeparator);
        }
        return stringBuffer.toString();
    }

    private static String outputApplicationSpecific(String str, String str2, boolean z10, ASN1Primitive aSN1Primitive, String str3) {
        ASN1ApplicationSpecific instance = ASN1ApplicationSpecific.getInstance(aSN1Primitive);
        StringBuffer stringBuffer = new StringBuffer();
        if (instance.isConstructed()) {
            try {
                ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObject(16));
                stringBuffer.append(str2 + str + " ApplicationSpecific[" + instance.getApplicationTag() + "]" + str3);
                Enumeration objects = instance2.getObjects();
                while (objects.hasMoreElements()) {
                    _dumpAsString(str2 + TAB, z10, (ASN1Primitive) objects.nextElement(), stringBuffer);
                }
            } catch (IOException e10) {
                stringBuffer.append(e10);
            }
            return stringBuffer.toString();
        }
        return str2 + str + " ApplicationSpecific[" + instance.getApplicationTag() + "] (" + Strings.fromByteArray(Hex.encode(instance.getContents())) + ")" + str3;
    }
}
