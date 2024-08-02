package javaStack.BFHD.Controller;


import javaStack.BFHD.Model.RequestModel;
import javaStack.BFHD.Model.ResponseModel;
import net.javastack.BFHD.Model.GetResponseModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    @PostMapping
    public ResponseEntity<ResponseModel> handlePost(@RequestBody RequestModel request) {
        List<String> data = request.getData();
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        String highestAlphabet = null;

        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (highestAlphabet == null || item.compareToIgnoreCase(highestAlphabet) > 0) {
                    highestAlphabet = item;
                }
            }
        }

        ResponseModel response = new ResponseModel();
        response.setIs_success(true);
        response.setUser_id("manohar_13072002");  // Replace with dynamic user_id generation logic
        response.setEmail("manohar_chinna@srmap.edu.in");
        response.setRoll_number("AP21110010994");
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighest_alphabet(highestAlphabet != null ? List.of(highestAlphabet) : new ArrayList<>());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GetResponseModel> handleGet() {
        GetResponseModel response = new GetResponseModel();
        response.setOperation_code(1);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}