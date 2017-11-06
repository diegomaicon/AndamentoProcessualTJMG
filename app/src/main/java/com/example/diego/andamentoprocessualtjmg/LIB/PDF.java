package com.example.diego.andamentoprocessualtjmg.LIB;

import android.os.Environment;
import android.support.annotation.NonNull;

import com.example.diego.andamentoprocessualtjmg.MODELO.Processo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by diego on 30/10/17.


*/
public class PDF {

    //Document document;
    //public String nome;
    //public String diretorio;
    //fontes usadas para criação do pdf
    private static Font catFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    private static Font catFont3 = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
    private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private static Font smallFont1 = new Font(Font.FontFamily.HELVETICA, 6, Font.NORMAL);
    private static Font dados = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
    private static BaseColor color = new BaseColor(153, 255, 153);

    /**
     * Função responsável por criar um diretório caso ele não exista
     * @param diretorio
*/
    private void criandoDiretorio(String diretorio) {
        File file1 = new File(Environment.getExternalStorageDirectory(), "/" + diretorio + "/");
        if (!file1.exists()) {
            file1.mkdirs();

        }

    }

    //gerando o pdf
    public PDF(Processo p,String nomePDF) {
        //Criando um diretório caso ele não exista
        nomePDF = getString(nomePDF);
        String diretorio = "AndProTJMG";
        criandoDiretorio(diretorio);
        //alocando espaço do arquivo
        File file = new File(Environment.getExternalStorageDirectory(), "/" + diretorio + "/" + nomePDF + ".pdf");
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(file);
            if (file.exists()) {
                new FileOutputStream(file);
            } else {
                file.createNewFile();
                new FileOutputStream(file);
            }

            Document document = new Document(PageSize.A4);


            PdfWriter.getInstance(document, fileOut);
            document.open();


            //insere dados formatados do pdf
            tabFormatada(document);
            document.newPage();//gera a pagina
            document.close(); //fecha o documento
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    private String getString(String nomePDF) {
       nomePDF = nomePDF.replace(".","");
        StringBuilder s = new StringBuilder(nomePDF);
        s.delete(0, 18);
        nomePDF = s.toString();
        return nomePDF;
    }


    private void tabFormatada(Document document) throws DocumentException {
        PdfPTable table;
        PdfPCell c1;
        table = new PdfPTable(20);//cria um pdfTable com 20 colunas
        table.setWidthPercentage(110);// porcentagem de largura do documento em relação a folha
        /**
         * Cria-se linhas e celulas para tabela formatada.
         * primeiramente cria-se as celulas e adiciona a tabela. as colunas são controladas
         * pela colspan de acordo com o tamanho de colunas criadas anteriormente
        */

        //____________________________________________-
        //Criando célula por celula da tabela
        c1 = new PdfPCell(new Phrase("Matricula XXX", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setColspan(20);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("FICHA CADASTRAL", smallFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setColspan(18);
        c1.setBackgroundColor(color);
        table.addCell(c1);//adiciona na linha

        c1 = new PdfPCell();
        c1.setColspan(2);
        c1.setBackgroundColor(BaseColor.BLACK);
        table.addCell(c1);

// proxima linha
        c1 = new PdfPCell(new Phrase("Cruso:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(17);
        table.addCell(c1);
//nova linha
        c1 = new PdfPCell(new Phrase("Nome:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(10);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("CPF:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(1);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(6);
        table.addCell(c1);

        // ============= proxima linha =================
        c1 = new PdfPCell(new Phrase("Email:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(10);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("CEP:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(1);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(6);
        table.addCell(c1);
//nova linha
        c1 = new PdfPCell(new Phrase("Número:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Endereço:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(4);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(8);
        table.addCell(c1);
//proxima linha
        c1 = new PdfPCell(new Phrase("Edificio:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(7);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Turma:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(7);
        table.addCell(c1);
        // proxima linha
        c1 = new PdfPCell(new Phrase("Mãe:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(7);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Naturalidade:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(4);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(6);
        table.addCell(c1);
//proxima linha
        c1 = new PdfPCell(new Phrase("Bairro:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("UF:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(1);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(2);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Cidade:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(6);
        table.addCell(c1);
//prox linha
        c1 = new PdfPCell(new Phrase("Telefone Fixo:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(7);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Telefone Fixo", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("texto", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(7);
        table.addCell(c1);

        // proxima linha ============================
        c1 = new PdfPCell(new Phrase("Telefone Móvel:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(7);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Telefone Móvel:", catFont3));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(3);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("dados", dados));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setVerticalAlignment(Element.ALIGN_BOTTOM);
        c1.setColspan(7);
        table.addCell(c1);
        document.add(table);
    }

    private static void addLinhaBranco(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }




}
