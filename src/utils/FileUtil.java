/*
 * File and string utilities.
 * Created on 4 febbraio 2005, 19.24
 * author: Luigi Selmi
 */
package utils;
import java.io.*;
public class FileUtil {
  /** copies a byte array into a file */
  public static void copyBytes2File(byte[] buffer, String destfilename) {
    try{      File fout = new File(destfilename);      FileOutputStream fos = new FileOutputStream(fout);
      fos.write(buffer,0,buffer.length);
      fos.close();
    }
    catch(FileNotFoundException fnfe){
      System.out.println("Class FileUtil, copyBytes2File(..) method call error..");
      fnfe.printStackTrace();
    }
    catch(IOException ioe){
      System.out.println("Class FileUtil, copyBytes2File(..) method call error..");
        ioe.printStackTrace();
    }
  }
  /** creates a copy of a file */
  public static void copyFile2File(String sourcefilename, String destfilename) {
    try{
      File fin = new File(sourcefilename);
      File fout = new File(destfilename);
      if ( fin.exists() ) {
        FileInputStream fis = new FileInputStream(fin);
        FileOutputStream fos = new FileOutputStream(fout);
        byte buffer[] = new byte[256];
        int n;
        while((n = fis.read(buffer)) > -1)
          fos.write(buffer,0,n);
        fos.close();
        fis.close();
      }
      else{
        System.out.println(sourcefilename + " does not exist.");
      }
    }
    catch(FileNotFoundException fnfe){
      System.out.println("Class FileUtil, copyFile2File(..) method call error.."); 
      fnfe.printStackTrace();
    }
    catch(IOException ioe){
      System.out.println("Class FileUtil, copyFile2File(..) method call error..");
        ioe.printStackTrace();
    }
  }
  /** copies a file into a byte array */
  public static byte[] getBytesFromFile(String filename) {
    byte[] buffer = null;
    try{
      File fin = new File(filename);
      FileInputStream fis = new FileInputStream(fin);
      int filelength = (int)fin.length();
      System.out.println("FileUtil, getBytesFromFile(..) dimensione file " + filename + " " + filelength);
      buffer = new byte[filelength];
      fis.read(buffer);
      fis.close();
    }
    catch(FileNotFoundException fnfe){
      System.out.println("Class FileUtil, getBytesFromFile(..) method call error. " + fnfe.getMessage());
    }
    catch(IOException ioe){
      System.out.println("Class FileUtil, getBytesFromFile(..) method call error. " + ioe.getMessage());
    }
    return buffer;
  }
  /**
   *copies a file into an InputStream object
   */
  public static InputStream getInputStreamFromFile(String filename) {
    InputStream is = null;
    File fin = new File(filename);
    InputStream bytearray = null;
    if ( fin.exists() ) {
      byte[] buffer = null;
      try{
        FileInputStream fis = new FileInputStream(fin);
        int filelength = (int)fin.length();
        buffer = new byte[filelength];
        fis.read(buffer);
        bytearray = new ByteArrayInputStream(buffer);
        fis.close();
      }
      catch(FileNotFoundException fnfe){
        System.out.println("Method call error. File: "+ filename + ". Error message:" + fnfe.getMessage());      }
      catch(IOException ioe){
        System.out.println("Method call error. File: " + filename + ". Error message:" + ioe.getMessage());
      }
    }
    return bytearray;
  }
  
  /** copies an InputStream object into an OutputStream */
  public static void copyInputStream2OutputStream(InputStream in, OutputStream out) {
    DataInputStream buffIn;
    DataOutputStream buffOut;
    try {
      buffIn = new DataInputStream(in);
      buffOut = new DataOutputStream(out);
      byte buffer[] = new byte[256];
      int n;
      while((n = buffIn.read(buffer)) > -1)      
        buffOut.write(buffer,0,n);
    }
    catch(IOException ioe){
      System.out.println(" method error. " + ioe.getMessage());
    }
  }
  
  /** copies a byte array into an OutputStream object */
  public static void copyBytes2OutputStream(byte[] buffer, BufferedOutputStream bos) {
    try{
      bos.write(buffer,0,buffer.length);
    }
    catch(FileNotFoundException fnfe){
      System.out.println("Class FileUtil, copyBytes2File(..) method call error..");
      fnfe.printStackTrace();
    }
    catch(IOException ioe){
      System.out.println("Class FileUtil, copyBytes2File(..) method call error..");
      ioe.printStackTrace();
    }
  }
  /** Replaces string subout with string subin  */
  public static String replacesubstring(String string, 
                                 String subout,
                                 String subin,
                                 int start) {
    String rightstring = string;
    int indexofapice = start;
    int lastindexapice = rightstring.lastIndexOf(subout);
    String strLeft;
    String strRight;
    indexofapice = rightstring.indexOf(subout,start);
		if(indexofapice != -1) {
      //System.out.println("index apice: " + indexofapice);
      strLeft = rightstring.substring(0,indexofapice);
      strRight = rightstring.substring(indexofapice + subout.length(),rightstring.length());
      //System.out.println(strLeft);
      //System.out.println(strRight);
      rightstring = strLeft + subin + strRight;
      //System.out.println(rightstring);
			//System.out.println("index apice: " + indexofapice);
			//System.out.println("lunghezza stringa " + rightstring + ": " + rightstring.length());
      if(indexofapice + subin.length() < lastindexapice) 
        rightstring = replacesubstring(rightstring,subout,subin,indexofapice + subin.length());
    }
    return rightstring;
  }
}
