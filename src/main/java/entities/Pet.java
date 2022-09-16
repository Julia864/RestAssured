package entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Random;

@Data
@Accessors(chain = true)

public class Pet {

    private int id;
    private String photoUrls;
    private String name;
    private String status;

    public int getId() {
        return id;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
