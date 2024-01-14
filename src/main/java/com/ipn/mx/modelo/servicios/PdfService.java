package com.ipn.mx.modelo.servicios;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.mx.modelo.entidades.HistorialClinico;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {
	@Autowired
    private HistorialClinicoService historialClinicoService;

    public byte[] generatePdfReport(Integer id) throws DocumentException {
        // Obtener el evento específico por su ID
        HistorialClinico historial = historialClinicoService.findById(id);

        // Crear un documento PDF con OpenPDF
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        // Agregar contenido al documento para el evento específico
        if (historial != null) {
            document.add(new Paragraph("Detalles del Historial:"));
            document.add(new Paragraph(historial.toString()));
        } else {
            document.add(new Paragraph("Histotial no encontrado"));
        }

        document.close();

        return outputStream.toByteArray();
    }
}
