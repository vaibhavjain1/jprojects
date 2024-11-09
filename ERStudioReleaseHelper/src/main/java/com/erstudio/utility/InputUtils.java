package main.java.com.erstudio.utility;

/**
 * @author darpan.kochar
 * for input validation utils
 */

import main.java.com.erstudio.constants.Constants;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class InputUtils {
    // method to check if the directory is valid or not
    public static boolean isValidDirectory(String tabTitle, String path) {
        File directory = new File(path);
        if (!directory.isDirectory()) {
            return false;
        }
        FilenameFilter directoryFilter = new FilenameFilter() {
            public boolean accept(File file, String fileName) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        if (tabTitle.equals(Constants.TEAM_SERVER)) {
            ArrayList<String> directoryList = new ArrayList<>(Arrays.asList(directory.list(directoryFilter)));
            if (directoryList.contains(Constants.ERS_STUDIO_DIRECTORY_CONFIGURATOR) && directoryList.contains(Constants.ERS_STUDIO_DIRECTORY_ERSPORTAL)) {
                return true;
            } else {
                return false;
            }
        }
        if (tabTitle.equals(Constants.DATA_ARCHITECT)) {
            ArrayList<String> mainDirectoryList = new ArrayList<>(Arrays.asList(directory.list(directoryFilter)));
            if (mainDirectoryList.contains(Constants.DA_DIRECTORY_ERDTSTUDIO) && mainDirectoryList.contains(Constants.DA_DIRECTORY_SOLUTION)) {
                ArrayList<File> mainDirectories = new ArrayList<>(Arrays.asList(directory.listFiles(directoryFilter)));
                File erdtStudio = mainDirectories.get(mainDirectoryList.indexOf(Constants.DA_DIRECTORY_ERDTSTUDIO));
                File solution = mainDirectories.get(mainDirectoryList.indexOf(Constants.DA_DIRECTORY_SOLUTION));

                ArrayList<String> erdtStudioDirectoryList = new ArrayList<>(Arrays.asList(erdtStudio.list(directoryFilter)));
                if (!erdtStudioDirectoryList.contains(Constants.DA_DIRECTORY_ER1CORE)) {
                    return false;
                }

                ArrayList<String> solutionDirectoryList = new ArrayList<>(Arrays.asList(solution.list()));
                if (solutionDirectoryList.contains(Constants.DA_FILE_ERDTREPO)) {
                    ArrayList<File> solutionDirectories = new ArrayList<>(Arrays.asList(solution.listFiles()));
                    File erdtRepo = solutionDirectories.get(solutionDirectoryList.indexOf(Constants.DA_FILE_ERDTREPO));
                    if (erdtRepo.isFile()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // method to match version with the regex
    public static boolean isValidVersionNumber(String tabTitle, String version) {
        if (tabTitle.equals(Constants.TEAM_SERVER)) {
            return Pattern.matches(Constants.ERS_STUDIO_RELEASE_VERSION_PATTERN, version);
        }

        if (tabTitle.equals(Constants.DATA_ARCHITECT)) {
            return Pattern.matches(Constants.DA_RELEASE_VERSION_PATTERN, version);
        } else {
            return false;
        }
    }
}
