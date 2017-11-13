package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {

    private List<Mail> mailList;
    Histogram<String> histogram;

    public static void main(String[] args) throws IOException {
        new Kata4().execute();
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