package office.furniture.test.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by artyom on 15.25.11.
 */

@Entity
@Table(name = "rebate")
public class Rebate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private TYPE type;

    @Column(name = "time_of_year")
    private TIME_OF_YEAR timeOfYear;

    @Column(name = "discount_percentage")
    private Float discountPercentage;
    
    @Column(name = "quantity_threshold")
    private Integer quantityThreshold;

    @DateTimeFormat
    @Column(name = "start_period")
    private Date startPeriod;

    @DateTimeFormat
    @Column(name = "end_period")
    private Date endPeriod;

    public enum TYPE {TIME_OF_YEAR, FIXED, VOLUME}

    public enum TIME_OF_YEAR {WINTER, SPRING, SUMMER, AUTUMN}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public TIME_OF_YEAR getTimeOfYear() {
        return timeOfYear;
    }

    public void setTimeOfYear(TIME_OF_YEAR timeOfYear) {
        this.timeOfYear = timeOfYear;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Integer getQuantityThreshold() {
        return quantityThreshold;
    }

    public void setQuantityThreshold(Integer quantityThreshold) {
        this.quantityThreshold = quantityThreshold;
    }

    public Date getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(Date startPeriod) {
        this.startPeriod = startPeriod;
    }

    public Date getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(Date endPeriod) {
        this.endPeriod = endPeriod;
    }
}




