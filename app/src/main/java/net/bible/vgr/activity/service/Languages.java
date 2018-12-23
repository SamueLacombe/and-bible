package net.bible.vgr.activity.service;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Locale;

public class Languages {

    public String defaultLanguageCode = "en";
    public static final String[] languagesCodeList = new String[] {"fr","en","pt","it"};
    public static final String[] languagesCodeVGRList = new String[] {"FRN","ENG","POR","ITL"};

    public Languages() {
    }

    //Validate if language Code is supported
    public Boolean isLanguageValid(String languageCode) {
        return ArrayUtils.contains( languagesCodeList, languageCode );
    }

    //Validate if VGR language Code is supported
    public Boolean isVGRLanguageValid(String languageVGRCode) {
        return ArrayUtils.contains( languagesCodeVGRList, languageVGRCode );
    }

    //Validate if language is supported.. if not return default.
    public String getBestDefaultLanguageCode(){
        String languageCode = Locale.getDefault().getLanguage();
        if(this.isLanguageValid(languageCode)){
            return languageCode;
        }
        else {
            return defaultLanguageCode;
        }
    }

    //Return corresponding language Code
    public String getCorrespondingLanguageCode(String languageVGRCode){
        for (int i = 0; (i < languagesCodeVGRList.length) ; i++) {
            if (languagesCodeVGRList[i].equals(languageVGRCode)) {
                return languagesCodeList[i];
            }
        }
        return null;
    }

    //Return corresponding VGR language Code
    public String getCorrespondingLanguagVGRCode(String languageCode){
        for (int i = 0; (i < languagesCodeList.length); i++) {
            if (languagesCodeList[i].equals(languageCode)) {
                return languagesCodeVGRList[i];
            }
        }
        return null;
    }

}
