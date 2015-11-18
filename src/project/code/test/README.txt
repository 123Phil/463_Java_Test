Submission for:
CPSC 463 - Software Testing
Testing Project - Part 2 (Executable tests)
with Prof: Greenbaum
Fall 2015

Contributors:
- Phillip Stewart
- Timothy Ater
- Kenneth Gunderson

The Java test files provided here accompany the provided 'project.code.base' Java files.
These tests are implemented using JUnit 4, and were run using Eclipse.
The project structure in Eclipse placed the 'project.code.base' files in the '<Project name>/src/code/base/' directory. Our test files are in the package 'project.code.test', and so they fall into the '<Project name>/src/code/test/' directory.

Upon running the tests in Eclipse, 71 of 154 tests failed. Many of these test cases fail due to the same few code faults (for example, Command.Set_Unit_ID(String) does not check for null values, and many tests supply subclassed Command instances with null parameters).
Due to the "Temporary implementation" in Send_Message_To_Operator, some of the tests print to stdout. One test currently fails and prints a message that should not be printed.

A helper function exists in a few test classes to add a response unit to the Response_Unit_Manager cleanly and consistently. Furthermore, a helper Thread class (EnqueueThread) exists to run the Command_Manager_Test with threads.
