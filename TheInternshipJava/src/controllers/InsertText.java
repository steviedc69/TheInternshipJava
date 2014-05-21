package controllers;
import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.File;  
import java.io.IOException;  
import java.io.UnsupportedEncodingException;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Set;  
  
import org.apache.poi.hwpf.HWPFDocument;  
import org.apache.poi.hwpf.usermodel.Range;  
import org.apache.poi.hwpf.usermodel.Paragraph;  
import org.apache.poi.poifs.filesystem.POIFSFileSystem;  
import org.apache.poi.hwpf.model.TextPiece;  
  
 
public class InsertText {  
    public InsertText(){}
    //http://www.coderanch.com/t/534754/java/java/Editing-pdf-word-content-text
    private String filename = null;
    private File inputFile = null;  
    private HWPFDocument document = null;  
    private HashMap<String, String> replacementText = null;  
    private Set<String> keys = null;  
          
 
    public InsertText(String filename, HashMap<String, String> replacementText, String newFilename) throws NullPointerException, IllegalArgumentException {  
         
        // Not strictly necessary as a similar exception will be thrown on  
        // instantiation of the File object later. Still like to test the parameters though.  
        if(filename == null) {  
            throw new NullPointerException("Null value passed to the filename parameter of the InsertText class constructor.");  
        }  
        if(replacementText == null) {  
            throw new NullPointerException("Null value passed to the replacementText parameter of the InsertText class constructor.");  
        }  
        if(filename==null) {  
            throw new IllegalArgumentException("An empty String was passed to the filename parameter of the InsertText class constructor.");  
        }  
        if(replacementText.isEmpty()) {  
            throw new IllegalArgumentException("An empty HashMap was passed to the replacementText parameter of the InsertText class constructor.");  
        }  
        // Copy parameters to local variables. Get the set of keys backing the HashMap and open the file.  
        this.replacementText = replacementText;  
        this.keys = replacementText.keySet();  
        this.inputFile = new File(filename);
        this.filename = newFilename;
    }  
      
    /** 
     * Called to replace any named 'placeholders' with their accompanying text. 
     */  
    public void processFile() {  
        Range range = null;  
        BufferedInputStream buffInputStream = null;  
        BufferedOutputStream buffOutputStream = null;  
        FileInputStream fileInputStream = null;  
        FileOutputStream fileOutputStream = null;  
        ParagraphText[] paraText = null;  
  
        try {  
            // Open the input file.  
            fileInputStream = new FileInputStream(this.inputFile);  
            buffInputStream = new BufferedInputStream(fileInputStream);  
            this.document = new HWPFDocument(new POIFSFileSystem(buffInputStream));  
              
            // Get an instance of the Range class and load all of the Paragrpahs  
            // the document contains into a local array of type ParagraphText.  
            range = this.document.getRange();  
            paraText = this.loadParagraphs(range);  
  
            // Step through the paragraph text.  
            for(int i = 0; i < paraText.length; i++) {  
                  
                // Step through the Set of keys that backs the HashMap of  
                // key/value pairs. For each key, test to see whether it exists  
                // in the paragraph of text and if so replace it with the specified text value.  
                for(String key : this.keys) {  
                    System.out.println(paraText[i].getUpdatedText());  
                    if(paraText[i].getUpdatedText().contains(key)) {  
                        paraText[i].updateText(  
                            this.replacePlaceholders(key, this.replacementText.get(key), paraText[i].getUpdatedText()));  
                    }  
                }  
                  
                 
                if(paraText[i].isUpdated()) {  
                    range.getParagraph(paraText[i].getParagraphNumber()).replaceText(  
                            paraText[i].getRawText(), paraText[i].getUpdatedText(), 0);  
                }  
            }  
            // Save the document away.  
            fileOutputStream = new FileOutputStream(new File(filename));  
            buffOutputStream = new BufferedOutputStream(fileOutputStream);  
            this.document.write(buffOutputStream);  
        }  
        catch(IOException ioEx) {  
            System.out.println("Caught an: " + ioEx.getClass().getName());  
            System.out.println("Message: " + ioEx.getMessage());  
            System.out.println("StackTrace follows:");  
            ioEx.printStackTrace(System.out);  
        }  
        finally {  
            if(buffInputStream != null) {  
                try {  
                    buffInputStream.close();  
                }  
                catch(IOException ioEx) {  
                    // I G N O R E //  
                }  
            }  
              
            if(buffOutputStream != null) {  
                try {  
                    buffOutputStream.flush();  
                    buffOutputStream.close();  
                }  
                catch(IOException ioEx) {  
                    // I G N O R E //  
                }  
            }  
        }  
    }  
      
      
    private String replacePlaceholders(String key, String value, String text) {  
        int index = 0;  
        // This is far from the most efficient way to parse the String as it  
        // always starts from the beginning even after one or more substitutions  
        // have been made. For now though it does work but will have obvious  
        // limitations if the chunks of text are very large.  
        while((index = text.indexOf(key)) >= 0) {  
            text = text.substring(0, index) + value + text.substring(index + key.length());  
        }  
        return(text);  
    }  
      
     
    private ParagraphText[] loadParagraphs(Range range) {  
        ParagraphText[] paraText = new ParagraphText[range.numParagraphs()];  
        Paragraph paragraph = null;  
        String readText = null;  
        try{  
          
            for(int i = 0; i < range.numParagraphs(); i++) {  
                paragraph = range.getParagraph(i);  
                readText = paragraph.text();  
                if(readText.endsWith("\n")) {  
                    readText = readText + "\n";  
                }  
                paraText[i] = new ParagraphText(i, readText);  
            }  
        }  
        catch(Exception ex) {  
            paraText[0] = this.getTextFromPieces();  
        }  
        return(paraText);  
    }  
  
     
    private ParagraphText getTextFromPieces() {  
        TextPiece piece = null;  
        StringBuffer buffer = new StringBuffer();  
        String text = null;  
        String encoding = "Cp1252";  
          
        Iterator textPieces = this.document.getTextTable().getTextPieces().iterator();  
        while (textPieces.hasNext()) {  
            piece = (TextPiece)textPieces.next();  
            if (piece.isUnicode()) {  
                encoding = "UTF-16LE";  
            }  
            try {  
                text = new String(piece.getRawBytes(), encoding);  
            buffer.append(text);  
            } catch(UnsupportedEncodingException e) {  
                throw new InternalError("Standard Encoding " + encoding + " not found, JVM broken");  
            }  
        }  
        text = buffer.toString();  
        // Fix line endings (Note - won't get all of them  
        text = text.replaceAll("\r\r\r", "\r\n\r\n\r\n");  
        text = text.replaceAll("\r\r", "\r\n\r\n");  
        if(text.endsWith("\r")) {  
            text += "\n";  
        }  
        return(new ParagraphText(0, text));  
      }  
      
     
}  