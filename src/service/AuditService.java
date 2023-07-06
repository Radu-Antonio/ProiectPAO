package service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

public class AuditService {
    FileWriter output;

    public AuditService() throws IOException {
        output = new FileWriter("audit.txt", true);
    }

    public void logMessage(String message) throws IOException {
        output.write(message + LocalTime.now() + '\n');
    }

    public void closeFileHandler() throws IOException {
        output.close();
    }
}
