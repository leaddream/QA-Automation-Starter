package com.esshva.utils.ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;
import java.text.SimpleDateFormat;
import java.util.Calendar;


//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"/ExtentReports/ExtentReportResults"+"_"+formater.format(calendar.getTime())+".html", true);
        }
        return extent;
    }
}
