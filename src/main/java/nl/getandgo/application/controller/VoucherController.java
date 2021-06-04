package nl.getandgo.application.controller;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewVoucherDTO;
import nl.getandgo.application.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VoucherController {
    private final ProductService productService;

    @PreAuthorize("hasAuthority('UPDATE_PRODUCT_INFORMATION')")
    @PostMapping(value = "api/vouchers")
    public String addNewVoucher(@RequestBody NewVoucherDTO newVoucherDTO){
        return productService.addVoucherForProduct(newVoucherDTO);
    }

}
