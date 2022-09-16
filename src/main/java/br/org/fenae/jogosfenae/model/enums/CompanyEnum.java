package br.org.fenae.jogosfenae.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CompanyEnum {

    APCEF_AC ("APCEF/AC"), APCEF_AL ("APCEF/AL"), APCEF_AM ("APCEF/AM"), APCEF_AP ("APCEF/AP"), APCEF_BA ("APCEF/BA"),
    APCEF_CE ("APCEF/CE"), APCEF_DF ("APCEF/DF"), APCEF_ES ("APCEF/ES"), APCEF_GO ("APCEF/GO"), APCEF_MA ("APCEF/MA"),
    APCEF_MG ("APCEF/MG"), APCEF_MS ("APCEF/MS"), APCEF_MT ("APCEF/MT"), APCEF_PA ("APCEF/PA"), APCEF_PB ("APCEF/PB"),
    APCEF_PE ("APCEF/PE"), APCEF_PI ("APCEF/PI"), APCEF_PR ("APCEF/PR"), APCEF_RJ ("APCEF/RJ"), APCEF_RN ("APCEF/RN"),
    APCEF_RO ("APCEF/RO"), APCEF_RR ("APCEF/RR"), APCEF_RS ("APCEF/RS"), APCEF_SC ("APCEF/SC"), APCEF_SE ("APCEF/SE"),
    APCEF_SP ("APCEF/SP"), APCEF_TO ("APCEF/TO"), FENAE ("FENAE");

    private String company;

    CompanyEnum(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    @JsonCreator
    public static String toString(String name){
        if(name == null)
            return null;

        for (CompanyEnum locatedCompany : CompanyEnum.values()){
            if(name.equals(locatedCompany.getCompany()))
                return locatedCompany.company;
        }

        throw new IllegalArgumentException("Apcef ou Fenae inválido: " + name);
    }

}
