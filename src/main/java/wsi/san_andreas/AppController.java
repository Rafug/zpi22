package wsi.san_andreas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import wsi.model.Temperatura;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin
@Slf4j
public class AppController {

    @RequestMapping(value = "/status")
    public String showStatus() {
        return "App running OK";
    }


    @RequestMapping(value = "/current_time", method = GET)
    public String currentTime() {
        return (new Date()).toString();
    }

    @RequestMapping(value="/jd", method=GET)
    public String jd(){
        String jd;
        jd="tututu";
        return jd;
    }

    @CrossOrigin
    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public Temperatura getWeaterInRoom(
            @RequestParam(value = "id") String id
    ) {
        RestTemplate template = new RestTemplate();
        Temperatura temperatura = null;
        log.info("Getting weater info for [{}]", id);
        String url = "";
        if (id.equals("2")) url = "http://10.10.26.127/update";
        if (id.equals("1")) url = "http://10.10.27.17/update";
        log.info("url=[{}]", url);  //http://10.10.26.127/update
        temperatura = template.getForObject(url, Temperatura.class);
        return temperatura;
    }

}

