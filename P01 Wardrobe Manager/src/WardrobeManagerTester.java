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

import java.util.Arrays;

/**
 * This class tests all the methods within the WardrobeManager class.
 */
public class WardrobeManagerTester {

    //// CONTAINS

    /**
     * Test method verifies whether an item is already in the wardrobe if the
     * wardrobe is empty.
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testContainsEmpty() {
        //set up the test variables and call the method we are testing
        String[][] empty = new String[10][];
        String[][] wardrobeCopy = Arrays.copyOf(empty, empty.length);
        int size = 0;
        boolean expected = false;
        boolean actual = WardrobeManager.containsClothing("blue t-shirt",
                "Hanes", empty, size);

        //verifies that the expected return value and the actual return value match
        if (expected != actual) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(empty, wardrobeCopy)) {
            return false;
        }

        //if all checks pass then the tester passes
        return true;
    }

    /**
     * PROVIDED: example test method for verifying whether an item is already
     * in the wardrobe if it is already in the wardrobe.
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testContainsTrue() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"black t-shirt", "Hanes", "never"},
                {"dark blue jeans", "Levi", "never"}, null, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 2;
        boolean expected = true;
        boolean actual = WardrobeManager.containsClothing("black t-shirt",
                "Hanes", wardrobe, size);

        // verify that the expected return value and the actual return value match
        if (expected != actual) return false;

        // another test method call, this time with case difference
        // (that should still match!)
        actual = WardrobeManager.containsClothing("dark blue jeans",
                "LEVI", wardrobe, size);
        if (expected != actual) return false;

        //since this method should not modify the array, let's check it against our copy:
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) return false;

        // if all of those checks pass, NOW we can say we passed the test
        return true;
    }

    /**
     * Test method for verifying whether an item is already in the wardrobe if
     * it is not already in the wardrobe..
     *
     * @return false if any of the conditions we are verifying are not
     * what we expect; true ONLY if all of our expectations are correct
     */
    public static boolean testContainsFalse() {
        //set up test variables and call method we are testing
        String[][] wardrobe = {{"white t-shirt", "Hanes", "never"},
                {"black jeans", "Levi", "never"}, null, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 2;
        boolean expected = false;
        boolean actual = WardrobeManager.containsClothing("Black t-shirt",
                "H&M", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (expected != actual) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    //// ADD

    /**
     * PROVIDED: example test method for adding a new clothing item to an
     * EMPTY oversize array.
     *
     * @return false if any of the conditions we are verifying are not what we expect;
     * true ONLY if all of our expectations are correct
     */
    public static boolean testAddToEmpty() {
        // (1) set up the test variables and call the method we are testing
        String[][] empty = new String[10][];
        int size = 0;
        int expected = 1;
        int actual = WardrobeManager.addClothing("green crop top",
                "H&M", empty, size);
        // (2) verify the expected return value
        if (expected != actual) return false;

        // (3) verify that the provided array was updated correctly
        if (empty[0] == null) return false;
        if (!empty[0][0].equalsIgnoreCase("green crop top") ||
                !empty[0][1].equalsIgnoreCase("H&M") ||
                !empty[0][2].equals("never")) return false;

        // (4) verify that NOTHING ELSE was changed unexpectedly
        for (int i = 1; i < empty.length; i++) {
            if (empty[i] != null) return false;
        }

        // (5) if all of those checks pass, NOW we can say that we passed the test
        return true;
    }

    /**
     * Test method for adding a new clothing item to a not empty oversize array.
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testAddNonEmpty() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White t-shirt",
                "Hanes", "never"}, {"Black t-shirt", "Hanes", "never"}, null, null};
        int size = 3;
        int expected = 4;
        int actual = WardrobeManager.addClothing("green crop top",
                "H&M", wardrobe, size);

        // (2) verify the expected return value
        if (expected != actual) return false;

        // (3) verify that the provided array was updated correctly
        if (wardrobe[size] == null) return false;
        if (!wardrobe[size][0].equalsIgnoreCase("green crop top") ||
                !wardrobe[size][1].equalsIgnoreCase("H&M") ||
                !wardrobe[size][2].equals("never")) return false;

        // (4) verify that NOTHING ELSE was changed unexpectedly
        for (int i = size + 1; i < wardrobe.length; i++) {
            if (wardrobe[i] != null) return false;
        }

        // (5) if all of those checks pass, NOW we can say that we passed the test
        return true;
    }

    /**
     * Test method for adding a duplicate clothing item to a not empty oversize array.
     *
     * @return false if any of the conditions we are verifying are not what we expect;
     * true ONLY if all of our expectations are correct
     */
    public static boolean testAddDuplicate() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White t-shirt",
                "Hanes", "never"}, {"Black t-shirt", "Hanes", "never"}, null, null};
        int size = 3;
        int expected = 3;
        int actual = WardrobeManager.addClothing("White t-shirt",
                "Hanes", wardrobe, size);

        // (2) verify the expected return value
        if (expected != actual) return false;

        // (3) verify that the provided array was updated correctly
        if (wardrobe[size] != null) {
            return false;
        }

        // (4) verify that NOTHING ELSE was changed unexpectedly
        for (int i = size; i < wardrobe.length; i++) {
            if (wardrobe[i] != null) {
                return false;
            }
        }

        // (5) if all of those checks pass, NOW we can say that we passed the test
        return true;
    }

