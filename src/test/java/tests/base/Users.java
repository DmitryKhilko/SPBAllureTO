package tests.base;

import org.testng.ITestContext;
import pages.base.BasePage;
import utils.PropertyReader;

public class Users {

    public static final String superuserLogin = System.getenv().getOrDefault("SPB_SUPERUSERLOGIN", PropertyReader.getProperty("spb.superuserLogin")); //команда, берущая значение для переменной или для настроек CI (SPB_SUPERUSERLOGIN) из настройки spb.superuserLogin файла config.properties;
    public static final String superuserPassword = System.getenv().getOrDefault("SPB_SUPERUSERPASSWORD", PropertyReader.getProperty("spb.superuserPassword"));
    //public static final String superuserName = System.getenv().getOrDefault("SPB_SUPERUSERNAME", PropertyReader.getProperty("spb.superuserName"));
    public static final String superuserName = "Хилько Т.Ю.";

    public static final String adminLogin = System.getenv().getOrDefault("SPB_ADMINLOGIN", PropertyReader.getProperty("spb.adminLogin"));
    public static final String adminPassword = System.getenv().getOrDefault("SPB_ADMINPASSWORD", PropertyReader.getProperty("spb.adminPassword"));
    //public static final String adminName = System.getenv().getOrDefault("SPB_ADMINNAME", PropertyReader.getProperty("spb.adminName"));
    public static final String adminName = "Петров П.П.";

    public static final String specialistMinfinLogin = System.getenv().getOrDefault("SPB_SPECIALISTMINFINLOGIN", PropertyReader.getProperty("spb.specialistMinfinLogin"));
    public static final String specialistMinfinPassword = System.getenv().getOrDefault("SPB_SPECIALISTMINFINPASSWORD", PropertyReader.getProperty("spb.specialistMinfinPassword"));
    //public static final String specialistMinfinName = System.getenv().getOrDefault("SPB_SPECIALISTMINFINNAME", PropertyReader.getProperty("spb.specialistMinfinName"));
    public static final String specialistMinfinName = "Самохина И.В.";

    public static final String secretaryCommissionLogin = System.getenv().getOrDefault("SPB_SECRETARYCOMMISSIONLOGIN", PropertyReader.getProperty("spb.secretaryCommissionLogin"));
    public static final String secretaryCommissionPassword = System.getenv().getOrDefault("SPB_SECRETARYCOMMISSIONPASSWORD", PropertyReader.getProperty("spb.secretaryCommissionPassword"));
    //public static final String secretaryCommissionName = System.getenv().getOrDefault("SPB_SECRETARYCOMMISSIONNAME", PropertyReader.getProperty("spb.secretaryCommissionName"));
    public static final String secretaryCommissionName = "Свиридова Н.И.";

    public static final String memberCommissionLogin = System.getenv().getOrDefault("SPB_MEMBERCOMMISSIONLOGIN", PropertyReader.getProperty("spb.memberCommissionLogin"));
    public static final String memberCommissionPassword = System.getenv().getOrDefault("SPB_MEMBERCOMMISSIONPASSWORD", PropertyReader.getProperty("spb.memberCommissionPassword"));
    //public static final String memberCommissionName = System.getenv().getOrDefault("SPB_MEMBERCOMMISSIONNAME", PropertyReader.getProperty("spb.memberCommissionName"));
    public static final String memberCommissionName = "Савина Т.Н.";

    public static final String employeeTCMinfinLogin = System.getenv().getOrDefault("SPB_EMPLOYEETCMINFINLOGIN", PropertyReader.getProperty("spb.employeeTCMinfinLogin"));
    public static final String employeeTCMinfinPassword = System.getenv().getOrDefault("SPB_EMPLOYEETCMINFINPASSWORD", PropertyReader.getProperty("spb.employeeTCMinfinPassword"));
    //public static final String employeeTCMinfinName = System.getenv().getOrDefault("SPB_EMPLOYEETCMINFINNAME", PropertyReader.getProperty("spb.employeeTCMinfinName"));
    public static final String employeeTCMinfinName = "Соловьева Т.М.";

}
