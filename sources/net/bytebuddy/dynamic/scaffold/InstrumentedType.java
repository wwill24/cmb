package net.bytebuddy.dynamic.scaffold;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.leanplum.internal.Constants;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.Transformer;
import net.bytebuddy.dynamic.scaffold.TypeInitializer;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;
import org.apache.commons.validator.Var;
import org.jivesoftware.smackx.carbons.packet.CarbonExtension;

public interface InstrumentedType extends TypeDescription {

    public static class Default extends TypeDescription.AbstractBase.OfSimpleType implements WithFlexibleName {
        private static final Set<String> KEYWORDS = new HashSet(Arrays.asList(new String[]{"abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized", "boolean", "do", "if", CarbonExtension.Private.ELEMENT, "this", "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", FacebookRequestErrorClassification.KEY_TRANSIENT, "catch", "extends", Var.JSTYPE_INT, "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", Constants.Kinds.FLOAT, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "super", "while"}));
        private final List<? extends AnnotationDescription> annotationDescriptions;
        private final boolean anonymousClass;
        private final Map<String, Object> auxiliaryFields;
        private final List<? extends TypeDescription> declaredTypes;
        @MaybeNull
        private final TypeDescription declaringType;
        @MaybeNull
        private final MethodDescription.InDefinedShape enclosingMethod;
        @MaybeNull
        private final TypeDescription enclosingType;
        private final List<? extends FieldDescription.Token> fieldTokens;
        private final List<? extends TypeDescription.Generic> interfaceTypes;
        private final LoadedTypeInitializer loadedTypeInitializer;
        private final boolean localClass;
        private final List<? extends MethodDescription.Token> methodTokens;
        private final int modifiers;
        private final String name;
        private final TypeDescription nestHost;
        private final List<? extends TypeDescription> nestMembers;
        @MaybeNull
        private final List<? extends TypeDescription> permittedSubclasses;
        private final boolean record;
        private final List<? extends RecordComponentDescription.Token> recordComponentTokens;
        @MaybeNull
        private final TypeDescription.Generic superClass;
        private final TypeInitializer typeInitializer;
        private final List<? extends TypeVariableToken> typeVariables;

        protected Default(String str, int i10, @MaybeNull TypeDescription.Generic generic, List<? extends TypeVariableToken> list, List<? extends TypeDescription.Generic> list2, List<? extends FieldDescription.Token> list3, Map<String, Object> map, List<? extends MethodDescription.Token> list4, List<? extends RecordComponentDescription.Token> list5, List<? extends AnnotationDescription> list6, TypeInitializer typeInitializer2, LoadedTypeInitializer loadedTypeInitializer2, @MaybeNull TypeDescription typeDescription, @MaybeNull MethodDescription.InDefinedShape inDefinedShape, @MaybeNull TypeDescription typeDescription2, List<? extends TypeDescription> list7, @MaybeNull List<? extends TypeDescription> list8, boolean z10, boolean z11, boolean z12, TypeDescription typeDescription3, List<? extends TypeDescription> list9) {
            this.name = str;
            this.modifiers = i10;
            this.typeVariables = list;
            this.superClass = generic;
            this.interfaceTypes = list2;
            this.fieldTokens = list3;
            this.auxiliaryFields = map;
            this.methodTokens = list4;
            this.recordComponentTokens = list5;
            this.annotationDescriptions = list6;
            this.typeInitializer = typeInitializer2;
            this.loadedTypeInitializer = loadedTypeInitializer2;
            this.declaringType = typeDescription;
            this.enclosingMethod = inDefinedShape;
            this.enclosingType = typeDescription2;
            this.declaredTypes = list7;
            this.permittedSubclasses = list8;
            this.anonymousClass = z10;
            this.localClass = z11;
            this.record = z12;
            this.nestHost = typeDescription3;
            this.nestMembers = list9;
        }

        private static boolean isValidIdentifier(String[] strArr) {
            if (strArr.length == 0) {
                return false;
            }
            for (String isValidIdentifier : strArr) {
                if (!isValidIdentifier(isValidIdentifier)) {
                    return false;
                }
            }
            return true;
        }

        public static InstrumentedType of(String str, TypeDescription.Generic generic, ModifierContributor.ForType... forTypeArr) {
            return of(str, generic, ModifierContributor.Resolver.of(forTypeArr).resolve());
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.annotationDescriptions);
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return new FieldList.ForTokens((TypeDescription) this, this.fieldTokens);
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return new MethodList.ForTokens((TypeDescription) this, this.methodTokens);
        }

        public TypeList getDeclaredTypes() {
            return new TypeList.Explicit(this.declaredTypes);
        }

