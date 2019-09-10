package com.esshva.tests;

import com.esshva.pageObjects.EsshvaHomePage;
import com.esshva.utility.Log;
import com.esshva.utility.SingletonClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EsshvaHomePageTest {

    @Test (priority=1)
    public void AboutUsNavigation() throws Exception {
        Log.info("Esshva Techq About Us > Navigate to About Us page");
        Assert.assertTrue(EsshvaHomePage.getInstance().isAboutUsPresent());
        EsshvaHomePage.getInstance().NavigatestoAboutUs();

    }

    @Test (priority=2)
    public void EsshvaHomeNavigation() throws Exception {
        Log.info("Esshva Techq Home Page navigation > Navigate to Home Page");
        EsshvaHomePage.getInstance().NavigatesbacktoHome();

    }

    @Test (priority=3)
    public void theMagicTouchNavigation() throws Exception {
        Assert.assertTrue(EsshvaHomePage.getInstance().theMagicTouchPresent());
        Log.info("Esshva Techq The Magic Touch > Navigate to Creative Software Skills Page");
        EsshvaHomePage.getInstance().NavigatestoTheMagicTouch();

//        String ActualLabel;
//        ActualLabel = EsshvaHomePage.getInstance().getText(SingletonClass.getInstance().getPfez().ourSkillsMicro);
//        EsshvaHomePage.getInstance().ourSkillsDescription(ActualLabel,SingletonClass.getUiPropExpectedresults("SkillsDescriptionMicro"));

    }

}
