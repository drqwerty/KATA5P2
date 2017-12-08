package kata5p2.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderDB;

public class Kata5p2 {

    private List<Mail> mailList;
    Histogram<String> histogram;

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        new Kata5p2().execute();
    }

    public void execute() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }

    private void input() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        mailList = MailListReaderDB.read();
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}