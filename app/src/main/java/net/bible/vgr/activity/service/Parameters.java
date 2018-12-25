package net.bible.vgr.activity.service;

import android.content.Context;

import net.bible.vgr.activity.database.ParametersDBHandler;

import org.apache.commons.lang3.ArrayUtils;

public class Parameters {
    public static final String[] parametersList = new String[] {"InitialisedInd", "MenuLanguage", "MenuRedLetterDayInd","FullScreenInd",};
    Languages languages;

    public Parameters() {
    }

    public void initialiseParameters(Context context) {
        //define databaseHandler
        ParametersDBHandler dbParameterHandler = new ParametersDBHandler(context, null, null, 0);

        //if not already initialised than initialise all parameters
        if(!dbParameterHandler.isParameterPresent("InitialisedInd")) {
            setParameter(context,"InitialisedInd","1");
            setParameter(context,"MenuLanguage",languages.getBestDefaultLanguageCode());
            setParameter(context,"MenuRedLetterDay","1");
            setParameter(context,"MenuRedLetterDay","0");
        }
    }

    public void setParameter(Context context, String parameterName, String parameterValue) {

        //validate if parameter is valid (safety net for developers)
        try {
            if(!ArrayUtils.contains( parametersList, parameterName )) {
                throw new Exception("Parameter : " + parameterName + " is not part of the parameter list. Please update the list 'parametersList' in the class 'Parameters'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //define databaseHandler
        ParametersDBHandler dbParameterHandler = new ParametersDBHandler(context, null, null, 0);

        //if parameter is valid but is not yet created: lets create it. Otherwise update it.
        if(dbParameterHandler.isParameterPresent(parameterName)) {
            dbParameterHandler.updateParameter(parameterName,parameterValue);

            //TODO we will do a swtich case to handle when a paramater is updated for what ever update to be trigger on screen
        } else {
            dbParameterHandler.addParameter(parameterName,parameterValue);
        }
    }

    public String getParameterValue(Context context, String parameterName) {

        //validate if parameter is valid (safety net for developers)
        try {
            if(!ArrayUtils.contains( parametersList, parameterName )) {
                throw new Exception("Parameter : " + parameterName + " is not part of the parameter list. Please update the list 'parametersList' in the class 'Parameters'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //define databaseHandler
        ParametersDBHandler dbParameterHandler = new ParametersDBHandler(context, null, null, 0);

        //get parameter if in database otherwise return null
        if(dbParameterHandler.isParameterPresent(parameterName)) {
            return dbParameterHandler.getParameterValue(parameterName);
        } else {
            return null;
        }
    }

}
