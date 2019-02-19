import java.math.BigInteger;

public class Attack {

    public String attack(String msg){
        RSA rsa = new RSA(BigInteger.valueOf(524287),BigInteger.valueOf(6700417));
        rsa.calcKeys();
        return  (rsa.decryptMsg(msg));

    }
}
