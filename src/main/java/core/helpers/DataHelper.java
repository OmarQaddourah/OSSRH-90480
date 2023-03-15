package core.helpers;

import java.util.Random;

import static com.utils.PropReader.readConfig;
import static com.utils.readers.XMLFileReader.getElementTextByTagName;
import static core.base.GlobalValues.globalMap;

public class DataHelper {

    public static String getRandomString(String language, int vinLength) {
        String englishCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String arabicCharacters = "ابتثجحخدذرزسشصضطظعغفقكلمنهوي";
        StringBuilder salt = new StringBuilder();
        Random random = new Random();

        while (salt.length() < vinLength) {
            switch (language) {
                case "Arabic":
                    int arabicIndex = (int) (random.nextFloat() * arabicCharacters.length());
                    salt.append(arabicCharacters.charAt(arabicIndex));
                    break;
                case "English":
                    int englishIndex = (int) (random.nextFloat() * englishCharacters.length());
                    salt.append(englishCharacters.charAt(englishIndex));
                    break;
            }
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
        String dataFile = readConfig("readDataFile");
        return getElementTextByTagName(dataFile, testKey);
    }

    public static void setGlobalValue(String key, String value) {
        globalMap.put(key, value);
    }

    public static Object getGlobalValue(String key) {
        return globalMap.get(key);
    }
}
