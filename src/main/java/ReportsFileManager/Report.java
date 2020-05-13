package ReportsFileManager;

public class Report {
    private String ReportName;
    private String FileName;
    private Boolean isFileNameFullyTyped;
    private String FileSource;
    private String FileDestination;


    public Report(String reportName, String fileName, Boolean isFileNameFullyTyped, String fileSource, String fileDestination) {
        ReportName = reportName;
        FileName = fileName;
        this.isFileNameFullyTyped = isFileNameFullyTyped;
        FileSource = fileSource;
        FileDestination = fileDestination;
    }

    public String getReportName() {
        return ReportName;
    }

    public String getFileName() {
        return FileName;
    }

    public Boolean getFileNameFullyTyped() {
        return isFileNameFullyTyped;
    }

    public String getFileSource() {
        return FileSource;
    }

    public String getFileDestination() {
        return FileDestination;
    }
}
