package chapter_04;

import static chapter_04.Attributes.BODY;
import static chapter_04.Attributes.PATIENT;
import static chapter_04.Attributes.TYPE;

import java.io.File;
import java.io.IOException;
import java.util.Map;

class ReportImporter implements Importer {
    private static final String NAME_PREFIX = "Patient: ";

    @Override
    public Document importFile(final File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLines(2, line -> false, BODY);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "REPORT");
        return new Document(attributes);
    }
}
