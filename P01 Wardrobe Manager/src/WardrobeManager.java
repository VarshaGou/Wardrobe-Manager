//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Spring 2024
//
// Author:   Varsha Gouraram
// Email:    gouraram@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons:         PM Kate helped me with the logic formatting of my mostRecentlyWorn,
//                  removeClothingAtIndex, and removeAllUnworn methods
//
// Online Sources:  N/A
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class manages clothing in a wardrobe by keeping track of the description,
 * brand, and last worn date of each clothing item.
 */
public class WardrobeManager {
    /**
     * Checks whether the oversized array (wardrobe) has an element (clothing item)
     * that matches the description and brand provided.
     *
     * @param description  - String title of the clothing item
     * @param brand        - String brand name of clothing item
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return true if description/brand combination is present in the wardrobe
     * and false if the description/brand is not found
     */
    public static boolean containsClothing(String description, String brand,
                                           String[][] wardrobe, int wardrobeSize) {
        //The set of nested for loops parse through the oversize 2-D array
        for (int i = 0; i < wardrobeSize; i++) {
            for (int j = 0; j < wardrobeSize; j++) {
                //start with the index of clothing that stores a description and checks if
                //the description stored in the clothing and the corresponding brand String
                //matches the description and brand parameters respectively.
                if (j == 0) {
                    if (wardrobe[i][j].equalsIgnoreCase(description) &&
                            wardrobe[i][j + 1].equalsIgnoreCase(brand) &&
                            !wardrobe[i][j + 2].equalsIgnoreCase(null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Adds a new clothing element to the end of the oversize 2-D array wardrobe based on
     * the description and brand provided.
     *
     * @param description  - String title of the new clothing item
     * @param brand        - String brand name of new clothing item
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return the number of elements (clothes) in the array after adding an element
     */
    public static int addClothing(String description, String brand,
                                  String[][] wardrobe, int wardrobeSize) {

        //Checks if the provided description & brand combo already exists in the
        //wardrobe by calling the containClothing method. If the clothing does already exists,
        //the method returns the current size of the array so that no duplicates are added
        boolean clothingExists = false;
        clothingExists = containsClothing(description, brand, wardrobe, wardrobeSize);
        if (clothingExists) {
            return wardrobeSize;
        }

        //checks if array is full. If there are no open spaces to add an element, the
        //current wardrobe size is returned and no element is added
        for (int j = 0; j < wardrobe.length; j++) {
            if (j == wardrobe.length - 1) {
                if (wardrobe[j] != null) {
                    return wardrobeSize;
                }
            }
        }

        //finds the first open space in the array and adds the clothing item
        for (int j = 0; j < wardrobe.length; j++) {
            if (wardrobe[j] == null) {
                wardrobe[j] = new String[3];
                wardrobe[j][0] = description;
                wardrobe[j][1] = brand;
                wardrobe[j][2] = "never";
                wardrobeSize++;
                return wardrobeSize;
            }
        }
        return wardrobeSize;
    }

    /**
     * Finds the location (index) of a clothing item in the array that matches the
     * provided description and brand.
     *
     * @param description  - String title of the clothing item
     * @param brand        - String brand name of clothing item
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return the index of the matching clothing item or -1 if there is no matching clothing
     */
    public static int indexOfClothing(String description, String brand,
                                      String[][] wardrobe, int wardrobeSize) {
        //variable indexOfClothing initialized to -1 so that if no clothing match occurs the
        //program will return -1
        int indexOfClothing = -1;

        //Parses through all elements in the wardrobe array. Checks if the element's description
        // and corresponding brand matches the provided description and brand. If there is a
        // match then the index of the clothing match is returned.
        for (int i = 0; i < wardrobeSize; i++) {
            for (int j = 0; j < wardrobe[i].length; j++) {
                if (j == 0) {
                    if (wardrobe[i][j].equalsIgnoreCase(description) &&
                            wardrobe[i][j + 1].equalsIgnoreCase(brand)) {
                        indexOfClothing = i;
                        return indexOfClothing;
                    }
                }
            }
        }
        return indexOfClothing;
    }

    /**
     * Finds the element (clothing item) that matches the provided description/brand combo and
     * updates the last worn date to match the provided date.
     *
     * @param description  - String title of the clothing item
     * @param brand        - String brand name of clothing item
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return true if the last worn date of the matching element was successfully updated
     * and false otherwise
     */
    public static boolean wearClothing(String description, String brand,
                                       String date, String[][] wardrobe, int wardrobeSize) {
        boolean clothingMatch = false;

        //calls the containsClothing method to check if the clothing with the matching description
        //and brand combo exists. If it does, The array is parsed through and when the clothing match
        // is found, the corresponding last worn date is changed to the provided date. Then clothingMatch
        //is changed to true and is returned.
        if (containsClothing(description, brand, wardrobe, wardrobeSize)) {
            for (int i = 0; i < wardrobeSize; i++) {
                for (int j = 0; j < wardrobe[i].length; j++) {
                    if (j == 0) {
                        if (wardrobe[i][j].equalsIgnoreCase(description)
                                && wardrobe[i][j + 1].equalsIgnoreCase(brand)) {
                            clothingMatch = true;
                            wardrobe[i][j + 2] = date;
                            return clothingMatch;
                        }
                    }
                }
            }
            //if there is no clothing match then false is returned.
        } else if (!containsClothing(description, brand, wardrobe, wardrobeSize)) {
            return false;
        }
        return clothingMatch;

    }

    /**
     * Counts the number of clothing elements in the array that have brands that match
     * the provided brand.
     *
     * @param brand        - String brand name of clothing item
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return number of clothing items whose brand matches the provided brand
     */
    public static int getBrandCount(String brand, String[][] wardrobe, int
            wardrobeSize) {
        int brandCounter = 0;
        //parses through the array and finds elements that have a matching brand and then
        //increments the brandCounter every time an element with a matching brand is found
        for (int i = 0; i < wardrobeSize; i++) {
            for (int j = 0; j < wardrobe[i].length; j++) {
                if (wardrobe[i][j].equalsIgnoreCase(brand)) {
                    brandCounter++;
                }
            }
        }
        return brandCounter;
    }

    /**
     * Counts the number of clothes in the array that have the last worn date of "never".
     *
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return number of clothing that have the last worn date of "never"
     */
    public static int getNumUnwornClothes(String[][] wardrobe, int
            wardrobeSize) {
        int unwornClothesCounter = 0;
        //parses through the 2-D array and when "never" is found in a clothing element the
        //counter that counts the unworn clothes is incremented.
        for (int i = 0; i < wardrobeSize; i++) {
            for (int j = 0; j < wardrobe[i].length; j++) {
                if (wardrobe[i][j].equalsIgnoreCase("never")) {
                    unwornClothesCounter++;
                }
            }
        }
        return unwornClothesCounter;
    }

    /**
     * Finds the clothing element in the 2-D array that has the most recent last worn date.
     *
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return the smallest index of a clothing element in the array with the most recent last
     * worn date or -1 if the wardrobe is empty.
     */
    public static int getMostRecentlyWorn(String[][] wardrobe, int
            wardrobeSize) {
        //sets the most recent last worn date to the first element in array
        int indexMostRecent = 0;
        String mostRecentDate = "";

        //checks if the array is empty and return -1 if it is
        if (wardrobeSize == 0) {
            return -1;
        } else {
            //parse through the array and find the last worn dates that aren't "never"
            // and compare them to the current mostRecentDate. The larger of the two dates
            // get stored in the mostRecent variables.
            for (int i = 0; i < wardrobeSize; i++) {
                if (!wardrobe[i][2].equalsIgnoreCase("never")) {
                    if (mostRecentDate.compareTo(wardrobe[i][2]) < 0) {
                        mostRecentDate = wardrobe[i][2];
                        indexMostRecent = i;
                    }
                }
            }
        }
        return indexMostRecent;
    }

    /**
     * Removes the clothing element that is in the location of the provided index and
     * shifts the indexes of the remaining elements to keep the oversize array compressed.
     *
     * @param index        - Int that represents the index to be removed
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return size of the oversize array after attempting to remove the clothing element
     * at the provided index
     */
    public static int removeClothingAtIndex(int index, String[][] wardrobe,
                                            int wardrobeSize) {
        //checks if index is a valid index within the array if not returns without
        //updating the array
        if (index > wardrobeSize - 1) {
            return wardrobeSize;
        } else {
            //shifts all the elements from the index to the end of the elements to
            // the left one position an makes the last element null to remove the
            // element at the index. Decrements the size each time.
            for (int m = index; m < wardrobeSize - 1; m++) {
                wardrobe[m] = wardrobe[m + 1];
            }
            wardrobe[wardrobeSize - 1] = null;
            wardrobeSize--;
        }
        return wardrobeSize;
    }

    /**
     * Removes clothing elements in the array that are unworn (last worn date is "never")
     *
     * @param wardrobe     - 2D array that stores the clothing items
     * @param wardrobeSize - Int that represents how many clothing items are in the wardrobe
     * @return size of the oversize array after all the unworn items are removed
     */
    public static int removeAllUnworn(String[][] wardrobe, int
            wardrobeSize) {
        //Find how many are unworn by calling getNumUnwornClothes method
        int numUnworn = getNumUnwornClothes(wardrobe, wardrobeSize);


        //parses through the array as many times as there is unworn clothing
        //finds the unworn clothing and stores that index.
        for (int i = 0; i < numUnworn; i++) {
            int index = -1;
            for (int j = 0; j < wardrobeSize; j++) {
                if (wardrobe[j][2].equalsIgnoreCase("never")) {
                    index = j;
                    break;
                }
            }
            //the elements from the index to the end of the elements in the array
            //are all shifted once to the left and then last element becomes null.
            if (index != -1) {
                for (int m = index; m < wardrobeSize - 1; m++) {
                    wardrobe[m] = wardrobe[m + 1];
                }
                wardrobe[wardrobeSize - 1] = null;
                wardrobeSize--;
            }
        }

        return wardrobeSize;
    }
}