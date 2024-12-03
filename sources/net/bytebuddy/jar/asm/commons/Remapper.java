package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.signature.SignatureReader;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class Remapper {
    private Type mapType(Type type) {
        switch (type.getSort()) {
            case 9:
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < type.getDimensions(); i10++) {
                    sb2.append('[');
                }
                sb2.append(mapType(type.getElementType()).getDescriptor());
                return Type.getType(sb2.toString());
            case 10:
                String map = map(type.getInternalName());
                return map != null ? Type.getObjectType(map) : type;
            case 11:
                return Type.getMethodType(mapMethodDesc(type.getDescriptor()));
            default:
                return type;
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public SignatureVisitor createRemappingSignatureAdapter(SignatureVisitor signatureVisitor) {
        return createSignatureRemapper(signatureVisitor);
    }

    /* access modifiers changed from: protected */
    public SignatureVisitor createSignatureRemapper(SignatureVisitor signatureVisitor) {
        return new SignatureRemapper(signatureVisitor, this);
    }

    public String map(String str) {
        return str;
    }

    public String mapAnnotationAttributeName(String str, String str2) {
        return str2;
    }

    public String mapDesc(String str) {
        return mapType(Type.getType(str)).getDescriptor();
    }

    public String mapFieldName(String str, String str2, String str3) {
        return str2;
    }

    public String mapInnerClassName(String str, String str2, String str3) {
        String mapType = mapType(str);
        if (mapType.equals(str)) {
            return str3;
        }
        int lastIndexOf = str.lastIndexOf(47);
        int lastIndexOf2 = mapType.lastIndexOf(47);
        if ((lastIndexOf != -1 && lastIndexOf2 != -1 && str.substring(lastIndexOf).equals(mapType.substring(lastIndexOf2))) || !mapType.contains("$")) {
            return str3;
        }
        int lastIndexOf3 = mapType.lastIndexOf(36);
        do {
            lastIndexOf3++;
            if (lastIndexOf3 >= mapType.length() || !Character.isDigit(mapType.charAt(lastIndexOf3))) {
            }
            lastIndexOf3++;
            break;
        } while (!Character.isDigit(mapType.charAt(lastIndexOf3)));
        return mapType.substring(lastIndexOf3);
    }

    public String mapInvokeDynamicMethodName(String str, String str2) {
        return str;
    }

    public String mapMethodDesc(String str) {
        if ("()V".equals(str)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder("(");
        for (Type mapType : Type.getArgumentTypes(str)) {
            sb2.append(mapType(mapType).getDescriptor());
        }
        Type returnType = Type.getReturnType(str);
        if (returnType == Type.VOID_TYPE) {
            sb2.append(")V");
        } else {
            sb2.append(PropertyUtils.MAPPED_DELIM2);
            sb2.append(mapType(returnType).getDescriptor());
        }
        return sb2.toString();
    }

    public String mapMethodName(String str, String str2, String str3) {
        return str2;
    }

    public String mapModuleName(String str) {
        return str;
    }

    public String mapPackageName(String str) {
        return str;
    }

    public String mapRecordComponentName(String str, String str2, String str3) {
        return str2;
    }

    public String mapSignature(String str, boolean z10) {
        if (str == null) {
            return null;
        }
        SignatureReader signatureReader = new SignatureReader(str);
        SignatureWriter signatureWriter = new SignatureWriter();
        SignatureVisitor createSignatureRemapper = createSignatureRemapper(signatureWriter);
        if (z10) {
            signatureReader.acceptType(createSignatureRemapper);
        } else {
            signatureReader.accept(createSignatureRemapper);
        }
        return signatureWriter.toString();
    }

    public String[] mapTypes(String[] strArr) {
        String[] strArr2 = null;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String mapType = mapType(strArr[i10]);
            if (mapType != null) {
                if (strArr2 == null) {
                    strArr2 = (String[]) strArr.clone();
                }
                strArr2[i10] = mapType;
            }
        }
        if (strArr2 != null) {
            return strArr2;
        }
        return strArr;
    }

    public Object mapValue(Object obj) {
        String str;
        String str2;
        if (obj instanceof Type) {
            return mapType((Type) obj);
        }
        int i10 = 0;
        if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            if (handle.getTag() <= 4) {
                i10 = 1;
            }
            int tag = handle.getTag();
            String mapType = mapType(handle.getOwner());
            if (i10 != 0) {
                str = mapFieldName(handle.getOwner(), handle.getName(), handle.getDesc());
            } else {
                str = mapMethodName(handle.getOwner(), handle.getName(), handle.getDesc());
            }
            String str3 = str;
            if (i10 != 0) {
                str2 = mapDesc(handle.getDesc());
            } else {
                str2 = mapMethodDesc(handle.getDesc());
            }
            return new Handle(tag, mapType, str3, str2, handle.isInterface());
        } else if (!(obj instanceof ConstantDynamic)) {
            return obj;
        } else {
            ConstantDynamic constantDynamic = (ConstantDynamic) obj;
            int bootstrapMethodArgumentCount = constantDynamic.getBootstrapMethodArgumentCount();
            Object[] objArr = new Object[bootstrapMethodArgumentCount];
            while (i10 < bootstrapMethodArgumentCount) {
                objArr[i10] = mapValue(constantDynamic.getBootstrapMethodArgument(i10));
                i10++;
            }
            String descriptor = constantDynamic.getDescriptor();
            return new ConstantDynamic(mapInvokeDynamicMethodName(constantDynamic.getName(), descriptor), mapDesc(descriptor), (Handle) mapValue(constantDynamic.getBootstrapMethod()), objArr);
        }
    }

    public String mapType(String str) {
        if (str == null) {
            return null;
        }
        return mapType(Type.getObjectType(str)).getInternalName();
    }
}
