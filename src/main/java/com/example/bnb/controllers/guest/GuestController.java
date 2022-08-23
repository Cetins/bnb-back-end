package com.example.bnb.controllers.guest;

import com.example.bnb.models.guest.Guest;
import com.example.bnb.repositories.guest.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
public class GuestController {

    @Autowired
    GuestRepository guestRepository;

    @GetMapping("/guests")
    public ResponseEntity getAllGuests() {
        return new ResponseEntity<>(guestRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/guests/{id}")
    public ResponseEntity getGuest(@PathVariable Long id) {
        return new ResponseEntity<>(guestRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/guests")
    public ResponseEntity<Guest> postGuest(@RequestBody Guest guest) {
        guestRepository.save(guest);
        return new ResponseEntity<>(guest, HttpStatus.CREATED);
    }


//    @ApiOperation(value = "add product", response = Iterable.class)
//    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added product") })
//    @PostMapping("/addProduct")
//    public void addProduct(@RequestPart(value = "images")       @ApiParam(value = "images")  MultipartFile[] images,
//                           @RequestPart(value = "productName")  @ApiParam(value = "productName")  String productName,
//                           @RequestPart(value = "description")  @ApiParam(value = "description")  String description,
//                           @RequestPart(value = "realPrice")    @ApiParam(value = "realPrice")    String realPrice,
//                           @RequestPart(value = "category")     @ApiParam(value = "category")     String category,
//                           @RequestPart(value = "creator")      @ApiParam(value = "creator")      String creator,
//                           @RequestPart(value = "tradeReference") @ApiParam(value = "tradeReference") String tradeReference
//    ) throws Exception {
//
//        Product p = createProduct(productName, description, Double.valueOf(realPrice), category, creator, tradeReference);
//        Arrays.asList(images)
//                .stream()
//                .forEach(image -> uploadImages(image, p));
//        traderServices.addProduct(p);
//    }
}
