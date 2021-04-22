package nl.getandgo.application.dto;

import lombok.Getter;
import nl.getandgo.application.model.City;


public class EditStoreDTO extends NewStoreDTO{
   @Getter private Long store_id;
    public EditStoreDTO(Long vendor_id,
                        String store_name,
                        City city,
                        String official_website,
                        String address,
                        String img,
                        String description,Long store_id) {
        super(vendor_id, store_name, city, official_website, address, img, description);
        this.store_id=store_id;
    }
}
