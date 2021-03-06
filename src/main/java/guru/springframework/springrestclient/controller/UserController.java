package guru.springframework.springrestclient.controller;

import guru.springframework.springrestclient.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Controller
public class UserController {

    private final ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/users")
    public String postForm(Model model, ServerWebExchange serverWebExchange) {
        //Non reactive implementation
//        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();
//
//        Integer limit = Integer.valueOf(map.get("limit").get(0));
//
//        log.debug("Received Limit value: {}", limit);
//        //default if null or zero
//        if (limit == null || limit == 0) {
//            log.debug("Setting limit to default of 10");
//            limit = 10;
//        }
//
//        model.addAttribute("users", apiService.getUsers(limit));

        model.addAttribute("users",
                apiService.getUsers(serverWebExchange.getFormData().map(data -> new Integer(data.getFirst("limit"))))
        );

        return "userlist";
    }
}
