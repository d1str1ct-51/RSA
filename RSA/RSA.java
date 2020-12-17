import java.math.BigInteger;
import java.util.Random;

public class RSA{

    private BigInteger p;
    private BigInteger q;
    private static BigInteger n;
    private BigInteger euler;
    private static BigInteger e;
    private static BigInteger d;
    private Random rnd;
    private int bitLength = 512;

    public RSA() {
        rnd = new Random();
        // Создать два случайных простых числа
        p = BigInteger.probablePrime(bitLength, rnd);
        q = BigInteger.probablePrime(bitLength, rnd);
        // Произведение p, q.
        n = p.multiply(q);
        // Функция Эйлера
        euler = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        // Открытая экспонента
        e = BigInteger.probablePrime(64, rnd);
        // Секретная экспонента = инверсия ф. Эйлера
        d = e.modInverse(euler);

    }
    // Открытая экспонента ^ производная 
    public byte[] encrypt(byte[] text) {
        return ((new BigInteger(text)).modPow(e, n).toByteArray());
    }
    // Закрытая экспонента ^ производная 
    public byte[] decrypt(byte[] text) {
        return (new BigInteger(text)).modPow(d, n).toByteArray();
    }
}