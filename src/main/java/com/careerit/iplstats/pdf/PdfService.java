package com.careerit.iplstats.pdf;

import lombok.SneakyThrows;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.springframework.stereotype.Component;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

@Component
public class PdfService {


    @SneakyThrows
    public void generatePdf() {
        File xmlFile = new File("src/main/resources/input.xml");
        File xsltFile = new File("src/main/resources/stylesheet.xsl");
        File pdfFile = new File("src/main/resources/output.pdf");

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        try (OutputStream out = new FileOutputStream(pdfFile)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            Source src = new StreamSource(xmlFile);
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
