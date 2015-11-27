package office.furniture.test.service;


import office.furniture.test.domain.Document;
import office.furniture.test.jpa.DocumentRepository;
import office.furniture.test.template.ExportDocument;
import office.furniture.test.template.ImportDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by artyom on 15.27.11.
 */

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ExportDocument exportDocument;

    @Autowired
    private ImportDocument importDocument;

    public Long saveDocument(Document document) {

        switch (document.getType()) {

            case EXPORT: {

                exportDocument.handleDocument(document);
                break;
            }

            case IMPORT: {

                importDocument.handleDocument(document);
                break;
            }

            default: {
                System.out.println("Unsupported document type");
            }
        }

        return documentRepository.save(document).getId();
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findOne(id);
    }

    public Iterable<Document> getAllDocuments(){
        return documentRepository.findAll();
    }
}
