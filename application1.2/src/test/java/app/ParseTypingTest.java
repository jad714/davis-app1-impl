/*
 *  UCF COP3330 Fall 2021 ToDoListApplication Assignment 1 Solution
 *  Copyright 2021 Joshua Davis
 */

package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseTypingTest {

    @Test
    void validateTypingTest(){
        // Instantiate new ParseTyping object for testing.
        ParseTyping parseTypingTest = new ParseTyping();
        // Create a test string containing a hyphen for rejection (hyphens are used for formatting the save file and are not allowed).
        String testStringRejectHyphen = "-";
        // Create a test string containing more than the max allowable characters for rejection.
        String testStringRejectLength = "a";
        for(int i=0;i<257;i++){
            testStringRejectLength = testStringRejectLength.concat("a");
        }
        // Reject the empty string, according to the project requirements.
        String testStringRejectZero = "";
        // Create a string that would be accepted by the program.
        String testStringAccept = "All your base are belong to us.";
        // Run the appropriate assertions.
        assertTrue(parseTypingTest.validateDescription(testStringAccept));
        assertFalse(parseTypingTest.validateDescription(testStringRejectLength));
        assertFalse(parseTypingTest.validateDescription(testStringRejectHyphen));
        assertFalse(parseTypingTest.validateDescription(testStringRejectZero));
    }
}