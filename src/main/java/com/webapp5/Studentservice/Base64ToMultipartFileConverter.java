package com.webapp5.Studentservice;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StreamUtils;
import java.io.*;

public class Base64ToMultipartFileConverter {

    public static MultipartFile convert(String base64String) throws IOException {
        // Decode Base64 string to bytes
        byte[] bytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64String);
        
        // Create a temporary file
        File tempFile = File.createTempFile("temp", null);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(bytes);
        }

        // Convert the file to MultipartFile
        InputStream inputStream = new FileInputStream(tempFile);
        return new MultipartFileImpl(inputStream, tempFile.getName());
    }

    // Custom implementation of MultipartFile for simplicity
    private static class MultipartFileImpl implements MultipartFile {

        private final InputStream inputStream;
        private final String originalFilename;

        public MultipartFileImpl(InputStream inputStream, String originalFilename) {
            this.inputStream = inputStream;
            this.originalFilename = originalFilename;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getOriginalFilename() {
            return originalFilename;
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public long getSize() {
            try {
                return inputStream.available();
            } catch (IOException e) {
                return 0;
            }
        }

        @Override
        public byte[] getBytes() throws IOException {
            return StreamUtils.copyToByteArray(inputStream);
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return inputStream;
        }

        @Override
        public void transferTo(File dest) throws IOException, IllegalStateException {
            try (FileOutputStream fos = new FileOutputStream(dest)) {
                StreamUtils.copy(inputStream, fos);
            }
        }
    }
}

