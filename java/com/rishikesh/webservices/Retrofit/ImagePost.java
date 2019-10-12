package com.rishikesh.webservices.Retrofit;

public class ImagePost {

    private String FolderName;
    private String TotalImages;
    private String SelectedFile;

    public String getFolderName() {
        return FolderName;
    }

    public void setFolderName(String folderName) {
        FolderName = folderName;
    }

    public String getTotalImages() {
        return TotalImages;
    }

    public void setTotalImages(String totalImages) {
        TotalImages = totalImages;
    }

    public String getSelectedFile() {
        return SelectedFile;
    }

    public void setSelectedFile(String selectedFile) {
        SelectedFile = selectedFile;
    }


    @Override
    public String toString() {
        return "ImagePost{" +
                "FolderName='" + FolderName + '\'' +
                ", TotalImages='" + TotalImages + '\'' +
                ", SelectedFile='" + SelectedFile + '\'' +
                '}';
    }
}
