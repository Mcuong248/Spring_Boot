package vn.techmaster.job_hunt.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.techmaster.job_hunt.exception.StorageException;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;

    //id của Employer id
    public String saveFile(MultipartFile file, String id) throws IOException {
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file");
          }
          //logo.png
          String extension = getFileExtension(file.getOriginalFilename()); //png
          String newFilename = path + id + "." + extension; //path=/abc/2123212212.png
          // Lấy extension   
        try {
      var is = file.getInputStream();
      // Files.copy(is, Paths.get(path + id + "." + extension), StandardCopyOption.REPLACE_EXISTING);
      
      Files.copy(is, Paths.get("D:\\Techmaster\\Spring_Boot.github\\Spring_Boot\\Hackathon1\\JOB_HUNTS\\job_hunt\\src\\main\\resources\\static\\logo\\" + id + "." + extension), StandardCopyOption.REPLACE_EXISTING);
      return id + "." + extension;
    } catch (IOException e) {
      var msg = String.format("Failed to store file %s", newFilename);
      throw new StorageException(msg, e);
    }
  }

  public void deleteFile(String logoPath){
    String filePathToDelete = path + logoPath;
    try {
      Files.deleteIfExists(Paths.get(filePathToDelete));
    } catch (IOException e) {
      var msg = String.format("Failed to delete file %s", filePathToDelete);
      throw new StorageException(msg, e);
    }
  }

    /*
     * Bóc tách file extension từ file name. Ví dụ
     * input: pic1.png
     * output: png
     */
    public String getFileExtension(String fileName) {
        int postOfDot = fileName.lastIndexOf(".");
        if (postOfDot >= 0) {
            return fileName.substring(postOfDot + 1);
        } else {
            return null;
        }
    }
}
