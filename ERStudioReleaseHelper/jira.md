1. MUST HAVE - Valid TS version -> have it as 3 digits. May be show it in the tooltip like x.y.z.

2. MUST HAVE - List down all files which are changed in the final output. Right now it doesn't show that. 

3. MUST HAVE - If a folder is selected, and if we click browse, navigate to that folder and not always default.

4. DELIGHTER - Allow editing of folder text box (like we can copy paste the path or directly type the path)

5. MUST HAVE - If non existing version is given, it still says success. Looks like there is no validation of version string.
for ex: try to change from 18.5.0.0 -> 18.3.0.0 it proceeds.

6. MUST HAVE - Looks like once we replace the version, clicking on change version number next time is not having any effect. 
for ex: change from 18.1.0.0 -> 18.2.0.0 and change from 18.2.0.0 -> 18.3.0.0

7. MUST HAVE - Selecting patch upgrade and clicking on change version number should validate whether the new version number I entered is really a patch version or not. By checking if the 3rd digit is NOT 0 and has values from 1 to 9. Then it's a patch.

8. MUST HAVE - Any reason why GUID shows ....s in between on the UI. On hover, it shows full GUID though.

9. DELIGHTER - Enable "change version number and reset" buttons only when the above information is entered and correct.
