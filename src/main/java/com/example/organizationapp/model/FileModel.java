package com.example.organizationapp.model;

public class FileModel {
    private final String name;
    private final long size;
    private final Integer index;

    public FileModel(String name, long size, Integer index) {
        this.name = name;
        this.size = size;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public Integer getIndex() {
        return index;
    }
}

