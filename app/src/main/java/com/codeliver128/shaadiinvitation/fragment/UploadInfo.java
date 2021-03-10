package com.codeliver128.shaadiinvitation.fragment;

public class UploadInfo {
    public String fileName;
    public String fileUrl;

    public UploadInfo(){
    }

    public UploadInfo(String fileName, String fileUrl) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

}