    /**
     * Test method for adding a new clothing item to an FULL oversize array.
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testAddToFull() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White t-shirt",
                "Hanes", "never"}, {"Black t-shirt", "Hanes", "never"}, {"pink t-shirt",
                "Hanes", "never"}};
        int size = 4;
        int expected = 4;
        int actual = WardrobeManager.addClothing("Yellow t-shirt",
                "Hanes", wardrobe, size);

        // (2) verify the expected return value
        if (expected != actual) return false;

        // (3) verify that the provided array was updated correctly
        if (wardrobe[size - 1][0].equals("Yellow t-shirt") &&
                wardrobe[size - 1][1].equals("Hanes")) {
            return false;
        }

        // (5) if all of those checks pass, NOW we can say that we passed the test
        return true;
    }

    //// INDEX

    /**
     * Test method for finding the index of a clothing element in an EMPTY oversize array
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testIndexOfEmpty() {
        //set up the test variables and call the method we are testing
        String[][] empty = new String[10][];
        String[][] emptyCopy = Arrays.copyOf(empty, empty.length);
        int size = 0;
        int expected = -1;
        int actual = WardrobeManager.indexOfClothing("Blue jeans",
                "Levi", empty, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(empty, emptyCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for finding the index of the first clothing element in an
     * oversize array
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testIndexOfFirstLast() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White t-shirt",
                "Hanes", "never"}, {"Black t-shirt", "Hanes", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 0;
        int actual = WardrobeManager.indexOfClothing("BlUE JEANS",
                "LEVI", wardrobe, size);


        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for finding the index of the last clothing element in an
     * oversize array
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    private static boolean testIndexOfLast() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White t-shirt",
                "Hanes", "never"}, {"Black t-shirt", "Fruit of Loom", "never"},
                {"pink t-shirt", "Hanes", "never"}};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 4;
        int expected = 3;
        int actual = WardrobeManager.indexOfClothing("PINK t-shirt",
                "Hanes", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for finding the index of a clothing element in the
     * middle of an oversize array
     *
     * @return false if any of the conditions we are verifying are not
     * what we expect; true ONLY if all of our expectations are correct
     */
    public static boolean testIndexOfMiddle() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White t-shirt",
                "Hanes", "never"}, {"Black t-shirt", "Hanes", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 1;
        int actual = WardrobeManager.indexOfClothing("WHite T-shirt",
                "Hanes", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for finding the index of a clothing element in an oversize
     * array that does not exist
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testIndexOfNoMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White t-shirt",
                "Hanes", "never"}, {"Black t-shirt", "Hanes", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = -1;
        int actual = WardrobeManager.indexOfClothing("White tank top",
                "H&M", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    //// WEAR

    /**
     * Test method for updating the date of an element that exists in an oversize array
     *
     * @return false if any of the conditions we are verifying are not what we expect;
     * true ONLY if all of our expectations are correct
     */
    public static boolean testWearClothingTrue() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White jeans", "Levi",
                "never"}, {"Black jeans", "Levi", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        boolean expected = true;
        boolean actual = WardrobeManager.wearClothing("White JEANS",
                "LEVI", "2024-01-27", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //checks to make sure that the correct element was updated
        if (wardrobe[1][2].equals("never")) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for updating the date of an element that does not exist in an
     * oversize array
     *
     * @return false if any of the conditions we are verifying are not what we expect;
     * true ONLY if all of our expectations are correct
     */
    public static boolean testWearClothingNoMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White jeans", "Levi", "never"},
                {"Black jeans", "Levi", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        boolean expected = false;
        boolean actual = WardrobeManager.wearClothing("Green jeans",
                "Levi", "2024-01-27", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    //// BRAND COUNT

    /**
     * Test method for counting the elements that have match the provided brand
     * when every element matches
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testBrandCountAllMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White jeans",
                "Levi", "never"}, {"Black jeans", "Levi", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 3;
        int actual = WardrobeManager.getBrandCount("Levi", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for counting the elements that have match the provided brand
     * when some elements match
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testBrandCountSomeMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White t-shirt",
                "Hanes", "never"}, {"Black jeans", "Levi", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 2;
        int actual = WardrobeManager.getBrandCount("Levi", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for counting the elements that have match the provided brand
     * when no elements match
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testBrandCountNoMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White jeans", "Levi", "never"},
                {"Black jeans", "Levi", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 0;
        int actual = WardrobeManager.getBrandCount("Hanes", wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    //// COUNT UNWORN

    /**
     * Test method for counting the elements that are unworn in an oversize array when e
     * very element is unworn
     *
     * @return false if any of the conditions we are verifying are not what we expect;
     * true ONLY if all of our expectations are correct
     */
    public static boolean testUnwornCountAllMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White jeans",
                "Levi", "never"}, {"Black jeans", "Levi", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 3;
        int actual = WardrobeManager.getNumUnwornClothes(wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for counting the elements that are unworn in an oversize
     * array when some elements are unworn
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testUnwornCountSomeMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"}, {"White jeans",
                "Levi", "2024-01-06"}, {"Black jeans", "Levi", "never"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 2;
        int actual = WardrobeManager.getNumUnwornClothes(wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for counting the elements that are unworn in an oversize
     * array when no elements are unworn
     *
     * @return false if any of the conditions we are verifying are not what
     * we expect; true ONLY if all of our expectations are correct
     */
    public static boolean testUnwornCountNoMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "2023-04-19"}, {"White jeans",
                "Levi", "2024-01-06"}, {"Black jeans", "Levi", "2020-09-12"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 0;
        int actual = WardrobeManager.getNumUnwornClothes(wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    //// MOST RECENTLY WORN

    /**
     * PROVIDED: example test method for verifying that the most recently worn item is found correctly.
     * Note that this tester is not comprehensive; if you wish to verify additional behavior you are
     * welcome to add additional tester methods (please specify such methods to be PRIVATE).
     *
     * @return false if any of the conditions we are verifying are not what we expect; true ONLY if
     * all of our expectations are correct
     */
    public static boolean testMostRecentlyWorn() {
        // (1) set up the test variables and call the method we are testing - EXACT MATCH
        String[][] wardrobe = {{"black t-shirt", "Hanes", "2023-12-19"},
                {"grey UW hoodie", "gildan", "2020-03-16"},
                {"dark blue jeans", "Levi", "2024-01-25"},
                {"green cabled sweater", "handmade", "never"}, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 4;
        int expected = 2;
        int actual = WardrobeManager.getMostRecentlyWorn(wardrobe, size);

        // (2) verify that the expected return value and the actual return value match
        if (expected != actual) return false;

        // (3) since this method should not modify the array, let's check it against our copy:
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) return false;

        // (4) if all of those checks pass, NOW we can say we passed the test
        return true;
    }

    //// REMOVE BY INDEX

    /**
     * Test method for removing an element at the specified index - this case is removing
     * the last element
     *
     * @return false if any of the conditions we are verifying are not what we expect; true ONLY if
     * all of our expectations are correct
     */
    public static boolean testRemoveLastItem() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"black t-shirt", "Hanes", "2023-12-19"},
                {"grey UW hoodie", "gildan", "2020-03-16"},
                {"dark blue jeans", "Levi", "2024-01-25"},
                {"green cabled sweater", "handmade", "never"}, null};
        int size = 4;
        int expected = 3;
        int actual = WardrobeManager.removeClothingAtIndex(3, wardrobe, size);

        // (2) verify the expected return value
        if (expected != actual) return false;

        //Check that the correct element was updated
        if (wardrobe[3] != null) return false;

        // (5) if all of those checks pass, NOW we can say that we passed the test
        return true;
    }

    /**
     * Test method for removing an element at the specified index - this case is removing
     * the first element
     *
     * @return false if any of the conditions we are verifying are not what we expect; true ONLY if
     * all of our expectations are correct
     */
    public static boolean testRemoveFirstItem() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"black t-shirt", "Hanes", "2023-12-19"},
                {"grey UW hoodie", "gildan", "2020-03-16"},
                {"dark blue jeans", "Levi", "2024-01-25"},
                {"green cabled sweater", "handmade", "never"},
                {"yellow cabled sweater", "handmade", "never"}};
        int size = 5;
        int expected = 4;
        int actual = WardrobeManager.removeClothingAtIndex(1, wardrobe, size);

        // (2) verify the expected return value
        if (expected != actual) return false;

        //Check that the correct element was updated
        if (wardrobe[0] == null) {
            return false;
        }
        if (wardrobe[4] != null) {
            return false;
        }

        // (5) if all of those checks pass, NOW we can say that we passed the test
        return true;
    }

    /**
     * Test method for removing an element at the specified index - this case is removing
     * at an invalid index
     *
     * @return false if any of the conditions we are verifying are not what we expect;
     * true ONLY if all of our expectations are correct
     */
    public static boolean testRemoveBadIndex() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"black t-shirt", "Hanes", "2023-12-19"},
                {"grey UW hoodie", "gildan", "2020-03-16"},
                {"dark blue jeans", "Levi", "2024-01-25"},
                {"green cabled sweater", "handmade", "never"},
                {"yellow cabled sweater", "handmade", "never"}};
        int size = 5;
        int expected = 5;
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);

        //verifies that the expected return value and the actual return value match
        int actual = WardrobeManager.removeClothingAtIndex(8, wardrobe, size);

        // (2) verify the expected return value
        if (expected != actual) return false;

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) return false;


        // (5) if all of those checks pass, NOW we can say that we passed the test
        return true;
    }

    //// REMOVE ALL UNWORN

    /**
     * Test method for removing all unworn clothing elements - this case no elements are
     * unworn
     *
     * @return false if any of the conditions we are verifying are not what we
     * expect; true ONLY if all of our expectations are correct
     */
    public static boolean testRemoveUnwornNoMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "2023-04-19"},
                {"White jeans", "Levi", "2024-01-06"},
                {"Black jeans", "Levi", "2020-09-12"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 3;
        int actual = WardrobeManager.removeAllUnworn(wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //verifies that the method did not modify the array
        if (!Arrays.deepEquals(wardrobe, wardrobeCopy)) {
            return false;
        }
        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for removing all unworn clothing elements -
     * this case some elements are unworn
     *
     * @return false if any of the conditions we are verifying
     * are not what we expect; true ONLY if all of our expectations are correct
     */
    public static boolean testRemoveUnwornSomeMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"},
                {"White jeans", "Levi", "never"},
                {"Black jeans", "Levi", "2024-01-06"}, null, null};
        String[][] wardrobeCopy = Arrays.copyOf(wardrobe, wardrobe.length);
        int size = 3;
        int expected = 1;
        int actual = WardrobeManager.removeAllUnworn(wardrobe, size);

        //verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //Check that the correct element was updated
        if (wardrobe[0] == null) {
            return false;
        }
        if (wardrobe[1] != null) {
            return false;
        }
        if (wardrobe[2] != null) {
            return false;
        }
        if(!wardrobe[0][2].equals("2024-01-06")){
            return false;
        }

        //if all checks pass then the tester passes
        return true;
    }

    /**
     * Test method for removing all unworn clothing elements - this case all elements are
     * unworn
     *
     * @return false if any of the conditions we are verifying are not what we expect; true ONLY if
     * all of our expectations are correct
     */
    public static boolean testRemoveUnwornAllMatch() {
        //set up the test variables and call the method we are testing
        String[][] wardrobe = {{"Blue jeans", "Levi", "never"},
                {"White jeans", "Levi", "never"},
                {"Black jeans", "Levi", "never"}, null, null};
        int size = 3;
        int expected = 0;
        int actual = WardrobeManager.removeAllUnworn(wardrobe, size);

//verifies that the expected return value and the actual return value match
        if (actual != expected) {
            return false;
        }

        //Check that the correct element was updated
        if (wardrobe[0] != null) {
            return false;
        }
        if (wardrobe[1] != null) {
            return false;
        }
        if (wardrobe[2] != null) {
            return false;
        }

        //if all checks pass then the tester passes
        return true;
    }

    /**
     * PROVIDED: calls all tester methods and displays the results of the tests.
     * <p>
     * All tests are called in the order they were provided in this file. The output of this method
     * will NOT be graded so you may modify it however you wish.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("CONTAINS:\n  " + (testContainsEmpty() ? "pass" : "FAIL") + ", " +
                (testContainsTrue() ? "pass" : "FAIL") + ", " + (testContainsFalse() ? "pass" : "FAIL"));
        System.out.println("ADD:\n  " + (testAddToEmpty() ? "pass" : "FAIL") + ", " + (testAddNonEmpty() ? "pass" : "FAIL") +
                ", " + (testAddDuplicate() ? "pass" : "FAIL") + ", " + (testAddToFull() ? "pass" : "FAIL"));
        System.out.println("INDEX OF:\n  " + (testIndexOfEmpty() ? "pass" : "FAIL") + ", " + (testIndexOfFirstLast() ? "pass" : "FAIL") +
                ", " + (testIndexOfLast() ? "pass" : "FAIL") + ", " + (testIndexOfMiddle() ? "pass" : "FAIL") + ", " + (testIndexOfNoMatch() ? "pass" : "FAIL"));
        System.out.println("WEAR:\n  " + (testWearClothingTrue() ? "pass" : "FAIL") + ", " + (testWearClothingNoMatch() ? "pass" : "FAIL"));
        System.out.println("BRAND COUNT:\n  " + (testBrandCountAllMatch() ? "pass" : "FAIL") + ", " +
                (testBrandCountSomeMatch() ? "pass" : "FAIL") + ", " + (testBrandCountNoMatch() ? "pass" : "FAIL"));
        System.out.println("UNWORN COUNT:\n  " + (testUnwornCountAllMatch() ? "pass" : "FAIL") + ", " +
                (testUnwornCountSomeMatch() ? "pass" : "FAIL") + ", " + (testUnwornCountNoMatch() ? "pass" : "FAIL"));
        System.out.println("MOST RECENTLY WORN:\n  " + (testMostRecentlyWorn() ? "pass" : "FAIL"));
        System.out.println("REMOVE BY INDEX:\n  " + (testRemoveLastItem() ? "pass" : "FAIL") + ", " +
                (testRemoveFirstItem() ? "pass" : "FAIL") + ", " + (testRemoveBadIndex() ? "pass" : "FAIL"));
        System.out.println("REMOVE UNWORN:\n  " + (testRemoveUnwornNoMatch() ? "pass" : "FAIL") + ", " +
                (testRemoveUnwornSomeMatch() ? "pass" : "FAIL") + ", " + (testRemoveUnwornAllMatch() ? "pass" : "FAIL"));
    }

}
