lms_console
===========

a simple project to build a console based lms system using TDD and other clean code principles


Things to be incorporated
=========================
10) Result formatter that provides formatted output for the console
12  Introduce list command to see all books, users etc
13) Do not treat exit as invalid command
14) do clean up before exit
15) introduce command to see items checked out to user
16) introduce command to see who has checked out
17) If the command is invalid the message to user should be different

Refactorings
============
1) Rename all Simple* classes to a more meaningful name
2) How
3) Same logic should be in place for all valid commands
9) Command Interpreter that converts the command to the query language for the service.

Done
==========
1) Creating command objects from command string
2) Validating the syntax of specific commands e.g. search should be followed by specific parameters else command
   is invalid
4) help command should list out all possible commands in the system
5) Command processor that takes a valid command object and provides the Result object
8) Create mock/real service to provide the data for the command
6) Validate Search results
7) Validate results of other commands
11) Handle specific help
