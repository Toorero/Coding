public class BinaryJ {

    static String crypt(String s, String key) {
        final int keyi = Integer.parseInt(key, 2);
        return new String(s.chars().map(c -> c ^ keyi).toArray(), 0, s.length());
    }

}
