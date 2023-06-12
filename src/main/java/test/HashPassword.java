package test;

import L100.L101.hash.SaltUserPassword;

public class HashPassword {
    public static void main(String[] args) {
        String id = "0000";
        String pw = "0000";
        System.out.println(new SaltUserPassword().getDigest(id,pw));
    }
}
