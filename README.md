lms_console
===========

a simple project to build a console based lms system using TDD and other clean code principles


Things to be incorporated
=========================
 Introduce list command to see all books, users etc
 Introduce command to add new user into the system
 Introduce command to add new media item into the system
 introduce command to see items checked out to user
 introduce command to see who has checked out a particular book
 introduce command to see reservations against a book
 If the command is invalid the message to user should be different
 Introduce DAO to get the data from data store
 Introduce LMSMain and add tests for LMSConsole
 integrate the GUI of LMS with LMSConsole
 introduce command to execute canned reports based on user inputs
 Consolidate all the places where operation is used in a map. Create a meta model for a command
 Result formatter that provides formatted output for the console based on the result
 do clean up before exit

Refactorings
============
 Rename all Simple* classes to a more meaningful name
 Command Interpreter that converts the command to the query language for the service.

Done
==========
 Creating command objects from command string
 Validating the syntax of specific commands e.g. search should be followed by specific parameters else command
 is invalid
 help command should list out all possible commands in the system
 Command processor that takes a valid command object and provides the Result object
 Create mock/real service to provide the data for the command
 Validate Search results
 Validate results of other commands
 Handle specific help
 Do not treat exit as invalid command
