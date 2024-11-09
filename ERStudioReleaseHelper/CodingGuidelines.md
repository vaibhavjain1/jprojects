Code Check-in Process
1. Fork Main Repository in local User
2. Create branch if required
3. Complete code changes and dev test
4. Commit-Push changes in git Repository and Raise a pull request against Main Repository. Notify reviewer to review the changes.
5. If any review comments come, perform step 3-4 again and resolve conversation. Same pull request will pick the changes.
6. Before we ask reviewer to review the changes, Do check if PR has got merge conflicts. 
   If Yes
   a. Take backup of your changes, unless you have experience in resolving conflicts.
   b. Fetch changes from origin.
   c. Resolve conflicts and commit-push new changes.
Java
1. Code should be formatted before check-in. No Extra lines in between class or at the end of file.
2. Every Class should have Author name as well as description
3. Every Method should have description and parameter details.
4. Class/Method/Variable names should be self explanatory.
5. Naming conventions:
   Classes and interface: First letter capitalized. Should be a noun. Should not contain abbreviations and acronyms
   Methods: first letter small with internal word’s first letter capitalized. Should be a verb
   Variable: should not start with _ or $. 
   Constant variable: should be in all Capitalized letters with internal words separated by _.
   Packages: should be in all small letters.6. Add getters, setters, toString methods in Entity classes(wherever required)
7. Always get the field declarations in separate lines. This is incorrect - static private int counter, serial;
8. A field or class which doesn't change after initialization should be declared final. This approach allows the compiler to generate better code.
9. Don't leave any variable without the access specifiers.
10. Function returning boolean should be prefixed with <is>. e.g. isVisible(), isChecked(), isNumeric().
11. Limit each line - 80 chars. Comment - 70 chars.
12. For/If-Else/While etc. Curly brackets should start with next line followed by actual code.