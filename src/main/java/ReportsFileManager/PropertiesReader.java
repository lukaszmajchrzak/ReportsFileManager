package ReportsFileManager;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PropertiesReader {
    private String propertiesFileName;
    private String  properrtiesFilePaath;
    private ArrayList<Report> reportsList = new ArrayList();


     public void setPropertiesFileName(String propertiesFileName) {
        this.propertiesFileName = propertiesFileName;
    }

    public void setProperrtiesFilePaath(String properrtiesFilePaath) {
        this.properrtiesFilePaath = properrtiesFilePaath;
    }

    public void readReportsFile(){
         try {
             File reportFile = new File(this.properrtiesFilePaath + this.propertiesFileName);
             DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
             DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
             Document document = documentBuilder.parse(reportFile);

             readReports(document);
         } catch(ParserConfigurationException | SAXException | IOException e){
             e.printStackTrace();
         }
    }

    private void readReports(Document document){
        NodeList reportName = document.getElementsByTagName("ReportName");
        NodeList fileName = document.getElementsByTagName("FileName");
        NodeList isFileNameFullyTyped = document.getElementsByTagName("isFileNameFullyTyped");
        NodeList fileSource = document.getElementsByTagName("FileSource");
        NodeList fileDestination = document.getElementsByTagName("FileDestination");

            for(int i=0;i<reportName.getLength();i++){
                reportsList.add(new Report(reportName.item(i).getTextContent(),  fileName.item(i).getTextContent(), Boolean.parseBoolean(isFileNameFullyTyped.item(i).getTextContent()),
                        fileSource.item(i).getTextContent(),fileDestination.item(i).getTextContent()));
            }
        }

    }
