package com.esshva.pageObjects;

import org.testng.Assert;

import com.esshva.utility.SingletonClass;

public class EsshvaHomePage extends BasePageObject{


        private static EsshvaHomePage esshvaHomePage;

        private EsshvaHomePage() {
        }

        public static EsshvaHomePage getInstance() {
            if (esshvaHomePage == null) {
                esshvaHomePage = new EsshvaHomePage();
            }
            return esshvaHomePage;
        }


        public Boolean isAboutUsPresent() throws Exception {
            return isDisplayed(SingletonClass.getInstance().getPfez().aboutUs, 10);
        }

        public void NavigatestoAboutUs()throws Exception{
            Thread.sleep(1000);
            uiClick(SingletonClass.getInstance().getPfez().aboutUs);
        }

        public void NavigatesbacktoHome()throws Exception{
            Thread.sleep(1000);
            uiClick(SingletonClass.getInstance().getPfez().esshvaImage);
        }

        public Boolean theMagicTouchPresent() throws Exception {
            return isDisplayed(SingletonClass.getInstance().getPfez().theMagicTouch, 10);

        }

        public void NavigatestoTheMagicTouch()throws Exception{
            Thread.sleep(1000);
            uiClick(SingletonClass.getInstance().getPfez().theMagicTouch);
        }

//        public void ourSkillsDescription (String ActualLabel, String ExpectedLabel) throws Exception {
//            Assert.assertEquals(ActualLabel, ExpectedLabel);
//
//            Thread.sleep(1000);

//        }


}
