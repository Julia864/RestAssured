package entities;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Random;

@Data
@Accessors(chain = true)
public class Store {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

    public int getId() {
        return id;
    }

    public int getPetId() {
        return petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getComplete() {
        return complete;
    }
}
