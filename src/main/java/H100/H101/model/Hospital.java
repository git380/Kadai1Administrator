package H100.H101.model;

public class Hospital {
    private final String tabyouinid;
    private final String tabyouinmei;
    private final String tabyouinaddres;
    private final String tabyouintel;
    private final int tabyouinshihonkin;
    private final int kyukyu;

    public Hospital(String tabyouinid, String tabyouinmei, String tabyouinaddres, String tabyouintel, int tabyouinshihonkin, int kyukyu) {
        this.tabyouinid = tabyouinid;
        this.tabyouinmei = tabyouinmei;
        this.tabyouinaddres = tabyouinaddres;
        this.tabyouintel = tabyouintel;
        this.tabyouinshihonkin = tabyouinshihonkin;
        this.kyukyu = kyukyu;
    }

    public String getTabyouinid() {
        return tabyouinid;
    }

    public String getTabyouinmei() {
        return tabyouinmei;
    }

    public String getTabyouinaddres() {
        return tabyouinaddres;
    }

    public String getTabyouintel() {
        return tabyouintel;
    }

    public int getTabyouinshihonkin() {
        return tabyouinshihonkin;
    }

    public int getKyukyu() {
        return kyukyu;
    }
}
