package com.infosys.retailrobot.utils;

import java.io.File;
import java.io.FilenameFilter;

public class FileManage {
	public static File[] getFilesEndWith(String _path, final FileMatchType _matchType, final String _matchString) {
		// your directory
		File f = new File(_path);
		File[] matchingFiles = f.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				if(_matchType == FileMatchType.ENDWITH)
					return name.endsWith(_matchString);
				else if(_matchType == FileMatchType.STARTWITH)
					return name.startsWith(_matchString);
				else if(_matchType == FileMatchType.CONATINS)
					return name.contains(_matchString);
				return false;
			}
		});
		return matchingFiles;
	}
}
