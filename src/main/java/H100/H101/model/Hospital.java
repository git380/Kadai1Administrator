package H100.H101.model;

public class Hospital {
    private String tabyouinid;
    private String tabyouinmei;
    private String tabyouinaddres;
    private String tabyouintel;
    private int tabyouinshihonkin;
    private int kyukyu;

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
