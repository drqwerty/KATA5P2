package kata5p2.main;

import java.io.IOException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;

public class Kata5p2 {

    private List<Mail> mailList;
    Histogram<String> histogram;

    public static void main(String[] args) throws IOException {
        new Kata5p2().execute();
    }

    public void execute() throws IOException {
        input();
        process();
        output();
    }

    private void input() throws IOException {
        String filname = "emails.txt";
        mailList = MailListReader.read(filname);
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}