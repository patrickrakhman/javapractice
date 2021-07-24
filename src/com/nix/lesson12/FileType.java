package com.nix.lesson12;

public enum FileType {
    FILE_PATH("file.txt"),
    DIR_PATH("file_dir"),
    DIRS_PATH("file_dir/file_dir1/file_dir2");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
