package ToCodeBase64;

import java.io.*;
import java.util.Base64;



public class CodeBase64 {

    public static void main(String[] args) throws IOException {
        
        String imgPath = "C:\\Users\\melin\\OneDrive\\Documentos\\Convert\\Convert\\src\\main\\img\\bean.jpg";
        System.out.println("==Encoder img to base64==");
        String base64ImgString = encodeToBase64(imgPath);
        System.out.println("Base64 code: " + base64ImgString);
        
        System.out.println("==Decoder base64 to img==");
        System.out.println ("Img: " + decodeToImg(base64ImgString, imgPath));
        
        System.out.println("Its done!");
        
        
    }
    
    public static String encodeToBase64(String imgPath) {
        String base64Img = "";
        File file = new File(imgPath);
        
        try (FileInputStream imgInFile = new FileInputStream(file)){
            byte imageData[] = new byte[(int) file.length()];
            imgInFile.read(imageData);
            base64Img = Base64.getEncoder().encodeToString(imageData);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found:" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the image: " + ioe);
        }
        return base64Img;
    }
    
    public static FileOutputStream decodeToImg (String base64Img, String pathFile){
        FileOutputStream imgOutFile = null;
        byte[] imageByteArray = null;
        try {
            imgOutFile = new FileOutputStream(pathFile);
            imageByteArray = Base64.getDecoder().decode(base64Img);
            imgOutFile.write(imageByteArray);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found:" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the image: " + ioe);
        }    
        return imgOutFile;


    }        
}
