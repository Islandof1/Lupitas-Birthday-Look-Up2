package com.bday2;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class BirthdayExample {
  /*
   * Step 1 read JSON file
   * Step 2 as back up read JSON file from a file path on C drive.
   * Step 3 Loop throught Array and creat an objet and assign two key called
   * "name " && "birthday"
   * Step 4 Insert Keys and Values into a HashMap using the put.Method
   * Step 5 Make a scan and system.in function
   * Step 6 Enter a "name" and search HashMap for a value + birthday and value of
   * birthday
   * Step 7 Return bithday value.
   * 
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
    // reads a json data file
    //
    String pathToFile = "C:/Users/palme/OneDrive/Documents/GitHub/class-cis-084-java/Lupitas-Birthday-Look-Up2/.vscode/birthday.json";

    JSONArray jsonData = readJSONArrayFile(pathToFile);

    // loop over list
    String birthday;
    JSONObject obj;
    // Create a HashMap

    HashMap<String, String> hashMap = new HashMap<String, String>();
    //
    // how to read user input from keyboard
    //
    System.out.println("Reading user input into a string");

    // get user input
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a name:");
    String name = input.nextLine();

    // print user input
    System.out.println("name = " + name);

    // close the scanner
    input.close();

    // Pushing array into HashMap
    for (Integer i = 0; i < jsonData.size(); i++) {
      // parse the object and pull out the name and birthday
      obj = (JSONObject) jsonData.get(i);
      name = (String) obj.get("name");
      birthday = (String) obj.get("birthday");

      hashMap.put(name, birthday);
    }

    // Mapping
    String a = hashMap.get("Hazle Lesch");

    // Printing value for the corresponding key
    System.out.println("value for key" + " \"birthday\" is:- " + a);

  }
}
