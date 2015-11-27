package office.furniture.test.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by artyom on 15.25.11.
 */
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @CreationTimestamp
    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DocumentLine> lines;

    @Column(name = "tax_rate")
    private float taxRate;

    @Column(name = "total_net_amount")
    private float totalNetAmount;

    @Column(name = "total_tax_amount")
    private float totalTaxAmount;

    @Column(name = "total_gross_amount")
    private float totalGrossAmount;

    @Column(name = "total_rebate_amount")
    private float totalRebateAmount;

    @Column(name = "total_document_amount")
    private float totalDocumentAmount;

    @Column(name = "type")
    private TYPE type;

    public enum TYPE {IMPORT, EXPORT}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<DocumentLine> getLines() {
        return lines;
    }

    public void setLines(List<DocumentLine> lines) {
        this.lines = lines;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public float getTotalNetAmount() {
        return totalNetAmount;
    }

    public void setTotalNetAmount(float totalNetAmount) {
        this.totalNetAmount = totalNetAmount;
    }

    public float getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(float totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public float getTotalGrossAmount() {
        return totalGrossAmount;
    }

    public void setTotalGrossAmount(float totalGrossAmount) {
        this.totalGrossAmount = totalGrossAmount;
    }

    public float getTotalRebateAmount() {
        return totalRebateAmount;
    }

    public void setTotalRebateAmount(float totalRebateAmount) {
        this.totalRebateAmount = totalRebateAmount;
    }

    public float getTotalDocumentAmount() {
        return totalDocumentAmount;
    }

    public void setTotalDocumentAmount(float totalDocumentAmount) {
        this.totalDocumentAmount = totalDocumentAmount;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
