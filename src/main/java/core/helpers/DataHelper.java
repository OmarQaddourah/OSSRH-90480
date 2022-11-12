package core.helpers;

import core.base.BaseTest;

import java.security.SecureRandom;

import static com.utils.PropReader.readConfig;
import static com.utils.readers.XMLFileReader.getElementTextByTagName;

public class DataHelper extends BaseTest {

    public static String getRandString(int vinLength) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        SecureRandom random = new SecureRandom();
        while (salt.length() < vinLength) {
            int index = (int) (random.nextFloat() * chars.length());
            salt.append(chars.charAt(index));
        }
        return salt.toString();
    }

    public static String getRandArabicString(int vinLength) {
        String chars = "ابتثجحخدذرزسشصضطظعغفقكلمنهوي١٢٣٤٥٦٧٨٩٠";
        StringBuilder salt = new StringBuilder();
        SecureRandom random = new SecureRandom();
        while (salt.length() < vinLength) {
            int index = (int) (random.nextFloat() * chars.length());
            salt.append(chars.charAt(index));
        }
        return salt.toString();
    }

    public static int getRandNumber(int number) {
        int randomNumber = (int) Math.floor(Math.random() * number);
        if (randomNumber == 0) {
            return 1;
        }
        return randomNumber;
    }

    public static String getTestData(String testKey) {
        String dataFile = readConfig("datafile");
        return getElementTextByTagName(dataFile, testKey);
    }

    public static void setGlobalValue(String key, String value) {
        globalMap.put(key, value);
    }

    public static Object getGlobalValue(String key) {
        return globalMap.get(key);
    }
}
