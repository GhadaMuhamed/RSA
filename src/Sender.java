import java.math.BigInteger;

public class Sender {
BigInteger n;
Integer e;
public Sender(BigInteger a, Integer b){
    n=a;
    e=b;
}
    public String encryptMsg(String toBeEnc){
        String msg = new String();
        String res = "";
        for (int i=0;i<toBeEnc.length();++i){
            Integer tmp = (int)toBeEnc.charAt(i);
            String num_str = tmp.toString();
            //String tmp = num.toString();
            if (num_str.length() < 3)
                num_str += '0';
            //System.out.println(num);
            BigInteger num = new BigInteger(num_str);
            if ((new BigInteger(msg+num.toString())).compareTo(n) == 1){
                BigInteger bi = new BigInteger(msg);
                bi = bi.modPow(BigInteger.valueOf(e),n);
                res += bi.toString();
                res += '-';

                msg = num.toString();
            }else msg += num.toString();
        }

        BigInteger bi = new BigInteger(msg);
        bi = bi.modPow(BigInteger.valueOf(e),n);
        res += bi.toString();
        return res;
    }
}
