package tests;

import org.junit.Assert;
import org.junit.Test;

public class C09_Assertions {
    /*
    Bize verilen gorevde birden fazla assertion varsa tek bir test methoduyla yapmak
    akıllıca degildir. Tek biri hata verirse diger methodları yapma calısmayı durdurur.
    Ama ayrı test methodları altında yaptıgımızda tum programı calıstırır hata olanları raporlar ve testler
    bitinceye kadar calısmaya devam eder
     */
    @Test
    public void test02(){
        //emeklilik yası 65 olsun
        //70 yasındaki bir kisinin emekli olabildigini test edin
        int yas = 70;
        Assert.assertTrue(yas>65);//test passed

        String actualURL = "https://testotomasyonu.com/";
        //Url in 'testotomasyonu' icerdigini test edin
        Assert.assertTrue(actualURL.contains("testotomasyonu"));//Passed

        //Url'in 'wisequarter' icermedigini test edin
        Assert.assertFalse(actualURL.contains("wisequarter")); //passed

        //Url'in "https://testotomasyonu.com/" oldugunu test edin
        Assert.assertEquals("https://testotomasyonu.com/",actualURL); //Passed
        Assert.assertTrue("https://testotomasyonu.com/".equals(actualURL));//Passed () assertequals ile yazsak daha iyi olur
        //Url'in "https://www.testotomasyonu.com/" olmadıgını test edin
        Assert.assertNotEquals("https://www.testotomasyonu.com/",actualURL);//Passed
        Assert.assertFalse("https://www.testotomasyonu.com/".equals(actualURL));//Passed

        String str1 ="Ali", str2= "ALI";
        Assert.assertTrue(str1.equalsIgnoreCase(str2)); //passed
        Assert.assertFalse(str1.equals(str2)); //passed


        int sayi1 = 20;
        int sayi2 = 30;
        Assert.assertTrue(sayi1>sayi2);//failed verdi
        System.out.println("assertion fail verirse bu satır calısmaz ve exception fırlatır");
        Assert.assertFalse(sayi1>sayi2); // yukardaki fail oldugu icin bu da calısmaz

    }

}
