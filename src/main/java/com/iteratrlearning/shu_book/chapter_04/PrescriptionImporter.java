package com.iteratrlearning.shu_book.chapter_04;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static com.iteratrlearning.shu_book.chapter_04.Attributes.*;

public class PrescriptionImporter implements Importer {
    // Definimos los prefijos que buscaremos en el archivo de texto
    private static final String NAME_PREFIX = "Patient: ";
    private static final String DRUG_PREFIX = "Drug: ";
    private static final String QUANTITY_PREFIX = "Quantity: ";
    private static final String DATE_PREFIX = "Date: ";
    private static final String CONDITIONS_PREFIX = "Conditions: ";

    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        // Extraemos los valores usando los prefijos
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLineSuffix(DRUG_PREFIX, DRUG);
        textFile.addLineSuffix(QUANTITY_PREFIX, QUANTITY);
        textFile.addLineSuffix(DATE_PREFIX, DATE);
        textFile.addLineSuffix(CONDITIONS_PREFIX, CONDITIONS);

        final Map<String, String> attributes = textFile.getAttributes();

        // Asignamos el tipo de documento
        attributes.put(TYPE, "PRESCRIPTION");

        return new Document(attributes);
    }
}