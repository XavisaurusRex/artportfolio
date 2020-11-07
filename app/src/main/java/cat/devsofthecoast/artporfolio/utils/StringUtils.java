package cat.devsofthecoast.artporfolio.utils;
public class StringUtils {
    private String insult = "Fucking Idiot";

    public String insultMe() {
        return insult;
    }

    public void changeInsult() {
        insult += ", additional Fucking Idiot";
    }
}
