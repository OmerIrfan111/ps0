/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {

    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /** Code you wrote yourself may always be used. */
    @Test
    public void testOwnCodeIsAllowed() {
        assertTrue("Expected true: code written by yourself",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, false, false));
    }

    /** Other students' course work may never be used, even if cited. */
    @Test
    public void testOtherStudentsCourseworkIsForbidden() {
        assertFalse("Expected false: other students' course work, even if cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /** Public code is allowed when it is cited. */
    @Test
    public void testCitedPublicCodeIsAllowed() {
        assertTrue("Expected true: cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    /** If the assignment says "implement X", you must write X yourself. */
    @Test
    public void testImplementationRequiredIsForbidden() {
        assertFalse("Expected false: external code when implementation is required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }
}