package ascii;

public class AsciiCharSequence implements CharSequence {

    private final byte[] value;

    public AsciiCharSequence(byte[] value) {
        this.value = value;
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        return (char) value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(value, start, end));
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (byte c: value) {
            b.append((char) c);
        }
        return b.toString();
    }
}