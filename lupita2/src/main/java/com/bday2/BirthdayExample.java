package com.bday2;

import java.io.*;
import java.security.KeyStore.Entry;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class BirthdayExample {
  /*
   * Step 1 read JSON file
   * Step 2 Put Array into HashMap
   * Step 3 Scan HashMap and Retu return birthday
   */
  //
  // Func: ReadJSONFile
  // Desc: Reads a json file storing an array and returns an object
  // that can be iterated over
  //
  public static JSONArray readJSONArrayFile(String fileName) {
    //
    // read the birthday.json file and iterate over it
    //

    // JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();

    JSONArray birthdayList = null;

    try (FileReader reader = new FileReader(fileName)) {
      // Read JSON file
      Object obj = jsonParser.parse(reader);

      birthdayList = (JSONArray) obj;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return birthdayList;
  }

  public static void main(final String[] args) {

    //
    // how to read user input from keyboard
    //
    System.out.println("Reading user input into a string");

    // get user input
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a name:");
    String name = input.nextLine();

    // close the scanner
    input.close();

    // reads a json data file
    //
    String pathToFile = "C:/Users/palme/OneDrive/Documents/GitHub/class-cis-084-java/Lupitas-Birthday-Look-Up2/.vscode/birthday.json";

    JSONArray jsonData = readJSONArrayFile(pathToFile);

    // loop over list
    String birthday;
    String bname;
    JSONObject obj;
    // Create a HashMap
    Map<String, String> hashMap = new HashMap<String, String>();
    // Pushing array into HashMap
    for (Integer i = 0; i < jsonData.size(); i++) {
      // parse the object and pull out the name and birthday
      obj = (JSONObject) jsonData.get(i);
      bname = (String) obj.get("name");
      birthday = (String) obj.get("birthday");

      hashMap.put(name, birthday);

      if (bname.contains(name)) {
        System.out.println("Name: " + bname);
        System.out.println("Birthday: " + birthday);
      }

    }

    // System.out.println("Birthday= " + name);

    // System.out.println(hashMap);

    // System.out.println("Birthday= " + hashMap.get(name));

    // for(String key : hashMap.keySet()){
    // System.out.println(key);
    // }
    // for(String values : hashMap.values());
  }
}
