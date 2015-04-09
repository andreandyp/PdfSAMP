package pdfsamp;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
public class consultas implements PdfPCellEvent {
    public static byte[] OWNER = "ClavePrivada127".getBytes();
    final BaseColor vimss = WebColors.getRGBColor("#228B22");
    final BaseColor form = WebColors.getRGBColor("#87CEEB");
    Date now = new Date();
    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
    protected int tf;
    Font boldfont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    int i = 1;
    public consultas(int tf) {
        this.tf = tf;
    }
    public void createPdf(String filename) throws DocumentException, IOException {
        Image im = Image.getInstance(new File("").getAbsolutePath()+"\\imss.jpg");
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        writer.setEncryption(null, OWNER, PdfWriter.ALLOW_FILL_IN, PdfWriter.STANDARD_ENCRYPTION_128);
        writer.createXmpMetadata();
        document.open();
        PdfPCell cell;
        PdfPTable table = new PdfPTable(6);
        table.setTotalWidth(550);
        table.setLockedWidth(true);
        table.addCell(im);
        cell = new PdfPCell(new Phrase("Instituto Mexicano Del Seguro Social"
                + "\nDelegacion Michoacan"
                + "\nJefatura de Prestaciones Economicas y Sociales", boldfont));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setColspan(5);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Documento de Eleccion de Regimen (DER)"
                + "\nInvalidez y Vida",boldfont));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setColspan(6);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Estimado Derechohabiente:\n" +
"De acuerdo con sus datos afiliatorios, usted tiene derecho a elegir entre los regímenes pensionarios de Ley 73 (pensión pagada por el IMSS) y\n" +
"Ley 97 (pensión pagada por una\n" +
"En ambos casos, el monto de su pensión se actualizará en el mes de febrero, en la misma proporción que la inflación presentada en el año\n" +
"inmediato anterior.\n" +
"Este documento le presenta las diferentes opciones de pensión a que tiene derecho, de las cuales deberá elegir sólo una. Antes de tomar su\n" +
"decisión se sugiere leer detenidamente y asegurarse de comprender cada una de las alternativas."));
        cell.setColspan(6);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Datos personales del asegurado",boldfont));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBackgroundColor(vimss);
        cell.setColspan(6);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Nombre completo del Afiliado"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(3);
        cell.setCellEvent(new consultas(i));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("No. Folio"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setCellEvent(new consultas(++i));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Nombre del solicitante"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(3);
        cell.setCellEvent(new consultas(++i));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("C.U.R.P."));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(3);
        cell.setCellEvent(new consultas(++i));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Numero de Seguridad Social"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(3);
        cell.setCellEvent(new consultas(++i));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Pension"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(3);
        cell.setCellEvent(new consultas(++i));
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Pensión",boldfont));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBackgroundColor(vimss);
        cell.setColspan(6);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Institucion que paga la pension"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(3);
        cell.setCellEvent(new consultas(++i));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Pension mensual total**"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setCellEvent(new consultas(++i));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Aguinaldo anual"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(3);
        cell.setCellEvent(new consultas(++i));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Importe a retirar de la AFORE*"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(3);
        cell.setCellEvent(new consultas(++i));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("* Las cantidades reportadas pueden variar por tratarse de saldos preliminares incluye las subcuentas de SAR 92 y Vivienda 92. En caso de régimen por\n" +
"Ley 73 incluye además las subcuentas de Retiro y Vivienda 97.\n" +
"** Los cálculos se presentan a la fecha de generación de este documento, habiéndose considerado los incrementos del Índice Nacional de Precios al\n" +
"Consumidor (INPC), en caso de ser procedente.\n" +
"***En caso de elegir Régimen 97, podrá tener un beneficio adicional único de hasta $9000, si eligiera la Aseguradora que fuera la mejor opción."));
        cell.setColspan(6);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Documento solo para uso informativo"));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setBackgroundColor(vimss);
        cell.setColspan(6);
        table.addCell(cell);
        document.add(table);
        document.close();
    }
    @Override
    public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
        PdfWriter writer = canvases[0].getPdfWriter();
        TextField text = new TextField(writer, rectangle,String.format("text_%s", tf));
        text.setAlignment(Element.ALIGN_LEFT);
        try {PdfFormField field = text.getTextField();
            writer.addAnnotation(field);}
        catch(IOException | DocumentException e) {System.out.println(e.getMessage());}
    }
    public void abrirarchivo(String archivo){
    try{
        File objetofile = new File (archivo);
        Desktop.getDesktop().open(objetofile);
    }
    catch (IOException ex){
        System.out.println(ex.getMessage());
        }
    }
}