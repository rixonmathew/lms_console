lms_console
===========

a simple project to build a console based lms system using TDD and other clean code principles


Things to be incorporated
=========================
10) Result formatter that provides formatted output for the console
11)

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