        @MaybeNull
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return this.enclosingMethod;
        }

        @MaybeNull
        public TypeDescription getEnclosingType() {
            return this.enclosingType;
        }

        public TypeList.Generic getInterfaces() {
            return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(this.interfaceTypes, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of((TypeDescription) this));
        }

        public LoadedTypeInitializer getLoadedTypeInitializer() {
            return this.loadedTypeInitializer;
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription getNestHost() {
            return this.nestHost.represents(TargetType.class) ? this : this.nestHost;
        }

        public TypeList getNestMembers() {
            if (this.nestHost.represents(TargetType.class)) {
                return new TypeList.Explicit((List<? extends TypeDescription>) CompoundList.of(this, this.nestMembers));
            }
            return this.nestHost.getNestMembers();
        }

        @MaybeNull
        public PackageDescription getPackage() {
            int lastIndexOf = this.name.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return PackageDescription.DEFAULT;
            }
            return new PackageDescription.Simple(this.name.substring(0, lastIndexOf));
        }

        public TypeList getPermittedSubtypes() {
            return this.permittedSubclasses == null ? new TypeList.Empty() : new TypeList.Explicit(this.permittedSubclasses);
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return new RecordComponentList.ForTokens((TypeDescription) this, this.recordComponentTokens);
        }

        @MaybeNull
        public TypeDescription.Generic getSuperClass() {
            TypeDescription.Generic generic = this.superClass;
            if (generic == null) {
                return TypeDescription.Generic.UNDEFINED;
            }
            return new TypeDescription.Generic.LazyProjection.WithResolvedErasure(generic, TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of((TypeDescription) this));
        }

        public TypeInitializer getTypeInitializer() {
            return this.typeInitializer;
        }

        public TypeList.Generic getTypeVariables() {
            return TypeList.Generic.ForDetachedTypes.attachVariables((TypeDescription) this, this.typeVariables);
        }

        public boolean isAnonymousType() {
            return this.anonymousClass;
        }

        public boolean isLocalType() {
            return this.localClass;
        }

        @SuppressFBWarnings(justification = "Assuming super class for given instance.", value = {"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
        public boolean isRecord() {
            if (!this.record || this.superClass == null || !getSuperClass().asErasure().equals(JavaType.RECORD.getTypeStub())) {
                return false;
            }
            return true;
        }

        public boolean isSealed() {
            return this.permittedSubclasses != null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:164:0x0517  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.description.type.TypeDescription validated() {
            /*
                r30 = this;
                r0 = r30
                java.lang.String r1 = r30.getName()
                java.lang.String r2 = "\\."
                java.lang.String[] r1 = r1.split(r2)
                boolean r1 = isValidIdentifier((java.lang.String[]) r1)
                java.lang.String r2 = " for "
                if (r1 == 0) goto L_0x0ed2
                int r1 = r30.getModifiers()
                r3 = -161312(0xfffffffffffd89e0, float:NaN)
                r1 = r1 & r3
                java.lang.String r3 = "Illegal modifiers "
                if (r1 != 0) goto L_0x0eb2
                boolean r1 = r30.isPackageType()
                if (r1 == 0) goto L_0x0050
                int r1 = r30.getModifiers()
                r4 = 5632(0x1600, float:7.892E-42)
                if (r1 != r4) goto L_0x002f
                goto L_0x0050
            L_0x002f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r3)
                int r3 = r30.getModifiers()
                r2.append(r3)
                java.lang.String r3 = " for package "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0050:
                net.bytebuddy.description.type.TypeDescription$Generic r1 = r30.getSuperClass()
                if (r1 == 0) goto L_0x00d4
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r4 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.SUPER_CLASS
                java.lang.Object r4 = r1.accept(r4)
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x00b7
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r4 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                java.lang.Object r4 = r1.accept(r4)
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x009a
                net.bytebuddy.description.type.TypeDescription r4 = r1.asErasure()
                boolean r4 = r4.isVisibleTo(r0)
                if (r4 == 0) goto L_0x007d
                goto L_0x00d4
            L_0x007d:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Invisible super type "
                r4.append(r5)
                r4.append(r1)
                r4.append(r2)
                r4.append(r0)
                java.lang.String r1 = r4.toString()
                r3.<init>(r1)
                throw r3
            L_0x009a:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Illegal type annotations on super class "
                r4.append(r5)
                r4.append(r1)
                r4.append(r2)
                r4.append(r0)
                java.lang.String r1 = r4.toString()
                r3.<init>(r1)
                throw r3
            L_0x00b7:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Illegal super class "
                r4.append(r5)
                r4.append(r1)
                r4.append(r2)
                r4.append(r0)
                java.lang.String r1 = r4.toString()
                r3.<init>(r1)
                throw r3
            L_0x00d4:
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                net.bytebuddy.description.type.TypeList$Generic r4 = r30.getInterfaces()
                java.util.Iterator r4 = r4.iterator()
            L_0x00e1:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L_0x0192
                java.lang.Object r5 = r4.next()
                net.bytebuddy.description.type.TypeDescription$Generic r5 = (net.bytebuddy.description.type.TypeDescription.Generic) r5
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r6 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.INTERFACE
                java.lang.Object r6 = r5.accept(r6)
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L_0x0175
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r6 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                java.lang.Object r6 = r5.accept(r6)
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L_0x0158
                net.bytebuddy.description.type.TypeDescription r6 = r5.asErasure()
                boolean r6 = r1.add(r6)
                if (r6 == 0) goto L_0x013b
                net.bytebuddy.description.type.TypeDescription r6 = r5.asErasure()
                boolean r6 = r6.isVisibleTo(r0)
                if (r6 == 0) goto L_0x011e
                goto L_0x00e1
            L_0x011e:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Invisible interface type "
                r3.append(r4)
                r3.append(r5)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x013b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Already implemented interface "
                r3.append(r4)
                r3.append(r5)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0158:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Illegal type annotations on interface "
                r3.append(r4)
                r3.append(r5)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0175:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Illegal interface "
                r3.append(r4)
                r3.append(r5)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0192:
                net.bytebuddy.description.type.TypeList$Generic r1 = r30.getTypeVariables()
                boolean r4 = r1.isEmpty()
                if (r4 != 0) goto L_0x01c1
                java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
                boolean r4 = r0.isAssignableTo((java.lang.Class<?>) r4)
                if (r4 != 0) goto L_0x01a5
                goto L_0x01c1
            L_0x01a5:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Cannot define throwable "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r3 = " to be generic"
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x01c1:
                java.util.HashSet r4 = new java.util.HashSet
                r4.<init>()
                java.util.Iterator r1 = r1.iterator()
            L_0x01ca:
                boolean r5 = r1.hasNext()
                java.lang.String r6 = "Illegal interface bound "
                java.lang.String r8 = "Duplicate bound "
                java.lang.String r9 = "Illegal type variable bound "
                java.lang.String r10 = " does not define at least one bound"
                java.lang.String r11 = "Type variable "
                java.lang.String r12 = "Illegal type annotation on '"
                java.lang.String r14 = "Illegal type variable name '"
                java.lang.String r15 = "Duplicate type variable symbol '"
                java.lang.String r7 = "' for "
                java.lang.String r13 = " of "
                if (r5 == 0) goto L_0x034a
                java.lang.Object r5 = r1.next()
                net.bytebuddy.description.type.TypeDescription$Generic r5 = (net.bytebuddy.description.type.TypeDescription.Generic) r5
                r17 = r1
                java.lang.String r1 = r5.getSymbol()
                boolean r18 = r4.add(r1)
                if (r18 == 0) goto L_0x032f
                boolean r1 = isValidIdentifier((java.lang.String) r1)
                if (r1 == 0) goto L_0x0314
                boolean r1 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(r5)
                if (r1 == 0) goto L_0x02f9
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                net.bytebuddy.description.type.TypeList$Generic r7 = r5.getUpperBounds()
                java.util.Iterator r7 = r7.iterator()
                r16 = 0
            L_0x0211:
                boolean r12 = r7.hasNext()
                if (r12 == 0) goto L_0x02d5
                java.lang.Object r12 = r7.next()
                net.bytebuddy.description.type.TypeDescription$Generic r12 = (net.bytebuddy.description.type.TypeDescription.Generic) r12
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r14 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.TYPE_VARIABLE
                java.lang.Object r14 = r12.accept(r14)
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                if (r14 == 0) goto L_0x02b4
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r14 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                java.lang.Object r14 = r12.accept(r14)
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                if (r14 == 0) goto L_0x0297
                boolean r14 = r1.add(r12)
                if (r14 == 0) goto L_0x0276
                if (r16 == 0) goto L_0x0273
                net.bytebuddy.description.type.TypeDefinition$Sort r14 = r12.getSort()
                boolean r14 = r14.isTypeVariable()
                if (r14 != 0) goto L_0x0252
                boolean r14 = r12.isInterface()
                if (r14 == 0) goto L_0x0252
                goto L_0x0273
            L_0x0252:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r6)
                r3.append(r12)
                r3.append(r13)
                r3.append(r5)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0273:
                r16 = 1
                goto L_0x0211
            L_0x0276:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r8)
                r3.append(r12)
                r3.append(r13)
                r3.append(r5)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0297:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Illegal type annotations on type variable "
                r3.append(r4)
                r3.append(r12)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x02b4:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r9)
                r3.append(r12)
                r3.append(r13)
                r3.append(r5)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x02d5:
                if (r16 == 0) goto L_0x02db
                r1 = r17
                goto L_0x01ca
            L_0x02db:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r11)
                r3.append(r5)
                r3.append(r2)
                r3.append(r0)
                r3.append(r10)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x02f9:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r12)
                r2.append(r5)
                r2.append(r7)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0314:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r14)
                r2.append(r5)
                r2.append(r7)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x032f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r15)
                r2.append(r5)
                r2.append(r7)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x034a:
                net.bytebuddy.description.type.TypeDescription r1 = r30.getEnclosingType()
                java.lang.String r4 = "Cannot define array type or primitive type "
                if (r1 == 0) goto L_0x037c
                boolean r5 = r1.isArray()
                if (r5 != 0) goto L_0x035f
                boolean r5 = r1.isPrimitive()
                if (r5 != 0) goto L_0x035f
                goto L_0x037c
            L_0x035f:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r4)
                r3.append(r1)
                java.lang.String r1 = " + as enclosing type for "
                r3.append(r1)
                r3.append(r0)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1)
                throw r2
            L_0x037c:
                net.bytebuddy.description.method.MethodDescription$InDefinedShape r5 = r30.getEnclosingMethod()
                if (r5 == 0) goto L_0x03a0
                boolean r17 = r5.isTypeInitializer()
                if (r17 != 0) goto L_0x0389
                goto L_0x03a0
            L_0x0389:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Cannot enclose type declaration in class initializer "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x03a0:
                r17 = r3
                net.bytebuddy.description.type.TypeDescription r3 = r30.getDeclaringType()
                if (r3 == 0) goto L_0x03d2
                boolean r5 = r3.isPrimitive()
                if (r5 != 0) goto L_0x03b5
                boolean r5 = r3.isArray()
                if (r5 != 0) goto L_0x03b5
                goto L_0x03fa
            L_0x03b5:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r3)
                java.lang.String r3 = " as declaring type for "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x03d2:
                if (r1 != 0) goto L_0x03fa
                if (r5 != 0) goto L_0x03fa
                boolean r3 = r30.isLocalType()
                if (r3 != 0) goto L_0x03e3
                boolean r3 = r30.isAnonymousType()
                if (r3 != 0) goto L_0x03e3
                goto L_0x03fa
            L_0x03e3:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Cannot define an anonymous or local class without a declaring type for "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x03fa:
                java.util.HashSet r3 = new java.util.HashSet
                r3.<init>()
                net.bytebuddy.description.type.TypeList r5 = r30.getDeclaredTypes()
                java.util.Iterator r5 = r5.iterator()
            L_0x0407:
                boolean r18 = r5.hasNext()
                if (r18 == 0) goto L_0x0460
                java.lang.Object r18 = r5.next()
                r19 = r5
                r5 = r18
                net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                boolean r18 = r5.isArray()
                if (r18 != 0) goto L_0x0443
                boolean r18 = r5.isPrimitive()
                if (r18 != 0) goto L_0x0443
                boolean r18 = r3.add(r5)
                if (r18 == 0) goto L_0x042c
                r5 = r19
                goto L_0x0407
            L_0x042c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Duplicate definition of declared type "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0443:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r5)
                java.lang.String r3 = " + as declared type for "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0460:
                net.bytebuddy.description.type.TypeDescription r3 = r30.getNestHost()
                boolean r5 = r3.equals(r0)
                r18 = r1
                java.lang.String r1 = " + within different package then "
                if (r5 == 0) goto L_0x04f7
                java.util.HashSet r3 = new java.util.HashSet
                r3.<init>()
                net.bytebuddy.description.type.TypeList r5 = r30.getNestMembers()
                java.util.Iterator r5 = r5.iterator()
            L_0x047b:
                boolean r19 = r5.hasNext()
                if (r19 == 0) goto L_0x0509
                java.lang.Object r19 = r5.next()
                r20 = r5
                r5 = r19
                net.bytebuddy.description.type.TypeDescription r5 = (net.bytebuddy.description.type.TypeDescription) r5
                boolean r19 = r5.isArray()
                if (r19 != 0) goto L_0x04da
                boolean r19 = r5.isPrimitive()
                if (r19 != 0) goto L_0x04da
                boolean r19 = r5.isSamePackage(r0)
                if (r19 == 0) goto L_0x04bd
                boolean r19 = r3.add(r5)
                if (r19 == 0) goto L_0x04a6
                r5 = r20
                goto L_0x047b
            L_0x04a6:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Duplicate definition of nest member "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x04bd:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Cannot define nest member "
                r3.append(r4)
                r3.append(r5)
                r3.append(r1)
                r3.append(r0)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1)
                throw r2
            L_0x04da:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r5)
                java.lang.String r3 = " + as nest member of "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x04f7:
                boolean r5 = r3.isArray()
                if (r5 != 0) goto L_0x0e95
                boolean r5 = r3.isPrimitive()
                if (r5 != 0) goto L_0x0e95
                boolean r4 = r3.isSamePackage(r0)
                if (r4 == 0) goto L_0x0e78
            L_0x0509:
                net.bytebuddy.description.type.TypeList r1 = r30.getPermittedSubtypes()
                java.util.Iterator r1 = r1.iterator()
            L_0x0511:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0549
                java.lang.Object r3 = r1.next()
                net.bytebuddy.description.type.TypeDescription r3 = (net.bytebuddy.description.type.TypeDescription) r3
                boolean r4 = r3.isAssignableTo((net.bytebuddy.description.type.TypeDescription) r0)
                if (r4 == 0) goto L_0x052a
                boolean r4 = r3.equals(r0)
                if (r4 != 0) goto L_0x052a
                goto L_0x0511
            L_0x052a:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "Cannot assign permitted subclass "
                r2.append(r4)
                r2.append(r3)
                java.lang.String r3 = " to "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0549:
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                net.bytebuddy.description.annotation.AnnotationList r3 = r30.getDeclaredAnnotations()
                java.util.Iterator r3 = r3.iterator()
            L_0x0556:
                boolean r4 = r3.hasNext()
                java.lang.String r5 = " on "
                r19 = r15
                java.lang.String r15 = "Cannot add "
                r20 = r14
                java.lang.String r14 = "Duplicate annotation "
                if (r4 == 0) goto L_0x05da
                java.lang.Object r4 = r3.next()
                net.bytebuddy.description.annotation.AnnotationDescription r4 = (net.bytebuddy.description.annotation.AnnotationDescription) r4
                r21 = r3
                java.lang.annotation.ElementType r3 = java.lang.annotation.ElementType.TYPE
                boolean r3 = r4.isSupportedOn((java.lang.annotation.ElementType) r3)
                if (r3 != 0) goto L_0x05ae
                boolean r3 = r30.isAnnotation()
                if (r3 == 0) goto L_0x0584
                java.lang.annotation.ElementType r3 = java.lang.annotation.ElementType.ANNOTATION_TYPE
                boolean r3 = r4.isSupportedOn((java.lang.annotation.ElementType) r3)
                if (r3 != 0) goto L_0x05ae
            L_0x0584:
                boolean r3 = r30.isPackageType()
                if (r3 == 0) goto L_0x0593
                java.lang.annotation.ElementType r3 = java.lang.annotation.ElementType.PACKAGE
                boolean r3 = r4.isSupportedOn((java.lang.annotation.ElementType) r3)
                if (r3 == 0) goto L_0x0593
                goto L_0x05ae
            L_0x0593:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r15)
                r2.append(r4)
                r2.append(r5)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x05ae:
                net.bytebuddy.description.type.TypeDescription r3 = r4.getAnnotationType()
                boolean r3 = r1.add(r3)
                if (r3 == 0) goto L_0x05bf
                r15 = r19
                r14 = r20
                r3 = r21
                goto L_0x0556
            L_0x05bf:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r14)
                r3.append(r4)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x05da:
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                net.bytebuddy.description.field.FieldList r3 = r30.getDeclaredFields()
                java.util.Iterator r3 = r3.iterator()
            L_0x05e7:
                boolean r4 = r3.hasNext()
                r21 = r7
                java.lang.String r7 = "Illegal type annotations on "
                if (r4 == 0) goto L_0x0761
                java.lang.Object r4 = r3.next()
                net.bytebuddy.description.field.FieldDescription$InDefinedShape r4 = (net.bytebuddy.description.field.FieldDescription.InDefinedShape) r4
                java.lang.String r22 = r4.getName()
                r23 = r3
                net.bytebuddy.description.field.FieldDescription$SignatureToken r3 = r4.asSignatureToken()
                boolean r3 = r1.add(r3)
                if (r3 == 0) goto L_0x074a
                boolean r3 = isValidIdentifier((java.lang.String) r22)
                if (r3 == 0) goto L_0x0733
                int r3 = r4.getModifiers()
                r22 = -151776(0xfffffffffffdaf20, float:NaN)
                r3 = r3 & r22
                if (r3 != 0) goto L_0x0712
                net.bytebuddy.description.type.TypeDescription$Generic r3 = r4.getType()
                r22 = r1
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r1 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.FIELD
                java.lang.Object r1 = r3.accept(r1)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x06f5
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r1 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                java.lang.Object r1 = r3.accept(r1)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x06da
                boolean r1 = r4.isSynthetic()
                if (r1 != 0) goto L_0x066c
                net.bytebuddy.description.type.TypeDescription r1 = r3.asErasure()
                boolean r1 = r1.isVisibleTo(r0)
                if (r1 == 0) goto L_0x064b
                goto L_0x066c
            L_0x064b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "Invisible field type "
                r3.append(r5)
                net.bytebuddy.description.type.TypeDescription$Generic r5 = r4.getType()
                r3.append(r5)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x066c:
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                net.bytebuddy.description.annotation.AnnotationList r3 = r4.getDeclaredAnnotations()
                java.util.Iterator r3 = r3.iterator()
            L_0x0679:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L_0x06d2
                java.lang.Object r7 = r3.next()
                net.bytebuddy.description.annotation.AnnotationDescription r7 = (net.bytebuddy.description.annotation.AnnotationDescription) r7
                r24 = r3
                java.lang.annotation.ElementType r3 = java.lang.annotation.ElementType.FIELD
                boolean r3 = r7.isSupportedOn((java.lang.annotation.ElementType) r3)
                if (r3 == 0) goto L_0x06b7
                net.bytebuddy.description.type.TypeDescription r3 = r7.getAnnotationType()
                boolean r3 = r1.add(r3)
                if (r3 == 0) goto L_0x069c
                r3 = r24
                goto L_0x0679
            L_0x069c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r14)
                r3.append(r7)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x06b7:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r15)
                r2.append(r7)
                r2.append(r5)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x06d2:
                r7 = r21
                r1 = r22
                r3 = r23
                goto L_0x05e7
            L_0x06da:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r7)
                r4.append(r3)
                r4.append(r2)
                r4.append(r0)
                java.lang.String r2 = r4.toString()
                r1.<init>(r2)
                throw r1
            L_0x06f5:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal field type "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0712:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "Illegal field modifiers "
                r3.append(r5)
                int r5 = r4.getModifiers()
                r3.append(r5)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0733:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Illegal field name for "
                r2.append(r3)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x074a:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Duplicate field definition for "
                r2.append(r3)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0761:
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                net.bytebuddy.description.method.MethodList r3 = r30.getDeclaredMethods()
                java.util.Iterator r3 = r3.iterator()
            L_0x076e:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x0e77
                java.lang.Object r4 = r3.next()
                net.bytebuddy.description.method.MethodDescription$InDefinedShape r4 = (net.bytebuddy.description.method.MethodDescription.InDefinedShape) r4
                r22 = r3
                net.bytebuddy.description.method.MethodDescription$SignatureToken r3 = r4.asSignatureToken()
                boolean r3 = r1.add(r3)
                if (r3 == 0) goto L_0x0e60
                int r3 = r4.getModifiers()
                r3 = r3 & -7680(0xffffffffffffe200, float:NaN)
                if (r3 != 0) goto L_0x0e3f
                boolean r3 = r30.isInterface()
                if (r3 == 0) goto L_0x07b8
                boolean r3 = r4.isPublic()
                if (r3 != 0) goto L_0x07b8
                boolean r3 = r4.isPrivate()
                if (r3 == 0) goto L_0x07a1
                goto L_0x07b8
            L_0x07a1:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Methods declared by an interface must be public or private "
                r2.append(r3)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x07b8:
                java.util.HashSet r3 = new java.util.HashSet
                r3.<init>()
                net.bytebuddy.description.type.TypeList$Generic r23 = r4.getTypeVariables()
                java.util.Iterator r23 = r23.iterator()
            L_0x07c5:
                boolean r24 = r23.hasNext()
                if (r24 == 0) goto L_0x0959
                java.lang.Object r24 = r23.next()
                r25 = r1
                r1 = r24
                net.bytebuddy.description.type.TypeDescription$Generic r1 = (net.bytebuddy.description.type.TypeDescription.Generic) r1
                r24 = r7
                java.lang.String r7 = r1.getSymbol()
                boolean r26 = r3.add(r7)
                if (r26 == 0) goto L_0x093a
                boolean r7 = isValidIdentifier((java.lang.String) r7)
                if (r7 == 0) goto L_0x091b
                boolean r7 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(r1)
                if (r7 == 0) goto L_0x08fe
                java.util.HashSet r7 = new java.util.HashSet
                r7.<init>()
                net.bytebuddy.description.type.TypeList$Generic r26 = r1.getUpperBounds()
                java.util.Iterator r26 = r26.iterator()
                r27 = 0
            L_0x07fc:
                boolean r28 = r26.hasNext()
                if (r28 == 0) goto L_0x08d0
                java.lang.Object r28 = r26.next()
                r29 = r3
                r3 = r28
                net.bytebuddy.description.type.TypeDescription$Generic r3 = (net.bytebuddy.description.type.TypeDescription.Generic) r3
                r28 = r5
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r5 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.TYPE_VARIABLE
                java.lang.Object r5 = r3.accept(r5)
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L_0x08af
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r5 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                java.lang.Object r5 = r3.accept(r5)
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L_0x088c
                boolean r5 = r7.add(r3)
                if (r5 == 0) goto L_0x086b
                if (r27 == 0) goto L_0x0864
                net.bytebuddy.description.type.TypeDefinition$Sort r5 = r3.getSort()
                boolean r5 = r5.isTypeVariable()
                if (r5 != 0) goto L_0x0843
                boolean r5 = r3.isInterface()
                if (r5 == 0) goto L_0x0843
                goto L_0x0864
            L_0x0843:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r6)
                r7.append(r3)
                r7.append(r13)
                r7.append(r1)
                r7.append(r2)
                r7.append(r4)
                java.lang.String r1 = r7.toString()
                r5.<init>(r1)
                throw r5
            L_0x0864:
                r5 = r28
                r3 = r29
                r27 = 1
                goto L_0x07fc
            L_0x086b:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r8)
                r6.append(r3)
                r6.append(r13)
                r6.append(r1)
                r6.append(r2)
                r6.append(r4)
                java.lang.String r1 = r6.toString()
                r5.<init>(r1)
                throw r5
            L_0x088c:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal type annotations on bound "
                r5.append(r6)
                r5.append(r3)
                r5.append(r13)
                r5.append(r1)
                r5.append(r2)
                r5.append(r0)
                java.lang.String r1 = r5.toString()
                r4.<init>(r1)
                throw r4
            L_0x08af:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r9)
                r6.append(r3)
                r6.append(r13)
                r6.append(r1)
                r6.append(r2)
                r6.append(r4)
                java.lang.String r1 = r6.toString()
                r5.<init>(r1)
                throw r5
            L_0x08d0:
                r29 = r3
                r28 = r5
                if (r27 == 0) goto L_0x08e0
                r7 = r24
                r1 = r25
                r5 = r28
                r3 = r29
                goto L_0x07c5
            L_0x08e0:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r11)
                r5.append(r1)
                r5.append(r2)
                r5.append(r4)
                r5.append(r10)
                java.lang.String r1 = r5.toString()
                r3.<init>(r1)
                throw r3
            L_0x08fe:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r12)
                r3.append(r1)
                r5 = r21
                r3.append(r5)
                r3.append(r4)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1)
                throw r2
            L_0x091b:
                r5 = r21
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r7 = r20
                r3.append(r7)
                r3.append(r1)
                r3.append(r5)
                r3.append(r4)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1)
                throw r2
            L_0x093a:
                r5 = r21
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r6 = r19
                r3.append(r6)
                r3.append(r1)
                r3.append(r5)
                r3.append(r4)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1)
                throw r2
            L_0x0959:
                r25 = r1
                r28 = r5
                r24 = r7
                r1 = r19
                r7 = r20
                r5 = r21
                net.bytebuddy.description.type.TypeDescription$Generic r3 = r4.getReturnType()
                boolean r19 = r4.isTypeInitializer()
                if (r19 != 0) goto L_0x0e28
                boolean r19 = r4.isConstructor()
                if (r19 == 0) goto L_0x09b9
                r19 = r1
                java.lang.Class r1 = java.lang.Void.TYPE
                boolean r1 = r3.represents(r1)
                if (r1 == 0) goto L_0x09a2
                net.bytebuddy.description.annotation.AnnotationList r1 = r3.getDeclaredAnnotations()
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x098b
                goto L_0x0a17
            L_0x098b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "The void non-type must not be annotated for "
                r2.append(r3)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x09a2:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "A constructor must return void "
                r2.append(r3)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x09b9:
                r19 = r1
                java.lang.String r1 = r4.getInternalName()
                boolean r1 = isValidIdentifier((java.lang.String) r1)
                if (r1 == 0) goto L_0x0e0b
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r1 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.METHOD_RETURN
                java.lang.Object r1 = r3.accept(r1)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x0dee
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r1 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                java.lang.Object r1 = r3.accept(r1)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x0dd1
                boolean r1 = r4.isSynthetic()
                if (r1 != 0) goto L_0x0a17
                net.bytebuddy.description.type.TypeDescription$Generic r1 = r4.getReturnType()
                net.bytebuddy.description.type.TypeDescription r1 = r1.asErasure()
                boolean r1 = r1.isVisibleTo(r0)
                if (r1 == 0) goto L_0x09f6
                goto L_0x0a17
            L_0x09f6:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "Invisible return type "
                r3.append(r5)
                net.bytebuddy.description.type.TypeDescription$Generic r5 = r4.getReturnType()
                r3.append(r5)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0a17:
                java.util.HashSet r1 = new java.util.HashSet
                r1.<init>()
                net.bytebuddy.description.method.ParameterList r3 = r4.getParameters()
                java.util.Iterator r3 = r3.iterator()
            L_0x0a24:
                boolean r20 = r3.hasNext()
                if (r20 == 0) goto L_0x0bbb
                java.lang.Object r20 = r3.next()
                r21 = r3
                r3 = r20
                net.bytebuddy.description.method.ParameterDescription$InDefinedShape r3 = (net.bytebuddy.description.method.ParameterDescription.InDefinedShape) r3
                r20 = r5
                net.bytebuddy.description.type.TypeDescription$Generic r5 = r3.getType()
                r23 = r6
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r6 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.METHOD_PARAMETER
                java.lang.Object r6 = r5.accept(r6)
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L_0x0b9e
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r6 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                java.lang.Object r6 = r5.accept(r6)
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L_0x0b81
                boolean r6 = r4.isSynthetic()
                if (r6 != 0) goto L_0x0a86
                net.bytebuddy.description.type.TypeDescription r5 = r5.asErasure()
                boolean r5 = r5.isVisibleTo(r0)
                if (r5 == 0) goto L_0x0a69
                goto L_0x0a86
            L_0x0a69:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Invisible parameter type of "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0a86:
                boolean r5 = r3.isNamed()
                if (r5 == 0) goto L_0x0ad7
                java.lang.String r5 = r3.getName()
                boolean r6 = r1.add(r5)
                if (r6 == 0) goto L_0x0aba
                boolean r5 = isValidIdentifier((java.lang.String) r5)
                if (r5 == 0) goto L_0x0a9d
                goto L_0x0ad7
            L_0x0a9d:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal parameter name of "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0aba:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Duplicate parameter name of "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0ad7:
                boolean r5 = r3.hasModifiers()
                if (r5 == 0) goto L_0x0b05
                int r5 = r3.getModifiers()
                r6 = -36881(0xffffffffffff6fef, float:NaN)
                r5 = r5 & r6
                if (r5 != 0) goto L_0x0ae8
                goto L_0x0b05
            L_0x0ae8:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal modifiers of "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0b05:
                java.util.HashSet r5 = new java.util.HashSet
                r5.<init>()
                net.bytebuddy.description.annotation.AnnotationList r6 = r3.getDeclaredAnnotations()
                java.util.Iterator r6 = r6.iterator()
            L_0x0b12:
                boolean r26 = r6.hasNext()
                if (r26 == 0) goto L_0x0b79
                java.lang.Object r26 = r6.next()
                r27 = r1
                r1 = r26
                net.bytebuddy.description.annotation.AnnotationDescription r1 = (net.bytebuddy.description.annotation.AnnotationDescription) r1
                r26 = r6
                java.lang.annotation.ElementType r6 = java.lang.annotation.ElementType.PARAMETER
                boolean r6 = r1.isSupportedOn((java.lang.annotation.ElementType) r6)
                if (r6 == 0) goto L_0x0b5c
                net.bytebuddy.description.type.TypeDescription r6 = r1.getAnnotationType()
                boolean r6 = r5.add(r6)
                if (r6 == 0) goto L_0x0b3b
                r6 = r26
                r1 = r27
                goto L_0x0b12
            L_0x0b3b:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r14)
                r6.append(r1)
                r6.append(r13)
                r6.append(r3)
                r6.append(r2)
                r6.append(r4)
                java.lang.String r1 = r6.toString()
                r5.<init>(r1)
                throw r5
            L_0x0b5c:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r15)
                r4.append(r1)
                r1 = r28
                r4.append(r1)
                r4.append(r3)
                java.lang.String r1 = r4.toString()
                r2.<init>(r1)
                throw r2
            L_0x0b79:
                r5 = r20
                r3 = r21
                r6 = r23
                goto L_0x0a24
            L_0x0b81:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal type annotations on parameter "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0b9e:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal parameter type of "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0bbb:
                r20 = r5
                r23 = r6
                r1 = r28
                net.bytebuddy.description.type.TypeList$Generic r3 = r4.getExceptionTypes()
                java.util.Iterator r3 = r3.iterator()
            L_0x0bc9:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L_0x0c59
                java.lang.Object r5 = r3.next()
                net.bytebuddy.description.type.TypeDescription$Generic r5 = (net.bytebuddy.description.type.TypeDescription.Generic) r5
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r6 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.EXCEPTION
                java.lang.Object r6 = r5.accept(r6)
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L_0x0c3c
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r6 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                java.lang.Object r6 = r5.accept(r6)
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L_0x0c1f
                boolean r6 = r4.isSynthetic()
                if (r6 != 0) goto L_0x0bc9
                net.bytebuddy.description.type.TypeDescription r6 = r5.asErasure()
                boolean r6 = r6.isVisibleTo(r0)
                if (r6 == 0) goto L_0x0c02
                goto L_0x0bc9
            L_0x0c02:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r6 = "Invisible exception type "
                r3.append(r6)
                r3.append(r5)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0c1f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r6 = r24
                r3.append(r6)
                r3.append(r5)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0c3c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r6 = "Illegal exception type "
                r3.append(r6)
                r3.append(r5)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0c59:
                r6 = r24
                java.util.HashSet r3 = new java.util.HashSet
                r3.<init>()
                net.bytebuddy.description.annotation.AnnotationList r5 = r4.getDeclaredAnnotations()
                java.util.Iterator r5 = r5.iterator()
            L_0x0c68:
                boolean r21 = r5.hasNext()
                if (r21 == 0) goto L_0x0cd2
                java.lang.Object r21 = r5.next()
                r24 = r5
                r5 = r21
                net.bytebuddy.description.annotation.AnnotationDescription r5 = (net.bytebuddy.description.annotation.AnnotationDescription) r5
                boolean r21 = r4.isMethod()
                if (r21 == 0) goto L_0x0c81
                java.lang.annotation.ElementType r21 = java.lang.annotation.ElementType.METHOD
                goto L_0x0c83
            L_0x0c81:
                java.lang.annotation.ElementType r21 = java.lang.annotation.ElementType.CONSTRUCTOR
            L_0x0c83:
                r26 = r6
                r6 = r21
                boolean r6 = r5.isSupportedOn((java.lang.annotation.ElementType) r6)
                if (r6 == 0) goto L_0x0cb7
                net.bytebuddy.description.type.TypeDescription r6 = r5.getAnnotationType()
                boolean r6 = r3.add(r6)
                if (r6 == 0) goto L_0x0c9c
                r5 = r24
                r6 = r26
                goto L_0x0c68
            L_0x0c9c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r14)
                r3.append(r5)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0cb7:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r15)
                r3.append(r5)
                r3.append(r1)
                r3.append(r4)
                java.lang.String r1 = r3.toString()
                r2.<init>(r1)
                throw r2
            L_0x0cd2:
                r26 = r6
                net.bytebuddy.description.annotation.AnnotationValue r3 = r4.getDefaultValue()
                if (r3 == 0) goto L_0x0d00
                boolean r5 = r4.isDefaultValue(r3)
                if (r5 == 0) goto L_0x0ce1
                goto L_0x0d00
            L_0x0ce1:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "Illegal default value "
                r2.append(r5)
                r2.append(r3)
                java.lang.String r3 = "for "
                r2.append(r3)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0d00:
                net.bytebuddy.description.type.TypeDescription$Generic r3 = r4.getReceiverType()
                if (r3 == 0) goto L_0x0d32
                net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator r5 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.RECEIVER
                java.lang.Object r5 = r3.accept(r5)
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L_0x0d15
                goto L_0x0d32
            L_0x0d15:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal receiver type "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0d32:
                boolean r5 = r4.isStatic()
                if (r5 == 0) goto L_0x0d5c
                if (r3 != 0) goto L_0x0d3d
                r28 = r1
                goto L_0x0da4
            L_0x0d3d:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "Static method "
                r2.append(r5)
                r2.append(r4)
                java.lang.String r4 = " defines a non-null receiver "
                r2.append(r4)
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0d5c:
                boolean r5 = r4.isConstructor()
                java.lang.String r6 = " defines an illegal receiver "
                if (r5 == 0) goto L_0x0d96
                if (r3 == 0) goto L_0x0d79
                net.bytebuddy.description.type.TypeDescription r5 = r3.asErasure()
                r28 = r1
                if (r18 != 0) goto L_0x0d70
                r1 = r0
                goto L_0x0d72
            L_0x0d70:
                r1 = r18
            L_0x0d72:
                boolean r1 = r5.equals(r1)
                if (r1 == 0) goto L_0x0d79
                goto L_0x0da4
            L_0x0d79:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "Constructor "
                r2.append(r5)
                r2.append(r4)
                r2.append(r6)
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0d96:
                r28 = r1
                if (r3 == 0) goto L_0x0db4
                net.bytebuddy.description.type.TypeDescription r1 = r3.asErasure()
                boolean r1 = r0.equals(r1)
                if (r1 == 0) goto L_0x0db4
            L_0x0da4:
                r21 = r20
                r3 = r22
                r6 = r23
                r1 = r25
                r5 = r28
                r20 = r7
                r7 = r26
                goto L_0x076e
            L_0x0db4:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "Method "
                r2.append(r5)
                r2.append(r4)
                r2.append(r6)
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0dd1:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal type annotations on return type "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0dee:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal return type "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0e0b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Illegal method name "
                r5.append(r6)
                r5.append(r3)
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                r1.<init>(r2)
                throw r1
            L_0x0e28:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Illegal explicit declaration of a type initializer by "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0e3f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r5 = r17
                r3.append(r5)
                int r5 = r4.getModifiers()
                r3.append(r5)
                r3.append(r2)
                r3.append(r4)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0e60:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Duplicate method signature for "
                r2.append(r3)
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0e77:
                return r0
            L_0x0e78:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "Cannot define nest host "
                r4.append(r5)
                r4.append(r3)
                r4.append(r1)
                r4.append(r0)
                java.lang.String r1 = r4.toString()
                r2.<init>(r1)
                throw r2
            L_0x0e95:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r4)
                r2.append(r3)
                java.lang.String r3 = " + as nest host for "
                r2.append(r3)
                r2.append(r0)
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r1
            L_0x0eb2:
                r5 = r3
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r5)
                int r4 = r30.getModifiers()
                r3.append(r4)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            L_0x0ed2:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Illegal type name: "
                r3.append(r4)
                java.lang.String r4 = r30.getName()
                r3.append(r4)
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.scaffold.InstrumentedType.Default.validated():net.bytebuddy.description.type.TypeDescription");
        }

        public WithFlexibleName withName(String str) {
            return new Default(str, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
            ArrayList arrayList = new ArrayList(this.typeVariables.size());
            int i10 = 0;
            for (TypeVariableToken typeVariableToken : this.typeVariables) {
                int i11 = i10 + 1;
                if (elementMatcher.matches(getTypeVariables().get(i10))) {
                    typeVariableToken = transformer.transform(this, typeVariableToken);
                } else {
                    Transformer<TypeVariableToken> transformer2 = transformer;
                }
                arrayList.add(typeVariableToken);
                i10 = i11;
            }
            return new Default(this.name, this.modifiers, this.superClass, arrayList, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public static InstrumentedType of(String str, TypeDescription.Generic generic, int i10) {
            return Factory.Default.MODIFIABLE.subclass(str, i10, generic);
        }

        @MaybeNull
        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        public WithFlexibleName withAnnotations(List<? extends AnnotationDescription> list) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, CompoundList.of(this.annotationDescriptions, list), this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withAnonymousClass(boolean z10) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, z10, false, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withAuxiliaryField(FieldDescription.Token token, Object obj) {
            Object obj2 = obj;
            HashMap hashMap = new HashMap(this.auxiliaryFields);
            Object put = hashMap.put(token.getName(), obj2);
            if (put == null) {
                String str = this.name;
                return new Default(str, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, CompoundList.of(this.fieldTokens, token.accept((TypeDescription.Generic.Visitor) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), hashMap, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, new LoadedTypeInitializer.Compound(this.loadedTypeInitializer, new LoadedTypeInitializer.ForStaticField(token.getName(), obj2)), this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
            } else if (put == obj2) {
                return this;
            } else {
                throw new IllegalStateException("Field " + token.getName() + " for " + this + " already mapped to " + put + " and not " + obj2);
            }
        }

        public WithFlexibleName withDeclaredTypes(TypeList typeList) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, CompoundList.of(this.declaredTypes, (List<? extends TypeDescription>) typeList), this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withDeclaringType(@MaybeNull TypeDescription typeDescription) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, typeDescription, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape inDefinedShape) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, inDefinedShape, inDefinedShape.getDeclaringType(), this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withEnclosingType(@MaybeNull TypeDescription typeDescription) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, MethodDescription.UNDEFINED, typeDescription, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withField(FieldDescription.Token token) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, CompoundList.of(this.fieldTokens, token.accept((TypeDescription.Generic.Visitor) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withInterfaces(TypeList.Generic generic) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, CompoundList.of(this.interfaceTypes, (List<? extends TypeDescription.Generic>) generic.accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withLocalClass(boolean z10) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, false, z10, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withMethod(MethodDescription.Token token) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, CompoundList.of(this.methodTokens, token.accept((TypeDescription.Generic.Visitor) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withModifiers(int i10) {
            return new Default(this.name, i10, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withNestHost(TypeDescription typeDescription) {
            String str = this.name;
            int i10 = this.modifiers;
            TypeDescription.Generic generic = this.superClass;
            List<? extends TypeVariableToken> list = this.typeVariables;
            List<? extends TypeDescription.Generic> list2 = this.interfaceTypes;
            List<? extends FieldDescription.Token> list3 = this.fieldTokens;
            Map<String, Object> map = this.auxiliaryFields;
            List<? extends MethodDescription.Token> list4 = this.methodTokens;
            List<? extends RecordComponentDescription.Token> list5 = this.recordComponentTokens;
            List<? extends AnnotationDescription> list6 = this.annotationDescriptions;
            TypeInitializer typeInitializer2 = this.typeInitializer;
            LoadedTypeInitializer loadedTypeInitializer2 = this.loadedTypeInitializer;
            TypeDescription typeDescription2 = this.declaringType;
            MethodDescription.InDefinedShape inDefinedShape = this.enclosingMethod;
            TypeDescription typeDescription3 = this.enclosingType;
            MethodDescription.InDefinedShape inDefinedShape2 = inDefinedShape;
            List<? extends TypeDescription> list7 = this.declaredTypes;
            List<? extends TypeDescription> list8 = this.permittedSubclasses;
            boolean z10 = this.anonymousClass;
            boolean z11 = this.localClass;
            boolean z12 = this.record;
            TypeDescription typeDescription4 = typeDescription3;
            TypeDescription typeDescription5 = typeDescription;
            if (typeDescription5.equals(this)) {
                typeDescription5 = TargetType.DESCRIPTION;
            }
            boolean z13 = z12;
            return new Default(str, i10, generic, list, list2, list3, map, list4, list5, list6, typeInitializer2, loadedTypeInitializer2, typeDescription2, inDefinedShape2, typeDescription4, list7, list8, z10, z11, z13, typeDescription5, Collections.emptyList());
        }

        public WithFlexibleName withNestMembers(TypeList typeList) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, TargetType.DESCRIPTION, CompoundList.of(this.nestMembers, (List<? extends TypeDescription>) typeList));
        }

        public WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList typeList) {
            List<? extends TypeDescription> list;
            List<S> list2 = typeList;
            String str = this.name;
            int i10 = this.modifiers;
            TypeDescription.Generic generic = this.superClass;
            List<? extends TypeVariableToken> list3 = this.typeVariables;
            List<? extends TypeDescription.Generic> list4 = this.interfaceTypes;
            List<? extends FieldDescription.Token> list5 = this.fieldTokens;
            Map<String, Object> map = this.auxiliaryFields;
            List<? extends MethodDescription.Token> list6 = this.methodTokens;
            List<? extends RecordComponentDescription.Token> list7 = this.recordComponentTokens;
            List<? extends AnnotationDescription> list8 = this.annotationDescriptions;
            TypeInitializer typeInitializer2 = this.typeInitializer;
            LoadedTypeInitializer loadedTypeInitializer2 = this.loadedTypeInitializer;
            TypeDescription typeDescription = this.declaringType;
            MethodDescription.InDefinedShape inDefinedShape = this.enclosingMethod;
            TypeDescription typeDescription2 = this.enclosingType;
            List<? extends TypeDescription> list9 = this.declaredTypes;
            if (!(list2 == null || (list = this.permittedSubclasses) == null)) {
                list2 = CompoundList.of(list, (List<? extends TypeDescription>) list2);
            }
            return new Default(str, i10, generic, list3, list4, list5, map, list6, list7, list8, typeInitializer2, loadedTypeInitializer2, typeDescription, inDefinedShape, typeDescription2, list9, list2, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withRecord(boolean z10) {
            List<? extends RecordComponentDescription.Token> list;
            String str = this.name;
            int i10 = this.modifiers;
            TypeDescription.Generic generic = this.superClass;
            List<? extends TypeVariableToken> list2 = this.typeVariables;
            List<? extends TypeDescription.Generic> list3 = this.interfaceTypes;
            List<? extends FieldDescription.Token> list4 = this.fieldTokens;
            Map<String, Object> map = this.auxiliaryFields;
            List<? extends MethodDescription.Token> list5 = this.methodTokens;
            if (z10) {
                list = this.recordComponentTokens;
            } else {
                list = Collections.emptyList();
            }
            return new Default(str, i10, generic, list2, list3, list4, map, list5, list, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, z10, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withRecordComponent(RecordComponentDescription.Token token) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, CompoundList.of(this.recordComponentTokens, token.accept((TypeDescription.Generic.Visitor) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, true, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withTypeVariable(TypeVariableToken typeVariableToken) {
            return new Default(this.name, this.modifiers, this.superClass, CompoundList.of(this.typeVariables, typeVariableToken.accept((TypeDescription.Generic.Visitor) TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(this))), this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer, this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        public WithFlexibleName withInitializer(LoadedTypeInitializer loadedTypeInitializer2) {
            String str = this.name;
            int i10 = this.modifiers;
            TypeDescription.Generic generic = this.superClass;
            List<? extends TypeVariableToken> list = this.typeVariables;
            List<? extends TypeDescription.Generic> list2 = this.interfaceTypes;
            List<? extends FieldDescription.Token> list3 = this.fieldTokens;
            Map<String, Object> map = this.auxiliaryFields;
            List<? extends MethodDescription.Token> list4 = this.methodTokens;
            List<? extends RecordComponentDescription.Token> list5 = this.recordComponentTokens;
            List<? extends AnnotationDescription> list6 = this.annotationDescriptions;
            TypeInitializer typeInitializer2 = this.typeInitializer;
            LoadedTypeInitializer.Compound compound = r14;
            LoadedTypeInitializer.Compound compound2 = new LoadedTypeInitializer.Compound(this.loadedTypeInitializer, loadedTypeInitializer2);
            return new Default(str, i10, generic, list, list2, list3, map, list4, list5, list6, typeInitializer2, compound, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }

        private static boolean isValidIdentifier(String str) {
            if (KEYWORDS.contains(str) || str.length() == 0 || !Character.isJavaIdentifierStart(str.charAt(0))) {
                return false;
            }
            if (str.equals(PackageDescription.PACKAGE_CLASS_NAME)) {
                return true;
            }
            for (int i10 = 1; i10 < str.length(); i10++) {
                if (!Character.isJavaIdentifierPart(str.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }

        public WithFlexibleName withInitializer(ByteCodeAppender byteCodeAppender) {
            return new Default(this.name, this.modifiers, this.superClass, this.typeVariables, this.interfaceTypes, this.fieldTokens, this.auxiliaryFields, this.methodTokens, this.recordComponentTokens, this.annotationDescriptions, this.typeInitializer.expandWith(byteCodeAppender), this.loadedTypeInitializer, this.declaringType, this.enclosingMethod, this.enclosingType, this.declaredTypes, this.permittedSubclasses, this.anonymousClass, this.localClass, this.record, this.nestHost, this.nestMembers);
        }
    }

    public interface Factory {

        public enum Default implements Factory {
            MODIFIABLE {
                public WithFlexibleName represent(TypeDescription typeDescription) {
                    TypeList typeList;
                    TypeDescription typeDescription2;
                    TypeDescription typeDescription3;
                    List list;
                    String name = typeDescription.getName();
                    int modifiers = typeDescription.getModifiers();
                    TypeDescription.Generic superClass = typeDescription.getSuperClass();
                    ByteCodeElement.Token.TokenList<TypeVariableToken> asTokenList = typeDescription.getTypeVariables().asTokenList(ElementMatchers.is((Object) typeDescription));
                    TypeList.Generic accept = typeDescription.getInterfaces().accept(TypeDescription.Generic.Visitor.Substitutor.ForDetachment.of(typeDescription));
                    ByteCodeElement.Token.TokenList<FieldDescription.Token> asTokenList2 = typeDescription.getDeclaredFields().asTokenList(ElementMatchers.is((Object) typeDescription));
                    Map emptyMap = Collections.emptyMap();
                    ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList3 = typeDescription.getDeclaredMethods().asTokenList(ElementMatchers.is((Object) typeDescription));
                    ByteCodeElement.Token.TokenList<RecordComponentDescription.Token> asTokenList4 = typeDescription.getRecordComponents().asTokenList(ElementMatchers.is((Object) typeDescription));
                    AnnotationList declaredAnnotations = typeDescription.getDeclaredAnnotations();
                    TypeInitializer.None none = TypeInitializer.None.INSTANCE;
                    LoadedTypeInitializer.NoOp noOp = LoadedTypeInitializer.NoOp.INSTANCE;
                    TypeDescription declaringType = typeDescription.getDeclaringType();
                    MethodDescription.InDefinedShape enclosingMethod = typeDescription.getEnclosingMethod();
                    TypeDescription enclosingType = typeDescription.getEnclosingType();
                    TypeList declaredTypes = typeDescription.getDeclaredTypes();
                    if (typeDescription.isSealed()) {
                        typeList = typeDescription.getPermittedSubtypes();
                    } else {
                        typeList = TypeList.UNDEFINED;
                    }
                    TypeList typeList2 = typeList;
                    boolean isAnonymousType = typeDescription.isAnonymousType();
                    boolean isLocalType = typeDescription.isLocalType();
                    boolean isRecord = typeDescription.isRecord();
                    if (typeDescription.isNestHost()) {
                        typeDescription2 = TargetType.DESCRIPTION;
                    } else {
                        typeDescription2 = typeDescription.getNestHost();
                    }
                    TypeDescription typeDescription4 = typeDescription2;
                    if (typeDescription.isNestHost()) {
                        typeDescription3 = enclosingType;
                        list = typeDescription.getNestMembers().filter(ElementMatchers.not(ElementMatchers.is((Object) typeDescription)));
                    } else {
                        typeDescription3 = enclosingType;
                        list = Collections.emptyList();
                    }
                    return new Default(name, modifiers, superClass, asTokenList, accept, asTokenList2, emptyMap, asTokenList3, asTokenList4, declaredAnnotations, none, noOp, declaringType, enclosingMethod, typeDescription3, declaredTypes, typeList2, isAnonymousType, isLocalType, isRecord, typeDescription4, list);
                }
            },
            FROZEN {
                public WithFlexibleName represent(TypeDescription typeDescription) {
                    return new Frozen(typeDescription, LoadedTypeInitializer.NoOp.INSTANCE);
                }
            };

            public WithFlexibleName subclass(String str, int i10, TypeDescription.Generic generic) {
                List emptyList = Collections.emptyList();
                List emptyList2 = Collections.emptyList();
                List emptyList3 = Collections.emptyList();
                Map emptyMap = Collections.emptyMap();
                List emptyList4 = Collections.emptyList();
                List emptyList5 = Collections.emptyList();
                List emptyList6 = Collections.emptyList();
                TypeInitializer.None none = TypeInitializer.None.INSTANCE;
                LoadedTypeInitializer.NoOp noOp = LoadedTypeInitializer.NoOp.INSTANCE;
                TypeDescription typeDescription = TypeDescription.UNDEFINED;
                return new Default(str, i10, generic, emptyList, emptyList2, emptyList3, emptyMap, emptyList4, emptyList5, emptyList6, none, noOp, typeDescription, MethodDescription.UNDEFINED, typeDescription, Collections.emptyList(), TypeList.UNDEFINED, false, false, false, TargetType.DESCRIPTION, Collections.emptyList());
            }
        }

        WithFlexibleName represent(TypeDescription typeDescription);

        WithFlexibleName subclass(String str, int i10, TypeDescription.Generic generic);
    }

    public static class Frozen extends TypeDescription.AbstractBase.OfSimpleType implements WithFlexibleName {
        private final LoadedTypeInitializer loadedTypeInitializer;
        private final TypeDescription typeDescription;

        protected Frozen(TypeDescription typeDescription2, LoadedTypeInitializer loadedTypeInitializer2) {
            this.typeDescription = typeDescription2;
            this.loadedTypeInitializer = loadedTypeInitializer2;
        }

        public int getActualModifiers(boolean z10) {
            return this.typeDescription.getActualModifiers(z10);
        }

        @MaybeNull
        public ClassFileVersion getClassFileVersion() {
            return this.typeDescription.getClassFileVersion();
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.typeDescription.getDeclaredAnnotations();
        }

        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return this.typeDescription.getDeclaredFields();
        }

        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return this.typeDescription.getDeclaredMethods();
        }

        public TypeList getDeclaredTypes() {
            return this.typeDescription.getDeclaredTypes();
        }

        @MaybeNull
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return this.typeDescription.getEnclosingMethod();
        }

        @MaybeNull
        public TypeDescription getEnclosingType() {
            return this.typeDescription.getEnclosingType();
        }

        @MaybeNull
        public String getGenericSignature() {
            return this.typeDescription.getGenericSignature();
        }

        public TypeList.Generic getInterfaces() {
            return this.typeDescription.getInterfaces();
        }

        public LoadedTypeInitializer getLoadedTypeInitializer() {
            return this.loadedTypeInitializer;
        }

        public int getModifiers() {
            return this.typeDescription.getModifiers();
        }

        public String getName() {
            return this.typeDescription.getName();
        }

        public TypeDescription getNestHost() {
            return this.typeDescription.getNestHost();
        }

        public TypeList getNestMembers() {
            return this.typeDescription.getNestMembers();
        }

        @MaybeNull
        public PackageDescription getPackage() {
            return this.typeDescription.getPackage();
        }

        public TypeList getPermittedSubtypes() {
            return this.typeDescription.getPermittedSubtypes();
        }

        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return this.typeDescription.getRecordComponents();
        }

        @MaybeNull
        public TypeDescription.Generic getSuperClass() {
            return this.typeDescription.getSuperClass();
        }

        public TypeInitializer getTypeInitializer() {
            return TypeInitializer.None.INSTANCE;
        }

        public TypeList.Generic getTypeVariables() {
            return this.typeDescription.getTypeVariables();
        }

        public boolean isAnonymousType() {
            return this.typeDescription.isAnonymousType();
        }

        public boolean isLocalType() {
            return this.typeDescription.isLocalType();
        }

        public boolean isRecord() {
            return this.typeDescription.isRecord();
        }

        public boolean isSealed() {
            return this.typeDescription.isSealed();
        }

        public TypeDescription validated() {
            return this.typeDescription;
        }

        public WithFlexibleName withName(String str) {
            throw new IllegalStateException("Cannot change name of frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer) {
            throw new IllegalStateException("Cannot add type variables of frozen type: " + this.typeDescription);
        }

        @MaybeNull
        public TypeDescription getDeclaringType() {
            return this.typeDescription.getDeclaringType();
        }

        public WithFlexibleName withAnnotations(List<? extends AnnotationDescription> list) {
            throw new IllegalStateException("Cannot add annotation to frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withAnonymousClass(boolean z10) {
            throw new IllegalStateException("Cannot define anonymous class state for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withAuxiliaryField(FieldDescription.Token token, Object obj) {
            throw new IllegalStateException("Cannot define auxiliary field for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withDeclaredTypes(TypeList typeList) {
            throw new IllegalStateException("Cannot add declared types to frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withDeclaringType(@MaybeNull TypeDescription typeDescription2) {
            throw new IllegalStateException("Cannot add declaring type to frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape inDefinedShape) {
            throw new IllegalStateException("Cannot set enclosing method of frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withEnclosingType(@MaybeNull TypeDescription typeDescription2) {
            throw new IllegalStateException("Cannot set enclosing type of frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withField(FieldDescription.Token token) {
            throw new IllegalStateException("Cannot define field for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withInterfaces(TypeList.Generic generic) {
            throw new IllegalStateException("Cannot add interfaces for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withLocalClass(boolean z10) {
            throw new IllegalStateException("Cannot define local class state for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withMethod(MethodDescription.Token token) {
            throw new IllegalStateException("Cannot define method for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withModifiers(int i10) {
            throw new IllegalStateException("Cannot change modifiers for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withNestHost(TypeDescription typeDescription2) {
            throw new IllegalStateException("Cannot set nest host of frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withNestMembers(TypeList typeList) {
            throw new IllegalStateException("Cannot add nest members to frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList typeList) {
            throw new IllegalStateException("Cannot add permitted subclasses to frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withRecord(boolean z10) {
            throw new IllegalStateException("Cannot define record state for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withRecordComponent(RecordComponentDescription.Token token) {
            throw new IllegalStateException("Cannot define record component for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withTypeVariable(TypeVariableToken typeVariableToken) {
            throw new IllegalStateException("Cannot define type variable for frozen type: " + this.typeDescription);
        }

        public WithFlexibleName withInitializer(LoadedTypeInitializer loadedTypeInitializer2) {
            return new Frozen(this.typeDescription, new LoadedTypeInitializer.Compound(this.loadedTypeInitializer, loadedTypeInitializer2));
        }

        public WithFlexibleName withInitializer(ByteCodeAppender byteCodeAppender) {
            throw new IllegalStateException("Cannot add initializer to frozen type: " + this.typeDescription);
        }
    }

    public interface Prepareable {

        public enum NoOp implements Prepareable {
            INSTANCE;

            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        }

        InstrumentedType prepare(InstrumentedType instrumentedType);
    }

    public interface WithFlexibleName extends InstrumentedType {
        WithFlexibleName withAnnotations(List<? extends AnnotationDescription> list);

        WithFlexibleName withAnonymousClass(boolean z10);

        WithFlexibleName withAuxiliaryField(FieldDescription.Token token, Object obj);

        WithFlexibleName withDeclaredTypes(TypeList typeList);

        WithFlexibleName withDeclaringType(@MaybeNull TypeDescription typeDescription);

        WithFlexibleName withEnclosingMethod(MethodDescription.InDefinedShape inDefinedShape);

        WithFlexibleName withEnclosingType(@MaybeNull TypeDescription typeDescription);

        WithFlexibleName withField(FieldDescription.Token token);

        WithFlexibleName withInitializer(LoadedTypeInitializer loadedTypeInitializer);

        WithFlexibleName withInitializer(ByteCodeAppender byteCodeAppender);

        WithFlexibleName withInterfaces(TypeList.Generic generic);

        WithFlexibleName withLocalClass(boolean z10);

        WithFlexibleName withMethod(MethodDescription.Token token);

        WithFlexibleName withModifiers(int i10);

        WithFlexibleName withName(String str);

        WithFlexibleName withNestHost(TypeDescription typeDescription);

        WithFlexibleName withNestMembers(TypeList typeList);

        WithFlexibleName withPermittedSubclasses(@MaybeNull TypeList typeList);

        WithFlexibleName withRecord(boolean z10);

        WithFlexibleName withRecordComponent(RecordComponentDescription.Token token);

        WithFlexibleName withTypeVariable(TypeVariableToken typeVariableToken);

        WithFlexibleName withTypeVariables(ElementMatcher<? super TypeDescription.Generic> elementMatcher, Transformer<TypeVariableToken> transformer);
    }

    LoadedTypeInitializer getLoadedTypeInitializer();

    TypeInitializer getTypeInitializer();

    TypeDescription validated();

    InstrumentedType withAnnotations(List<? extends AnnotationDescription> list);

    InstrumentedType withAnonymousClass(boolean z10);

    InstrumentedType withAuxiliaryField(FieldDescription.Token token, Object obj);

    InstrumentedType withDeclaredTypes(TypeList typeList);

    InstrumentedType withDeclaringType(@MaybeNull TypeDescription typeDescription);

    InstrumentedType withEnclosingMethod(MethodDescription.InDefinedShape inDefinedShape);

    InstrumentedType withEnclosingType(TypeDescription typeDescription);

    InstrumentedType withField(FieldDescription.Token token);

    InstrumentedType withInitializer(LoadedTypeInitializer loadedTypeInitializer);

    InstrumentedType withInitializer(ByteCodeAppender byteCodeAppender);

    InstrumentedType withInterfaces(TypeList.Generic generic);

    InstrumentedType withLocalClass(boolean z10);

    InstrumentedType withMethod(MethodDescription.Token token);

    InstrumentedType withModifiers(int i10);

    InstrumentedType withNestHost(TypeDescription typeDescription);

    InstrumentedType withNestMembers(TypeList typeList);

    InstrumentedType withPermittedSubclasses(@MaybeNull TypeList typeList);

    InstrumentedType withRecord(boolean z10);

    InstrumentedType withRecordComponent(RecordComponentDescription.Token token);

    InstrumentedType withTypeVariable(TypeVariableToken typeVariableToken);
}
