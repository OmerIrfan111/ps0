package rules;

/**
 * Policy for using code in 6.005-style assignments.
 */
public class RulesOf6005 {

    /**
     * Decides whether code may be used in an assignment.
     *
     * @param writtenByYourself      true if you wrote the code yourself
     * @param availableToOthers      true if the code is available to all students
     * @param writtenAsCourseWork    true if the code was produced as course work by other students
     * @param citingYourSource       true if you give proper attribution
     * @param implementationRequired true if the assignment says to implement this yourself
     * @return true if the code may be used
     */
    public static boolean mayUseCodeInAssignment(boolean writtenByYourself,
                                                 boolean availableToOthers,
                                                 boolean writtenAsCourseWork,
                                                 boolean citingYourSource,
                                                 boolean implementationRequired) {
        if (writtenByYourself) {
            return true;
        }
        if (writtenAsCourseWork) {
            return false;
        }
        return availableToOthers && citingYourSource && !implementationRequired;
    }

    /**
     * Entry point: prints the result of a few sample inputs.
     */
    public static void main(String[] args) {
        System.out.println("Own code: "
                + mayUseCodeInAssignment(true, false, false, false, false));
        System.out.println("Cited public code: "
                + mayUseCodeInAssignment(false, true, false, true, false));
        System.out.println("Uncited public code: "
                + mayUseCodeInAssignment(false, true, false, false, false));
        System.out.println("Other students' coursework: "
                + mayUseCodeInAssignment(false, true, true, true, false));
    }
}