package makotogu;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

public class MetaDataOutOfMemoryTest extends ClassLoader {
    // 测试元空间溢出
    public static void main(String[] args) {
        int j=0;
        try {
            MetaDataOutOfMemoryTest test = new MetaDataOutOfMemoryTest();
            for (int i=0; i<10000000; i++,j++){
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(Opcodes.V11,Opcodes.ACC_PUBLIC, "Class"+i, null,"java/lang/Object", null);
                byte[] code = classWriter.toByteArray();
                test.defineClass("Class"+i, code, 0, code.length);
            }
        } finally {
            System.out.println(j);
        }
    }


}
