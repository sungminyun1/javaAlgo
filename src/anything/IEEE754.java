package anything;

public class IEEE754 {
    public static void main(String[] args) {
        byte[] t = floatToByteArray(-36.4f);
        for(byte tt : t){
            System.out.println(String.format("%8s", Integer.toBinaryString(tt & 0xFF)).replace(' ', '0'));
        }
//        System.out.println(t);
    }
    public static byte[] floatToByteArray(float value) {
        int intBits =  Float.floatToIntBits(value);
        return new byte[] {
                (byte) (intBits >> 24),
                (byte) (intBits >> 16),
                (byte) (intBits >> 8),
                (byte) (intBits) };
    }
}
