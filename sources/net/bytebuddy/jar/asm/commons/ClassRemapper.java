package net.bytebuddy.jar.asm.commons;

import java.util.List;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;

public class ClassRemapper extends ClassVisitor {
    protected String className;
    protected final Remapper remapper;

    public ClassRemapper(ClassVisitor classVisitor, Remapper remapper2) {
        this(Opcodes.ASM9, classVisitor, remapper2);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, (String) null, annotationVisitor, this.remapper);
    }

    /* access modifiers changed from: protected */
    public FieldVisitor createFieldRemapper(FieldVisitor fieldVisitor) {
        return new FieldRemapper(this.api, fieldVisitor, this.remapper);
    }

    /* access modifiers changed from: protected */
    public MethodVisitor createMethodRemapper(MethodVisitor methodVisitor) {
        return new MethodRemapper(this.api, methodVisitor, this.remapper);
    }

    /* access modifiers changed from: protected */
    public ModuleVisitor createModuleRemapper(ModuleVisitor moduleVisitor) {
        return new ModuleRemapper(this.api, moduleVisitor, this.remapper);
    }

    /* access modifiers changed from: protected */
    public RecordComponentVisitor createRecordComponentRemapper(RecordComponentVisitor recordComponentVisitor) {
        return new RecordComponentRemapper(this.api, recordComponentVisitor, this.remapper);
    }

    public void visit(int i10, int i11, String str, String str2, String str3, String[] strArr) {
        String[] strArr2;
        this.className = str;
        String mapType = this.remapper.mapType(str);
        String mapSignature = this.remapper.mapSignature(str2, false);
        String mapType2 = this.remapper.mapType(str3);
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = this.remapper.mapTypes(strArr);
        }
        super.visit(i10, i11, mapType, mapSignature, mapType2, strArr2);
    }

    public AnnotationVisitor visitAnnotation(String str, boolean z10) {
        AnnotationVisitor visitAnnotation = super.visitAnnotation(this.remapper.mapDesc(str), z10);
        if (visitAnnotation == null) {
            return null;
        }
        return createAnnotationRemapper(str, visitAnnotation);
    }

    public void visitAttribute(Attribute attribute) {
        if (attribute instanceof ModuleHashesAttribute) {
            List<String> list = ((ModuleHashesAttribute) attribute).modules;
            for (int i10 = 0; i10 < list.size(); i10++) {
                list.set(i10, this.remapper.mapModuleName(list.get(i10)));
            }
        }
        super.visitAttribute(attribute);
    }

    public FieldVisitor visitField(int i10, String str, String str2, String str3, Object obj) {
        Object obj2;
        String mapFieldName = this.remapper.mapFieldName(this.className, str, str2);
        String mapDesc = this.remapper.mapDesc(str2);
        String mapSignature = this.remapper.mapSignature(str3, true);
        if (obj == null) {
            obj2 = null;
        } else {
            obj2 = this.remapper.mapValue(obj);
        }
        FieldVisitor visitField = super.visitField(i10, mapFieldName, mapDesc, mapSignature, obj2);
        if (visitField == null) {
            return null;
        }
        return createFieldRemapper(visitField);
    }

    public void visitInnerClass(String str, String str2, String str3, int i10) {
        String str4;
        String mapType = this.remapper.mapType(str);
        String str5 = null;
        if (str2 == null) {
            str4 = null;
        } else {
            str4 = this.remapper.mapType(str2);
        }
        if (str3 != null) {
            str5 = this.remapper.mapInnerClassName(str, str2, str3);
        }
        super.visitInnerClass(mapType, str4, str5, i10);
    }

    public MethodVisitor visitMethod(int i10, String str, String str2, String str3, String[] strArr) {
        String[] strArr2;
        String mapMethodDesc = this.remapper.mapMethodDesc(str2);
        String mapMethodName = this.remapper.mapMethodName(this.className, str, str2);
        String mapSignature = this.remapper.mapSignature(str3, false);
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = this.remapper.mapTypes(strArr);
        }
        MethodVisitor visitMethod = super.visitMethod(i10, mapMethodName, mapMethodDesc, mapSignature, strArr2);
        if (visitMethod == null) {
            return null;
        }
        return createMethodRemapper(visitMethod);
    }

    public ModuleVisitor visitModule(String str, int i10, String str2) {
        ModuleVisitor visitModule = super.visitModule(this.remapper.mapModuleName(str), i10, str2);
        if (visitModule == null) {
            return null;
        }
        return createModuleRemapper(visitModule);
    }

    public void visitNestHost(String str) {
        super.visitNestHost(this.remapper.mapType(str));
    }

    public void visitNestMember(String str) {
        super.visitNestMember(this.remapper.mapType(str));
    }

    public void visitOuterClass(String str, String str2, String str3) {
        String str4;
        String mapType = this.remapper.mapType(str);
        String str5 = null;
        if (str2 == null) {
            str4 = null;
        } else {
            str4 = this.remapper.mapMethodName(str, str2, str3);
        }
        if (str3 != null) {
            str5 = this.remapper.mapMethodDesc(str3);
        }
        super.visitOuterClass(mapType, str4, str5);
    }

    public void visitPermittedSubclass(String str) {
        super.visitPermittedSubclass(this.remapper.mapType(str));
    }

    public RecordComponentVisitor visitRecordComponent(String str, String str2, String str3) {
        RecordComponentVisitor visitRecordComponent = super.visitRecordComponent(this.remapper.mapRecordComponentName(this.className, str, str2), this.remapper.mapDesc(str2), this.remapper.mapSignature(str3, true));
        if (visitRecordComponent == null) {
            return null;
        }
        return createRecordComponentRemapper(visitRecordComponent);
    }

    public AnnotationVisitor visitTypeAnnotation(int i10, TypePath typePath, String str, boolean z10) {
        AnnotationVisitor visitTypeAnnotation = super.visitTypeAnnotation(i10, typePath, this.remapper.mapDesc(str), z10);
        if (visitTypeAnnotation == null) {
            return null;
        }
        return createAnnotationRemapper(str, visitTypeAnnotation);
    }

    protected ClassRemapper(int i10, ClassVisitor classVisitor, Remapper remapper2) {
        super(i10, classVisitor);
        this.remapper = remapper2;
    }

    /* access modifiers changed from: protected */
    public AnnotationVisitor createAnnotationRemapper(String str, AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, str, annotationVisitor, this.remapper).orDeprecatedValue(createAnnotationRemapper(annotationVisitor));
    }
}
