


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CustomCollection {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        boolean enterAgain = true;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Enter Key:");
            String key = scan.nextLine();
            Set<String> keySet = map.keySet();
            if(keySet.contains(key)) {
                System.out.println("Key :" + key + " is already present");
            }else {
                System.out.print("Enter Value:");
                String value = scan.nextLine();
                map.put(key, value);

                // ask user to check if another entry is required
                System.out.print("Enter another Key,Value (y/n)?");
                String answer = scan.nextLine();

                // condition to satisfy in order to loop again
                if (answer.equals("y") || answer.equals("Y")) {
                    continue;
                } else {
                    break;
                }
            }
        } while (enterAgain);

        System.out.println("\n**********************************");
        System.out.println(" ****  Default Map ****");
        iterateMap(map);
        Map<String, String> ascendingOrderMap = retrieveAscendingOrderMap(map);
        System.out.println(" ****  Ascending Order Map ****");
        iterateMap(ascendingOrderMap);
        Map<String, String> decendingOrderMap = retrieveDescendingOrderMap(map);
        System.out.println(" ****  Decending Order Map ****");
        iterateMap(decendingOrderMap);
        System.out.println("\n**********************************");


        boolean enterKeyAgain = true;
        do {
            System.out.print("Enter Key to search :");
            String key = scan.nextLine();
            searchValue(key,map);


            // ask user to check if another entry is required
            System.out.print("Do you wish to continue (y/n)?");
            String answer = scan.nextLine();

            // condition to satisfy in order to loop again
            if (answer.equals("y") || answer.equals("Y")) {
                continue;
            } else {
                break;
            }

        } while (enterKeyAgain);
        scan.close();
    }


    private static void searchValue(String key, Map<String, String> map) {
        Set<String> keySet = map.keySet();
        if(!keySet.contains(key)) {
            System.out.println("Key doesn't exist");
        }else {
            System.out.println("Value for entered key : "+map.get(key));
        }
    }


    /**
     * @param map
     *            Method is used to iterate and print the map
     */
    private static void iterateMap(Map<String, String> map) {

        /**
         * With Java 7
         */
        /*for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " :  Value : " + entry.getValue());
        }*/


        /**
         * With Java 8
         */

        map.forEach( (k,v) -> System.out.println("Key: " + k + ": Value: " + v));

        /**
         * OR
         *
         * Java 8 using stream
         */
        // map.entrySet().stream().forEach((m) -> {
        //      System.out.println("Key: " + m.getKey() + ", Value:" + m.getValue());
        //    });

        /**
         * OR
         *
         * Java 8 using parallel stream
         */
        // map.entrySet().stream().parallel().forEach((entry) -> {
        //      System.out.println("Key: " + entry.getKey() + ", Value:"  + entry.getValue());
        //    });
    }

    /**
     * Method use tree map to sort the key
     *
     * @param map
     * @return
     */
    private static Map<String, String> retrieveAscendingOrderMap(Map<String, String> map) {
        //
        return new TreeMap<String, String>(map);
    }

    /**
     * Method use tree map having Collections.reverseOrder() in constructor to sort
     * the key
     *
     * @param map
     * @return
     */
    private static Map<String, String> retrieveDescendingOrderMap(Map<String, String> map) {
        Map<String, String> decendingOrderMap = new TreeMap<String, String>(Collections.reverseOrder());
        decendingOrderMap.putAll(map);

        return decendingOrderMap;
    }

}


