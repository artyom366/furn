package office.furniture.test.api;

import office.furniture.test.domain.Document;
import office.furniture.test.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by artyom on 15.26.11.
 */

@RestController
@RequestMapping(value = "/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Document getDocumentById(@PathVariable("id") Long id) {
        return documentService.getDocumentById(id);
    }

    @RequestMapping(value = "put", method = RequestMethod.PUT)
    public Long saveDocument(@RequestBody Document document) {
        return documentService.saveDocument(document);
    }
}
