package services;

import java.awt.*;
import java.awt.image.BufferedImage;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.DirectoryChooser;
import javafx.embed.swing.SwingFXUtils;
import javafx.stage.Stage;
import models.Studenti;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import repository.QytetiRepository;
import repository.ShkollaRepository;
import repository.StudentiRepository;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileUtil {
    public static String getDirectoryFromUser(Stage primaryStage){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(primaryStage);
        if(selectedDirectory != null){
            return selectedDirectory.getAbsolutePath();
        }
        else {
            return "";
        }
    }
    public static void writeStudentInfoOnPDF(Studenti studenti, String path) throws IOException, SQLException {
        // Marrja e imazhit nga path i caktuar
        BufferedImage bim = ImageIO.read(new File("src/main/resources/images/UP_logo.png"));
        // Krijimi i nje dokumenti PDF
        PDDocument document = new PDDocument();
        // Krijimi i nje faqeje
        PDPage page = new PDPage();
        PDRectangle pageSize = page.getMediaBox();
        document.addPage(page);
        // Fillimi i content-it
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        // Imazhi
        PDImageXObject image = LosslessFactory.createFromImage(document, bim);

        // Vendosja e imazheve dhe e tekstit ne content
        contentStream.drawImage(image, 10, pageSize.getHeight() - image.getHeight() - 10);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 16);
        // Cdo koordinate x paraqet offset te tekstit ndaj rreshtit paraprak
        // E njejta vlene edhe per y
        contentStream.newLineAtOffset(15, pageSize.getHeight() - image.getHeight() - 40);
        contentStream.showText("ID - " + studenti.getStudentId());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Emri - " + studenti.getEmri());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Mbiemri - " + studenti.getMbiemri());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Gjinia - " + studenti.getGjinia());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Ditelindja - " + studenti.getDitelindja().toString());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Email - " + studenti.getEmail());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Qyteti i lindjes - " + QytetiRepository.getQytetiById(studenti.getQytetiLindjesId()).getEmri());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Komuna - " + QytetiRepository.getQytetiById(studenti.getKomunaId()).getEmri());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Shkolla e mesme - " + ShkollaRepository.getShkollaById(studenti.getShkollaId()).getEmriShkolles());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Suksesi ne shkollen e mesme - " + studenti.getSuksesiNeShkollenMesme());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Piket ne testin e matures - " + studenti.getPiketTestitMatures());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Piket ne provimin pranues - " + studenti.getPiketProvimitPranues());
        contentStream.newLineAtOffset(0, -25);
        contentStream.showText("Drejtimi - " + studenti.getDrejtimi());
        contentStream.endText();

        contentStream.close();
        String file_path = path + "/" + studenti.getEmri() + studenti.getMbiemri() + ".pdf";
        document.save(file_path);
        document.close();
    }

    public static void saveBarChartAsPNG(PieChart chart, Stage stage){
        try{
            String directory = FileUtil.getDirectoryFromUser(stage);
            String filename = "/piechart.png";
            WritableImage image = chart.snapshot(null, null);
            File outputFile = new File(directory, filename);
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", outputFile);
        } catch (IOException e) {
            AlertUtil.alertError("File Error", "Image Error", "We're sorry but this action could not be completed!");
        }
    }
}
